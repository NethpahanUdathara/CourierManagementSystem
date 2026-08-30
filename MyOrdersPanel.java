package couriermanagementsystem.gui;

import couriermanagementsystem.models.*;
import javax.swing.table.DefaultTableModel;

public class MyOrdersPanel extends javax.swing.JPanel {

    private int senderIndex;  // stores which sender is logged in

    public MyOrdersPanel(int senderIndex) {
        this.senderIndex = senderIndex;
        initComponents();
        loadOrders();
    }

    public void loadOrders() {
        String[] columns = {"Order ID", "Receiver", "Description", "Weight", "Value", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        // Only show orders that belong to this sender
        for (int i = 0; i < Data.orderCount; i++) {
            Order order = Data.orders[i];
            if (order != null) {
                // Check if the order's sender matches the logged‑in sender
                if (senderIndex >= 0 && senderIndex < Data.userCount && Data.users[senderIndex] instanceof Sender) {
                    Sender currentSender = (Sender) Data.users[senderIndex];
                    // Compare usernames
                    if (order.getSender() != null && order.getSender().getUsername().equals(currentSender.getUsername())) {
                        model.addRow(new Object[]{
                            order.getOrderId(),
                            order.getReceiverName(),
                            order.getParcelDescription(),
                            order.getWeight(),
                            order.getParcelValue(),
                            order.getStatus()
                        });
                    }
                }
            }
        }
        OrderTable.setModel(model);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();

        OrderTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Order ID", "Status", "Receiver", "Weight (kg)", "Value"}
        ));
        jScrollPane1.setViewportView(OrderTable);
        if (OrderTable.getColumnModel().getColumnCount() > 0) {
            OrderTable.getColumnModel().getColumn(0).setResizable(false);
            OrderTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            OrderTable.getColumnModel().getColumn(1).setResizable(false);
            OrderTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            OrderTable.getColumnModel().getColumn(2).setResizable(false);
            OrderTable.getColumnModel().getColumn(3).setResizable(false);
            OrderTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            OrderTable.getColumnModel().getColumn(4).setResizable(false);
            OrderTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 184, Short.MAX_VALUE))
        );
    }

    private javax.swing.JTable OrderTable;
    private javax.swing.JScrollPane jScrollPane1;
}