package model.tisseo;

public class ArriveBM {
    private String number;

    private String dateTime;
    
    public ArriveBM(String number, String dateTime) {
        this.number = number;
        this.dateTime = dateTime;
    }
    
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
  
    public String getTime() {
        return dateTime;
    }
    public void setTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
}

