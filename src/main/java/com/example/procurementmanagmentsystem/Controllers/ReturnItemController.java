package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.ReturnItem;
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

public class ReturnItemController extends SceneController implements Initializable {

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
    private TableColumn<ReturnItem, Integer> col1;

    @FXML
    private TableColumn<ReturnItem, String> col2;

    @FXML
    private TableColumn<ReturnItem, String> col3;

    @FXML
    private TableColumn<ReturnItem, Integer> col4;

    @FXML
    private TableColumn<ReturnItem, Integer> col5;

    @FXML
    private TableColumn<ReturnItem, Integer> col6;

    @FXML
    private TableColumn<ReturnItem, Integer> col7;

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
    private TableView<ReturnItem> tvItem;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }

    @FXML
    void handleMouseAction(MouseEvent event) {
        ReturnItem returnItem = tvItem.getSelectionModel().getSelectedItem();
        tf1.setText("" + returnItem.getReturn_item_id());
        tf2.setText("" + returnItem.getDate_return());
        tf3.setText("" + returnItem.getSerial_no());
        tf4.setText("" + returnItem.getItem_id());
        tf5.setText("" + returnItem.getPo_item_id());
        tf6.setText("" + returnItem.getPo_id());
        tf7.setText("" + returnItem.getQuantity());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showItem();

    }

    //input select item query
    public ObservableList<ReturnItem> getItemList() {
        ObservableList<ReturnItem> itemList = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT * FROM returnItem ";
        Statement st;
        ResultSet rs;

        try {
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            ReturnItem item;

            while (rs.next()) {
                item = new ReturnItem(rs.getInt("return_item_id"), rs.getString("date_return"), rs.getString("serial_no"), rs.getInt("item_id"), rs.getInt("po_item_id"), rs.getInt("po_id"), rs.getInt("quantity") );

                itemList.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemList;

    }


    //show select item query result
    public void showItem() {
        ObservableList<ReturnItem> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<ReturnItem, Integer>("return_item_id"));
        col2.setCellValueFactory(new PropertyValueFactory<ReturnItem, String>("date_return"));
        col3.setCellValueFactory(new PropertyValueFactory<ReturnItem, String>("serial_no"));
        col4.setCellValueFactory(new PropertyValueFactory<ReturnItem, Integer>("item_id"));
        col5.setCellValueFactory(new PropertyValueFactory<ReturnItem, Integer>("po_item_id"));
        col6.setCellValueFactory(new PropertyValueFactory<ReturnItem, Integer>("po_id"));
        col7.setCellValueFactory(new PropertyValueFactory<ReturnItem, Integer>("quantity"));


        tvItem.setItems(list);

    }





}