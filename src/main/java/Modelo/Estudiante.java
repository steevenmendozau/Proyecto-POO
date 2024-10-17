/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author steevenmendozaromero
 */
public class Estudiante {
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

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
}
