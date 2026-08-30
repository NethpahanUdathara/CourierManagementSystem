package couriermanagementsystem.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import couriermanagementsystem.models.*;

public class CustomerManagementPanel extends javax.swing.JPanel {

    public CustomerManagementPanel() {
        initComponents();
        loadCustomers();
    }

    private void loadCustomers() {
        DefaultTableModel model = (DefaultTableModel) CustomerTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < Data.userCount; i++) {
            if (Data.users[i] instanceof Sender) {
                Sender sender = (Sender) Data.users[i];
                model.addRow(new Object[]{
                    sender.getId(),
                    sender.getName(),
                    sender.getAddress(),
                    sender.getPhone()
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();
        CustomerDeleteButton = new javax.swing.JButton();
        CustomerEditButton = new javax.swing.JButton();

        CustomerTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sender ID", "Name", "Address", "Phone"
            }
        ));
        jScrollPane1.setViewportView(CustomerTable);
        if (CustomerTable.getColumnModel().getColumnCount() > 0) {
            CustomerTable.getColumnModel().getColumn(0).setResizable(false);
            CustomerTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            CustomerTable.getColumnModel().getColumn(1).setResizable(false);
            CustomerTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            CustomerTable.getColumnModel().getColumn(2).setResizable(false);
            CustomerTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            CustomerTable.getColumnModel().getColumn(3).setResizable(false);
            CustomerTable.getColumnModel().getColumn(3).setPreferredWidth(75);
        }

        CustomerDeleteButton.setBackground(new java.awt.Color(204, 0, 0));
        CustomerDeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        CustomerDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        CustomerDeleteButton.setText("Delete Customer");
        CustomerDeleteButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CustomerDeleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CustomerDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerDeleteButtonActionPerformed(evt);
            }
        });

        CustomerEditButton.setBackground(new java.awt.Color(0, 51, 153));
        CustomerEditButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        CustomerEditButton.setForeground(new java.awt.Color(255, 255, 255));
        CustomerEditButton.setText("Edit Customer");
        CustomerEditButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CustomerEditButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CustomerEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerEditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1133, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(CustomerDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CustomerEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CustomerDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(CustomerEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }

    private void CustomerDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = CustomerTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a customer from the table to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String selectedSenderId = CustomerTable.getValueAt(selectedRow, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this customer?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int targetIndex = -1;
            for (int i = 0; i < Data.userCount; i++) {
                if (Data.users[i].getId().equals(selectedSenderId)) {
                    targetIndex = i;
                    break;
                }
            }
            if (targetIndex != -1) {
                for (int i = targetIndex; i < Data.userCount - 1; i++) {
                    Data.users[i] = Data.users[i + 1];
                }
                Data.users[Data.userCount - 1] = null;
                Data.userCount--;
                loadCustomers();
                JOptionPane.showMessageDialog(this, "Customer deleted successfully.");
            }
        }
    }

    private void CustomerEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = CustomerTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a customer from the table to edit.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String selectedSenderId = CustomerTable.getValueAt(selectedRow, 0).toString();
        Sender targetSender = null;
        for (int i = 0; i < Data.userCount; i++) {
            if (Data.users[i].getId().equals(selectedSenderId) && Data.users[i] instanceof Sender) {
                targetSender = (Sender) Data.users[i];
                break;
            }
        }
        if (targetSender == null) return;

        String newAddress = JOptionPane.showInputDialog(this, "Edit Address:", targetSender.getAddress());
        if (newAddress == null || newAddress.trim().isEmpty()) return;

        String newPhone = JOptionPane.showInputDialog(this, "Edit Phone Number:", targetSender.getPhone());
        if (newPhone == null || newPhone.trim().isEmpty()) return;

        targetSender.setAddress(newAddress.trim());
        targetSender.setPhone(newPhone.trim());
        loadCustomers();
        JOptionPane.showMessageDialog(this, "Customer details updated successfully.");
    }

    private javax.swing.JButton CustomerDeleteButton;
    private javax.swing.JButton CustomerEditButton;
    private javax.swing.JTable CustomerTable;
    private javax.swing.JScrollPane jScrollPane1;
}