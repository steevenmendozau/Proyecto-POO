/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Estudiante;
import java.io.*;
import java.util.ArrayList;


public class controladorEstudiantes {
    
    private final String filePath = "estudiantes.txt";
    
    public void agregarEstudiante(int idEstudiante, String nombre,int edad, String matricula)
    {
        Estudiante estudiante = new Estudiante(idEstudiante,nombre,edad,matricula);
        
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw)) 
        {
            bw.write(idEstudiante + ";" + nombre + ";" + edad + ";" + matricula);
            bw.newLine();             
            System.out.println("Estudiante guardado correctamente" + estudiante);
        } catch (IOException e)
        {
            System.out.println("Error al guardar el estudiante" + e.getMessage());
        }
    }
    
    public void eliminarEstudiante(int idEstudiante, String nombre,int edad, String matricula)
    {
        
    }
    
    public ArrayList<Estudiante> consultarEstudiantes()
    {
        ArrayList<Estudiante> estudiantes = new ArrayList<>(); 
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                int idEstudiante = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                int edad = Integer.parseInt(datos[2]);
                String matricula = datos[3];
                estudiantes.add(new Estudiante(idEstudiante, nombre, edad, matricula));
            }
            System.out.println("Lectura completada.");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de Estudiantes.");
        } catch (IOException e) {
            System.out.println("Error al leer las sucursales: " + e.getMessage());
        }

        return estudiantes;
    }
}
