/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nomi;

import Clases.ClaseMetodos;
import java.awt.Color;
import java.awt.Image;
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
public class PagarSueldo extends javax.swing.JFrame {

    /**
     * Creates new form PagarSueldo
     */
    Clases.Metodos m = new Clases.Metodos();
    Clases.ClaseMetodos c = new Clases.ClaseMetodos();
    String Salario = "", estado = "";
    String id = "";
    int salario = 0;
    boolean ModificarFecha = false;
    boolean ModificarValor = false;
    DefaultTableModel modelo = new DefaultTableModel();

    public PagarSueldo() {
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        initComponents();
        
        ImageIcon FondoDePantalla = new ImageIcon("src/IMG/gradient-pink.png");
        Icon icono = new ImageIcon(FondoDePantalla.getImage().getScaledInstance(Background.getWidth(), 
                Background.getHeight(), Image.SCALE_DEFAULT));
        Background.setIcon(icono);
        
        
        //aca se colocan las imagenes en los Stiquer
        ImageIcon Stiq = new ImageIcon("src/IMG/Pagarsueldo.png");
        Icon icono2 = new ImageIcon(Stiq.getImage().getScaledInstance(Stiquer.getWidth(),
                Stiquer.getHeight(), Image.SCALE_DEFAULT));
        Stiquer.setIcon(icono2);
        
        
        
        this.setBounds(0, 0, 950, 550);
        this.setLocationRelativeTo(null);
        DiaInicio.setVisible(false);
        MesInicio.setVisible(false);
        AñoInicio.setVisible(false);

        Cargo.setEnabled(false);
        NominaBoton.setEnabled(false);
        NombrePago1.setEditable(false);
        Fecha.setEditable(false);
        Valor.setEditable(false);
        Identificacion1.setEditable(false);

        for (int i = 1; i <= 31; i++) {
            DiaInicio.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 13; i++) {
            MesInicio.addItem(String.valueOf(i));
        }
        for (int i = año; i >= 1999; i--) {
            AñoInicio.addItem(String.valueOf(i));
        }

        int contador = 0;
        try {

            Trabajadores.setModel(modelo);

            //coneccion con base de datos
            Connection on = ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = on.prepareStatement(
                    "SELECT Nombres, Apellidos, Cargo, Sueldo, Estados,"
                    + " Direccion, Telefono, Estudios, No_Identificacion FROM trabajadores");

            ResultSet rs = pst.executeQuery();

            //establecer nombres de columnas
            modelo.addColumn("NOMBRES");
            modelo.addColumn("APELLIDOS");
            modelo.addColumn("CARGO");
            modelo.addColumn("SUELDO");
            modelo.addColumn("ESTADO");
            modelo.addColumn("DIRECCION");
            modelo.addColumn("TELEFONO");
            modelo.addColumn("ESTUDIOS");
            modelo.addColumn("IDENTIFICACION");

            ResultSetMetaData rsMd = rs.getMetaData();
            int CantidadDeColumnas = rsMd.getColumnCount();
            String[] filas = new String[CantidadDeColumnas];
            while (rs.next()) {

                for (int i = 0; i < CantidadDeColumnas; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                estado = rs.getString("Estados");
                if ("Activo".equals(estado)) {
                    Salario = rs.getString("Sueldo");
                    salario = salario + Integer.parseInt(Salario);
                }
                contador = contador + 1;
                modelo.addRow(filas);
            }
            System.out.println("nomina   " + salario);

        } catch (SQLException e) {
            System.out.println(e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Valor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Cargo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        NombrePago1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        NominaBoton = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        EmpleadoBoton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Trabajadores = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Identificacion1 = new javax.swing.JTextField();
        TotalNomina = new javax.swing.JLabel();
        CheckBoxValor = new javax.swing.JCheckBox();
        CheckBoxFecha = new javax.swing.JCheckBox();
        DiaInicio = new javax.swing.JComboBox<>();
        MesInicio = new javax.swing.JComboBox<>();
        AñoInicio = new javax.swing.JComboBox<>();
        Fecha = new javax.swing.JTextField();
        Stiquer = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setText("x");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 35));

        jLabel1.setFont(new java.awt.Font("Broadway", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PAGO DE SUELDO.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 890, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("FECHA:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("VALOR EN NUMEROS:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        Valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValorsoloNumeros(evt);
            }
        });
        getContentPane().add(Valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 240, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("NIT O IDENTIFICACION:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        Cargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CargosoloNumeros(evt);
            }
        });
        getContentPane().add(Cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 240, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("PAGADO A:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        NombrePago1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombrePago1soloLetras(evt);
            }
        });
        getContentPane().add(NombrePago1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 240, 30));

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("=> Digite Documento De Empleado:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 105, -1, -1));

        ID.setBackground(new java.awt.Color(152, 255, 152));
        ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarID(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SoloNumeros(evt);
            }
        });
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 140, 25));

        NominaBoton.setText("Pagar Nomina");
        NominaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominaBotonActionPerformed(evt);
            }
        });
        getContentPane().add(NominaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, 130, 30));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCheckBox1.setText("Nomina Completa.");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, -1));

        EmpleadoBoton.setText("Pagar Empleado.");
        EmpleadoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleadoBotonActionPerformed(evt);
            }
        });
        getContentPane().add(EmpleadoBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 130, 30));

        Trabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Trabajadores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 520, 200));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("CARGO:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("NIT O IDENTIFICACION:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        Identificacion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Identificacion1soloNumeros(evt);
            }
        });
        getContentPane().add(Identificacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 240, 30));

        TotalNomina.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TotalNomina.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TotalNomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));

        CheckBoxValor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CheckBoxValor.setText("Cambiar.");
        CheckBoxValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxValorActionPerformed(evt);
            }
        });
        getContentPane().add(CheckBoxValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, 30));

        CheckBoxFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CheckBoxFecha.setText("Cambiar.");
        CheckBoxFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxFechaActionPerformed(evt);
            }
        });
        getContentPane().add(CheckBoxFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, 30));

        DiaInicio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DiaInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia" }));
        getContentPane().add(DiaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 70, 30));

        MesInicio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MesInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes" }));
        getContentPane().add(MesInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 80, 30));

        AñoInicio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AñoInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año" }));
        getContentPane().add(AñoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 80, 30));

        Fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FechasoloNumeros(evt);
            }
        });
        getContentPane().add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 240, 30));
        getContentPane().add(Stiquer, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 300, 140));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Clases.Nomina i = new Clases.Nomina();
        i.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void FechasoloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FechasoloNumeros
        // TODO add your handling code here:
        m.SoloNumeros(evt);

    }//GEN-LAST:event_FechasoloNumeros

    private void ValorsoloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorsoloNumeros
        // TODO add your handling code here:
        m.SoloNumeros(evt);

    }//GEN-LAST:event_ValorsoloNumeros

    private void CargosoloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CargosoloNumeros
        // TODO add your handling code here:
        m.SoloNumeros(evt);

    }//GEN-LAST:event_CargosoloNumeros

    private void NombrePago1soloLetras(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombrePago1soloLetras
        // TODO add your handling code here:
        m.SoloLetras(evt);
    }//GEN-LAST:event_NombrePago1soloLetras

    private void NominaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NominaBotonActionPerformed
        // TODO add your handling code here:

        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
        String day = c.DiaEnLetras(dia);
        String Mes = c.MesEnLetras(mes);
        String f = dia + "/" + Mes + "/" + año + "/ " + hora + ":" + min;

        String saldo = "";

        try {

            //en las segundas comillas va el usuario de mysql y en las terceras va la contraseña.
            Connection on = ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = on.prepareStatement(
                    "SELECT Fecha, Ingreso, Egreso, Saldo FROM contavilidad");
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
                    pst2.setString(2, f);
                    pst2.setString(3, "Pago Nomina");
                    pst2.setString(4, "");
                    pst2.setString(5, Integer.toString(salario));
                    if (contador == 0) {
                        saldo = "0";
                    }
                    if (saldo != "0") {
                        int sald = Integer.parseInt(saldo.trim());
                        int pagado = salario;
                        sald = sald - pagado;
                        saldo = Integer.toString(sald);

                        pst2.setString(6, saldo);
                        pst2.setString(7, "Empleados en Nomina");
                        pst2.setString(8, "");
                        pst2.setString(9, "Nomina");
                        pst2.executeUpdate();

                        on.close();
                        JOptionPane.showMessageDialog(null, "PAGO NOMINA EXITOSO");

                        NombrePago1.setText("");
                        Fecha.setText("");
                        Valor.setText("");
                        Cargo.setText("");
                        Identificacion1.setText("");
                        ID.setText("");

                    } else {
                        JOptionPane.showMessageDialog(
                                null, "EN ESTOS MOMENTOS NO SE PUEDE REGISTRAR EGRESO \n"
                                + "            POR FALTA DE RECURSOS");
                    }
                }

            } catch (SQLException e) {
                System.err.println("error al registrar egreso " + e);
                JOptionPane.showMessageDialog(
                        null, "Error en el sistema contacte con el administrador.");
            }

        } catch (SQLException e) {
            System.out.println("error en el boton = " + e);
        }


    }//GEN-LAST:event_NominaBotonActionPerformed

    private void Identificacion1soloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Identificacion1soloNumeros
        // TODO add your handling code here:
    }//GEN-LAST:event_Identificacion1soloNumeros

    private void BuscarID(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarID
        // TODO add your handling code here:
        id = ID.getText().trim();
        BuscarDocumento();
    }//GEN-LAST:event_BuscarID

    private void SoloNumeros(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SoloNumeros
        // TODO add your handling code here:
        m.SoloNumeros(evt);
    }//GEN-LAST:event_SoloNumeros

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:

        if (jCheckBox1.isSelected()) {

            NominaBoton.setEnabled(true);
            EmpleadoBoton.setEnabled(false);
            CheckBoxFecha.setEnabled(false);
            CheckBoxValor.setEnabled(false);
            Fecha.setVisible(true);
            DiaInicio.setVisible(false);
            MesInicio.setVisible(false);
            AñoInicio.setVisible(false);

            ID.setEditable(false);
            ID.setText("");
            NombrePago1.setText("");
            Cargo.setText("");
            Salario = ("");
            estado = ("");
            Fecha.setText("");
            Valor.setText("");
            jLabel11.setVisible(false);
            Identificacion1.setText("");

            TotalNomina.setText("El Valor Total De Nomina Es: " + salario);

        } else {
            NominaBoton.setEnabled(false);
            EmpleadoBoton.setEnabled(true);

            CheckBoxFecha.setEnabled(true);
            CheckBoxValor.setEnabled(true);
            ID.setEditable(true);
            ID.setText("");
            NombrePago1.setText("");
            Cargo.setText("");
            Salario = ("");
            estado = ("");
            Fecha.setText("");
            Valor.setText("");
            jLabel11.setVisible(true);
            Identificacion1.setText("");
            TotalNomina.setText("");
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void EmpleadoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleadoBotonActionPerformed
        // TODO add your handling code here:
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
        String day = c.DiaEnLetras(dia);
        String Mes = c.MesEnLetras(mes);
        String f = dia + "/" + Mes + "/" + año + "/ " + hora + ":" + min;

        String d[] = new String[6], saldo = "";
        int validacion = 0, valor = 0;

        d[0] = NombrePago1.getText();
        if (ModificarFecha == true) {
            
            
            if (DiaInicio.getSelectedIndex() != 0
                    && MesInicio.getSelectedIndex() != 0
                    && AñoInicio.getSelectedIndex() != 0) {
                

                
                    d[1] = DiaInicio.getSelectedItem().toString()
                            + " / " + MesInicio.getSelectedItem().toString()
                            + " / " + AñoInicio.getSelectedItem().toString();
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Por favor indique FECHA.");
                valor++;
            }
            
        } else {
            d[1] = Fecha.getText().trim();
        }

        if (ModificarValor == true) {
            d[2] = Valor.getText();
            if (d[2].equals(Salario)) {

                Valor.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "este varlor deve ser diferente \n"
                        + "           al salario del empleado.");
                valor++;

            }
        } else {
            d[2] = Valor.getText();
        }

        d[3] = Cargo.getText();
        d[4] = Identificacion1.getText();
        d[5] = ID.getText();

        if ("".equals(d[5]) || "".equals(d[4])) {
            validacion++;
            ID.setBackground(Color.red);
        }
        if("".equals(d[2])){
        validacion++;
        Valor.setBackground(Color.RED);
        }

        if (valor == 0) {
            if (validacion == 0) {

                if ("Activo".equals(estado)) {
                    try {

                        //en las segundas comillas va el usuario de mysql y en las terceras va la contraseña.
                        Connection on = ClaseMetodos.conectar();

                        //esta linea de codigo le da las intrucciones a la base de datos
                        PreparedStatement pst = on.prepareStatement(
                                "SELECT Fecha, Ingreso, Egreso, Saldo FROM contavilidad");
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
                                pst2.setString(2, d[1]);
                                pst2.setString(3, "Pago salario a empleado");
                                pst2.setString(4, "");
                                pst2.setString(5, d[2]);
                                if (contador == 0) {
                                    saldo = "0";
                                }
                                if (saldo != "0") {
                                    int sald = Integer.parseInt(saldo.trim());
                                    int pagado = Integer.parseInt(d[2]);
                                    sald = sald - pagado;
                                    saldo = Integer.toString(sald);

                                    pst2.setString(6, saldo);
                                    pst2.setString(7, d[0]);
                                    pst2.setString(8, d[4]);
                                    pst2.setString(9, "Nomina");
                                    pst2.executeUpdate();

                                    on.close();
                                    JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");

                                    NombrePago1.setText("");
                                    Fecha.setText("");
                                    Valor.setText("");
                                    Cargo.setText("");
                                    Identificacion1.setText("");
                                    ID.setText("");
                                    DiaInicio.setSelectedIndex(0);
                                    MesInicio.setSelectedIndex(0);
                                    AñoInicio.setSelectedIndex(0);

                                } else {
                                    JOptionPane.showMessageDialog(
                                            null, "EN ESTOS MOMENTOS NO SE PUEDE REGISTRAR EGRESO \n"
                                            + "            POR FALTA DE RECURSOS");
                                }
                            }

                        } catch (SQLException e) {
                            System.err.println("error al registrar egreso " + e);
                            JOptionPane.showMessageDialog(
                                    null, "Error en el sistema contacte con el administrador.");
                        }

                    } catch (SQLException e) {
                        System.out.println("error en el boton = " + e);
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null, "Este empleado no se encuentra Activo");
                }

            } else {
                JOptionPane.showMessageDialog(
                        null, "DEBES RELLENAR TODOS LOS CAMPOS \n"
                        + "LOS CAMPOS MARCADOS CON ROJO SON OBLIGATORIOS.");
            }
        }

    }//GEN-LAST:event_EmpleadoBotonActionPerformed

    private void CheckBoxFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxFechaActionPerformed
        // TODO add your handling code here:
        if (CheckBoxFecha.isSelected()) {
            JOptionPane.showMessageDialog(null, "Por favor Introduzca Fecha");
            ModificarFecha = true;
            Fecha.setVisible(false);
            DiaInicio.setVisible(true);
            MesInicio.setVisible(true);
            AñoInicio.setVisible(true);
        } else {
            ModificarFecha = false;
            Fecha.setVisible(true);
            DiaInicio.setVisible(false);
            MesInicio.setVisible(false);
            AñoInicio.setVisible(false);

        }
    }//GEN-LAST:event_CheckBoxFechaActionPerformed

    private void CheckBoxValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxValorActionPerformed
        // TODO add your handling code here:
        if (CheckBoxValor.isSelected()) {
            ModificarValor = true;
            JOptionPane.showMessageDialog(null, "Al modificar este varlor, deve ser diferente \n"
                    + "           al salario del empleado.");
            Valor.setEditable(true);
            Valor.setText("");
        } else {
            ModificarValor = false;
            Valor.setEditable(false);
            Valor.setBackground(Color.WHITE);
            Valor.setText(Salario);
        }
    }//GEN-LAST:event_CheckBoxValorActionPerformed

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
            java.util.logging.Logger.getLogger(PagarSueldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagarSueldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagarSueldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagarSueldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagarSueldo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> AñoInicio;
    private javax.swing.JLabel Background;
    private javax.swing.JTextField Cargo;
    private javax.swing.JCheckBox CheckBoxFecha;
    private javax.swing.JCheckBox CheckBoxValor;
    public static javax.swing.JComboBox<String> DiaInicio;
    private javax.swing.JButton EmpleadoBoton;
    private javax.swing.JTextField Fecha;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Identificacion1;
    public static javax.swing.JComboBox<String> MesInicio;
    private javax.swing.JTextField NombrePago1;
    private javax.swing.JButton NominaBoton;
    private javax.swing.JLabel Stiquer;
    private javax.swing.JLabel TotalNomina;
    private javax.swing.JTable Trabajadores;
    private javax.swing.JTextField Valor;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void BuscarDocumento() {
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
        String day = c.DiaEnLetras(dia);
        String Mes = c.MesEnLetras(mes);
        String f = dia + "/" + Mes + "/" + año + "/ " + hora + ":" + min;

        try {
            Connection cn = Clases.ClaseMetodos.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from Trabajadores where No_Identificacion ='" + id + "'");
            ResultSet rs = pst.executeQuery();
            String Nombre = "";
            if (rs.next()) {

                Nombre = (rs.getString("Apellidos"));
                Nombre += (rs.getString("Nombres"));
                NombrePago1.setText(Nombre);
                Cargo.setText(rs.getString("Cargo"));
                Salario = (rs.getString("Sueldo"));
                estado = (rs.getString("Estados"));

                Identificacion1.setText(rs.getString("No_Identificacion"));
                cn.close();
                Fecha.setText(f);
                Valor.setText(Salario);
                jLabel11.setForeground(Color.WHITE);
                jLabel11.setText(estado);

            } else {
                if ("".equals(id)) {
                    jLabel11.setVisible(true);
                    jLabel11.setForeground(Color.red);
                    jLabel11.setText("<= Digite Documento de Empleado.");
                    Nombre = ("");

                    NombrePago1.setText("");
                    Cargo.setText("");
                    Salario = ("");
                    estado = ("");
                    Fecha.setText("");
                    Valor.setText("");

                    Identificacion1.setText("");
                } else {
                    jLabel11.setVisible(true);
                    jLabel11.setForeground(Color.red);
                    jLabel11.setText("Este numero no cincide.");
                    Nombre = ("");

                    NombrePago1.setText("");
                    Cargo.setText("");
                    Salario = ("");
                    estado = ("");
                    Fecha.setText("");
                    Valor.setText("");

                    Identificacion1.setText("");
                }
            }
        } catch (Exception e) {
            System.out.println("este fallo al buscar... " + e);
        }
    }
}
