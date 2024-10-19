/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author steevenmendozaromero
 */
public class Calificacion {
    private int idCalificacion;
    private Estudiante idEstudiante;
    private Curso nombreCurso;
    private int valor;

    public Calificacion(int idCalificacion, Estudiante idEstudiante, Curso curso, int valor) {
        this.idCalificacion = idCalificacion;
        this.idEstudiante = idEstudiante;
        this.nombreCurso = curso;
        this.valor = valor;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public Curso getCurso() {
        return nombreCurso;
    }

    public int getValor() {
        return valor;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setCurso(Curso curso) {
        this.nombreCurso = curso;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    }
