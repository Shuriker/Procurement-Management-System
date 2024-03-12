package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.CustomerOrderDetail;
import com.example.procurementmanagmentsystem.Entities.CustomerOrderDetailReserv;
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

public class CustomerOrderDetailRezervController extends SceneController implements Initializable {

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
    private TableColumn<CustomerOrderDetailReserv, Integer> col1;

    @FXML
    private TableColumn<CustomerOrderDetailReserv, Integer> col2;

    @FXML
    private TableColumn<CustomerOrderDetailReserv, String> col3;

    @FXML
    private TableColumn<CustomerOrderDetailReserv, Integer> col4;

    @FXML
    private TableColumn<CustomerOrderDetailReserv, Integer> col5;

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
    private TableView<CustomerOrderDetailReserv> tvItem;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }
    @FXML
    void handleMouseAction(MouseEvent event) {
        CustomerOrderDetailReserv customerOrderDetailReserv = (CustomerOrderDetailReserv) tvItem.getSelectionModel().getSelectedItem();
        tf1.setText("" + customerOrderDetailReserv.getCo_item_id());
        tf2.setText("" + customerOrderDetailReserv.getCo_id());
        tf3.setText("" + customerOrderDetailReserv.getSerial_no());
        tf4.setText("" + customerOrderDetailReserv.getItem_id());
        tf5.setText("" + customerOrderDetailReserv.getQuantity());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showItem();

    }

    //input select item query
    public ObservableList<CustomerOrderDetailReserv> getItemList() {
        ObservableList<CustomerOrderDetailReserv> itemList = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT * FROM customerOrderDetailReserv ";
        Statement st;
        ResultSet rs;

        try {
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            CustomerOrderDetailReserv item;

            while (rs.next()) {
                item = new CustomerOrderDetailReserv(rs.getInt("co_item_id"), rs.getInt("co_id"), rs.getString("serial_no"), rs.getInt("item_id"), rs.getInt("quantity"));

                itemList.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemList;

    }


    //show select item query result
    public void showItem() {
        ObservableList<CustomerOrderDetailReserv> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<CustomerOrderDetailReserv, Integer>("co_item_id"));
        col2.setCellValueFactory(new PropertyValueFactory<CustomerOrderDetailReserv, Integer>("co_id"));
        col3.setCellValueFactory(new PropertyValueFactory<CustomerOrderDetailReserv, String>("serial_no"));
        col4.setCellValueFactory(new PropertyValueFactory<CustomerOrderDetailReserv, Integer>("item_id"));
        col5.setCellValueFactory(new PropertyValueFactory<CustomerOrderDetailReserv, Integer>("quantity"));

        tvItem.setItems(list);

    }


}
