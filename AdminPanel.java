package couriermanagementsystem.gui;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AdminPanel extends javax.swing.JFrame {
    
    public AdminPanel() {

        javax.swing.UIManager.put(
            "TabbedPane.tabInsets",
            new java.awt.Insets(25, 20, 15, 20)
        );
        javax.swing.UIManager.put(
            "TabbedPane.tabAreaInsets",
            new java.awt.Insets(5, 5, 5, 5)
        );

        initComponents();

        // Customer Management
        CustomerManagementPanel customerPanel = new CustomerManagementPanel();
        CustomerManegementTab.setLayout(new java.awt.BorderLayout());
        CustomerManegementTab.add(customerPanel, java.awt.BorderLayout.CENTER);

        // Parcel Management
        ParcelManagementPanel parcelPanel = new ParcelManagementPanel();
        ParcelManegementTab.setLayout(new java.awt.BorderLayout());
        ParcelManegementTab.add(parcelPanel, java.awt.BorderLayout.CENTER);

        // Order Management 
        OrderManagementPanel orderPanel = new OrderManagementPanel();
        OrderManegementTab.setLayout(new java.awt.BorderLayout());
        OrderManegementTab.add(orderPanel, java.awt.BorderLayout.CENTER);

        // Track Order
        TrackOrderPanel trackPanel = new TrackOrderPanel();
        TrackOrderTab.setLayout(new java.awt.BorderLayout());
        TrackOrderTab.add(trackPanel, java.awt.BorderLayout.CENTER);

        // Driver Management
        DriverManagementPanel driverPanel = new DriverManagementPanel();
        DriverManegementTab.setLayout(new java.awt.BorderLayout());
        DriverManegementTab.add(driverPanel, java.awt.BorderLayout.CENTER);

        AdminSidePanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                if (AdminSidePanel.getSelectedIndex() == 2) {
                    orderPanel.loadDriversToComboBox();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        AdminWelcomeText = new javax.swing.JLabel();
        AdminDashboardText = new javax.swing.JLabel();
        AdminSidePanel = new javax.swing.JTabbedPane();
        CustomerManegementTab = new javax.swing.JPanel();
        ParcelManegementTab = new javax.swing.JPanel();
        OrderManegementTab = new javax.swing.JPanel();
        DriverManegementTab = new javax.swing.JPanel();
        TrackOrderTab = new javax.swing.JPanel();
        AdminLogOutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));
        setPreferredSize(new java.awt.Dimension(1300, 750));
        setResizable(false);
        setSize(new java.awt.Dimension(960, 540));

        AdminWelcomeText.setFont(new java.awt.Font("Segoe UI", 1, 24));
        AdminWelcomeText.setText("Welcome Admin");

        AdminDashboardText.setFont(new java.awt.Font("Segoe UI", 1, 18));
        AdminDashboardText.setText("Dashboard");

        AdminSidePanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        AdminSidePanel.setFont(new java.awt.Font("Segoe UI", 0, 18));

        CustomerManegementTab.setPreferredSize(new java.awt.Dimension(960, 540));
        javax.swing.GroupLayout CustomerManegementTabLayout = new javax.swing.GroupLayout(CustomerManegementTab);
        CustomerManegementTab.setLayout(CustomerManegementTabLayout);
        CustomerManegementTabLayout.setHorizontalGroup(
            CustomerManegementTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 991, Short.MAX_VALUE)
        );
        CustomerManegementTabLayout.setVerticalGroup(
            CustomerManegementTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
        AdminSidePanel.addTab("Customer Management", CustomerManegementTab);

        javax.swing.GroupLayout ParcelManegementTabLayout = new javax.swing.GroupLayout(ParcelManegementTab);
        ParcelManegementTab.setLayout(ParcelManegementTabLayout);
        ParcelManegementTabLayout.setHorizontalGroup(
            ParcelManegementTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 991, Short.MAX_VALUE)
        );
        ParcelManegementTabLayout.setVerticalGroup(
            ParcelManegementTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
        AdminSidePanel.addTab("Parcel Management", ParcelManegementTab);

        javax.swing.GroupLayout OrderManegementTabLayout = new javax.swing.GroupLayout(OrderManegementTab);
        OrderManegementTab.setLayout(OrderManegementTabLayout);
        OrderManegementTabLayout.setHorizontalGroup(
            OrderManegementTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        OrderManegementTabLayout.setVerticalGroup(
            OrderManegementTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
        AdminSidePanel.addTab("Order Management", OrderManegementTab);

        javax.swing.GroupLayout DriverManegementTabLayout = new javax.swing.GroupLayout(DriverManegementTab);
        DriverManegementTab.setLayout(DriverManegementTabLayout);
        DriverManegementTabLayout.setHorizontalGroup(
            DriverManegementTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DriverManegementTabLayout.setVerticalGroup(
            DriverManegementTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
        AdminSidePanel.addTab("Driver Management", DriverManegementTab);

        javax.swing.GroupLayout TrackOrderTabLayout = new javax.swing.GroupLayout(TrackOrderTab);
        TrackOrderTab.setLayout(TrackOrderTabLayout);
        TrackOrderTabLayout.setHorizontalGroup(
            TrackOrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        TrackOrderTabLayout.setVerticalGroup(
            TrackOrderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
        AdminSidePanel.addTab("Track Order", TrackOrderTab);

        AdminLogOutButton.setBackground(new java.awt.Color(255, 102, 102));
        AdminLogOutButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        AdminLogOutButton.setForeground(new java.awt.Color(255, 255, 255));
        AdminLogOutButton.setText("Log Out");
        AdminLogOutButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AdminLogOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AdminLogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminLogOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AdminDashboardText, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdminWelcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 1182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdminSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(AdminLogOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AdminWelcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AdminDashboardText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdminSidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AdminLogOutButton)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void AdminLogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new AdminPanel().setVisible(true));
    }


    private javax.swing.JLabel AdminDashboardText;
    private javax.swing.JButton AdminLogOutButton;
    private javax.swing.JTabbedPane AdminSidePanel;
    private javax.swing.JLabel AdminWelcomeText;
    private javax.swing.JPanel CustomerManegementTab;
    private javax.swing.JPanel DriverManegementTab;
    private javax.swing.JPanel OrderManegementTab;
    private javax.swing.JPanel ParcelManegementTab;
    private javax.swing.JPanel TrackOrderTab;
}