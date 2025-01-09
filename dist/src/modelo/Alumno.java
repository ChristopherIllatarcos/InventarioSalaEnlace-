
package modelo;

/**
 *
 * @author caill
 */
public class Alumno {
    
   private int idAlumno;
   private String nombre;
   private String curso;
   private String hora_entrega;
   private String hora_devolucion;
   private String estado;
   private String accesorio_nombre;
   private int nro_accesorio;

    public Alumno() {
    }

    public Alumno(int idAlumno, String nombre, String curso, String hora_entrega, String hora_devolucion, String estado, String accesorio_nombre, int nro_accesorio) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.curso = curso;
        this.hora_entrega = hora_entrega;
        this.hora_devolucion = hora_devolucion;
        this.estado = estado;
        this.accesorio_nombre = accesorio_nombre;
        this.nro_accesorio = nro_accesorio;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getHora_entrega() {
        return hora_entrega;
    }

    public void setHora_entrega(String hora_entrega) {
        this.hora_entrega = hora_entrega;
    }

    public String getHora_devolucion() {
        return hora_devolucion;
    }

    public void setHora_devolucion(String hora_devolucion) {
        this.hora_devolucion = hora_devolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAccesorio_nombre() {
        return accesorio_nombre;
    }

    public void setAccesorio_nombre(String accesorio_nombre) {
        this.accesorio_nombre = accesorio_nombre;
    }

    public int getNro_accesorio() {
        return nro_accesorio;
    }

    public void setNro_accesorio(int nro_accesorio) {
        this.nro_accesorio = nro_accesorio;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", curso=" + curso + ", hora_entrega=" + hora_entrega + ", hora_devolucion=" + hora_devolucion + ", estado=" + estado + ", accesorio_nombre=" + accesorio_nombre + ", nro_accesorio=" + nro_accesorio + '}';
    }

   
   
   
}
