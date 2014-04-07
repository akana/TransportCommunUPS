package model.tisseo;

public class ArriveBM {
    private String number;
    private String dateTime;
    private String destination;
    
    public ArriveBM(String number, String dateTime,String destination) {
        this.number = number;
        this.dateTime = dateTime;
        this.destination = destination;
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
    
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
}

