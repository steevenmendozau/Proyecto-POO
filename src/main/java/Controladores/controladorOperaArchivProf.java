package Controladores;

import Modelo.Profesor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class controladorOperaArchivProf {

    private FileOutputStream fout = null;
    private ObjectInputStream in = null;

    public List<Profesor> leerArchivoProfesores(String archivo) {
        List<Profesor> profesores = new ArrayList<>();
        try {
            in = new ObjectInputStream(new FileInputStream(archivo));

            while (true) {
                Profesor profesor = (Profesor) in.readObject();
                profesores.add(profesor);
            }
        } catch (EOFException ex) {
            System.out.println("Lectura completada, fin del archivo.");
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada: " + ex.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                System.out.println("Error al cerrar el flujo de entrada: " + ex.getMessage());
            }
        }
        return profesores;
    }

    public boolean grabarProfesores(List<Profesor> profesores, String archivo) {
        boolean resultado = false;
        try {
            fout = new FileOutputStream(archivo);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for (Profesor profesor : profesores) {
                out.writeObject(profesor);
            }
            out.flush();
            resultado = true;
        } catch (FileNotFoundException ex) {
            System.out.println("Error: Archivo no encontrado - " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida: " + ex.getMessage());
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException ex) {
                System.out.println("Error al cerrar el flujo de salida: " + ex.getMessage());
            }
        }
        return resultado;
    }
}