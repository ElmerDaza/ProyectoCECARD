/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class SeleccionDePago extends javax.swing.JFrame {

    String ruta = "src/IMG/gradient-red (2).png";
    public static int decicion;
    ClaseMetodos c = new ClaseMetodos();
    
    public SeleccionDePago() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Seleccione Acción.");
        

        ImageIcon FondoDePantalla = new ImageIcon(ruta);
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Bakground.getWidth(),
                Bakground.getHeight(), Image.SCALE_DEFAULT));
        Bakground.setIcon(icono);
        this.repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Matricula = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        Bakground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Matricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/matricula.png"))); // NOI18N
        Matricula.setText("jButton1");
        Matricula.setBorder(null);
        Matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatriculaActionPerformed(evt);
            }
        });
        getContentPane().add(Matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 130, 130));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/pension.png"))); // NOI18N
        jButton2.setText("jButton1");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 130, 130));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Libros.png"))); // NOI18N
        jButton3.setText("jButton1");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 130, 130));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/uniformes.png"))); // NOI18N
        jButton4.setText("jButton1");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 130, 130));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/evento.png"))); // NOI18N
        jButton5.setText("jButton1");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 130, 130));

        jButton6.setBackground(new java.awt.Color(51, 102, 255));
        jButton6.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jButton6.setText("MAS");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 70, 70));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton7.setText("x");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        Bakground.setFont(new java.awt.Font("Tahoma", 1, 5)); // NOI18N
        getContentPane().add(Bakground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazPrincipal I = new InterfazPrincipal();
        I.setVisible(true);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void MatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatriculaActionPerformed
        // TODO add your handling code here:
        decicion = 1;
        c.pasar = 1;
        c.DecidirPago(decicion);
        //this.setVisible(false);
        RegistrarPagoDeMatricula r = new RegistrarPagoDeMatricula();
        r.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_MatriculaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        decicion = 2;
        c.pasar = 2;
        c.DecidirPago(decicion);
        RegistrarPagoDeMatricula p= new RegistrarPagoDeMatricula();
        this.setVisible(false);
        p.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        RegistrarPagoDeLibro r = new RegistrarPagoDeLibro();
        this.setVisible(false);
        r.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        RegistrarPagoDeUniforme r = new RegistrarPagoDeUniforme();
        this.setVisible(false);
        r.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        AporteDeActividad a = new AporteDeActividad();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionDePago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bakground;
    private javax.swing.JButton Matricula;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    // End of variables declaration//GEN-END:variables
}
