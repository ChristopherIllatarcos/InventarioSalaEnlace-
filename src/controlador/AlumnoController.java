package controlador;

import modelo.Alumno;
import java.sql.*;
import conexion.Conexion;
import java.util.ArrayList;

/**
 *
 * @author caill
 */
public class AlumnoController {

    public boolean Guardar(Alumno objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            // Validar datos obligatorios
            if (objeto.getCurso() == null || objeto.getCurso().isEmpty()) {
                System.out.println("El curso no puede ser nulo o vacío.");
                return false;
            }

            // Mostrar datos a guardar
            System.out.println("Datos a guardar:");
            System.out.println("Nombre: " + objeto.getNombre());
            System.out.println("Curso: " + objeto.getCurso());
            System.out.println("Nombre Accesorio: " + objeto.getAccesorio_nombre());
            System.out.println("Número Accesorio: " + objeto.getNro_accesorio());
            System.out.println("Hora Entrega: " + objeto.getHora_entrega());
            System.out.println("Hora Devolución: " + objeto.getHora_devolucion());
            System.out.println("Estado: " + objeto.getEstado());

            // Consulta SQL
            String sql = "INSERT INTO tb_prestamo(nombre, curso, nombre_accesorio, numero_accesorio, hora_entrega, hora_devolucion, estado) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar valores
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getCurso());
            consulta.setString(3, objeto.getAccesorio_nombre());
            consulta.setInt(4, objeto.getNro_accesorio());
            consulta.setString(5, objeto.getHora_entrega());
            consulta.setString(6, objeto.getHora_devolucion());
            consulta.setString(7, objeto.getEstado());

            // Ejecutar la consulta
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar datos del alumno: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close(); // Cerrar conexión
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return respuesta;
    }

    // MÉTODO PARA ELIMINAR UN ALUMNO
    public boolean eliminar(int idAlumno) {
        boolean respuesta = false;
        String sql = "DELETE FROM tb_prestamo WHERE id_prestamo = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {

            // Asignar el parámetro al PreparedStatement
            consulta.setInt(1, idAlumno);

            // Ejecutar la consulta
            int filasAfectadas = consulta.executeUpdate();
            if (filasAfectadas > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar Alumno: " + e.getMessage());
        }

        return respuesta;
    }

    public boolean existeAlumno(String nombre) {
        boolean respuesta = false;
        String sql = "SELECT nombre FROM tb_prestamo WHERE nombre = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {

            // Se utiliza un PreparedStatement para prevenir inyección SQL
            pst.setString(1, nombre);

            try (ResultSet rs = pst.executeQuery()) {
                // Si el resultado tiene datos, el funcionario existe
                if (rs.next()) {
                    respuesta = true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar Alumno: " + e.getMessage());
        }

        return respuesta;
    }

    public ArrayList<Alumno> BuscarAlumnoNombreFecha(String nombre, String fecha) {
        ArrayList<Alumno> listaAlumno = new ArrayList<>();
        String sql = "SELECT * FROM tb_prestamo WHERE 1=1"; // Inicia con una condición siempre verdadera

        // Agregar condiciones a la consulta según los parámetros no vacíos
        if (!nombre.isEmpty()) {
            sql += " AND nombre LIKE ?";
        }
        if (!fecha.isEmpty()) {
            sql += " AND hora_entrega LIKE ?";
        }

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {

            int index = 1;
            // Establecer los parámetros de la consulta si son necesarios
            if (!nombre.isEmpty()) {
                pst.setString(index++, "%" + nombre + "%");
            }
            if (!fecha.isEmpty()) {
                pst.setString(index++, fecha + "%");
            }

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setIdAlumno(rs.getInt("id_prestamo"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setCurso(rs.getString("curso"));
                    alumno.setAccesorio_nombre(rs.getString("nombre_accesorio"));
                    alumno.setNro_accesorio(rs.getInt("numero_accesorio"));
                    alumno.setHora_entrega(rs.getString("hora_entrega"));
                    alumno.setHora_devolucion(rs.getString("hora_devolucion"));
                    alumno.setEstado(rs.getString("estado"));

                    listaAlumno.add(alumno);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar nombre y fecha del Alumno: " + e);
        }

        return listaAlumno;
    }

    // MÉTODO PARA ACTUALIZAR ALUMNO
    public boolean actualizarTablaAlumno(Alumno objeto, int idAlumno) {
        boolean respuesta = false;
        String sql = "UPDATE tb_prestamo SET nombre = ?, curso = ?, nombre_accesorio = ?, numero_accesorio = ?, hora_entrega = ?, hora_devolucion = ?, estado = ? WHERE id_prestamo = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {

            // Asignar los valores al PreparedStatement
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getCurso());
            consulta.setString(3, objeto.getAccesorio_nombre());
            consulta.setInt(4, objeto.getNro_accesorio());
            consulta.setString(5, objeto.getHora_entrega());
            consulta.setString(6, objeto.getHora_devolucion());
            consulta.setString(7, objeto.getEstado());

            consulta.setInt(8, idAlumno);

            // Ejecutar la consulta
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar Alumno: " + e.getMessage());
        }

        return respuesta;
    }

    public boolean actualizarAlumno(Alumno objeto, int idAlumno) {
        boolean respuesta = false;
        // Actualizar la columna hora_devolucion, no hora_entrega
        String sql = "UPDATE tb_prestamo SET hora_devolucion = ?, estado = ? WHERE id_prestamo = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {

            // Establecer los parámetros para hora_devolucion y estado
            consulta.setString(1, objeto.getHora_devolucion());
            consulta.setString(2, objeto.getEstado());
            consulta.setInt(3, idAlumno);

            // Ejecutar la actualización
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
        return respuesta;
    }

}
