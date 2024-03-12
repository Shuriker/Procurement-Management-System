package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.Item;
import com.example.procurementmanagmentsystem.Entities.PlanOrder;
import com.example.procurementmanagmentsystem.Entities.ProcurementPlan;
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

public class PlanOrderController extends SceneController implements Initializable {

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
    private TableColumn<PlanOrder, Integer> col1;

    @FXML
    private TableColumn<PlanOrder, Integer> col2;

    @FXML
    private TableColumn<PlanOrder, Integer> col3;

    @FXML
    private TableColumn<PlanOrder, String> col4;

    @FXML
    private TableColumn<PlanOrder, String> col5;

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
    private TextField tf5;

    @FXML
    private TableView<PlanOrder> tvItem;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }

    @FXML
    void handleMouseAction(MouseEvent event) {
        PlanOrder planOrder = tvItem.getSelectionModel().getSelectedItem();
        tf1.setText("" + planOrder.getOrder_plan_id());
        tf2.setText("" + planOrder.getPlan_id());
        tf3.setText("" + planOrder.getSupplier_id());
        tf4.setText("" + planOrder.getOrder_date());
        tf5.setText("" + planOrder.getDate_end());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showItem();

    }

    //input select item query
    public ObservableList<PlanOrder> getItemList() {
        ObservableList<PlanOrder> itemList = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT planOrder.order_plan_id, planOrder.plan_id, planOrder.supplier_id, planOrder.order_date, planOrder.date_end FROM planOrder ";
        Statement st;
        ResultSet rs;

        try {
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            PlanOrder item;

            while (rs.next()) {
                item = new PlanOrder(rs.getInt("order_plan_id"), rs.getInt("plan_id"), rs.getInt("supplier_id"), rs.getString("order_date"), rs.getString("date_end"));

                itemList.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemList;

    }


    //show select item query result
    public void showItem() {
        ObservableList<PlanOrder> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<PlanOrder, Integer>("order_plan_id"));
        col2.setCellValueFactory(new PropertyValueFactory<PlanOrder, Integer>("plan_id"));
        col3.setCellValueFactory(new PropertyValueFactory<PlanOrder, Integer>("supplier_id"));
        col4.setCellValueFactory(new PropertyValueFactory<PlanOrder, String>("order_date"));
        col5.setCellValueFactory(new PropertyValueFactory<PlanOrder, String>("date_end"));

        tvItem.setItems(list);

    }
}