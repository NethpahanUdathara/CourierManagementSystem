package couriermanagementsystem.models;

public class Sender extends User {
    private String address;

    public Sender(String id, String name, String phone, String address, String username, String password) {
        super(id, name, phone, username, password);
        this.address = address;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getRole() { return "SENDER"; }
}