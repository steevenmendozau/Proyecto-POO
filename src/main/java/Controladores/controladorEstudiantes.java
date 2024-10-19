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
    
    public void eliminarEstudiante(int idEstudiante) {
    File inputFile = new File(filePath);
    File tempFile = new File("estudiantes_temp.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
        
        String currentLine;
        
        while ((currentLine = reader.readLine()) != null) {
            String[] datos = currentLine.split(";");
            int currentIdEstudiante = Integer.parseInt(datos[0]);
            
            // Si el ID no es igual al que queremos eliminar, copiamos la línea al archivo temporal
            if (currentIdEstudiante != idEstudiante) {
                writer.write(currentLine);
                writer.newLine();
            }
        }

        System.out.println("Estudiante eliminado correctamente.");
    } catch (IOException e) {
        System.out.println("Error al eliminar el estudiante: " + e.getMessage());
    }

    // Renombrar el archivo temporal
    if (inputFile.delete()) {
        tempFile.renameTo(inputFile);
    }
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
            System.out.println("Error al leer los estudiantes: " + e.getMessage());
        }

        return estudiantes;
    }
}
