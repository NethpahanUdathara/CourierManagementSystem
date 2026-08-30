package couriermanagementsystem.gui;
import couriermanagementsystem.models.*;

public class UserLogin extends javax.swing.JFrame {

    public UserLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        UsernameLabel = new javax.swing.JLabel();
        LoginUserLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        LoginUserText = new javax.swing.JTextField();
        LoginPassText = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        UsernameLabel.setText("Username: ");
        getContentPane().add(UsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 80, -1));

        LoginUserLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        LoginUserLabel.setText("User Login");
        getContentPane().add(LoginUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 120, -1));

        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        PasswordLabel.setText("Password:");
        getContentPane().add(PasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 80, -1));

        LoginButton.setBackground(new java.awt.Color(0, 0, 102));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Sign In");
        LoginButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 80, -1));

        getContentPane().add(LoginUserText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 110, -1));
        getContentPane().add(LoginPassText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 110, -1));

        setSize(new java.awt.Dimension(313, 317));
        setLocationRelativeTo(null);
    }

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = LoginUserText.getText().trim();
        String password = new String(LoginPassText.getPassword()).trim();

        // Admin Check
        if (username.equals("admin") && password.equals("12")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Admin login successful!");
            AdminPanel adminPanel = new AdminPanel();
            adminPanel.setVisible(true);
            this.dispose();
            return;
        }

        // User Check
        for (int i = 0; i < Data.userCount; i++) {
            User user = Data.users[i];
            if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                if (user instanceof Sender) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Login successful!");
                    SenderDashboard dashboard = new SenderDashboard(i);
                    dashboard.setVisible(true);
                    this.dispose();
                    return;
                }
                if (user instanceof Driver) {
                    Driver driver = (Driver) user;
                    javax.swing.JOptionPane.showMessageDialog(this, "Driver login successful!");
                    DriverDashboard dashboard = new DriverDashboard(driver.getId());
                    dashboard.setVisible(true);
                    this.dispose();
                    return;
                }
            }
        }

        javax.swing.JOptionPane.showMessageDialog(this, "Invalid username or password!");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new UserLogin().setVisible(true));
    }

    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField LoginPassText;
    private javax.swing.JTextField LoginUserText;
    private javax.swing.JLabel LoginUserLabel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JLabel PasswordLabel;
}