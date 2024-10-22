package Controladores;

import Modelo.Estudiante;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class controladorEliminarEstudiante {

    @FXML
    private TextField txtIdEstudiante;

    private final String archivoEstudiantes = "estudiantes.txt";

    @FXML
    private void eliminarEstudiante() {
        try {
            int id = Integer.parseInt(txtIdEstudiante.getText());

            List<Estudiante> estudiantes = leerEstudiantesDelArchivo();

            boolean estudianteEliminado = false;
            List<Estudiante> estudiantesActualizados = new ArrayList<>();
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getIdEstudiante() == id) {
                    estudianteEliminado = true;  
                } else {
                    estudiantesActualizados.add(estudiante);  
                }
            }

            if (estudianteEliminado) {
                escribirEstudiantesEnArchivo(estudiantesActualizados);
                mostrarAlerta("Éxito", "Estudiante eliminado", "El estudiante ha sido eliminado exitosamente.");
            } else {
                mostrarAlerta("Advertencia", "No encontrado", "No se encontró un estudiante con el ID proporcionado.");
            }

            limpiarCampoEstudiante();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID inválido", "Por favor, verifica el ID ingresado.");
        } catch (IOException e) {
            mostrarAlerta("Error", "Error de archivo", "Hubo un problema al procesar el archivo.");
        }
    }

    private List<Estudiante> leerEstudiantesDelArchivo() throws IOException {
        List<Estudiante> estudiantes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEstudiantes))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {  
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    int edad = Integer.parseInt(partes[2]);
                    String matricula = partes[3];
                    estudiantes.add(new Estudiante(id, nombre, edad, matricula));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + archivoEstudiantes);
        }
        return estudiantes;
    }

    private void escribirEstudiantesEnArchivo(List<Estudiante> estudiantes) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoEstudiantes))) {
            for (Estudiante estudiante : estudiantes) {
                String linea = estudiante.getIdEstudiante() + "," + estudiante.getNombre() + "," +
                        estudiante.getEdad() + "," + estudiante.getMatricula();
                bw.write(linea);
                bw.newLine();  
            }
        }
    }

    private void limpiarCampoEstudiante() {
        txtIdEstudiante.clear();
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}