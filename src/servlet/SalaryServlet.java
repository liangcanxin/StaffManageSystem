package servlet;

import pojo.Salary;
import pojo.Status;
import service.SalaryService;
import service.StatusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/salary", "/salary/retrieve"})
public class SalaryServlet extends HttpServlet {

    private SalaryService service = new SalaryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String path = req.getServletPath();
        switch (path){
            case "/salary":{
                List<Salary> salaries = service.getAllSalaries();
                req.setAttribute("salaries", salaries);
                req.getRequestDispatcher("/WEB-INF/jsp/salary/salaryInfo.jsp").forward(req, resp);
                break;
            }
            case "/salary/retrieve": {
                String queryDepartment = req.getParameter("department");
                String queryMonth = req.getParameter("month");
                String queryName = req.getParameter("name");
                if(queryMonth.equals("所有月份")){
                    if(queryDepartment.equals("所有部门")){
                        if(queryName.equals("所有员工")){
                            List<Salary> salaries = service.getAllSalaries();
                            req.setAttribute("salaries", salaries);
                        }else{
                            List<Salary> salaries = service.getSalariesByName(queryName);
                            req.setAttribute("salaries", salaries);
                        }
                    }else{
                        if(queryName.equals("所有员工")){
                            List<Salary> salaries = service.getSalariesByDepartment(queryDepartment);
                            req.setAttribute("salaries", salaries);
                        }else{
                            List<Salary> salaries = service.getSalariesByDepartmentAndName(queryDepartment, queryName);
                            req.setAttribute("salaries", salaries);
                        }
                    }
                }else{
                    if(queryDepartment.equals("所有部门")){
                        if(queryName.equals("所有员工")){
                            List<Salary> salaries = service.getSalariesByMonth(Integer.parseInt(queryMonth));
                            req.setAttribute("salaries", salaries);
                        }else{
                            Salary salary = service.getSalaryByNameAndMonth(queryName,Integer.parseInt(queryMonth));
                            req.setAttribute("salary", salary);
                        }
                    }else{
                        if(queryName.equals("所有员工")){
                            List<Salary> salaries = service.getSalariesByDepartmentAndMonth(queryDepartment,Integer.parseInt(queryMonth));
                            req.setAttribute("salaries", salaries);
                        }else{
                            List<Salary> salaries = service.getSalariesByNameMonthAndDepartment(queryName,Integer.parseInt(queryMonth),queryDepartment);
                            req.setAttribute("salaries", salaries);
                        }
                    }
                }
                req.getRequestDispatcher("/WEB-INF/jsp/salary/salaryInfo.jsp").forward(req, resp);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

