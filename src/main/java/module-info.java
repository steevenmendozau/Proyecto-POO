module com.mycompany.gestionestudiantil {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.gestionestudiantil to javafx.fxml;
    exports com.mycompany.gestionestudiantil;
}
