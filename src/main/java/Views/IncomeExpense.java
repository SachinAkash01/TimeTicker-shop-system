package Views;

import DBLayer.DBConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public final class IncomeExpense extends javax.swing.JFrame {

    Color mouseEnterColor = new Color(255, 0, 0);
    Color mouseExitColor = new Color(204, 0, 0);

    DefaultTableModel model;

    public IncomeExpense() {
        initComponents();
        setIncomeExpenseToTable();
    }

    public void setIncomeExpenseToTable() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 1;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 1;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"January", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 2;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 2;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"February", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 3;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 3;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"March", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 4;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 4;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"April", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 5;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 5;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"May", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 6;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 6;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"June", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 7;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 7;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"July", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 8;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 8;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"August", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 9;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 9;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"September", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 10;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 10;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"October", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 11;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 11;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"November", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select sum(income) as 'income' from income where month(date) = 12;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            String sql1 = "select sum(expenses) as 'expense' from expense where month(date) = 12;";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();

            while (rs.next() && rs1.next()) {
                double income = rs.getDouble("income");
                double expense = rs1.getDouble("expense");
                double profit = income - expense;

                Object[] obj = {"December", income, expense, profit};
                model = (DefaultTableModel) tbl_income_expense.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_income_expense = new rojeru_san.complementos.RSTableMetro();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 0, 80, 40));

        tbl_income_expense.setAutoCreateRowSorter(true);
        tbl_income_expense.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Month", "Income", "Expenses", "Profit or Loss"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_income_expense.setColorBackgoundHead(new java.awt.Color(204, 0, 0));
        tbl_income_expense.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_income_expense.setColorSelBackgound(new java.awt.Color(0, 102, 102));
        tbl_income_expense.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_income_expense.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_income_expense.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_income_expense.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_income_expense.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_income_expense);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 840, 530));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 350, 5));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\blackdollar.png")); // NOI18N
        jLabel3.setText("Income & Expenses");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 510, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 830));

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
            java.util.logging.Logger.getLogger(IncomeExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IncomeExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IncomeExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IncomeExpense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IncomeExpense().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSTableMetro tbl_income_expense;
    // End of variables declaration//GEN-END:variables
}
