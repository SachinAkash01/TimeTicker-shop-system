package Views;

import DBLayer.DBConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ValidateUser extends javax.swing.JFrame {

    Color mouseEnterColor = new Color(255, 0, 0);
    Color mouseExitColor = new Color(204, 0, 0);

    public ValidateUser() {
        initComponents();
    }
    
    public boolean validateAccess() {
        String name = txt_username.getText();
        String pwd = txt_password.getText();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Username!");
            return false;
        }
        if (pwd.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Password!");
            return false;
        }

        return true;
    }

    public boolean access() {
        boolean validation = false;
        String name = txt_username.getText();
        String pwd = txt_password.getText();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from users where name = ? and password = ?");
            pst.setString(1, name);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();

            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery("select post from users where name = '" + name + "'");
            rs1.next();
            String uname = rs1.getString("post");

            if (rs.next()) {

                if (uname.equals("Manager")) {
                    JOptionPane.showMessageDialog(this, "Access Granted!");
                    ManagePartSupplier ui = new ManagePartSupplier();
                    ui.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Access denied!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Access denied!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return validation;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\icons8_Rewind_48px.png")); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 50, -1));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 50, -1));

        rSMaterialButtonCircle1.setLabel("Validate");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 220, 70));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 290, 5));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\addcustomer.png")); // NOI18N
        jLabel3.setText("User Validation");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 390, 90));

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 130, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\icons8_Account_50px.png")); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 50, -1));

        txt_username.setBackground(new java.awt.Color(0, 153, 153));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_username.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_username.setPlaceholder("Enter Username..");
        jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 260, 40));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 130, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\icons8_Secure_50px.png")); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 50, -1));

        txt_password.setBackground(new java.awt.Color(0, 153, 153));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_password.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_password.setPlaceholder("Enter Password..");
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 260, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 440));

        setSize(new java.awt.Dimension(846, 441));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePageUI ui = new HomePageUI();
        ui.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jPanel2.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jPanel2.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel1MouseExited

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        validateAccess();
        access();
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ValidateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValidateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValidateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValidateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValidateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
