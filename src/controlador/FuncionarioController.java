package controlador;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import modelo.Funcionario;

/**
 *
 * @author caill
 */
public class FuncionarioController {

    // Método para guardar registro de los funcionarios
    public boolean Guardar(Funcionario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            // Ajustar la consulta SQL: especificar las columnas a insertar
            String sql = "INSERT INTO tb_funcionario (nombre, cargo, especialidad, curso, hora_entrada, hora_salida, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Configuración de parámetros
            consulta.setString(1, objeto.getNombre());        // Primer parámetro
            consulta.setString(2, objeto.getCargo());         // Segundo parámetro
            consulta.setString(3, objeto.getEspecialidad());  // Tercer parámetro
            consulta.setString(4, objeto.getCurso());         // Cuarto parámetro
            consulta.setString(5, objeto.getHora_entrada());  // Quinto parámetro
            consulta.setString(6, objeto.getHora_salida());   // Sexto parámetro
            consulta.setString(7, objeto.getEstado());        // Séptimo parámetro

            // Ejecutar consulta y verificar resultado
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error en guardar: " + e.getMessage());
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
    
    
    
    

    //metodo para consultar datos del funcionario
    public ArrayList<Funcionario> listaFuncionario = new ArrayList<>();

    public ArrayList<Funcionario> BuscarFuncionarioNombreFecha(String nombreEspecialidad, String fecha) {
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        String sql = "";

        // Construir la consulta SQL dependiendo de los criterios
        if (!nombreEspecialidad.isEmpty() && !fecha.isEmpty()) {
            sql = "SELECT * FROM tb_funcionario WHERE "
                    + "(nombre LIKE '%" + nombreEspecialidad + "%' OR especialidad LIKE '%" + nombreEspecialidad + "%') "
                    + "AND hora_entrada LIKE '" + fecha + "%';";
        } else if (!nombreEspecialidad.isEmpty()) {
            sql = "SELECT * FROM tb_funcionario WHERE nombre LIKE '%" + nombreEspecialidad + "%' OR especialidad LIKE '%" + nombreEspecialidad + "%';";
        } else if (!fecha.isEmpty()) {
            sql = "SELECT * FROM tb_funcionario WHERE hora_entrada LIKE '" + fecha + "%';";
        }

        try (Connection cn = Conexion.conectar(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                funcionario.setNombre(rs.getString("nombre"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setEspecialidad(rs.getString("especialidad"));
                funcionario.setCurso(rs.getString("curso"));
                funcionario.setHora_entrada(rs.getString("hora_entrada"));
                funcionario.setHora_salida(rs.getString("hora_salida"));
                funcionario.setEstado(rs.getString("estado"));

                listaFuncionario.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar nombre y/o especialidad del Funcionario: " + e);
        }
        return listaFuncionario;
    }

    public boolean actualizar(Funcionario objeto, int idFuncionario) {
        boolean respuesta = false;
        String sql = "UPDATE tb_funcionario SET hora_salida = ?, estado = ? WHERE id_funcionario = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {

            consulta.setString(1, objeto.getHora_salida());
            consulta.setString(2, objeto.getEstado());
            consulta.setInt(3, idFuncionario);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
        return respuesta;
    }

    public boolean existeFuncionario(String nombre) {
        boolean respuesta = false;
        String sql = "SELECT nombre FROM tb_funcionario WHERE nombre = ?";

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
            System.out.println("Error al consultar Funcionario: " + e.getMessage());
        }

        return respuesta;
    }

    // MÉTODO PARA ELIMINAR UN FUNCIONARIO
    public boolean eliminar(int idFuncionario) {
        boolean respuesta = false;
        String sql = "DELETE FROM tb_funcionario WHERE id_funcionario = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {

            // Asignar el parámetro al PreparedStatement
            consulta.setInt(1, idFuncionario);

            // Ejecutar la consulta
            int filasAfectadas = consulta.executeUpdate();
            if (filasAfectadas > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar Funcionario: " + e.getMessage());
        }

        return respuesta;
    }
    
    // MÉTODO PARA ACTUALIZAR FUNCIONARIO
public boolean actualizarTabla(Funcionario objeto, int idFuncionario) {
    boolean respuesta = false;
    String sql = "UPDATE tb_funcionario SET nombre = ?, cargo = ?, especialidad = ?, curso = ?, hora_entrada = ?, hora_salida = ?, estado = ? WHERE id_funcionario = ?";

    try (Connection cn = Conexion.conectar();
         PreparedStatement consulta = cn.prepareStatement(sql)) {

        // Asignar los valores al PreparedStatement
        consulta.setString(1, objeto.getNombre());
        consulta.setString(2, objeto.getCargo());
        consulta.setString(3, objeto.getEspecialidad());
        consulta.setString(4, objeto.getCurso());
        consulta.setString(5, objeto.getHora_entrada());
        consulta.setString(6, objeto.getHora_salida());
        consulta.setString(7, objeto.getEstado());
        consulta.setInt(8, idFuncionario);

        // Ejecutar la consulta
        if (consulta.executeUpdate() > 0) {
            respuesta = true;
        }

    } catch (SQLException e) {
        System.out.println("Error al actualizar Funcionario: " + e.getMessage());
    }

    return respuesta;
}


}
