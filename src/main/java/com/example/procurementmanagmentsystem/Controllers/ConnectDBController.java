package com.example.procurementmanagmentsystem.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDBController extends SceneController {

    @FXML
    private Button btnConnect;

    @FXML
    private Button btnNext;

    @FXML
    private PasswordField fldPassword;

    @FXML
    private TextField fldUsername;

    @FXML
    private Label lbWelcome;

    @FXML
    private Label lbStatus;

    public static Connection connectDB;

    public void ConnectButton(ActionEvent event) {
    //checkout for input available
        if (!fldUsername.getText().isBlank() && !fldPassword.getText().isBlank()) {
            connectDB = getConnection(fldUsername.getText(), fldPassword.getText());
        } else {
            lbStatus.setText("Please enter your username and password");
        }

    }

    //connection to DB
    public Connection databaseLink;

    public Connection getConnection(String databaseUser, String databasePassword) {
        String databaseName = "procurementmanage";
        String url = "jdbc:mysql://localhost/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            lbStatus.setText("You have been successfully connected");
        } catch (Exception e) {
            e.printStackTrace();
            lbStatus.setText("Check your username and password");
        }
        return databaseLink;
    }
}
