package dao;

import pojo.Staff;
import pojo.Status;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatusDao {

    /**
     * 显示所有员工的基本信息
     *
     * @return 员工对象的信息
     */
    public List<Status> showAllStatuses() {
        List<Status> statuses = new ArrayList<>();
        String sql = "SELECT * FROM employment_status";
        List<Map<String, Object>> list = JDBCUtils.executeSelect(sql);
        System.out.println(list);
        for (Map<String, Object> map : list) {
            Status status = new Status();
            status.setName((String) map.get("staff_name"));
            status.setMonth((Integer) map.get("month"));
            System.out.println(map.get("attend_day") instanceof Long);
            status.setAttendDay((Integer)map.get("attend_day"));
            System.out.println(map.get("subsidy_day") instanceof Long);
            status.setSubsidyDay((Integer) map.get("subsidy_day")) ;
            statuses.add(status);
        }
        return statuses;
    }

    public List<Status> retrieveByMonth(int month) {
        List<Status> statuses = new ArrayList<>();
        String sql = "SELECT * FROM employment_status WHERE month LIKE ?";
        Object[] params = {month};
        return getStatus(statuses, sql, params);
    }

    public List<Status> retrieveByName(String name) {
        List<Status> statuses = new ArrayList<>();
        String sql = "SELECT * FROM employment_status WHERE staff_name LIKE ?";
        Object[] params = {name};
        return getStatus(statuses, sql, params);
    }

    public List<Status> retrieveByDepartment(String department) {
        List<Status> statuses = new ArrayList<>();
        String sql = "SELECT * FROM employment_status, staff_info WHERE staff_info.staff_name = employment_status.staff_name "
                +"and staff_info.staff_department LIKE ?";
        Object[] params = {department};
        return getStatus(statuses, sql, params);
    }

    /**
     * 根据员工姓名查询员工，模糊查询
     *
     * @param name, month 员工姓名的全部或部分
     * @return 员工对象的信息
     */
    public Status retrieveByNameAndMonth(String name, int month) {
        Status status = new Status();
        String sql = "SELECT * FROM employment_status WHERE staff_name LIKE ? and month=?";
        Object[] params = {name, month};
        List<Map<String, Object>> list = JDBCUtils.prepareSelect(sql, params);
        if (list.size() > 0) {
            Map<String, Object> map = list.get(0);
            status = new Status();
            status.setMonth((Integer) map.get("month"));
            status.setName((String) map.get("staff_name"));
            status.setAttendDay((Integer) map.get("attend_day"));
            status.setSubsidyDay((Integer) map.get("subsidy_day"));
        }
        return status;
    }

    /**
     * 根据员工姓名和所在部门查询员工，模糊查询
     *
     * @param name,month,department 员工姓名的全部或部分
     * @return 员工对象的信息
     */
    public List<Status> retrieveByNameMonthAndDepartment(String name, int month, String department) {
        List<Status> statuses = new ArrayList<>();
        String sql = "SELECT * FROM staff_info, employment_status WHERE staff_info.staff_name = employment_status.staff_name "
            +"and employment_status.staff_name LIKE ? "
            +"and employment_status.month LIKE ? "
            +"and staff_info.staff_department LIKE ?";
        Object[] params = {name, month, department};
        return getStatus(statuses, sql, params);
    }

    /**
     * 根据员工姓名和所在部门查询员工，模糊查询
     *
     * @param department 员工姓名的全部或部分
     * @return 员工对象的信息
     */
    public List<Status> retrieveByDepartmentAndMonth(String department, int month) {
        List<Status> statuses = new ArrayList<>();
        String sql = "SELECT * FROM staff_info, employment_status WHERE staff_info.staff_name = employment_status.staff_name "
                + "and staff_info.staff_department like ? "
                + "and employment_status.month like ?";
        Object[] params = {department, month};
        return getStatus(statuses, sql, params);
    }

    public List<Status> retrieveByDepartmentAndName(String department, String name) {
        List<Status> statuses = new ArrayList<>();
        String sql = "SELECT * FROM staff_info, employment_status WHERE staff_info.staff_name = employment_status.staff_name "
                + "and staff_info.staff_department like ? "
                + "and employment_status.staff_name like ?";
        Object[] params = {department, name};
        return getStatus(statuses, sql, params);
    }

    private List<Status> getStatus(List<Status> statuses, String sql, Object[] params) {
        List<Map<String, Object>> list = JDBCUtils.prepareSelect(sql, params);
        System.out.println(list);
        for (Map<String, Object> map : list) {
            Status status = new Status();
            status.setName((String) map.get("staff_name"));
            status.setMonth((Integer) map.get("month"));
            status.setAttendDay((Integer) map.get("attend_day"));
            status.setSubsidyDay((Integer) map.get("subsidy_day"));
            statuses.add(status);
        }
        return statuses;
    }

    /**
     * 将Staff对象插入到表中
     *
     * @param status
     * @return true 成功 | false 失败
     */
    public boolean create(Status status) {
        String sql = "INSERT INTO employment_status(month,staff_name,attend_day,subsidy_day) VALUES(?,?,?,?)";
        Object[] params = {status.getMonth(),status.getName(),status.getAttendDay(),status.getSubsidyDay()};
        int rows = JDBCUtils.prepareUpdate(sql, params);
        return rows == 1;
    }

    /**
     * 根据Staff对象更新记录
     *
     * @param status
     * @return true 成功 | false 失败
     */
    public boolean update(Status status) {
        String sql = "UPDATE employment_status SET " +
                "attend_day=?, "+
                "subsidy_day=? "+
                "WHERE staff_name=? and month=?";
        Object[] params = {status.getAttendDay(),status.getSubsidyDay(),status.getName(),status.getMonth()};
        //System.out.println(status.getAttendDay()+status.getSubsidyDay()+status.getName()+status.getMonth());
        int rows = JDBCUtils.prepareUpdate(sql, params);
        return rows == 1;
    }

    /**
     * 根据主键id删除员工
     *
     * @param name, month
     * @return true 成功 | false 失败
     */
    public boolean delete(String name, int month) {
        String sql = "DELETE FROM employment_status WHERE staff_name=? and month=?";
        Object[] params = {name, month};
        int rows = JDBCUtils.prepareUpdate(sql, params);
        return rows == 1;
    }

}

