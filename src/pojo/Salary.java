package pojo;

public class Salary implements java.io.Serializable {

    private int month;
    private int id;
    private String name;
    private String department;
    private int attendSubsidy;
    private int overtimeSubsidy;
    private int baseSalary;
    private int totalSalary;

    public Salary(){}

    public void setMonth(int month){ this.month = month; }

    public int getMonth(){ return month; }

    public void setId(int id){ this.id = id; }

    public int getId(){ return id; }

    public void setName(String name){ this.name = name; }

    public String getName(){ return name; }

    public void setDepartment(String department){ this.department = department; }

    public String getDepartment(){ return department; }

    public void setAttendSubsidy(int attendSubsidy){ this.attendSubsidy = attendSubsidy; }

    public int getAttendSubsidy(){ return attendSubsidy; }

    public void setOvertimeSubsidy(int overtimeSubsidy){ this.overtimeSubsidy = overtimeSubsidy; }

    public int getOvertimeSubsidy(){ return overtimeSubsidy; }

    public void setBaseSalary(int baseSalary){ this.baseSalary = baseSalary; }

    public int getBaseSalary(){ return baseSalary; }

    public void setTotalSalary(int totalSalary){ this.totalSalary = totalSalary; }

    public int getTotalSalary(){ return totalSalary; }

}
