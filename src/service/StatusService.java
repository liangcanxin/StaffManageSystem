package service;

import dao.StaffDao;
import dao.StatusDao;
import pojo.Staff;
import pojo.Status;

import java.util.List;

public class StatusService {

    private StatusDao dao = new StatusDao();

    public List<Status> getAllStatuses(){return dao.showAllStatuses();}

    public List<Status> getStatusByName(String name){return dao.retrieveByName(name); }

    public List<Status> getStatusByMonth(int month){return dao.retrieveByMonth(month);}

    public List<Status> getStatusByDepartment(String department){return dao.retrieveByDepartment(department);}

    public Status getStatusByNameAndMonth(String name, int month){
        return dao.retrieveByNameAndMonth(name, month);
    }

    public List<Status> getStatusesByDepartmentAndName(String department, String name)
    { return  dao.retrieveByDepartmentAndName(department, name);}

    public List<Status> getStatusesByNameMonthAndDepartment(String name, int month, String department){
        return dao.retrieveByNameMonthAndDepartment(name, month, department);
    }

    public List<Status> getStatusesByDepartmentAndMonth(String department, int month)
    { return  dao.retrieveByDepartmentAndMonth(department, month);}

    public String UpdateStatus(Status status){
        String message = null;
        boolean flag = false;
        System.out.println(status.getAttendDay()+status.getSubsidyDay()+status.getName()+status.getMonth());
        StatusDao dao = new StatusDao();
        if(dao.retrieveByNameAndMonth(status.getName(),status.getMonth()).getMonth()==0){
            flag = dao.create(status);
            System.out.println("create");
        } else {
            flag = dao.update(status);
            System.out.println("update");
        }
        if(!flag){
            message = "更新工作信息失败！";
        }
        return message;
    }

    public String deleteStatus(String name, int month){
        if(dao.delete(name, month)){
            return null;
        } else {
            return "删除工作信息失败！";
        }
    }
}
