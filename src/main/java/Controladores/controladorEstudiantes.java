/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;




import Modelo.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class controladorEstudiantes {

    @FXML
    private TableView<Estudiante> tablaEstudiantes;

    @FXML
    private TableColumn<Estudiante, Integer> colIdEstudiante;
    
    @FXML
    private TableColumn<Estudiante, String> colNombreEstudiante;

    @FXML
    private TableColumn<Estudiante, Integer> colEdadEstudiante;

    @FXML
    private TableColumn<Estudiante, String> colMatriculaEstudiante;

    @FXML
    private TextField txtIdEstudiante;
    
    @FXML
    private TextField txtNombreEstudiante;

    @FXML
    private TextField txtEdadEstudiante;

    @FXML
    private TextField txtMatriculaEstudiante;

    @FXML
    private Button btnAgregarEstudiante;
    
    @FXML
    private Button btnEliminarEstudiante;

    private ObservableList<Estudiante> estudiantes;

    public void initialize() {
        estudiantes = FXCollections.observableArrayList();
        tablaEstudiantes.setItems(estudiantes);

        colIdEstudiante.setCellValueFactory(new PropertyValueFactory<>("idEstudiante"));
        colNombreEstudiante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEdadEstudiante.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colMatriculaEstudiante.setCellValueFactory(new PropertyValueFactory<>("matricula"));
    }

    @FXML
    public void agregarEstudiante() {
        try {
            int id = Integer.parseInt(txtIdEstudiante.getText());
            String nombre = txtNombreEstudiante.getText();
            int edad = Integer.parseInt(txtEdadEstudiante.getText());
            String matricula = txtMatriculaEstudiante.getText();

            Estudiante estudiante = new Estudiante(id, nombre, edad, matricula);
            estudiantes.add(estudiante);

            limpiarCamposEstudiante();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Datos inválidos", "Por favor, verifica los datos ingresados.");
        }
    }

    @FXML
    public void eliminarEstudiante() {
        Estudiante estudianteSeleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();
        if (estudianteSeleccionado != null) {
            estudiantes.remove(estudianteSeleccionado);
        } else {
            mostrarAlerta("Advertencia", "Selección requerida", "Debes seleccionar un estudiante para eliminar.");
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



