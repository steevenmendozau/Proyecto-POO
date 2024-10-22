package Controladores;

import Modelo.Curso;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class controladorEliminarCurso {

    @FXML
    private TextField txtIdCurso;

    private final String archivoCursos = "cursos.txt"; 

    @FXML
    private void eliminarCurso() {
        try {
            int id = Integer.parseInt(txtIdCurso.getText());

            List<Curso> cursos = leerCursosDelArchivo();

            boolean cursoEliminado = false;
            List<Curso> cursosActualizados = new ArrayList<>();
            for (Curso curso : cursos) {
                if (curso.getIdCurso() == id) {
                    cursoEliminado = true;  
                } else {
                    cursosActualizados.add(curso); 
                }
            }

            if (cursoEliminado) {
                escribirCursosEnArchivo(cursosActualizados);
                mostrarAlerta("Éxito", "Curso eliminado", "El curso ha sido eliminado exitosamente.");
            } else {
                mostrarAlerta("Advertencia", "No encontrado", "No se encontró un curso con el ID proporcionado.");
            }

            limpiarCampoCurso();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID inválido", "Por favor, verifica el ID ingresado.");
        } catch (IOException e) {
            mostrarAlerta("Error", "Error de archivo", "Hubo un problema al procesar el archivo.");
        }
    }

    private List<Curso> leerCursosDelArchivo() throws IOException {
        List<Curso> cursos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCursos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {  // Aseguramos que haya exactamente 3 campos por curso
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String descripcion = partes[2];
                    cursos.add(new Curso(id, nombre, descripcion));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + archivoCursos);
        }
        return cursos;
    }

    private void escribirCursosEnArchivo(List<Curso> cursos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCursos))) {
            for (Curso curso : cursos) {
                String linea = curso.getIdCurso() + "," + curso.getNombreCurso() + "," + curso.getDescripcion();
                bw.write(linea);
                bw.newLine();  // Para separar cada registro
            }
        }
    }

    private void limpiarCampoCurso() {
        txtIdCurso.clear();
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}