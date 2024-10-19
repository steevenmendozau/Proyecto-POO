package Controladores;

import Modelo.Calificacion;
import Modelo.Curso;
import Modelo.Estudiante;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class controladorCalificaciones {
         
    private final String filePath = "calificaciones.txt"; 
    
    public void agregarCalificacion(int idCalificacion, Estudiante estudiante, Curso curso, int valor) {
        Calificacion calificacion = new Calificacion(idCalificacion, estudiante, curso, valor);
    
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw)) 
        {
            bw.write(idCalificacion + ";" + estudiante.getIdEstudiante() + ";" + curso.getIdCurso() + ";" + valor);
            bw.newLine();             
            System.out.println("Calificación guardada correctamente para el curso: " + curso.getNombreCurso());
        } catch (IOException e) {
            System.out.println("Error al guardar la calificación: " + e.getMessage());
        }
    }
    
    public void eliminarCalificacion(int idCalificacion) {
        File inputFile = new File(filePath);
        File tempFile = new File("calificaciones_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            
            String currentLine;
            
            while ((currentLine = reader.readLine()) != null) {
                String[] datos = currentLine.split(";");
                int currentIdCalificacion = Integer.parseInt(datos[0]);
                
                if (currentIdCalificacion != idCalificacion) {
                    writer.write(currentLine);
                    writer.newLine();
                }
            }

            System.out.println("Calificación eliminada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al eliminar la calificación: " + e.getMessage());
        }

        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
        }
    }
    
    public ArrayList<Calificacion> consultarCalificaciones(ArrayList<Estudiante> estudiantes, ArrayList<Curso> cursos) {
        ArrayList<Calificacion> calificaciones = new ArrayList<>(); 
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                int idCalificacion = Integer.parseInt(datos[0]);
                int idEstudiante = Integer.parseInt(datos[1]);
                int idCurso = Integer.parseInt(datos[2]);
                int valor = Integer.parseInt(datos[3]);

                Estudiante estudiante = estudiantes.stream().filter(e -> e.getIdEstudiante() == idEstudiante).findFirst().orElse(null);
                Curso curso = cursos.stream().filter(c -> c.getIdCurso() == idCurso).findFirst().orElse(null);

                if (estudiante != null && curso != null) {
                    calificaciones.add(new Calificacion(idCalificacion, estudiante, curso, valor));
                }
            }
            System.out.println("Lectura de calificaciones completada.");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de Calificaciones.");
        } catch (IOException e) {
            System.out.println("Error al leer las calificaciones: " + e.getMessage());
        }

        return calificaciones;
    }
    
}  