
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author caill
 */
public class ReporteAlumno {
    
     public void TicketRetiro(int idAlumno) {
        Document documento = new Document();
        String ruta = System.getProperty("user.home") + "/OneDrive/Escritorio/Reporte_prestamo.pdf";

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
                String sql = "SELECT * FROM tb_prestamo WHERE id_prestamo = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, idAlumno);

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
                    String fechaEntrega = dateFormat.format(rs.getTimestamp("hora_entrega"));
                    String fechaDevolucion = dateFormat.format(rs.getTimestamp("hora_devolucion"));

                    Paragraph contenido = new Paragraph();
                    contenido.setAlignment(Paragraph.ALIGN_LEFT);        
                    contenido.add("Nombre: " + rs.getString("nombre") + "\n");
                    contenido.add("Curso: " + rs.getString("curso") + "\n");
                    contenido.add("Nombre Accesorio: " + rs.getString("nombre_accesorio") + "\n");
                    contenido.add("Número Accesorio: " + rs.getString("numero_accesorio") + "\n");
                    contenido.add("Hora de entrega: " + fechaEntrega + "\n");
                    contenido.add("Hora de devolucion: " + fechaDevolucion + "\n");
                    contenido.add("Estado: " + rs.getString("estado") + "\n\n");
                    contenido.add("_____________________________________________________\n\n");
                    contenido.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.BLACK));

                    documento.add(contenido);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un Alumno con el ID proporcionado.");
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
        String ruta = System.getProperty("user.home") + "/OneDrive/Escritorio/Reporte_Tabla_prestamo.pdf";

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
        Paragraph titulo = new Paragraph("Informe Control de Prestamos Accesorios\n",
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
            String sql = "SELECT id_prestamo, nombre, curso, nombre_accesorio, numero_accesorio, hora_entrega, hora_devolucion, estado FROM tb_prestamo";
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
            tabla.addCell(new PdfPCell(new Phrase("Curso", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Accesorio", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Número", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Hora Entrega", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Hora Devolución", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
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
                tabla.addCell(new PdfPCell(new Phrase(String.valueOf(rs.getInt("id_prestamo")))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("nombre"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("curso"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("nombre_accesorio"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("numero_accesorio"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("hora_entrega"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("hora_devolucion"))));
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
}
