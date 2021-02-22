package Clases;

//imports
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import java.awt.event.ActionEvent;
import java.io.FileOutputStream;

public class GeneraDocumentos extends javax.swing.JFrame {

    //variable para asignar tipo de documento del alumno
    //query se utiliza para filtrar con el jcombo box
    String Tipo_Documento, query;
    //Conexion con la clase Metodos
    Metodos m = new Metodos();
    //Conexion con la clase ClaseMetodos
    ClaseMetodos c = new ClaseMetodos();
    //Variable para la tabla y se declara aquí para poder filtrar
    DefaultTableModel modelo = new DefaultTableModel();
    //variable para boletines
    //para enviar documento a la ventana boletines
    protected String ident = "";

    //codigo para obtener la fecha
    Calendar fecha = Calendar.getInstance();
    int año = fecha.get(Calendar.YEAR);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    int mes = fecha.get(Calendar.MONTH);
    String day = c.DiaEnLetras(dia);
    String Mes = c.MesEnLetras(mes);

    //variables a utilizar en los documentos 
    //para obtener la informacion de alumno
    String nombre;
    String apellido;
    String edad;
    String id;
    String grado;

    public GeneraDocumentos() {

        initComponents();

        // esta linea ayuda a filtrar la tabla con el jComboBox1
        query = jComboBox1.getSelectedItem().toString();

        setLocationRelativeTo(null);
        setTitle("Generar Documento.");

        //fondo de pantalla en un jLabel
        ImageIcon FondoDePantalla = new ImageIcon("src/IMG/gradient-red (2).png");
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Background.getWidth(),
                Background.getHeight(), Image.SCALE_DEFAULT));
        Background.setIcon(icono);
        this.repaint();

        //aca se colocan las imagenes en los Stiquer
        ImageIcon Stiq = new ImageIcon("src/IMG/document.png");
        Icon icono2 = new ImageIcon(Stiq.getImage().getScaledInstance(Stiquer.getWidth(),
                Stiquer.getHeight(), Image.SCALE_DEFAULT));
        Stiquer.setIcon(icono2);

        //listado de alumnos
        try {

            jTable1.setModel(modelo);

            //coneccion con base de datos
            Connection on = ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = on.prepareStatement(
                    "SELECT Apellidos, Nombres, Grado, Edad, Documento, Tipo_Documento FROM alumnos");

            ResultSet rs = pst.executeQuery();

            //establecer nombres de columnas
            modelo.addColumn("APELLIDOS");
            modelo.addColumn("NOMBRES");
            modelo.addColumn("GRADO");
            modelo.addColumn("EDAD");
            modelo.addColumn("DOCUMENTO");
            modelo.addColumn("TD");

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
            System.out.println("error en la tabla " + e);
        }

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filas_point = jTable1.rowAtPoint(e.getPoint());
                //int columnas_point = 5;

                if (filas_point > -1) {
                    Apellido.setText((String) modelo.getValueAt(filas_point, 0));
                    Nombre.setText((String) modelo.getValueAt(filas_point, 1));
                    Grado.setText((String) modelo.getValueAt(filas_point, 2));
                    Edad.setText((String) modelo.getValueAt(filas_point, 3));
                    ID.setText((String) modelo.getValueAt(filas_point, 4));
                    Tipo_Documento = ((String) modelo.getValueAt(filas_point, 5));

                    // se envia el numero ID y el grado A la ClaseMetodos
                    //Ident="", grado="", nombre="", apellido="";
                    c.Ident = ID.getText();
                    c.grado = (Grado.getText());
                    //se envia Nombre a la ventana Bolertines
                    c.nombre = (Nombre.getText());
                    c.apellido = (Apellido.getText());

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

        jLabel2 = new javax.swing.JLabel();
        Stiquer = new javax.swing.JLabel();
        Asistencia = new javax.swing.JButton();
        Comportamiento = new javax.swing.JButton();
        PazYSalvo = new javax.swing.JButton();
        CursoYAprobo = new javax.swing.JButton();
        ListAlumnos = new javax.swing.JButton();
        MovimientoFinanciero = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        Edad = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Grado = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONTROL DE DOCUMENTOS.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 900, -1));

        //Stiquer
        getContentPane().add(Stiquer, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 150, 150));

        Asistencia.setText("Asistencia");
        Asistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsistenciaActionPerformed(evt);
            }
        });
        getContentPane().add(Asistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 100, 100));

        Comportamiento.setText("Comportamiento y diciplina");
        Comportamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComportamientoActionPerformed(evt);
            }
        });
        getContentPane().add(Comportamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 100, 100));

        PazYSalvo.setText("Paz y Salvo");
        PazYSalvo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PazYSalvoActionPerformed(evt);
            }
        });
        getContentPane().add(PazYSalvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 100, 100));

        CursoYAprobo.setText("Cursó y Aprovó");
        CursoYAprobo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CursoYAproboActionPerformed(evt);
            }
        });
        getContentPane().add(CursoYAprobo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 100, 100));

        ListAlumnos.setText("Alumnos");
        ListAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListAlumnosActionPerformed(evt);
            }
        });
        getContentPane().add(ListAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(
                550, 590, 100, 35));

        MovimientoFinanciero.setText("Movimientos financieros.");
        MovimientoFinanciero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MovimientoFinancieroActionPerformed(evt);
            }
        });
        getContentPane().add(MovimientoFinanciero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 100, 100));

        jButton6.setText("Boletines\ny notas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);

            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 100, 100));

        BotonSalir.setText("x");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(BotonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 35));

        jLabel3.setFont(new java.awt.Font("Broadway", 1, 14)); // NOI18N
        jLabel3.setText("IDENTIFICACION :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 160, 30));

        ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }

            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
            }
        });
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 150, 160, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Seleccione", "Maternal", "Parvulo", "Pre-Jardin", "Jardin", "Trancision", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto"}));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 180, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {},
                    {},
                    {},
                    {}
                },
                new String[]{}
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 220, 390, 190));

        jButton8.setText("Buscar.");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 90, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(251, 249, 250));
        jLabel1.setText("NOMBRES.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(251, 249, 250));
        jLabel4.setText("APELLIDOS.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(251, 249, 250));
        jLabel6.setText("EDAD.");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        Nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        Apellido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        Edad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(251, 249, 250));
        jLabel7.setText("GRADO.");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, -1));

        Grado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, -1, -1));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton de sierre de la ventana
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        InterfazPrincipal i = new InterfazPrincipal();
        this.setVisible(false);
        i.setVisible(true);

    }//GEN-LAST:event_jButton7ActionPerformed

    //Boton de abrir ventana de Notas y Boletines.
    private void jButton6ActionPerformed(java.awt.event.ActionEvent ent) {

        ident = ID.getText().trim();
        String nom = Nombre.getText();
        // se envia el numero de documento del alumno
        // a la ventana Boletines verificando que no este bacia ni nula
        if (!"".equals(ident) && !nom.equals("")) {

            // se crea objeto de la clase NotasYBoletines
            NotasYBoletines n = new NotasYBoletines();
            // se envia el numero ID y el grado A la ventana Boletines
            //Ident="", grado="", nombre="", apellido="";
            c.Ident = (ident);
            c.grado = (Grado.getText());
            //se envia Nombre a la ventana Bolertines
            c.nombre = (Nombre.getText());
            c.apellido = (Apellido.getText());

            // se hace visible la ventana Boletines
            n.setVisible(true);

            //se sierra la ventana actual
            this.setVisible(false);

        } else {
            //se envia mensaje si esta vacio el campo
            JOptionPane.showMessageDialog(null,
                    "Debes consultar un numero de identificacion");
            //se coloca el campo en rojo
            ID.setBackground(Color.red);
        }
    }

    //Aca se Filtra la Tabla con el jComboBox De los Cursos.
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:

        //esta linea se comento porque se declaró en el initComponent
        query = jComboBox1.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        jTable1.setRowSorter(tr);

        if (query != "Seleccione") {
            tr.setRowFilter(RowFilter.regexFilter(query));
        } else {
            jTable1.setRowSorter(tr);

        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    //Boton para buscar el numero de documento en la base de datos y Mostrarlos en Los elementos
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        ident = ID.getText();

        if (ident != "" || ident != null) {
            try {

                //Conexion con base de datos.
                Connection cn = ClaseMetodos.conectar();

                //esta linea de codigo le da las intrucciones a la base de datos
                PreparedStatement pst = cn.prepareStatement("select * from alumnos where Documento = ?");

                pst.setString(1, ID.getText());
                ResultSet rs = pst.executeQuery();

                // con este codigo intento obtener los balores almacenados en la base de datos registro
                if (rs.next()) {

                    //Aca se llenan los elementos Con la informacion de la base de datos Registro
                    Apellido.setText(rs.getString("Apellidos"));
                    Nombre.setText(rs.getString("Nombres"));
                    Edad.setText(rs.getString("Edad"));
                    Tipo_Documento = (rs.getString("Tipo_Documento"));
                    Grado.setText(rs.getString("Grado"));

                    // se envia el numero ID y el grado A la ClaseMetodos
                    //Ident="", grado="", nombre="", apellido="";
                    c.Ident = ID.getText();
                    c.grado = (Grado.getText());
                    //se envia Nombre a la ventana Bolertines
                    c.nombre = (Nombre.getText());
                    c.apellido = (Apellido.getText());

                } else {
                    JOptionPane.showMessageDialog(null, "No coincide el numero: "
                            + ID.getText().trim() + " \n con los datos almacenados");
                }

            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes introducir un numero de identificacion");
            ID.setBackground(Color.red);
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    //Metodo para Impedir las letras en El jTextFaild Que se encuentra en la clase Metodos
    private void soloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soloNumeros
        // TODO add your handling code here:
        m.SoloNumeros(evt);
    }//GEN-LAST:event_soloNumeros

    //boton para generar documento con listado de alumnos.
    private void ListAlumnosActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            //Conexxion con la base de datos
            Connection on2 = ClaseMetodos.conectar();
            PreparedStatement pst2 = on2.prepareStatement(
                    "select Apellidos, Nombres, Documento, Tipo_Documento, Sexo, "
                    + "Fecha_De_Ingreso, Matricula, Padre, Cedula_Padre, Direccion_Padre,"
                    + " Telefono_Padre, Madre, Cedula_Madre, Direccion_Madre, Telefono_Madre, "
                    + "Acudiente, Direccion_Acudiente, Telefono_Acudiente, Cedula_Acudiente,"
                    + "Edad, RH, Valor_Pension, Grado from alumnos");//23

            String iny[] = new String[23];
            iny[0] = "Apellidos";
            iny[1] = "Nombres";
            iny[2] = "Documento";
            iny[3] = "Tipo_Documento";
            iny[4] = "Sexo";
            iny[5] = "Fecha_De_Ingreso";
            iny[6] = "Matricula";
            iny[7] = "Padre";
            iny[8] = "Cedula_Padre";
            iny[8] = "Direccion_Padre";
            iny[10] = "Telefono_Padre";
            iny[11] = "Madre";
            iny[12] = "Cedula_Madre";
            iny[13] = "Direccion_Madre";
            iny[14] = "Telefono_Madre";
            iny[15] = "Acudiente";
            iny[16] = "Direccion_Acudiente";
            iny[17] = "Telefono_Acudiente";
            iny[18] = "Cedula_Acudiente";
            iny[19] = "Edad";
            iny[20] = "RH";
            iny[21] = "Valor_Pension";
            iny[22] = "Grado";
            ResultSet rs2 = pst2.executeQuery();
            //se crea la variabre a llenar
            String Informacion[][] = new String[m.CantRegistros() + 1][27];

            //llenar la matriz con los datos de la consulta
            if (rs2.next()) {
                //se llena la variable con el resultado de la base de datos.
                for (int i = 0; i < m.CantRegistros()/*cantidad de filas*/; i++) {
                    for (int j = 0; j < 27/*cantidad de columnas*/ ; j++) {
                        Informacion[i][j] = rs2.getString(iny[j]);
                    }

                }

            }
            //ruta donde se guardara el documento incluida la extencion.
            String ruta = System.getProperty("user.home")
                    + "/Documents/PrimerosProgramasEnNetBeans/ProyectoCECARD2000"
                    + "/documentosPDF/Listado_Alumnos" + Mes + ".xls";
            //metodo que crea el documento en exel
            m.CrearListadoAlumnos(Informacion, ruta);
            JOptionPane.showMessageDialog(null, "Documento creado con\n EXITO");
        } catch (SQLException e) {
            System.out.println("error aqie mijo " + e);
        }

    }

    //Boton para generar documento de asistencia. en la carpeta ProyectoCECARD200/DocumentosPDF/
    private void AsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsistenciaActionPerformed
        // TODO add your handling code here:

        //se Obtienen Los datos del alumno en Variables locales
        nombre = Nombre.getText();
        apellido = Apellido.getText();
        edad = Edad.getText();
        id = ID.getText();
        grado = Grado.getText();

        //hacer que se combiertan en mayuscula
        nombre = nombre.toUpperCase();
        apellido = apellido.toUpperCase();

        //Condicionar que las Variables no esten vacias "".
        if (nombre != "" && apellido != "" && edad != "" && id != "") {

            //Condicionar que las Variables no esten nulas "null".
            if (nombre != null && apellido != null && edad != null && id != null) {

                //aca se crea el Documento de lA clase Document  utilizando itextpdf5
                com.itextpdf.text.Document documento = new com.itextpdf.text.Document();

                try {
                    //Variable con la ruta de ingreso al sistema
                    String Ruta = System.getProperty("user.home");

                    //aca se espesifica donde se guardara el documento
                    //codigo ruta y nombre del documento sin olvidar la extencion
                    PdfWriter.getInstance(documento, new FileOutputStream(Ruta
                            + "/Documents/PrimerosProgramasEnNetBeans/ProyectoCECARD2000"
                            + "/documentosPDF/documento_asistencia" + nombre + ".pdf"));

                    //se introduce en un objeto Image el encabezado de la pagina utilizando una imangen
                    com.itextpdf.text.Image escudo;
                    escudo = com.itextpdf.text.Image.getInstance("src/IMG/encabezado.PNG");
                    //dimenciones
                    escudo.scaleToFit(850, 90);
                    //alineado al centro
                    escudo.setAlignment(Chunk.ANCHOR);

                    //este codigo introduce texto o un parrafo dentro
                    //del documento creando un documento de la clase com.itextpdf.text.Paragraph
                    Paragraph cuerpo = new Paragraph();
                    Paragraph parrafo = new Paragraph();

                    //se especifica el contenido del documento
                    //en los objetos de tipo Paragraph.
                    //Encabezado
                    cuerpo.add(escudo);

                    //se especifica tipo y tamaño de letra Negrilla
                    cuerpo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    //Se alínea al centro de la pagina
                    cuerpo.setAlignment(Paragraph.ALIGN_CENTER);
                    //texto
                    cuerpo.add("EL CENTRO EDUCATIVO CRISTIANO EL AMOR RESTAURADOR DE DIOS\n");
                    cuerpo.add("NIT 900870840-7\n\n\n\n");
                    //se especifica tipo y tamaño de letra Normal
                    cuerpo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    cuerpo.add("HACE CONSTAR QUE\n\n\n");
                    //se justifica el Parrafo
                    parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add(nombre + " " + apellido);
                    //se especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    parrafo.add(" con " + Tipo_Documento + " N° ");
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add(id);
                    //se especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    parrafo.add(" se encuentra matriculado y cursando en el grado " + grado
                            + " en esta institución en la jornada de la ");
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("MAÑANA");
                    //se especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    parrafo.add(" calendario ");
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("A");
                    //se especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    parrafo.add(" con asistencia en un 80% por los meses de ");
                    parrafo.add("JUNIO Y JULIO");
                    parrafo.add(" con un buen comportamiento y cumpliendo satisfactoriamente con "
                            + "todos los requisitos necesarios para el desarrollo de las actividades. \n\n\n"
                            + "La presente solicitud se expide en el Distrito de Riohacha, a los "
                            + day + " (" + dia + ") días del mes de " + Mes + " del año " + año
                            + ", sin tachones, borrones y/o enmendaduras a solicitud de la parte interesada."
                            + "\n\n\n\n\n\n\n\n\n\n\n\n"
                            + "Atentamente:\n\n\n");
                    //parrafo Alineado al centro
                    parrafo.add("                                               _________________________________\n ");
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("                                                       MIGDALIS YANET RODRGUEZ.\n"
                            + "                                                                      c.c 40921582\n"
                            + "                                                                          Rector\n\n\n\n\n\n");
                    //se justifica el parrafo
                    parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("Calle 28ª N° 11ª – 45  Fijo 5 7287884 Cel. 302 3901106 -  301 5535215\n"
                            + "Riohacha – La Guajira");
                    //Se ingresa en el documento 
                    //todo lo especificado anteriormente
                    documento.open();
                    documento.add(cuerpo);
                    documento.add(parrafo);
                    //se sierra el documento
                    documento.close();

                    JOptionPane.showMessageDialog(null, "reporte creado con exito\n"
                            + "en " + Ruta);
                    //se limpia la informacion en pantalla.
                    Nombre.setText("");
                    Apellido.setText("");
                    Edad.setText("");
                    ID.setText("");
                    Grado.setText("");

                    //codigo para crear tabla especificando cuantas columnas se utilizaran
                    /*PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Grupo");

            
            try {
                Connection on = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "");

                //en esta linea se especifica que deve seleccionar toda la tabla llamada listado.
                PreparedStatement pst = on.prepareStatement("select * from listado");
                //ejecutar las 2 lineas anteriores.
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                    } while (rs.next());
                    documento.add(tabla);

                }
            } catch (DocumentException | SQLException e) {

                System.out.println("3" + e);
            }
                     */
                } catch (DocumentException | HeadlessException | FileNotFoundException e) {

                    System.out.println("2 aqui es el error" + e);
                } catch (IOException e) {
                    System.out.println("1" + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "es necesario verificar los datos");
        }
    }//GEN-LAST:event_AsistenciaActionPerformed

    //Boton para generar documento de comprtamiento en la carpeta ProyectoCECARD200/DocumentosPDF/
    private void ComportamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComportamientoActionPerformed
        // TODO add your handling code here:

        //se toma la informacion consultada en base de datos
        nombre = Nombre.getText();
        apellido = Apellido.getText();
        edad = Edad.getText();
        id = ID.getText();
        grado = Grado.getText();

        //paso a mayuscula
        nombre = nombre.toUpperCase();
        apellido = apellido.toUpperCase();

        //se impide que Las variabres esten vacias ""
        if (nombre != "" && apellido != "" && edad != "" && id != "") {
            //se impide que Las variabres esten nulas "null"
            if (nombre != null && apellido != null && edad != null && id != null) {
                //se crea el objeto de tipo Document en la clase com.itextpdf.text.Document
                com.itextpdf.text.Document documento = new com.itextpdf.text.Document();

                try {
                    //codigo ruta de ingreso al sistema
                    String rUta = System.getProperty("user.home");
                    //codigo ruta y nombre del documento sin olvidar la extencion
                    PdfWriter.getInstance(documento, new FileOutputStream(rUta
                            + "/Documents/PrimerosProgramasEnNetBeans/ProyectoCECARD2000/"
                            + "documentosPDF/documento_Comportamiento" + nombre + ".pdf"));

                    // se crea un objeto de tipo Image para utilizarla como encavezado
                    com.itextpdf.text.Image escudo;
                    escudo = com.itextpdf.text.Image.getInstance("src/img/encabezado.PNG");
                    //dimenciones
                    escudo.scaleToFit(850, 90);
                    //Centrado
                    escudo.setAlignment(Chunk.ANCHOR);

                    //este codigo introduce texto o un parrafo dentro del documento
                    Paragraph cuerpo = new Paragraph();
                    Paragraph parrafo = new Paragraph();

                    //se intrudruce encavezado
                    cuerpo.add(escudo);
                    //este codigo especifica tipo y tamaño de letra Negrilla
                    cuerpo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    //Parrafo alineado al centro
                    cuerpo.setAlignment(Paragraph.ALIGN_CENTER);
                    cuerpo.add("EL CENTRO EDUCATIVO CRISTIANO EL AMOR RESTAURADOR DE DIOS\n");
                    cuerpo.add("NIT 900870840-7\n\n\n\n");
                    //este codigo especifica tipo y tamaño de letra Normal
                    cuerpo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    cuerpo.add("HACE CONSTAR QUE\n\n\n");
                    //parrafo justificado
                    parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                    //este codigo especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add(nombre + " " + apellido);
                    //este codigo especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));

                    parrafo.add(" con " + Tipo_Documento + " N° ");
                    //este codigo especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add(id);
                    //este codigo especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    parrafo.add(" se encuentra matriculado y cursando en el grado" + grado
                            + " en esta institución en la jornada de la MAÑANA calendario ");
                    //este codigo especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("A");
                    //este codigo especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    parrafo.add(" con asistencia en un 80% por los meses de ");
                    //este codigo especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("JUNIO Y JULIO ");
                    //este codigo especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    parrafo.add("con un buen comportamiento y cumpliendo satisfactoriamente con todos los requisitos necesarios para el desarrollo de "
                            + "las actividades. \n\n"
                            + "La presente solicitud se expide en el Distrito de Riohacha, a los " + day + " (" + dia
                            + ") días del mes de agosto del año " + año + ", sin tachones, borrones y/o enmendaduras a solicitud de la parte interesada."
                            + "\n\n\n\n\n\n\n\n\n\n\n\n"
                            + "Atentamente:\n\n\n\n");
                    //parrafo Alineado al centro
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.add("                                               _________________________________\n ");
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("                                                       MIGDALIS YANET RODRGUEZ.\n"
                            + "                                                                        c.c 40921582\n"
                            + "                                                                           Rector\n\n\n\n\n\n\n");
                    //se justifica el parrafo
                    parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("Calle 28ª N° 11ª – 45  Fijo 5 7287884 Cel. 302 3901106 -  301 5535215\n"
                            + "Riohacha – La Guajira");

                    //se introducen el parrafo dentro del documento
                    documento.open();
                    documento.add(cuerpo);
                    documento.add(parrafo);
                    documento.close();

                    JOptionPane.showMessageDialog(null, "reporte creado con exito \n"
                            + "en " + rUta);

                    //se limpia la imformacion consultada
                    Nombre.setText("");
                    Apellido.setText("");
                    Edad.setText("");
                    ID.setText("");
                    Grado.setText("");

                    //java.io.FileNotFoundException
                    //errores
                } catch (DocumentException | HeadlessException | FileNotFoundException e) {

                    System.out.println("2" + e);
                } catch (IOException e) {
                    System.out.println("1" + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "es necesario revisar los datos");
        }

    }//GEN-LAST:event_ComportamientoActionPerformed

    //Boton para generar documento de PazYsalvo en la carpeta ProyectoCECARD200/DocumentosPDF/
    private void PazYSalvoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PazYSalvoActionPerformed
        // TODO add your handling code here:

        //se obtienen los datos consultados
        nombre = Nombre.getText();
        apellido = Apellido.getText();
        edad = Edad.getText();
        id = ID.getText();
        grado = Grado.getText();

        //hacer que se combiertan en mayuscula
        nombre = nombre.toUpperCase();
        apellido = apellido.toUpperCase();

        //Impedir que las variables esten basias ""
        if (nombre != "" && apellido != "" && edad != "" && id != "") {
            //Impedir que las variables esten nulas "null"
            if (nombre != null && apellido != null && edad != null && id != null) {

                // se crea documento desde la clasecom.itextpdf.text.Document 
                com.itextpdf.text.Document documento = new com.itextpdf.text.Document();

                try {
                    //codigo ruta de ingreso al sistema
                    String Ruta = System.getProperty("user.home");
                    //codigo ruta y nombre del documento sin olvidar la extencion
                    PdfWriter.getInstance(documento, new FileOutputStream(Ruta
                            + "/Documents/PrimerosProgramasEnNetBeans/ProyectoCECARD2000/"
                            + "documentosPDF/documento_PazYSalvo" + nombre + ".pdf"));

                    //se crea una imagen con el encabezado
                    com.itextpdf.text.Image escudo;
                    escudo = com.itextpdf.text.Image.getInstance("src/img/encabezado.PNG");
                    //dimenciones
                    escudo.scaleToFit(850, 90);
                    //Alineado al centro
                    escudo.setAlignment(Chunk.ANCHOR);

                    //este codigo introduce texto o un parrafo dentro del documento
                    Paragraph cuerpo = new Paragraph();
                    Paragraph parrafo = new Paragraph();
                    //parrafo.setAlignment(Paragraph.ALIGN_CENTER);

                    //se añade encabezado
                    cuerpo.add(escudo);
                    //se especifica tipo y tamaño de letra Negrilla
                    cuerpo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    //parrafo Alineado al centro
                    cuerpo.setAlignment(Paragraph.ALIGN_CENTER);
                    cuerpo.add("EL CENTRO EDUCATIVO CRISTIANO EL AMOR RESTAURADOR DE DIOS\n");
                    cuerpo.add("NIT 900870840-7\n\n\n\n");
                    //se especifica tipo y tamaño de letra Normal
                    cuerpo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    cuerpo.add("HACE CONSTAR QUE\n\n\n");
                    //se justifica el parrafo
                    parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add(nombre + " " + apellido);
                    //se especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    parrafo.add(" con " + Tipo_Documento + " N° ");
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add(id);
                    //se especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    parrafo.add(" cursó y aprobó el grado " + grado
                            + " en esta institución en la jornada de la MAÑANA calendario ");
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("A");
                    //se especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    parrafo.add(", se encuentra a ");
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("PAZ Y SALVO");
                    //se especifica tipo y tamaño de letra Normal
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                    parrafo.add(" con la institución y cumplió con todos "
                            + "los reglamentos institucionales requeridos por el centro"
                            + " de desarrollo y la secretaria de educación. \n\n"
                            + "La presente solicitud se expide en el Distrito de Riohacha, a los " + day
                            + " (" + dia + ") días del mes de " + Mes + " del año " + año
                            + ", sin tachones, borrones y/o enmendaduras a solicitud de la parte interesada."
                            + "\n\n\n\n\n\n\n\n\n"
                            + "Atentamente:\n\n\n\n\n\n");
                    //parrafo Alineado al centro
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.add("                                               _________________________________\n ");
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("                                                       MIGDALIS YANET RODRGUEZ.\n"
                            + "                                                                     c.c 40921582\n"
                            + "                                                                         Rector\n\n\n\n\n\n\n\n");
                    //se justifica el parrafo
                    parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                    //se especifica tipo y tamaño de letra Negrilla
                    parrafo.setFont(FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
                    parrafo.add("Calle 28ª N° 11ª – 45  Fijo 5 7287884 Cel. 302 3901106 -  301 5535215\n"
                            + "Riohacha – La Guajira");

                    //se añade el parrafo al documento
                    documento.open();
                    documento.add(cuerpo);
                    documento.add(parrafo);
                    documento.close();

                    //aviso
                    JOptionPane.showMessageDialog(null, "reporte creado con exito \n"
                            + "en " + Ruta);
                    //Se limpia La informacion
                    Nombre.setText("");
                    Apellido.setText("");
                    Edad.setText("");
                    ID.setText("");
                    Grado.setText("");

                    //java.io.FileNotFoundException
                    //error
                } catch (DocumentException | HeadlessException | FileNotFoundException e) {

                    System.out.println("2" + e);
                } catch (IOException e) {
                    System.out.println("1" + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "es necesario revisar los datos");
        }

    }//GEN-LAST:event_PazYSalvoActionPerformed

    //Boton para generar documento de cursó y aprobó en la carpeta ProyectoCECARD200/DocumentosPDF/
    private void CursoYAproboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CursoYAproboActionPerformed
        // TODO add your handling code here:

        //se obtienen la informacion de alumno
        nombre = Nombre.getText();
        apellido = Apellido.getText();
        edad = Edad.getText();
        id = ID.getText();
        grado = Grado.getText();

        //Se pasa a Mayuscula.
        nombre = nombre.toUpperCase();
        apellido = apellido.toUpperCase();

        //se inpide que las variables esten vacias "" y nulas "null"
        if (nombre != "" && apellido != "" && edad != "" && id != ""
                && nombre != null && apellido != null && edad != null && id != null) {

            //Se crea un objetos de la clase Document
            com.itextpdf.text.Document documento = new com.itextpdf.text.Document();

            //sentencia que captuRA errores
            try {

                //codigo ruta de ingreso al sistema
                String rutA = System.getProperty("user.home");
                //codigo ruta y nombre del documento sin olvidar la extencion
                PdfWriter.getInstance(documento, new FileOutputStream(rutA
                        + "/Documents/PrimerosProgramasEnNetBeans/ProyectoCECARD2000"
                        + "/documentosPDF/documento_Aprobó" + nombre + ".pdf"));

                //se crea una imagen para utilizarla como encavezado.
                com.itextpdf.text.Image escudo;
                escudo = com.itextpdf.text.Image.getInstance("src/img/encabezado.PNG");
                //Dimenciones
                escudo.scaleToFit(850, 90);
                //alineado al centro
                escudo.setAlignment(Chunk.ANCHOR);

                //este codigo introduce texto o un parrafo dentro del documento
                Paragraph cuerpo = new Paragraph();
                Paragraph parrafo = new Paragraph();

                //Se añade el encabezado.
                cuerpo.add(escudo);
                //este codigo especifica tipo y tamaño de letra Negrilla
                cuerpo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                //Parrafo alineado al centro
                cuerpo.setAlignment(Paragraph.ALIGN_CENTER);
                cuerpo.add("EL CENTRO EDUCATIVO CRISTIANO EL AMOR RESTAURADOR DE DIOS\n");
                cuerpo.add("NIT 900870840-7\n\n\n\n");
                //este codigo especifica tipo y tamaño de letra Normal
                cuerpo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                cuerpo.add("HACE CONSTAR QUE\n\n\n");
                //Parrafo justificado
                parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                //este codigo especifica tipo y tamaño de letra Negrilla
                parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                parrafo.add(nombre + " " + apellido);
                //este codigo especifica tipo y tamaño de letra Normal
                parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                parrafo.add(" con " + Tipo_Documento + " N° ");
                //este codigo especifica tipo y tamaño de letra Negrilla
                parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                parrafo.add(id);
                //este codigo especifica tipo y tamaño de letra Normal
                parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                parrafo.add(" cursó y aprobó el grado "
                        + grado + " en esta institución en la jornada de la MAÑANA calendario ");
                //este codigo especifica tipo y tamaño de letra Negrilla
                parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                parrafo.add("A");
                //este codigo especifica tipo y tamaño de letra Normal
                parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
                parrafo.add(", con un buen comportamiento y cumpliendo "
                        + "satisfactoriamente con todos los requisitos necesarios para el desarrollo de las actividades. \n\n"
                        + "La presente solicitud se expide en el Distrito de Riohacha, a los " + day + " (" + dia
                        + ") días del mes de diciembre del año " + año + ", sin tachones, borrones y/o enmendaduras a solicitud de la parte interesada."
                        + "\n\n\n\n\n\n\n\n\n\n\n\n"
                        + "Atentamente:\n\n\n\n\n\n");
                //parrafo Alineado al centro
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.add("                                               _________________________________\n ");
                //se especifica tipo y tamaño de letra Negrilla
                parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
                parrafo.add("                                                       MIGDALIS YANET RODRGUEZ.\n"
                        + "                                                                     c.c 40921582\n"
                        + "                                                                         Rector\n\n\n\n\n\n\n\n");
                //se justifica el parrafo
                parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                //se especifica tipo y tamaño de letra Negrilla
                parrafo.setFont(FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
                parrafo.add("Calle 28ª N° 11ª – 45  Fijo 5 7287884 Cel. 302 3901106 -  301 5535215\n"
                        + "Riohacha – La Guajira");

                //Se añade el parrafo al documeto.
                documento.open();
                documento.add(cuerpo);
                documento.add(parrafo);
                documento.close();

                JOptionPane.showMessageDialog(null, "reporte creado con exito\n"
                        + "en " + rutA);
                Nombre.setText("");
                Apellido.setText("");
                Edad.setText("");
                ID.setText("");
                Grado.setText("");

                //java.io.FileNotFoundException
                //Errores.
            } catch (DocumentException | HeadlessException | FileNotFoundException e) {

                System.out.println("2" + e);
            } catch (IOException e) {
                System.out.println("1" + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "es necesario revisar los datos");
        }

    }//GEN-LAST:event_CursoYAproboActionPerformed

    //Boton para generar documentos de movimientos financieros.
    private void MovimientoFinancieroActionPerformed(java.awt.event.ActionEvent evt) {

        //se crea un objeto de tipo documento
        Document documento = new Document(/*Creo que esto coloca*/PageSize.A4.rotate()/* el documento vertical*/);

        try {
            //codigo ruta de ingreso al sistema
            String rutAA = System.getProperty("user.home");
            //codigo ruta y nombre del documento sin olvidar la extencion
            PdfWriter.getInstance(documento, new FileOutputStream(rutAA
                    + "/Documents/PrimerosProgramasEnNetBeans/ProyectoCECARD2000/"
                    + "documentosPDF/Tabla_prueba.pdf"));

            //se crea un objeto de tipo Image para utilizarlo como encavezado.
            com.itextpdf.text.Image escudo;
            escudo = com.itextpdf.text.Image.getInstance("src/IMG/encabezado.PNG");
            //dimenciones
            escudo.scaleToFit(850, 90);
            //alineado al centro
            escudo.setAlignment(Chunk.ALIGN_CENTER);

            //este codigo introduce texto o un parrafo dentro del documento
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("CECARD\n\n");
            //este codigo especifica tipo y tamaño de letra
            parrafo.setFont(FontFactory.getFont("segoe UI", 18, Font.BOLD, BaseColor.CYAN));
            parrafo.add("LISTADO DE BD cecard1.\n\n");

            documento.open();
            documento.add(escudo);
            documento.add(parrafo);

            //codigo para crear tabla especificando cuantas columnas se utilizaran
            PdfPTable tabla = new PdfPTable(8);

            /*  Opción 2: define un ancho absoluto.

            Suponga que se le pide que cree una tabla con un ancho de 4 pulgadas.
            Por defecto, 1 pulgada es 72 unidades de usuario, por lo que necesita 
            una tabla de 288 unidades de usuario.

            Esto se puede lograr así:


            PdfPTable table = new PdfPTable(2);
            table.setTotalWidth(288);
            table.setLockedWidth(true);
            
            Si olvida la línea table.setLockedWidth(true);, iText asumirá que desea que iText calcule 
            el ancho en función del porcentaje de ancho (predeterminado) y el ancho disponible. 
            Al bloquear el ancho, iText cambia para usar el ancho total como un ancho absoluto.*/
            // determina el porcentaje a ocupar del ancho del documento.
            tabla.setWidthPercentage(100);
            //se introduce el nombre de las columnas
            tabla.addCell("FECHA");
            tabla.addCell("CONSEPTO");
            tabla.addCell("INGRESO");
            tabla.addCell("EGRESO");
            tabla.addCell("SALDO");
            tabla.addCell("NOMBRE");
            tabla.addCell("CEDULA");
            tabla.addCell("ALUMNO");

            try {

                //Conexxion con la base de datos
                Connection on = ClaseMetodos.conectar();

                //en esta linea se especifica que deve seleccionar toda la tabla llamada listado.
                PreparedStatement pst = on.prepareStatement(
                        "select Fecha, Consepto, Ingreso, Egreso, Saldo, "
                        + "Nombre_De_Quien_Paga, Cedula_De_Quien_Paga, Alumno from contavilidad");

                //ejecutar las 2 lineas anteriores.
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        //se llena la tabla con el resultado de la base de datos.
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));

                    } while (rs.next());

                    //terminado el ciclo se añade la tabla al documento.
                    documento.add(tabla);

                }

                //errores.
            } catch (DocumentException | SQLException e) {

                System.out.println("3 : " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "reporte creado\n"
                    + "en " + rutAA);
            documento.close();
            //java.io.FileNotFoundException
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

            System.out.println("2" + e);
        } catch (IOException e) {
            System.out.println("1" + e);
        }

    }

    //Metodo para consultar la base de datos al oprimir enter.
    private void Enter(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String ident = ID.getText();

            if (ident != "" || ident != null) {
                try {

                    //Conexion con base de datos.
                    Connection cn = ClaseMetodos.conectar();

                    //esta linea de codigo le da las intrucciones a la base de datos
                    PreparedStatement pst = cn.prepareStatement("select * from alumnos where Documento = ?");

                    pst.setString(1, ID.getText());
                    ResultSet rs = pst.executeQuery();

                    // con este codigo intento obtener los balores almacenados en la base de datos registro
                    if (rs.next()) {

                        Apellido.setText(rs.getString("Apellidos"));
                        Nombre.setText(rs.getString("Nombres"));
                        Edad.setText(rs.getString("Edad"));
                        Tipo_Documento = (rs.getString("Tipo_Documento"));
                        Grado.setText(rs.getString("Grado"));

                        // se envia el numero ID y el grado A la ClaseMetodos
                        //Ident="", grado="", nombre="", apellido="";
                        c.Ident = ID.getText();
                        c.grado = (Grado.getText());
                        //se envia Nombre a la ventana Bolertines
                        c.nombre = (Nombre.getText());
                        c.apellido = (Apellido.getText());

                    } else {
                        JOptionPane.showMessageDialog(null, "No coincide el numero: "
                                + ID.getText().trim() + " \n con los datos almacenados");
                    }

                } catch (Exception e) {
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes introducir un numero de identificacion");
                ID.setBackground(Color.red);
            }

        }

    }

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
            java.util.logging.Logger.getLogger(GeneraDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneraDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneraDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneraDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneraDocumentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Apellido;
    private javax.swing.JButton Asistencia;
    private javax.swing.JLabel Background;
    private javax.swing.JButton Comportamiento;
    private javax.swing.JButton CursoYAprobo;
    private javax.swing.JLabel Edad;
    private javax.swing.JLabel Grado;
    private javax.swing.JLabel Stiquer;
    private javax.swing.JTextField ID;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton PazYSalvo;
    private javax.swing.JButton MovimientoFinanciero;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton ListAlumnos;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
