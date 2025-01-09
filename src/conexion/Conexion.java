package conexion;

//import com.sun.jdi.connect.spi.Connection;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author caill
 */
public class Conexion {

    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/bd_registro_horario_sala_computacion?useSSL=false&allowPublicKeyRetrieval=true";
        String usuario = "root";
        String contraseña = "admin";

        try {
            Connection cn = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión establecida con éxito.");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexión local: " + e.getMessage());
        }
        return null;
    }

}
