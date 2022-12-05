package Views;

import DBLayer.DBConnection;
import Code.JavaEmailSender;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public final class ManageSpareParts extends javax.swing.JFrame {

    Color mouseEnterColor = new Color(255, 0, 0);
    Color mouseExitColor = new Color(204, 0, 0);

    int sp_id, sup_id, quantity;
    String sp_name, condition;
    double unitprice;
    String date;
    DefaultTableModel model;

    String from, to, host, sub, content;

    public ManageSpareParts() {
        initComponents();
        setSparePartDetailsToTable();
    }

    //to set the spare part details into the table
    public void setSparePartDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection(); //To connect the database
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from spare_parts;");

            while (rs.next()) {
                String spid = rs.getString("sp_id");
                String spname = rs.getString("sp_name");
                String supid = rs.getString("supplier_id");
                String uprice = rs.getString("unit_price");
                String quantity1 = rs.getString("quantity");
                String cond = rs.getString("sp_condition");
                String dt = rs.getString("date");

                Object[] obj = {spid, spname, supid, uprice, quantity1, cond, dt};
                model = (DefaultTableModel) tbl_spare.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ADD spare part to spare parts table
    public boolean addSparePart() {

        boolean added = false;
        
        //fetch the values from the fields
        sp_id = Integer.parseInt(txt_spid.getText());
        sp_name = txt_spname.getText();
        sup_id = Integer.parseInt(txt_supid.getText());
        unitprice = Double.parseDouble(txt_unitprice.getText());
        quantity = (int) txt_quantity.getModel().getValue();
        condition = txt_condition.getSelectedItem().toString();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into spare_parts(sp_id,sp_name,supplier_id,unit_price,quantity,sp_condition,date) values(?,?,?,?,?,?,curdate());";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, sp_id);
            pst.setString(2, sp_name);
            pst.setInt(3, sup_id);
            pst.setDouble(4, unitprice);
            pst.setInt(5, quantity);
            pst.setString(6, condition);

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

    //UPDATE spare part details
    public boolean updateSparePart() {
        boolean updated = false;
        sp_id = Integer.parseInt(txt_spid.getText());
        sp_name = txt_spname.getText();
        sup_id = Integer.parseInt(txt_supid.getText());
        unitprice = Double.parseDouble(txt_unitprice.getText());
        quantity = (int) txt_quantity.getModel().getValue();
        condition = txt_condition.getSelectedItem().toString();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "update spare_parts set sp_name = ?,supplier_id = ?,unit_price = ?,quantity = ?, sp_condition = ? where sp_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, sp_name);
            pst.setInt(2, sup_id);
            pst.setDouble(3, unitprice);
            pst.setInt(4, quantity);
            pst.setString(5, condition);
            pst.setInt(6, sp_id);

            int rowCount = pst.executeUpdate();
            
            try {
                if (quantity == 0) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select email from supplier where supplier_id = "+sup_id+"");
                    rs.next();
                    String email = rs.getString("email");
                    
                    JavaEmailSender j = new JavaEmailSender();
                    j.createAndSendEmail(email, "OUT OF STOCK", "This is to inform you that we've experienced an unusually high number of orders and have run out of inventory!\n\nTime Ticker");
                    JOptionPane.showMessageDialog(this, "Supplier Informed via Email");
                }
            } catch (Exception e) {
                e.printStackTrace();
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

    //DELETE spare parts from the table
    public boolean deleteSparePart() {
        boolean deleted = false;
        sp_id = Integer.parseInt(txt_spid.getText());

        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from spare_parts where sp_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, sp_id);
            
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
        DefaultTableModel model = (DefaultTableModel) tbl_spare.getModel();
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
        txt_spid = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_supid = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_spname = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_unitprice = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jLabel28 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_repairid1 = new app.bolivia.swing.JCTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_cusid1 = new app.bolivia.swing.JCTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_repairname1 = new app.bolivia.swing.JCTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_price1 = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle6 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle7 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle8 = new rojerusan.RSMaterialButtonCircle();
        jLabel17 = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JSpinner();
        txt_condition = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_spare = new rojeru_san.complementos.RSTableMetro();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

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
        jLabel13.setText("Spare Part ID:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 130, 30));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 50, -1));

        txt_spid.setBackground(new java.awt.Color(0, 153, 153));
        txt_spid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_spid.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_spid.setPlaceholder("Enter Spare Part ID..");
        jPanel1.add(txt_spid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 260, 40));

        jLabel14.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Supplier ID:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 130, 30));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 50, -1));

        txt_supid.setBackground(new java.awt.Color(0, 153, 153));
        txt_supid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_supid.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_supid.setPlaceholder("Enter Supplier ID..");
        jPanel1.add(txt_supid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 260, 40));

        jLabel16.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Unit Price:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 130, 30));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 50, -1));

        txt_spname.setBackground(new java.awt.Color(0, 153, 153));
        txt_spname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_spname.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_spname.setPlaceholder("Enter Spare Part Name..");
        jPanel1.add(txt_spname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 260, 40));
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 50, -1));

        jLabel19.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Spare Part Name:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 160, 30));

        txt_unitprice.setBackground(new java.awt.Color(0, 153, 153));
        txt_unitprice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_unitprice.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_unitprice.setPlaceholder("Enter Unit Price..");
        jPanel1.add(txt_unitprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 260, 40));

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

        jLabel28.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\maintenance.png")); // NOI18N
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 50, 50));

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(204, 0, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Back");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jLabel15.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Spare Part ID:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 130, 30));
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 50, -1));

        txt_repairid1.setBackground(new java.awt.Color(0, 153, 153));
        txt_repairid1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_repairid1.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_repairid1.setPlaceholder("Enter Spare Part ID..");
        jPanel6.add(txt_repairid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 260, 40));

        jLabel20.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Supplier ID:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 130, 30));
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 50, -1));

        txt_cusid1.setBackground(new java.awt.Color(0, 153, 153));
        txt_cusid1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_cusid1.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_cusid1.setPlaceholder("Enter Supplier ID..");
        jPanel6.add(txt_cusid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 260, 40));

        jLabel22.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Unit Price:");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 130, 30));
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 50, -1));

        txt_repairname1.setBackground(new java.awt.Color(0, 153, 153));
        txt_repairname1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_repairname1.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_repairname1.setPlaceholder("Enter Spare Part Name..");
        jPanel6.add(txt_repairname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 260, 40));

        jLabel24.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Condition:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 110, 30));
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 50, -1));

        jLabel26.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Spare Part Name:");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 160, 30));

        txt_price1.setBackground(new java.awt.Color(0, 153, 153));
        txt_price1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_price1.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        txt_price1.setPlaceholder("Enter Unit Price..");
        jPanel6.add(txt_price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 260, 40));

        rSMaterialButtonCircle6.setBackground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonCircle6.setHideActionText(true);
        rSMaterialButtonCircle6.setLabel("DELETE");
        rSMaterialButtonCircle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle6ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 690, 130, 70));

        rSMaterialButtonCircle7.setBackground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonCircle7.setLabel("ADD");
        rSMaterialButtonCircle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle7ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 690, 130, 70));

        rSMaterialButtonCircle8.setBackground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonCircle8.setLabel("UPDATE");
        rSMaterialButtonCircle8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle8ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 690, 130, 70));

        jLabel17.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Quantity:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 110, 30));

        txt_quantity.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        jPanel6.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, 120, 40));

        txt_condition.setBackground(new java.awt.Color(0, 102, 102));
        txt_condition.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        txt_condition.setForeground(new java.awt.Color(255, 255, 255));
        txt_condition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brand New", "Used" }));
        jPanel6.add(txt_condition, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 590, 130, 40));

        jLabel27.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\unit.png")); // NOI18N
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 40, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\dollar.png")); // NOI18N
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 50, 50));

        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\empid.png")); // NOI18N
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 50, 50));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

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

        tbl_spare.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SparePartID", "SPName", "SupplierID", "UnitPrice", "Quantity", "Condition", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_spare.setColorBackgoundHead(new java.awt.Color(204, 0, 0));
        tbl_spare.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_spare.setColorSelBackgound(new java.awt.Color(0, 102, 102));
        tbl_spare.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_spare.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_spare.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_spare.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_spare.setRowHeight(40);
        tbl_spare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_spareMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_spare);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 920, 350));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 360, 5));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Akash\\OneDrive\\Desktop\\TimeTicker\\TimeTicker\\src\\main\\java\\icons\\spare.png")); // NOI18N
        jLabel3.setText("Manage Spare Parts");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 510, 90));

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

    private void tbl_spareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_spareMouseClicked
        int rowNo = tbl_spare.getSelectedRow();
        TableModel model = tbl_spare.getModel();

        txt_spid.setText(model.getValueAt(rowNo, 0).toString());
        txt_spname.setText(model.getValueAt(rowNo, 1).toString());
        txt_supid.setText(model.getValueAt(rowNo, 2).toString());
        txt_unitprice.setText(model.getValueAt(rowNo, 3).toString());
        int value = Integer.parseInt((String) model.getValueAt(rowNo, 4));
        txt_quantity.setValue(value);
        txt_condition.setSelectedItem(model.getValueAt(rowNo, 5));

    }//GEN-LAST:event_tbl_spareMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if (addSparePart() == true) {
            JOptionPane.showMessageDialog(this, "Spare Part Added Successfully!");
            clearTable();
            setSparePartDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Spare Part Addition Failed!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (updateSparePart() == true) {
            JOptionPane.showMessageDialog(this, "Spare Part Updated Successfully!");
            clearTable();
            setSparePartDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Spare Part Updation Failed!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if (deleteSparePart() == true) {
            JOptionPane.showMessageDialog(this, "Spare Part Deleted Successfully!");
            clearTable();
            setSparePartDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Spare Part Deletion Failed!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseExited

    private void rSMaterialButtonCircle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle6ActionPerformed

    private void rSMaterialButtonCircle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle7ActionPerformed

    private void rSMaterialButtonCircle8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle8ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageSpareParts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageSpareParts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageSpareParts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageSpareParts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageSpareParts().setVisible(true);
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle6;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle7;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle8;
    private rojeru_san.complementos.RSTableMetro tbl_spare;
    private javax.swing.JComboBox<String> txt_condition;
    private app.bolivia.swing.JCTextField txt_cusid1;
    private app.bolivia.swing.JCTextField txt_price1;
    private javax.swing.JSpinner txt_quantity;
    private app.bolivia.swing.JCTextField txt_repairid1;
    private app.bolivia.swing.JCTextField txt_repairname1;
    private app.bolivia.swing.JCTextField txt_spid;
    private app.bolivia.swing.JCTextField txt_spname;
    private app.bolivia.swing.JCTextField txt_supid;
    private app.bolivia.swing.JCTextField txt_unitprice;
    // End of variables declaration//GEN-END:variables
}
