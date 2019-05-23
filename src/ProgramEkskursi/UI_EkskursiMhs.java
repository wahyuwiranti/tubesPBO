/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramEkskursi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus pc
 */
public class UI_EkskursiMhs extends javax.swing.JFrame {
    DefaultTableModel model;
    String username;
    String ID;
    String Tipe;
    /**
     * Creates new form UI_EkskursiMhs
     */
    public UI_EkskursiMhs() {
        setTitle("EKSCALIBUR");
        setLocation(400, 160);
        setLayout(null);
        initComponents();

        //Memberi Penamaan pada Tabel
        model = new DefaultTableModel();
        tabelEkskursi.setModel(model);
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Program Studi");
        model.addColumn("Departure");
        //model.addColumn("Durasi");
        //model.addColumn("Tujuan");
        //model.addColumn("Biaya");
        model.addColumn("Kuota");
        
        LoadAll();
    }
    
    
    public UI_EkskursiMhs(String Tipe, String username) {
        initComponents();
        this.Tipe=Tipe;
        if(Tipe.equals("mahasiswa")) this.username=username;
        
        //Memberi Penamaan pada Tabel
        model = new DefaultTableModel();
        tabelEkskursi.setModel(model);
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Program Studi");
        model.addColumn("Departure");
        //model.addColumn("Durasi");
        //model.addColumn("Tujuan");
        //model.addColumn("Biaya");
        model.addColumn("Kuota");
        
        LoadAll();
    }
    public void LoadAll(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            //Membuat Statement Pemanggilan data pada table mahasiswa dari database
            Statement stat=(Statement) User.getConnection().createStatement();
            String query="SELECT * FROM KEGIATAN WHERE KEGIATAN.ID NOT IN (SELECT ID FROM PEMBAYARAN WHERE NIM=(SELECT NIM FROM MAHASISWA WHERE USERNAME='"+username+"'));";
            ResultSet res=stat.executeQuery(query);
            
            //penelusuran baris pada tabel mahasiswa dari database
            while(res.next()){
                Object[] obj = new Object[5];
                obj[0] = res.getString("ID");
                obj[1] = res.getString("Nama");
                obj[2] = res.getString("prodi");
                obj[3] = res.getString("departure");
                obj[4] = res.getString("kuota");
                
                model.addRow(obj);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void dataSelect(){
        int i=tabelEkskursi.getSelectedRow();
        if(i==-1){
            //tidak ada baris terpilih
            return;
        }
        ID=(String) model.getValueAt(i, 0);
        
//        jTextField1.setText(""+model.getValueAt(i, 1));
//        jTextField2.setText(""+model.getValueAt(i, 0));
//        jComboBox1.getModel().setSelectedItem(model.getValueAt(i, 2));
    }
//    public void updateData(){
//        // Menambahkan Data Mahasiswa
//        String[] x=new String[4];
//        x[0]=jTextField1.getText();
//        x[1]=jTextField2.getText();
//        x[2]=String.valueOf(jComboBox1.getSelectedItem());
//        x[3]=(1900+jDateChooser1.getDate().getYear())+"-"+
//             (1+jDateChooser1.getDate().getMonth())+"-"+
//             jDateChooser1.getDate().getDate();
//        System.out.println(jDateChooser1.getDate().getMonth());
//        KumpulanMahasiswa obj=new KumpulanMahasiswa();
//        obj.UpdateMhs(new Mahasiswa(x[0],x[1],x[2],x[3]));
//        
//        new UI_KumpulanMhs().setVisible(true);
//        dispose();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        background1 = new ProgramEkskursi.Background();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelEkskursi = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelEkskursi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelEkskursi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelEkskursi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelEkskursiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelEkskursi);

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 51));
        jButton2.setText("Detail");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            new UI_Mahasiswa(username).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(UI_EkskursiMhs.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            new UI_DetailEkskursi(Tipe,username,ID).setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(UI_EkskursiMhs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabelEkskursiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelEkskursiMouseClicked
        // TODO add your handling code here:
        dataSelect();
    }//GEN-LAST:event_tabelEkskursiMouseClicked

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
            java.util.logging.Logger.getLogger(UI_EkskursiMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_EkskursiMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_EkskursiMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_EkskursiMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_EkskursiMhs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ProgramEkskursi.Background background1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelEkskursi;
    // End of variables declaration//GEN-END:variables
}
