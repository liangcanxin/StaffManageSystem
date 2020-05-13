package servlet;

import pojo.Duty;
import pojo.Staff;
import service.DutyService;
import service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/duty", "/duty/update", "/duty/save", "/duty/info"})
public class DutyServlet extends HttpServlet {

    private DutyService service = new DutyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String path = req.getServletPath();
        switch (path){
            case "/duty":{

                List<Duty> duties = service.getAllDuties();
                req.setAttribute("duties", duties);
                req.getRequestDispatcher("/WEB-INF/jsp/duty/dutyInfo.jsp").forward(req, resp);
                break;
            }

            case "/duty/update": {
                String errMessage = null;
                String idStr = req.getParameter("id");
                if (idStr != null && idStr.matches("[0-9]+")) {
                    Duty duty = service.getDuty(Integer.parseInt(idStr));
                    session.setAttribute("duty", duty);
                    req.getRequestDispatcher("/WEB-INF/jsp/duty/editInfo.jsp").forward(req, resp);
                } else {
                    errMessage = "职务设置参数格式错误！";
                }
                if (errMessage != null) {
                    session.setAttribute("errMessage", errMessage);
                }
                resp.sendRedirect("/duty/info");
                break;
            }
            case "/duty/save": {
                Duty duty = new Duty();
                duty.setId(Integer.parseInt(req.getParameter("id")));
                duty.setName(req.getParameter("name"));
                duty.setBaseSalary(Integer.parseInt(req.getParameter("baseSalary")));
                String errMessage = service.UpdateDuty(duty);
                System.out.println(errMessage);
                if (errMessage == null) {
                    session.setAttribute("message", "职务更新保存成功！");
                } else {
                    session.setAttribute("errMessage", errMessage);
                }
                resp.sendRedirect("/duty/info");
                break;
            }
            case "/duty/info":
                req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

