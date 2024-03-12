package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.PlanOrder;
import com.example.procurementmanagmentsystem.Entities.PlanOrderDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class PlanOrderDetailController extends SceneController implements Initializable {

    @FXML
    private MenuItem DemandAnalyze;

    @FXML
    private MenuItem ProcurementPlanControl;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<PlanOrderDetail, Integer> col1;

    @FXML
    private TableColumn<PlanOrderDetail, Integer> col2;

    @FXML
    private TableColumn<PlanOrderDetail, Integer> col3;

    @FXML
    private TableColumn<PlanOrderDetail, Integer> col4;

    @FXML
    private MenuItem menuItemItem;

    @FXML
    private MenuBar myMenyBar;

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane root1;

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @FXML
    private TextField tf4;

    @FXML
    private TableView<PlanOrderDetail> tvItem;


    @FXML
    void handleButtonAction(ActionEvent event) {

    }

    @FXML
    void handleMouseAction(MouseEvent event) {
        PlanOrderDetail PlanOrderDetail = tvItem.getSelectionModel().getSelectedItem();
        tf1.setText("" + PlanOrderDetail.getItem_id());
        tf2.setText("" + PlanOrderDetail.getOrder_plan_id());
        tf3.setText("" + PlanOrderDetail.getPlan_id());
        tf4.setText("" + PlanOrderDetail.getQuantity_plan());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showItem();

    }

    //input select item query
    public ObservableList<PlanOrderDetail> getItemList() {
        ObservableList<PlanOrderDetail> itemList = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT planOrderDetail.item_id, planOrderDetail.order_plan_id, planOrderDetail.plan_id, planOrderDetail.quantity_plan FROM planOrderDetail ";
        Statement st;
        ResultSet rs;

        try {
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            PlanOrderDetail item;

            while (rs.next()) {
                item = new PlanOrderDetail(rs.getInt("item_id"), rs.getInt("order_plan_id"), rs.getInt("plan_id"), rs.getInt("quantity_plan"));

                itemList.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemList;

    }


    //show select item query result
    public void showItem() {
        ObservableList<PlanOrderDetail> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<PlanOrderDetail, Integer>("item_id"));
        col2.setCellValueFactory(new PropertyValueFactory<PlanOrderDetail, Integer>("order_plan_id"));
        col3.setCellValueFactory(new PropertyValueFactory<PlanOrderDetail, Integer>("plan_id"));
        col4.setCellValueFactory(new PropertyValueFactory<PlanOrderDetail, Integer>("quantity_plan"));


        tvItem.setItems(list);

    }

}