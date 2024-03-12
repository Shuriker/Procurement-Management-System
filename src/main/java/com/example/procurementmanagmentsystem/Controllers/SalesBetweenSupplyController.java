package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.Item;
import com.example.procurementmanagmentsystem.Entities.SalesBetweenSupply;
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

public class SalesBetweenSupplyController extends SceneController implements Initializable {

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
    private TableColumn<SalesBetweenSupply, Integer> col1;

    @FXML
    private TableColumn<SalesBetweenSupply, Integer> col2;

    @FXML
    private TableColumn<SalesBetweenSupply, Integer> col3;

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
    private TableView<SalesBetweenSupply> tvItem;

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showItem();

    }

    @FXML
    void handleButtonAction(ActionEvent event) {

    }


    @FXML
    void handleMouseAction(MouseEvent event) {
        SalesBetweenSupply salesBetweenSupply = tvItem.getSelectionModel().getSelectedItem();
        tf1.setText("" + salesBetweenSupply.getSales_period_no());
        tf2.setText("" + salesBetweenSupply.getItem_id());
        tf3.setText("" + salesBetweenSupply.getQuantity());

    }




    public ObservableList<SalesBetweenSupply> getItemList(){
        ObservableList<SalesBetweenSupply> itemList  = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "Select * from salesBetweenSupply";
        Statement st;
        ResultSet rs;

        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            SalesBetweenSupply item;

            while (rs.next()){
                item = new SalesBetweenSupply(rs.getInt("sales_period_no"), rs.getInt("item_id"), rs.getInt("quantity"));

                itemList.add(item);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return itemList;

    }



    //show select item query result
    public void showItem(){
        ObservableList<SalesBetweenSupply> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<SalesBetweenSupply, Integer>("sales_period_no"));
        col2.setCellValueFactory(new PropertyValueFactory<SalesBetweenSupply, Integer>("item_id"));
        col3.setCellValueFactory(new PropertyValueFactory<SalesBetweenSupply, Integer>("quantity"));


        tvItem.setItems(list);

    }

}