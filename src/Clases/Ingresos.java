package Clases;

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

public class Ingresos extends javax.swing.JFrame {

    String ruta = "src/IMG/gradient-pink.png";
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Ingresos() {
        initComponents();
        
        setLocationRelativeTo(null);
        setTitle("Registro De Ingresos.");
        
        ImageIcon FondoDePantalla = new ImageIcon(ruta);
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Background.getWidth(), 
                Background.getHeight(), Image.SCALE_DEFAULT));
        Background.setIcon(icono);
        this.repaint();
        
        
        int contador = 0;
        try {
            
            jTable1.setModel(modelo);

            //coneccion con base de datos
            Connection on = ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = on.prepareStatement(
                    "SELECT Consepto, Ingreso, Egreso, Fecha, Nombre_De_Quien_Paga, "
                            + "Cedula_De_Quien_Paga, Alumno FROM contavilidad");

            ResultSet rs = pst.executeQuery();

            //establecer nombres de columnas
            modelo.addColumn("CONSEPTO");
            modelo.addColumn("INGRESO");
            modelo.addColumn("EGRESO");
            modelo.addColumn("FECHA");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DOCUMENTO");
            modelo.addColumn("ALUMNO");

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
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labei1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labei1.setFont(new java.awt.Font("Broadway", 1, 24)); // NOI18N
        labei1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labei1.setText("MOVIMIENTOS FINANCIEROS");
        labei1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(labei1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 800, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 107, 700, 350));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 30));

        jButton3.setText("x");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 35));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Filtrar por mes.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        InterfazPrincipal i = new InterfazPrincipal();
        this.setVisible(false);
        i.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        String query = jComboBox1.getSelectedItem().toString();
        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        jTable1.setRowSorter(tr);
        
        if(query != "Todo"){
            tr.setRowFilter(RowFilter.regexFilter(query));
        }else{
            jTable1.setRowSorter(tr);
            
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

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
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labei1;
    // End of variables declaration//GEN-END:variables
}
