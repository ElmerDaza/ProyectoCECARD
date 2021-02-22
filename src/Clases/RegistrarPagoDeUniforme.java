/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class RegistrarPagoDeUniforme extends javax.swing.JFrame {
    ClaseMetodos c = new ClaseMetodos();
    int cantFila = 5, contador,exito;
    String ruta = "src/IMG/gradient-red.png ",saldo,ob[] = new String [cantFila];
    Metodos m = new Metodos();
    
    public RegistrarPagoDeUniforme() {
        initComponents();
        setLocationRelativeTo(null);
        
        //Fondo de Pantalla en un jLabel
        ImageIcon FondoDePantalla = new ImageIcon(ruta);
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Background.getWidth(),
                Background.getHeight(), Image.SCALE_DEFAULT));
        Background.setIcon(icono);
        this.repaint();
        
        //aca se colocan las imagenes en los Stiquer
        ImageIcon Stiq = new ImageIcon("src/IMG/uniformes.png");
        Icon icono2 = new ImageIcon(Stiq.getImage().getScaledInstance(Stiquer.getWidth(),
                Stiquer.getHeight(), Image.SCALE_DEFAULT));
        Stiquer.setIcon(icono2);
        
        
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
        ID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Continuar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Valor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Diario = new javax.swing.JCheckBox();
        EduFisica = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        Stiquer = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cooper Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(251, 249, 250));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pago de uniforme");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 500, -1));

        ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 200, 30));

        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 100, 30));

        Continuar.setText("CONTINUAR");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(Continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 100, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(251, 249, 250));
        jLabel2.setText("Identificación de alumno:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        Valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });
        getContentPane().add(Valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 200, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(251, 249, 250));
        jLabel4.setText("Valor:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        Diario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Diario.setText("Diario");
        getContentPane().add(Diario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        EduFisica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EduFisica.setText("Edu Fisica");
        getContentPane().add(EduFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(251, 249, 250));
        jLabel5.setText("Seleccione:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));
        getContentPane().add(Stiquer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 110, 110));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SeleccionDePago s = new SeleccionDePago();
        this.setVisible(false);
        s.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        // TODO add your handling code here:
        
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
        String day = c.DiaEnLetras(dia);
        String Mes = c.MesEnLetras(mes);
        String fechaS = dia + "/" + Mes + "/" + año + "/ " + hora + ":" + min;

        int Validacion = 0;
        exito = 0;
        contador = 0;
        cantFila = 4;
        ob[0] = ID.getText().trim();
        ob[1] = Valor.getText().trim();
        if(EduFisica.isSelected() && !Diario.isSelected()){
        
            ob[2] = "Pago uniforme de fisica.";
        } else if(!EduFisica.isSelected() && Diario.isSelected()){
            ob[2] = "Pago uniforme de diario.";
        } else if(!EduFisica.isSelected() && !Diario.isSelected()){
            JOptionPane.showMessageDialog(null,"Por favor seleccione un uniforme.");
            Validacion++;
        }
        
        
        if (ob[0].equals("")) {
            ID.setBackground(Color.red);
            Validacion++;
        }
        if (ob[1].equals("")) {
            Validacion++;
            Valor.setBackground(Color.red);
        }
        
        
        if (Validacion != 0) {
            JOptionPane.showMessageDialog(null,
                    "Todos los campos marcados con rojo son obligatorios");
        }
        if (Validacion == 0) {
            c.pasar = 3;
            c.identificacion = ID.getText().trim();
            c.Buscar();
            
            try {
                Connection on = ClaseMetodos.conectar();
                PreparedStatement pst = on.prepareStatement(
                        "SELECT Fecha, Ingreso, Egreso, Saldo FROM contavilidad");

                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rsMd = rs.getMetaData();
                int CantidadDeColumnas = rsMd.getColumnCount();
                cantFila = CantidadDeColumnas;

                while (rs.next()) {
                    for (int i = 0; i < CantidadDeColumnas; i++) {
                        ob[i] = rs.getString(i + 1);
                    }

                    contador = contador + 1;
                }

                pst = on.prepareStatement(
                        "select * from contavilidad where ID_Contabilidad =" + contador);
                rs = pst.executeQuery();

                if (rs.next()) {
                    saldo = (rs.getString("Saldo"));
                }

                exito = c.exito;
                System.out.println("este es contador " + contador);
                try (Connection cn = ClaseMetodos.conectar()) {
                    if (exito == 0) {
                        PreparedStatement pst2 = cn.prepareStatement("insert into contavilidad values "
                                + "(?,?,?, ?,?,?, ?,?,?)");
                        pst2.setInt(1, 0);
                        pst2.setString(2, fechaS);
                        pst2.setString(3, "Compra de Uniforme: // " + ob[2]);
                        pst2.setString(4, Valor.getText().trim());
                        pst2.setString(5, "");
                        if (contador == 0) {
                            saldo = "0";
                        }
                        int sald = Integer.parseInt(saldo.trim());
                        int pagado = Integer.parseInt(Valor.getText().trim());
                        sald = sald + pagado;
                        saldo = Integer.toString(sald);

                        pst2.setString(6, saldo);
                        pst2.setString(7, "Usuario.");
                        pst2.setString(8, ID.getText().trim());
                        String nombre = c.d[0] + " " + c.d[1] + " " + c.d[4];
                        pst2.setString(9, nombre);

                        pst2.executeUpdate();

                        on.close();

                        JOptionPane.showMessageDialog(null, "Registro exitoso.");
                        SeleccionDePago s = new SeleccionDePago();
                        s.setVisible(true);
                        this.setVisible(false);
                    }
                }

            } catch (SQLException e) {
                Validacion++;

                System.err.println("error al registrar alumno " + e);
                JOptionPane.showMessageDialog(null, "Error en el sisteme contacte con el administrador.");
            }
        }
    }//GEN-LAST:event_ContinuarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarPagoDeUniforme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPagoDeUniforme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPagoDeUniforme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPagoDeUniforme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarPagoDeUniforme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton Continuar;
    private javax.swing.JCheckBox Diario;
    private javax.swing.JCheckBox EduFisica;
    private javax.swing.JTextField ID;
    private javax.swing.JLabel Stiquer;
    private javax.swing.JTextField Valor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}