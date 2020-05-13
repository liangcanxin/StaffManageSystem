package service;

import dao.DutyDao;
import pojo.Duty;

import java.util.List;

public class DutyService {

    private DutyDao dao = new DutyDao();

    public Duty getDuty(int id){return dao.get(id); }

    public List<Duty> getAllDuties(){return dao.showAllDuties();}

    public String UpdateDuty(Duty duty){
        String message = null;
        boolean flag = false;
        flag = dao.update(duty);
        System.out.println("update");
        if(!flag){
            message = "更新职务信息失败！";
        }
        return message;
    }

}
