package com.mycompany.gestionestudiantil;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource("/Vista/vistaPrincipal.fxml"));
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Sistema de Gestión Estudiantil");
        stage.show();
    }

    public static void mostrarVistaEstudiantes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Vista/vistasEstudiante/vistaEstudiante.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Administrar Estudiantes");
        stage.show();
    }

    public static void mostrarVistaCursos() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Vista/vistasCursos/vistaCurso.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Administrar Cursos");
        stage.show();
    }
    
    public static void mostrarVistaAgregarCurso() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Vista/vistasCursos/agregarCurso.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Agregar Curso");
        stage.show();
    }

    public static void mostrarVistaEliminarCurso() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/Vista/vistasCursos/eliminarCurso.fxml"));  
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Eliminar Curso");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void mostrarVistaProfesores() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Vista/vistasProfesores/vistaProfesor.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Administrar Profesores");
        stage.show();
    }

public static void mostrarVistaAgregarProfesor() throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Vista/vistaProfesores/agregarProfesor.fxml"));
    Parent root = fxmlLoader.load();
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.setTitle("Agregar Profesor");
    stage.show();
}

public static void mostrarVistaEliminarProfesor() throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Vista/vistaProfesores/eliminarProfesor.fxml"));
    Parent root = fxmlLoader.load();
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.setTitle("Eliminar Profesor");
    stage.show();
}

    public static void mostrarVistaAgregarEstudiante() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Vista/vistasEstudiante/agregarEstudiante.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Agregar Estudiante");
        stage.show();
    }

    public static void mostrarVistaEliminarEstudiante() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Vista/vistasEstudiante/eliminarEstudiante.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Eliminar Estudiante");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}