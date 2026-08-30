package couriermanagementsystem.gui;

import couriermanagementsystem.models.*;
import javax.swing.table.DefaultTableModel;

public class ParcelManagementPanel extends javax.swing.JPanel {

    public ParcelManagementPanel() {
        initComponents();
        loadParcels();
    }

    private void loadParcels() {
        DefaultTableModel model = (DefaultTableModel) ParcelManageTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < Data.orderCount; i++) {
            Order order = Data.orders[i];
            if (order != null) {
                model.addRow(new Object[]{
                    order.getOrderId(),
                    order.getSenderUsername(),
                    order.getReceiverName(),
                    order.getWeight(),
                    order.getParcelValue(),
                    order.getStatus()
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        ParcelManageTable = new javax.swing.JTable();

        ParcelManageTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Track ID", "Sender ID", "Receiver", "Weight", "Fee", "Status"
            }
        ));
        jScrollPane1.setViewportView(ParcelManageTable);
        if (ParcelManageTable.getColumnModel().getColumnCount() > 0) {
            ParcelManageTable.getColumnModel().getColumn(0).setResizable(false);
            ParcelManageTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            ParcelManageTable.getColumnModel().getColumn(1).setResizable(false);
            ParcelManageTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            ParcelManageTable.getColumnModel().getColumn(2).setResizable(false);
            ParcelManageTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            ParcelManageTable.getColumnModel().getColumn(3).setResizable(false);
            ParcelManageTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            ParcelManageTable.getColumnModel().getColumn(4).setResizable(false);
            ParcelManageTable.getColumnModel().getColumn(4).setPreferredWidth(50);
            ParcelManageTable.getColumnModel().getColumn(5).setResizable(false);
            ParcelManageTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ParcelManageTable;
}