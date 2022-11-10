module com.example.pluie_de_valentin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pluie_de_valentin to javafx.fxml;
    exports com.example.pluie_de_valentin;
}