package couriermanagementsystem.gui;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import couriermanagementsystem.models.*;

public class DriverDashboard extends javax.swing.JFrame {
    private String driverId;

    public DriverDashboard(String driverId) {
        initComponents();
        this.driverId = driverId;
        loadOrders();
    }

    private void loadOrders() {
        DefaultTableModel model = (DefaultTableModel) DriverOrderTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < Data.orderCount; i++) {
            Order order = Data.orders[i];
            if (order != null && order.getAssignedDriver() != null && driverId.equals(order.getAssignedDriver().getId())) {
                model.addRow(new Object[]{
                    order.getOrderId(),
                    order.getReceiverAddress(),
                    order.getStatus()
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        DriverOrderTable = new javax.swing.JTable();
        CompleteOrderButton = new javax.swing.JButton();
        DriverWelcomeLabel = new javax.swing.JLabel();
        DriverLogoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DriverOrderTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tracking ID", "Destination", "Status"
            }
        ));
        jScrollPane1.setViewportView(DriverOrderTable);
        if (DriverOrderTable.getColumnModel().getColumnCount() > 0) {
            DriverOrderTable.getColumnModel().getColumn(0).setResizable(false);
            DriverOrderTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            DriverOrderTable.getColumnModel().getColumn(1).setResizable(false);
            DriverOrderTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            DriverOrderTable.getColumnModel().getColumn(2).setResizable(false);
            DriverOrderTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 1033, 460));

        CompleteOrderButton.setBackground(new java.awt.Color(0, 0, 102));
        CompleteOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        CompleteOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        CompleteOrderButton.setText("Complete Order");
        CompleteOrderButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CompleteOrderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CompleteOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompleteOrderButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CompleteOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, -1));

        DriverWelcomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        DriverWelcomeLabel.setText("My Assigned Orders");
        getContentPane().add(DriverWelcomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 43));

        DriverLogoutButton.setBackground(new java.awt.Color(204, 0, 0));
        DriverLogoutButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        DriverLogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        DriverLogoutButton.setText("Log Out");
        DriverLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DriverLogoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DriverLogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 105, -1));

        pack();
        setLocationRelativeTo(null);
    }

    private void CompleteOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = DriverOrderTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String orderId = DriverOrderTable.getValueAt(row, 0).toString();
        for (int i = 0; i < Data.orderCount; i++) {
            Order order = Data.orders[i];
            if (order != null && order.getOrderId().equals(orderId)) {
                order.setStatus("DELIVERED");
                break;
            }
        }
        loadOrders();
        JOptionPane.showMessageDialog(this, "Order marked as DELIVERED!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void DriverLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new DriverDashboard("D001").setVisible(true));
    }

    private javax.swing.JButton CompleteOrderButton;
    private javax.swing.JButton DriverLogoutButton;
    private javax.swing.JTable DriverOrderTable;
    private javax.swing.JLabel DriverWelcomeLabel;
    private javax.swing.JScrollPane jScrollPane1;
}