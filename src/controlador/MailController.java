
package controlador;

/**
 *
 * @author caill
 */
//import jakarta.mail.*;
//import jakarta.mail.internet.*;
import java.io.IOException;
import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.*;

public class MailController {

    public static void enviarReportePorCorreo(String destinatario, String asunto, String mensaje, String rutaArchivoAdjunto) {
        // Configuración del servidor SMTP
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP
        propiedades.put("mail.smtp.port", "587"); // Puerto SMTP
        propiedades.put("mail.smtp.auth", "true"); // Autenticación requerida
        propiedades.put("mail.smtp.starttls.enable", "true"); // TLS habilitado

        // Credenciales del correo emisor
        final String correoEmisor = "cillatarcosc@gmail.com"; // Reemplaza con tu correo
        final String contraseña = "tucontraseña"; // Reemplaza con tu contraseña o token de app

        // Crear una sesión con autenticación
        Session sesion = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoEmisor, contraseña);
            }
        });

        try {
            // Crear el mensaje de correo
            MimeMessage mensajeCorreo = new MimeMessage(sesion);
            mensajeCorreo.setFrom(new InternetAddress(correoEmisor));
            mensajeCorreo.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mensajeCorreo.setSubject(asunto);

            // Crear el cuerpo del correo
            MimeBodyPart cuerpo = new MimeBodyPart();
            cuerpo.setText(mensaje);

            // Adjuntar el archivo
            MimeBodyPart archivoAdjunto = new MimeBodyPart();
            archivoAdjunto.attachFile(rutaArchivoAdjunto);

            // Combinar el cuerpo y el adjunto en un multipart
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(cuerpo);
            multipart.addBodyPart(archivoAdjunto);

            mensajeCorreo.setContent(multipart);

            // Enviar el correo
            Transport.send(mensajeCorreo);
            System.out.println("Correo enviado correctamente.");
        } catch (IOException | MessagingException e) {
            System.err.println("Error al enviar el correo: " + e.getMessage());
        }
    }
}
