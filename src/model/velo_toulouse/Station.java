package model.velo_toulouse;

public class Station {
    private int number;
    private String name;
    private String address;
    private double position_lat;
    private double position_lng;
    private boolean banking;
    private boolean bonus;
    private String status;
    private String contractName;
    private int bikeStands;
    private int availableBikeStand;
    private int availableBike;
    private long lastUpdate;
    
    public Station(int number, String name, String address, double position_lat,
            double position_lng, boolean banking, boolean bonus, String status,
            String contractName, int bikeStands, int availableBikeStand,
            int availableBike, long lastUpdate) {
        this.number = number;
        this.name = name;
        this.address = address;
        this.position_lat = position_lat;
        this.position_lng = position_lng;
        this.banking = banking;
        this.bonus = bonus;
        this.status = status;
        this.contractName = contractName;
        this.bikeStands = bikeStands;
        this.availableBikeStand = availableBikeStand;
        this.availableBike = availableBike;
        this.lastUpdate = lastUpdate;
    }
    
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getPosition_lat() {
        return position_lat;
    }
    public void setPosition_lat(double position_lat) {
        this.position_lat = position_lat;
    }
    public double getPosition_lng() {
        return position_lng;
    }
    public void setPosition_lng(double position_lng) {
        this.position_lng = position_lng;
    }
    public boolean isBanking() {
        return banking;
    }
    public void setBanking(boolean banking) {
        this.banking = banking;
    }
    public boolean isBonus() {
        return bonus;
    }
    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getContractName() {
        return contractName;
    }
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
    public int getBikeStands() {
        return bikeStands;
    }
    public void setBikeStands(int bikeStands) {
        this.bikeStands = bikeStands;
    }
    public int getAvailableBikeStand() {
        return availableBikeStand;
    }
    public void setAvailableBikeStand(int availableBikeStand) {
        this.availableBikeStand = availableBikeStand;
    }
    public int getAvailableBike() {
        return availableBike;
    }
    public void setAvailableBike(int availableBike) {
        this.availableBike = availableBike;
    }
    public long getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
