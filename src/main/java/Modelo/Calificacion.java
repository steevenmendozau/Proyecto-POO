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
    private int valor;

    public Calificacion(int idCalificacion, int valor) {
        this.idCalificacion = idCalificacion;
        this.valor = valor;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public int getValor() {
        return valor;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
