package couriermanagementsystem.gui;

import couriermanagementsystem.models.*;
import javax.swing.table.DefaultTableModel;

public class OrderManagementPanel extends javax.swing.JPanel {
    private int selectedOrder = -1;

    public OrderManagementPanel() {
        initComponents();
        loadDriversToComboBox();
        loadOrders();
    }

    public void loadDriversToComboBox() {
        DriverComboBox.removeAllItems();
        for (int i = 0; i < Data.userCount; i++) {
            if (Data.users[i] instanceof Driver) {
                Driver driver = (Driver) Data.users[i];
                DriverComboBox.addItem(driver.getId() + " - " + driver.getName());
            }
        }
    }

    private void loadOrders() {
        DefaultTableModel model = (DefaultTableModel) OrderManageTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < Data.orderCount; i++) {
            Order order = Data.orders[i];
            if (order != null) {
                String driverText = "Not Assigned";
                if (order.getAssignedDriver() != null) {
                    driverText = order.getAssignedDriver().getId() + " - " + order.getAssignedDriver().getName();
                }
                model.addRow(new Object[]{
                    order.getOrderId(),
                    order.getReceiverAddress(),
                    driverText,
                    order.getStatus()
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderManageTable = new javax.swing.JTable();
        SelectOrderLabel = new javax.swing.JLabel();
        SelectedOrderDisplay = new javax.swing.JLabel();
        AssignDriverLabel = new javax.swing.JLabel();
        DriverComboBox = new javax.swing.JComboBox<>();
        AssignDriverButton = new javax.swing.JButton();

        OrderManageTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tracking ID", "Destination", "Driver", "Status"
            }
        ));
        OrderManageTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(OrderManageTable);
        if (OrderManageTable.getColumnModel().getColumnCount() > 0) {
            OrderManageTable.getColumnModel().getColumn(0).setResizable(false);
            OrderManageTable.getColumnModel().getColumn(0).setPreferredWidth(75);
            OrderManageTable.getColumnModel().getColumn(1).setResizable(false);
            OrderManageTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            OrderManageTable.getColumnModel().getColumn(2).setResizable(false);
            OrderManageTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            OrderManageTable.getColumnModel().getColumn(3).setResizable(false);
            OrderManageTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        }

        SelectOrderLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        SelectOrderLabel.setText("Selected Order :");
        AssignDriverLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        AssignDriverLabel.setText("Assign Driver : ");

        AssignDriverButton.setBackground(new java.awt.Color(0, 0, 102));
        AssignDriverButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        AssignDriverButton.setForeground(new java.awt.Color(255, 255, 255));
        AssignDriverButton.setText("Assign Driver");
        AssignDriverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignDriverButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectOrderLabel)
                    .addComponent(AssignDriverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DriverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AssignDriverButton))
                    .addComponent(SelectedOrderDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(472, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectedOrderDisplay))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AssignDriverLabel)
                    .addComponent(DriverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AssignDriverButton))
                .addContainerGap(207, Short.MAX_VALUE))
        );
    }

    private void AssignDriverButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedOrder == -1 || selectedOrder >= Data.orderCount) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select an order first.");
            return;
        }

        int selectedComboIndex = DriverComboBox.getSelectedIndex();
        if (selectedComboIndex == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a valid driver.");
            return;
        }

        Driver selectedDriver = getSelectedDriverFromCombo(selectedComboIndex);
        Order targetOrder = Data.orders[selectedOrder];

        if (targetOrder != null && selectedDriver != null) {
            targetOrder.setAssignedDriver(selectedDriver);
            targetOrder.setStatus("OUT FOR DELIVERY");
            loadOrders();
            javax.swing.JOptionPane.showMessageDialog(this, "Driver assigned successfully!");
        }
    }

    private Driver getSelectedDriverFromCombo(int comboIndex) {
        int count = 0;
        for (int i = 0; i < Data.userCount; i++) {
            if (Data.users[i] instanceof Driver) {
                if (count == comboIndex) {
                    return (Driver) Data.users[i];
                }
                count++;
            }
        }
        return null;
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int row = OrderManageTable.getSelectedRow();
        if (row >= 0 && row < Data.orderCount) {
            selectedOrder = row;
            Order selected = Data.orders[row];
            if (selected != null) {
                SelectedOrderDisplay.setText(selected.getOrderId());
            }
        }
    }

    private javax.swing.JButton AssignDriverButton;
    private javax.swing.JComboBox<String> DriverComboBox;
    private javax.swing.JLabel SelectedOrderDisplay;
    private javax.swing.JLabel SelectOrderLabel;
    private javax.swing.JLabel AssignDriverLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable OrderManageTable;
}