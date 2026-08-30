package couriermanagementsystem.gui;
import couriermanagementsystem.models.*;

public class RegisterPanel extends javax.swing.JFrame {

    public RegisterPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        RegisterTitle = new javax.swing.JLabel();
        RegNameLabel = new javax.swing.JLabel();
        RegPhoneLabel = new javax.swing.JLabel();
        RegAddressLabel = new javax.swing.JLabel();
        RegisterButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        RegUsernameLabel = new javax.swing.JLabel();
        RegPasswordLabel = new javax.swing.JLabel();
        RegCPasswordLabel = new javax.swing.JLabel();
        RegNameText = new javax.swing.JTextField();
        RegPhoneText = new javax.swing.JTextField();
        RegAddressText = new javax.swing.JTextField();
        RegUsernameText = new javax.swing.JTextField();
        RegPasswordText = new javax.swing.JPasswordField();
        RegCPasswordText = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RegisterTitle.setFont(new java.awt.Font("Segoe UI", 1, 24));
        RegisterTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegisterTitle.setText("Sender Register");
        getContentPane().add(RegisterTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 180, -1));

        RegNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        RegNameLabel.setText("Name");
        getContentPane().add(RegNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        RegPhoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        RegPhoneLabel.setText("Phone no");
        getContentPane().add(RegPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        RegAddressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        RegAddressLabel.setText("Address");
        getContentPane().add(RegAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        RegisterButton.setBackground(new java.awt.Color(0, 0, 102));
        RegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        RegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        RegisterButton.setText("Register");
        RegisterButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RegisterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });
        getContentPane().add(RegisterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 100, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 412, 10));

        RegUsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        RegUsernameLabel.setText("Username");
        getContentPane().add(RegUsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        RegPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        RegPasswordLabel.setText("Password");
        getContentPane().add(RegPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 20));

        RegCPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        RegCPasswordLabel.setText("Confirm password");
        getContentPane().add(RegCPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 20));

        getContentPane().add(RegNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 110, -1));
        getContentPane().add(RegPhoneText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 110, 20));
        getContentPane().add(RegAddressText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 110, -1));
        getContentPane().add(RegUsernameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 110, -1));
        getContentPane().add(RegPasswordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 110, -1));
        getContentPane().add(RegCPasswordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 110, -1));

        setSize(new java.awt.Dimension(295, 479));
        setLocationRelativeTo(null);
    }

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String name = RegNameText.getText().trim();
        String phone = RegPhoneText.getText().trim();
        String address = RegAddressText.getText().trim();
        String username = RegUsernameText.getText().trim();
        String password = new String(RegPasswordText.getPassword()).trim();
        String confirmPassword = new String(RegCPasswordText.getPassword()).trim();

        if (name.isEmpty() || phone.isEmpty() || address.isEmpty() || username.isEmpty() || password.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please fill in all fields!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Passwords do not match!");
            return;
        }
        
        String senderId = "S" + (Data.userCount + 1);

        Sender newSender = new Sender(senderId, name, phone, address, username, password);
        Data.addUser(newSender);
        javax.swing.JOptionPane.showMessageDialog(this, "Registration Successful!");
        dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new RegisterPanel().setVisible(true));
    }

    private javax.swing.JLabel RegAddressLabel;
    private javax.swing.JTextField RegAddressText;
    private javax.swing.JLabel RegCPasswordLabel;
    private javax.swing.JPasswordField RegCPasswordText;
    private javax.swing.JLabel RegNameLabel;
    private javax.swing.JTextField RegNameText;
    private javax.swing.JLabel RegPasswordLabel;
    private javax.swing.JPasswordField RegPasswordText;
    private javax.swing.JLabel RegPhoneLabel;
    private javax.swing.JTextField RegPhoneText;
    private javax.swing.JLabel RegUsernameLabel;
    private javax.swing.JTextField RegUsernameText;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel RegisterTitle;
    private javax.swing.JSeparator jSeparator1;
}