/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Curso;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author steevenmendozaromero
 */
public class controladorCursos {
        
    private final String filePath = "cursos.txt";
    
    public void agregarCurso(int idCurso, String nombreCurso, String descripcion)
    {
        Curso curso = new Curso(idCurso,nombreCurso ,descripcion);
        
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw)) 
        {
            bw.write(idCurso + ";" + nombreCurso + ";" + descripcion);
            bw.newLine();             
            System.out.println("Curso guardado correctamente" + curso);
        } catch (IOException e)
        {
            System.out.println("Error al guardar el estudiante" + e.getMessage());
        }
    }
    
    public void eliminarCurso(int idCurso) {
    File inputFile = new File(filePath);
    File tempFile = new File("cursos_temp.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
        
        String currentLine;
        
        while ((currentLine = reader.readLine()) != null) {
            String[] datos = currentLine.split(";");
            int currentIdCurso = Integer.parseInt(datos[0]);
            
            // Si el ID no es igual al que queremos eliminar, copiamos la línea al archivo temporal
            if (currentIdCurso != idCurso) {
                writer.write(currentLine);
                writer.newLine();
            }
        }

        System.out.println("Curso eliminado correctamente.");
    } catch (IOException e) {
        System.out.println("Error al eliminar el curso: " + e.getMessage());
    }

    // Renombrar el archivo temporal
    if (inputFile.delete()) {
        tempFile.renameTo(inputFile);
    }
}
    
    public ArrayList<Curso> consultarEstudiantes()
    {
        ArrayList<Curso> cursos = new ArrayList<>(); 
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                int idCurso = Integer.parseInt(datos[0]);
                String nombreCurso = datos[1];
                String descripcion = datos[2];
                cursos.add(new Curso(idCurso, nombreCurso, descripcion));
            }
            System.out.println("Lectura completada.");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de Cursos.");
        } catch (IOException e) {
            System.out.println("Error al leer los Cursos: " + e.getMessage());
        }

        return cursos;
    }
}
