/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static Clases.ContinuarConsulta.user_update;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class AporteDeActividad extends javax.swing.JFrame {

    /**
     * Creates new form AporteDeActividad
     */
    String ruta = "src/IMG/FD0036-color.png", Info = "", b[] = new String[5];
    Metodos m = new Metodos();
    ClaseMetodos c = new ClaseMetodos();
    DefaultTableModel modelo = new DefaultTableModel();

    public AporteDeActividad() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon FondoDePantalla = new ImageIcon(ruta);
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Background.getWidth(),
                Background.getHeight(), Image.SCALE_DEFAULT));
        Background.setIcon(icono);

        try {

            Actividades.setModel(modelo);

            //coneccion con base de datos
            Connection on = ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = on.prepareStatement(
                    "SELECT ID_Alumnos, Nombre_Actividad, Fecha_Inicio, Fecha_Final,"
                    + " Descripcion_Actividad FROM actividades");

            ResultSet rs = pst.executeQuery();

            //establecer nombres de columnas
            modelo.addColumn("#");
            modelo.addColumn("ACTIVIDAD");
            modelo.addColumn("FECHA DE INICIO");
            modelo.addColumn("FECHA FINAL");
            modelo.addColumn("DESCRIPCION");

            ResultSetMetaData rsMd = rs.getMetaData();
            int CantidadDeColumnas = rsMd.getColumnCount();
            String[] filas = new String[CantidadDeColumnas];
            while (rs.next()) {

                for (int i = 0; i < CantidadDeColumnas; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        Actividades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filas_point = Actividades.rowAtPoint(e.getPoint());
                int columnas_point = 4;

                if (filas_point > -1) {
                    Concepto.setText((String) modelo.getValueAt(filas_point, columnas_point));
                    Info = (String) modelo.getValueAt(filas_point, columnas_point);
                    Concepto.setEditable(false);

                }

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        NombrePago = new javax.swing.JTextField();
        Valor = new javax.swing.JTextField();
        IdentificacionPago = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Concepto = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Actividades = new javax.swing.JTable();
        IdentificacionAlumno = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        Edad = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Grado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("x");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 35));

        jLabel2.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(251, 249, 250));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRAR INGRESO POR ACTIVIDAD ESCOLAR.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1010, 40));

        NombrePago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombrePagosoloLetras(evt);
            }
        });
        getContentPane().add(NombrePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 240, 30));

        Valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValorsoloNumeros(evt);
            }
        });
        getContentPane().add(Valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 240, 30));

        IdentificacionPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IdentificacionPagosoloNumeros(evt);
            }
        });
        getContentPane().add(IdentificacionPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 240, 30));

        Concepto.setBackground(new java.awt.Color(204, 204, 255));
        Concepto.setColumns(20);
        Concepto.setRows(5);
        jScrollPane1.setViewportView(Concepto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 220, 120));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(251, 249, 250));
        jLabel7.setText("INGRESE VALOR:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 268, 114, 21));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(251, 249, 250));
        jLabel5.setText("NOMBRE DE QUIEN REALIZA EL PAGO :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(251, 249, 250));
        jLabel11.setText("IDENTIFICACION:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 110, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(251, 249, 250));
        jLabel9.setText("CONCEPTO:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, -1, -1));

        Actividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Actividades);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 940, 130));

        IdentificacionAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IdentificacionAlumnosoloNumeros(evt);
            }
        });
        getContentPane().add(IdentificacionAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 240, 30));

        label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label.setForeground(new java.awt.Color(251, 249, 250));
        label.setText("IDENTIFICACION ALUMNO:");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 170, -1));

        Apellido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 380, -1, -1));

        Edad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 410, -1, -1));

        Nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 440, -1, -1));

        Grado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 350, -1, -1));

        jButton1.setText("Continuar.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 450, 220, 35));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombrePagosoloLetras(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombrePagosoloLetras
        // TODO add your handling code here:
        m.SoloLetras(evt);
    }//GEN-LAST:event_NombrePagosoloLetras

    private void ValorsoloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorsoloNumeros
        // TODO add your handling code here:
        m.SoloNumeros(evt);

    }//GEN-LAST:event_ValorsoloNumeros

    private void IdentificacionPagosoloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdentificacionPagosoloNumeros
        // TODO add your handling code here:
        m.SoloNumeros(evt);

    }//GEN-LAST:event_IdentificacionPagosoloNumeros

    private void IdentificacionAlumnosoloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdentificacionAlumnosoloNumeros
        // TODO add your handling code here:
        m.SoloNumeros(evt);
    }//GEN-LAST:event_IdentificacionAlumnosoloNumeros

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        InterfazPrincipal i = new InterfazPrincipal();
        this.setVisible(false);
        i.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        //Codigo Para generar Fecha.
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
        String day = c.DiaEnLetras(dia);
        String Mes = c.MesEnLetras(mes);
        String fechaS = dia + "/" + Mes + "/" + año + "/ " + hora + ":" + min;

        int validacion = 0;
        b[0] = NombrePago.getText().trim();
        b[1] = IdentificacionPago.getText().trim();
        b[2] = Valor.getText().trim();
        b[3] = IdentificacionAlumno.getText().trim();
        b[4] = Concepto.getText().trim();

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                if ("".equals(b[i])) {

                    NombrePago.setBackground(Color.red);
                    validacion++;
                }
            }
            if (i == 1) {
                if ("".equals(b[i])) {

                    IdentificacionPago.setBackground(Color.red);
                    validacion++;
                }
            }
            if (i == 2) {
                if ("".equals(b[i])) {

                    Valor.setBackground(Color.red);
                    validacion++;
                }
            }
            if (i == 3) {
                if ("".equals(b[i])) {

                    IdentificacionAlumno.setBackground(Color.red);
                    validacion++;
                }
            }
            if (i == 4) {
                if ("".equals(b[i])) {

                    Concepto.setBackground(Color.red);
                    validacion++;
                }
            }

        }

        if (validacion == 0) {
            //aca registra con la base de datos.

            try {

                //en las segundas comillas va el usuario de mysql y en las terceras va la contraseña.
                Connection cn = ClaseMetodos.conectar();

                //esta linea de codigo le da las intrucciones a la base de datos
                PreparedStatement pst = cn.prepareStatement("SELECT Fecha, Ingreso, Egreso, Saldo FROM contavilidad");
                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rsMd = rs.getMetaData();

                int CantidadDeColumnas = rsMd.getColumnCount(), contador = 0, cantFila = CantidadDeColumnas;

                String ob[] = new String[cantFila], saldo = "";
                while (rs.next()) {
                    for (int i = 0; i < CantidadDeColumnas; i++) {
                        ob[i] = rs.getString(i + 1);
                    }

                    contador = contador + 1;
                }
                pst = cn.prepareStatement("select * from contavilidad where ID_Contabilidad =" + contador);

                rs = pst.executeQuery();

                if (rs.next()) {
                    saldo = (rs.getString("Saldo"));
                }

                PreparedStatement pst2 = cn.prepareStatement("insert into contavilidad values "
                        + "(?,?,?, ?,?,?, ?,?,?)");
                pst2.setInt(1, 0);
                pst2.setString(2, fechaS);
                pst2.setString(3, b[4]);
                pst2.setString(4, b[2]);
                pst2.setString(5, "");
                if (contador == 0) {
                    saldo = "0";
                }
                int sald = Integer.parseInt(saldo.trim());
                int pagado = Integer.parseInt(b[2]);
                sald = sald + pagado;
                saldo = Integer.toString(sald);

                pst2.setString(6, saldo);
                pst2.setString(7, b[0]);
                pst2.setString(8, b[1]);
                String nombre = Nombre.getText();
                pst2.setString(9, nombre);

                pst2.executeUpdate();

                cn.close();
                JOptionPane.showMessageDialog(null,
                        "Registro Exitoso.");
                Clases.ClaseMetodos.Salir();
                this.setVisible(false);
            } catch (SQLException e) {
                validacion++;
                JOptionPane.showMessageDialog(null,
                        "Error en el sistema contacte con el administrador.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AporteDeActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AporteDeActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AporteDeActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AporteDeActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AporteDeActividad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Actividades;
    private javax.swing.JLabel Apellido;
    private javax.swing.JLabel Background;
    private javax.swing.JTextArea Concepto;
    private javax.swing.JLabel Edad;
    private javax.swing.JLabel Grado;
    private javax.swing.JTextField IdentificacionAlumno;
    private javax.swing.JTextField IdentificacionPago;
    private javax.swing.JLabel Nombre;
    private javax.swing.JTextField NombrePago;
    private javax.swing.JTextField Valor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
