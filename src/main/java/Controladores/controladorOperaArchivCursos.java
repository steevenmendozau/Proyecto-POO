package Controladores;

import Modelo.Curso;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class controladorOperaArchivCursos {

    private final String archivoCursos = "cursos.txt";

    public List<Curso> leerArchivoCursos() {
        List<Curso> cursos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCursos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); 
                if (datos.length == 3) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String descripcion = datos[2];
                    Curso curso = new Curso(id, nombre, descripcion);
                    cursos.add(curso);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + archivoCursos);
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }
        return cursos;
    }

    public boolean grabarCursos(List<Curso> cursos) {
        boolean resultado = false;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCursos))) {
            for (Curso curso : cursos) {
                String linea = curso.getIdCurso() + "," + curso.getNombreCurso() + "," + curso.getDescripcion();
                bw.write(linea);
                bw.newLine();  
            }
            resultado = true;
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
        return resultado;
    }
}