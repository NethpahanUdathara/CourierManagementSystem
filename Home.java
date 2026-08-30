package couriermanagementsystem.gui;

import couriermanagementsystem.models.*;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        LoginTrackIdText.setText("Enter Track ID Here");
        LoginTrackIdText.setForeground(java.awt.Color.GRAY);
        LoginTrackIdText.setCaretPosition(0);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        LoginTitleLabel = new javax.swing.JLabel();
        LoginTrackIdLabel = new javax.swing.JLabel();
        LoginTrackIdText = new javax.swing.JTextField();
        LoginTrackButton = new javax.swing.JButton();
        Seperator = new javax.swing.JSeparator();
        LoginButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        RegisterTextLabel = new javax.swing.JLabel();
        LoginTextLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 36));
        LoginTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginTitleLabel.setText("Courier Manegement System");
        getContentPane().add(LoginTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 500, 55));

        LoginTrackIdLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        LoginTrackIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginTrackIdLabel.setText("Track Order :");
        getContentPane().add(LoginTrackIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 177, 30));

        LoginTrackIdText.setFont(new java.awt.Font("Segoe UI", 0, 18));
        LoginTrackIdText.setForeground(new java.awt.Color(204, 204, 204));
        LoginTrackIdText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        LoginTrackIdText.setText("Enter Track ID Here");
        LoginTrackIdText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LoginTrackIdText.setCaretPosition(0);
        LoginTrackIdText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        LoginTrackIdText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginTrackIdTextKeyPressed(evt);
            }
        });
        getContentPane().add(LoginTrackIdText, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 200, 30));

        LoginTrackButton.setBackground(new java.awt.Color(0, 0, 102));
        LoginTrackButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        LoginTrackButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginTrackButton.setText("Track");
        LoginTrackButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LoginTrackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginTrackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginTrackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginTrackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 120, 30));

        Seperator.setForeground(new java.awt.Color(153, 153, 153));
        getContentPane().add(Seperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 346, 788, 10));

        LoginButton.setBackground(new java.awt.Color(0, 0, 102));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Log In");
        LoginButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 100, 40));

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
        getContentPane().add(RegisterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 100, 40));

        RegisterTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        RegisterTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegisterTextLabel.setText("Don't have an account ?");
        getContentPane().add(RegisterTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, -1, 36));

        LoginTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        LoginTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginTextLabel.setText("Already have an account ?");
        getContentPane().add(LoginTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, 36));

        setSize(new java.awt.Dimension(814, 574));
        setLocationRelativeTo(null);
    }

    private void LoginTrackIdTextKeyPressed(java.awt.event.KeyEvent evt) {
        if (LoginTrackIdText.getText().equals("Enter Track ID Here")) {
            LoginTrackIdText.setText("");
            LoginTrackIdText.setForeground(java.awt.Color.BLACK);
        }
    }

    private void LoginTrackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String trackId = LoginTrackIdText.getText().trim();
        if (trackId.isEmpty() || trackId.equals("Enter Track ID Here")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter a Tracking ID");
            return;
        }

        Order foundOrder = null;
        for (int i = 0; i < Data.orderCount; i++) {
            if (Data.orders[i] != null && Data.orders[i].getOrderId().equalsIgnoreCase(trackId)) {
                foundOrder = Data.orders[i];
                break;
            }
        }

        if (foundOrder != null) {
            // Show tracking info 
            javax.swing.JOptionPane.showMessageDialog(this,
                "Tracking ID: " + foundOrder.getOrderId() +
                "\nDestination: " + foundOrder.getReceiverAddress() +
                "\nStatus: " + foundOrder.getStatus() +
                "\nParcel Value: " + foundOrder.getParcelValue()
            );
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid Tracking ID!");
        }
    }

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        RegisterPanel registerpanel = new RegisterPanel();
        registerpanel.setVisible(true);
    }

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        UserLogin userLogin = new UserLogin();
        userLogin.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Home().setVisible(true));
    }

    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel LoginTextLabel;
    private javax.swing.JLabel LoginTitleLabel;
    private javax.swing.JButton LoginTrackButton;
    private javax.swing.JLabel LoginTrackIdLabel;
    private javax.swing.JTextField LoginTrackIdText;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel RegisterTextLabel;
    private javax.swing.JSeparator Seperator;
}