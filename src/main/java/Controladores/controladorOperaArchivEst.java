package Controladores;

import Modelo.Estudiante;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class controladorOperaArchivEst {

    public List<Estudiante> leerArchivoEstudiantes(String archivo) {
        List<Estudiante> estudiantes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");  
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                int edad = Integer.parseInt(datos[2]);
                String matricula = datos[3];
                Estudiante estudiante = new Estudiante(id, nombre, edad, matricula);
                estudiantes.add(estudiante);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return estudiantes;
    }

    public boolean grabarEstudiantes(List<Estudiante> estudiantes, String archivo) {
        boolean resultado = false;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Estudiante estudiante : estudiantes) {
                String linea = estudiante.getIdEstudiante() + "," +
                               estudiante.getNombre() + "," +
                               estudiante.getEdad() + "," +
                               estudiante.getMatricula();
                bw.write(linea);
                bw.newLine();  
            }
            resultado = true;
        } catch (IOException ex) {
            System.out.println("Error al escribir el archivo: " + ex.getMessage());
        }
        return resultado;
    }
}