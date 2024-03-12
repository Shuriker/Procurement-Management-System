module com.example.procurementmanagmentsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires mysql.connector.j;

    opens com.example.procurementmanagmentsystem to javafx.fxml;
    exports com.example.procurementmanagmentsystem;
    exports com.example.procurementmanagmentsystem.Controllers;
    opens com.example.procurementmanagmentsystem.Controllers to javafx.fxml;
    exports com.example.procurementmanagmentsystem.Entities;
    opens com.example.procurementmanagmentsystem.Entities to javafx.fxml;
}