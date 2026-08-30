package couriermanagementsystem.gui;
import couriermanagementsystem.models.*;

public class TrackOrderPanel extends javax.swing.JPanel {

    public TrackOrderPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        TrackingLabel = new javax.swing.JLabel();
        TrackIdLabel = new javax.swing.JLabel();
        TrackingIDText = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        StatusLabel = new javax.swing.JLabel();
        DriverLabel = new javax.swing.JLabel();
        DestinationLabel = new javax.swing.JLabel();
        SenderLabel = new javax.swing.JLabel();
        ReceiverLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TrackingLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        TrackingLabel.setText("Tracking System");
        add(TrackingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 43, -1, -1));

        TrackIdLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        TrackIdLabel.setText("Tracking ID:");
        add(TrackIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 119, -1, -1));
        add(TrackingIDText, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 118, 295, 32));

        SearchButton.setBackground(new java.awt.Color(0, 0, 102));
        SearchButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        SearchButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        add(SearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 116, -1, -1));

        StatusLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        StatusLabel.setText("Status:");
        add(StatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 186, 191, -1));

        DriverLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        DriverLabel.setText("Driver: ");
        add(DriverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 246, -1, -1));

        DestinationLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        DestinationLabel.setText("Destination:");
        add(DestinationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 300, -1, -1));

        SenderLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        SenderLabel.setText("Sender: ");
        add(SenderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 353, -1, -1));

        ReceiverLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        ReceiverLabel.setText("Receiver: ");
        add(ReceiverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 409, -1, -1));
    }

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String trackingID = TrackingIDText.getText().trim();
        if (trackingID.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter a Tracking ID!");
            return;
        }

        boolean found = false;
        for (int i = 0; i < Data.orderCount; i++) {
            Order order = Data.orders[i];
            if (order != null && order.getOrderId().equalsIgnoreCase(trackingID)) {
                
                SenderLabel.setText("Sender: \t\t" + order.getSenderUsername());
                ReceiverLabel.setText("Receiver: \t" + order.getReceiverName());
                DestinationLabel.setText("Destination: \t" + order.getReceiverAddress());

                String driverInfo = "Not Assigned";
                Driver assignedDriver = order.getAssignedDriver();
                if (assignedDriver != null) {
                    driverInfo = assignedDriver.getId() + " - " + assignedDriver.getName();
                }
                DriverLabel.setText("Driver: \t\t" + driverInfo);
                StatusLabel.setText("Status: \t\t" + order.getStatus());

                found = true;
                break;
            }
        }

        if (!found) {
            javax.swing.JOptionPane.showMessageDialog(this, "Order not found!");
        }
    }

    private javax.swing.JLabel DestinationLabel;
    private javax.swing.JLabel DriverLabel;
    private javax.swing.JLabel ReceiverLabel;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel SenderLabel;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JTextField TrackingIDText;
    private javax.swing.JLabel TrackingLabel;
    private javax.swing.JLabel TrackIdLabel;
}