package couriermanagementsystem.models;

public abstract class User {
    private String id;
    private String name;
    private String phone;
    private String username;
    private String password;

    public User(String id, String name, String phone, String username, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public void setPhone(String phone) { this.phone = phone; }
    public abstract String getRole();
}