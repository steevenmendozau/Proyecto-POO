package Controladores;

import Modelo.Profesor;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class controladorEliminarProfesor {

    @FXML
    private TextField txtIdProfesorEliminar;

    @FXML
    public void eliminarProfesor() {
        String archivo = "profesores.txt";
        List<Profesor> profesores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                int idProfesor = Integer.parseInt(datos[0]);
                String nombreProfesor = datos[1];
                String especialidad = datos[2];
                profesores.add(new Profesor(idProfesor, nombreProfesor, especialidad));
            }
        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo leer el archivo de profesores.");
            return;
        }

        int idAEliminar;
        try {
            idAEliminar = Integer.parseInt(txtIdProfesorEliminar.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Por favor, ingresa un ID válido.");
            return;
        }

        boolean profesorEliminado = false;
        List<Profesor> profesoresActualizados = new ArrayList<>();
        for (Profesor profesor : profesores) {
            if (profesor.getIdProfesor() != idAEliminar) {
                profesoresActualizados.add(profesor);
            } else {
                profesorEliminado = true;
            }
        }

        if (!profesorEliminado) {
            mostrarAlerta("Error", "No se encontró ningún profesor con el ID proporcionado.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Profesor profesor : profesoresActualizados) {
                String linea = profesor.getIdProfesor() + "," + profesor.getNombreProfesor() + "," + profesor.getEspecialidad();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo escribir el archivo de profesores.");
            return;
        }

        mostrarAlerta("Éxito", "El profesor ha sido eliminado exitosamente.");
        txtIdProfesorEliminar.clear();
    }

    private void mostrarAlerta(String titulo, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, contenido, ButtonType.OK);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }
}