package couriermanagementsystem.gui;

public class SenderDashboard extends javax.swing.JFrame {
    private int senderIndex;

    public SenderDashboard(int senderIndex) {
        initComponents();
        this.senderIndex = senderIndex;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        TitleLabel = new javax.swing.JLabel();
        SideBarPanel = new javax.swing.JPanel();
        DashboardLabel = new javax.swing.JLabel();
        MyOrderButton = new javax.swing.JButton();
        NewOrderButton = new javax.swing.JButton();
        SenderLogOutButton = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        WelcomeLabel = new javax.swing.JLabel();
        TextLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 36));
        TitleLabel.setText("Courier Management System");
        TitleLabel.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 490, -1));

        SideBarPanel.setBackground(new java.awt.Color(0, 0, 102));
        SideBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DashboardLabel.setBackground(new java.awt.Color(255, 255, 255));
        DashboardLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        DashboardLabel.setForeground(new java.awt.Color(255, 255, 255));
        DashboardLabel.setText("Sender Dashboard");
        SideBarPanel.add(DashboardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 160, -1));

        MyOrderButton.setBackground(new java.awt.Color(239, 238, 237));
        MyOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        MyOrderButton.setText("My Orders");
        MyOrderButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MyOrderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MyOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyOrderButtonActionPerformed(evt);
            }
        });
        SideBarPanel.add(MyOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 220, -1));

        NewOrderButton.setBackground(new java.awt.Color(239, 238, 237));
        NewOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        NewOrderButton.setText("New Order");
        NewOrderButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NewOrderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewOrderButtonActionPerformed(evt);
            }
        });
        SideBarPanel.add(NewOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 220, -1));

        SenderLogOutButton.setBackground(new java.awt.Color(204, 0, 0));
        SenderLogOutButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        SenderLogOutButton.setForeground(new java.awt.Color(255, 255, 255));
        SenderLogOutButton.setText("Log Out");
        SenderLogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenderLogOutButtonActionPerformed(evt);
            }
        });
        SideBarPanel.add(SenderLogOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 220, -1));

        getContentPane().add(SideBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 220, 600));

        ContentPanel.setBackground(new java.awt.Color(231, 231, 231));
        ContentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WelcomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 36));
        WelcomeLabel.setText("Welcome Back");
        ContentPanel.add(WelcomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        TextLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        TextLabel.setText("Manage your courier deliveries from one place");
        ContentPanel.add(TextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 530, -1));

        getContentPane().add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 850, 490));

        pack();
        setLocationRelativeTo(null);
    }

    private void NewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ContentPanel.removeAll();
        ContentPanel.setLayout(new java.awt.BorderLayout());
        CreateOrderPanel orderPanel = new CreateOrderPanel(senderIndex);
        ContentPanel.add(orderPanel, java.awt.BorderLayout.CENTER);
        ContentPanel.revalidate();
        ContentPanel.repaint();
    }

    private void MyOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ContentPanel.removeAll();
        ContentPanel.setLayout(new java.awt.BorderLayout());
        MyOrdersPanel ordersPanel = new MyOrdersPanel(senderIndex); 
        ContentPanel.add(ordersPanel, java.awt.BorderLayout.CENTER);
        ContentPanel.revalidate();
        ContentPanel.repaint();
    }

    private void SenderLogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SenderDashboard(0).setVisible(true));
    }

    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel SideBarPanel;
    private javax.swing.JButton MyOrderButton;
    private javax.swing.JButton NewOrderButton;
    private javax.swing.JButton SenderLogOutButton;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel TextLabel;
    private javax.swing.JLabel DashboardLabel;
    private javax.swing.JLabel WelcomeLabel;
}