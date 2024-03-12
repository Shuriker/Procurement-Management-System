package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.PlanOrderDetail;
import com.example.procurementmanagmentsystem.Entities.PurchaseOrder;
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

public class PurchaseOrderController extends SceneController implements Initializable {

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
    private TableColumn<PurchaseOrder, Integer> col1;

    @FXML
    private TableColumn<PurchaseOrder, Integer> col2;

    @FXML
    private TableColumn<PurchaseOrder, String> col3;

    @FXML
    private TableColumn<PurchaseOrder, String> col4;

    @FXML
    private TableColumn<PurchaseOrder, Integer> col5;

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
    private TableView<PurchaseOrder> tvItem;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }

    @FXML
    void handleMouseAction(MouseEvent event) {
        PurchaseOrder PurchaseOrder = tvItem.getSelectionModel().getSelectedItem();
        tf1.setText("" + PurchaseOrder.getPo_id());
        tf2.setText("" + PurchaseOrder.getPlan_id());
        tf3.setText("" + PurchaseOrder.getDate_register());
        tf4.setText("" + PurchaseOrder.getDescription());
        tf5.setText("" + PurchaseOrder.getSupplier_id());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showItem();

    }

    //input select item query
    public ObservableList<PurchaseOrder> getItemList() {
        ObservableList<PurchaseOrder> itemList = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT * FROM PurchaseOrder ";
        Statement st;
        ResultSet rs;

        try {
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            PurchaseOrder item;

            while (rs.next()) {
                item = new PurchaseOrder(rs.getInt("po_id"), rs.getInt("plan_id"), rs.getString("date_register"), rs.getString("description"), rs.getInt("supplier_id"));

                itemList.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemList;

    }


    //show select item query result
    public void showItem() {
        ObservableList<PurchaseOrder> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<PurchaseOrder, Integer>("po_id"));
        col2.setCellValueFactory(new PropertyValueFactory<PurchaseOrder, Integer>("plan_id"));
        col3.setCellValueFactory(new PropertyValueFactory<PurchaseOrder, String>("date_register"));
        col4.setCellValueFactory(new PropertyValueFactory<PurchaseOrder, String>("description"));
        col5.setCellValueFactory(new PropertyValueFactory<PurchaseOrder, Integer>("supplier_id"));



        tvItem.setItems(list);

    }

}
