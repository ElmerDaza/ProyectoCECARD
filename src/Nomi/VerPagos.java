/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nomi;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Acer
 */
public class VerPagos extends javax.swing.JFrame {

    
    
    DefaultTableModel modelo = new DefaultTableModel();
    /**
     * Creates new form VerPagos
     */
    public VerPagos() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        ImageIcon FondoDePantalla = new ImageIcon("src/IMG/white-gradient.jpg");
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Background.getWidth(), 
                Background.getHeight(), Image.SCALE_DEFAULT));
        Background.setIcon(icono);
        
        
        int contador = 0;
        try {
            
            Tabla.setModel(modelo);

            //coneccion con base de datos
            Connection on = Clases.ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = on.prepareStatement(
                    "SELECT Consepto, Ingreso, Egreso, Saldo, Fecha, Alumno, "
                            + "Nombre_De_Quien_Paga FROM contavilidad");

            ResultSet rs = pst.executeQuery();

            //establecer nombres de columnas
            modelo.addColumn("CONCEPTO");
            modelo.addColumn("INGRESO");
            modelo.addColumn("EGRESO");
            modelo.addColumn("SALDO");
            modelo.addColumn("FECHA");
            modelo.addColumn("ALUMNO");
            modelo.addColumn("PAGANTE");
            

            ResultSetMetaData rsMd = rs.getMetaData();
            int CantidadDeColumnas = rsMd.getColumnCount();
            String[] filas = new String[CantidadDeColumnas];
            while (rs.next()) {

                for (int i = 0; i < CantidadDeColumnas; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                contador = contador + 1;
                modelo.addRow(filas);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        Filtrar();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setText("x");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 35));

        jLabel2.setFont(new java.awt.Font("Broadway", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PAGOS.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 900, 30));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 87, 800, 290));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Clases.Nomina i = new Clases.Nomina();
        i.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(VerPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerPagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables



    public void Filtrar(){
        String query = "Nomina",pin = "Nom";
        try{
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        Tabla.setRowSorter(tr);
        
        if(!"Nomina".equals(pin)){
            tr.setRowFilter(RowFilter.regexFilter(query,5));
        }else{
            Tabla.setRowSorter(tr);
            
        }
        }catch(Exception e){
            System.out.println("algo salio mal..  "+e);
        }
    }
}
