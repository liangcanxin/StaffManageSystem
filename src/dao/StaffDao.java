package dao;

import pojo.Staff;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StaffDao {
    /**
     * 根据主键ID，查询并获得Staff对象
     *
     * @param id 主键
     * @return null表示查询失败
     */
    public Staff get(int id) {
        Staff staff = null;
        String sql = "SELECT * FROM staff_info WHERE staff_id=?";
        Object[] params = {id};
        List<Map<String, Object>> list = JDBCUtils.prepareSelect(sql, params);
        if (list.size() > 0) {
            Map<String, Object> map = list.get(0);
            staff = new Staff();
            staff.setId((Integer) map.get("staff_id"));
            staff.setName((String) map.get("staff_name"));
            staff.setStaffDepartment((String) map.get("staff_department"));
            staff.setStaffDuty((String) map.get("staff_duty"));
        }
        return staff;
    }

    /**
     * 显示所有员工的基本信息
     *
     * @return 员工对象的信息
     */
    public List<Staff> showAllStaffs() {
        List<Staff> staffs = new ArrayList<>();
        String sql = "SELECT * FROM staff_info";
        List<Map<String, Object>> list = JDBCUtils.executeSelect(sql);
        System.out.println(list);
        for (Map<String, Object> map : list) {
            Staff staff = new Staff();
            staff.setId((Integer) map.get("staff_id"));
            staff.setName((String) map.get("staff_name"));
            staff.setStaffDepartment((String) map.get("staff_department"));
            staff.setStaffDuty((String) map.get("staff_duty"));
            staffs.add(staff);
        }
        return staffs;
    }

    /**
     * 根据员工姓名查询员工，模糊查询
     *
     * @param name 员工姓名的全部或部分
     * @return 员工对象的信息
     */
    public List<Staff> retrieveByName(String name) {
        List<Staff> staffs = new ArrayList<>();
        String sql = "SELECT * FROM staff_info WHERE staff_name LIKE ?";
        Object[] params = {name};
        return getStaff(staffs, sql, params);
    }

    /**
     * 根据员工姓名和所在部门查询员工，模糊查询
     *
     * @param name,department 员工姓名的全部或部分
     * @return 员工对象的信息
     */
    public List<Staff> retrieveByNameAndDepartment(String name, String department) {
        List<Staff> staffs = new ArrayList<>();
        String sql = "SELECT * FROM staff_info WHERE staff_name LIKE ? and staff_department LIKE ?";
        Object[] params = {name, department};
        return getStaff(staffs, sql, params);
    }

    /**
     * 根据员工姓名和所在部门查询员工，模糊查询
     *
     * @param department 员工姓名的全部或部分
     * @return 员工对象的信息
     */
    public List<Staff> retrieveByDepartment(String department) {
        List<Staff> staffs = new ArrayList<>();
        String sql = "SELECT * FROM staff_info WHERE staff_department LIKE ?";
        Object[] params = {department};
        return getStaff(staffs, sql, params);
    }

    private List<Staff> getStaff(List<Staff> staffs, String sql, Object[] params) {
        List<Map<String, Object>> list = JDBCUtils.prepareSelect(sql, params);
        //System.out.println(list);
        for (Map<String, Object> map : list) {
            Staff staff = new Staff();
            staff.setId((Integer) map.get("staff_id"));
            staff.setName((String) map.get("staff_name"));
            staff.setStaffDepartment((String) map.get("staff_department"));
            staff.setStaffDuty((String) map.get("staff_duty"));
            staffs.add(staff);
        }
        return staffs;
    }

    /**
     * 将Staff对象插入到表中
     *
     * @param staff
     * @return true 成功 | false 失败
     */
    public boolean create(Staff staff) {
        // 字段id是auto increment，不用插入值
        String sql = "INSERT INTO staff_info(staff_name,staff_department,staff_duty) VALUES(?,?,?)";
        Object[] params = {staff.getName(), staff.getStaffDepartment(), staff.getStaffDuty()};
        int rows = JDBCUtils.prepareUpdate(sql, params);
        return rows == 1;
    }

    /**
     * 根据Staff对象更新记录
     *
     * @param staff
     * @return true 成功 | false 失败
     */
    public boolean update(Staff staff) {
        String sql = "UPDATE staff_info SET " +
                "staff_name=?," +
                "staff_department=?," +
                "staff_duty=?"+
                "WHERE staff_id=?";
        Object[] params = {staff.getName(), staff.getStaffDepartment(), staff.getStaffDuty(), staff.getId()};
        int rows = JDBCUtils.prepareUpdate(sql, params);
        return rows == 1;
    }

    /**
     * 根据主键id删除员工
     *
     * @param id
     * @return true 成功 | false 失败
     */
    public boolean delete(int id) {
        String sql = "DELETE FROM staff_info WHERE staff_id=?";
        Object[] params = {id};
        int rows = JDBCUtils.prepareUpdate(sql, params);
        return rows == 1;
    }

}
