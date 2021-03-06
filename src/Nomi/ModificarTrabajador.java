/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nomi;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Clases.Metodos;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Acer
 */
public class ModificarTrabajador extends javax.swing.JFrame {

    /**
     * Creates new form ModificarTrabajador
     */
    Clases.Metodos c = new Clases.Metodos();
    public static boolean MostrarID = false;
    String id = "";
    String estado = "";

    public ModificarTrabajador() {
        initComponents();
        this.setLocationRelativeTo(null);
        jLabel11.setVisible(false);
        
        ImageIcon FondoDePantalla = new ImageIcon("src/IMG/white-gradient.jpg");
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Background.getWidth(), 
                Background.getHeight(), Image.SCALE_DEFAULT));
        Background.setIcon(icono);
        
        
        //aca se colocan las imagenes en los Stiquer
        ImageIcon Stiq = new ImageIcon("src/IMG/CorregirDatos.png");
        Icon icono2 = new ImageIcon(Stiq.getImage().getScaledInstance(Stiquer.getWidth(),
                Stiquer.getHeight(), Image.SCALE_DEFAULT));
        Stiquer.setIcon(icono2);
        
        

        try {
            //Conexion con base de datos.
            Connection cn = Clases.ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = cn.prepareStatement("select * from trabajadores where No_Identificacion = ?");

            pst.setString(1, TrabajadoresUno.dat);
            ResultSet rs = pst.executeQuery();
            // con este codigo intento obtener los balores almacenados en la base de datos registro
            if (rs.next()) {

                jTextField2.setText(rs.getString("Apellidos"));
                jTextField5.setText(rs.getString("Nombres"));
                jTextField4.setText(rs.getString("Cargo"));
                jTextField1.setText(rs.getString("Sueldo"));
                estado = rs.getString("Estados");
                jTextField6.setText(rs.getString("Direccion"));
                jTextField3.setText(rs.getString("Telefono"));
                jTextField7.setText(rs.getString("Estudios"));
                jTextField8.setText(rs.getString("No_Identificacion"));
            }
        } catch (SQLException e) {
            System.out.println("error en buscar...." + e);
        }

        int item = 0;
        if (null != estado) {
            switch (estado) {
                case "Activo":
                    item = 1;
                    break;
                case "Suspendido":
                    item = 2;
                    break;
                case "Retirado":
                    item = 3;
                    break;
                default:
                    break;
            }
        }
        jComboBox1.setSelectedIndex(item);

        
        //se inabilitan los elementos 
        jButton1.setEnabled(false);

        jTextField5.setEditable(false);
        jTextField6.setEditable(false);
        jTextField4.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField1.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(false);

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
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        Stiquer = new javax.swing.JLabel();

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

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5soloLetras(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 150, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nombres:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Dirección:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 150, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Cargo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4soloLetras(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 150, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Apellidos:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2soloLetras(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 150, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, -1));

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3solaNumeros(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Salario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1solaNumeros(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 150, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("No Identificacion:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8soloLetras(evt);
            }
        });
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 150, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Estudios realizados:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, -1, -1));

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7soloLetras(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 150, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Activo", "Suspendido", "Retirado" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Estado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        jLabel1.setFont(new java.awt.Font("Broadway", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MODIFICAR INFORMACION.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 710, 30));

        jButton1.setText("Continuar.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, 150, 30));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCheckBox1.setText("     MODIFICAR.");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 150, -1));

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("=> Digite Documento De Empleado:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 550));
        getContentPane().add(Stiquer, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 100, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5soloLetras(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5soloLetras
        // TODO add your handling code here:
        c.SoloLetras(evt);
    }//GEN-LAST:event_jTextField5soloLetras

    private void jTextField4soloLetras(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4soloLetras
        // TODO add your handling code here:
        c.SoloLetras(evt);
    }//GEN-LAST:event_jTextField4soloLetras

    private void jTextField2soloLetras(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2soloLetras
        // TODO add your handling code here:
        c.SoloLetras(evt);
    }//GEN-LAST:event_jTextField2soloLetras

    private void jTextField3solaNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3solaNumeros
        // TODO add your handling code here:
        c.SoloNumeros(evt);
    }//GEN-LAST:event_jTextField3solaNumeros

    private void jTextField1solaNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1solaNumeros
        // TODO add your handling code here:
        c.SoloNumeros(evt);
    }//GEN-LAST:event_jTextField1solaNumeros

    private void jTextField8soloLetras(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8soloLetras
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8soloLetras

    private void jTextField7soloLetras(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7soloLetras
        // TODO add your handling code here:
        c.SoloLetras(evt);
    }//GEN-LAST:event_jTextField7soloLetras

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (TrabajadoresUno.TraUno == 1) {

            TrabajadoresUno.TraUno = 0;
            TrabajadoresUno.dat = "";
            TrabajadoresUno.Tabla.setVisible(true);

        } else {
            Clases.Metodos m = new Clases.Metodos();
            TrabajadoresUno.dat = "";
            TrabajadoresUno.TraUno = 0;
            m.VolverNomina();
        }
        TrabajadoresUno.dat = "";

        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Modificar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            jButton1.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Los datos por modificar \n"
                    + "no se podran recuperar");

            jTextField5.setEditable(true);
            jTextField6.setEditable(true);
            jTextField4.setEditable(true);
            jTextField2.setEditable(true);
            jTextField3.setEditable(true);
            jTextField1.setEditable(true);
            jTextField7.setEditable(true);
            jTextField8.setEditable(true);

            //cambio de color
            jTextField5.setBackground(Color.CYAN);
            jTextField6.setBackground(Color.CYAN);
            jTextField4.setBackground(Color.CYAN);
            jTextField2.setBackground(Color.CYAN);
            jTextField3.setBackground(Color.CYAN);
            jTextField1.setBackground(Color.CYAN);
            jTextField7.setBackground(Color.CYAN);
            jTextField8.setBackground(Color.CYAN);
        }
        if (!jCheckBox1.isSelected()) {
            jButton1.setEnabled(false);

            jTextField5.setEditable(false);
            jTextField6.setEditable(false);
            jTextField4.setEditable(false);
            jTextField2.setEditable(false);
            jTextField3.setEditable(false);
            jTextField1.setEditable(false);
            jTextField7.setEditable(false);
            jTextField8.setEditable(false);
        }


    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarTrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Stiquer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
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
    //La inicializacion de estas variables esta en la clase metodos.
    public static javax.swing.JTextField ID;
    public static javax.swing.JLabel LabelID;

    public void Press(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        id = ID.getText().trim();
        BuscarDocumento();
    }

    public void soloNumeros(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        SoloNumeros(evt);
    }

    private void BuscarDocumento() {
        try {
            Connection cn = Clases.ClaseMetodos.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from Trabajadores where No_Identificacion ='" + id + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                jTextField2.setText(rs.getString("Apellidos"));
                jTextField5.setText(rs.getString("Nombres"));
                jTextField4.setText(rs.getString("Cargo"));
                jTextField1.setText(rs.getString("Sueldo"));
                estado = (rs.getString("Estados"));
                jTextField6.setText(rs.getString("Direccion"));
                jTextField3.setText(rs.getString("telefono"));
                jTextField7.setText(rs.getString("Estudios"));
                jTextField8.setText(rs.getString("No_Identificacion"));
                cn.close();
                int item = 0;
                if (null != estado) {
                    switch (estado) {
                        case "Activo":
                            item = 1;
                            break;
                        case "Suspendido":
                            item = 2;
                            break;
                        case "Retirado":
                            item = 3;
                            break;
                        default:
                            break;
                    }
                }
                jComboBox1.setSelectedIndex(item);
                jLabel11.setVisible(false);

            } else {
                if ("".equals(id)) {
                    jLabel11.setVisible(true);
                    jLabel11.setText("<= Digite Documento de Empleado.");
                } else {
                    jLabel11.setVisible(true);
                    jLabel11.setText("Este numero no cincide.");
                    jTextField5.setText("");
                    jTextField6.setText("");
                    jTextField4.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField1.setText("");
                    jTextField7.setText("");
                    jTextField8.setText("");
                }
            }
        } catch (Exception e) {
            System.out.println("este fallo al buscar... " + e);
        }
    }

    private void Modificar() {

        int validacion = 0;
        String d[] = new String[10];
        d[0] = jTextField1.getText().trim();//sueldo
        d[1] = jTextField2.getText().trim();//apellidos
        d[2] = jTextField3.getText().trim();//telefono
        d[3] = jTextField4.getText().trim();//Cargo
        d[4] = jTextField5.getText().trim();//Nombres
        d[5] = jTextField6.getText().trim();//direccion
        d[6] = jTextField7.getText().trim();//estudios
        d[7] = jTextField8.getText().trim();//Identificacion
        d[8] = jComboBox1.getSelectedItem().toString();//estado
        if (MostrarID == true) {
            d[9] = ID.getText().trim();
        }
        if ("".equals(d[0])) {
            jTextField1.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[1])) {
            jTextField2.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[2])) {
            jTextField3.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[3])) {
            jTextField4.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[4])) {
            jTextField5.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[5])) {
            jTextField6.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[6])) {
            jTextField7.setBackground(Color.red);
            validacion++;
        }
        if ("".equals(d[7])) {
            jTextField8.setBackground(Color.red);
            validacion++;
        }
        if ("Seleccione".equals(d[8])) {
            JOptionPane.showMessageDialog(null, "Seleccione Estado.");
            validacion++;
        }
        if (MostrarID == true) {
            if ("".equals(d[9])) {
                ID.setBackground(Color.red);
                validacion++;
            }
        }
        if (validacion == 0) {
            try {
                //este codigo conecta con la base de datos
                Connection cn = Clases.ClaseMetodos.conectar();
                //esta linea de codigo da las instrucciones a la base de datos
                PreparedStatement pst = cn.prepareStatement(
                        "update trabajadores set Nombres = ?, "
                        + "Apellidos = ?, Cargo = ?, "
                        + "Sueldo = ?, Estados = ?, Direccion = ?, Telefono = ?, "
                        + "Estudios = ?, No_Identificacion = ? WHERE No_Identificacion = '" + TrabajadoresUno.dat + "'");

                //sueldo
                //apellidos
                //telefono
                //Cargo
                //Nombres
                //direccion
                //estudios
                //Identificacion
                //estado
                pst.setString(1, d[4]);
                pst.setString(2, d[1]);
                pst.setString(3, d[3]);
                pst.setString(4, d[0]);
                pst.setString(5, d[8]);
                pst.setString(6, d[5]);
                pst.setString(7, d[2]);
                pst.setString(8, d[6]);
                pst.setString(9, d[7]);

                pst.executeUpdate();
                cn.close();
                JOptionPane.showMessageDialog(null, "Modificacion Exitosa.");
                if (TrabajadoresUno.TraUno == 1) {
                    TrabajadoresUno.TraUno = 0;
                    TrabajadoresUno.dat = "";
                    TrabajadoresUno.Tabla.setVisible(true);
                }
                if (MostrarID == true){
                    
                    c.VolverNomina();
                }
                this.setVisible(false);
            } catch (SQLException e) {
                System.out.println("Errorrr corrigiendo...." + e);
            }
        }
    }

    public void SoloNumeros(java.awt.event.KeyEvent e) {

        //esta condicional restringe los caracteres basado en el listado de la tabla ascii
        if (e.getKeyChar() >= 32 && e.getKeyChar() <= 47
                || e.getKeyChar() >= 58 && e.getKeyChar() <= 255) {
            e.consume();

        }
    }
}
