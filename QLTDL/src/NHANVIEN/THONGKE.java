/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package NHANVIEN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class THONGKE extends javax.swing.JFrame {

    DefaultTableModel tblModel = new DefaultTableModel();

    public THONGKE() {
        initComponents();
        setLocationRelativeTo(null);
        show_SP();
        show_SP1();

    }

    public void show_SP() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=demo_CSDL1;user=yun;password=123");
            System.out.println("Connected to the database");
            String query = "SELECT CD.MA_TOUR, DS.GIA,  COUNT(*) as sl, DS.GIA*count(*) AS TONGTIEN\n"
                    + "FROM DS_TOUR DS, CHUYENDI_KH CD\n"
                    + "WHERE DS.MA_TOUR = CD.MA_TOUR and CD.TRANGTHAI = N'ĐÃ XÁC THỰC'\n"
                    + "GROUP BY CD.MA_TOUR, DS.GIA";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel tblmodel = (DefaultTableModel) tbl_tk.getModel();
            while (rs.next()) {
                tblmodel.addRow(new String[]{rs.getString(1), String.valueOf(rs.getInt(2)), String.valueOf(rs.getInt(3)), String.valueOf(rs.getInt(4))});
            }
        } catch (Exception E) {
            System.out.println("Connection failed");
            E.printStackTrace();
        }
    }

    public void show_SP1() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=demo_CSDL1;user=yun;password=123");
            System.out.println("Connected to the database");
            String query = "SELECT CD.MA_TOUR, month(CT.NGAYXUATPHAT) AS THANG , DS.GIA*count(*) AS TONGTIEN\n"
                    + "FROM DS_TOUR DS, CHITIET_TOUR CT, CHUYENDI_KH CD\n"
                    + "WHERE DS.MA_TOUR = CT.MA_TOUR AND CT.MA_TOUR = CD.MA_TOUR and CD.TRANGTHAI = N'ĐÃ XÁC THỰC'\n"
                    + "group by CT.MA_TOUR,month(CT.NGAYXUATPHAT), CD.MA_TOUR, DS.GIA\n"
                    + "ORDER BY month(CT.NGAYXUATPHAT) ASC";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel tblmodel = (DefaultTableModel) tbl_tk_thang.getModel();
            while (rs.next()) {
                tblmodel.addRow(new String[]{rs.getString(1), String.valueOf(rs.getInt(2)), String.valueOf(rs.getInt(3))});
            }
        } catch (Exception E) {
            System.out.println("Connection failed");
            E.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tk = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_tk_thang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("THONG KE");

        tbl_tk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MA TOUR", "GIA", "SO LUONG", "TONG LOI NHUAN"
            }
        ));
        jScrollPane1.setViewportView(tbl_tk);

        tbl_tk_thang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MA TOUR", "THANG", "TONG TIEN"
            }
        ));
        jScrollPane2.setViewportView(tbl_tk_thang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new THONGKE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_tk;
    private javax.swing.JTable tbl_tk_thang;
    // End of variables declaration//GEN-END:variables
}
