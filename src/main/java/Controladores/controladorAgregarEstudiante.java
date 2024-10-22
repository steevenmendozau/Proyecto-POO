package Controladores;

import Modelo.Estudiante;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.List;
import java.util.ArrayList;

public class controladorAgregarEstudiante {

    @FXML
    private TextField txtIdEstudiante;

    @FXML
    private TextField txtNombreEstudiante;

    @FXML
    private TextField txtEdadEstudiante;

    @FXML
    private TextField txtMatriculaEstudiante;

    private final String archivoEstudiantes = "estudiantes.txt";  

    @FXML
private void agregarEstudiante() {
    try {
        int id = Integer.parseInt(txtIdEstudiante.getText());
        String nombre = txtNombreEstudiante.getText();
        int edad = Integer.parseInt(txtEdadEstudiante.getText());
        String matricula = txtMatriculaEstudiante.getText();

        Estudiante estudiante = new Estudiante(id, nombre, edad, matricula);
        
        controladorOperaArchivEst archivoEstudiantes = new controladorOperaArchivEst();
        List<Estudiante> estudiantes = archivoEstudiantes.leerArchivoEstudiantes("estudiantes.txt");
        
        estudiantes.add(estudiante);
        
        
        boolean guardado = archivoEstudiantes.grabarEstudiantes(estudiantes, "estudiantes.txt");

        if (guardado) {
            limpiarCamposEstudiante();
            mostrarAlerta("Éxito", "Estudiante agregado", "El estudiante ha sido agregado correctamente.");
        } else {
            mostrarAlerta("Error", "Error al guardar", "Hubo un problema al guardar el estudiante.");
        }
    } catch (NumberFormatException e) {
        mostrarAlerta("Error", "Datos inválidos", "Por favor, verifica los datos ingresados.");
    }
}

    private void limpiarCamposEstudiante() {
        txtIdEstudiante.clear();
        txtNombreEstudiante.clear();
        txtEdadEstudiante.clear();
        txtMatriculaEstudiante.clear();
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}