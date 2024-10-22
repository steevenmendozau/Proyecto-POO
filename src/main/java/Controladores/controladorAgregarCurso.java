package Controladores;

import Modelo.Curso;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class controladorAgregarCurso {

    @FXML
    private TextField txtIdCurso;

    @FXML
    private TextField txtNombreCurso;

    @FXML
    private TextField txtDescripcionCurso;

    private final String archivoCursos = "cursos.txt";  

    @FXML
    private void agregarCurso() {
        try {
            int id = Integer.parseInt(txtIdCurso.getText());
            String nombre = txtNombreCurso.getText();
            String descripcion = txtDescripcionCurso.getText();

            Curso curso = new Curso(id, nombre, descripcion);

            guardarCursoEnArchivo(curso);

            limpiarCamposCurso();

            mostrarAlerta("Éxito", "Curso agregado", "El curso ha sido agregado correctamente.");
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Datos inválidos", "Por favor, verifica los datos ingresados.");
        } catch (IOException e) {
            mostrarAlerta("Error", "Error al guardar", "Hubo un problema al guardar el curso.");
        }
    }

    private void guardarCursoEnArchivo(Curso curso) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCursos, true))) {  // 'true' para agregar datos al final
            String linea = curso.getIdCurso() + "," + curso.getNombreCurso() + "," + curso.getDescripcion();
            bw.write(linea);
            bw.newLine();  // Añadir nueva línea después del curso
        }
    }

    private void limpiarCamposCurso() {
        txtIdCurso.clear();
        txtNombreCurso.clear();
        txtDescripcionCurso.clear();
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}