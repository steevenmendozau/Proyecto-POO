module com.mycompany.gestionestudiantil {
    requires javafx.controls;
    requires javafx.fxml;

    // Exporta el paquete Controladores al módulo javafx.fxml
    opens Controladores to javafx.fxml;
    opens Modelo to javafx.base;

    opens Vista.vistaProfesores to javafx.fxml;
    opens Vista.vistasEstudiante to javafx.fxml;
    opens Vista.vistasCursos to javafx.fxml;

    exports com.mycompany.gestionestudiantil;
}