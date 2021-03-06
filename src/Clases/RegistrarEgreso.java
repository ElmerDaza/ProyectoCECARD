/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.*;
import Clases.ClaseMetodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class RegistrarEgreso extends javax.swing.JFrame {

    String b[] = new String[5];
    Metodos m = new Metodos();
    ClaseMetodos c = new ClaseMetodos();

    public RegistrarEgreso() {
        initComponents();
        this.setLocationRelativeTo(null);

        String ruta = "src/IMG/gradient-red.png";
        ImageIcon FondoDePantalla = new ImageIcon(ruta);
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Background.getWidth(),
                Background.getHeight(), Image.SCALE_DEFAULT));
        Background.setIcon(icono);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NombrePago = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Concepto = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NombrePago1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        NombrePago2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NombrePago3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NombrePago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });
        getContentPane().add(NombrePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 240, 30));

        Concepto.setColumns(20);
        Concepto.setRows(5);
        jScrollPane1.setViewportView(Concepto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 220, 120));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("NIT O IDENTIFICACION:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("POR CONCEPTO DE:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        NombrePago1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloLetras(evt);
            }
        });
        getContentPane().add(NombrePago1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 240, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("PAGADO A:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        NombrePago2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });
        getContentPane().add(NombrePago2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 240, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("FECHA:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("VALOR EN NUMEROS:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        NombrePago3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });
        getContentPane().add(NombrePago3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 240, 30));

        jLabel2.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRO DE EGRESO.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 620, -1));

        jButton1.setText("GUARDAR.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 150, 35));

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 150, 35));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int Contador = 0;
        String saldo = "";
        b[0] = NombrePago.getText().trim();
        b[1] = NombrePago1.getText().trim();
        b[2] = NombrePago2.getText().trim();
        b[3] = NombrePago3.getText().trim();
        b[4] = Concepto.getText().trim();

        if (b[0].equals("")) {
            NombrePago.setBackground(Color.red);
            Contador++;
        }
        if (b[1].equals("")) {
            NombrePago1.setBackground(Color.red);
            Contador++;
        }
        if (b[2].equals("")) {
            NombrePago2.setBackground(Color.red);
            Contador++;
        }
        if (b[3].equals("")) {
            NombrePago3.setBackground(Color.red);
            Contador++;
        }
        if (b[4].equals("")) {
            Concepto.setBackground(Color.red);
            Contador++;
        }
        if (Contador == 0) {
            try {

                //en las segundas comillas va el usuario de mysql y en las terceras va la contraseña.
                Connection on = ClaseMetodos.conectar();

                //esta linea de codigo le da las intrucciones a la base de datos
                PreparedStatement pst = on.prepareStatement("SELECT Fecha, Ingreso, Egreso, Saldo FROM contavilidad");
                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rsMd = rs.getMetaData();
                int CantidadDeColumnas = rsMd.getColumnCount();
                int cantFilas = CantidadDeColumnas;
                String ob[] = new String[cantFilas];
                int contador = 0;

                while (rs.next()) {
                    for (int i = 0; i < CantidadDeColumnas; i++) {
                        ob[i] = rs.getString(i + 1);
                    }

                    contador = contador + 1;
                }

                pst = on.prepareStatement("select * from contavilidad where ID_Contabilidad =" + contador);

                rs = pst.executeQuery();

                if (rs.next()) {
                    saldo = (rs.getString("Saldo"));
                }
                
                try {
                        try (Connection cn = ClaseMetodos.conectar()) {
                            PreparedStatement pst2 = cn.prepareStatement("insert into contavilidad values "
                                    + "(?,?,?, ?,?,?, ?,?,?)");
                            pst2.setInt(1, 0);
                            pst2.setString(2, b[2]);
                            pst2.setString(3, b[4]);
                            pst2.setString(4, "");
                            pst2.setString(5, b[3]);
                            if (contador == 0) {
                                saldo = "0";
                            }
                            if(saldo != "0"){
                            int sald = Integer.parseInt(saldo.trim());
                            int pagado = Integer.parseInt(b[3]);
                            sald = sald - pagado;
                            saldo = Integer.toString(sald);

                            pst2.setString(6, saldo);
                            pst2.setString(7, b[1]);
                            pst2.setString(8, b[0]);
                            pst2.setString(9, "");
                            pst2.executeUpdate();

                            on.close();
                            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
                            c.VolerFinanzas();
                            this.setVisible(false);
                            }else {
                                JOptionPane.showMessageDialog(null, "EN ESTOS MOMENTOS NO SE PUEDE REGISTRAR EGRESO");
                            }
                        }

                    } catch (SQLException e) {
                        System.err.println("error al registrar egreso " + e);
                        JOptionPane.showMessageDialog(null, "Error en el sisteme contacte con el administrador.");
                    }

            } catch (SQLException e) {
                System.out.println("error en el boton = " + e);
            }
        } else{
            JOptionPane.showMessageDialog(null, "DEBES RELLENAR TODOS LOS CAMPOS \n"
                                                + "LOS CAMPOS MARCADOS CON ROJO SON OBLIGATORIOS.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        Finanzas r = new Finanzas();
        r.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void soloLetras(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soloLetras
        // TODO add your handling code here:
        m.SoloLetras(evt);
    }//GEN-LAST:event_soloLetras

    private void soloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soloNumeros
        // TODO add your handling code here:
        m.SoloNumeros(evt);
        
    }//GEN-LAST:event_soloNumeros

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
            java.util.logging.Logger.getLogger(RegistrarEgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEgreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JTextArea Concepto;
    private javax.swing.JTextField NombrePago;
    private javax.swing.JTextField NombrePago1;
    private javax.swing.JTextField NombrePago2;
    private javax.swing.JTextField NombrePago3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
