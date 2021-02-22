package Clases;

//imports para mysql
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
//Imports para crear documento de exel
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Metodos {

    //variable para comprovar la salida en modificar informacion.
    public static int pass = 0;

    public int CantRegistros() {
        //esta variable es para consultar la 
        //cantidad de registrs en la base de datos alumnos
        int contador = 0;

        try {
            //Conexxion con la base de datos
            Connection on = ClaseMetodos.conectar();

            //en esta linea se especifica que deve seleccionar toda la tabla llamada listado.
            PreparedStatement pst = on.prepareStatement(
                    "select Apellidos, Grado from alumnos");

            //ejecutar las 2 lineas anteriores.
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int CantidadDeColumnas = rsMd.getColumnCount();
            String Info[] = new String[CantidadDeColumnas];

            //llenar la matriz con los datos de la consulta
            while (rs.next()) {
                for (int i = 0; i < CantidadDeColumnas; i++) {
                    Info[i] = rs.getString(i + 1);
                }
                contador = contador + 1;
                System.out.println("contador es " + contador);
            }
        } catch (Exception e) {
            System.out.println("error al contar " + e);
        }

        return contador;
    }

//Metodo para crear listado de alumnos en exel.
    public void CrearListadoAlumnos(String[][] informacion, String ruta) {

        try {
            //se crea un objeto de la clase WorkbookSettings
            //para especificar la norma iso que se utilizara.
            WorkbookSettings Libro = new WorkbookSettings();
            //se especifica la norma iso que se utilizara.
            Libro.setEncoding("ISO-8859-1");
            // se crea el libro.
            WritableWorkbook WorBook = Workbook.createWorkbook(new File(ruta), Libro);

            //se crea una hoja en el libro de exel dandole nombre y posición
            WritableSheet hoja = WorBook.createSheet(/*Nombre*/"Hoja 1", 0/*Posicion*/);
            // se agrega fuente tamaño y estilo de la letra
            WritableFont font = new WritableFont(
                    /*fuente o tipo de letra*/WritableFont.ARIAL,/*tamaño*/ 18, /*Estilo*/ WritableFont.BOLD);
            //se añade lo anterior a las celdas
            WritableCellFormat Cell = new WritableCellFormat(font);

            //se recorren la celdas
            for (int i = 0; i < informacion.length; i++) {//filas
                for (int j = 0; j < informacion.length; j++) {//columnas
                    //se agrega el contenido por celdas
                    hoja.addCell(new jxl.write.Label(j, i, informacion[i][j], Cell));
                    System.out.println("este = " + informacion[i][j]);

                }
            }
            //se agrega el contenido
            WorBook.write();
            WorBook.close();

        } catch (IOException | WriteException e) {
            System.out.println("error creando doc.xml  " + e);

        }

    }

    public void VolverNomina() {
        Nomina n = new Nomina();
        Nomi.TrabajadoresUno.TraUno = 0;
        n.setVisible(true);

    }

    public void MostrarID() {
        Nomi.ModificarTrabajador m
                = new Nomi.ModificarTrabajador();
        m.MostrarID
                = true;

        if (m.MostrarID
                == true) {
            m.ID
                    = new javax.swing.JTextField();
            m
                    .getContentPane().add(m.ID,
                            new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 125, 150, 30));
            m.ID
                    .setBackground(new Color(152, 255, 152));
            m.ID
                    .addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent evt
                        ) {
                            m
                                    .Press(evt
                                    );

                        }

                        public void keyTyped(java.awt.event.KeyEvent evt
                        ) {
                            m
                                    .soloNumeros(evt
                                    );

                        }
                    });
            m.ID
                    .setVisible(m.MostrarID
                    );
            m.LabelID
                    = new javax.swing.JLabel();
            m.LabelID
                    .setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            m.LabelID
                    .setText("Identificación:");
            m
                    .getContentPane().add(m.LabelID,
                            new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 100, 30));
            m.jLabel11
                    .setVisible(m.MostrarID
                    );
            System.out
                    .println("ok deveria estar mostrado");

        }
        m
                .setVisible(true);
        System.out
                .println("cambie a MostrarID");

    }

    public void PassModifi() {

        Nomi.ModificarTrabajador m = new Nomi.ModificarTrabajador();
        m.setVisible(true);
        System.out.println("lo abrí");

    }

    public void Pasar() {
        ContinuarPago co
                = new ContinuarPago();
        co
                .setVisible(true);

    }

    // este metodo restringe los caracteres que se pueden escribir en un campo jtexfield
    //https://ascii.cl/es/codigos-html.htm
    public void SoloLetras(java.awt.event.KeyEvent e
    ) {

        //esta condicional restringe los caracteres basado en el listado de la tabla ascii
        if (e
                .getKeyChar() >= 33 && e
                        .getKeyChar() <= 64
                || e
                        .getKeyChar() >= 91 && e
                        .getKeyChar() <= 96
                || e
                        .getKeyChar() >= 123 && e
                        .getKeyChar() <= 208
                || e
                        .getKeyChar() >= 210 && e
                        .getKeyChar() <= 240
                || e
                        .getKeyChar() >= 242 && e
                        .getKeyChar() <= 255) {
            e
                    .consume();

        }

    }

    // este metodo restringe los caracteres que se pueden escribir en un campo jtexfield
    //https://ascii.cl/es/codigos-html.htm
    public void SoloNumeros(java.awt.event.KeyEvent e
    ) {

        //esta condicional restringe los caracteres basado en el listado de la tabla ascii
        if (e
                .getKeyChar() >= 32 && e
                        .getKeyChar() <= 47
                || e
                        .getKeyChar() >= 58 && e
                        .getKeyChar() <= 255) {
            e
                    .consume();

        }
    }

    public void Fechas(java.awt.event.KeyEvent e
    ) {

        if (e
                .getKeyChar() >= 32 && e
                        .getKeyChar() <= 46
                || e
                        .getKeyChar() >= 58 && e
                        .getKeyChar() <= 255) {
            e
                    .consume();

        }

    }

}
