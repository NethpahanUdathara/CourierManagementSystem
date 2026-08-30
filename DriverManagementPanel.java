package couriermanagementsystem.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import couriermanagementsystem.models.*;

public class DriverManagementPanel extends javax.swing.JPanel {

    public DriverManagementPanel() {
        initComponents();
        loadDrivers();
    }

    private void loadDrivers() {
        DefaultTableModel model = (DefaultTableModel) DriverTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < Data.userCount; i++) {
            if (Data.users[i] instanceof Driver) {
                Driver driver = (Driver) Data.users[i];
                model.addRow(new Object[]{
                    driver.getId(),
                    driver.getName(),
                    driver.getVehicleId(),
                    driver.getPhone()
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        DriverTable = new javax.swing.JTable();
        DriverNameLabel = new javax.swing.JLabel();
        DriverUsernameLabel = new javax.swing.JLabel();
        DriverPasswordLabel = new javax.swing.JLabel();
        DriverNameText = new javax.swing.JTextField();
        DriverUsernameText = new javax.swing.JTextField();
        AddDriverButton = new javax.swing.JButton();
        DriverPhoneLabel = new javax.swing.JLabel();
        DriverPhoneText = new javax.swing.JTextField();
        DriverPasswordText = new javax.swing.JPasswordField();
        VehicleIdLabel = new javax.swing.JLabel();
        VehicleIdText = new javax.swing.JTextField();

        DriverTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Driver ID", "Name", "Vehicle ID", "Number"
            }
        ));
        jScrollPane1.setViewportView(DriverTable);
        if (DriverTable.getColumnModel().getColumnCount() > 0) {
            DriverTable.getColumnModel().getColumn(0).setResizable(false);
            DriverTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            DriverTable.getColumnModel().getColumn(1).setResizable(false);
            DriverTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            DriverTable.getColumnModel().getColumn(2).setResizable(false);
            DriverTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            DriverTable.getColumnModel().getColumn(3).setResizable(false);
            DriverTable.getColumnModel().getColumn(3).setPreferredWidth(75);
        }

        DriverNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        DriverNameLabel.setText("Driver Name: ");
        DriverUsernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        DriverUsernameLabel.setText("Username: ");
        DriverPasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        DriverPasswordLabel.setText("Password:");
        AddDriverButton.setBackground(new java.awt.Color(0, 0, 102));
        AddDriverButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        AddDriverButton.setForeground(new java.awt.Color(255, 255, 255));
        AddDriverButton.setText("Add Driver");
        AddDriverButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddDriverButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddDriverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDriverButtonActionPerformed(evt);
            }
        });
        DriverPhoneLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        DriverPhoneLabel.setText("Mobile Number: ");
        VehicleIdLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        VehicleIdLabel.setText("Vehicle ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DriverPhoneLabel)
                    .addComponent(DriverNameLabel)
                    .addComponent(DriverUsernameLabel)
                    .addComponent(DriverPasswordLabel)
                    .addComponent(VehicleIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DriverUsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DriverNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DriverPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(AddDriverButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(VehicleIdText, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(DriverPhoneText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DriverNameText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DriverNameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VehicleIdLabel)
                    .addComponent(VehicleIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DriverPhoneLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DriverPhoneText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DriverUsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DriverUsernameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DriverPasswordLabel)
                    .addComponent(DriverPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddDriverButton))
                .addGap(16, 16, 16))
        );
    }

    private void AddDriverButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String name = DriverNameText.getText().trim();
        String phone = DriverPhoneText.getText().trim();
        String username = DriverUsernameText.getText().trim();
        String vehicleid = VehicleIdText.getText().trim();
        String password = new String(DriverPasswordText.getPassword()).trim();

        if (name.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty() || vehicleid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (int i = 0; i < Data.userCount; i++) {
            if (Data.users[i].getUsername().equalsIgnoreCase(username)) {
                JOptionPane.showMessageDialog(this, "Username already exists!", "Duplicate Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        String driverId = "D" + String.format("%02d", Data.userCount + 1);
        Driver newDriver = new Driver(driverId, name, phone, vehicleid, username, password);
        Data.addUser(newDriver);
        loadDrivers();
        JOptionPane.showMessageDialog(this, "Driver created successfully!\n\nDriver ID: " + driverId, "Success", JOptionPane.INFORMATION_MESSAGE);

        DriverNameText.setText("");
        DriverPhoneText.setText("");
        DriverUsernameText.setText("");
        DriverPasswordText.setText("");
        VehicleIdText.setText("");
    }

    private javax.swing.JButton AddDriverButton;
    private javax.swing.JLabel DriverNameLabel;
    private javax.swing.JTextField DriverNameText;
    private javax.swing.JLabel DriverPasswordLabel;
    private javax.swing.JPasswordField DriverPasswordText;
    private javax.swing.JLabel DriverPhoneLabel;
    private javax.swing.JTextField DriverPhoneText;
    private javax.swing.JTable DriverTable;
    private javax.swing.JLabel DriverUsernameLabel;
    private javax.swing.JTextField DriverUsernameText;
    private javax.swing.JLabel VehicleIdLabel;
    private javax.swing.JTextField VehicleIdText;
    private javax.swing.JScrollPane jScrollPane1;
}