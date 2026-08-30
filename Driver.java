package couriermanagementsystem.models;

public class Driver extends User {
    private String vehicleId;

    public Driver(String id, String name, String phone, String vehicleId, String username, String password) {
        super(id, name, phone, username, password);
        this.vehicleId = vehicleId;
    }

    public String getVehicleId() { return vehicleId; }
    public String getRole() { return "DRIVER"; }
}