package service;

import dao.SalaryDao;
import dao.StaffDao;
import dao.StatusDao;
import pojo.Salary;
import pojo.Staff;
import pojo.Status;

import java.util.List;

public class SalaryService {

    private SalaryDao dao = new SalaryDao();

    public List<Salary> getAllSalaries(){return dao.showAllSalaries();}

    public List<Salary> getSalariesByName(String name){return dao.retrieveByName(name); }

    public List<Salary> getSalariesByMonth(int month){return dao.retrieveByMonth(month);}

    public List<Salary> getSalariesByDepartment(String department){return dao.retrieveByDepartment(department);}

    public Salary getSalaryByNameAndMonth(String name, int month){
        return dao.retrieveByNameAndMonth(name, month);
    }

    public List<Salary> getSalariesByDepartmentAndName(String department, String name)
    { return  dao.retrieveByDepartmentAndName(department, name);}

    public List<Salary> getSalariesByNameMonthAndDepartment(String name, int month, String department){
        return dao.retrieveByNameMonthAndDepartment(name, month, department);
    }

    public List<Salary> getSalariesByDepartmentAndMonth(String department, int month)
    { return  dao.retrieveByDepartmentAndMonth(department, month);}

}
