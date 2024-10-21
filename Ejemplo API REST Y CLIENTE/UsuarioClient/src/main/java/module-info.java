module com.example.cliente {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    // Abre el paquete 'model' para que Jackson y JavaFX puedan acceder
    opens com.example.cliente.model to com.fasterxml.jackson.databind, javafx.base;

    // Abre otros paquetes para JavaFX
    opens com.example.cliente to javafx.fxml;
    opens com.example.cliente.controller to javafx.fxml;

    // Exporta los paquetes para su uso
    exports com.example.cliente;
    exports com.example.cliente.controller;
}
