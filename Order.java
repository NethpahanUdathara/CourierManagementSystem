package couriermanagementsystem.models;

public class Order {
    private String orderId;
    private Sender sender;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String parcelDescription;
    private double weight;
    private double parcelValue;
    private String status;
    private Driver driver;

    public Order(String orderId, Sender sender, String receiverName, String receiverPhone,
                 String receiverAddress, String parcelDescription, double weight, double parcelValue) {
        this.orderId = orderId;
        this.sender = sender;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverAddress = receiverAddress;
        this.parcelDescription = parcelDescription;
        this.weight = weight;
        this.parcelValue = parcelValue;
        this.status = "PENDING";
        this.driver = null;
    }

    public String getOrderId() { return orderId; }
    public Sender getSender() { return sender; }
    public String getReceiverName() { return receiverName; }
    public String getReceiverPhone() { return receiverPhone; }
    public String getReceiverAddress() { return receiverAddress; }
    public String getParcelDescription() { return parcelDescription; }
    public double getWeight() { return weight; }
    public double getParcelValue() { return parcelValue; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Driver getAssignedDriver() { return driver; }
    public void setAssignedDriver(Driver assignedDriver) { this.driver = assignedDriver; }
    public String getSenderUsername() {
        return (sender != null) ? sender.getUsername() : "Unknown";
    }
}