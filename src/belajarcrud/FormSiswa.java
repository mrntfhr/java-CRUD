/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package belajarcrud;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class FormSiswa extends javax.swing.JFrame {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement statSiswa;
    Boolean ada = false;
    
    public FormSiswa() {
        initComponents();
        koneksi();
        display();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Form Siswa");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 37, -1, -1));

        jLabel2.setText("Rombel");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 130, -1, -1));

        jLabel3.setText("Nama");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 96, -1, -1));

        jLabel4.setText("NIS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 62, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 59, 114, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 93, 114, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 127, 114, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 59, -1, -1));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 93, -1, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 127, -1, -1));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 59, -1, -1));

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        getContentPane().add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 93, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 155, 380, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void koneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost/crud_java";
            String user="root";
            String pass="";
            con = DriverManager.getConnection(url,user,pass);
            statSiswa = con.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_UPDATABLE);
            rs = statSiswa.executeQuery("select * from siswa");

          }catch(Exception e){
              JOptionPane.showMessageDialog(null, e);
              System.exit(0);
          }
    }
    
    private void display(){
        try{
            String sql="select * from siswa";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
   
    private void reset(){
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
    }
    
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
      try{
            koneksi();
            statSiswa = con.createStatement();
            String SQL = "DELETE FROM siswa WHERE nis = '"+jTextField1.getText()+"'";
            statSiswa.executeUpdate(SQL);
            display();
            statSiswa.close();
            con.close();
            JOptionPane.showMessageDialog(null, "berhasil hapus");

        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        final String nisRegex = "\\d+";
        final String usernameRegex = "\\w+";

        try{
            koneksi();
            statSiswa = con.createStatement();
            
            if(jTextField1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "nis tidak boleh kosong");
                return;
            }
            if(jTextField1.getText().length()>8) {
                JOptionPane.showMessageDialog(null, "nis terlalu panjang");
                return;
            }

            if(jTextField1.getText().matches(nisRegex) == false) {
                JOptionPane.showMessageDialog(null, "nis harus angka");
                return;
            }
            
            if(jTextField2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "nama tidak boleh kosong");
                                return;

            }
            if(jTextField2.getText().matches(usernameRegex) == false) {
                JOptionPane.showMessageDialog(null, "nama harus huruf");
                return;
            }
            
            if(jTextField3.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "rombel tidak boleh kosong");
                                return;

            }
            if(jTextField3.getText().length()>10) {
                JOptionPane.showMessageDialog(null, "rombel terlalu panjang");
                return;
            }
            if(jTextField3.getText().matches(usernameRegex) == false) {
                JOptionPane.showMessageDialog(null, "rombel harus huruf");
                return;
            }
            
            ResultSet checkNis = statSiswa.executeQuery("select * from siswa where nis = "+jTextField1.getText());
            
            if (checkNis.first()) {
                JOptionPane.showMessageDialog(null, "nis tidak boleh duplicate");
                return;
            }
            String SQL = "insert into siswa values('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"')";
            statSiswa.executeUpdate(SQL);
            display();
            statSiswa.close();
            con.close();
            Reset();
            JOptionPane.showMessageDialog(null, "berhasil simpan");

        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            koneksi();
            int row =jTable1.getSelectedRow();
            String tabel_klik=(jTable1.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from siswa where nis='"+tabel_klik+"'");
            if(sql.next()){
                String id = sql.getString("nis");
                jTextField1.setText(id);
                String nama = sql.getString("nama");
                jTextField2.setText(nama);
                String harga = sql.getString("rombel");
                jTextField3.setText(harga);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
    try{
            koneksi();
            statSiswa = con.createStatement();
            String SQL = "update siswa SET nis = '"+jTextField1.getText()+"', nama = '"+jTextField2.getText()+"', rombel = '"+jTextField3.getText()+"' WHERE nis = '"+jTextField1.getText()+"'";
            statSiswa.executeUpdate(SQL);
            display();
            statSiswa.close();
            con.close();
            Reset();
            JOptionPane.showMessageDialog(null, "berhasil edit");

        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
    reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
    System.exit(0);
    }//GEN-LAST:event_btnKeluarActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("test");
                new FormSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    private void Reset() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}