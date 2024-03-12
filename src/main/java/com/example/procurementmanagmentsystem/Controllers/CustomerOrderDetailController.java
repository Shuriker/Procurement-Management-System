package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.CustomerOrderDetail;
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

public class CustomerOrderDetailController extends SceneController implements Initializable {

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
    private TableColumn<CustomerOrderDetail, Integer> col1;

    @FXML
    private TableColumn<CustomerOrderDetail, Integer> col2;

    @FXML
    private TableColumn<CustomerOrderDetail, Integer> col3;

    @FXML
    private TableColumn<CustomerOrderDetail, Integer> col4;

    @FXML
    private TableColumn<CustomerOrderDetail, Float> col5;

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
    private TableView<CustomerOrderDetail> tvItem;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }
    @FXML
    void handleMouseAction(MouseEvent event) {
        CustomerOrderDetail customerOrderDetail = (CustomerOrderDetail) tvItem.getSelectionModel().getSelectedItem();
        tf1.setText("" + customerOrderDetail.getCo_item_id());
        tf2.setText("" + customerOrderDetail.getCo_id());
        tf3.setText("" + customerOrderDetail.getItem_id());
        tf4.setText("" + customerOrderDetail.getQuantity_order());
        tf5.setText("" + customerOrderDetail.getSale_item_cost());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showItem();

    }

    //input select item query
    public ObservableList<CustomerOrderDetail> getItemList() {
        ObservableList<CustomerOrderDetail> itemList = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT * FROM customerOrderDetail ";
        Statement st;
        ResultSet rs;

        try {
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            CustomerOrderDetail item;

            while (rs.next()) {
                item = new CustomerOrderDetail(rs.getInt("co_item_id"), rs.getInt("co_id"), rs.getInt("item_id"), rs.getInt("quantity_order"), rs.getFloat("sale_item_cost"));

                itemList.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemList;

    }


    //show select item query result
    public void showItem() {
        ObservableList<CustomerOrderDetail> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<CustomerOrderDetail, Integer>("co_item_id"));
        col2.setCellValueFactory(new PropertyValueFactory<CustomerOrderDetail, Integer>("co_id"));
        col3.setCellValueFactory(new PropertyValueFactory<CustomerOrderDetail, Integer>("item_id"));
        col4.setCellValueFactory(new PropertyValueFactory<CustomerOrderDetail, Integer>("quantity_order"));
        col5.setCellValueFactory(new PropertyValueFactory<CustomerOrderDetail, Float>("sale_item_cost"));

        tvItem.setItems(list);

    }


}