package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.CustomerOrder;
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

public class CustomerOrderController extends SceneController implements Initializable {

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
    private TableColumn<CustomerOrder, Integer> col1;

    @FXML
    private TableColumn<CustomerOrder, Integer> col2;

    @FXML
    private TableColumn<CustomerOrder, String> col3;

    @FXML
    private TableColumn<CustomerOrder, String> col4;

    @FXML
    private TableColumn<CustomerOrder, String> col5;

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
    private TableView<CustomerOrder> tvItem;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }

    @FXML
    void handleMouseAction(MouseEvent event) {
        CustomerOrder customerOrder = tvItem.getSelectionModel().getSelectedItem();
        tf1.setText("" + customerOrder.getCo_id());
        tf2.setText("" + customerOrder.getClient_id());
        tf3.setText("" + customerOrder.getDate_register());
        tf4.setText("" + customerOrder.getCo_status());
        tf5.setText("" + customerOrder.getDescription());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showItem();

    }

    //input select item query
    public ObservableList<CustomerOrder> getItemList() {
        ObservableList<CustomerOrder> itemList = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT * FROM customerOrder ";
        Statement st;
        ResultSet rs;

        try {
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            CustomerOrder item;

            while (rs.next()) {
                item = new CustomerOrder(rs.getInt("co_id"), rs.getInt("client_id"), rs.getString("date_register"), rs.getString("co_status"), rs.getString("description"));

                itemList.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemList;

    }


    //show select item query result
    public void showItem() {
        ObservableList<CustomerOrder> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<CustomerOrder, Integer>("co_id"));
        col2.setCellValueFactory(new PropertyValueFactory<CustomerOrder, Integer>("client_id"));
        col3.setCellValueFactory(new PropertyValueFactory<CustomerOrder, String>("date_register"));
        col4.setCellValueFactory(new PropertyValueFactory<CustomerOrder, String>("co_status"));
        col5.setCellValueFactory(new PropertyValueFactory<CustomerOrder, String>("description"));


        tvItem.setItems(list);

    }

}







