package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.ItemsTransactions;
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

public class ItemTransactionsController extends SceneController implements Initializable {

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
    private TableColumn<ItemsTransactions, Integer> col1;

    @FXML
    private TableColumn<ItemsTransactions, String> col2;

    @FXML
    private TableColumn<ItemsTransactions, Integer> col3;

    @FXML
    private TableColumn<ItemsTransactions, String> col4;

    @FXML
    private TableColumn<ItemsTransactions, String> col5;

    @FXML
    private TableColumn<ItemsTransactions, Integer> col6;

    @FXML
    private TableColumn<ItemsTransactions, Integer> col7;

    @FXML
    private TableColumn<ItemsTransactions, Integer> col8;

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
    private TextField tf7;

    @FXML
    private TextField tf8;

    @FXML
    private TableView<ItemsTransactions> tvItem;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }

    @FXML
    void handleMouseAction(MouseEvent event) {
        ItemsTransactions itemsTransactions = (ItemsTransactions) tvItem.getSelectionModel().getSelectedItem();
        tf1.setText("" + itemsTransactions.getTransaction_id());
        tf2.setText("" + itemsTransactions.getTransaction_code());
        tf3.setText("" + itemsTransactions.getItem_id());
        tf4.setText("" + itemsTransactions.getSerial_no());
        tf5.setText("" + itemsTransactions.getDate());
        tf6.setText("" + itemsTransactions.getQuantity());
        tf7.setText("" + itemsTransactions.getOrder_item_id());
        tf8.setText("" + itemsTransactions.getOrder_id());


    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showItem();

    }

    //input select item query
    public ObservableList<ItemsTransactions> getItemList() {
        ObservableList<ItemsTransactions> itemList = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT * FROM itemTransactions ";
        Statement st;
        ResultSet rs;

        try {
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            ItemsTransactions item;

            while (rs.next()) {
                item = new ItemsTransactions(rs.getInt("transaction_id"), rs.getString("transaction_code"),
                        rs.getInt("item_id"), rs.getString("serial_no"), rs.getString("date"),
                        rs.getInt("quantity"), rs.getInt("order_item_id"), rs.getInt("order_id"));

                itemList.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemList;

    }


    //show select item query result
    public void showItem() {
        ObservableList<ItemsTransactions> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<ItemsTransactions, Integer>("transaction_id"));
        col2.setCellValueFactory(new PropertyValueFactory<ItemsTransactions, String>("transaction_code"));
        col3.setCellValueFactory(new PropertyValueFactory<ItemsTransactions, Integer>("item_id"));
        col4.setCellValueFactory(new PropertyValueFactory<ItemsTransactions, String>("serial_no"));
        col5.setCellValueFactory(new PropertyValueFactory<ItemsTransactions, String>("date"));
        col6.setCellValueFactory(new PropertyValueFactory<ItemsTransactions, Integer>("quantity"));
        col7.setCellValueFactory(new PropertyValueFactory<ItemsTransactions, Integer>("order_item_id"));
        col8.setCellValueFactory(new PropertyValueFactory<ItemsTransactions, Integer>("order_id"));

        tvItem.setItems(list);

    }





}