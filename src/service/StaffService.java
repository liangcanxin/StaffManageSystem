package service;

import dao.StaffDao;
import pojo.Staff;

import java.util.List;

public class StaffService {

    private StaffDao dao = new StaffDao();

    public Staff getStaff(int id){return dao.get(id); }

    public List<Staff> getAllStaffs(){return dao.showAllStaffs();}

    public List<Staff> getStaffsByName(String name){
        return dao.retrieveByName("%" + name + "%");
    }

    public List<Staff> getStaffsByDepartment(String department){
        return dao.retrieveByDepartment("%" + department + "%");
    }

    public List<Staff> getStaffsByNameAndDepartment(String name, String department)
    { return  dao.retrieveByNameAndDepartment("%" + name + "%",department);}

    public String UpdateStaff(Staff staff){
        String message = null;
        boolean flag = false;
        if(staff.getId() == 0){
            flag = dao.create(staff);
            System.out.println("create");
        } else {
            flag = dao.update(staff);
            System.out.println("update");
        }
        if(!flag){
            message = "更新员工信息失败！";
        }
        return message;
    }

    public String deleteStaff(int id){
        if(dao.delete(id)){
            return null;
        } else {
            return "删除员工信息失败！";
        }
    }
}
