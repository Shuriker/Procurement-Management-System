package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.ProcurementPlan;
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

public class ProcurementPlanController extends  SceneController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb){

        showPlan();

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
    private TableColumn<ProcurementPlan, Integer> col1;

    @FXML
    private TableColumn<ProcurementPlan, String> col2;

    @FXML
    private TableColumn<ProcurementPlan, String> col3;

    @FXML
    private TableColumn<ProcurementPlan, String> col4;

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
    private TableView<ProcurementPlan> tvPlan;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }

    @FXML
    void handleMouseAction(MouseEvent event) {
        ProcurementPlan plan = tvPlan.getSelectionModel().getSelectedItem();
        tf1.setText("" + plan.getPlan_id());
        tf2.setText("" + plan.getName());
        tf3.setText("" + plan.getDate_start());
        tf4.setText(""+ plan.getDate_start());
    }


    //input select item query
    public ObservableList<ProcurementPlan> getItemList(){
        ObservableList<ProcurementPlan> itemList  = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT procurementPlan.plan_id, procurementPlan.name, procurementPlan.date_start, procurementPlan.date_end FROM procurementPlan";
        Statement st;
        ResultSet rs;

        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            ProcurementPlan item;

            while (rs.next()){
                item = new ProcurementPlan(rs.getInt("plan_id"), rs.getString("name"), rs.getString("date_start"), rs.getString("date_end"));

                itemList.add(item);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return itemList;

    }



    //show select item query result
    public void showPlan(){
        ObservableList<ProcurementPlan> list = getItemList();

        col1.setCellValueFactory(new PropertyValueFactory<ProcurementPlan, Integer>("plan_id"));
        col2.setCellValueFactory(new PropertyValueFactory<ProcurementPlan, String>("name"));
        col3.setCellValueFactory(new PropertyValueFactory<ProcurementPlan, String>("date_start"));
        col4.setCellValueFactory(new PropertyValueFactory<ProcurementPlan, String>("date_end"));

        tvPlan.setItems(list);

    }









}

