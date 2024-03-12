package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class SceneController {

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    @FXML
    private MenuBar myMenyBar;





    public void switchToSceneAccountingMenu1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("accounting-menu.fxml"));
        Stage stage = (Stage) myMenyBar.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /* old methods
    //switching to database connection stage
    public void switchToSceneDBConnect(ActionEvent event) throws IOException {
         root = FXMLLoader.load(HelloApplication.class.getResource("connect-DB.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

*/
    //switching to main menu stage
    public void switchToSceneMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("main-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void switchToSceneCRUDItem(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("crud-item-table.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void switchToSceneProcurementPlanControl(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("procurement-plan-control.fxml"));
        stage = (Stage)myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneDemandAnalyze(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("demand_analyze.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneItemCategoryTable(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("item-category-table.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void switchToSceneItemProcurement(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("item-procurement.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneProcurementPlan(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("procurement-plan.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScenePlanOrder(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("plan order.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScenePlanOrderDetail(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("plan order detail.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScenePurchaseOrder(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("purchase order.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScenePurchaseOrderDetail(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("purchase order detail.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneCustomerOrder(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("customer order.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneCustomerOrderDetail(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("customer order detail.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneCustomerOrderDetailReserv(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("customer order detail reserv.fxml"));
        stage = (Stage) myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneItemTransactions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("item transactions.fxml"));
        stage = (Stage)myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneReturnItem(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("return item.fxml"));
        stage = (Stage)myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneSalesBetweenSupply(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("sales between supply.fxml"));
        stage = (Stage)myMenyBar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}