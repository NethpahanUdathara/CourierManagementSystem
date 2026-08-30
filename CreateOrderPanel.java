package couriermanagementsystem.gui;
import javax.swing.JOptionPane;
import couriermanagementsystem.models.*;

public class CreateOrderPanel extends javax.swing.JPanel {

    private int senderIndex;
    public CreateOrderPanel(int senderIndex) {
        initComponents();
        this.senderIndex = senderIndex;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        NewOrderLabel = new javax.swing.JLabel();
        RecieverNameLabel = new javax.swing.JLabel();
        RecieverAddressLabel = new javax.swing.JLabel();
        RecieverPhoneLabel = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        Weight = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        ReceiverNameText = new javax.swing.JTextField();
        ReceiverAddressText = new javax.swing.JTextField();
        ReceiverPhoneText = new javax.swing.JTextField();
        ParcelDescriptionText = new javax.swing.JTextField();
        WeightText = new javax.swing.JTextField();
        ParcelValueText = new javax.swing.JTextField();
        CreateOrderButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NewOrderLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        NewOrderLabel.setText("Create New Order");
        add(NewOrderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 220, -1));

        RecieverNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        RecieverNameLabel.setText("Receiver Name: ");
        add(RecieverNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 180, -1));

        RecieverAddressLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        RecieverAddressLabel.setText("Receiver Address: ");
        add(RecieverAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 165, -1));

        RecieverPhoneLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        RecieverPhoneLabel.setText("Receiver Phone: ");
        add(RecieverPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        DescriptionLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        DescriptionLabel.setText("Parcel Description: ");
        add(DescriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        Weight.setFont(new java.awt.Font("Segoe UI", 1, 18));
        Weight.setText("Parcel Weight (kg): ");
        add(Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        Price.setFont(new java.awt.Font("Segoe UI", 1, 18));
        Price.setText("Price: ");
        add(Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, -1));

        add(ReceiverNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 210, -1));
        add(ReceiverAddressText, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 210, -1));
        add(ReceiverPhoneText, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 210, -1));
        add(ParcelDescriptionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 210, -1));
        add(WeightText, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 210, -1));
        add(ParcelValueText, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 210, -1));

        CreateOrderButton.setBackground(new java.awt.Color(0, 0, 102));
        CreateOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        CreateOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        CreateOrderButton.setText("Place Order");
        CreateOrderButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CreateOrderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreateOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateOrderButtonActionPerformed(evt);
            }
        });
        add(CreateOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, -1, -1));
    }

    private void CreateOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String receiverName = ReceiverNameText.getText().trim();
        String receiverPhone = ReceiverPhoneText.getText().trim();
        String receiverAddress = ReceiverAddressText.getText().trim();
        String description = ParcelDescriptionText.getText().trim();

        if (receiverName.isEmpty() || receiverPhone.isEmpty() || receiverAddress.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double weight = 0;
        double value = 0;
        try {
            weight = Double.parseDouble(WeightText.getText().trim());
            value = Double.parseDouble(ParcelValueText.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for Weight and Price.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Sender currentSender = null;
        if (senderIndex >= 0 && senderIndex < Data.userCount && Data.users[senderIndex] instanceof Sender) {
            currentSender = (Sender) Data.users[senderIndex];
        }

        String orderId = "ORD" + (Data.orderCount + 1);
        Order newOrder = new Order(orderId, currentSender, receiverName, receiverPhone,
                                   receiverAddress, description, weight, value);
        Data.addOrder(newOrder);

        JOptionPane.showMessageDialog(this, "Order Created Successfully!\nOrder ID: " + orderId, "Success", JOptionPane.INFORMATION_MESSAGE);

        // Clear fields
        ReceiverNameText.setText("");
        ReceiverPhoneText.setText("");
        ReceiverAddressText.setText("");
        ParcelDescriptionText.setText("");
        WeightText.setText("");
        ParcelValueText.setText("");
    }

    private javax.swing.JButton CreateOrderButton;
    private javax.swing.JTextField ParcelDescriptionText;
    private javax.swing.JTextField ParcelValueText;
    private javax.swing.JTextField ReceiverAddressText;
    private javax.swing.JTextField ReceiverNameText;
    private javax.swing.JTextField ReceiverPhoneText;
    private javax.swing.JTextField WeightText;
    private javax.swing.JLabel NewOrderLabel;
    private javax.swing.JLabel RecieverNameLabel;
    private javax.swing.JLabel RecieverAddressLabel;
    private javax.swing.JLabel RecieverPhoneLabel;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JLabel Weight;
    private javax.swing.JLabel Price;
}