package Modelo;
import java.io.Serializable;

public class Estudiante implements Serializable {

    private int idEstudiante;
    private String nombre;
    private int edad;
    private String matricula;

    public Estudiante(int idEstudiante, String nombre, int edad, String matricula) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}