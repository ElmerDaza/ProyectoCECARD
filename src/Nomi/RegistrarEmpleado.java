package Nomi;

import Clases.ClaseMetodos;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class RegistrarEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form Profesores
     */
    public static int paso = 0;
    Clases.Metodos c = new Clases.Metodos();

    public RegistrarEmpleado() {
        initComponents();

        this.setLocationRelativeTo(null);

        ImageIcon FondoDePantalla = new ImageIcon("src/IMG/redgeometria.jpg");
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Background.getWidth(),
                Background.getHeight(), Image.SCALE_DEFAULT));
        Background.setIcon(icono);
        
        //aca se colocan las imagenes en los Stiquer
        ImageIcon Stiq = new ImageIcon("src/IMG/Empleadospng.png");
        Icon icono2 = new ImageIcon(Stiq.getImage().getScaledInstance(Stiquer.getWidth(),
                Stiquer.getHeight(), Image.SCALE_DEFAULT));
        Stiquer.setIcon(icono2);

        /*Continuar.setVisible(false);
            jComboBox1.setVisible(false);
            jLabel1.setText("LISTADO DE EMPLEADOS");
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jTextField3.setVisible(false);
            jTextField4.setVisible(false);
            jTextField5.setVisible(false);
            jTextField6.setVisible(false);
            jTextField7.setVisible(false);*/
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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Continuar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Stiquer = new javax.swing.JLabel();
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
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 35));

        jLabel1.setFont(new java.awt.Font("Broadway", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR EMPLEADO.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 720, 30));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                solaNumeros(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Salario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloLetras(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Estado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                solaNumeros(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 150, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, -1, -1));

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloLetras(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 150, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Cargo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Activo", "Suspendido", "Retirado" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 150, 30));

        Continuar.setText("Continuar.");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(Continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, 150, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Apellidos:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nombres:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloLetras(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 150, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Dirección:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 150, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Estudios realizados:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloLetras(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 150, 30));

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8soloLetras(evt);
            }
        });
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 150, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("No Identificacion:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));
        getContentPane().add(Stiquer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 300, 140));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Clases.Nomina i = new Clases.Nomina();
        paso = 0;
        i.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        // TODO add your handling code here:
        int validacion = 0, Validacion = 0;

        String d[] = new String[9];
        d[0] = jTextField5.getText().trim();
        d[1] = jTextField6.getText().trim();
        d[2] = jTextField4.getText().trim();
        d[3] = jTextField2.getText().trim();
        d[4] = jTextField3.getText().trim();
        d[5] = jTextField1.getText().trim();
        d[6] = jComboBox1.getSelectedItem().toString();
        d[7] = jTextField7.getText().trim();
        d[8] = jTextField8.getText().trim();

        if ("".equals(d[0])) {
            jTextField5.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[1])) {
            jTextField6.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[2])) {
            jTextField4.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[3])) {
            jTextField2.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[4])) {
            jTextField3.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[5])) {
            jTextField1.setBackground(Color.red);
            validacion++;
        }
        if ("Seleccione".equals(d[6])) {
            JOptionPane.showMessageDialog(null, "Seleccione Estado del trabajador.");
            validacion++;
        }
        if ("".equals(d[7])) {
            jTextField7.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[8])) {
            jTextField8.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {

            try {
                Connection cn = ClaseMetodos.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select No_Identificacion from trabajadores where No_Identificacion ='" + d[8] + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    jTextField8.setBackground(new Color(255, 0, 128));
                    JOptionPane.showMessageDialog(null,
                            "Este numerom de documento:" + d[8] + " ya se encuentra Registrado.");
                    cn.close();
                    Validacion++;
                }
            } catch (Exception e) {
                System.out.println("errrorr " + e);
            }
            if (Validacion == 0) {
                try {
                    Connection cn = ClaseMetodos.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "insert into trabajadores values "
                            + "(?,?,?, ?,?,?, ?,?,?,?)");
                    pst.setInt(1, 0);
                    pst.setString(2, d[0]);
                    pst.setString(3, d[3]);
                    pst.setString(4, d[2]);
                    pst.setString(5, d[5]);
                    pst.setString(6, d[6]);
                    pst.setString(7, d[1]);
                    pst.setString(8, d[4]);
                    pst.setString(9, d[7]);
                    pst.setString(10, d[8]);
                    pst.executeUpdate();
                    cn.close();

                    JOptionPane.showMessageDialog(null, "Registro Realizado con Exito");
                    jComboBox1.setSelectedIndex(0);
                    jTextField5.setText("");
                    jTextField6.setText("");
                    jTextField4.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField1.setText("");
                    jTextField7.setText("");
                    jTextField8.setText("");
                    jTextField5.setBackground(Color.WHITE);
                    jTextField6.setBackground(Color.WHITE);
                    jTextField4.setBackground(Color.WHITE);
                    jTextField2.setBackground(Color.WHITE);
                    jTextField3.setBackground(Color.WHITE);
                    jTextField1.setBackground(Color.WHITE);
                    jTextField7.setBackground(Color.WHITE);
                    jTextField8.setBackground(Color.WHITE);

                } catch (SQLException e) {
                    System.out.println("errrooor   " + e);
                }
            }

        } else if (validacion != 0) {
            JOptionPane.showMessageDialog(null,
                    "Los campos marcados con rojo son \n"
                    + "          OBLIGATORIOS.");
        }
    }//GEN-LAST:event_ContinuarActionPerformed

    private void soloLetras(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soloLetras
        // TODO add your handling code here:
        c.SoloLetras(evt);
    }//GEN-LAST:event_soloLetras

    private void solaNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_solaNumeros
        // TODO add your handling code here:
        c.SoloNumeros(evt);
    }//GEN-LAST:event_solaNumeros

    private void jTextField8soloLetras(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8soloLetras
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8soloLetras

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
            java.util.logging.Logger.getLogger(RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton Continuar;
    private javax.swing.JLabel Stiquer;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

}
