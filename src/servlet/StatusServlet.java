package servlet;

import pojo.Staff;
import pojo.Status;
import service.StaffService;
import service.StatusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/status", "/status/create", "/status/delete", "/status/update", "/status/retrieve", "/status/save", "/status/info", "/status/create/save"})
public class StatusServlet extends HttpServlet {

    private StatusService service = new StatusService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String path = req.getServletPath();
        switch (path){
            case "/status":{
                List<Status> statuses = service.getAllStatuses();
                req.setAttribute("statuses", statuses);
                req.getRequestDispatcher("/WEB-INF/jsp/employStatus/statusInfo.jsp").forward(req, resp);
                break;
            }
            case "/status/create":{
                session.removeAttribute("status");
                Object obj = session.getAttribute("status");
                System.out.println(obj);
                if (obj == null){
                    Status status = new Status();
                    session.setAttribute("status",status);
                }
                req.getRequestDispatcher("/WEB-INF/jsp/employStatus/editInfo.jsp").forward(req, resp);
                break;
            }
            case "/status/retrieve": {
                String queryDepartment = req.getParameter("staffDepartment");
                String queryMonth = req.getParameter("month");
                String queryName = req.getParameter("name");
                if(queryMonth.equals("所有月份")){
                    if(queryDepartment.equals("所有部门")){
                        if(queryName.equals("所有员工")){
                            List<Status> statuses = service.getAllStatuses();
                            req.setAttribute("statuses", statuses);
                        }else{
                            List<Status> statuses = service.getStatusByName(queryName);
                            req.setAttribute("statuses", statuses);
                        }
                    }else{
                        if(queryName.equals("所有员工")){
                            List<Status> statuses = service.getStatusByDepartment(queryDepartment);
                            req.setAttribute("statuses", statuses);
                        }else{
                            List<Status> statuses = service.getStatusesByDepartmentAndName(queryDepartment, queryName);
                            req.setAttribute("statuses", statuses);
                        }
                    }
                }else{
                    if(queryDepartment.equals("所有部门")){
                        if(queryName.equals("所有员工")){
                            List<Status> statuses = service.getStatusByMonth(Integer.parseInt(queryMonth));
                            req.setAttribute("statuses", statuses);
                        }else{
                            Status status = service.getStatusByNameAndMonth(queryName,Integer.parseInt(queryMonth));
                            req.setAttribute("status", status);
                        }
                    }else{
                        if(queryName.equals("所有员工")){
                            List<Status> statuses = service.getStatusesByDepartmentAndMonth(queryDepartment,Integer.parseInt(queryMonth));
                            req.setAttribute("statuses", statuses);
                        }else{
                            List<Status> statuses = service.getStatusesByNameMonthAndDepartment(queryName,Integer.parseInt(queryMonth),queryDepartment);
                            req.setAttribute("statuses", statuses);
                        }
                    }
                }
                req.getRequestDispatcher("/WEB-INF/jsp/employStatus/statusInfo.jsp").forward(req, resp);
                break;
            }
            case "/status/update":
            case "/status/delete": {
                String errMessage = null;
                String nameStr = req.getParameter("name");
                String monthStr = req.getParameter("month");
                System.out.println(nameStr+monthStr);
                if (nameStr != null && monthStr != null && monthStr.matches("[0-9]+")) {
                    Status status = service.getStatusByNameAndMonth(nameStr,Integer.parseInt(monthStr));
                    if (status == null) {
                        errMessage = "没有指定编号的员工！";
                    } else {
                        if ("/status/update".equals(path)) {
                            session.setAttribute("status", status);
                            req.getRequestDispatcher("/WEB-INF/jsp/employStatus/editInfo.jsp").forward(req, resp);
                        } else {
                            errMessage = service.deleteStatus(status.getName(),status.getMonth());
                            if (errMessage == null) {
                                session.setAttribute("message", "员工工作信息删除成功！");
                            }
                        }
                    }
                } else {
                    errMessage = "员工工作信息参数格式错误！";
                }
                if (errMessage != null) {
                    session.setAttribute("errMessage", errMessage);
                }
                resp.sendRedirect("/status/info");
                break;
            }
            case "/status/save":
            case "/status/create/save":{
                Status status = new Status();
                status.setMonth(Integer.parseInt(req.getParameter("month")));
                status.setName(req.getParameter("name"));
                status.setAttendDay(Integer.parseInt(req.getParameter("attendDay")));
                status.setSubsidyDay(Integer.parseInt(req.getParameter("subsidyDay")));
                String errMessage = service.UpdateStatus(status);
                System.out.println(errMessage);
                if (errMessage == null) {
                    session.setAttribute("message", "员工工作信息保存成功！");
                } else {
                    session.setAttribute("errMessage", errMessage);
                }
                resp.sendRedirect("/status/info");
                break;
            }
            case "/status/info":
                req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
