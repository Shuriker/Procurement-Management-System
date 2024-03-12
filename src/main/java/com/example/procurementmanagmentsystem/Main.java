package com.example.procurementmanagmentsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        //downloading start scene
        primaryStage.setTitle("Procurement Management System");
        primaryStage.getIcons().add(new Image("D:\\Education\\Diploma\\Software\\ProcurementManagmentSystem\\src\\main\\resources\\com\\example\\procurementmanagmentsystem\\shopping-cart-icon.png"));
        Parent root = FXMLLoader.load(Main.class.getResource("connect-DB.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}