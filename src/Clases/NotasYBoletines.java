package Clases;

import static Clases.ClaseMetodos.conectar;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class NotasYBoletines extends javax.swing.JFrame {

    // conexion con la claseNotas}
    ClaseNotas C = new ClaseNotas();
    //Conexion con la clase Metodos
    Metodos m = new Metodos();
    //variable Para validar los campos.
    String b[] = new String[22];

    String Alumno[] = new String[1];
    //Conexion con la clase ClaseMetodos.
    ClaseMetodos c = new ClaseMetodos();
    
    
    int SiguienteColumnas = 1;

    int SiguienteFilas = 1, valorf = 0, valor = 0;
    //variables para utilizar la informacion de la ventana GenerarDocumentos
    static String Ident="", grado="", nombre="", apellido="";
    //variable para saber si es de primaria o infantil.
    boolean Primaria = false;
    // variables para obtener elperiodo.
    String periodo = "", periodo2 = "", periodo3 = "", periodo4 = "";

    //codigo para obtener la fecha.
    Calendar fecha = Calendar.getInstance();
    int año = fecha.get(Calendar.YEAR);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    int mes = fecha.get(Calendar.MONTH);
    int hora = fecha.get(Calendar.HOUR_OF_DAY);
    int min = fecha.get(Calendar.MINUTE);

    /**
     * Creates new form NotasYBoletines
     */
    public NotasYBoletines() {
        initComponents();
        MetodoDeInformacion();
        this.setLocationRelativeTo(null);

        //Fondo de Pantalla.
        ImageIcon FondoDePantalla = new ImageIcon("src/IMG/redgeometria.jpg");
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Background.getWidth(),
                Background.getHeight(), Image.SCALE_DEFAULT));
        Background.setIcon(icono);

    }
    //metodo que determina campos a mostrar
    @SuppressWarnings("unchecked")
    public void MetodoDeInformacion(){
        
        //el campo de identeficacion no se debe modificar.
        //se introduce datos
        ID.setText(c.Ident);
        ID.setEditable(false);
        Grado.setText(c.grado);
        Nombre.setText(c.nombre);
        Apellido.setText(c.apellido);

        //se establecen los campos que seran visibles
        //dependiendo de el grado.
        //y se establece el balor de primaria
        if ("Maternal".equals(Grado.getText())
                || "Parvulo".equals(Grado.getText())
                || "Pre-Jardin".equals(Grado.getText())
                || "Jardin".equals(Grado.getText())
                || "Trancision".equals(Grado.getText())) {

            //se esconden los campos sobrantes
            Campo11.setVisible(false);
            Campo12.setVisible(false);
            Campo13.setVisible(false);
            Campo14.setVisible(false);
            
            //se establesen el titulo a cada campo
            Titulo1.setText("Dim. Cognitiva");
            Titulo2.setText("Dim. Comunicativa");
            Titulo3.setText("Dim. Socioafectiva");
            Titulo4.setText("Dim. Corporal");
            Titulo5.setText("Dim. Etica Y Valores");
            Titulo6.setText("Dim. Estetica");
            Titulo7.setText("Idiomas");
            Titulo8.setText("Edu. Cristiana");
            Titulo9.setText("Informatica");
            Titulo10.setText("Comportamiento");

        } else {
            //se especifica que el alumno es de primaria
            Primaria = true;
            
            //se establesen el titulo a cada campo
            Titulo1.setText("Matematicas");
            Titulo2.setText("Geometria");
            Titulo3.setText("Castellano");
            Titulo4.setText("Ingles");
            Titulo5.setText("Naturales");
            Titulo6.setText("Ciencia Social");
            Titulo7.setText("Constitucion");
            Titulo8.setText("Etica Y Valores");
            Titulo9.setText("Artistica");
            Titulo10.setText("Catedra de Paz");
            Titulo11.setText("Edu. Cristiana");
            Titulo12.setText("Edu. Fisica");
            Titulo13.setText("Informatica");
            Titulo14.setText("Comportamiento");
            
            
        }

        

    }//metododeinformacion
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
        jLabel6 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        FallasS = new javax.swing.JTextField();
        PeriodoCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Observaciones = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Grado = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        FallasJ = new javax.swing.JTextField();
        Campo2 = new javax.swing.JTextField();
        Campo7 = new javax.swing.JTextField();
        Campo3 = new javax.swing.JTextField();
        Campo8 = new javax.swing.JTextField();
        Campo4 = new javax.swing.JTextField();
        Campo9 = new javax.swing.JTextField();
        Campo10 = new javax.swing.JTextField();
        Campo5 = new javax.swing.JTextField();
        Campo1 = new javax.swing.JTextField();
        Campo6 = new javax.swing.JTextField();
        Titulo6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Titulo2 = new javax.swing.JLabel();
        Titulo7 = new javax.swing.JLabel();
        Titulo3 = new javax.swing.JLabel();
        Titulo4 = new javax.swing.JLabel();
        Titulo8 = new javax.swing.JLabel();
        Titulo9 = new javax.swing.JLabel();
        Titulo10 = new javax.swing.JLabel();
        Titulo5 = new javax.swing.JLabel();
        Titulo1 = new javax.swing.JLabel();
        Campo11 = new javax.swing.JTextField();
        Campo12 = new javax.swing.JTextField();
        Campo13 = new javax.swing.JTextField();
        Campo14 = new javax.swing.JTextField();
        Titulo16 = new javax.swing.JLabel();
        Titulo11 = new javax.swing.JLabel();
        Titulo12 = new javax.swing.JLabel();
        Titulo17 = new javax.swing.JLabel();
        Titulo18 = new javax.swing.JLabel();
        Titulo13 = new javax.swing.JLabel();
        Titulo14 = new javax.swing.JLabel();
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
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOTAS Y BOLETINES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 890, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(251, 249, 250));
        jLabel6.setText("Identificacion de alumno");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        ID.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 200, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(251, 249, 250));
        jLabel8.setText("Fallas sin Justificar.");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, -1, -1));

        FallasS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });
        getContentPane().add(FallasS, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 165, 30));

        PeriodoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3", "4" }));
        getContentPane().add(PeriodoCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 165, 30));

        Observaciones.setColumns(20);
        Observaciones.setRows(5);
        jScrollPane1.setViewportView(Observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 570, 200, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(251, 249, 250));
        jLabel10.setText("Fallas Justificadas.");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, -1, -1));

        jButton1.setText("CONTINUAR.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 650, 200, 60));

        Grado.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(Grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));

        Nombre.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 185, -1, -1));

        Apellido.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));
        getContentPane().add(FallasJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 165, 30));
        getContentPane().add(Campo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 100, 30));

        Campo7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Campo7soloNumeros(evt);
            }
        });
        getContentPane().add(Campo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 100, 30));
        getContentPane().add(Campo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 100, 30));

        Campo8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Campo8soloNumeros(evt);
            }
        });
        getContentPane().add(Campo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 100, 30));
        getContentPane().add(Campo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 100, 30));

        Campo9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Campo9soloNumeros(evt);
            }
        });
        getContentPane().add(Campo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 100, 30));
        getContentPane().add(Campo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, 100, 30));

        Campo5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Campo5soloNumeros(evt);
            }
        });
        getContentPane().add(Campo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 100, 30));
        getContentPane().add(Campo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 100, 30));

        Campo6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Campo6soloNumeros(evt);
            }
        });
        getContentPane().add(Campo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 100, 30));

        Titulo6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo6.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(251, 249, 250));
        jLabel7.setText("Observaciones.");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, -1, -1));

        Titulo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo2.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        Titulo7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo7.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, -1));

        Titulo3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo3.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));

        Titulo4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo4.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, -1, -1));

        Titulo8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo8.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, -1));

        Titulo9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo9.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, -1, -1));

        Titulo10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo10.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, -1, -1));

        Titulo5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo5.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, -1));

        Titulo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo1.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));
        getContentPane().add(Campo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 100, 30));
        getContentPane().add(Campo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 100, 30));
        getContentPane().add(Campo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 100, 30));
        getContentPane().add(Campo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 100, 30));

        Titulo16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo16.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, -1, -1));

        Titulo11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo11.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        Titulo12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo12.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, -1, -1));

        Titulo17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo17.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, -1, -1));

        Titulo18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo18.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo18, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, -1, -1));

        Titulo13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo13.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, -1, -1));

        Titulo14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo14.setForeground(new java.awt.Color(251, 249, 250));
        getContentPane().add(Titulo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, -1, -1));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton para cerrar la ventana.
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        GeneraDocumentos i = new GeneraDocumentos();
        i.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton3ActionPerformed

    //Metodo para evitar las letrar en el campo.
    private void soloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soloNumeros
        // TODO add your handling code here:
        m.SoloNumeros(evt);
    }//GEN-LAST:event_soloNumeros

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int validacion = 0;

        String day = c.DiaEnLetras(dia);
        String Mes = c.MesEnLetras(mes);
        String f = dia + "/" + Mes + "/" + año + "/ " + hora + ":" + min;

        //se obtienen la informacion de los campos
        b[0] = Campo1.getText().trim();
        b[1] = Campo2.getText().trim();
        b[2] = Campo3.getText().trim();
        b[3] = Campo4.getText().trim();
        b[8] = Campo5.getText().trim();
        b[9] = Campo6.getText().trim();
        b[10] = Campo7.getText().trim();
        b[11] = Campo8.getText().trim();
        b[12] = Campo9.getText().trim();
        b[13] = Campo10.getText().trim();
        b[14] = Campo11.getText().trim();
        b[15] = Campo12.getText().trim();
        b[16] = Campo13.getText().trim();
        b[17] = Campo14.getText().trim();
        b[18]= ID.getText().trim();
        b[19]= Grado.getText();
        b[4] = PeriodoCombo.getSelectedItem().toString();
        b[5] = Observaciones.getText().trim();
        b[6] = FallasJ.getText().trim();
        b[7] = FallasS.getText().trim();

        //Validacion FallasS
        if (b[7].equals("")) {
            FallasS.setBackground(Color.PINK);
            FallasS.setForeground(Color.WHITE);
            validacion++;
        }
        //Validacion de periodo
        if ("Seleccione".equals(b[4])) {
            validacion++;
        }
        //Validacion FallasJ
        if ("".equals(b[6])) {
            FallasJ.setBackground(Color.PINK);
            FallasJ.setForeground(Color.WHITE);
            validacion++;
        }
        if (PeriodoCombo.getSelectedIndex() == 0) {
            validacion++;
            JOptionPane.showMessageDialog(null, "seleccione periodo.");
        }
        //Validacion de campo1
        if ("".equals(b[0])) {
            Campo1.setBackground(Color.red);
            Campo1.setForeground(Color.WHITE);
            validacion++;
        }
        //Validacion Campo2
        if ("".equals(b[1])) {
            Campo2.setBackground(Color.red);
            Campo2.setForeground(Color.WHITE);
            validacion++;
        }
        //Validacion Campo3
        if ("".equals(b[2])) {
            Campo3.setBackground(Color.red);
            Campo3.setForeground(Color.WHITE);
            validacion++;
        }
        //Validacion Campo4
        if ("".equals(b[3])) {
            Campo4.setBackground(Color.red);
            Campo4.setForeground(Color.WHITE);
            validacion++;
        }
        //Validacion Campo5
        if ("".equals(b[8])) {
            Campo5.setBackground(Color.red);
            Campo5.setForeground(Color.WHITE);
            validacion++;
        }
        //Validacion Campo6
        if ("".equals(b[9])) {
            Campo6.setBackground(Color.red);
            Campo6.setForeground(Color.WHITE);
            validacion++;
        }
        //Validacion Campo7
        if ("".equals(b[10])) {
            Campo7.setBackground(Color.red);
            Campo7.setForeground(Color.WHITE);
            validacion++;
        }
        //Validacion Campo8
        if ("".equals(b[11])) {
            Campo8.setBackground(Color.red);
            Campo8.setForeground(Color.WHITE);
            validacion++;
        }
        //Validacion Campo9
        if ("".equals(b[12])) {
            Campo9.setBackground(Color.red);
            Campo9.setForeground(Color.WHITE);
            validacion++;
        }
        
        //se valida los campos de primaria
        if (Primaria == true) {

            //Validacion Campo10
            if ("".equals(b[13])) {
                Campo10.setBackground(Color.red);
                Campo10.setForeground(Color.WHITE);
                validacion++;
            }
            //Validacion Campo11
            if ("".equals(b[14])) {
                Campo11.setBackground(Color.red);
                Campo11.setForeground(Color.WHITE);
                validacion++;
            }
            //Validacion Campo12
            if ("".equals(b[15])) {
                Campo12.setBackground(Color.red);
                Campo12.setForeground(Color.WHITE);
                validacion++;
            }
            //Validacion Campo13
            if ("".equals(b[16])) {
                Campo13.setBackground(Color.red);
                Campo13.setForeground(Color.WHITE);
                validacion++;
            }
            //Validacion Campo14
            if ("".equals(b[17])) {
                Campo14.setBackground(Color.red);
                Campo14.setForeground(Color.WHITE);
                validacion++;
            }

        }
        //Validacion de observaciones
        if ("".equals(b[5])) {
            Observaciones.setBackground(Color.red);
            Observaciones.setForeground(Color.WHITE);
            validacion++;
        }
        //se valida que este vacio la informacion de periodo1
        if ("Listo".equals(periodo) && PeriodoCombo.getSelectedIndex() == 1) {
            JOptionPane.showMessageDialog(null,
                    "este periodo ya se registró 1");
            validacion++;
        }
        //se valida que este vacio la informacion de periodo2
        if ("Listo".equals(periodo2) && PeriodoCombo.getSelectedIndex() == 2) {
            JOptionPane.showMessageDialog(null,
                    "este periodo ya se registró 2");
            validacion++;
        }
        //se valida que este vacio la informacion de periodo3
        if ("Listo".equals(periodo3) && PeriodoCombo.getSelectedIndex() == 3) {
            JOptionPane.showMessageDialog(null,
                    "este periodo ya se registró 3");
            validacion++;
        }
        //se valida que este vacio la informacion de periodo4
        if ("Listo".equals(periodo4) && PeriodoCombo.getSelectedIndex() == 4) {
            JOptionPane.showMessageDialog(null,
                    "este periodo ya se registró 4");
            validacion++;
        }

        //campos validados y llenos
        if (validacion == 0) {
            //este metodo consulta el periodo
            Documento();
            //este metodo registra los datos
            C.RegistrarNotas(b,Primaria,periodo,periodo2,periodo3,periodo4);
            
            //se crean los boletines
            Clases.ClaseNotas c = new Clases.ClaseNotas();
            
            // se crea periodo en estring
            String per = "";
            if("1".equals(PeriodoCombo.getSelectedItem().toString())){
                per = "PRIMERO";
            } else if("2".equals(PeriodoCombo.getSelectedItem().toString())){
                per = "SEGUNDO";
            } else if ("3".equals(PeriodoCombo.getSelectedItem().toString())){
                per = "TERCERO";
            } else if ("4".equals(PeriodoCombo.getSelectedItem().toString())){
                per = "CUARTO";
            }
            if(Primaria == true){
                c.CrearBoletinPrimaria(ID.getText(),per);
            }else{
                c.CrearBoletinTrancision(ID.getText(),per);
            }
        
            InterfazPrincipal i = new InterfazPrincipal();
            i.setVisible(true);
            this.setVisible(false);
        
        
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void Campo7soloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Campo7soloNumeros
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo7soloNumeros

    private void Campo8soloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Campo8soloNumeros
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo8soloNumeros

    private void Campo9soloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Campo9soloNumeros
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo9soloNumeros

    private void Campo5soloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Campo5soloNumeros
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo5soloNumeros

    private void Campo6soloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Campo6soloNumeros
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo6soloNumeros

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
            java.util.logging.Logger.getLogger(NotasYBoletines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotasYBoletines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotasYBoletines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotasYBoletines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotasYBoletines().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Apellido;
    private javax.swing.JLabel Background;
    public static javax.swing.JTextField Campo1;
    public static javax.swing.JTextField Campo10;
    public static javax.swing.JTextField Campo11;
    public static javax.swing.JTextField Campo12;
    public static javax.swing.JTextField Campo13;
    public static javax.swing.JTextField Campo14;
    public static javax.swing.JTextField Campo2;
    public static javax.swing.JTextField Campo3;
    public static javax.swing.JTextField Campo4;
    public static javax.swing.JTextField Campo5;
    public static javax.swing.JTextField Campo6;
    public static javax.swing.JTextField Campo7;
    public static javax.swing.JTextField Campo8;
    public static javax.swing.JTextField Campo9;
    public static javax.swing.JTextField FallasJ;
    private javax.swing.JTextField FallasS;
    public static javax.swing.JLabel Grado;
    public static javax.swing.JTextField ID;
    public static javax.swing.JLabel Nombre;
    private javax.swing.JTextArea Observaciones;
    private javax.swing.JComboBox<String> PeriodoCombo;
    public static javax.swing.JLabel Titulo1;
    public static javax.swing.JLabel Titulo10;
    public static javax.swing.JLabel Titulo11;
    public static javax.swing.JLabel Titulo12;
    public static javax.swing.JLabel Titulo13;
    public static javax.swing.JLabel Titulo14;
    public static javax.swing.JLabel Titulo16;
    public static javax.swing.JLabel Titulo17;
    public static javax.swing.JLabel Titulo18;
    public static javax.swing.JLabel Titulo2;
    public static javax.swing.JLabel Titulo3;
    public static javax.swing.JLabel Titulo4;
    public static javax.swing.JLabel Titulo5;
    public static javax.swing.JLabel Titulo6;
    public static javax.swing.JLabel Titulo7;
    public static javax.swing.JLabel Titulo8;
    public static javax.swing.JLabel Titulo9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void Documento() {

        //Consultar que periodo este lleno En los que no son primaria.
        if (Primaria == false) {

            try {
                //se consulta en la tabla notas.
                Connection cn = ClaseMetodos.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from notas where ID_Alumno ='" + b[18] + "'");
                ResultSet rs = pst.executeQuery();

                //se guarda el resultado el las variables periodo
                if (rs.next()) {

                    periodo = (rs.getString("Periodo1"));
                    periodo2 = (rs.getString("Periodo2"));
                    periodo3 = (rs.getString("Periodo3"));
                    periodo4 = (rs.getString("Periodo4"));

                    cn.close();
                    

                } else {
                    JOptionPane.showMessageDialog(null, "este alumno no esta registrado en notas");
                    periodo = "vacio";
                    periodo2 = "vacio";
                    periodo3 = "vacio";
                    periodo4 = "vacio";
                }
            } catch (Exception e) {
                System.out.println("este fallo  " + e);
            }
        } else {
            try {
                //se consulta en la tabla notas.
                Connection cn = ClaseMetodos.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from notas_primaria where ID_Alumno ='" + b[18] + "'");
                ResultSet rs = pst.executeQuery();

                //se guarda el resultado el las variables periodo
                if (rs.next()) {

                    periodo = (rs.getString("Periodo1"));
                    periodo2 = (rs.getString("Periodo2"));
                    periodo3 = (rs.getString("Periodo3"));
                    periodo4 = (rs.getString("Periodo4"));

                    cn.close();
                    

                } else {
                    JOptionPane.showMessageDialog(null, "este alumno no esta registrado en\n notas_primaria");
                    periodo = "vacio";
                    periodo2 = "vacio";
                    periodo3 = "vacio";
                    periodo4 = "vacio";
                }
            } catch (Exception e) {
                System.out.println("este fallo  " + e);
            }
        }
    }

    

}//clase
