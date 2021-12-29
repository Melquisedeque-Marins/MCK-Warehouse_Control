package VIEW.mainFrame;

import Atxy2k.CustomTextField.RestrictedTextField;
import CONTROLER.UserControler;
import MODEL.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame {

    public LoginFrame() {
        initComponents();

        RestrictedTextField validarUser = new RestrictedTextField(txtUser);
        validarUser.setOnlyAlphaNumeric(true);
        validarUser.setLimit(20);

        RestrictedTextField validarPass = new RestrictedTextField(txtPassword);
        validarPass.setOnlyAlphaNumeric(true);
        validarPass.setLimit(8);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblCharacteres = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MCK WAREHOUSE CONTROL - LOGIN");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VIEW/utilView/Icones/USER 24.png"))); // NOI18N
        lblUser.setText("  User");
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 80, 30));

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VIEW/utilView/Icones/PASSWORD PRETO 24.png"))); // NOI18N
        lblPassword.setText("  Password");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 110, 30));

        txtUser.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 170, 30));

        txtPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 170, 30));

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 80, 30));

        lblLogo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(0, 0, 153));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VIEW/utilView/Icones/USERS LOGIN 48.png"))); // NOI18N
        lblLogo.setText(" USER LOGIN");
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 260, 60));

        lblCharacteres.setForeground(new java.awt.Color(51, 51, 51));
        lblCharacteres.setText("* 8 characters");
        getContentPane().add(lblCharacteres, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VIEW/utilView/Icones/BACKGROUND LOGIN.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 230));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        LoginUser();

    }//GEN-LAST:event_btnLoginActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCharacteres;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private void LoginUser() {
        String username = txtUser.getText();
        String password = String.valueOf(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(null, "ALL FIELDS MUST BE FILLED IN");

        } else {

            try {
                UserModel usermodel = new UserModel();
                usermodel.setUser(username);
                usermodel.setPassword(password);

                UserControler userCont = new UserControler(usermodel);
                ResultSet rs = userCont.autenticationUser(usermodel);

                if (rs.next()) {
                    String perfil = rs.getString(6);
                    if (perfil.equals("Admin")) {
                        MainFrame mainframe = new MainFrame();
                        mainframe.setVisible(true);
                        MainFrame.MenManeger.setEnabled(true);
                        MainFrame.lblUserName.setText(rs.getString(2));

                        dispose();
                    } else {

                        MainFrame mainframe = new MainFrame();
                        mainframe.setVisible(true);
                        MainFrame.lblUserName.setText(rs.getString(2));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "INVALID USER NAME OU PASSWORD");
                    txtUser.setText(null);
                    txtPassword.setText(null);

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
