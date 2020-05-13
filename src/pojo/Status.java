package pojo;

public class Status implements java.io.Serializable {

    private int month;
    private String name;
    private int attendDay;
    private int subsidyDay;

    public Status(){}

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAttendDay(int attendDay) {
        this.attendDay = attendDay;
    }

    public int getAttendDay() {
        return attendDay;
    }

    public void setSubsidyDay(int subsidyDay) {
        this.subsidyDay = subsidyDay;
    }

    public int getSubsidyDay() {
        return subsidyDay;
    }

}
