package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.PurchaseOrderDetail;
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

public class PurchaseOrderDetailController extends SceneController implements Initializable {

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
    private TableColumn<PurchaseOrderDetail, Integer> col1;

    @FXML
    private TableColumn<PurchaseOrderDetail, Integer> col2;

    @FXML
    private TableColumn<PurchaseOrderDetail, Integer> col3;

    @FXML
    private TableColumn<PurchaseOrderDetail, Integer> col4;

    @FXML
    private TableColumn<PurchaseOrderDetail, Integer> col5;

    @FXML
    private TableColumn<PurchaseOrderDetail, Integer> col6;

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
    private TextField tf6;

    @FXML
    private TableView<PurchaseOrderDetail> tvItem;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }




    @FXML
    void handleMouseAction(MouseEvent event) {
        PurchaseOrderDetail purchaseOrderDetail = tvItem.getSelectionModel().getSelectedItem();
        tf1.setText("" + purchaseOrderDetail.getPo_item_id());
        tf2.setText("" + purchaseOrderDetail.getPo_id());
        tf3.setText("" + purchaseOrderDetail.getPlan_id());
        tf4.setText("" + purchaseOrderDetail.getPlan_id());
        tf5.setText("" + purchaseOrderDetail.getQuantity_order());
        tf6.setText("" + purchaseOrderDetail.getUnit_cost());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showItem();

    }

    //input select item query
    public ObservableList<PurchaseOrderDetail> getItemList() {
        ObservableList<PurchaseOrderDetail> itemList = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT * FROM purchaseOrderDetail ";
        Statement st;
        ResultSet rs;

        try {
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            PurchaseOrderDetail item;

            while (rs.next()) {
                item = new PurchaseOrderDetail(rs.getInt("po_item_id"), rs.getInt("po_id"), rs.getInt("plan_id"), rs.getInt("item_id"), rs.getInt("quantity_order"), rs.getInt("unit_cost"));

                itemList.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemList;

    }


    //show select item query result
    public void showItem() {
        ObservableList<PurchaseOrderDetail> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<PurchaseOrderDetail, Integer>("po_item_id"));
        col2.setCellValueFactory(new PropertyValueFactory<PurchaseOrderDetail, Integer>("po_id"));
        col3.setCellValueFactory(new PropertyValueFactory<PurchaseOrderDetail, Integer>("plan_id"));
        col4.setCellValueFactory(new PropertyValueFactory<PurchaseOrderDetail, Integer>("item_id"));
        col5.setCellValueFactory(new PropertyValueFactory<PurchaseOrderDetail, Integer>("quantity_order"));
        col6.setCellValueFactory(new PropertyValueFactory<PurchaseOrderDetail, Integer>("unit_cost"));


        tvItem.setItems(list);

    }

}