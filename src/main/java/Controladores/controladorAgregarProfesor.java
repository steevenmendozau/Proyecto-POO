package Controladores;

import Modelo.Profesor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.FileWriter;
import java.io.IOException;

public class controladorAgregarProfesor {

    @FXML
    private TextField txtIdProfesor;

    @FXML
    private TextField txtNombreProfesor;

    @FXML
    private TextField txtEspecialidadProfesor;

    private ObservableList<Profesor> profesores = FXCollections.observableArrayList(); 

    public void setProfesores(ObservableList<Profesor> profesores) {
        this.profesores = profesores;
    }

    @FXML
    public void agregarProfesor() {
        try {
            if (txtIdProfesor.getText().isEmpty() || txtNombreProfesor.getText().isEmpty() || txtEspecialidadProfesor.getText().isEmpty()) {
                throw new IllegalArgumentException("Todos los campos son obligatorios");
            }

            int idProfesor = Integer.parseInt(txtIdProfesor.getText());
            String nombreProfesor = txtNombreProfesor.getText();
            String especialidad = txtEspecialidadProfesor.getText();

            Profesor nuevoProfesor = new Profesor(idProfesor, nombreProfesor, especialidad);

            profesores.add(nuevoProfesor);

            guardarProfesorEnArchivo(nuevoProfesor);

            txtIdProfesor.clear();
            txtNombreProfesor.clear();
            txtEspecialidadProfesor.clear();
        } catch (NumberFormatException e) {
            System.out.println("El ID debe ser un número válido.");
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    private void guardarProfesorEnArchivo(Profesor profesor) {
        String archivo = "profesores.txt";  // Nombre del archivo
        try (FileWriter writer = new FileWriter(archivo, true)) {
            writer.append(profesor.getIdProfesor() + "," + profesor.getNombreProfesor() + "," + profesor.getEspecialidad() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}