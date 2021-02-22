package Clases;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class ClaseNotas {

    //este es la coneccion con ClaseMetodos.
    ClaseMetodos c = new ClaseMetodos();

    //Variables para consultal datos
    String[] b = new String[61];
    String n[] = new String[103];
    String Nombre = "";

    public void ConsultarNotasPrimaria(String numero) {
        try {
            //Conexion con base de datos.
            Connection ccn = ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = ccn.prepareStatement("select * from notas_primaria where ID_Alumno = ?");

            pst.setString(1, numero);
            ResultSet rs = pst.executeQuery();
            // con este codigo intento obtener los valores almacenados en la base de datos alumnos

            if (rs.next()) {

                n[1] = rs.getString("Fecha");
                n[2] = rs.getString("ID_Alumno");
                n[3] = rs.getString("Grado");
                n[4] = rs.getString("Periodo1");
                n[5] = rs.getString("Periodo2");
                n[6] = rs.getString("Periodo3");
                n[7] = rs.getString("Periodo4");
                n[8] = rs.getString("AREA_DE_MATEMATICASp1");
                n[9] = rs.getString("AREA_DE_MATEMATICASp2");
                n[10] = rs.getString("AREA_DE_MATEMATICASp3");
                n[11] = rs.getString("AREA_DE_MATEMATICASp4");
                n[12] = rs.getString("DesempeñoAreaMatematicas");
                n[13] = rs.getString("MATEMATICASp1");
                n[14] = rs.getString("MATEMATICASp2");
                n[15] = rs.getString("MATEMATICASp3");
                n[16] = rs.getString("MATEMATICASp4");
                n[17] = rs.getString("DesempeñoMatematicas");
                n[18] = rs.getString("GEOMETRIAp1");
                n[19] = rs.getString("GEOMETRIAp2");
                n[20] = rs.getString("GEOMETRIAp3");
                n[21] = rs.getString("GEOMETRIAp4");
                n[22] = rs.getString("DesempeñoGeometria");
                n[23] = rs.getString("AREA_DE_HUMANIDADES_E_IDIOMA_EXTRANJEROp1");
                n[24] = rs.getString("AREA_DE_HUMANIDADES_E_IDIOMA_EXTRANJEROp2");
                n[25] = rs.getString("AREA_DE_HUMANIDADES_E_IDIOMA_EXTRANJEROp3");
                n[26] = rs.getString("AREA_DE_HUMANIDADES_E_IDIOMA_EXTRANJEROp4");
                n[27] = rs.getString("DesempeñoAreaHumanidades");
                n[28] = rs.getString("CASTELLANOp1");
                n[29] = rs.getString("CASTELLANOp2");
                n[30] = rs.getString("CASTELLANOp3");
                n[31] = rs.getString("CASTELLANOp4");
                n[32] = rs.getString("DesempeñoCastellano");
                n[33] = rs.getString("INGLESp1");
                n[34] = rs.getString("INGLESp2");
                n[35] = rs.getString("INGLESp3");
                n[36] = rs.getString("INGLESp4");
                n[37] = rs.getString("DesempeñoIngles");
                n[38] = rs.getString("CIENCIAS_NATURALES_Y_EDUCACION_AMBIENTALp1");
                n[39] = rs.getString("CIENCIAS_NATURALES_Y_EDUCACION_AMBIENTALp2");
                n[40] = rs.getString("CIENCIAS_NATURALES_Y_EDUCACION_AMBIENTALp3");
                n[41] = rs.getString("CIENCIAS_NATURALES_Y_EDUCACION_AMBIENTALp4");
                n[42] = rs.getString("DesempeñoNaturalesEduAmbiental");
                n[43] = rs.getString("NATURALESp1");
                n[44] = rs.getString("NATURALESp2");
                n[45] = rs.getString("NATURALESp3");
                n[46] = rs.getString("NATURALESp4");
                n[47] = rs.getString("DesempeñoNaturales");
                n[48] = rs.getString("AREA_DE_CIENCIAS_SOCIALESp1");
                n[49] = rs.getString("AREA_DE_CIENCIAS_SOCIALESp2");
                n[50] = rs.getString("AREA_DE_CIENCIAS_SOCIALESp3");
                n[51] = rs.getString("AREA_DE_CIENCIAS_SOCIALESp4");
                n[52] = rs.getString("DesempeñoAreaSociales");
                n[53] = rs.getString("CIENCIAS_SOCIALESp1");
                n[54] = rs.getString("CIENCIAS_SOCIALESp2");
                n[55] = rs.getString("CIENCIAS_SOCIALESp3");
                n[56] = rs.getString("CIENCIAS_SOCIALESp4");
                n[57] = rs.getString("DesempeñoSociales");
                n[58] = rs.getString("CONSTITUCION_POLITICAp1");
                n[59] = rs.getString("CONSTITUCION_POLITICAp2");
                n[60] = rs.getString("CONSTITUCION_POLITICAp3");
                n[61] = rs.getString("CONSTITUCION_POLITICAp4");
                n[62] = rs.getString("DesempeñoContitucion");
                n[63] = rs.getString("EDUCACION_ETICA_ACTITUDES_Y_VALORESp1");
                n[64] = rs.getString("EDUCACION_ETICA_ACTITUDES_Y_VALORESp2");
                n[65] = rs.getString("EDUCACION_ETICA_ACTITUDES_Y_VALORESp3");
                n[66] = rs.getString("EDUCACION_ETICA_ACTITUDES_Y_VALORESp4");
                n[67] = rs.getString("DesempeñoEticaValores");
                n[68] = rs.getString("EDUCACION_ARTISTICAp1");
                n[69] = rs.getString("EDUCACION_ARTISTICAp2");
                n[70] = rs.getString("EDUCACION_ARTISTICAp3");
                n[71] = rs.getString("EDUCACION_ARTISTICAp4");
                n[72] = rs.getString("DesempeñoArtistica");
                n[73] = rs.getString("CATEDRA_DE_PAZp1");
                n[74] = rs.getString("CATEDRA_DE_PAZp2");
                n[75] = rs.getString("CATEDRA_DE_PAZp3");
                n[76] = rs.getString("CATEDRA_DE_PAZp4");
                n[77] = rs.getString("DesempñoCatedraDePaz");
                n[78] = rs.getString("EDUCACION_CRISTIANAp1");
                n[79] = rs.getString("EDUCACION_CRISTIANAp2");
                n[80] = rs.getString("EDUCACION_CRISTIANAp3");
                n[81] = rs.getString("EDUCACION_CRISTIANAp4");
                n[82] = rs.getString("DesempeñoEduCristiana");
                n[83] = rs.getString("EDUCACION_FISICA_RECREACION_Y_DEPORTESp1");
                n[84] = rs.getString("EDUCACION_FISICA_RECREACION_Y_DEPORTESp2");
                n[85] = rs.getString("EDUCACION_FISICA_RECREACION_Y_DEPORTESp3");
                n[86] = rs.getString("EDUCACION_FISICA_RECREACION_Y_DEPORTESp4");
                n[87] = rs.getString("DesempeñoDeportes");
                n[88] = rs.getString("TECNOLOGIA_E_INFORMATICAp1");
                n[89] = rs.getString("TECNOLOGIA_E_INFORMATICAp2");
                n[90] = rs.getString("TECNOLOGIA_E_INFORMATICAp3");
                n[91] = rs.getString("TECNOLOGIA_E_INFORMATICAp4");
                n[92] = rs.getString("DesempeñoInformatica");
                n[93] = rs.getString("COMPORTAMIENTOp1");
                n[94] = rs.getString("COMPORTAMIENTOp2");
                n[95] = rs.getString("COMPORTAMIENTOp3");
                n[96] = rs.getString("COMPORTAMIENTOp4");
                n[97] = rs.getString("DesempeñoComportamiento");
                n[98] = rs.getString("Fallas_Justificadas");
                n[99] = rs.getString("Fallas_Sin_Justificar");
                n[100] = rs.getString("Observaciones");

            } else {
                JOptionPane.showMessageDialog(null, "No coincide el numero: "
                        + " \n con los datos almacenados");
                //ce.setVisible(true);

            }

            ccn.close();
        } catch (SQLException e) {
            System.out.println("aqui hatuu errro " + e);

        }

    }

    public void ConsultarNotasTrancision(String numero) {

        try {
            //Conexion con base de datos.
            Connection ccn = ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = ccn.prepareStatement("select * from notas where ID_Alumno = ?");

            pst.setString(1, numero);
            ResultSet rs = pst.executeQuery();
            // con este codigo intento obtener los valores almacenados en la base de datos alumnos

            if (rs.next()) {

                b[0] = rs.getString("ID_Notas");
                b[1] = rs.getString("Fecha");
                b[2] = rs.getString("ID_Alumno");
                b[3] = rs.getString("Grado");
                b[4] = rs.getString("Periodo1");
                b[5] = rs.getString("Periodo2");
                b[6] = rs.getString("Periodo3");
                b[7] = rs.getString("Periodo4");
                b[8] = rs.getString("DIMENSION_COGNITIVAp1");
                b[9] = rs.getString("DIMENSION_COGNITIVAp2");
                b[10] = rs.getString("DIMENSION_COGNITIVAp3");
                b[11] = rs.getString("DIMENSION_COGNITIVAp4");
                b[12] = rs.getString("DesempeñoDCognitiva");
                b[13] = rs.getString("DIMENSION_COMUNICATIVAp1");
                b[14] = rs.getString("DIMENSION_COMUNICATIVAp2");
                b[15] = rs.getString("DIMENSION_COMUNICATIVAp3");
                b[16] = rs.getString("DIMENSION_COMUNICATIVAp4");
                b[17] = rs.getString("DesempeñoDComunicativa");
                b[18] = rs.getString("DIMENSION_SOCIOAFECTIVAp1");
                b[19] = rs.getString("DIMENSION_SOCIOAFECTIVAp2");
                b[20] = rs.getString("DIMENSION_SOCIOAFECTIVAp3");
                b[21] = rs.getString("DIMENSION_SOCIOAFECTIVAp4");
                b[22] = rs.getString("DesempeñoDSocioafectiva");
                b[23] = rs.getString("DIMENSION_CORPORALp1");
                b[24] = rs.getString("DIMENSION_CORPORALp2");
                b[25] = rs.getString("DIMENSION_CORPORALp3");
                b[26] = rs.getString("DIMENSION_CORPORALp4");
                b[27] = rs.getString("DesempeñoDCorporal");
                b[28] = rs.getString("DIMENSION_ETICA_ACTITUDES_Y_VALORESp1");
                b[29] = rs.getString("DIMENSION_ETICA_ACTITUDES_Y_VALORESp2");
                b[30] = rs.getString("DIMENSION_ETICA_ACTITUDES_Y_VALORESp3");
                b[31] = rs.getString("DIMENSION_ETICA_ACTITUDES_Y_VALORESp4");
                b[32] = rs.getString("DesempeñoDEticaValores");
                b[33] = rs.getString("DIMENSION_ESTETICAp1");
                b[34] = rs.getString("DIMENSION_ESTETICAp2");
                b[35] = rs.getString("DIMENSION_ESTETICAp3");
                b[36] = rs.getString("DIMENSION_ESTETICAp4");
                b[37] = rs.getString("DesempeñoDEstetica");
                b[38] = rs.getString("IDIOMA_EXTRANJERO_E_INGLESp1");
                b[39] = rs.getString("IDIOMA_EXTRANJERO_E_INGLESp2");
                b[40] = rs.getString("IDIOMA_EXTRANJERO_E_INGLESp3");
                b[41] = rs.getString("IDIOMA_EXTRANJERO_E_INGLESp4");
                b[42] = rs.getString("DesempeñoIngles");
                b[43] = rs.getString("EDUCACION_CRISTIANAp1");
                b[44] = rs.getString("EDUCACION_CRISTIANAp2");
                b[45] = rs.getString("EDUCACION_CRISTIANAp3");
                b[46] = rs.getString("EDUCACION_CRISTIANAp4");
                b[47] = rs.getString("DesempeñoEducacionCristiana");
                b[48] = rs.getString("TECNOLOGIA_E_INFORMATICAp1");
                b[49] = rs.getString("TECNOLOGIA_E_INFORMATICAp2");
                b[50] = rs.getString("TECNOLOGIA_E_INFORMATICAp3");
                b[51] = rs.getString("TECNOLOGIA_E_INFORMATICAp4");
                b[52] = rs.getString("DesempeñoInformatica");
                b[53] = rs.getString("COMPORTAMIENTOp1");
                b[54] = rs.getString("COMPORTAMIENTOp2");
                b[55] = rs.getString("COMPORTAMIENTOp3");
                b[56] = rs.getString("COMPORTAMIENTOp4");
                b[57] = rs.getString("DesempeñoComportamiento");
                b[58] = rs.getString("Fallas_Justificadas");
                b[59] = rs.getString("Fallas_Sin_Justificar");
                b[60] = rs.getString("Observaciones");

            } else {
                JOptionPane.showMessageDialog(null, "No coincide el numero: "
                        + " \n con los datos almacenados");
                //ce.setVisible(true);

            }

            ccn.close();
        } catch (SQLException e) {
            System.out.println("aqui haty errro " + e);

        }

    }

    public void ConsultarNombre(String numero) {

        try {

            //Conexion con base de datos.
            Connection cn = ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = cn.prepareStatement("select * from alumnos where Documento = ?");

            pst.setString(1, numero);
            ResultSet rs = pst.executeQuery();
            // con este codigo intento obtener los valores almacenados en la base de datos alumnos
            if (rs.next()) {

                Nombre = rs.getString("Apellidos");
                Nombre += " "+rs.getString("Nombres");
            }

        } catch (SQLException e) {
            System.out.println("este error " + e);
        }
    }

    public void ConsultarNombrePrimaria(String numero) {
        try {

            //Conexion con base de datos.
            Connection cn = ClaseMetodos.conectar();

            //esta linea de codigo le da las intrucciones a la base de datos
            PreparedStatement pst = cn.prepareStatement("select * from alumnos where Documento = ?");

            pst.setString(1, numero);
            ResultSet rs = pst.executeQuery();
            // con este codigo intento obtener los valores almacenados en la base de datos alumnos
            if (rs.next()) {

                Nombre = rs.getString("Apellidos");
                Nombre += " "+rs.getString("Nombres");
            }

        } catch (SQLException e) {
            System.out.println("este errorrr " + e);
        }
    }

    public void CrearBoletinPrimaria(String numero, String periodo){
        
        ConsultarNombrePrimaria(numero);
        ConsultarNotasPrimaria(numero);
        
        /*n[1] = rs.getString("Fecha");
                n[2] = rs.getString("ID_Alumno");
                n[3] = rs.getString("Grado");
                n[4] = rs.getString("Periodo1");
                n[5] = rs.getString("Periodo2");
                n[6] = rs.getString("Periodo3");
                n[7] = rs.getString("Periodo4");
                n[8] = rs.getString("AREA_DE_MATEMATICASp1");
                n[9] = rs.getString("AREA_DE_MATEMATICASp2");
                n[10] = rs.getString("AREA_DE_MATEMATICASp3");
                n[11] = rs.getString("AREA_DE_MATEMATICASp4");
                n[12] = rs.getString("DesempeñoAreaMatematicas");
                n[13] = rs.getString("MATEMATICASp1");
                n[14] = rs.getString("MATEMATICASp2");
                n[15] = rs.getString("MATEMATICASp3");
                n[16] = rs.getString("MATEMATICASp4");
                n[17] = rs.getString("DesempeñoMatematicas");
                n[18] = rs.getString("GEOMETRIAp1");
                n[19] = rs.getString("GEOMETRIAp2");
                n[20] = rs.getString("GEOMETRIAp3");
                n[21] = rs.getString("GEOMETRIAp4");
                n[22] = rs.getString("DesempeñoGeometria");
                n[23] = rs.getString("AREA_DE_HUMANIDADES_E_IDIOMA_EXTRANJEROp1");
                n[24] = rs.getString("AREA_DE_HUMANIDADES_E_IDIOMA_EXTRANJEROp2");
                n[25] = rs.getString("AREA_DE_HUMANIDADES_E_IDIOMA_EXTRANJEROp3");
                n[26] = rs.getString("AREA_DE_HUMANIDADES_E_IDIOMA_EXTRANJEROp4");
                n[27] = rs.getString("DesempeñoAreaHumanidades");
                n[28] = rs.getString("CASTELLANOp1");
                n[29] = rs.getString("CASTELLANOp2");
                n[30] = rs.getString("CASTELLANOp3");
                n[31] = rs.getString("CASTELLANOp4");
                n[32] = rs.getString("DesempeñoCastellano");
                n[33] = rs.getString("INGLESp1");
                n[34] = rs.getString("INGLESp2");
                n[35] = rs.getString("INGLESp3");
                n[36] = rs.getString("INGLESp4");
                n[37] = rs.getString("DesempeñoIngles");
                n[38] = rs.getString("CIENCIAS_NATURALES_Y_EDUCACION_AMBIENTALp1");
                n[39] = rs.getString("CIENCIAS_NATURALES_Y_EDUCACION_AMBIENTALp2");
                n[40] = rs.getString("CIENCIAS_NATURALES_Y_EDUCACION_AMBIENTALp3");
                n[41] = rs.getString("CIENCIAS_NATURALES_Y_EDUCACION_AMBIENTALp4");
                n[42] = rs.getString("DesempeñoNaturalesEduAmbiental");
                n[43] = rs.getString("NATURALESp1");
                n[44] = rs.getString("NATURALESp2");
                n[45] = rs.getString("NATURALESp3");
                n[46] = rs.getString("NATURALESp4");
                n[47] = rs.getString("DesempeñoNaturales");
                n[48] = rs.getString("AREA_DE_CIENCIAS_SOCIALESp1");
                n[49] = rs.getString("AREA_DE_CIENCIAS_SOCIALESp2");
                n[50] = rs.getString("AREA_DE_CIENCIAS_SOCIALESp3");
                n[51] = rs.getString("AREA_DE_CIENCIAS_SOCIALESp4");
                n[52] = rs.getString("DesempeñoAreaSociales");
                n[53] = rs.getString("CIENCIAS_SOCIALESp1");
                n[54] = rs.getString("CIENCIAS_SOCIALESp2");
                n[55] = rs.getString("CIENCIAS_SOCIALESp3");
                n[56] = rs.getString("CIENCIAS_SOCIALESp4");
                n[57] = rs.getString("DesempeñoSociales");
                n[58] = rs.getString("CONSTITUCION_POLITICAp1");
                n[59] = rs.getString("CONSTITUCION_POLITICAp2");
                n[60] = rs.getString("CONSTITUCION_POLITICAp3");
                n[61] = rs.getString("CONSTITUCION_POLITICAp4");
                n[62] = rs.getString("DesempeñoContitucion");
                n[63] = rs.getString("EDUCACION_ETICA_ACTITUDES_Y_VALORESp1");
                n[64] = rs.getString("EDUCACION_ETICA_ACTITUDES_Y_VALORESp2");
                n[65] = rs.getString("EDUCACION_ETICA_ACTITUDES_Y_VALORESp3");
                n[66] = rs.getString("EDUCACION_ETICA_ACTITUDES_Y_VALORESp4");
                n[67] = rs.getString("DesempeñoEticaValores");
                n[68] = rs.getString("EDUCACION_ARTISTICAp1");
                n[69] = rs.getString("EDUCACION_ARTISTICAp2");
                n[70] = rs.getString("EDUCACION_ARTISTICAp3");
                n[71] = rs.getString("EDUCACION_ARTISTICAp4");
                n[72] = rs.getString("DesempeñoArtistica");
                n[73] = rs.getString("CATEDRA_DE_PAZp1");
                n[74] = rs.getString("CATEDRA_DE_PAZp2");
                n[75] = rs.getString("CATEDRA_DE_PAZp3");
                n[76] = rs.getString("CATEDRA_DE_PAZp4");
                n[77] = rs.getString("DesempñoCatedraDePaz");
                n[78] = rs.getString("EDUCACION_CRISTIANAp1");
                n[79] = rs.getString("EDUCACION_CRISTIANAp2");
                n[80] = rs.getString("EDUCACION_CRISTIANAp3");
                n[81] = rs.getString("EDUCACION_CRISTIANAp4");
                n[82] = rs.getString("DesempeñoEduCristiana");
                n[83] = rs.getString("EDUCACION_FISICA_RECREACION_Y_DEPORTESp1");
                n[84] = rs.getString("EDUCACION_FISICA_RECREACION_Y_DEPORTESp2");
                n[85] = rs.getString("EDUCACION_FISICA_RECREACION_Y_DEPORTESp3");
                n[86] = rs.getString("EDUCACION_FISICA_RECREACION_Y_DEPORTESp4");
                n[87] = rs.getString("DesempeñoDeportes");
                n[88] = rs.getString("TECNOLOGIA_E_INFORMATICAp1");
                n[89] = rs.getString("TECNOLOGIA_E_INFORMATICAp2");
                n[90] = rs.getString("TECNOLOGIA_E_INFORMATICAp3");
                n[91] = rs.getString("TECNOLOGIA_E_INFORMATICAp4");
                n[92] = rs.getString("DesempeñoInformatica");
                n[93] = rs.getString("COMPORTAMIENTOp1");
                n[94] = rs.getString("COMPORTAMIENTOp2");
                n[95] = rs.getString("COMPORTAMIENTOp3");
                n[96] = rs.getString("COMPORTAMIENTOp4");
                n[97] = rs.getString("DesempeñoComportamiento");
                n[98] = rs.getString("Fallas_Justificadas");
                n[99] = rs.getString("Fallas_Sin_Justificar");
                n[100] = rs.getString("Observaciones");*/
        
        //codigo para consultar fecha
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
        String day = c.DiaEnLetras(dia);
        String Mes = c.MesEnLetras(mes);
        String fechaS = dia + "-" + Mes + "-" + año + "-" + hora + "_" + min;
        
        
        try {
            
            //se crea un documento en blanco
            com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
            //codigo ruta de ingreso al sistema
            String ruta = System.getProperty("user.home");
            //codigo ruta y nombre del documento sin olvidar la extencion
            PdfWriter.getInstance(documento, new FileOutputStream(ruta
                    + "/Documents/PrimerosProgramasEnNetBeans/ProyectoCECARD2000"
                    + "/documentosPDF/Boletin NombreAlumnofechaSPrimaria.pdf"));

            
            
            //se crea un objeto de la clase Image
            com.itextpdf.text.Image image;
            image = com.itextpdf.text.Image.getInstance("src/IMG/encabezado.PNG");
            image.setAlignment(Chunk.ANCHOR);
            image.scaleToFit(850, 90);

            //se crea un objeto de la clase Paragraph
            Paragraph parrafo = new Paragraph();
            
            
            //se crea tabla
            PdfPTable table = new PdfPTable(9);
            //ancho a utilizar por la tabla en porcentage
            table.setWidthPercentage(100);
            //se establece ancho de colomnas
            int t[] = {27, 3, 3, 3, 3, 3, 3, 3, 3};

            table.setWidths(t);
            //se crea celda con la imagen
            PdfPCell celda = new PdfPCell(image);
            //se combinan las celdas
            celda.setColspan(9);
            table.addCell(celda);
            //tipo, tamaño y color de letra
            parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            //se crea celda
            PdfPCell celda2 = new PdfPCell();
            //se combinan las celdas
            parrafo.add("NOMBRE DEL NIÑO: " + Nombre/*+ Nombredelniño*/);
            celda2.setColspan(4);
            celda2.addElement(parrafo);
            //se añade
            table.addCell(celda2);
            //se crea celda
            PdfPCell celda3 = new PdfPCell();
            Paragraph parrafo1 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo1.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo1.add("GRADO: " + n[3]/*+ gradodealumno*/);
            //se combinan la celda
            celda3.setColspan(5);
            celda3.addElement(parrafo1);
            //se añade
            table.addCell(celda3);

            //se crea celda
            PdfPCell celda4 = new PdfPCell();
            //se combinan las celdas
            Paragraph parrafo2 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo2.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo2.add("PERIODO: " +periodo/*+ Periodo*/);
            celda4.setColspan(4);
            celda4.addElement(parrafo2);
            //se añade
            table.addCell(celda4);
            //se crea celda
            Paragraph parrafo3 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo3.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            PdfPCell celda5 = new PdfPCell();
            parrafo3.add("AÑO: " + año);
            //se combinan la celda
            celda5.setColspan(5);
            celda5.addElement(parrafo3);
            //se añade
            table.addCell(celda5);

            //se crea celda veacia
            PdfPCell celdaV = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo30 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo30.setFont(FontFactory.getFont("Arial", 6, Font.BOLD, BaseColor.BLACK));
            parrafo30.add("           ");
            celdaV.setColspan(9);
            celdaV.addElement(parrafo30);
            //se añade
            table.addCell(celdaV);

            //se crea celda
            Paragraph parrafo4 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo4.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo4.add("           AREAS Y ASIGNATURAS");
            table.addCell(parrafo4);
            //Se crea nueva celda
            table.addCell("IH");
            //Se crea nueva celda
            table.addCell("IP");
            //Se crea nueva celda
            table.addCell("IIP");
            //Se crea nueva celda
            table.addCell("IIIP");
            //Se crea nueva celda
            table.addCell("IVP");
            //Se crea nueva celda
            table.addCell("DS");
            //Se crea nueva celda
            table.addCell("FS");
            //Se crea nueva celda
            table.addCell("FJ");

            //SE CREA CELDA VACIA
            PdfPCell celdaV233 = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo300099 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo300099.setFont(FontFactory.getFont("Arial", 6, Font.BOLD, BaseColor.BLACK));
            parrafo300099.add("            ");
            celdaV233.setColspan(9);
            celdaV233.addElement(parrafo300099);
            //se añade
            table.addCell(celdaV233);

            //Se crea nueva celda
            PdfPCell celda6 = new PdfPCell();
            Paragraph parrafo5 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo5.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo5.add("AREA DE MATEMATICAS");
            celda6.addElement(parrafo5);
            table.addCell(celda6);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[8]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[9]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[10]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[11]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[12]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            

            //Se crea nueva celda
            PdfPCell celda7 = new PdfPCell();
            Paragraph parrafo6 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo6.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo6.add("Matematicas");
            celda7.addElement(parrafo6);
            table.addCell(celda7);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(/*nota*/n[13]);
            //Se crea nueva celda
            table.addCell(n[14]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[15]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[16]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[17]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //Se crea nueva celda
            PdfPCell celda8 = new PdfPCell();
            Paragraph parrafo7 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo7.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo7.add("Geometria");
            celda8.addElement(parrafo7);
            table.addCell(celda8);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[18]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[19]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[20]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[21]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[22]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //Se crea nueva celda
            PdfPCell celda9 = new PdfPCell();
            Paragraph parrafo8 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo8.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo8.add("AREA DE HUMANIDADES E IDIOMA EXTRANJERO");
            celda9.addElement(parrafo8);
            table.addCell(celda9);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[23]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[24]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[25]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[26]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[27]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //Se crea nueva celda
            PdfPCell celda10 = new PdfPCell();
            Paragraph parrafo9 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo9.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo9.add("Castellano");
            celda10.addElement(parrafo9);
            table.addCell(celda10);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[28]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[29]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[30]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[31]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[32]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //Se crea nueva celda
            PdfPCell celda11 = new PdfPCell();
            Paragraph parrafo10 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo10.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo10.add("Ingles");
            celda11.addElement(parrafo10);
            table.addCell(celda11);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[33]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[34]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[35]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[36]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[37]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //Se crea nueva celda
            PdfPCell celda12 = new PdfPCell();
            Paragraph parrafo11 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo11.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo11.add("CIENCIAS NATURALES Y EDUCACION AMBIENTAL");
            celda12.addElement(parrafo11);
            table.addCell(celda12);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[38]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[39]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[40]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[41]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[42]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //Se crea nueva celda
            PdfPCell celda13 = new PdfPCell();
            Paragraph parrafo12 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo12.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo12.add("Naturales");
            celda13.addElement(parrafo12);
            table.addCell(celda13);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[43]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[44]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[45]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[46]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[47]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //Se crea nueva celda
            PdfPCell celda14 = new PdfPCell();
            Paragraph parrafo13 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo13.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo13.add("AREA DE CIENCIAS SOCIALES");
            celda14.addElement(parrafo13);
            table.addCell(celda14);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[48]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[49]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[50]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[51]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[52]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //Se crea nueva celda
            PdfPCell celda15 = new PdfPCell();
            Paragraph parrafo14 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo14.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo14.add("Ciencias sociales");
            celda15.addElement(parrafo14);
            table.addCell(celda15);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[53]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[54]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[55]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[56]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[57]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);
            
            //Se crea nueva celda
            PdfPCell celda16 = new PdfPCell();
            Paragraph parrafo15 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo15.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo15.add("Constitucion Politica");
            celda16.addElement(parrafo15);
            table.addCell(celda16);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[58]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[59]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[60]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[61]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[62]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            
            //Se crea nueva celda
            PdfPCell celda17 = new PdfPCell();
            Paragraph parrafo16 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo16.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo16.add("EDUCACION ETICA ACTITUDES Y VALORES");
            celda17.addElement(parrafo16);
            table.addCell(celda17);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[63]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[64]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[65]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[66]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[67]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);
            
            
            
            //Se crea nueva celda
            PdfPCell celda18 = new PdfPCell();
            Paragraph parrafo17 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo17.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo17.add("Educacion Artistica");
            celda18.addElement(parrafo17);
            table.addCell(celda18);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[68]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[69]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[70]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[71]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[72]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);
            
            
            //Se crea nueva celda
            PdfPCell celda19 = new PdfPCell();
            Paragraph parrafo18 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo18.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo18.add("Catedra de Paz");
            celda19.addElement(parrafo18);
            table.addCell(celda19);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[73]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[74]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[75]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[76]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[77]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);
            
            
            //Se crea nueva celda
            PdfPCell celda191 = new PdfPCell();
            Paragraph parrafo19 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo19.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo19.add("Educacion Cristiana");
            celda191.addElement(parrafo19);
            table.addCell(celda191);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[78]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[79]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[80]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[81]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[82]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);
            
            
            //Se crea nueva celda
            PdfPCell celda192 = new PdfPCell();
            Paragraph parrafo191 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo191.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo191.add("EDUCACION FISICA RECREACION Y DEPORTES");
            celda192.addElement(parrafo191);
            table.addCell(celda192);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[83]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[84]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[85]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[86]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[87]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);
            
            
            //Se crea nueva celda
            PdfPCell celda193 = new PdfPCell();
            Paragraph parrafo192 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo192.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo192.add("TECNOLOGIA E INFORMATICA");
            celda193.addElement(parrafo192);
            table.addCell(celda193);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[88]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[89]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[90]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[91]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[92]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);
            
            
            //Se crea nueva celda
            PdfPCell celda194 = new PdfPCell();
            Paragraph parrafo193 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo193.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo193.add("COMPORTAMIENTO");
            celda194.addElement(parrafo193);
            table.addCell(celda194);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(n[93]/*nota*/);
            //Se crea nuen celda
            table.addCell(n[94]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[95]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[96]/*nota*/);
            //Se crea nueva celda
            table.addCell(n[97]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(n[98]/*fsj*/);
            //Se crea nueva celda
            table.addCell(n[99]/*fj*/);
            
            //se crea celda de observaciones
            PdfPCell celdaU = new PdfPCell();
            Paragraph parrafoU = new Paragraph();

            //tipo, tamaño y color de letra
            parrafoU.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafoU.add("OBSERVACIONES: " + n[100]/*OBSERVACIONES*/);
            celdaU.setColspan(9);
            celdaU.addElement(parrafoU);
            table.addCell(celdaU);
            //se crea celda
            PdfPCell celd = new PdfPCell();
            celd.setColspan(9);
            Paragraph parrafo100 = new Paragraph();
            parrafo100.setFont(FontFactory.getFont("Arial", 8, Font.NORMAL, BaseColor.BLACK));
            parrafo100.add(
                    "BA: Bajo 1-5.9 B: Básico 6.0-7.9   A: Alto 8.0-9.0   "
                    + "S: Superior9.1-10.0  FJ: Falla justificada  FSJ: "
                    + "Sin justificar");
            celd.addElement(parrafo100);
            table.addCell(celd);

            //se crea celda
            PdfPCell celde = new PdfPCell();
            Paragraph parra = new Paragraph();
            parra.add("\n\n\n\n\nFIRMA DEL DIRECTOR(A)");
            celde.setColspan(1);
            celde.addElement(parra);
            table.addCell(celde);

            //table.addCell("");
            //se crea celda
            PdfPCell celde1 = new PdfPCell();
            Paragraph parraf = new Paragraph();
            parraf.add("\n\n\n\n\nFIRMA DEL DIRECTOR DE GRUPO");
            celde1.setColspan(8);
            celde1.addElement(parraf);
            table.addCell(celde1);

            //
            documento.open();
            documento.add(table);
            documento.close();
            /*
             */
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
            // determina el porcentage a ocupar del ancho del documento.
            /*tabla.setWidthPercentage(100);*/
            
            JOptionPane.showMessageDialog(null, "se creo boletin Primaria " + periodo);
            
        } catch (DocumentException | IOException e) {
            System.err.print("errrois este "+e);
        }
        
    }
    //metodo para crear boletin
    public void CrearBoletinTrancision(String numero, String periodo) {

        ConsultarNombre(numero);
        ConsultarNotasTrancision(numero);

        /*B[0] = "ID_Notas";
        B[1] = "Fecha";
        B[2] = "ID_Alumno";
        B[3] = "Grado";
        B[4] = "Periodo1";
        B[5] = "Periodo2";
        B[6] = "Periodo3";
        B[7] = "Periodo4";
        B[8] = "DIMENSION_COGNITIVAp1";
        B[9] = "DIMENSION_COGNITIVAp2";
        B[10] = "DIMENSION_COGNITIVAp3";
        B[11] = "DIMENSION_COGNITIVAp4";
        B[12] = "DesempeñoDCognitiva";
        B[13] = "DIMENSION_COMUNICATIVAp1";
        B[14] = "DIMENSION_COMUNICATIVAp2";
        B[15] = "DIMENSION_COMUNICATIVAp3";
        B[16] = "DIMENSION_COMUNICATIVAp4";
        B[17] = "DesempeñoDComunicativa";
        B[18] = "DIMENSION_SOCIOAFECTIVAp1";
        B[19] = "DIMENSION_SOCIOAFECTIVAp2";
        B[20] = "DIMENSION_SOCIOAFECTIVAp3";
        B[21] = "DIMENSION_SOCIOAFECTIVAp4";
        B[22] = "DesempeñoDSocioafectiva";
        B[23] = "DIMENSION_CORPORALp1";
        B[24] = "DIMENSION_CORPORALp2";
        B[25] = "DIMENSION_CORPORALp3";
        B[26] = "DIMENSION_CORPORALp4";
        B[27] = "DesempeñoDCorporal";
        B[28] = "DIMENSION_ETICA_ACTITUDES_Y_VALORESp1";
        B[29] = "DIMENSION_ETICA_ACTITUDES_Y_VALORESp2";
        B[30] = "DIMENSION_ETICA_ACTITUDES_Y_VALORESp3";
        B[31] = "DIMENSION_ETICA_ACTITUDES_Y_VALORESp4";
        B[32] = "DesempeñoDEticaValores";
        B[33] = "DIMENSION_ESTETICAp1";
        B[34] = "DIMENSION_ESTETICAp2";
        B[35] = "DIMENSION_ESTETICAp3";
        B[36] = "DIMENSION_ESTETICAp4";
        B[37] = "DesempeñoDEstetica";
        B[38] = "IDIOMA_EXTRANJERO_E_INGLESp1";
        B[39] = "IDIOMA_EXTRANJERO_E_INGLESp2";
        B[40] = "IDIOMA_EXTRANJERO_E_INGLESp3";
        B[41] = "IDIOMA_EXTRANJERO_E_INGLESp4";
        B[42] = "DesempeñoIngles";
        B[43] = "EDUCACION_CRISTIANAp1";
        B[44] = "EDUCACION_CRISTIANAp2";
        B[45] = "EDUCACION_CRISTIANAp3";
        B[46] = "EDUCACION_CRISTIANAp4";
        B[47] = "DesempeñoEducacionCristiana";
        B[48] = "TECNOLOGIA_E_INFORMATICAp1";
        B[49] = "TECNOLOGIA_E_INFORMATICAp2";
        B[50] = "TECNOLOGIA_E_INFORMATICAp3";
        B[51] = "TECNOLOGIA_E_INFORMATICAp4";
        B[52] = "DesempeñoInformatica";
        B[53] = "COMPORTAMIENTOp1";
        B[54] = "COMPORTAMIENTOp2";
        B[55] = "COMPORTAMIENTOp3";
        B[56] = "COMPORTAMIENTOp4";
        B[57] = "DesempeñoComportamiento";
        B[58] = "Fallas_Justificadas";
        B[59] = "Fallas_Sin_Justificar";
        B[60] = "Observaciones";*/
        //codigo para consultar fecha
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
        String day = c.DiaEnLetras(dia);
        String Mes = c.MesEnLetras(mes);
        String fechaS = dia + "-" + Mes + "-" + año + "-" + hora + "_" + min;

        try {

            //se crea un documento en blanco
            com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
            //codigo ruta de ingreso al sistema
            String ruta = System.getProperty("user.home");
            //codigo ruta y nombre del documento sin olvidar la extencion
            PdfWriter.getInstance(documento, new FileOutputStream(ruta
                    + "/Documents/PrimerosProgramasEnNetBeans/ProyectoCECARD2000"
                    + "/documentosPDF/Boletin NombreAlumnofechaS.pdf"));

            //se crea un objeto de la clase Image
            com.itextpdf.text.Image image;
            image = com.itextpdf.text.Image.getInstance("src/IMG/encabezado.PNG");
            image.setAlignment(Chunk.ANCHOR);
            image.scaleToFit(850, 90);

            //se crea un objeto de la clase Paragraph
            Paragraph parrafo = new Paragraph();

            /*//codigo para crear tabla especificando cuantas columnas se utilizaran
                        PdfPTable tabla = new PdfPTable(4);

             */
            //se crea tabla
            PdfPTable table = new PdfPTable(9);
            //ancho a utilizar por la tabla en porcentage
            table.setWidthPercentage(100);
            //se establece ancho de colomnas
            int t[] = {27, 3, 3, 3, 3, 3, 3, 3, 3};

            table.setWidths(t);
            //se crea celda con la imagen
            PdfPCell celda = new PdfPCell(image);
            //se combinan las celdas
            celda.setColspan(9);
            table.addCell(celda);
            //tipo, tamaño y color de letra
            parrafo.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            //se crea celda
            PdfPCell celda2 = new PdfPCell();
            //se combinan las celdas
            parrafo.add("NOMBRE DEL NIÑO: " + Nombre/*+ Nombredelniño*/);
            celda2.setColspan(4);
            celda2.addElement(parrafo);
            //se añade
            table.addCell(celda2);
            //se crea celda
            PdfPCell celda3 = new PdfPCell();
            Paragraph parrafo1 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo1.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo1.add("GRADO: " + b[3]/*+ gradodealumno*/);
            //se combinan la celda
            celda3.setColspan(5);
            celda3.addElement(parrafo1);
            //se añade
            table.addCell(celda3);

            //se crea celda
            PdfPCell celda4 = new PdfPCell();
            //se combinan las celdas
            Paragraph parrafo2 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo2.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo2.add("PERIODO: " +periodo/*+ Periodo*/);
            celda4.setColspan(4);
            celda4.addElement(parrafo2);
            //se añade
            table.addCell(celda4);
            //se crea celda
            Paragraph parrafo3 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo3.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            PdfPCell celda5 = new PdfPCell();
            parrafo3.add("AÑO: " + año);
            //se combinan la celda
            celda5.setColspan(5);
            celda5.addElement(parrafo3);
            //se añade
            table.addCell(celda5);

            //se crea celda veacia
            PdfPCell celdaV = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo30 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo30.setFont(FontFactory.getFont("Arial", 6, Font.BOLD, BaseColor.BLACK));
            parrafo30.add("           ");
            celdaV.setColspan(9);
            celdaV.addElement(parrafo30);
            //se añade
            table.addCell(celdaV);

            //se crea celda
            Paragraph parrafo4 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo4.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo4.add("           AREAS Y ASIGNATURAS");
            table.addCell(parrafo4);
            //Se crea nueva celda
            table.addCell("IH");
            //Se crea nueva celda
            table.addCell("IP");
            //Se crea nueva celda
            table.addCell("IIP");
            //Se crea nueva celda
            table.addCell("IIIP");
            //Se crea nueva celda
            table.addCell("IVP");
            //Se crea nueva celda
            table.addCell("DS");
            //Se crea nueva celda
            table.addCell("FS");
            //Se crea nueva celda
            table.addCell("FJ");

            //SE CREA CELDA VACIA
            PdfPCell celdaV233 = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo300099 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo300099.setFont(FontFactory.getFont("Arial", 6, Font.BOLD, BaseColor.BLACK));
            parrafo300099.add("            ");
            celdaV233.setColspan(9);
            celdaV233.addElement(parrafo300099);
            //se añade
            table.addCell(celdaV233);

            //Se crea nueva celda
            PdfPCell celda6 = new PdfPCell();
            Paragraph parrafo5 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo5.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo5.add("Dimensión COGNITIVA");
            celda6.addElement(parrafo5);
            table.addCell(celda6);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(b[8]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[9]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[10]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[11]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[12]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //SE CREA CELDA VACIA
            PdfPCell celdaV1 = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo300 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo300.setFont(FontFactory.getFont("Arial", 6, Font.BOLD, BaseColor.BLACK));
            parrafo300.add("           ");
            celdaV1.setColspan(9);
            celdaV1.addElement(parrafo300);
            //se añade
            table.addCell(celdaV1);

            //Se crea nueva celda
            PdfPCell celda7 = new PdfPCell();
            Paragraph parrafo6 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo6.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo6.add("Dimensión COMUNICATIVA");
            celda7.addElement(parrafo6);
            table.addCell(celda7);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(/*nota*/b[13]);
            //Se crea nueva celda
            table.addCell(b[14]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[15]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[16]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[17]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //SE CREA CELDA VACIA
            PdfPCell celdaV2 = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo3000 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo3000.setFont(FontFactory.getFont("Arial", 6, Font.BOLD, BaseColor.BLACK));
            parrafo3000.add("            ");
            celdaV2.setColspan(9);
            celdaV2.addElement(parrafo3000);
            //se añade
            table.addCell(celdaV2);

            //Se crea nueva celda
            PdfPCell celda8 = new PdfPCell();
            Paragraph parrafo7 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo7.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo7.add("Dimensión SOCIOAFECTIVA");
            celda8.addElement(parrafo7);
            table.addCell(celda8);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(b[18]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[19]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[20]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[21]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[22]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //SE CREA CELDA VACIA
            PdfPCell celdaV3 = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo30000 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo30000.setFont(FontFactory.getFont("Arial", 6, Font.BOLD, BaseColor.BLACK));
            parrafo30000.add("              ");
            celdaV3.setColspan(9);
            celdaV3.addElement(parrafo30000);
            //se añade
            table.addCell(celdaV3);

            //Se crea nueva celda
            PdfPCell celda9 = new PdfPCell();
            Paragraph parrafo8 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo8.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo8.add("Dimensión CORPORAL");
            celda9.addElement(parrafo8);
            table.addCell(celda9);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(b[23]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[24]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[25]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[26]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[27]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //SE CREA CELDA VACIA
            PdfPCell celdaV4 = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo301 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo301.setFont(FontFactory.getFont("Arial", 6, Font.BOLD, BaseColor.BLACK));
            parrafo301.add("             ");
            celdaV4.setColspan(9);
            celdaV4.addElement(parrafo301);
            //se añade
            table.addCell(celdaV4);

            //Se crea nueva celda
            PdfPCell celda10 = new PdfPCell();
            Paragraph parrafo9 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo9.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo9.add("Dimensión ETICA ACTITUDES Y VALORES");
            celda10.addElement(parrafo9);
            table.addCell(celda10);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(b[28]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[29]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[30]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[31]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[32]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //SE CREA CELDA VACIA
            PdfPCell celdaV5 = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo3011 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo3011.setFont(FontFactory.getFont("Arial", 6, Font.BOLD, BaseColor.BLACK));
            parrafo3011.add("          ");
            celdaV5.setColspan(9);
            celdaV5.addElement(parrafo3011);
            //se añade
            table.addCell(celdaV5);

            //Se crea nueva celda
            PdfPCell celda11 = new PdfPCell();
            Paragraph parrafo10 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo10.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo10.add("Dimensión ESTETICA");
            celda11.addElement(parrafo10);
            table.addCell(celda11);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(b[33]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[34]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[35]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[36]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[37]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //SE CREA CELDA VACIA
            PdfPCell celdaV6 = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo3012 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo3012.setFont(FontFactory.getFont("Arial", 6, Font.BOLD, BaseColor.BLACK));
            parrafo3012.add("            ");
            celdaV6.setColspan(9);
            celdaV6.addElement(parrafo3012);
            //se añade
            table.addCell(celdaV6);

            //Se crea nueva celda
            PdfPCell celda12 = new PdfPCell();
            Paragraph parrafo11 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo11.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo11.add("IDIOMA EXTRANGERO E INGLES");
            celda12.addElement(parrafo11);
            table.addCell(celda12);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(b[38]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[39]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[40]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[41]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[42]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //SE CREA CELDA VACIA
            PdfPCell celdaV7 = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo3021 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo3021.setFont(FontFactory.getFont("Arial", 12 / 2, Font.BOLD, BaseColor.BLACK));
            parrafo3021.add("          ");
            celdaV7.setColspan(9);
            celdaV7.addElement(parrafo3021);
            //se añade
            table.addCell(celdaV7);

            //Se crea nueva celda
            PdfPCell celda13 = new PdfPCell();
            Paragraph parrafo12 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo12.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo12.add("EDUCACION CRISTIANA");
            celda13.addElement(parrafo12);
            table.addCell(celda13);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(b[43]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[44]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[45]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[46]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[47]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //SE CREA CELDA VACIA
            PdfPCell celdaV8 = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo3081 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo3081.setFont(FontFactory.getFont("Arial", 6, Font.BOLD, BaseColor.BLACK));
            parrafo3081.add("          ");
            celdaV8.setColspan(9);
            celdaV8.addElement(parrafo3081);
            //se añade
            table.addCell(celdaV8);

            //Se crea nueva celda
            PdfPCell celda14 = new PdfPCell();
            Paragraph parrafo13 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo13.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo13.add("TECNOLOGIA E INFORMATICA");
            celda14.addElement(parrafo13);
            table.addCell(celda14);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(b[48]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[49]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[50]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[51]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[52]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(""/*fsj*/);
            //Se crea nueva celda
            table.addCell(""/*fj*/);

            //SE CREA CELDA VACIA
            PdfPCell celdaV9 = new PdfPCell();
            //Se crea parrafo
            Paragraph parrafo3019 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo3019.setFont(FontFactory.getFont("Arial", 12 / 2, Font.BOLD, BaseColor.BLACK));
            parrafo3019.add("          ");
            celdaV9.setColspan(9);
            celdaV9.addElement(parrafo3019);
            //se añade
            table.addCell(celdaV9);

            //Se crea nueva celda
            PdfPCell celda15 = new PdfPCell();
            Paragraph parrafo14 = new Paragraph();
            //tipo, tamaño y color de letra
            parrafo14.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafo14.add("COMPORTAMIENTO");
            celda15.addElement(parrafo14);
            table.addCell(celda15);

            //Se crea nueva celda
            table.addCell(""/*IH*/);
            //Se crea nueva celda
            table.addCell(b[53]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[54]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[55]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[56]/*nota*/);
            //Se crea nueva celda
            table.addCell(b[57]/*desempeño*/);
            //Se crea nueva celda
            table.addCell(b[58]/*fsj*/);
            //Se crea nueva celda
            table.addCell(b[59]/*fj*/);

            //se crea celda de observaciones
            PdfPCell celdaU = new PdfPCell();
            Paragraph parrafoU = new Paragraph();

            //tipo, tamaño y color de letra
            parrafoU.setFont(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
            parrafoU.add("OBSERVACIONES: " + b[60]/*OBSERVACIONES*/);
            celdaU.setColspan(9);
            celdaU.addElement(parrafoU);
            table.addCell(celdaU);
            //se crea celda
            PdfPCell celd = new PdfPCell();
            celd.setColspan(9);
            Paragraph parrafo100 = new Paragraph();
            parrafo100.setFont(FontFactory.getFont("Arial", 8, Font.NORMAL, BaseColor.BLACK));
            parrafo100.add(
                    "BA: Bajo 1-5.9 B: Básico 6.0-7.9   A: Alto 8.0-9.0   "
                    + "S: Superior9.1-10.0  FJ: Falla justificada  FSJ: "
                    + "Sin justificar");
            celd.addElement(parrafo100);
            table.addCell(celd);

            //se crea celda
            PdfPCell celde = new PdfPCell();
            Paragraph parra = new Paragraph();
            parra.add("\n\n\n\n\nFIRMA DEL DIRECTOR(A)");
            celde.setColspan(1);
            celde.addElement(parra);
            table.addCell(celde);

            //table.addCell("");
            //se crea celda
            PdfPCell celde1 = new PdfPCell();
            Paragraph parraf = new Paragraph();
            parraf.add("\n\n\n\n\nFIRMA DEL DIRECTOR DE GRUPO");
            celde1.setColspan(8);
            celde1.addElement(parraf);
            table.addCell(celde1);

            //
            documento.open();
            documento.add(table);
            documento.close();
            /*
             */
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
            // determina el porcentage a ocupar del ancho del documento.
            /*tabla.setWidthPercentage(100);*/
            
            JOptionPane.showMessageDialog(null, "se creo boletin Trancision " + periodo);
            
        } catch (Exception e) {
            System.out.println("este es un error en crear boletines " + e);
        }
    }

    public void RegistrarNotas(String b[]/*informacion*/, boolean primaria/*primaria o transcision*/,
            String periodo, String periodo2, String periodo3, String periodo4) {

        //se consulta para saber si ya esta registrado en la tabla notas o notasprimaria
        //variable para saber si esta registrado
        boolean registrado = false;
        try {
            //se consulta en la tabla notas.
            Connection cn = ClaseMetodos.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from notas where ID_Alumno ='" + b[18] + "'");
            ResultSet rs = pst.executeQuery();

            //si hay respuesta es porque esta registrado y se debe modificar
            if (rs.next()) {

                registrado = true;

                cn.close();

            } else if (registrado == false) {

                //se consulta en la tabla notas_primaria.
                PreparedStatement pst2 = cn.prepareStatement(
                        "select * from notas_primaria where ID_Alumno ='" + b[18] + "'");
                rs = pst2.executeQuery();

                //si hay respuesta es porque esta registrado y se debe modificar
                if (rs.next()) {

                    registrado = true;

                    cn.close();
                }

            }
        } catch (SQLException e) {
            System.out.println("aquiii " + e);
        }
        //codigo para obtener la fecha.
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
        String day = c.DiaEnLetras(dia);
        String Mes = c.MesEnLetras(mes);
        String f = dia + "/" + Mes + "/" + año + "/ " + hora + ":" + min;

        //validacion de campos se hace en NotasYBoletines
        //si el registrado es false registra un nuevo alumno en la tabla
        //de lo contrario se modifica el registro con ID
        if (registrado == false) {

            //decide donde guardar las notas, si Primaria es false se registra en notas
            //si primaria es false entonces se registra preescolar
            if (primaria == false) {/*transicion*/


                //se establecen las variables  para sacar las cuentas de desempeño.
                double campo1 = /*se combierte a double*/ Double.parseDouble(b[0])/*Dimensión cognitiva*/,
                        campo2 = Double.parseDouble(b[1])/*comunicativa*/,
                        campo3 = Double.parseDouble(b[2])/*socioafectiva*/,
                        campo4 = Double.parseDouble(b[3])/*corporal*/,
                        campo5 = Double.parseDouble(b[8])/*etica y valores*/,
                        campo6 = Double.parseDouble(b[9])/*estetica*/,
                        campo7 = Double.parseDouble(b[10])/*idiomas*/,
                        campo8 = Double.parseDouble(b[11])/*Educacion cristiana*/,
                        campo9 = Double.parseDouble(b[12])/*Informatica*/,
                        campo10 = Double.parseDouble(b[13])/*comportamiento*/;

                /*BA: Bajo 1-5.9 B: Básico 6.0-7.9   A: Alto 8.0-9.0   S: Superior9.1-10.0  */
                //variables de desempeño
                String Dcognitiva = "", Dcomunicativa = "", Dsociafectiva = "";
                String Dcorporal = "", Detica = "", Destetica = "",
                        Idiomas = "", Ecristiana = "", Dinformatica = "", compor = "";
                //se asigna desempeño Dimensión cognitiva
                if (campo1 <= 5.9) {
                    Dcognitiva = "BA";
                } else if (campo1 > 5.9 && campo1 <= 7.9) {
                    Dcognitiva = "B";
                } else if (campo1 > 7.9 && campo1 < 9) {
                    Dcognitiva = "A";
                } else if (campo1 > 9 && campo1 <= 10) {
                    Dcognitiva = "S";
                }
                // se asigna desempeño Dimensión comunicativa
                if (campo2 <= 5.9) {
                    Dcomunicativa = "BA";
                } else if (campo2 > 5.9 && campo2 <= 7.9) {
                    Dcomunicativa = "B";
                } else if (campo2 > 7.9 && campo2 < 9) {
                    Dcomunicativa = "A";
                } else if (campo2 > 9 && campo2 <= 10) {
                    Dcomunicativa = "S";
                }
                //Se asigna desempeño a Dimensión socio afectiva
                if (campo3 <= 5.9) {
                    Dsociafectiva = "BA";
                } else if (campo3 > 5.9 && campo3 <= 7.9) {
                    Dsociafectiva = "B";
                } else if (campo3 > 7.9 && campo3 < 9) {
                    Dsociafectiva = "A";
                } else if (campo3 > 9 && campo3 <= 10) {
                    Dsociafectiva = "S";
                }
                // se asigna desempeño a Dimensión corporal
                if (campo4 <= 5.9) {
                    Dcorporal = "BA";
                } else if (campo4 > 5.9 && campo4 <= 7.9) {
                    Dcorporal = "B";
                } else if (campo4 > 7.9 && campo4 < 9) {
                    Dcorporal = "A";
                } else if (campo4 > 9 && campo4 <= 10) {
                    Dcorporal = "S";
                }
                //se asigna desempeño a Dimensión etica
                if (campo5 <= 5.9) {
                    Detica = "BA";
                } else if (campo5 > 5.9 && campo5 <= 7.9) {
                    Detica = "B";
                } else if (campo5 > 7.9 && campo5 < 9) {
                    Detica = "A";
                } else if (campo5 > 9 && campo5 <= 10) {
                    Detica = "S";
                }
                //se asigna desempeño a Dimensión estetica
                if (campo6 <= 5.9) {
                    Destetica = "BA";
                } else if (campo6 > 5.9 && campo6 <= 7.9) {
                    Destetica = "B";
                } else if (campo6 > 7.9 && campo6 < 9) {
                    Destetica = "A";
                } else if (campo6 > 9 && campo6 <= 10) {
                    Destetica = "S";
                }
                //se asigna desempeñoa a area de idiomas
                if (campo7 <= 5.9) {
                    Idiomas = "BA";
                } else if (campo7 > 5.9 && campo7 <= 7.9) {
                    Idiomas = "B";
                } else if (campo7 > 7.9 && campo7 < 9) {
                    Idiomas = "A";
                } else if (campo7 > 9 && campo7 <= 10) {
                    Idiomas = "S";
                }
                //se asigna desempeño a educacion cristiana
                if (campo8 <= 5.9) {
                    Ecristiana = "BA";
                } else if (campo8 > 5.9 && campo8 <= 7.9) {
                    Ecristiana = "B";
                } else if (campo8 > 7.9 && campo8 < 9) {
                    Ecristiana = "A";
                } else if (campo8 > 9 && campo9 <= 10) {
                    Ecristiana = "S";
                }
                //se asigna desempeñoa a informatica
                if (campo9 <= 5.9) {
                    Dinformatica = "BA";
                } else if (campo9 > 5.9 && campo9 <= 7.9) {
                    Dinformatica = "B";
                } else if (campo9 > 7.9 && campo9 < 9) {
                    Dinformatica = "A";
                } else if (campo9 > 9 && campo9 <= 10) {
                    Dinformatica = "S";
                }
                //se asigna desempeño a comportamiento
                if (campo10 <= 5.9) {
                    compor = "BA";
                } else if (campo10 > 5.9 && campo10 <= 7.9) {
                    compor = "B";
                } else if (campo10 > 7.9 && campo10 < 9) {
                    compor = "A";
                } else if (campo10 > 9 && campo10 <= 10) {
                    compor = "S";
                }

                //captura de errores.
                try {

                    //conexion con base de datos.
                    Connection cn2 = c.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("insert into notas values "
                            + "(?,?,?, ?,?,?, ?,?,?, ?,?,?, "
                            + "?,?, ?,?,?, ?,?,?, ?,?,?,?, ?,?,?, ?,?,?, "
                            + "?,?,?,?, ?,?,?, ?,?,?, ?,?,?,?, ?,?,?, ?,?,?,?,"
                            + "?,?,?, ?,?,?, ?,?,?, ?)");//61
                    pst2.setInt(1, 0);
                    pst2.setString(2, f);
                    pst2.setString(3, b[18]);
                    pst2.setString(4, b[19]);

                    //Se llena periodo1 como listo
                    if ("1"/*periodo*/.equals(b[4])) {
                        pst2.setString(5, "Listo");

                        pst2.setString(6, "");

                        pst2.setString(7, "");
                        pst2.setString(8, "");
                    }/*//Se llena periodo2 como listo*/ else if ("2".equals(b[4])) {
                        pst2.setString(5, "Listo");

                        pst2.setString(6, "Listo");

                        pst2.setString(7, "");
                        pst2.setString(8, "");
                    } /*//Se llena periodo3 como listo*/ else if ("3".equals(b[4])) {
                        pst2.setString(5, "Listo");

                        pst2.setString(6, "Listo");

                        pst2.setString(7, "Listo");
                        pst2.setString(8, "");
                    }/*//Se llena periodo4 como listo*/ else if ("4".equals(b[4])) {
                        pst2.setString(5, "Listo");

                        pst2.setString(6, "Listo");

                        pst2.setString(7, "Listo");
                        pst2.setString(8, "Listo");
                    }
                    //en caso de ser el primer periodo se 
                    //registra en el primer periodo de cada materia
                    if ("1"/*periodo*/.equals(b[4])) {
                        pst2.setString(9, b[0]);//Dimensión cognitiva
                        pst2.setString(10, "");
                        pst2.setString(11, "");
                        pst2.setString(12, "");
                        pst2.setString(13, Dcognitiva);//desempeño Dimensión cgnitiva
                        pst2.setString(14, b[1]);//Dimensión comunicativa
                        pst2.setString(15, "");
                        pst2.setString(16, "");
                        pst2.setString(17, "");
                        pst2.setString(18, Dcomunicativa);//desempeño Dimensión comunicativa
                        pst2.setString(19, b[2]);//Dimensión sicioafectiva
                        pst2.setString(20, "");
                        pst2.setString(21, "");
                        pst2.setString(22, "");
                        pst2.setString(23, Dsociafectiva);//desempeño Dimensión sicioafectiva
                        pst2.setString(24, b[3]);//Dimensión corporal
                        pst2.setString(25, "");
                        pst2.setString(26, "");
                        pst2.setString(27, "");
                        pst2.setString(28, Dcorporal);//desempeño //Dimensión corporal
                        pst2.setString(29, b[8]);//Dimensión etica
                        pst2.setString(30, "");
                        pst2.setString(31, "");
                        pst2.setString(32, "");
                        pst2.setString(33, Detica);//desempeño Dimensión etica  
                        pst2.setString(34, b[9]);//Dimensión estetica
                        pst2.setString(35, "");
                        pst2.setString(36, "");
                        pst2.setString(37, "");
                        pst2.setString(38, Destetica);//desempeño Dimensión estetica
                        pst2.setString(39, b[10]);//Dimensión ingles
                        pst2.setString(40, "");
                        pst2.setString(41, "");
                        pst2.setString(42, "");
                        pst2.setString(43, Idiomas);//desempeño ingles
                        pst2.setString(44, b[11]);//Dimensión edu crustiana
                        pst2.setString(45, "");
                        pst2.setString(46, "");
                        pst2.setString(47, "");
                        pst2.setString(48, Ecristiana);//desempeño Dimensión edu crustiana
                        pst2.setString(49, b[12]);//Dimensión informatica
                        pst2.setString(50, "");
                        pst2.setString(51, "");
                        pst2.setString(52, "");
                        pst2.setString(53, Dinformatica);//desempeño informatica
                        pst2.setString(54, b[13]);//comportamiento
                        pst2.setString(55, "");
                        pst2.setString(56, "");
                        pst2.setString(57, "");
                        pst2.setString(58, compor);//desempeño comportamiento

                        //en caso de ser el segundo periodo se 
                        //registra en el segundo periodo de cada materia
                    } else if ("2"/*periodo*/.equals(b[4])) {

                        pst2.setString(9, "");
                        pst2.setString(10, b[0]);
                        pst2.setString(11, "");
                        pst2.setString(12, "");
                        pst2.setString(13, Dcognitiva);
                        pst2.setString(14, "");
                        pst2.setString(15, b[1]);
                        pst2.setString(16, "");
                        pst2.setString(17, "");
                        pst2.setString(18, Dcomunicativa);
                        pst2.setString(19, "");
                        pst2.setString(20, b[2]);
                        pst2.setString(21, "");
                        pst2.setString(22, "");
                        pst2.setString(23, Dsociafectiva);
                        pst2.setString(24, "");
                        pst2.setString(25, b[3]);
                        pst2.setString(26, "");
                        pst2.setString(27, "");
                        pst2.setString(28, Dcorporal);
                        pst2.setString(29, "");
                        pst2.setString(30, b[8]);
                        pst2.setString(31, "");
                        pst2.setString(32, "");
                        pst2.setString(33, Detica);
                        pst2.setString(34, "");
                        pst2.setString(35, b[9]);
                        pst2.setString(36, "");
                        pst2.setString(37, "");
                        pst2.setString(38, Destetica);
                        pst2.setString(39, "");
                        pst2.setString(40, b[10]);
                        pst2.setString(41, "");
                        pst2.setString(42, "");
                        pst2.setString(43, Idiomas);
                        pst2.setString(44, "");
                        pst2.setString(45, b[11]);
                        pst2.setString(46, "");
                        pst2.setString(47, "");
                        pst2.setString(48, Ecristiana);
                        pst2.setString(49, "");
                        pst2.setString(50, b[12]);
                        pst2.setString(51, "");
                        pst2.setString(52, "");
                        pst2.setString(53, Dinformatica);
                        pst2.setString(54, "");
                        pst2.setString(55, b[13]);
                        pst2.setString(56, "");
                        pst2.setString(57, "");
                        pst2.setString(58, compor);

                        //en caso de ser el tercer periodo se 
                        //registra en el tercer periodo de cada materia
                    } else if ("3"/*periodo*/.equals(b[4])) {

                        pst2.setString(9, "");
                        pst2.setString(10, "");
                        pst2.setString(11, b[0]);
                        pst2.setString(12, "");
                        pst2.setString(13, Dcognitiva);
                        pst2.setString(14, "");
                        pst2.setString(15, "");
                        pst2.setString(16, b[1]);
                        pst2.setString(17, "");
                        pst2.setString(18, Dcomunicativa);
                        pst2.setString(19, "");
                        pst2.setString(20, "");
                        pst2.setString(21, b[2]);
                        pst2.setString(22, "");
                        pst2.setString(23, Dsociafectiva);
                        pst2.setString(24, "");
                        pst2.setString(25, "");
                        pst2.setString(26, b[3]);
                        pst2.setString(27, "");
                        pst2.setString(28, Dcorporal);
                        pst2.setString(29, "");
                        pst2.setString(30, "");
                        pst2.setString(31, b[8]);
                        pst2.setString(32, "");
                        pst2.setString(33, Detica);
                        pst2.setString(34, "");
                        pst2.setString(35, "");
                        pst2.setString(36, b[9]);
                        pst2.setString(37, "");
                        pst2.setString(38, Destetica);
                        pst2.setString(39, "");
                        pst2.setString(40, "");
                        pst2.setString(41, b[10]);
                        pst2.setString(42, "");
                        pst2.setString(43, Idiomas);
                        pst2.setString(44, "");
                        pst2.setString(45, "");
                        pst2.setString(46, b[11]);
                        pst2.setString(47, "");
                        pst2.setString(48, Ecristiana);
                        pst2.setString(49, "");
                        pst2.setString(50, "");
                        pst2.setString(51, b[12]);
                        pst2.setString(52, "");
                        pst2.setString(53, Dinformatica);
                        pst2.setString(54, "");
                        pst2.setString(55, "");
                        pst2.setString(56, b[13]);
                        pst2.setString(57, "");
                        pst2.setString(58, compor);

                        //en caso de ser el cuarto periodo se 
                        //registra en el cuarto periodo de cada materia
                    } else if ("4"/*periodo*/.equals(b[4])) {

                        pst2.setString(9, "");
                        pst2.setString(10, "");
                        pst2.setString(11, "");
                        pst2.setString(12, b[0]);
                        pst2.setString(13, Dcognitiva);
                        pst2.setString(14, "");
                        pst2.setString(15, "");
                        pst2.setString(16, "");
                        pst2.setString(17, b[1]);
                        pst2.setString(18, Dcomunicativa);
                        pst2.setString(19, "");
                        pst2.setString(20, "");
                        pst2.setString(21, "");
                        pst2.setString(22, b[2]);
                        pst2.setString(23, Dsociafectiva);
                        pst2.setString(24, "");
                        pst2.setString(25, "");
                        pst2.setString(26, "");
                        pst2.setString(27, b[3]);
                        pst2.setString(28, Dcorporal);
                        pst2.setString(29, "");
                        pst2.setString(30, "");
                        pst2.setString(31, "");
                        pst2.setString(32, b[8]);
                        pst2.setString(33, Detica);
                        pst2.setString(34, "");
                        pst2.setString(35, "");
                        pst2.setString(36, "");
                        pst2.setString(37, b[9]);
                        pst2.setString(38, Destetica);
                        pst2.setString(39, "");
                        pst2.setString(40, "");
                        pst2.setString(41, "");
                        pst2.setString(42, b[10]);
                        pst2.setString(43, Idiomas);
                        pst2.setString(44, "");
                        pst2.setString(45, "");
                        pst2.setString(46, "");
                        pst2.setString(47, b[11]);
                        pst2.setString(48, Ecristiana);
                        pst2.setString(49, "");
                        pst2.setString(50, "");
                        pst2.setString(51, "");
                        pst2.setString(52, b[12]);
                        pst2.setString(53, Dinformatica);
                        pst2.setString(54, "");
                        pst2.setString(55, "");
                        pst2.setString(56, "");
                        pst2.setString(57, b[13]);
                        pst2.setString(58, compor);
                    }

                    pst2.setString(59, b[6]);
                    pst2.setString(60, b[7]);
                    pst2.setString(61, b[5]);

                    pst2.executeUpdate();
                    cn2.close();

                    JOptionPane.showMessageDialog(null, "Notas Guardadas Con exito\n"
                            + "ya puede generar documento de periodo " + b[4]/*periodo*/);

                } catch (SQLException e) {
                    System.out.println("rerror sql " + e);
                }

            } else /*si primaria es verdadero entra aqui*/ {

                //declaracion de variables
                //se establecen las variables  para sacar las cuentas de la areas.
                double campo1 = /*se combierte a double*/ Double.parseDouble(b[0])/*matematicas*/,
                        campo2 = Double.parseDouble(b[1])/*geometria*/,
                        campo3 = Double.parseDouble(b[2])/*castellano*/,
                        campo4 = Double.parseDouble(b[3])/*Ingles*/,
                        campo5 = Double.parseDouble(b[8])/*Naturales*/,
                        campo6 = Double.parseDouble(b[9])/*sociales*/,
                        campo7 = Double.parseDouble(b[10])/*ConstitucionPolitica*/,
                        campo8 = Double.parseDouble(b[11])/*Etica Valores*/,
                        campo9 = Double.parseDouble(b[12])/*Artistica*/,
                        campo10 = Double.parseDouble(b[13])/*catedra de paz*/,
                        campo11 = Double.parseDouble(b[14])/*educacion cristiana*/,
                        campo12 = Double.parseDouble(b[15])/*deportes*/,
                        campo13 = Double.parseDouble(b[16])/*informatica*/,
                        campo14 = Double.parseDouble(b[17])/*desempeño*/,
                        area3 = 0, area2 = 0, area1 = 0;

                //se calcula el promedio del area de matematicas
                area1 = (campo1 + campo2) / 2;/*area de matematicas*/
                //se comvierte a String
                String Area1 = String.valueOf(area1);
                //se calcula el promedio del 
                //area de Humanidades e idioma extrangero
                area2 = (campo3 + campo4) / 2; //Humanidades e idioma extrangero
                //se combierte a String
                String Area2 = String.valueOf(area2);
                //se calcula el promedio del area de ciencias sociales
                area3 = (campo6 + campo7) / 2;//ciencias sociales.
                //se combierte en String
                String Area3 = String.valueOf(area3);

                /*BA: Bajo 1-5.9 B: Básico 6.0-7.9   A: Alto 8.0-9.0   S: Superior9.1-10.0  */
                //variables de desempeño
                String AreaM = "", Mate = "", Geometri = "";
                String AreaH = "", Castellano = "", ingles = "",
                        naturales = "", ASocial = "", social = "", constitu = "",
                        eticaV = "", artistica = "", catedra = "", eduCrist = "",
                        depor = "", infor = "", compor = "";
                //se asigna desempeño a area de matematicas
                if (area1 <= 5.9) {
                    AreaM = "BA";
                } else if (area1 > 5.9 && area1 <= 7.9) {
                    AreaM = "B";
                } else if (area1 > 7.9 && area1 < 9) {
                    AreaM = "A";
                } else if (area1 > 9 && area1 <= 10) {
                    AreaM = "S";
                }
                // se asigna desempeño a matematica
                if (campo1 <= 5.9) {
                    Mate = "BA";
                } else if (campo1 > 5.9 && campo1 <= 7.9) {
                    Mate = "B";
                } else if (campo1 > 7.9 && campo1 < 9) {
                    Mate = "A";
                } else if (campo1 > 9 && campo1 <= 10) {
                    Mate = "S";
                }
                //Se asigna desempeño a geometria
                if (campo2 <= 5.9) {
                    Geometri = "BA";
                } else if (campo2 > 5.9 && campo2 <= 7.9) {
                    Geometri = "B";
                } else if (campo2 > 7.9 && campo2 < 9) {
                    Geometri = "A";
                } else if (campo2 > 9 && campo2 <= 10) {
                    Geometri = "S";
                }
                // se asigna desempeño a Area Humanidades
                if (area2 <= 5.9) {
                    AreaH = "BA";
                } else if (area2 > 5.9 && area2 <= 7.9) {
                    AreaH = "B";
                } else if (area2 > 7.9 && area2 < 9) {
                    AreaH = "A";
                } else if (area2 > 9 && area2 <= 10) {
                    AreaH = "S";
                }
                //se asigna desempeño a castellano
                if (campo3 <= 5.9) {
                    Castellano = "BA";
                } else if (campo3 > 5.9 && campo3 <= 7.9) {
                    Castellano = "B";
                } else if (campo3 > 7.9 && campo3 < 9) {
                    Castellano = "A";
                } else if (campo3 > 9 && campo3 <= 10) {
                    Castellano = "S";
                }
                //se asigna desempeño a Ingles
                if (campo4 <= 5.9) {
                    ingles = "BA";
                } else if (campo4 > 5.9 && campo4 <= 7.9) {
                    ingles = "B";
                } else if (campo4 > 7.9 && campo4 < 9) {
                    ingles = "A";
                } else if (campo4 > 9 && campo4 <= 10) {
                    ingles = "S";
                }
                //se asigna desempeñoa a area de naturales Ed ambiental y naturales
                if (campo5 <= 5.9) {
                    naturales = "BA";
                } else if (campo5 > 5.9 && campo5 <= 7.9) {
                    naturales = "B";
                } else if (campo5 > 7.9 && campo5 < 9) {
                    naturales = "A";
                } else if (campo5 > 9 && campo5 <= 10) {
                    naturales = "S";
                }
                //se asigna desempeño a area de sociales
                if (area3 <= 5.9) {
                    ASocial = "BA";
                } else if (area3 > 5.9 && area3 <= 7.9) {
                    ASocial = "B";
                } else if (area3 > 7.9 && area3 < 9) {
                    ASocial = "A";
                } else if (area3 > 9 && area3 <= 10) {
                    ASocial = "S";
                }
                //se asigna desempeñoa a sociales
                if (campo6 <= 5.9) {
                    social = "BA";
                } else if (campo6 > 5.9 && campo6 <= 7.9) {
                    social = "B";
                } else if (campo6 > 7.9 && campo6 < 9) {
                    social = "A";
                } else if (campo6 > 9 && campo6 <= 10) {
                    social = "S";
                }
                //se asigna desempeño constitucionPolitica
                if (campo7 <= 5.9) {
                    constitu = "BA";
                } else if (campo7 > 5.9 && campo7 <= 7.9) {
                    constitu = "B";
                } else if (campo7 > 7.9 && campo7 < 9) {
                    constitu = "A";
                } else if (campo7 > 9 && campo7 <= 10) {
                    constitu = "S";
                }
                //se asigna desempeño a etica valores
                if (campo8 <= 5.9) {
                    eticaV = "BA";
                } else if (campo8 > 5.9 && campo8 <= 7.9) {
                    eticaV = "B";
                } else if (campo8 > 7.9 && campo8 < 9) {
                    eticaV = "A";
                } else if (campo8 > 9 && campo8 <= 10) {
                    eticaV = "S";
                }
                //se asigna desempeño a artistica
                if (campo9 <= 5.9) {
                    artistica = "BA";
                } else if (campo9 > 5.9 && campo9 <= 7.9) {
                    artistica = "B";
                } else if (campo9 > 7.9 && campo9 < 9) {
                    artistica = "A";
                } else if (campo9 > 9 && campo9 <= 10) {
                    artistica = "S";
                }
                //se asigna desempeño a catedra de paz
                if (campo10 <= 5.9) {
                    catedra = "BA";
                } else if (campo10 > 5.9 && campo10 <= 7.9) {
                    catedra = "B";
                } else if (campo10 > 7.9 && campo10 < 9) {
                    catedra = "A";
                } else if (campo10 > 9 && campo10 <= 10) {
                    catedra = "S";
                }
                //se asigna desempeño a educacion cristiana
                if (campo11 <= 5.9) {
                    eduCrist = "BA";
                } else if (campo11 > 5.9 && campo11 <= 7.9) {
                    eduCrist = "B";
                } else if (campo11 > 7.9 && campo11 < 9) {
                    eduCrist = "A";
                } else if (campo11 > 9 && campo11 <= 10) {
                    eduCrist = "S";
                }
                //se asigna desempeño de deportes
                if (campo12 <= 5.9) {
                    depor = "BA";
                } else if (campo12 > 5.9 && campo12 <= 7.9) {
                    depor = "B";
                } else if (campo12 > 7.9 && campo12 < 9) {
                    depor = "A";
                } else if (campo12 > 9 && campo12 <= 10) {
                    depor = "S";
                }
                // se asigna desempeño a informatica
                if (campo13 <= 5.9) {
                    infor = "BA";
                } else if (campo13 > 5.9 && campo13 <= 7.9) {
                    infor = "B";
                } else if (campo13 > 7.9 && campo13 < 9) {
                    infor = "A";
                } else if (campo13 > 9 && campo13 <= 10) {
                    infor = "S";
                }
                //se asigna desempeño a comportamiento
                if (campo14 <= 5.9) {
                    compor = "BA";
                } else if (campo14 > 5.9 && campo14 <= 7.9) {
                    compor = "B";
                } else if (campo14 > 7.9 && campo14 < 9) {
                    compor = "A";
                } else if (campo14 > 9 && campo14 <= 10) {
                    compor = "S";
                }

                try {

                    //conexion con la base de datos.
                    Connection cn3 = c.conectar();
                    PreparedStatement pst3 = cn3.prepareStatement("insert into notas_primaria values "
                            + "(?,?,?, ?,?,?, ?,?,?, ?,?,?, "
                            + "?,?, ?,?,?, ?,?,?, ?,?,?,?, ?,?,?, ?,?,?, "
                            + "?,?,?,?, ?,?,?, ?,?,?, ?,?,?,?, ?,?,?, ?,?,?,"
                            + "?,?,?,?, ?,?,?, ?,?,?, ?,?,?,?, ?,?,?, ?,?,?,"
                            + "?,?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,"
                            + "?,?,?, ?,?,?, ?,?)");//101
                    pst3.setInt(1, 0);
                    pst3.setString(2, f);//fecha
                    pst3.setString(3, b[18]);//ID
                    pst3.setString(4, b[19]);//grado

                    //en caso de ser el primer periodo se 
                    //registra en el primer periodo de cada materia
                    if ("1"/*periodo*/.equals(b[4])) {
                        pst3.setString(5, "listo");

                        pst3.setString(6, "");

                        pst3.setString(7, "");
                        pst3.setString(8, "");

                        pst3.setString(9, Area1);/*Area de matematicas*/
                        pst3.setString(10, "");
                        pst3.setString(11, "");
                        pst3.setString(12, "");
                        pst3.setString(13, AreaM);//desempeño area matematicas
                        pst3.setString(14, b[0]);//matematicas
                        pst3.setString(15, "");
                        pst3.setString(16, "");
                        pst3.setString(17, "");
                        pst3.setString(18, Mate);//desempeño matematicas
                        pst3.setString(19, b[1]);//geometria
                        pst3.setString(20, "");
                        pst3.setString(21, "");
                        pst3.setString(22, "");
                        pst3.setString(23, Geometri);//desempeño geometria
                        pst3.setString(24, Area2);/*Area de Humanidades*/
                        pst3.setString(25, "");
                        pst3.setString(26, "");
                        pst3.setString(27, "");
                        pst3.setString(28, AreaH);//desempeño homanidades
                        pst3.setString(29, b[2]);/*castellano*/
                        pst3.setString(30, "");
                        pst3.setString(31, "");
                        pst3.setString(32, "");
                        pst3.setString(33, Castellano);//desempeño castellano
                        pst3.setString(34, b[3]);//ingles
                        pst3.setString(35, "");
                        pst3.setString(36, "");
                        pst3.setString(37, "");
                        pst3.setString(38, ingles);/*desempeño ingles*/
                        pst3.setString(39, b[8]);/*naturales edu ambiental*/
                        pst3.setString(40, "");
                        pst3.setString(41, "");
                        pst3.setString(42, "");
                        pst3.setString(43, naturales);/*area de ciencias naturales*/
                        pst3.setString(44, b[8]);//naturales
                        pst3.setString(45, "");
                        pst3.setString(46, "");
                        pst3.setString(47, "");
                        pst3.setString(48, naturales);//desempeño naturales
                        pst3.setString(49, Area3);//area ciencia sociales
                        pst3.setString(50, "");
                        pst3.setString(51, "");
                        pst3.setString(52, "");
                        pst3.setString(53, ASocial);//area sociales
                        pst3.setString(54, b[9]);//sociales
                        pst3.setString(55, "");
                        pst3.setString(56, "");
                        pst3.setString(57, "");
                        pst3.setString(58, social);//desempeño sociales
                        pst3.setString(59, b[10]);//constitucion politica
                        pst3.setString(60, "");
                        pst3.setString(61, "");
                        pst3.setString(62, "");
                        pst3.setString(63, constitu);//desempeño constitucion politica
                        pst3.setString(64, b[11]);//etica y valores
                        pst3.setString(65, "");
                        pst3.setString(66, "");
                        pst3.setString(67, "");
                        pst3.setString(68, eticaV);
                        pst3.setString(69, b[12]);//artistica
                        pst3.setString(70, "");
                        pst3.setString(71, "");
                        pst3.setString(72, "");
                        pst3.setString(73, artistica);//desempeño artistica.
                        pst3.setString(74, b[13]);//catedra de paz
                        pst3.setString(75, "");
                        pst3.setString(76, "");
                        pst3.setString(77, "");
                        pst3.setString(78, catedra);//desempeño catedra de paz
                        pst3.setString(79, b[14]);//educacion cristiana
                        pst3.setString(80, "");
                        pst3.setString(81, "");
                        pst3.setString(82, "");
                        pst3.setString(83, eduCrist);//desempeño edu cristiana
                        pst3.setString(84, b[15]);//educacion fisica
                        pst3.setString(85, "");
                        pst3.setString(86, "");
                        pst3.setString(87, "");
                        pst3.setString(88, depor);
                        pst3.setString(89, b[16]);//informatica
                        pst3.setString(90, "");
                        pst3.setString(91, "");
                        pst3.setString(92, "");
                        pst3.setString(93, infor);//desempeño informatica
                        pst3.setString(94, b[17]);
                        pst3.setString(95, "");
                        pst3.setString(96, "");
                        pst3.setString(97, "");
                        pst3.setString(98, compor);//desempeño comportamiento

                        //en caso de ser el segundo periodo se 
                        //registra en el segundo periodo de cada materia
                    } else if ("2"/*periodo*/.equals(b[4])) {
                        pst3.setString(5, "listo");

                        pst3.setString(6, "Listo");

                        pst3.setString(7, "");
                        pst3.setString(8, "");

                        pst3.setString(9, "");
                        pst3.setString(10, Area1);/*Area de matematicas*/
                        pst3.setString(11, "");
                        pst3.setString(12, "");
                        pst3.setString(13, AreaM);//desempeño area matematicas
                        pst3.setString(14, "");
                        pst3.setString(15, b[0]);//matematicas
                        pst3.setString(16, "");
                        pst3.setString(17, "");
                        pst3.setString(18, Mate);//desempeño matematicas
                        pst3.setString(19, "");
                        pst3.setString(20, b[1]);//geometria
                        pst3.setString(21, "");
                        pst3.setString(22, "");
                        pst3.setString(23, Geometri);//desempeño geometria
                        pst3.setString(24, "");
                        pst3.setString(25, Area2);/*Area de Humanidades*/
                        pst3.setString(26, "");
                        pst3.setString(27, "");
                        pst3.setString(28, AreaH);//desempeño homanidades
                        pst3.setString(29, "");
                        pst3.setString(30, b[2]);/*castellano*/
                        pst3.setString(31, "");
                        pst3.setString(32, "");
                        pst3.setString(33, Castellano);//desempeño castellano
                        pst3.setString(34, "");
                        pst3.setString(35, b[3]);//ingles
                        pst3.setString(36, "");
                        pst3.setString(37, "");
                        pst3.setString(38, ingles);/*desempeño ingles*/
                        pst3.setString(39, "");
                        pst3.setString(40, b[8]);/*naturales edu ambiental*/
                        pst3.setString(41, "");
                        pst3.setString(42, "");
                        pst3.setString(43, naturales);/*area de ciencias naturales*/
                        pst3.setString(44, "");
                        pst3.setString(45, b[8]);//naturales
                        pst3.setString(46, "");
                        pst3.setString(47, "");
                        pst3.setString(48, naturales);//desempeño naturales
                        pst3.setString(49, "");
                        pst3.setString(50, Area3);//area ciencia sociales
                        pst3.setString(51, "");
                        pst3.setString(52, "");
                        pst3.setString(53, ASocial);//area sociales
                        pst3.setString(54, "");
                        pst3.setString(55, b[9]);//sociales
                        pst3.setString(56, "");
                        pst3.setString(57, "");
                        pst3.setString(58, social);//desempeño sociales
                        pst3.setString(59, "");
                        pst3.setString(60, b[10]);//constitucion politica
                        pst3.setString(61, "");
                        pst3.setString(62, "");
                        pst3.setString(63, constitu);//desempeño constitucion politica
                        pst3.setString(64, "");
                        pst3.setString(65, b[11]);//etica y valores
                        pst3.setString(66, "");
                        pst3.setString(67, "");
                        pst3.setString(68, eticaV);
                        pst3.setString(69, "");
                        pst3.setString(70, b[12]);//artistica
                        pst3.setString(71, "");
                        pst3.setString(72, "");
                        pst3.setString(73, artistica);//desempeño artistica.
                        pst3.setString(74, "");
                        pst3.setString(75, b[13]);//catedra de paz
                        pst3.setString(76, "");
                        pst3.setString(77, "");
                        pst3.setString(78, catedra);//desempeño catedra de paz
                        pst3.setString(79, "");
                        pst3.setString(80, b[14]);//educacion cristiana
                        pst3.setString(81, "");
                        pst3.setString(82, "");
                        pst3.setString(83, eduCrist);//desempeño edu cristiana
                        pst3.setString(84, "");
                        pst3.setString(85, b[15]);//educacion fisica
                        pst3.setString(86, "");
                        pst3.setString(87, "");
                        pst3.setString(88, depor);
                        pst3.setString(89, "");
                        pst3.setString(90, b[16]);//informatica
                        pst3.setString(91, "");
                        pst3.setString(92, "");
                        pst3.setString(93, infor);//desempeño informatica
                        pst3.setString(94, "");
                        pst3.setString(95, b[17]);
                        pst3.setString(96, "");
                        pst3.setString(97, "");
                        pst3.setString(98, compor);//desempeño comportamiento

                        //en caso de ser el tercer periodo se 
                        //registra en el tercer periodo de cada materia
                    } else if ("3"/*periodo*/.equals(b[4])) {

                        pst3.setString(5, "listo");

                        pst3.setString(6, "Listo");

                        pst3.setString(7, "Listo");
                        pst3.setString(8, "");

                        pst3.setString(9, "");
                        pst3.setString(10, "");
                        pst3.setString(11, Area1);/*Area de matematicas*/
                        pst3.setString(12, "");
                        pst3.setString(13, AreaM);//desempeño area matematicas
                        pst3.setString(14, "");
                        pst3.setString(15, "");
                        pst3.setString(16, b[0]);//matematicas
                        pst3.setString(17, "");
                        pst3.setString(18, Mate);//desempeño matematicas
                        pst3.setString(19, "");
                        pst3.setString(20, "");
                        pst3.setString(21, b[1]);//geometria
                        pst3.setString(22, "");
                        pst3.setString(23, Geometri);//desempeño geometria
                        pst3.setString(24, "");
                        pst3.setString(25, "");
                        pst3.setString(26, Area2);/*Area de Humanidades*/
                        pst3.setString(27, "");
                        pst3.setString(28, AreaH);//desempeño homanidades
                        pst3.setString(29, "");
                        pst3.setString(30, "");
                        pst3.setString(31, b[2]);/*castellano*/
                        pst3.setString(32, "");
                        pst3.setString(33, Castellano);//desempeño castellano
                        pst3.setString(34, "");
                        pst3.setString(35, "");
                        pst3.setString(36, b[3]);//ingles
                        pst3.setString(37, "");
                        pst3.setString(38, ingles);/*desempeño ingles*/
                        pst3.setString(39, "");
                        pst3.setString(40, "");
                        pst3.setString(41, b[8]);/*naturales edu ambiental*/
                        pst3.setString(42, "");
                        pst3.setString(43, naturales);/*desempeño area de ciencias naturales*/
                        pst3.setString(44, "");
                        pst3.setString(45, "");
                        pst3.setString(46, b[8]);//naturales
                        pst3.setString(47, "");
                        pst3.setString(48, naturales);//desempeño naturales
                        pst3.setString(49, "");
                        pst3.setString(50, "");
                        pst3.setString(51, Area3);//area ciencia sociales
                        pst3.setString(52, "");
                        pst3.setString(53, ASocial);//area sociales
                        pst3.setString(54, "");
                        pst3.setString(55, "");
                        pst3.setString(56, b[9]);//sociales
                        pst3.setString(57, "");
                        pst3.setString(58, social);//desempeño sociales
                        pst3.setString(59, "");
                        pst3.setString(60, "");
                        pst3.setString(61, b[10]);//constitucion politica
                        pst3.setString(62, "");
                        pst3.setString(63, constitu);//desempeño constitucion politica
                        pst3.setString(64, "");
                        pst3.setString(65, "");
                        pst3.setString(66, b[11]);//etica y valores
                        pst3.setString(67, "");
                        pst3.setString(68, eticaV);
                        pst3.setString(69, "");
                        pst3.setString(70, "");
                        pst3.setString(71, b[12]);//artistica
                        pst3.setString(72, "");
                        pst3.setString(73, artistica);//desempeño artistica.
                        pst3.setString(74, "");
                        pst3.setString(75, "");
                        pst3.setString(76, b[13]);//catedra de paz
                        pst3.setString(77, "");
                        pst3.setString(78, catedra);//desempeño catedra de paz
                        pst3.setString(79, "");
                        pst3.setString(80, "");
                        pst3.setString(81, b[14]);//educacion cristiana
                        pst3.setString(82, "");
                        pst3.setString(83, eduCrist);//desempeño edu cristiana
                        pst3.setString(84, "");
                        pst3.setString(85, "");
                        pst3.setString(86, b[15]);//educacion fisica
                        pst3.setString(87, "");
                        pst3.setString(88, depor);
                        pst3.setString(89, "");
                        pst3.setString(90, "");
                        pst3.setString(91, b[16]);//informatica
                        pst3.setString(92, "");
                        pst3.setString(93, infor);//desempeño informatica
                        pst3.setString(94, "");
                        pst3.setString(95, "");
                        pst3.setString(96, b[17]);
                        pst3.setString(97, "");
                        pst3.setString(98, compor);//desempeño comportamiento

                        //en caso de ser el cuarto periodo se 
                        //registra en el cuarto periodo de cada materia
                    } else if ("4"/*periodo*/.equals(b[4])) {
                        pst3.setString(5, "listo");

                        pst3.setString(6, "Listo");

                        pst3.setString(7, "Listo");
                        pst3.setString(8, "Listo");

                        pst3.setString(9, "");
                        pst3.setString(10, "");
                        pst3.setString(11, "");
                        pst3.setString(12, Area1);/*Area de matematicas*/
                        pst3.setString(13, AreaM);//desempeño area matematicas
                        pst3.setString(14, "");
                        pst3.setString(15, "");
                        pst3.setString(16, "");
                        pst3.setString(17, b[0]);//matematicas
                        pst3.setString(18, Mate);//desempeño matematicas
                        pst3.setString(19, "");
                        pst3.setString(20, "");
                        pst3.setString(21, "");
                        pst3.setString(22, b[1]);//geometria
                        pst3.setString(23, Geometri);//desempeño geometria
                        pst3.setString(24, "");
                        pst3.setString(25, "");
                        pst3.setString(26, "");
                        pst3.setString(27, Area2);/*Area de Humanidades*/
                        pst3.setString(28, AreaH);//desempeño homanidades
                        pst3.setString(29, "");
                        pst3.setString(30, "");
                        pst3.setString(31, "");
                        pst3.setString(32, b[2]);/*castellano*/
                        pst3.setString(33, Castellano);//desempeño castellano
                        pst3.setString(34, "");
                        pst3.setString(35, "");
                        pst3.setString(36, "");
                        pst3.setString(37, b[3]);//ingles
                        pst3.setString(38, ingles);/*desempeño ingles*/
                        pst3.setString(39, "");
                        pst3.setString(40, "");
                        pst3.setString(41, "");
                        pst3.setString(42, b[8]);/*naturales edu ambiental*/
                        pst3.setString(43, naturales);/*desempeño area de ciencias naturales*/
                        pst3.setString(44, "");
                        pst3.setString(45, "");
                        pst3.setString(46, "");
                        pst3.setString(47, b[8]);//naturales
                        pst3.setString(48, naturales);//desempeño naturales
                        pst3.setString(49, "");
                        pst3.setString(50, "");
                        pst3.setString(51, "");
                        pst3.setString(52, Area3);//area ciencia sociales
                        pst3.setString(53, ASocial);//area sociales
                        pst3.setString(54, "");
                        pst3.setString(55, "");
                        pst3.setString(56, "");
                        pst3.setString(57, b[9]);//sociales
                        pst3.setString(58, social);//desempeño sociales
                        pst3.setString(59, "");
                        pst3.setString(60, "");
                        pst3.setString(61, "");
                        pst3.setString(62, b[10]);//constitucion politica
                        pst3.setString(63, constitu);//desempeño constitucion politica
                        pst3.setString(64, "");
                        pst3.setString(65, "");
                        pst3.setString(66, "");
                        pst3.setString(67, b[11]);//etica y valores
                        pst3.setString(68, eticaV);
                        pst3.setString(69, "");
                        pst3.setString(70, "");
                        pst3.setString(71, "");
                        pst3.setString(72, b[12]);//artistica
                        pst3.setString(73, artistica);//desempeño artistica.
                        pst3.setString(74, "");
                        pst3.setString(75, "");
                        pst3.setString(76, "");
                        pst3.setString(77, b[13]);//catedra de paz
                        pst3.setString(78, catedra);//desempeño catedra de paz
                        pst3.setString(79, "");
                        pst3.setString(80, "");
                        pst3.setString(81, "");
                        pst3.setString(82, b[14]);//educacion cristiana
                        pst3.setString(83, eduCrist);//desempeño edu cristiana
                        pst3.setString(84, "");
                        pst3.setString(85, "");
                        pst3.setString(86, "");
                        pst3.setString(87, b[15]);//educacion fisica
                        pst3.setString(88, depor);
                        pst3.setString(89, "");
                        pst3.setString(90, "");
                        pst3.setString(91, "");
                        pst3.setString(92, b[16]);//informatica
                        pst3.setString(93, infor);//desempeño informatica
                        pst3.setString(94, "");
                        pst3.setString(95, "");
                        pst3.setString(96, "");
                        pst3.setString(97, b[17]);
                        pst3.setString(98, compor);//desempeño comportamiento

                    }
                    pst3.setString(99, b[6]/*Fallas justificada*/);
                    pst3.setString(100, b[7]/*Fallas sin justificar*/);
                    pst3.setString(101, b[5]/*observaciones*/);

                    pst3.executeUpdate();
                    cn3.close();

                    JOptionPane.showMessageDialog(null, "Notas Guardadas Con exito\n"
                            + "ya puede generar documento de periodo " + b[4]);

                } catch (SQLException e) {
                    System.out.println("rerror sql " + e);
                }

            }

            //si el periodo es vacio se registra un nuevo alumno en la tabla
            //de lo contrario se modifica el registro con ID
        } else if (registrado == true) {

            if (primaria == false) {/*transicion*/

                //se establecen las variables  para sacar las cuentas de desempeño.
                double campo1 = /*se combierte a double*/ Double.parseDouble(b[0])/*Dimensión cognitiva*/,
                        campo2 = Double.parseDouble(b[1])/*comunicativa*/,
                        campo3 = Double.parseDouble(b[2])/*socioafectiva*/,
                        campo4 = Double.parseDouble(b[3])/*corporal*/,
                        campo5 = Double.parseDouble(b[8])/*etica y valores*/,
                        campo6 = Double.parseDouble(b[9])/*estetica*/,
                        campo7 = Double.parseDouble(b[10])/*idiomas*/,
                        campo8 = Double.parseDouble(b[11])/*Educacion cristiana*/,
                        campo9 = Double.parseDouble(b[12])/*Informatica*/,
                        campo10 = Double.parseDouble(b[13])/*comportamiento*/;

                /*BA: Bajo 1-5.9 B: Básico 6.0-7.9   A: Alto 8.0-9.0   S: Superior9.1-10.0  */
                //variables de desempeño
                String Dcognitiva = "", Dcomunicativa = "", Dsociafectiva = "";
                String Dcorporal = "", Detica = "", Destetica = "",
                        Idiomas = "", Ecristiana = "", Dinformatica = "", compor = "";
                //se asigna desempeño Dimensión cognitiva
                if (campo1 <= 5.9) {
                    Dcognitiva = "BA";
                } else if (campo1 > 5.9 && campo1 <= 7.9) {
                    Dcognitiva = "B";
                } else if (campo1 > 7.9 && campo1 < 9) {
                    Dcognitiva = "A";
                } else if (campo1 > 9 && campo1 <= 10) {
                    Dcognitiva = "S";
                }
                // se asigna desempeño Dimensión comunicativa
                if (campo2 <= 5.9) {
                    Dcomunicativa = "BA";
                } else if (campo2 > 5.9 && campo2 <= 7.9) {
                    Dcomunicativa = "B";
                } else if (campo2 > 7.9 && campo2 < 9) {
                    Dcomunicativa = "A";
                } else if (campo2 > 9 && campo2 <= 10) {
                    Dcomunicativa = "S";
                }
                //Se asigna desempeño a Dimensión socio afectiva
                if (campo3 <= 5.9) {
                    Dsociafectiva = "BA";
                } else if (campo3 > 5.9 && campo3 <= 7.9) {
                    Dsociafectiva = "B";
                } else if (campo3 > 7.9 && campo3 < 9) {
                    Dsociafectiva = "A";
                } else if (campo3 > 9 && campo3 <= 10) {
                    Dsociafectiva = "S";
                }
                // se asigna desempeño a Dimensión corporal
                if (campo4 <= 5.9) {
                    Dcorporal = "BA";
                } else if (campo4 > 5.9 && campo4 <= 7.9) {
                    Dcorporal = "B";
                } else if (campo4 > 7.9 && campo4 < 9) {
                    Dcorporal = "A";
                } else if (campo4 > 9 && campo4 <= 10) {
                    Dcorporal = "S";
                }
                //se asigna desempeño a Dimensión etica
                if (campo5 <= 5.9) {
                    Detica = "BA";
                } else if (campo5 > 5.9 && campo5 <= 7.9) {
                    Detica = "B";
                } else if (campo5 > 7.9 && campo5 < 9) {
                    Detica = "A";
                } else if (campo5 > 9 && campo5 <= 10) {
                    Detica = "S";
                }
                //se asigna desempeño a Dimensión estetica
                if (campo6 <= 5.9) {
                    Destetica = "BA";
                } else if (campo6 > 5.9 && campo6 <= 7.9) {
                    Destetica = "B";
                } else if (campo6 > 7.9 && campo6 < 9) {
                    Destetica = "A";
                } else if (campo6 > 9 && campo6 <= 10) {
                    Destetica = "S";
                }
                //se asigna desempeñoa a area de idiomas
                if (campo7 <= 5.9) {
                    Idiomas = "BA";
                } else if (campo7 > 5.9 && campo7 <= 7.9) {
                    Idiomas = "B";
                } else if (campo7 > 7.9 && campo7 < 9) {
                    Idiomas = "A";
                } else if (campo7 > 9 && campo7 <= 10) {
                    Idiomas = "S";
                }
                //se asigna desempeño a educacion cristiana
                if (campo8 <= 5.9) {
                    Ecristiana = "BA";
                } else if (campo8 > 5.9 && campo8 <= 7.9) {
                    Ecristiana = "B";
                } else if (campo8 > 7.9 && campo8 < 9) {
                    Ecristiana = "A";
                } else if (campo8 > 9 && campo9 <= 10) {
                    Ecristiana = "S";
                }
                //se asigna desempeñoa a informatica
                if (campo9 <= 5.9) {
                    Dinformatica = "BA";
                } else if (campo9 > 5.9 && campo9 <= 7.9) {
                    Dinformatica = "B";
                } else if (campo9 > 7.9 && campo9 < 9) {
                    Dinformatica = "A";
                } else if (campo9 > 9 && campo9 <= 10) {
                    Dinformatica = "S";
                }
                //se asigna desempeño a comportamiento
                if (campo10 <= 5.9) {
                    compor = "BA";
                } else if (campo10 > 5.9 && campo10 <= 7.9) {
                    compor = "B";
                } else if (campo10 > 7.9 && campo10 < 9) {
                    compor = "A";
                } else if (campo10 > 9 && campo10 <= 10) {
                    compor = "S";
                }

                try {

                    if ("2".equals(b[4])) {
                        //conexion con base de datos.
                        Connection cn = c.conectar();
                        PreparedStatement pst = cn.prepareStatement("update notas set "
                                + "Periodo2 = ?, DIMENSION_COGNITIVAp2 = ?, DesempeñoDCognitiva = ?,"
                                + " DIMENSION_COMUNICATIVAp2 = ?, DesempeñoDComunicativa = ?, DIMENSION_SOCIOAFECTIVAp2 = ?,"
                                + "DesempeñoDSocioafectiva = ?, DIMENSION_CORPORALp2 = ?, DesempeñoDCorporal = ?,"
                                + "DIMENSION_ETICA_ACTITUDES_Y_VALORESp2 = ?, DesempeñoDEticaValores = ?,"
                                + "DIMENSION_ESTETICAp2 = ?, DesempeñoDEstetica = ?, IDIOMA_EXTRANJERO_E_INGLESp2 = ?,"
                                + "DesempeñoIngles = ?, EDUCACION_CRISTIANAp2 = ?,DesempeñoEducacionCristiana = ?,"
                                + "TECNOLOGIA_E_INFORMATICAp2 = ?,DesempeñoInformatica = ?,COMPORTAMIENTOp2 = ?, "
                                + "DesempeñoComportamiento = ?, Fallas_Justificadas = ?, Fallas_Sin_Justificar = ?,"
                                + "Observaciones = ? WHERE ID_Alumno = '" + b[18] + "'");
                        pst.setString(1, "Listo");//esto para dejarlo diferente de ""
                        pst.setString(2, b[0]);//Dimensión cognitiva
                        pst.setString(3, Dcognitiva);//Desempeño Dimensión Cognitiva
                        pst.setString(4, b[1]);//Dimensión comunicativa
                        pst.setString(5, Dcomunicativa);//Desempeño Dimensión comunicativa
                        pst.setString(6, b[2]);//Dimensión sicioafectiva
                        pst.setString(7, Dsociafectiva);//desempeño Dimensión sicioafectiva
                        pst.setString(8, b[3]);//Dimensión corporal
                        pst.setString(9, Dcorporal);//desempeño Dimensión corporal
                        pst.setString(10, b[8]);//Dimensión etica
                        pst.setString(11, Detica);//desempeño
                        pst.setString(12, b[9]);//Dimensión estetica
                        pst.setString(13, Destetica);//desempeño
                        pst.setString(14, b[10]);//Dimensión ingles
                        pst.setString(15, Idiomas);//desempeño
                        pst.setString(16, b[11]);//Dimensión educacion cristiana
                        pst.setString(17, Ecristiana);//desempeño
                        pst.setString(18, b[12]);//Dimensión  In
                        pst.setString(19, Dinformatica);//desempeño
                        pst.setString(20, b[13]);//Dimensión
                        pst.setString(21, compor);//desempeño
                        pst.setString(22, b[6]);//fallas justificadas
                        pst.setString(23, b[7]);//fallas sin justificar
                        pst.setString(24, b[5]);//Observaciones.

                        pst.executeUpdate();
                        cn.close();
                        JOptionPane.showMessageDialog(null, "Modificado " + b[4]);

                    } else if ("3"/*periodo*/.equals(b[4])) {
                        Connection cn = c.conectar();
                        PreparedStatement pst = cn.prepareStatement("update notas set "
                                + "Periodo3 = ?, DIMENSION_COGNITIVAp3 = ?, DesempeñoDCognitiva = ?,"
                                + " DIMENSION_COMUNICATIVAp3 = ?, DesempeñoDComunicativa = ?, DIMENSION_SOCIOAFECTIVAp3 = ?,"
                                + "DesempeñoDSocioafectiva = ?, DIMENSION_CORPORALp3 = ?, DesempeñoDCorporal = ?,"
                                + "DIMENSION_ETICA_ACTITUDES_Y_VALORESp3 = ?, DesempeñoDEticaValores = ?,"
                                + "DIMENSION_ESTETICAp3 = ?, DesempeñoDEstetica = ?, IDIOMA_EXTRANJERO_E_INGLESp3 = ?,"
                                + "DesempeñoIngles = ?, EDUCACION_CRISTIANAp3 = ?,DesempeñoEducacionCristiana = ?,"
                                + "TECNOLOGIA_E_INFORMATICAp3 = ?,DesempeñoInformatica = ?,COMPORTAMIENTOp3 = ?, "
                                + "DesempeñoComportamiento = ?, Fallas_Justificadas = ?, Fallas_Sin_Justificar = ?,"
                                + "Observaciones = ? WHERE ID_Alumno = '" + b[18] + "'");

                        pst.setString(1, "Listo");//esto para dejarlo diferente de ""
                        pst.setString(2, b[0]);//Dimensión cognitiva
                        pst.setString(3, Dcognitiva);//Desempeño Dimensión Cognitiva
                        pst.setString(4, b[1]);//Dimensión comunicativa
                        pst.setString(5, Dcomunicativa);//Desempeño Dimensión comunicativa
                        pst.setString(6, b[2]);//Dimensión sicioafectiva
                        pst.setString(7, Dsociafectiva);//desempeño Dimensión sicioafectiva
                        pst.setString(8, b[3]);//Dimensión corporal
                        pst.setString(9, Dcorporal);//desempeño Dimensión corporal
                        pst.setString(10, b[8]);//Dimensión etica
                        pst.setString(11, Detica);//desempeño
                        pst.setString(12, b[9]);//Dimensión estetica
                        pst.setString(13, Destetica);//desempeño
                        pst.setString(14, b[10]);//Dimensión ingles
                        pst.setString(15, Idiomas);//desempeño
                        pst.setString(16, b[11]);//Dimensión educacion cristiana
                        pst.setString(17, Ecristiana);//desempeño
                        pst.setString(18, b[12]);//Dimensión  In
                        pst.setString(19, Dinformatica);//desempeño
                        pst.setString(20, b[13]);//Dimensión
                        pst.setString(21, compor);//desempeño
                        pst.setString(22, b[6]);//fallas justificadas
                        pst.setString(23, b[7]);//fallas sin justificar
                        pst.setString(24, b[5]);//Observaciones.

                        pst.executeUpdate();
                        cn.close();
                        JOptionPane.showMessageDialog(null, "Modificado " + b[4]);

                    } else if ("4"/*periodo*/.equals(b[4])) {

                        Connection cn = c.conectar();
                        PreparedStatement pst = cn.prepareStatement("update notas set "
                                + "Periodo4 = ?, DIMENSION_COGNITIVAp4 = ?, DesempeñoDCognitiva = ?,"
                                + " DIMENSION_COMUNICATIVAp4 = ?, DesempeñoDComunicativa = ?, DIMENSION_SOCIOAFECTIVAp4 = ?,"
                                + "DesempeñoDSocioafectiva = ?, DIMENSION_CORPORALp4 = ?, DesempeñoDCorporal = ?,"
                                + "DIMENSION_ETICA_ACTITUDES_Y_VALORESp4 = ?, DesempeñoDEticaValores = ?,"
                                + "DIMENSION_ESTETICAp4 = ?, DesempeñoDEstetica = ?, IDIOMA_EXTRANJERO_E_INGLESp4 = ?,"
                                + "DesempeñoIngles = ?, EDUCACION_CRISTIANAp4 = ?,DesempeñoEducacionCristiana = ?,"
                                + "TECNOLOGIA_E_INFORMATICAp4 = ?,DesempeñoInformatica = ?,COMPORTAMIENTOp4 = ?, "
                                + "DesempeñoComportamiento = ?, Fallas_Justificadas = ?, Fallas_Sin_Justificar = ?,"
                                + "Observaciones = ? WHERE ID_Alumno = '" + b[18] + "'");

                        pst.setString(1, "Listo");//esto para dejarlo diferente de ""
                        pst.setString(2, b[0]);//Dimensión cognitiva
                        pst.setString(3, Dcognitiva);//Desempeño Dimensión Cognitiva
                        pst.setString(4, b[1]);//Dimensión comunicativa
                        pst.setString(5, Dcomunicativa);//Desempeño Dimensión comunicativa
                        pst.setString(6, b[2]);//Dimensión sicioafectiva
                        pst.setString(7, Dsociafectiva);//desempeño Dimensión sicioafectiva
                        pst.setString(8, b[3]);//Dimensión corporal
                        pst.setString(9, Dcorporal);//desempeño Dimensión corporal
                        pst.setString(10, b[8]);//Dimensión etica
                        pst.setString(11, Detica);//desempeño
                        pst.setString(12, b[9]);//Dimensión estetica
                        pst.setString(13, Destetica);//desempeño
                        pst.setString(14, b[10]);//Dimensión ingles
                        pst.setString(15, Idiomas);//desempeño
                        pst.setString(16, b[11]);//Dimensión educacion cristiana
                        pst.setString(17, Ecristiana);//desempeño
                        pst.setString(18, b[12]);//Dimensión  In
                        pst.setString(19, Dinformatica);//desempeño
                        pst.setString(20, b[13]);//Dimensión
                        pst.setString(21, compor);//desempeño
                        pst.setString(22, b[6]);//fallas justificadas
                        pst.setString(23, b[7]);//fallas sin justificar
                        pst.setString(24, b[5]);//Observaciones.

                        pst.executeUpdate();
                        cn.close();
                        JOptionPane.showMessageDialog(null, "Modificado " + b[4]);

                    }

                } catch (SQLException e) {
                    System.out.println("error de correccion " + e);
                }
            } else if (primaria == true) {

                //declaracion de variables
                //se establecen las variables  para sacar las cuentas de la areas.
                double campo1 = /*se combierte a double*/ Double.parseDouble(b[0])/*matematicas*/,
                        campo2 = Double.parseDouble(b[1])/*geometria*/,
                        campo3 = Double.parseDouble(b[2])/*castellano*/,
                        campo4 = Double.parseDouble(b[3])/*Ingles*/,
                        campo5 = Double.parseDouble(b[8])/*Naturales*/,
                        campo6 = Double.parseDouble(b[9])/*sociales*/,
                        campo7 = Double.parseDouble(b[10])/*ConstitucionPolitica*/,
                        campo8 = Double.parseDouble(b[11])/*Etica Valores*/,
                        campo9 = Double.parseDouble(b[12])/*Artistica*/,
                        campo10 = Double.parseDouble(b[13])/*catedra de paz*/,
                        campo11 = Double.parseDouble(b[14])/*educacion cristiana*/,
                        campo12 = Double.parseDouble(b[15])/*deportes*/,
                        campo13 = Double.parseDouble(b[16])/*informatica*/,
                        campo14 = Double.parseDouble(b[17])/*desempeño*/,
                        area3 = 0, area2 = 0, area1 = 0;

                //se calcula el promedio del area de matematicas
                area1 = (campo1 + campo2) / 2;/*area de matematicas*/
                //se comvierte a String
                String Area1 = String.valueOf(area1);
                //se calcula el promedio del 
                //area de Humanidades e idioma extrangero
                area2 = (campo3 + campo4) / 2; //Humanidades e idioma extrangero
                //se combierte a String
                String Area2 = String.valueOf(area2);
                //se calcula el promedio del area de ciencias sociales
                area3 = (campo6 + campo7) / 2;//ciencias sociales.
                //se combierte en String
                String Area3 = String.valueOf(area3);

                /*BA: Bajo 1-5.9 B: Básico 6.0-7.9   A: Alto 8.0-9.0   S: Superior9.1-10.0  */
                //variables de desempeño
                String AreaM = "", Mate = "", Geometri = "";
                String AreaH = "", Castellano = "", ingles = "",
                        naturales = "", ASocial = "", social = "", constitu = "",
                        eticaV = "", artistica = "", catedra = "", eduCrist = "",
                        depor = "", infor = "", compor = "";
                //se asigna desempeño a area de matematicas
                if (area1 <= 5.9) {
                    AreaM = "BA";
                } else if (area1 > 5.9 && area1 <= 7.9) {
                    AreaM = "B";
                } else if (area1 > 7.9 && area1 < 9) {
                    AreaM = "A";
                } else if (area1 > 9 && area1 <= 10) {
                    AreaM = "S";
                }
                // se asigna desempeño a matematica
                if (campo1 <= 5.9) {
                    Mate = "BA";
                } else if (campo1 > 5.9 && campo1 <= 7.9) {
                    Mate = "B";
                } else if (campo1 > 7.9 && campo1 < 9) {
                    Mate = "A";
                } else if (campo1 > 9 && campo1 <= 10) {
                    Mate = "S";
                }
                //Se asigna desempeño a geometria
                if (campo2 <= 5.9) {
                    Geometri = "BA";
                } else if (campo2 > 5.9 && campo2 <= 7.9) {
                    Geometri = "B";
                } else if (campo2 > 7.9 && campo2 < 9) {
                    Geometri = "A";
                } else if (campo2 > 9 && campo2 <= 10) {
                    Geometri = "S";
                }
                // se asigna desempeño a Area Humanidades
                if (area2 <= 5.9) {
                    AreaH = "BA";
                } else if (area2 > 5.9 && area2 <= 7.9) {
                    AreaH = "B";
                } else if (area2 > 7.9 && area2 < 9) {
                    AreaH = "A";
                } else if (area2 > 9 && area2 <= 10) {
                    AreaH = "S";
                }
                //se asigna desempeño a castellano
                if (campo3 <= 5.9) {
                    Castellano = "BA";
                } else if (campo3 > 5.9 && campo3 <= 7.9) {
                    Castellano = "B";
                } else if (campo3 > 7.9 && campo3 < 9) {
                    Castellano = "A";
                } else if (campo3 > 9 && campo3 <= 10) {
                    Castellano = "S";
                }
                //se asigna desempeño a Ingles
                if (campo4 <= 5.9) {
                    ingles = "BA";
                } else if (campo4 > 5.9 && campo4 <= 7.9) {
                    ingles = "B";
                } else if (campo4 > 7.9 && campo4 < 9) {
                    ingles = "A";
                } else if (campo4 > 9 && campo4 <= 10) {
                    ingles = "S";
                }
                //se asigna desempeñoa a area de naturales Ed ambiental y naturales
                if (campo5 <= 5.9) {
                    naturales = "BA";
                } else if (campo5 > 5.9 && campo5 <= 7.9) {
                    naturales = "B";
                } else if (campo5 > 7.9 && campo5 < 9) {
                    naturales = "A";
                } else if (campo5 > 9 && campo5 <= 10) {
                    naturales = "S";
                }
                //se asigna desempeño a area de sociales
                if (area3 <= 5.9) {
                    ASocial = "BA";
                } else if (area3 > 5.9 && area3 <= 7.9) {
                    ASocial = "B";
                } else if (area3 > 7.9 && area3 < 9) {
                    ASocial = "A";
                } else if (area3 > 9 && area3 <= 10) {
                    ASocial = "S";
                }
                //se asigna desempeñoa a sociales
                if (campo6 <= 5.9) {
                    social = "BA";
                } else if (campo6 > 5.9 && campo6 <= 7.9) {
                    social = "B";
                } else if (campo6 > 7.9 && campo6 < 9) {
                    social = "A";
                } else if (campo6 > 9 && campo6 <= 10) {
                    social = "S";
                }
                //se asigna desempeño constitucionPolitica
                if (campo7 <= 5.9) {
                    constitu = "BA";
                } else if (campo7 > 5.9 && campo7 <= 7.9) {
                    constitu = "B";
                } else if (campo7 > 7.9 && campo7 < 9) {
                    constitu = "A";
                } else if (campo7 > 9 && campo7 <= 10) {
                    constitu = "S";
                }
                //se asigna desempeño a etica valores
                if (campo8 <= 5.9) {
                    eticaV = "BA";
                } else if (campo8 > 5.9 && campo8 <= 7.9) {
                    eticaV = "B";
                } else if (campo8 > 7.9 && campo8 < 9) {
                    eticaV = "A";
                } else if (campo8 > 9 && campo8 <= 10) {
                    eticaV = "S";
                }
                //se asigna desempeño a artistica
                if (campo9 <= 5.9) {
                    artistica = "BA";
                } else if (campo9 > 5.9 && campo9 <= 7.9) {
                    artistica = "B";
                } else if (campo9 > 7.9 && campo9 < 9) {
                    artistica = "A";
                } else if (campo9 > 9 && campo9 <= 10) {
                    artistica = "S";
                }
                //se asigna desempeño a catedra de paz
                if (campo10 <= 5.9) {
                    catedra = "BA";
                } else if (campo10 > 5.9 && campo10 <= 7.9) {
                    catedra = "B";
                } else if (campo10 > 7.9 && campo10 < 9) {
                    catedra = "A";
                } else if (campo10 > 9 && campo10 <= 10) {
                    catedra = "S";
                }
                //se asigna desempeño a educacion cristiana
                if (campo11 <= 5.9) {
                    eduCrist = "BA";
                } else if (campo11 > 5.9 && campo11 <= 7.9) {
                    eduCrist = "B";
                } else if (campo11 > 7.9 && campo11 < 9) {
                    eduCrist = "A";
                } else if (campo11 > 9 && campo11 <= 10) {
                    eduCrist = "S";
                }
                //se asigna desempeño de deportes
                if (campo12 <= 5.9) {
                    depor = "BA";
                } else if (campo12 > 5.9 && campo12 <= 7.9) {
                    depor = "B";
                } else if (campo12 > 7.9 && campo12 < 9) {
                    depor = "A";
                } else if (campo12 > 9 && campo12 <= 10) {
                    depor = "S";
                }
                // se asigna desempeño a informatica
                if (campo13 <= 5.9) {
                    infor = "BA";
                } else if (campo13 > 5.9 && campo13 <= 7.9) {
                    infor = "B";
                } else if (campo13 > 7.9 && campo13 < 9) {
                    infor = "A";
                } else if (campo13 > 9 && campo13 <= 10) {
                    infor = "S";
                }
                //se asigna desempeño a comportamiento
                if (campo14 <= 5.9) {
                    compor = "BA";
                } else if (campo14 > 5.9 && campo14 <= 7.9) {
                    compor = "B";
                } else if (campo14 > 7.9 && campo14 < 9) {
                    compor = "A";
                } else if (campo14 > 9 && campo14 <= 10) {
                    compor = "S";
                }

                try {

                    // se escoge el periodo
                    if ("2".equals(b[4])) {
                        Connection cn = c.conectar();
                        PreparedStatement pst = cn.prepareStatement("update notas_primaria set "
                                + "Periodo2 = ?, AREA_DE_MATEMATICASp2 = ?, DesempeñoAreaMatematicas = ?,"
                                + "MATEMATICASp2 = ?, DesempeñoMatematicas = ?, GEOMETRIAp2 = ?,"
                                + "DesempeñoGeometria = ?, AREA_DE_HUMANIDADES_E_IDIOMA_EXTRANGEROp2 = ?,"
                                + "DesempeñoAreaHumanidades = ?, CASTELLANOp2 = ?, DesempeñoCastellano = ?,"
                                + "INGLESp2 = ?, DesempeñoIngles = ?, CIENCIAS_NATURALES_Y_EDUCACION_AMBIENTALp2 = ?,"
                                + "DesempeñoNaturalesEduAmbiental = ?, NATURALESp2 = ?, DesempeñoNaturales = ?,"
                                + "AREA_DE_CIENCIAS_SOCIALESp2 = ?, DesempeñoAreaSociales = ?, CIENCIAS_SOCIALESp2 = ?,"
                                + "DesempeñoSociles = ?,CONSTITUCION_POLITICAp2 = ?, DesempeñoConstitucion = ?,"
                                + "EDUCACION_ETICA_ACTITUDES_Y_VALORESp2 = ?, DesempeñoEticaValores = ?, EDUCACION_ARTISTICAp2 = ?,"
                                + "DesempeñoArtistica = ?, CATEDRA_DE_PAZp2 = ?, DesempeñoCatedraDePaz = ?,"
                                + "EDUCACION_CRISTIANAp2 = ?, DesempeñoEduCristiana = ?, EDUCACION_FISICA_RECREACION_Y_DEPORTESp2 = ?,"
                                + "DesempeñoDeportes = ?, TECNOLOGIA_E_INFORMATICAp2 = ?, DesempeñoInformatica = ?,"
                                + "COMPORTAMIENTOp2 = ?, DesempeñoComportamiento = ?, Fallas_Justificadas = ?, Fallas_Sin_Justificar = ?,"
                                + "Observaciones = ? WHERE ID_Alumno = '" + b[18] + "'");

                        pst.setString(1, "Listo");
                        pst.setString(2, Area1);//area de matematicas
                        pst.setString(3, AreaM);//desempeño area matematicas
                        pst.setString(4, b[0]);//matematicas
                        pst.setString(5, Mate);//desempeño amtematicas
                        pst.setString(6, b[1]);//geometria
                        pst.setString(7, Geometri);//desempeño geometria.
                        pst.setString(8, Area2);//Area de humanidades
                        pst.setString(9, AreaH);//desempeño area de humanidades
                        pst.setString(10, b[2]);//Castellano
                        pst.setString(11, Castellano);//desempeño castellano
                        pst.setString(12, b[3]);//Ingles
                        pst.setString(13, ingles);//Desempeño ingles
                        pst.setString(14, b[8]);//ciencias naturales y edu ambiental
                        pst.setString(15, naturales);//desempeño naturales edu ambiental
                        pst.setString(16, b[8]);//naturales
                        pst.setString(17, naturales);//desempeño naturales
                        pst.setString(18, Area3);//area ciencias sociales
                        pst.setString(19, ASocial);//desempeño area ciencias sociales
                        pst.setString(20, b[9]);//sociales
                        pst.setString(21, social);//desempeño sociales
                        pst.setString(22, b[10]);//Constitucion politica
                        pst.setString(23, constitu);//desempeño constitucion politica
                        pst.setString(24, b[11]);//educacion etica y valores
                        pst.setString(25, eticaV);//desempeño etica y valores
                        pst.setString(26, b[12]);//educacion artistica
                        pst.setString(27, artistica);//desempeño artistica
                        pst.setString(28, b[13]);//catedra de paz
                        pst.setString(29, catedra);//desempeño catedra de paz
                        pst.setString(30, b[14]);//educacion cristiana
                        pst.setString(31, eduCrist);//desempeño educacion cristiana
                        pst.setString(32, b[15]);//recreacion y deporte
                        pst.setString(33, depor);//desempeño deportes
                        pst.setString(34, b[16]);//tecnologia e informatica
                        pst.setString(35, infor);//desempeño informatica
                        pst.setString(36, b[17]);//comportamiento
                        pst.setString(37, compor);//desempeño comportamiento
                        pst.setString(38, b[6]);//fallas justificadas 
                        pst.setString(39, b[7]);//fallas sin justificar
                        pst.setString(40, b[5]);//observaciones

                        pst.executeUpdate();
                        cn.close();
                        JOptionPane.showMessageDialog(null, "Modificado " + b[4]);

                    } else if ("3"/*periodo*/.equals(b[4])) {

                        Connection cn = c.conectar();
                        PreparedStatement pst = cn.prepareStatement("update notas_primaria set "
                                + "Periodo3 = ?, AREA_DE_MATEMATICASp3 = ?, DesempeñoAreaMatematicas = ?,"
                                + "MATEMATICASp3 = ?, DesempeñoMatematicas = ?, GEOMETRIAp3 = ?,"
                                + "DesempeñoGeometria = ?, AREA_DE_HUMANIDADES_E_IDIOMA_EXTRANGEROp3 = ?,"
                                + "DesempeñoAreaHumanidades = ?, CASTELLANOp3 = ?, DesempeñoCastellano = ?,"
                                + "INGLESp3 = ?, DesempeñoIngles = ?, CIENCIAS_NATURALES_Y_EDUCACION_AMBIENTALp3 = ?,"
                                + "DesempeñoNaturalesEduAmbiental = ?, NATURALESp3 = ?, DesempeñoNaturales = ?,"
                                + "AREA_DE_CIENCIAS_SOCIALESp3 = ?, DesempeñoAreaSociales = ?, CIENCIAS_SOCIALESp3 = ?,"
                                + "DesempeñoSociles = ?,CONSTITUCION_POLITICAp3 = ?, DesempeñoConstitucion = ?,"
                                + "EDUCACION_ETICA_ACTITUDES_Y_VALORESp3 = ?, DesempeñoEticaValores = ?, EDUCACION_ARTISTICAp3 = ?,"
                                + "DesempeñoArtistica = ?, CATEDRA_DE_PAZp3 = ?, DesempeñoCatedraDePaz = ?,"
                                + "EDUCACION_CRISTIANAp3 = ?, DesempeñoEduCristiana = ?, EDUCACION_FISICA_RECREACION_Y_DEPORTESp3 = ?,"
                                + "DesempeñoDeportes = ?, TECNOLOGIA_E_INFORMATICAp3 = ?, DesempeñoInformatica = ?,"
                                + "COMPORTAMIENTOp3 = ?, DesempeñoComportamiento = ?, Fallas_Justificadas = ?, Fallas_Sin_Justificar = ?,"
                                + "Observaciones = ? WHERE ID_Alumno = '" + b[18] + "'");

                        pst.setString(1, "Listo");
                        pst.setString(2, Area1);//area de matematicas
                        pst.setString(3, AreaM);//desempeño area matematicas
                        pst.setString(4, b[0]);//matematicas
                        pst.setString(5, Mate);//desempeño amtematicas
                        pst.setString(6, b[1]);//geometria
                        pst.setString(7, Geometri);//desempeño geometria.
                        pst.setString(8, Area2);//Area de humanidades
                        pst.setString(9, AreaH);//desempeño area de humanidades
                        pst.setString(10, b[2]);//Castellano
                        pst.setString(11, Castellano);//desempeño castellano
                        pst.setString(12, b[3]);//Ingles
                        pst.setString(13, ingles);//Desempeño ingles
                        pst.setString(14, b[8]);//ciencias naturales y edu ambiental
                        pst.setString(15, naturales);//desempeño naturales edu ambiental
                        pst.setString(16, b[8]);//naturales
                        pst.setString(17, naturales);//desempeño naturales
                        pst.setString(18, Area3);//area ciencias sociales
                        pst.setString(19, ASocial);//desempeño area ciencias sociales
                        pst.setString(20, b[9]);//sociales
                        pst.setString(21, social);//desempeño sociales
                        pst.setString(22, b[10]);//Constitucion politica
                        pst.setString(23, constitu);//desempeño constitucion politica
                        pst.setString(24, b[11]);//educacion etica y valores
                        pst.setString(25, eticaV);//desempeño etica y valores
                        pst.setString(26, b[12]);//educacion artistica
                        pst.setString(27, artistica);//desempeño artistica
                        pst.setString(28, b[13]);//catedra de paz
                        pst.setString(29, catedra);//desempeño catedra de paz
                        pst.setString(30, b[14]);//educacion cristiana
                        pst.setString(31, eduCrist);//desempeño educacion cristiana
                        pst.setString(32, b[15]);//recreacion y deporte
                        pst.setString(33, depor);//desempeño deportes
                        pst.setString(34, b[16]);//tecnologia e informatica
                        pst.setString(35, infor);//desempeño informatica
                        pst.setString(36, b[17]);//comportamiento
                        pst.setString(37, compor);//desempeño comportamiento
                        pst.setString(38, b[6]);//fallas justificadas 
                        pst.setString(39, b[7]);//fallas sin justificar
                        pst.setString(40, b[5]);//observaciones

                        pst.executeUpdate();
                        cn.close();
                        JOptionPane.showMessageDialog(null, "Modificado " + b[4]);

                    } else if ("4"/*periodo*/.equals(b[4])) {

                        Connection cn = c.conectar();
                        PreparedStatement pst = cn.prepareStatement("update notas_primaria set "
                                + "Periodo4 = ?, AREA_DE_MATEMATICASp4 = ?, DesempeñoAreaMatematicas = ?,"
                                + "MATEMATICASp4 = ?, DesempeñoMatematicas = ?, GEOMETRIAp4 = ?,"
                                + "DesempeñoGeometria = ?, AREA_DE_HUMANIDADES_E_IDIOMA_EXTRANGEROp4 = ?,"
                                + "DesempeñoAreaHumanidades = ?, CASTELLANOp4 = ?, DesempeñoCastellano = ?,"
                                + "INGLESp4 = ?, DesempeñoIngles = ?, CIENCIAS_NATURALES_Y_EDUCACION_AMBIENTALp4 = ?,"
                                + "DesempeñoNaturalesEduAmbiental = ?, NATURALESp4 = ?, DesempeñoNaturales = ?,"
                                + "AREA_DE_CIENCIAS_SOCIALESp4 = ?, DesempeñoAreaSociales = ?, CIENCIAS_SOCIALESp4 = ?,"
                                + "DesempeñoSociles = ?,CONSTITUCION_POLITICAp4 = ?, DesempeñoConstitucion = ?,"
                                + "EDUCACION_ETICA_ACTITUDES_Y_VALORESp4 = ?, DesempeñoEticaValores = ?, EDUCACION_ARTISTICAp4 = ?,"
                                + "DesempeñoArtistica = ?, CATEDRA_DE_PAZp4 = ?, DesempeñoCatedraDePaz = ?,"
                                + "EDUCACION_CRISTIANAp4 = ?, DesempeñoEduCristiana = ?, EDUCACION_FISICA_RECREACION_Y_DEPORTESp4 = ?,"
                                + "DesempeñoDeportes = ?, TECNOLOGIA_E_INFORMATICAp2 = ?, DesempeñoInformatica = ?,"
                                + "COMPORTAMIENTOp4 = ?, DesempeñoComportamiento = ?, Fallas_Justificadas = ?, Fallas_Sin_Justificar = ?,"
                                + "Observaciones = ? WHERE ID_Alumno = '" + b[18] + "'");

                        pst.setString(1, "Listo");
                        pst.setString(2, Area1);//area de matematicas
                        pst.setString(3, AreaM);//desempeño area matematicas
                        pst.setString(4, b[0]);//matematicas
                        pst.setString(5, Mate);//desempeño amtematicas
                        pst.setString(6, b[1]);//geometria
                        pst.setString(7, Geometri);//desempeño geometria.
                        pst.setString(8, Area2);//Area de humanidades
                        pst.setString(9, AreaH);//desempeño area de humanidades
                        pst.setString(10, b[2]);//Castellano
                        pst.setString(11, Castellano);//desempeño castellano
                        pst.setString(12, b[3]);//Ingles
                        pst.setString(13, ingles);//Desempeño ingles
                        pst.setString(14, b[8]);//ciencias naturales y edu ambiental
                        pst.setString(15, naturales);//desempeño naturales edu ambiental
                        pst.setString(16, b[8]);//naturales
                        pst.setString(17, naturales);//desempeño naturales
                        pst.setString(18, Area3);//area ciencias sociales
                        pst.setString(19, ASocial);//desempeño area ciencias sociales
                        pst.setString(20, b[9]);//sociales
                        pst.setString(21, social);//desempeño sociales
                        pst.setString(22, b[10]);//Constitucion politica
                        pst.setString(23, constitu);//desempeño constitucion politica
                        pst.setString(24, b[11]);//educacion etica y valores
                        pst.setString(25, eticaV);//desempeño etica y valores
                        pst.setString(26, b[12]);//educacion artistica
                        pst.setString(27, artistica);//desempeño artistica
                        pst.setString(28, b[13]);//catedra de paz
                        pst.setString(29, catedra);//desempeño catedra de paz
                        pst.setString(30, b[14]);//educacion cristiana
                        pst.setString(31, eduCrist);//desempeño educacion cristiana
                        pst.setString(32, b[15]);//recreacion y deporte
                        pst.setString(33, depor);//desempeño deportes
                        pst.setString(34, b[16]);//tecnologia e informatica
                        pst.setString(35, infor);//desempeño informatica
                        pst.setString(36, b[17]);//comportamiento
                        pst.setString(37, compor);//desempeño comportamiento
                        pst.setString(38, b[6]);//fallas justificadas 
                        pst.setString(39, b[7]);//fallas sin justificar
                        pst.setString(40, b[5]);//observaciones

                        pst.executeUpdate();
                        cn.close();
                        JOptionPane.showMessageDialog(null, "Modificado " + b[4]);

                    }

                } catch (SQLException e) {
                    System.out.println("errorr aqka " + e);
                }

            }//else primaria true

        }//else registrado true

    }//metodo registrar nota

}//clase
