package Views;

import Code.JavaEmailSender;
import DBLayer.DBConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public final class RepairUI extends javax.swing.JFrame {

    Color mouseEnterColor = new Color(255, 0, 0);
    Color mouseExitColor = new Color(204, 0, 0);

    int repair_id, cus_id, emp_id;
    String repair_name, status;
    double price, amount_due;
    String date;
    DefaultTableModel model;

    public RepairUI() {
        initComponents();
        setRepairDetailsToTable();
    }

    //to set the repair details into the table
    public void setRepairDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from repair;");

            while (rs.next()) {
                String repid = rs.getString("repair_id");
                String repname = rs.getString("repair_name");
                String cusid = rs.getString("cus_id");
                String empid = rs.getString("emp_id");
                String pr = rs.getString("price");
                String paid = rs.getString("amount_paid");
                String due = rs.getString("amount_due");
                String dt = rs.getString("date");
                String stat = rs.getString("status");

                Object[] obj = {repid, repname, cusid, empid, pr, paid, due, dt, stat};
                model = (DefaultTableModel) tbl_repair.getModel();
                model.addRow(obj);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //add repair to repair table
    public boolean addRepair() {

        boolean added = false;
        repair_id = Integer.parseInt(txt_repairid.getText());
        repair_name = txt_repairname.getText();
        cus_id = Integer.parseInt(txt_cusid.getText());
        price = Double.parseDouble(txt_price.getText());
        status = txt_status.getSelectedItem().toString();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into repair(repair_id,repair_name,cus_id,price,amount_due,date,status) values(?,?,?,?,?,curdate(),?);";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, repair_id);
            pst.setString(2, repair_name);
            pst.setInt(3, cus_id);
            pst.setDouble(4, price);
            pst.setDouble(5, amount_due);
            pst.setString(6, status);

            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                added = true;
            } else {
                added = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return added;
    }

    //update repair details
    public boolean updateRepair() {
        boolean updated = false;
        repair_id = Integer.parseInt(txt_repairid.getText());
        repair_name = txt_repairname.getText();
        cus_id = Integer.parseInt(txt_cusid.getText());
        price = Double.parseDouble(txt_price.getText());
        status = txt_status.getSelectedItem().toString();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "update repair set repair_name = ?,cus_id = ?,price = ?,status = ? where repair_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, repair_name);
            pst.setInt(2, cus_id);
            pst.setDouble(3, price);
            pst.setString(4, status);
            pst.setInt(5, repair_id);

            int rowCount = pst.executeUpdate();

            if (status.equals("Completed")) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select email from customer where cus_id = " + cus_id + "");
                rs.next();
                String email = rs.getString("email");

                JavaEmailSender j = new JavaEmailSender();
                j.createAndSendEmail(email, "Repair Completed", "Dear Customer,\n\nYour watch repair has been completed! Please collect your item from the shop.\n\nTime Ticker");
                JOptionPane.showMessageDialog(this, "Customer Informed via Email");
            }
            if (rowCount > 0) {
                updated = true;
            } else {
                updated = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updated;
    }

    //method to delete repair detail
    public boolean deleteRepair() {
        boolean deleted = false;
        repair_id = Integer.parseInt(txt_repairid.getText());

        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from repair where repair_id=?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, repair_id);
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                deleted = true;
            } else {
                deleted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deleted;
    }

    //method to clear table
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_repair.getModel();
        model.setRowCount(0);
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
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_repairid = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_cusid = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_repairname = new app.bolivia.swing.JCTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_status = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txt_price = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_repair = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new rojerusan.RSMaterialButtonCircle();

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

        jLabel13.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Repair ID:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 130, 30));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 50, -1));

        txt_repairid.setBackground(new java.awt.Color(0, 153, 153));
        txt_repairid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_repairid.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_repairid.setPlaceholder("Enter Repair ID..");
        jPanel1.add(txt_repairid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 260, 40));

        jLabel14.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Customer ID:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 130, 30));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 50, -1));

        txt_cusid.setBackground(new java.awt.Color(0, 153, 153));
        txt_cusid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_cusid.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_cusid.setPlaceholder("Enter Customer ID..");
        jPanel1.add(txt_cusid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 260, 40));

        jLabel16.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Repair Cost:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 130, 30));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 50, -1));

        txt_repairname.setBackground(new java.awt.Color(0, 153, 153));
        txt_repairname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_repairname.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_repairname.setPlaceholder("Enter Repair Name..");
        jPanel1.add(txt_repairname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 260, 40));

        jLabel17.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Status:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 70, 30));
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 50, -1));

        txt_status.setBackground(new java.awt.Color(0, 102, 102));
        txt_status.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        txt_status.setForeground(new java.awt.Color(255, 255, 255));
        txt_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "On Going", "Completed" }));
        jPanel1.add(txt_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 210, 40));

        jLabel19.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Repair Name:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 130, 30));

        txt_price.setBackground(new java.awt.Color(0, 153, 153));
        txt_price.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_price.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_price.setPlaceholder("Enter Repair Cost..");
        jPanel1.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 260, 40));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonCircle1.setHideActionText(true);
        rSMaterialButtonCircle1.setLabel("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 690, 130, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonCircle2.setLabel("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 690, 130, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonCircle3.setLabel("UPDATE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 690, 130, 70));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\dollar.png")); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 50, 50));

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\empid.png")); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 50, 50));

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\maintenance.png")); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 50, 50));

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\unit.png")); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 50, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("x");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 80, 40));

        tbl_repair.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RepairID", "RepairName", "CustID", "EmpID", "Cost", "Paid", "Due", "Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_repair.setColorBackgoundHead(new java.awt.Color(204, 0, 0));
        tbl_repair.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_repair.setColorSelBackgound(new java.awt.Color(0, 102, 102));
        tbl_repair.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_repair.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_repair.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_repair.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_repair.setRowHeight(40);
        tbl_repair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_repairMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_repair);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 920, 350));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\repair.png")); // NOI18N
        jLabel3.setText("Manage Repairing Jobs");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 510, 90));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 420, 5));

        rSMaterialButtonCircle4.setText("pay repair");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 700, 380, 80));

        rSMaterialButtonCircle5.setText("Allocate Employee");
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 700, 380, 80));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 950, 830));

        setSize(new java.awt.Dimension(1523, 828));
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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tbl_repairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_repairMouseClicked
        int rowNo = tbl_repair.getSelectedRow();
        TableModel model = tbl_repair.getModel();

        txt_repairid.setText(model.getValueAt(rowNo, 0).toString());
        txt_repairname.setText(model.getValueAt(rowNo, 1).toString());
        txt_cusid.setText(model.getValueAt(rowNo, 2).toString());
        txt_price.setText(model.getValueAt(rowNo, 4).toString());
        txt_status.setSelectedItem(model.getValueAt(rowNo, 8));
    }//GEN-LAST:event_tbl_repairMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if (addRepair() == true) {
            JOptionPane.showMessageDialog(this, "Repair Added Successfully!");
            clearTable();
            setRepairDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Repair Addition Failed!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (updateRepair() == true) {
            JOptionPane.showMessageDialog(this, "Repair Updated Successfully!");
            clearTable();
            setRepairDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Repair Updation Failed!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if (deleteRepair() == true) {
            JOptionPane.showMessageDialog(this, "Repair Deleted Successfully!");
            clearTable();
            setRepairDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Repair Deletion Failed!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        PayRepair ui = new PayRepair();
        ui.setVisible(true);
        clearTable();
        setRepairDetailsToTable();
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        ValidateUser2 ui = new ValidateUser2();
        ui.setVisible(true);
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

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
            java.util.logging.Logger.getLogger(RepairUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RepairUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RepairUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RepairUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RepairUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojeru_san.complementos.RSTableMetro tbl_repair;
    private app.bolivia.swing.JCTextField txt_cusid;
    private app.bolivia.swing.JCTextField txt_price;
    private app.bolivia.swing.JCTextField txt_repairid;
    private app.bolivia.swing.JCTextField txt_repairname;
    private javax.swing.JComboBox<String> txt_status;
    // End of variables declaration//GEN-END:variables
}
