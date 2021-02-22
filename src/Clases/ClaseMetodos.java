package Clases;

import static Clases.ModificarInformacion.ID;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class ClaseMetodos {

    ModificarInformacion m = new ModificarInformacion();
    
    //declaracion de variables a utilizar en continuarpago.
    public static String d[] = new String[7];
    public static double matricula_pagada;
    public static double porpagar = 0;
    public static int va,
      pe, vandera;
    public static int pasar = 0, exito =0;

    public static int decidido;
    public static String identificacion;
    
    //variables para utilizar la informacion de la ventana GenerarDocumentos
    static String Ident="", grado="", nombre="", apellido="";

    
    public void VolerFinanzas(){
        Finanzas f = new Finanzas();
        f.setVisible(true);
    }

    public void Buscar() {
        String documento = identificacion;
        matricula_pagada = 0;
        va  = 0;
        vandera = 0;
        exito = 0;

        if(pasar == 4){
            
            m.TI.setEnabled(false);
            m.RC.setEnabled(false);
            m.F.setEnabled(false);
            m.M.setEnabled(false);
            try {
                //Conexion con base de datos.
                Connection cn = ClaseMetodos.conectar();

                //esta linea de codigo le da las intrucciones a la base de datos
                PreparedStatement pst = cn.prepareStatement("select * from alumnos where Documento = ?");

                pst.setString(1, ID.getText());
                ResultSet rs = pst.executeQuery();
                // con este codigo intento obtener los balores almacenados en la base de datos registro
                if (rs.next()) {

                    m.uno.setText(rs.getString("Apellidos"));
                    m.dos.setText(rs.getString("Nombres"));
                    m.tres.setText(rs.getString("Documento"));
                    m.ti = rs.getString("Tipo_Documento");
                    //System.out.println("este es ti: "+m.ti);
                    if (m.ti.equals("TI")) {
                        m.TI.setSelected(true);
                        m.RC.setSelected(false);
                    } else if (m.ti.equals("RC")) {
                        m.RC.setSelected(true);
                        m.TI.setSelected(false);
                    }
                    m.se = (rs.getString("Sexo"));
                    //System.out.println("este es se: "+m.se);
                    if (m.se.equals("F")) {
                        m.F.setSelected(true);
                        m.M.setSelected(false);
                    } else if (m.se.equals("M")) {
                        m.M.setSelected(true);
                        m.F.setSelected(false);
                    }
                    m.seis.setText(rs.getString("Matricula"));
                    m.siete.setText(rs.getString("Valor_Pension"));
                    m.ocho.setText(rs.getString("Padre"));
                    m.nueve.setText(rs.getString("Cedula_Padre"));
                    m.diez.setText(rs.getString("Direccion_Padre"));
                    m.once.setText(rs.getString("Telefono_Padre"));
                    m.doce.setText(rs.getString("Madre"));
                    m.trece.setText(rs.getString("Cedula_Madre"));
                    m.catorce.setText(rs.getString("Direccion_Madre"));
                    m.quince.setText(rs.getString("Telefono_Madre"));
                    m.dieciseis.setText(rs.getString("Acudiente"));
                    m.diecisiete.setText(rs.getString("Cedula_Acudiente"));
                    m.dieciocho.setText(rs.getString("Direccion_Acudiente"));
                    m.diecinueve.setText(rs.getString("Telefono_Acudiente"));
                    m.veinte.setText(rs.getString("Edad"));
                    m.veintiuno.setText(rs.getString("RH"));
                    m.veintidos.setText(rs.getString("Grado"));
                    m.veintiuno1.setText(rs.getString("InstitucionAnterior"));
                    m.veintiuno2.setText(rs.getString("EPS"));

                } else {
                    JOptionPane.showMessageDialog(null, "No coincide el numero: "
                            + ID.getText().trim() + " \n con los datos almacenados");

                    m.nueve.setText("");
                    m.dieciocho.setText("");
                    m.veintiuno.setText("");
                    m.diez.setText("");
                    m.once.setText("");
                    m.quince.setText("");
                    m.doce.setText("");
                    m.catorce.setText("");
                    m.trece.setText("");
                    m.dieciseis.setText("");
                    m.veinte.setText("");
                    m.uno.setText("");
                    m.dos.setText("");
                    m.tres.setText("");
                    m.seis.setText("");
                    m.siete.setText("");
                    m.ocho.setText("");
                    m.diecisiete.setText("");
                    m.diecinueve.setText("");
                    m.veintidos.setText("");
                    m.veintiuno1.setText("");
                    m.veintiuno2.setText("");
                }
            } catch (Exception e) {
                System.out.println("esta cosa no quiere conectar" + e);

            }
        }
        
        //continuar pago de matricula.
        if (pasar == 1) {
            try {
                //Conexion con base de datos.
                Connection cn = ClaseMetodos.conectar();

                //esta linea de codigo le da las intrucciones a la base de datos
                PreparedStatement pst = cn.prepareStatement("select * from alumnos where Documento = ?");

                pst.setString(1, documento);
                ResultSet rs = pst.executeQuery();
                // con este codigo intento obtener los valores almacenados en la base de datos alumnos
                if (rs.next()) {

                    d[0] = (rs.getString("Apellidos"));
                    d[1] = (rs.getString("Nombres"));
                    d[2] = (rs.getString("Documento"));
                    va  = rs.getInt("Matricula");
                    pe = rs.getInt("Valor_Pension");
                    d[3] = (rs.getString("Edad"));
                    d[4] = (rs.getString("Grado"));
                    matricula_pagada = rs.getDouble("Matricula_Pagada");

                    cn.close();

                } else {
                    JOptionPane.showMessageDialog(null, "No coincide el numero: "
                            + documento + " \n con los datos almacenados");
                    vandera++;

                    //ce.setVisible(true);
                }
                if (matricula_pagada >= 100 ) {

                    JOptionPane.showMessageDialog(null, "Este alumno ya se encuentra al dia con su matricula.");
                    vandera++;
                } else {
                    if (matricula_pagada != 0) {
                        double pagado = va  * matricula_pagada / 100;
                        //System.out.println("este es matricul_pagada " + matricula_pagada);
                        porpagar = va  - pagado;
                        //System.out.println("este es porpagar " + porpagar);
                        d[5] = (": " + porpagar);
                    } else {
                        porpagar = va;
                    }
                }

            } catch (SQLException e) {
                System.out.println(identificacion);
                vandera++;
                System.out.println("error al consultar datos " + e);
            }

            //continuar pago de pension.
        } else if (pasar == 2) {
            try {
                //Conexion con base de datos.
                Connection cn = ClaseMetodos.conectar();

                //esta linea de codigo le da las intrucciones a la base de datos
                PreparedStatement pst = cn.prepareStatement("select * from alumnos where Documento = ?");

                pst.setString(1, documento);
                ResultSet rs = pst.executeQuery();
                // con este codigo intento obtener los balores almacenados en la base de datos registro
                if (rs.next()) {

                    d[0] = (rs.getString("Apellidos"));
                    d[1] = (rs.getString("Nombres"));
                    d[2] = (rs.getString("Documento"));
                    va  = rs.getInt("Valor_Pension");
                    d[3] = (rs.getString("Edad"));
                    d[4] = (rs.getString("Grado"));
                    matricula_pagada = rs.getDouble("Pension_Pagada");

                    cn.close();

                } else {
                    JOptionPane.showMessageDialog(null, "No coincide el numero: "
                            + documento + " \n con los datos almacenados");
                    vandera++;

                    //ce.setVisible(true);
                }
                if (matricula_pagada == 100 || matricula_pagada > 100) {

                    JOptionPane.showMessageDialog(null, "Este alumno ya se encuentra al dia con su pension.");
                    vandera++;
                } else {
                    if (matricula_pagada != 0) {
                        double pagado = va  * matricula_pagada / 100;
                        //System.out.println("este es matricul_pagada " + matricula_pagada);
                        porpagar = va;
                        //System.out.println("este es porpagar " + porpagar);
                        d[5] = (": " + porpagar);
                    } else {
                        //d[5] = Integer.toString(va);
                        porpagar = va;
                        //System.out.println("este es va "+va);
                    }
                }

            } catch (SQLException e) {
                System.out.println(identificacion);
                vandera++;
                System.out.println("error al consultar datos " + e);
            }
        }

        if (pasar == 1 || pasar == 2) {
            Siguiente(vandera);
        }
        if (pasar == 3) {
            try {
                //Conexion con base de datos.
                Connection cn = ClaseMetodos.conectar();

                //esta linea de codigo le da las intrucciones a la base de datos
                PreparedStatement pst = cn.prepareStatement("select * from alumnos where Documento = ?");

                pst.setString(1, documento);
                ResultSet rs = pst.executeQuery();
                // con este codigo intento obtener los balores almacenados en la base de datos registro
                if (rs.next()) {

                    d[0] = (rs.getString("Apellidos"));
                    d[1] = (rs.getString("Nombres"));
                    d[4] = (rs.getString("Grado"));

                    cn.close();

                } else {
                    JOptionPane.showMessageDialog(null, "No coincide el numero: "
                            + documento + " \n con los datos almacenados");
                    exito++;
                    //ce.setVisible(true);
                }

            } catch (SQLException e) {
                System.out.println(identificacion);
                vandera++;
                System.out.println("error al consultar datos 3" + e);
            }
        }

    }

    public int DecidirPago(int d) {
        if (d == 1) {
            decidido = 1;
        } else {
            decidido = 0;
        }
        return decidido;
    }

    public int Siguiente(int i) {

        if (i == 0) {
            Metodos me = new Metodos();
            me.Pasar();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor intente de nuevo.");
        }
        return vandera;
    }

    public String ID(String id) {
        identificacion = id;
        return id;
    }

    public void Continuar() {
        ContinuarRegistro c = new ContinuarRegistro();
        c.setVisible(true);
    }

    public static void Salir() {

        InterfazPrincipal c = new InterfazPrincipal();
        c.setVisible(true);
    }

    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/cecard1", "root", "");
            return cn;
        } catch (SQLException e) {
            System.err.println("esto es el error en el metodo Conectar" + e);
        }
        return (null);

    }

    public String MesEnLetras(int mes) {
        String letras = "";
        if (mes == 0) {
            letras = "enero";
        }
        if (mes == 1) {
            letras = "febrero";
        }
        if (mes == 2) {
            letras = "marzo";
        }
        if (mes == 3) {
            letras = "abril";
        }
        if (mes == 4) {
            letras = "mayo";
        }
        if (mes == 5) {
            letras = "junio";
        }
        if (mes == 6) {
            letras = "julio";
        }
        if (mes == 7) {
            letras = "agosto";
        }
        if (mes == 8) {
            letras = "septiembre";
        }
        if (mes == 9) {
            letras = "octubre";
        }
        if (mes == 10) {
            letras = "noviembre";
        }
        if (mes == 11) {
            letras = "diciembre";
        }
        return letras;
    }

    public String DiaEnLetras(int dia) {
        String letras = "";
        if (dia == 1) {
            letras = "un";
        }
        if (dia == 2) {
            letras = "dos";
        }
        if (dia == 3) {
            letras = "tres";
        }
        if (dia == 4) {
            letras = "cuatro";
        }
        if (dia == 5) {
            letras = "cinco";
        }
        if (dia == 6) {
            letras = "seis";
        }
        if (dia == 7) {
            letras = "siete";
        }
        if (dia == 8) {
            letras = "ocho";
        }
        if (dia == 9) {
            letras = "nueve";
        }
        if (dia == 10) {
            letras = "dies";
        }
        if (dia == 11) {
            letras = "once";
        }
        if (dia == 12) {
            letras = "doce";
        }
        if (dia == 13) {
            letras = "trece";
        }
        if (dia == 14) {
            letras = "catorce";
        }
        if (dia == 15) {
            letras = "quince";
        }
        if (dia == 16) {
            letras = "dieciseis";
        }
        if (dia == 17) {
            letras = "diecisiete";
        }
        if (dia == 18) {
            letras = "dieciocho";
        }
        if (dia == 19) {
            letras = "diecinueve";
        }
        if (dia == 20) {
            letras = "veinte";
        }
        if (dia == 21) {
            letras = "veintiun";
        }
        if (dia == 22) {
            letras = "veintidos";
        }
        if (dia == 23) {
            letras = "veintitrés";
        }
        if (dia == 24) {
            letras = "veinticuaatro";
        }
        if (dia == 25) {
            letras = "veinticinco";
        }
        if (dia == 26) {
            letras = "veintiseis";
        }
        if (dia == 27) {
            letras = "veintisiete";
        }
        if (dia == 28) {
            letras = "veintiocho";
        }
        if (dia == 29) {
            letras = "veintinueve";
        }
        if (dia == 30) {
            letras = "treinta";
        }
        if (dia == 31) {
            letras = "treinta y un";
        }
        return letras;
    }

    
}
