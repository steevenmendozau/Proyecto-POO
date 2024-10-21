/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;





import Modelo.Curso;
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

public class controladorCursos {

    @FXML
    private TableView<Curso> tablaCursos;

    @FXML
    private TableColumn<Curso, Integer> colIdCurso;
    
    @FXML
    private TableColumn<Curso, String> colNombreCurso;

    @FXML
    private TableColumn<Curso, String> colDescripcionCurso;

    @FXML
    private TextField txtIdCurso;
    
    @FXML
    private TextField txtNombreCurso;

    @FXML
    private TextField txtDescripcionCurso;

    @FXML
    private Button btnAgregarCurso;
    
    @FXML
    private Button btnEliminarCurso;

    private ObservableList<Curso> cursos;

    public void initialize() {
        cursos = FXCollections.observableArrayList();
        tablaCursos.setItems(cursos);

        colIdCurso.setCellValueFactory(new PropertyValueFactory<>("idCurso"));
        colNombreCurso.setCellValueFactory(new PropertyValueFactory<>("nombreCurso"));
        colDescripcionCurso.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    }

    @FXML
    public void agregarCurso() {
        try {
            int id = Integer.parseInt(txtIdCurso.getText());
            String nombreCurso = txtNombreCurso.getText();
            String descripcion = txtDescripcionCurso.getText();

            Curso curso = new Curso(id, nombreCurso, descripcion);
            cursos.add(curso);

            limpiarCamposCurso();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Datos inválidos", "Por favor, verifica los datos ingresados.");
        }
    }

    @FXML
    public void eliminarCurso() {
        Curso cursoSeleccionado = tablaCursos.getSelectionModel().getSelectedItem();
        if (cursoSeleccionado != null) {
            cursos.remove(cursoSeleccionado);
        } else {
            mostrarAlerta("Advertencia", "Selección requerida", "Debes seleccionar un curso para eliminar.");
        }
    }

    private void limpiarCamposCurso() {
        txtIdCurso.clear();
        txtNombreCurso.clear();
        txtDescripcionCurso.clear();
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}

