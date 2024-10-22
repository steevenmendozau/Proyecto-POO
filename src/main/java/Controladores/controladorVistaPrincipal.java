package Controladores;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class controladorVistaPrincipal {

    @FXML
    private Button btnAdministrarEstudiantes;

    @FXML
    private Button btnAdministrarCursos;


    @FXML
    public void initialize() {
  
    }

    @FXML
    private void mostrarVistaEstudiantes() {
        try {
            com.mycompany.gestionestudiantil.App.mostrarVistaEstudiantes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarVistaCursos() {
        try {
            com.mycompany.gestionestudiantil.App.mostrarVistaCursos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
public void mostrarVistaProfesores() {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/vistaProfesores/vistaProfesores.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Administrar Profesores");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}