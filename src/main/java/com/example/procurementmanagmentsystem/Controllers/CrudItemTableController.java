package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CrudItemTableController  extends SceneController implements Initializable{


    @Override
    public void initialize(URL url, ResourceBundle rb){

        showItem();

    }

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<Item, Integer> col3;

    @FXML
    private TableColumn<Item, Integer> col1;

    @FXML
    private TableColumn<Item, String> col2;

    @FXML
    private TextField tf2;

    @FXML
    private TableColumn<Item, String> col4;

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf3;

    @FXML
    private TableView<Item> tvItem;

    @FXML
    private MenuItem menuItemItem;

    @FXML
    private Parent root ;

    /*
    @FXML
    private MenuBar myMenyBar;
    */



    //handle button actions
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnInsert) {
            insertRecord();
        }else if (event.getSource() == btnUpdate) {
            updateRecord();
        }else if (event.getSource() == btnDelete) {
        deleteRecord();
        }
    }

    //input select item query
    public ObservableList<Item> getItemList(){
        ObservableList<Item> itemList  = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT item.item_id, item.item_name, item.category_id, itemcategory.category_name FROM item, itemcategory where item.category_id = itemcategory.category_id";
        Statement st;
        ResultSet rs;

        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            Item item;

            while (rs.next()){
                item = new Item(rs.getInt("item_id"), rs.getString("item_name"), rs.getInt("category_id"), rs.getString("category_name"));

                itemList.add(item);
            }
        }catch (Exception ex){
        ex.printStackTrace();
        }
    return itemList;

    }



//show select item query result
    public void showItem(){
        ObservableList<Item> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<Item, Integer>("item_id"));
        col2.setCellValueFactory(new PropertyValueFactory<Item, String>("item_name"));
        col3.setCellValueFactory(new PropertyValueFactory<Item, Integer>("category_id"));
        col4.setCellValueFactory(new PropertyValueFactory<Item, String>("category_name"));

        tvItem.setItems(list);

    }

    //insert query method
    private void insertRecord(){
       String query = "INSERT INTO item VALUES (" + tf1.getText() + ",'" + tf3.getText() + "', " + tf2.getText() + ")";
       executeQuery(query);
       showItem();
    }

    //update query method
    private void updateRecord(){
        String query = "Update item SET category_id = " + tf2.getText() + ", item_name = '" + tf3.getText() + "' WHERE item_id = " + tf1.getText() + "";
        executeQuery(query);
        showItem();
    }

    //delete query method
    private void deleteRecord(){
        String query = "DELETE FROM item WHERE item_id =" + tf1.getText() + "";
        executeQuery(query);
        showItem();
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
    Item item = tvItem.getSelectionModel().getSelectedItem();
        tf1.setText("" + item.getItem_id());
        tf2.setText("" + item.getCategory_id());
        tf3.setText("" + item.getItem_name());

    }


}
