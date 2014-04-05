package model.tisseo;

public class ArriveBM {
    private String number;
    private String name;
    private String dateTime;
    
    public ArriveBM(String number, String name, String dateTime) {
        this.number = number;
        this.name = name;
        this.dateTime = dateTime;
    }
    
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTime() {
        return dateTime;
    }
    public void setTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
}

