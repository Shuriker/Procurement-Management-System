package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.Dates;
import com.example.procurementmanagmentsystem.Entities.OrdersDelivered;
import com.example.procurementmanagmentsystem.Entities.PlanOrders;
import com.example.procurementmanagmentsystem.Entities.PlanDelivered;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProcurementPlanConrolController extends SceneController {

    @FXML
    private MenuItem DemandAnalyze;

    @FXML
    private MenuItem ProcurementPlanControl;

    @FXML
    private Button btnAnalyze;

    @FXML
    private TableColumn<Dates, String> colArrivalDate4;

    @FXML
    private TableColumn<PlanOrders, Integer> colQuantityOrder1;

    @FXML
    private TableColumn<PlanOrders, Integer> colItemId1;

    @FXML
    private TableColumn<PlanDelivered, Integer> colItemId2;

    @FXML
    private TableColumn<OrdersDelivered, Integer> colItemId3;

    @FXML
    private TableColumn<PlanOrders, String> colItemName1;

    @FXML
    private TableColumn<PlanDelivered, String> colItemName2;

    @FXML
    private TableColumn<OrdersDelivered, String> colItemName3;

    @FXML
    private TableColumn<Dates, String> colOrderDate4;

    @FXML
    private TableColumn<Dates, Integer> colOrderId4;

    @FXML
    private TableColumn<Dates, String> colPlanDate4;

    @FXML
    private TableColumn<PlanDelivered, Integer> colQuantityDelivered2;

    @FXML
    private TableColumn<OrdersDelivered, Integer> colQuantityDelivered3;

    @FXML
    private TableColumn<OrdersDelivered, Integer> colQuantityOrder3;

    @FXML
    private TableColumn<PlanOrders, Integer> colQuantityPlan1;

    @FXML
    private TableColumn<PlanDelivered, Integer> colQuantityPlan2;

    @FXML
    private Label lbPlanEndDate;

    @FXML
    private Label lbPlanStartDate;

    @FXML
    private MenuItem menuItemItem;

    @FXML
    private MenuBar myMenyBar;

    @FXML
    private TextField tfIPlanId;

    @FXML
    private TableView<Dates> tvDates;

    @FXML
    private TableView<OrdersDelivered> tvOrdersDelivered;

    @FXML
    private TableView<PlanDelivered> tvPlanDelivered;

    @FXML
    private TableView<PlanOrders> tvPlanOrders;


    //handle button actions
    @FXML
    private void handleButtonAction(ActionEvent event) {
        showPlanOrders();
        showPlanDelivered();
        showOrdersDelivered();
        showDates();
        showPlanDates();

    }



//---------------------------------------------------------------------------------------

    //input select OrdersDate query
    public ObservableList<PlanOrders> getPlanOrders(){
        ObservableList<PlanOrders> planOrderslist = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT \n" +
                "    it.item_id,\n" +
                "    i.item_name,\n" +
                "    SUM(it.quantity_plan_all) AS quantity_plan_all,\n" +
                "    SUM(it.quantity_order_all) AS quantity_order_all\n" +
                "FROM\n" +
                "    (SELECT \n" +
                "        item_id,\n" +
                "            SUM(quantity_order) AS quantity_order_all,\n" +
                "            SUM(0) AS quantity_plan_all\n" +
                "    FROM\n" +
                "        purchaseorderdetail\n" +
                "    WHERE\n" +
                "        \n" +
                "             po_id IN (SELECT \n" +
                "                order_plan_id\n" +
                "            FROM\n" +
                "                planOrderDetail\n" +
                "            WHERE\n" +
                "        plan_id = " +
                tfIPlanId.getText() + ")" +
                "    GROUP BY item_id \n" +
                "    UNION ALL\n" +
                "    SELECT \n" +
                "        item_id,\n" +
                "            SUM(0) AS quantity_delivered,\n" +
                "            SUM(quantity_plan) AS quantity_plan_all\n" +
                "    FROM\n" +
                "        planOrderDetail\n" +
                "    WHERE\n" +
                "        plan_id = \n" +
                tfIPlanId.getText() +
                "    GROUP BY item_id) it,\n" +
                "    item i\n" +
                "WHERE\n" +
                "    it.item_id = i.item_id\n" +
                "GROUP BY it.item_id , i.item_name; ";
        Statement st;
        ResultSet rs;

        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            PlanOrders planOrders;

            while (rs.next()){
                planOrders = new PlanOrders(rs.getInt("item_id"), rs.getString("item_name"), rs.getInt("quantity_plan_all"), rs.getInt("quantity_order_all"));

                planOrderslist.add(planOrders);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return planOrderslist;

    }

    public void showPlanOrders(){
        ObservableList<PlanOrders> list = getPlanOrders();

        colItemId1.setCellValueFactory(new PropertyValueFactory<PlanOrders, Integer>("item_id"));
        colItemName1.setCellValueFactory(new PropertyValueFactory<PlanOrders, String>("item_name"));
        colQuantityPlan1.setCellValueFactory(new PropertyValueFactory<PlanOrders, Integer>("quantity_plan_all"));
        colQuantityOrder1.setCellValueFactory(new PropertyValueFactory<PlanOrders, Integer>("quantity_order_all"));

        tvPlanOrders.setItems(list);

    }

    //---------------------------------------------------------------------------------------


    //input select PlanDelivered query
    public ObservableList<PlanDelivered> getPlanDelivered(){
        ObservableList<PlanDelivered> planDeliveredlist = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT \n" +
                "    it.item_id,\n" +
                "    i.item_name,\n" +
                "    SUM(it.quantity_plan_all) AS quantity_plan_all,\n" +
                "    SUM(it.quantity_delivered) AS quantity_delivered\n" +
                "FROM\n" +
                "    (SELECT \n" +
                "        item_id,\n" +
                "            SUM(quantity) AS quantity_delivered,\n" +
                "            SUM(0) AS quantity_plan_all\n" +
                "    FROM\n" +
                "        ItemTransactions\n" +
                "    WHERE\n" +
                "        transaction_code = 'Arrival'\n" +
                "            AND order_id IN (SELECT \n" +
                "                order_plan_id\n" +
                "            FROM\n" +
                "                planOrderDetail\n" +
                "            WHERE\n" +
                "        plan_id = " +
                tfIPlanId.getText() + ")" +
                "    GROUP BY item_id \n" +
                "    UNION ALL\n" +
                "    SELECT \n" +
                "        item_id,\n" +
                "            SUM(0) AS quantity_delivered,\n" +
                "            SUM(quantity_plan) AS quantity_plan_all\n" +
                "    FROM\n" +
                "        planOrderDetail\n" +
                "    WHERE\n" +
                "        plan_id = " +
                tfIPlanId.getText() +
                "    GROUP BY item_id) it,\n" +
                "    item i\n" +
                "WHERE\n" +
                "    it.item_id = i.item_id\n" +
                "GROUP BY it.item_id , i.item_name;";
        Statement st;
        ResultSet rs;

        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            PlanDelivered planDelivered;

            while (rs.next()){
                planDelivered = new PlanDelivered(rs.getInt("item_id"), rs.getString("item_name"), rs.getInt("quantity_plan_all"), rs.getInt("quantity_delivered"));

                planDeliveredlist.add(planDelivered);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return planDeliveredlist;

    }

    public void showPlanDelivered(){
        ObservableList<PlanDelivered> list = getPlanDelivered();

        colItemId2.setCellValueFactory(new PropertyValueFactory<PlanDelivered, Integer>("item_id"));
        colItemName2.setCellValueFactory(new PropertyValueFactory<PlanDelivered, String>("item_name"));
        colQuantityPlan2.setCellValueFactory(new PropertyValueFactory<PlanDelivered, Integer>("quantity_plan_all"));
        colQuantityDelivered2.setCellValueFactory(new PropertyValueFactory<PlanDelivered, Integer>("quantity_delivered"));

        tvPlanDelivered.setItems(list);

    }

    //---------------------------------------------------------------------------------------


    //input select OrdersDelivered query
    public ObservableList<OrdersDelivered> getOrdersDelivered(){
        ObservableList<OrdersDelivered> OrdersDeliveredlist = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT \n" +
                "    it.item_id,\n" +
                "    i.item_name,\n" +
                "    SUM(it.quantity_order) AS quantity_order,\n" +
                "    SUM(it.quantity_delivered) AS quantity_delivered\n" +
                "FROM\n" +
                "    (SELECT \n" +
                "        item_id,\n" +
                "            SUM(quantity) AS quantity_delivered,\n" +
                "            SUM(0) AS quantity_order\n" +
                "    FROM\n" +
                "        ItemTransactions\n" +
                "    WHERE\n" +
                "        transaction_code = 'Arrival'\n" +
                "            AND order_id IN (SELECT \n" +
                "                po_id\n" +
                "            FROM\n" +
                "                purchaseorderDetail\n" +
                "            WHERE\n" +
                "        plan_id = " +
                tfIPlanId.getText() + ")" +
                "    GROUP BY item_id \n" +
                "    UNION ALL\n" +
                "    SELECT \n" +
                "        item_id,\n" +
                "            SUM(0) AS quantity_delivered,\n" +
                "            SUM(quantity_order) AS quantity_order\n" +
                "    FROM\n" +
                "        purchaseorderDetail\n" +
                "    WHERE\n" +
                "        plan_id = " +
                tfIPlanId.getText() +
                "    GROUP BY item_id) it,\n" +
                "    item i\n" +
                "WHERE\n" +
                "    it.item_id = i.item_id\n" +
                "GROUP BY it.item_id , i.item_name;";
        Statement st;
        ResultSet rs;

        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            OrdersDelivered ordersDelivered;

            while (rs.next()){
                ordersDelivered = new OrdersDelivered(rs.getInt("item_id"), rs.getString("item_name"), rs.getInt("quantity_order"), rs.getInt("quantity_delivered"));

                OrdersDeliveredlist.add(ordersDelivered);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return OrdersDeliveredlist;

    }

    public void showOrdersDelivered(){
        ObservableList<OrdersDelivered> list = getOrdersDelivered();

        colItemId3.setCellValueFactory(new PropertyValueFactory<OrdersDelivered, Integer>("item_id"));
        colItemName3.setCellValueFactory(new PropertyValueFactory<OrdersDelivered, String>("item_name"));
        colQuantityOrder3.setCellValueFactory(new PropertyValueFactory<OrdersDelivered, Integer>("quantity_order"));
        colQuantityDelivered3.setCellValueFactory(new PropertyValueFactory<OrdersDelivered, Integer>("quantity_delivered"));

        tvOrdersDelivered.setItems(list);

    }

    //---------------------------------------------------------------------------------------


    //input select OrdersDelivered query
    public ObservableList<Dates> getDates(){
        ObservableList<Dates> Dateslist = FXCollections.observableArrayList();
        //old DB connection implementation
        //Connection databaseLink = getConnection();
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "SELECT \n" +
                "    po.po_id, pl.date_end, po.date_register, MAX(it.date) AS date_arrival\n" +
                "FROM\n" +
                "    ItemTransactions it,\n" +
                "    purchaseorder po,\n" +
                "    planorder pl\n" +
                "WHERE\n" +
                "    transaction_code = 'ARRIVAL'\n" +
                "        AND pl.plan_id = " +
                tfIPlanId.getText() +
                "        AND it.order_id = po.po_id\n" +
                "        AND it.order_id = pl.order_plan_id\n" +
                "GROUP BY pl.date_end , it.order_id , po.date_register;";
        Statement st;
        ResultSet rs;

        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            Dates dates;

            while (rs.next()){
                dates = new Dates(rs.getInt("po_id"), rs.getString("date_end"), rs.getString("date_register"), rs.getString("date_arrival"));

                Dateslist.add(dates);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return Dateslist;

    }

    public void showDates(){
        ObservableList<Dates> list = getDates();

        colOrderId4.setCellValueFactory(new PropertyValueFactory<Dates, Integer>("po_id"));
        colPlanDate4.setCellValueFactory(new PropertyValueFactory<Dates, String>("date_end"));
        colOrderDate4.setCellValueFactory(new PropertyValueFactory<Dates, String>("date_register"));
        colArrivalDate4.setCellValueFactory(new PropertyValueFactory<Dates, String>("date_arrival"));

        tvDates.setItems(list);

    }

//---------------------------------------------------------------------------------------

    public void showPlanDates(){

        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "Select date_start, date_end From procurementPlan where plan_id =" + tfIPlanId.getText() + "" ;
        Statement st;
        ResultSet rs;

        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);


            while (rs.next()) {
                // Получение данных из результата запроса
                lbPlanStartDate.setText("Plan Start Date: " + rs.getString("date_start"));
                lbPlanEndDate.setText("Plan End Date: " + rs.getString("date_end"));

                // ...
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }







    }






}
