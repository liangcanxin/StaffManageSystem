package pojo;

public class Staff implements java.io.Serializable {

    private int id;
    private String name;
    private String staffDepartment;
    private String staffDuty;

    public Staff(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDuty(String staffDuty) {
        this.staffDuty = staffDuty;
    }

    public String getStaffDuty() {
        return staffDuty;
    }
}
