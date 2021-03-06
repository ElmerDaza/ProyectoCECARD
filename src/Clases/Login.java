package Clases;

//import static Clases.ClaseMetodos.conectar;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    String title = "Por Favor Ingrese Usuario - Contraseña", ruta = "src/IMG/escudo.jpg";
    public static String Usuario, Contraseña;

    public Login() {

        initComponents();
        setLocationRelativeTo(null);
        setTitle(title);

        ImageIcon FondoDePantalla = new ImageIcon("src/IMG/fondo.png");
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Bakground.getWidth(),
                Bakground.getHeight(), Image.SCALE_DEFAULT));
        Bakground.setIcon(icono);

        ImageIcon escudo = new ImageIcon(ruta);
        Icon Icono = new ImageIcon(escudo.getImage().getScaledInstance(Escudo1.getWidth(),
                Escudo1.getHeight(), Image.SCALE_DEFAULT));
        Escudo1.setIcon(Icono);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Escudo1 = new javax.swing.JLabel();
        Bakground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 200, 25));

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 200, 25));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sofware De Manejo De Información");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 400, -1));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        jButton1.setText("Continuar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 405, 100, 25));
        getContentPane().add(Escudo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 200, 200));
        getContentPane().add(Bakground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int contador = 0;
        String Contraseña = "";
        try {

            //coneccion con base de datos
            Connection on = ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = on.prepareStatement(
                    "select * from usuarios where Nombres ='" + jTextField1.getText().trim() + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                Contraseña = rs.getString("Contraseña");

            } else {
                JOptionPane.showMessageDialog(null, "El usuario o contraseño no coinsiden");
            }

            if ("".equals(jPasswordField1.getText().trim())) {
                jPasswordField1.setBackground(Color.red);
                jPasswordField1.setForeground(Color.WHITE);
                contador++;
            }
            if ("".equals(jTextField1.getText().trim())) {
                jTextField1.setBackground(Color.red);
                jTextField1.setForeground(Color.WHITE);
                contador++;
            }
            if (contador == 0 && jPasswordField1.getText().equals(Contraseña)) {

                InterfazPrincipal I = new InterfazPrincipal();
                I.setVisible(true);
                Usuario = jTextField1.getText().trim();
                this.Contraseña = Contraseña;
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "El usuario o contraseño no coinsiden");
            }

        } catch (SQLException e) {
            System.out.println("errrooooo en login " + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Enter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Enter
        // TODO add your handling code here:

        //se introduce el codigo de el boton conectar.
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int contador = 0;
            String Contraseña = "";
            try {

                //coneccion con base de datos
                Connection on = ClaseMetodos.conectar();

                //esta linea de codigo le da las intrucciones a la base de datos
                PreparedStatement pst = on.prepareStatement(
                        "select * from usuarios where Nombres ='" + jTextField1.getText().trim() + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    Contraseña = rs.getString("Contraseña");

                } else {
                    JOptionPane.showMessageDialog(null, "El usuario o contraseño no coinsiden");
                }

                if ("".equals(jPasswordField1.getText().trim())) {
                    jPasswordField1.setBackground(Color.red);
                    jPasswordField1.setForeground(Color.WHITE);
                    contador++;
                }
                if ("".equals(jTextField1.getText().trim())) {
                    jTextField1.setBackground(Color.red);
                    jTextField1.setForeground(Color.WHITE);
                    contador++;
                }
                if (contador == 0 && jPasswordField1.getText().equals(Contraseña)) {

                    InterfazPrincipal I = new InterfazPrincipal();
                    I.setVisible(true);
                    Usuario = jTextField1.getText().trim();
                    this.Contraseña = Contraseña;
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario o contraseño no coinsiden");
                }

            } catch (SQLException e) {
                System.out.println("errrooooo en login " + e);
            }
        }

    }//GEN-LAST:event_Enter

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bakground;
    private javax.swing.JLabel Escudo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
