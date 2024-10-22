package Controladores;

import Modelo.Profesor;
import com.mycompany.gestionestudiantil.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class controladorProfesores {

    @FXML
    private TableView<Profesor> tablaProfesores;

    @FXML
    private TableColumn<Profesor, Integer> colIdProfesor;

    @FXML
    private TableColumn<Profesor, String> colNombreProfesor;

    @FXML
    private TableColumn<Profesor, String> colEspecialidad;

    private ObservableList<Profesor> profesores = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colIdProfesor.setCellValueFactory(new PropertyValueFactory<>("idProfesor"));
        colNombreProfesor.setCellValueFactory(new PropertyValueFactory<>("nombreProfesor"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));

        cargarDatosDesdeArchivo();

        tablaProfesores.setItems(profesores);
    }

    private void cargarDatosDesdeArchivo() {
        String archivo = "profesores.txt";  
        String linea;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                int idProfesor = Integer.parseInt(datos[0]);
                String nombreProfesor = datos[1];
                String especialidad = datos[2];

                Profesor profesor = new Profesor(idProfesor, nombreProfesor, especialidad);
                profesores.add(profesor);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos del archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de los datos: " + e.getMessage());
        }
    }

    @FXML
public void mostrarVistaAgregarProfesor() {
    try {
        App.mostrarVistaAgregarProfesor();  
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@FXML
public void mostrarVistaEliminarProfesor() {
    try {
        App.mostrarVistaEliminarProfesor();  
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}