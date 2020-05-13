package servlet;

import pojo.Staff;
import service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/staff", "/staff/create", "/staff/delete", "/staff/update", "/staff/retrieve", "/staff/save", "/staff/info"})
public class StaffServlet extends HttpServlet {

    private StaffService service = new StaffService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String path = req.getServletPath();
        switch (path){
            case "/staff":{
                List<Staff> staffs = service.getAllStaffs();
                req.setAttribute("staffs", staffs);
                req.getRequestDispatcher("/WEB-INF/jsp/staff/info.jsp").forward(req, resp);
                break;
            }
            case "/staff/create":{
                session.removeAttribute("staff");
                Object obj = session.getAttribute("staff");
                if (obj == null){
                    Staff staff = new Staff();
                    session.setAttribute("staff",staff);
                }
                req.getRequestDispatcher("/WEB-INF/jsp/staff/editInfo.jsp").forward(req, resp);
                break;
            }
            case "/staff/retrieve": {
                String queryDepartment = req.getParameter("staffDepartment");
                //System.out.println(queryDepartment);
                String queryName = req.getParameter("name");
                if(queryDepartment.equals("所有部门")){
                    if(queryName.equals("所有员工")){
                        List<Staff> staffs = service.getAllStaffs();
                        req.setAttribute("staffs", staffs);
                    }
                    else if (queryName != null && queryName.trim().length() > 0) {
                        List<Staff> staffs = service.getStaffsByName(queryName);
                        req.setAttribute("staffs", staffs);
                    }
                }else{
                    if(queryName.equals("所有员工")){
                        List<Staff> staffs = service.getStaffsByDepartment(queryDepartment);
                        req.setAttribute("staffs", staffs);
                    }else{
                        List<Staff> staffs = service.getStaffsByNameAndDepartment(queryName,queryDepartment);
                        req.setAttribute("staffs", staffs);
                    }
                }
                req.getRequestDispatcher("/WEB-INF/jsp/staff/info.jsp").forward(req, resp);
                break;
            }
            case "/staff/update":
            case "/staff/delete": {
                String errMessage = null;
                String idStr = req.getParameter("id");
                if (idStr != null && idStr.matches("[0-9]+")) {
                    Staff staff = service.getStaff(Integer.parseInt(idStr));
                    if (staff == null) {
                        errMessage = "没有指定编号的员工！";
                    } else {
                        if ("/staff/update".equals(path)) {
                            session.setAttribute("staff", staff);
                            req.getRequestDispatcher("/WEB-INF/jsp/staff/editInfo.jsp").forward(req, resp);
                        } else {
                            errMessage = service.deleteStaff(staff.getId());
                            if (errMessage == null) {
                                session.setAttribute("message", "员工信息删除成功！");
                            }
                        }
                    }
                } else {
                    errMessage = "员工设定参数格式错误！";
                }
                if (errMessage != null) {
                    session.setAttribute("errMessage", errMessage);
                }
                resp.sendRedirect("/staff/info");
                break;
            }
            case "/staff/save": {
                Staff staff = new Staff();
                staff.setId(Integer.parseInt(req.getParameter("id")));
                staff.setName(req.getParameter("name"));
                staff.setStaffDepartment(req.getParameter("staffDepartment"));
                staff.setStaffDuty(req.getParameter("staffDuty"));
                String errMessage = service.UpdateStaff(staff);
                System.out.println(errMessage);
                if (errMessage == null) {
                    session.setAttribute("message", "员工信息保存成功！");
                } else {
                    session.setAttribute("errMessage", errMessage);
                }
                resp.sendRedirect("/staff/info");
                break;
            }
            case "/staff/info":
                req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
