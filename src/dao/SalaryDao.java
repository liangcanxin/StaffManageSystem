package dao;

import pojo.Salary;
import pojo.Status;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SalaryDao {

    /**
     * 显示所有员工的基本信息
     *
     * @return 员工对象的信息
     */
    public List<Salary> showAllSalaries() {
        List<Salary> salaries = new ArrayList<>();
        String sql = "SELECT * FROM salary_view";
        List<Map<String, Object>> list = JDBCUtils.executeSelect(sql);
        System.out.println(list);
        for (Map<String, Object> map : list) {
            Salary salary = new Salary();
            salary.setMonth((Integer) map.get("month"));
            salary.setId((Integer)map.get("id"));
            salary.setName((String) map.get("name"));
            salary.setDepartment((String)map.get("department"));
            salary.setAttendSubsidy((Integer)map.get("attend_subsidy"));
            salary.setOvertimeSubsidy((Integer) map.get("overtime_subsidy"));
            salary.setBaseSalary((Integer)map.get("base_salary"));
            salary.setTotalSalary((Integer)map.get("total_salary"));
            salaries.add(salary);
        }
        return salaries;
    }

    public List<Salary> retrieveByMonth(int month) {
        List<Salary> salaries = new ArrayList<>();
        String sql = "SELECT * FROM salary_view WHERE month LIKE ?";
        Object[] params = {month};
        return getSalary(salaries, sql, params);
    }

    public List<Salary> retrieveByName(String name) {
        List<Salary> salaries = new ArrayList<>();
        String sql = "SELECT * FROM salary_view WHERE name LIKE ?";
        Object[] params = {name};
        return getSalary(salaries, sql, params);
    }

    public List<Salary> retrieveByDepartment(String department) {
        List<Salary> salaries = new ArrayList<>();
        String sql = "SELECT * FROM salary_view WHERE department LIKE ?";
        Object[] params = {department};
        return getSalary(salaries, sql, params);
    }

    /**
     * 根据员工姓名查询员工，模糊查询
     *
     * @param name, month 员工姓名的全部或部分
     * @return 员工对象的信息
     */
    public Salary retrieveByNameAndMonth(String name, int month) {
        Salary salary = new Salary();
        String sql = "SELECT * FROM salary_view WHERE name LIKE ? and month=?";
        Object[] params = {name, month};
        List<Map<String, Object>> list = JDBCUtils.prepareSelect(sql, params);
        if (list.size() > 0) {
            Map<String, Object> map = list.get(0);
            salary = new Salary();
            salary.setMonth((Integer) map.get("month"));
            salary.setId((Integer)map.get("id"));
            salary.setName((String) map.get("name"));
            salary.setDepartment((String)map.get("department"));
            salary.setAttendSubsidy((Integer)map.get("attend_subsidy"));
            salary.setOvertimeSubsidy((Integer) map.get("overtime_subsidy"));
            salary.setBaseSalary((Integer)map.get("base_salary"));
            salary.setTotalSalary((Integer)map.get("total_salary"));
        }
        return salary;
    }

    /**
     * 根据员工姓名和所在部门查询员工，模糊查询
     *
     * @param name,month,department 员工姓名的全部或部分
     * @return 员工对象的信息
     */
    public List<Salary> retrieveByNameMonthAndDepartment(String name, int month, String department) {
        List<Salary> salaries = new ArrayList<>();
        String sql = "SELECT * FROM salary_view WHERE name LIKE ? and month LIKE ? and department LIKE ?";
        Object[] params = {name, month, department};
        return getSalary(salaries, sql, params);
    }

    /**
     * 根据员工姓名和所在部门查询员工，模糊查询
     *
     * @param department 员工姓名的全部或部分
     * @return 员工对象的信息
     */
    public List<Salary> retrieveByDepartmentAndMonth(String department, int month) {
        List<Salary> salaries = new ArrayList<>();
        String sql = "SELECT * FROM salary_view WHERE department like ? and month like ?";
        Object[] params = {department, month};
        return getSalary(salaries, sql, params);
    }

    public List<Salary> retrieveByDepartmentAndName(String department, String name) {
        List<Salary> salaries = new ArrayList<>();
        String sql = "SELECT * FROM salary_view WHERE department like ? and name like ?";
        Object[] params = {department, name};
        return getSalary(salaries, sql, params);
    }

    private List<Salary> getSalary(List<Salary> salaries, String sql, Object[] params) {
        List<Map<String, Object>> list = JDBCUtils.prepareSelect(sql, params);
        System.out.println(list);
        for (Map<String, Object> map : list) {
            Salary salary = new Salary();
            salary.setMonth((Integer) map.get("month"));
            salary.setId((Integer)map.get("id"));
            salary.setName((String) map.get("name"));
            salary.setDepartment((String)map.get("department"));
            salary.setAttendSubsidy((Integer)map.get("attend_subsidy"));
            salary.setOvertimeSubsidy((Integer) map.get("overtime_subsidy"));
            salary.setBaseSalary((Integer)map.get("base_salary"));
            salary.setTotalSalary((Integer)map.get("total_salary"));
            salaries.add(salary);
        }
        return salaries;
    }

}

