module com.mycompany.gestionestudiantil {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.gestionestudiantil to javafx.fxml;
    exports com.mycompany.gestionestudiantil;
}
