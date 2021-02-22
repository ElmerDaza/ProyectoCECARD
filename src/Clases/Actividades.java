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
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Actividades extends javax.swing.JFrame {

    String b[] = new String[4], ruta = "src/IMG/fondoblanco.jpg";
    ClaseMetodos c = new ClaseMetodos();
    //generar fecha
    Calendar fecha = Calendar.getInstance();
    int año = fecha.get(Calendar.YEAR);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    int mes = fecha.get(Calendar.MONTH);
    int hora = fecha.get(Calendar.HOUR_OF_DAY);
    int min = fecha.get(Calendar.MINUTE);
    String day = c.DiaEnLetras(dia);
    String Mes = c.MesEnLetras(mes);
    String fechaS = dia + " / " + Mes + " / " + año + " / " + hora + ":" + min;

    public Actividades() {

        initComponents();
        this.setLocationRelativeTo(null);

        ImageIcon FondoDePantalla = new ImageIcon(ruta);
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Background.getWidth(),
                Background.getHeight(), Image.SCALE_DEFAULT));
        Background.setIcon(icono);
        
        //aca se colocan las imagenes en los Stiquer
        ImageIcon Stiq = new ImageIcon("src/IMG/Registraractividad.png");
        Icon icono2 = new ImageIcon(Stiq.getImage().getScaledInstance(Stiquer.getWidth(),
                Stiquer.getHeight(), Image.SCALE_DEFAULT));
        Stiquer.setIcon(icono2);
        
        

        for (int i = 1; i <= 31; i++) {
            DiaInicio.addItem(String.valueOf(i));
            DiaFinal.addItem(String.valueOf(i));

        }
        for (int i = 0; i < 13; i++) {
            MesInicio.addItem(String.valueOf(i));
            MesFinal.addItem(String.valueOf(i));

        }
        for (int i = 1999; i <= año; i++) {
            AñoInicio.addItem(String.valueOf(i));
            AñoFinal.addItem(String.valueOf(i));
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NombreAct = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        MesInicio = new javax.swing.JComboBox<>();
        AñoInicio = new javax.swing.JComboBox<>();
        DiaInicio = new javax.swing.JComboBox<>();
        AñoFinal = new javax.swing.JComboBox<>();
        DiaFinal = new javax.swing.JComboBox<>();
        MesFinal = new javax.swing.JComboBox<>();
        Stiquer = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRAR ACTIVIDAD ESCOLAR.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 750, 40));

        jLabel1.setText("DESCRIBE LA ACTIVIDAD:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));
        getContentPane().add(NombreAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 200, 30));

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        jScrollPane1.setViewportView(Descripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 280, 130));

        jLabel3.setText("NOMBRE DE LA ACTIVIDAD:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel4.setText("FECHA DE INICIO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel5.setText("FECHA DE CULMINACION:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jButton1.setText("Cancelar.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 150, 35));

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 150, 35));

        jButton3.setText("Registrar aporte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 150, 35));

        MesInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes" }));
        getContentPane().add(MesInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 70, -1));

        AñoInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año" }));
        getContentPane().add(AñoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 70, -1));

        DiaInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia" }));
        getContentPane().add(DiaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 70, -1));

        AñoFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año" }));
        getContentPane().add(AñoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 70, -1));

        DiaFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia" }));
        getContentPane().add(DiaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 70, -1));

        MesFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes" }));
        getContentPane().add(MesFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 70, -1));

        Stiquer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Registrar(evt);
            }
        });
        getContentPane().add(Stiquer, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 130, 130));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int validacion = 0;
        String diainicio = DiaInicio.getSelectedItem().toString(),
                mesinicio = MesInicio.getSelectedItem().toString(),
                añoinicio = AñoInicio.getSelectedItem().toString(),
                diafinal = DiaFinal.getSelectedItem().toString(),
                mesfinal = MesFinal.getSelectedItem().toString(),
                añofinal = AñoFinal.getSelectedItem().toString();
        b[0] = NombreAct.getText().trim();
        b[1] = diainicio + " - " + mesinicio + " - " + añoinicio;
        b[2] = diafinal + " - " + mesfinal + " - " + añofinal;
        b[3] = Descripcion.getText().trim();

        for (int i = 0; i <= 3; i++) {

            if (i == 0) {
                if ("".equals(b[i])) {
                    NombreAct.setBackground(new Color(255, 111, 94));
                    validacion++;
                }
            }

            if (i == 3) {
                if ("".equals(b[i])) {
                    Descripcion.setBackground(new Color(255, 111, 94));
                    validacion++;
                }
            }

        }

        if (diainicio.equals("Dia") || mesinicio.equals("Mes") || añoinicio.equals("Año")) {
            JOptionPane.showMessageDialog(null, "Seleccione fecha de Inicio");
            validacion++;
        }

        if (diafinal.equals("Dia") || mesfinal.equals("Mes") || añofinal.equals("Año")) {
            JOptionPane.showMessageDialog(null, "Seleccione fecha final.");
            validacion++;
        }

        if (validacion == 0) {
            try {
                Connection cn = ClaseMetodos.conectar();
                PreparedStatement pst2 = cn.prepareStatement("insert into actividades values "
                        + "(?,?,?, ?,?,?)");
                pst2.setInt(1, 0);
                pst2.setString(2, fechaS);
                pst2.setString(3, b[0]);
                pst2.setString(4, b[1]);
                pst2.setString(5, b[2]);
                pst2.setString(6, b[3]);
                pst2.executeUpdate();

                cn.close();
                JOptionPane.showMessageDialog(null, "Actividad registrada.");

                NombreAct.setText("");
                Descripcion.setText("");

            } catch (SQLException e) {
                validacion++;

                System.err.println("error al registrar alumno " + e);
                JOptionPane.showMessageDialog(null, "Error en el sistema contacte con el administrador.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA \n"
                    + "Los campos marcados con rojo son obligatorios.");
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        c.Salir();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int validacion = 0;
        b[0] = NombreAct.getText().trim();
        b[3] = Descripcion.getText().trim();

        for (int i = 0; i <= 4; i++) {

            if (i == 0) {
                if (!"".equals(b[i])) {
                    validacion++;
                }
            }
            
            
            if (i == 3) {
                if (!"".equals(b[i])) {
                    validacion++;
                }
            }

        }
        if (validacion == 0) {
            AporteDeActividad a = new AporteDeActividad();
            a.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "alerta la informacion se perdera");
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void Registrar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Registrar
        // TODO add your handling code here:
        
        // Aca se coloca el codigo del boton registrar para interctuar con el Stiquer
        
        int validacion = 0;
        String diainicio = DiaInicio.getSelectedItem().toString(),
                mesinicio = MesInicio.getSelectedItem().toString(),
                añoinicio = AñoInicio.getSelectedItem().toString(),
                diafinal = DiaFinal.getSelectedItem().toString(),
                mesfinal = MesFinal.getSelectedItem().toString(),
                añofinal = AñoFinal.getSelectedItem().toString();
        b[0] = NombreAct.getText().trim();
        b[1] = diainicio + " - " + mesinicio + " - " + añoinicio;
        b[2] = diafinal + " - " + mesfinal + " - " + añofinal;
        b[3] = Descripcion.getText().trim();

        for (int i = 0; i <= 3; i++) {

            if (i == 0) {
                if ("".equals(b[i])) {
                    NombreAct.setBackground(new Color(255, 111, 94));
                    validacion++;
                }
            }

            if (i == 3) {
                if ("".equals(b[i])) {
                    Descripcion.setBackground(new Color(255, 111, 94));
                    validacion++;
                }
            }

        }

        if (diainicio.equals("Dia") || mesinicio.equals("Mes") || añoinicio.equals("Año")) {
            JOptionPane.showMessageDialog(null, "Seleccione fecha de Inicio");
            validacion++;
        }

        if (diafinal.equals("Dia") || mesfinal.equals("Mes") || añofinal.equals("Año")) {
            JOptionPane.showMessageDialog(null, "Seleccione fecha final.");
            validacion++;
        }

        if (validacion == 0) {
            try {
                Connection cn = ClaseMetodos.conectar();
                PreparedStatement pst2 = cn.prepareStatement("insert into actividades values "
                        + "(?,?,?, ?,?,?)");
                pst2.setInt(1, 0);
                pst2.setString(2, fechaS);
                pst2.setString(3, b[0]);
                pst2.setString(4, b[1]);
                pst2.setString(5, b[2]);
                pst2.setString(6, b[3]);
                pst2.executeUpdate();

                cn.close();
                JOptionPane.showMessageDialog(null, "Actividad registrada.");

                NombreAct.setText("");
                Descripcion.setText("");

            } catch (SQLException e) {
                validacion++;

                System.err.println("error al registrar alumno " + e);
                JOptionPane.showMessageDialog(null, "Error en el sistema contacte con el administrador.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ALERTA \n"
                    + "Los campos marcados con rojo son obligatorios.");
        }

        
        
    }//GEN-LAST:event_Registrar

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
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AñoFinal;
    private javax.swing.JComboBox<String> AñoInicio;
    private javax.swing.JLabel Background;
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JComboBox<String> DiaFinal;
    private javax.swing.JComboBox<String> DiaInicio;
    private javax.swing.JComboBox<String> MesFinal;
    private javax.swing.JComboBox<String> MesInicio;
    private javax.swing.JTextField NombreAct;
    private javax.swing.JLabel Stiquer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
