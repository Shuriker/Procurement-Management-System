package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.ItemProcurementCalcInfo;
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

public class ItemProcurementCalcInfoController extends SceneController implements Initializable {

        @Override
        public void initialize(URL url, ResourceBundle rb){

            showItemProcur();

        }


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
        private TableColumn<ItemProcurementCalcInfo, Integer> colItemId;

        @FXML
        private TableColumn<ItemProcurementCalcInfo, Integer> colSupplyTime;

        @FXML
        private TableColumn<ItemProcurementCalcInfo, Float> colUnitShortageCost;

        @FXML
        private TableColumn<ItemProcurementCalcInfo, Float> colUnitStorageCost;

    @FXML
    private TableColumn<ItemProcurementCalcInfo, Integer> col5;

    @FXML
    private TableColumn<ItemProcurementCalcInfo, Integer> col6;

        @FXML
        private MenuItem menuItemItem;

        @FXML
        private MenuBar myMenyBar;

        @FXML
        private AnchorPane root;

        @FXML
        private AnchorPane root1;

        @FXML
        private TextField tfItemId;

        @FXML
        private TextField tfItemName1;

        @FXML
        private TextField tfunit_shortage_cost;

        @FXML
        private TextField tfunit_storage_cost;

    @FXML
    private TextField tf5;

    @FXML
    private TextField tf6;


    @FXML
        private TableView<ItemProcurementCalcInfo> tvItemProcur;

        @FXML
        void handleButtonAction(ActionEvent event) {
            if (event.getSource() == btnInsert) {
                insertRecord();
            }else if (event.getSource() == btnUpdate) {
                updateRecord();
            }else if (event.getSource() == btnDelete) {
                deleteRecord();
            }
        }

        //input select item query
        public ObservableList<ItemProcurementCalcInfo> getItemList(){
            ObservableList<ItemProcurementCalcInfo> itemList  = FXCollections.observableArrayList();
            //old DB connection implementation
            //Connection databaseLink = getConnection();
            //new one
            Connection databaseLink = ConnectDBController.connectDB;
            //
            String query = "SELECT * FROM itemProcurementCalcInfo";
            Statement st;
            ResultSet rs;

            try{
                st = databaseLink.createStatement();
                rs = st.executeQuery(query);
                ItemProcurementCalcInfo itemProcurementCalcInfo;

                while (rs.next()){
                    itemProcurementCalcInfo = new ItemProcurementCalcInfo(rs.getInt("item_id"), rs.getFloat("unit_storage_cost"), rs.getFloat("unit_shortage_cost"), rs.getInt("supply_time"), rs.getInt("last_order_quantity"),rs.getInt("check_time"));

                    itemList.add(itemProcurementCalcInfo);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            return itemList;

        }



        //show select item query result
        public void showItemProcur(){
            ObservableList<ItemProcurementCalcInfo> list = getItemList();

            colItemId.setCellValueFactory(new PropertyValueFactory<ItemProcurementCalcInfo, Integer>("item_id"));
            colUnitStorageCost.setCellValueFactory(new PropertyValueFactory<ItemProcurementCalcInfo, Float>("unit_storage_cost"));
            colUnitShortageCost.setCellValueFactory(new PropertyValueFactory<ItemProcurementCalcInfo, Float>("unit_shortage_cost"));
            colSupplyTime.setCellValueFactory(new PropertyValueFactory<ItemProcurementCalcInfo, Integer>("supply_time"));
            col5.setCellValueFactory(new PropertyValueFactory<ItemProcurementCalcInfo, Integer>("last_order_quantity"));
            col6.setCellValueFactory(new PropertyValueFactory<ItemProcurementCalcInfo, Integer>("check_time"));


            tvItemProcur.setItems(list);

        }

        //insert query method
        private void insertRecord(){
            String query = "INSERT INTO itemProcurementCalcInfo VALUES (" + tfItemId.getText() + ",'" + tfunit_storage_cost.getText() + "', " + tfunit_shortage_cost.getText() + "," + tfItemName1.getText() + ")";
            executeQuery(query);
            showItemProcur();
        }

        //update query method
        private void updateRecord(){
            String query = "Update itemProcurementCalcInfo SET unit_storage_cost = " + tfunit_storage_cost.getText() + ", unit_shortage_cost = '" + tfunit_shortage_cost.getText() + "', supply_time = '" + tfItemName1.getText()+ "' WHERE item_id = " + tfItemId.getText() + "";
            executeQuery(query);
            showItemProcur();
        }

        //delete query method
        private void deleteRecord(){
            String query = "DELETE FROM itemProcurementCalcInfo WHERE item_id =" + tfItemId.getText() + "";
            executeQuery(query);
            showItemProcur();
        }



        //execute SQL queries method
        private void executeQuery(String query) {
            //old connection
            //Connection conn = getConnection();
            //new one
            Connection conn = ConnectDBController.connectDB;
            Statement st;
            try {
                st = conn.createStatement();
                st.executeUpdate(query);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        @FXML
        void handleMouseAction(MouseEvent event) {
            ItemProcurementCalcInfo itemProcurementCalcInfo = tvItemProcur.getSelectionModel().getSelectedItem();
            tfItemId.setText("" + itemProcurementCalcInfo.getItem_id());
            tfunit_storage_cost.setText("" + itemProcurementCalcInfo.getUnit_storage_cost());
            tfunit_shortage_cost.setText("" + itemProcurementCalcInfo.getUnit_shortage_cost());
            tfItemName1.setText("" + itemProcurementCalcInfo.getSupply_time());
            tf5.setText("" + itemProcurementCalcInfo.getLast_order_quantity());
            tf6.setText("" + itemProcurementCalcInfo.getCheck_time());
        }
}
