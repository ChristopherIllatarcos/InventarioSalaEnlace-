
package modelo;

/**
 *
 * @author caill
 */
public class Funcionario {
    
    private int idFuncionario;
    private String nombre;
    private String cargo;
    private String especialidad;
    private String curso;
    private String hora_entrada;
    private String hora_salida;
    private String estado;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, String nombre, String cargo, String especialidad, String curso, String hora_entrada, String hora_salida, String estado) {
        this.idFuncionario = idFuncionario;
        this.nombre = nombre;
        this.cargo = cargo;
        this.especialidad = especialidad;
        this.curso = curso;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.estado = estado;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + idFuncionario + ", nombre=" + nombre + ", cargo=" + cargo + ", especialidad=" + especialidad + ", curso=" + curso + ", hora_entrada=" + hora_entrada + ", hora_salida=" + hora_salida + ", estado=" + estado + '}';
    }
    
    
}
