package dao;

import pojo.Duty;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DutyDao {
    /**
     * 根据主键ID，查询并获得City对象
     *
     * @param id 主键
     * @return null表示查询失败
     */
    public Duty get(int id) {
        Duty duty= null;
        String sql = "SELECT * FROM duty_info WHERE duty_id=?";
        Object[] params = {id};
        List<Map<String, Object>> list = JDBCUtils.prepareSelect(sql, params);
        if (list.size() > 0) {
            Map<String, Object> map = list.get(0);
            duty = new Duty();
            duty.setId((Integer) map.get("duty_id"));
            duty.setName((String) map.get("duty_name"));
            duty.setBaseSalary((Integer) map.get("base_salary"));
        }
        return duty;
    }

    /**
     * 显示所有员工的基本信息
     *
     * @return 员工对象的信息
     */
    public List<Duty> showAllDuties() {
        List<Duty> duties = new ArrayList<>();
        String sql = "SELECT * FROM duty_info";
        List<Map<String, Object>> list = JDBCUtils.executeSelect(sql);
        System.out.println(list);
        for (Map<String, Object> map : list) {
            Duty duty = new Duty();
            duty.setId((Integer) map.get("duty_id"));
            duty.setName((String) map.get("duty_name"));
            duty.setBaseSalary((Integer) map.get("base_salary"));
            duties.add(duty);
        }
        return duties;
    }

    /**
     * 根据Duty对象更新记录
     *
     * @param duty
     * @return true 成功 | false 失败
     */
    public boolean update(Duty duty) {
        String sql = "UPDATE duty_info SET " +
                "duty_name=?," +
                "base_salary=? " +
                "WHERE duty_id=?";
        Object[] params = {duty.getName(), duty.getBaseSalary(), duty.getId()};
        int rows = JDBCUtils.prepareUpdate(sql, params);
        return rows == 1;
    }

}
