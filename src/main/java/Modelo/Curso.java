/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author steevenmendozaromero
 */
public class Curso {
    private int idCurso;
    private String nombreCurso;
    private String descripcion;

    public Curso(int idCurso, String nombreCurso, String descripcion) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.descripcion = descripcion;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
