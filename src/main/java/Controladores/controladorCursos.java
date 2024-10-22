package Controladores;

import Modelo.Curso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    private ObservableList<Curso> listaCursos = FXCollections.observableArrayList();

    public void initialize() {
        colIdCurso.setCellValueFactory(new PropertyValueFactory<>("idCurso"));
        colNombreCurso.setCellValueFactory(new PropertyValueFactory<>("nombreCurso"));
        colDescripcionCurso.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        cargarCursosDesdeArchivo("cursos.txt");

        tablaCursos.setItems(listaCursos);
    }

    public ObservableList<Curso> getCursos() {
        return listaCursos;
    }

    private void cargarCursosDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) { 
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String descripcion = datos[2];
                    Curso curso = new Curso(id, nombre, descripcion);
                    listaCursos.add(curso);
                }
            }
        } catch (IOException e) {
            mostrarAlerta("Error", "Error al cargar el archivo de cursos", "Hubo un problema al leer el archivo: " + archivo);
        }
    }

    @FXML
    public void eliminarCurso() {
        try {
            int id = Integer.parseInt(txtIdCurso.getText());
            Curso cursoAEliminar = null;

            for (Curso curso : listaCursos) {
                if (curso.getIdCurso() == id) {
                    cursoAEliminar = curso;
                    break;
                }
            }

            if (cursoAEliminar != null) {
                listaCursos.remove(cursoAEliminar);
                mostrarAlerta("Éxito", "Curso eliminado", "El curso ha sido eliminado exitosamente.");
            } else {
                mostrarAlerta("Advertencia", "Curso no encontrado", "No se encontró un curso con el ID proporcionado.");
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID inválido", "Por favor, ingresa un ID válido.");
        }
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    @FXML
    public void mostrarVistaAgregarCurso() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/vistasCursos/agregarCurso.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Agregar Curso");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void mostrarVistaEliminarCurso() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/vistasCursos/eliminarCurso.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Eliminar Curso");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}