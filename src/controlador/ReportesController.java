package controlador;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author caill
 */
public class ReportesController {

    public void TicketRetiro(int idFuncionario) {
        Document documento = new Document();
        String ruta = System.getProperty("user.home") + "/OneDrive/Escritorio/Reporte_funcionario.pdf";

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // Cargar la imagen del encabezado
            try {
                Image header = Image.getInstance("src/img/registro.png");
                header.scaleToFit(100, 100);
                header.setAlignment(Chunk.ALIGN_CENTER);
                documento.add(header);
            } catch (IOException ex) {
                System.out.println("Error al cargar la imagen del encabezado: " + ex);
            }

            // Conexión y consulta a la base de datos
            try (Connection cn = Conexion.conectar()) {
                String sql = "SELECT * FROM tb_funcionario WHERE id_funcionario = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, idFuncionario);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    // Encabezado del ticket
                    Paragraph parrafo = new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.add("Sistema de Ingreso y Registro \n ©NexusPro\n\n");
                    parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
                    parrafo.add("_____________________________________________________\n\n");
                    documento.add(parrafo);

                    // Contenido del ticket
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String fechaSalida = dateFormat.format(rs.getTimestamp("hora_salida"));
                    String fechaEntrada = dateFormat.format(rs.getTimestamp("hora_entrada"));

                    Paragraph contenido = new Paragraph();
                    contenido.setAlignment(Paragraph.ALIGN_LEFT);
                    contenido.add("Curso: " + rs.getString("curso") + "\n");
                    contenido.add("Nombre: " + rs.getString("nombre") + "\n");
                    contenido.add("Especialidad: " + rs.getString("especialidad") + "\n");
                    contenido.add("Cargo: " + rs.getString("cargo") + "\n");
                    contenido.add("Hora de entrada: " + fechaEntrada + "\n");
                    contenido.add("Hora de salida: " + fechaSalida + "\n");
                    contenido.add("Estado: " + rs.getString("estado") + "\n\n");
                    contenido.add("_____________________________________________________\n\n");
                    contenido.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.BLACK));

                    documento.add(contenido);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un funcionario con el ID proporcionado.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al acceder a la base de datos: " + ex);
            }

            // Mensaje de éxito
            JOptionPane.showMessageDialog(null, "Ticket creado con éxito en: " + ruta);
        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Error al generar el documento: " + ex);
        } finally {
            // Cierre seguro del documento
            if (documento.isOpen()) {
                documento.close();
            }
        }
    }

    public void generarReporteTabla() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        Document documento = new Document();
        String ruta = System.getProperty("user.home") + "/OneDrive/Escritorio/Reporte_Tabla_Registro.pdf";

        PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        documento.open();
        // Añadir encabezado
        try {
            Image header = Image.getInstance("src/img/header2.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(header);
        } catch (IOException ex) {
            System.out.println("Error al cargar la imagen del encabezado: " + ex);
        }
        // Título del reporte       
        Paragraph titulo = new Paragraph("Informe Control de Asistencia\n",
                FontFactory.getFont("Tahoma", 20, java.awt.Font.BOLD, BaseColor.DARK_GRAY));
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);
        // Línea separadora
        Paragraph separador = new Paragraph(
                "____________________________________________________________\n\n");
        documento.add(separador);

        // Agregar el nombre del creador del reporte
        Paragraph creadoPor = new Paragraph("CHRISTOPHER ILLATARCOS\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        creadoPor.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(creadoPor);

        // Agregar el nombre de la profesión
        Paragraph profesion = new Paragraph("Ingeniero en Informática\n\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        profesion.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(profesion);
        
           // Agregar el nombre de la escuela
        Paragraph escuela = new Paragraph("Escuela Alemanía\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        escuela.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(escuela);

        // Otra línea separadora
        Paragraph separador2 = new Paragraph("_____________________________________________________\n\n");
        separador2.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(separador2);

        // Conexión y consulta de datos
        try (Connection cn = Conexion.conectar()) {
            String sql = "SELECT id_funcionario, nombre, cargo, especialidad, curso, hora_entrada, hora_salida, estado FROM tb_funcionario";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Crear tabla PDF
            PdfPTable tabla = new PdfPTable(8); // 8 columnas
            tabla.setWidthPercentage(110);
            tabla.setWidths(new float[]{1.5f, 3f, 2f, 3f, 2f, 3f, 3f, 2f}); // Anchos de columnas
            tabla.setSpacingBefore(10f);

            // Encabezados de la tabla
            tabla.addCell(new PdfPCell(new Phrase("ID", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Nombre", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Cargo", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Especialidad", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Curso", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Hora Entrada", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Hora Salida", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Estado", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });

            // Llenar tabla con datos de la base
            while (rs.next()) {
                tabla.addCell(new PdfPCell(new Phrase(String.valueOf(rs.getInt("id_funcionario")))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("nombre"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("cargo"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("especialidad"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("curso"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("hora_entrada"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("hora_salida"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("estado"))));
            }

            // Añadir la tabla al documento
            documento.add(tabla);

        } catch (SQLException ex) {
            System.out.println("Error al acceder a la base de datos: " + ex);
        }
        // Mensaje de éxito
        JOptionPane.showMessageDialog(null, "Reporte generado con éxito en: " + ruta);
        // Cerrar el documento
        if (documento.isOpen()) {
            documento.close();
        }
    }

//    //metodo para crear el ticket
//    public void TicketRetiro(int idFuncionario) {
//
//        Document documento = new Document();
//        try {
//            String ruta = System.getProperty("user.home");
//            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/OneDrive/Escritorio/Reporte_Clientes.pdf"));
//            Image header = Image.getInstance("src/img/registro.png");
//            header.scaleToFit(100, 100);
//            header.setAlignment(Chunk.ALIGN_CENTER);
//            try {
//                Connection cn = Conexion.conectar();
//                PreparedStatement pst = cn.prepareStatement(
//                        "SELECT * FROM tb_funcionario WHERE id_funcionario = '" + idFuncionario + "';");
//                ResultSet rs = pst.executeQuery();
//                if (rs.next()) {
//                    Paragraph parrafo = new Paragraph();
//                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
//                    parrafo.add("Sistema de Ingreso y Registro \n ©NexusPro\n\n");
//                    parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
//                    parrafo.add("_____________________________________________________\n\n");
//                    Timestamp timestamp = rs.getTimestamp("hora_salida");
//                    Date fecha = new Date(timestamp.getTime());
//                    parrafo.add("Ticket de Retiro de " + rs.getString("curso") + " - (nombre: " + rs.getString("nombre") + ")\n\n");
//                    parrafo.add(fecha + "\n");
//                    parrafo.add("_____________________________________________________\n\n");
//
//                    Paragraph contenido = new Paragraph();
//                    contenido.setAlignment(Paragraph.ALIGN_CENTER);
//                    contenido.add("Especialidad: " + rs.getString("especialidad") + "\n");
//
//                    Timestamp timestampEntrada = rs.getTimestamp("hora_entrada");
//                    Time horaEntrada = new Time(timestampEntrada.getTime());
//                    contenido.add("Entrada:" + horaEntrada + "\n");
//
//                    Timestamp timestampSalida = rs.getTimestamp("hora_salida");
//                    Time horaSalida = new Time(timestampSalida.getTime());
//                    contenido.add("Salida:" + horaSalida + "\n");
//
//                    contenido.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.RED));
//                    parrafo.add("_____________________________________________________\n\n");
//
//                    documento.open();
//                    //añadir datos
//                    documento.add(header);
//                    documento.add(contenido);
//
//                }
//            } catch (SQLException e) {
//                System.out.println("Error 1 en:" + e);
//            }
//            documento.close();
//            JOptionPane.showMessageDialog(null, "Ticket Creado");
//        } catch (DocumentException e) {
//            System.out.println("Error 2 en:" + e);
//        } catch (FileNotFoundException ex) {
//            System.out.println("Error 3 en:" + ex);
//        } catch (IOException ex) {
//
//            System.out.println("Error 4 en:" + ex);
//        }
//    }
}
