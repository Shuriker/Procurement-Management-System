package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.ItemCategory;
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

public class ItemCategoryController extends SceneController implements Initializable {

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
    private TableColumn<ItemCategory, Integer> colCategoryId;

    @FXML
    private TableColumn<ItemCategory, String> colCategoryName;

    @FXML
    private MenuItem menuItemItem;

    @FXML
    private MenuBar myMenyBar;

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane root1;

    @FXML
    private TextField tfCategoryId;

    @FXML
    private TextField tfCategoryName;

    @FXML
    private TableView<ItemCategory> tvCategory;

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

    @FXML
    void handleMouseAction(MouseEvent event) {
        ItemCategory itemcategory = tvCategory.getSelectionModel().getSelectedItem();
        tfCategoryId.setText("" + itemcategory.getCategory_id());
        tfCategoryName.setText("" + itemcategory.getCategory_name());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showCategory();

    }

    //input select item query
    public ObservableList<ItemCategory> getCategoryList(){
        ObservableList<ItemCategory> itemList  = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT * FROM itemcategory";
        Statement st;
        ResultSet rs;

        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            ItemCategory itemcategory;

            while (rs.next()){
                itemcategory = new ItemCategory(rs.getInt("category_id"), rs.getString("category_name"));

                itemList.add(itemcategory);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return itemList;

    }



    //show select item query result
    public void showCategory(){
        ObservableList<ItemCategory> list = getCategoryList();

        colCategoryId.setCellValueFactory(new PropertyValueFactory<ItemCategory, Integer>("category_id"));
        colCategoryName.setCellValueFactory(new PropertyValueFactory<ItemCategory, String>("category_name"));

        tvCategory.setItems(list);

    }

    //insert query method
    private void insertRecord(){
        String query = "INSERT INTO itemcategory VALUES (" + tfCategoryId.getText() + ",'" + tfCategoryName.getText();
        executeQuery(query);
        showCategory();
    }

    //update query method
    private void updateRecord(){
        String query = "Update itemcategory SET category_id = " + tfCategoryId.getText() + ", category_name = '" + tfCategoryName.getText();
        executeQuery(query);
        showCategory();
    }

    //delete query method
    private void deleteRecord(){
        String query = "DELETE FROM itemcategory WHERE category_id =" + tfCategoryId.getText() + "";
        executeQuery(query);
        showCategory();
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



}
