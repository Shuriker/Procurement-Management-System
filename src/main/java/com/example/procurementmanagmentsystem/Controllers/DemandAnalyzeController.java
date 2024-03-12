package com.example.procurementmanagmentsystem.Controllers;

import com.example.procurementmanagmentsystem.Entities.Item;
import com.example.procurementmanagmentsystem.Entities.PlanDelivered;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

public class DemandAnalyzeController extends SceneController{

    @FXML
    private MenuItem DemandAnalyze;

    @FXML
    private MenuItem ProcurementPlanControl;

    @FXML
    private Button btnAnalyze;

    @FXML
    private Text lb1;

    @FXML
    private Text lb2;

    @FXML
    private Text lb3;

    @FXML
    private Text lb4;

    @FXML
    private MenuItem menuItemItem;

    @FXML
    private MenuBar myMenyBar;

    @FXML
    private TextField tf1;

    int quantityInStock;
    double mean;
    double safetyStock;
    int supply;
    int checkTime;
    double maxOptimalStock;
    int lastOrderQuantity;
    double orderQuantity;

    @FXML
    void handleButtonAction(ActionEvent event) {
        showQuantityInStock();
        showSafetyStock();
        showMaxOptimalStock();
        showQuantityOrder();

    }

    private void showQuantityInStock() {
        //public ObservableList<Item> getItemList(){
            //ObservableList<Item> itemList  = FXCollections.observableArrayList();
            //old DB connection implementation
            //Connection databaseLink = getConnection();
            //new one
            Connection databaseLink = ConnectDBController.connectDB;
            //
            String query = "SELECT \n" +
                    "        `it`.`item_id` AS `item_id`,\n" +
                    "        SUM(`it`.`quantity`) AS `quantity`\n" +
                    "    FROM\n" +
                    "        (SELECT \n" +
                    "            `procurementmanage`.`itemtransactions`.`item_id` AS `item_id`,\n" +
                    "                (CASE `procurementmanage`.`itemtransactions`.`transaction_code`\n" +
                    "                    WHEN 'ARRIVAL' THEN `procurementmanage`.`itemtransactions`.`quantity`\n" +
                    "                    WHEN 'SALE' THEN (-(1) * `procurementmanage`.`itemtransactions`.`quantity`)\n" +
                    "                    ELSE 0\n" +
                    "                END) AS `quantity`\n" +
                    "        FROM\n" +
                    "            `procurementmanage`.`itemtransactions`\n" +
                    "        WHERE `procurementmanage`.`itemtransactions`.`item_id` =  \n" +
                    tf1.getText() +
                    ") `it`\n" +
                    "    GROUP BY `it`.`item_id`";
            Statement st;
            ResultSet rs;

            try{
                st = databaseLink.createStatement();
                rs = st.executeQuery(query);
                //Item item;

                while (rs.next()){
                    quantityInStock = rs.getInt("quantity");
                   lb1.setText("quantity_in_stock = " + quantityInStock);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            //return itemList;

        }

    //}



    private void showSafetyStock() {
        //new one
        Connection databaseLink = ConnectDBController.connectDB;
        //
        ObservableList<Integer> itemList  = FXCollections.observableArrayList();
        String query = "Select quantity FROM salesBetweenSupply where item_id = " + tf1.getText() + "";
        Statement st;
        ResultSet rs;

        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            //PlanDelivered planDelivered;

            while (rs.next()){
               // planDelivered = new PlanDelivered(rs.getInt("item_id"), rs.getString("item_name"), rs.getInt("quantity_plan_all"), rs.getInt("quantity_delivered"));

                itemList.add(rs.getInt("quantity"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        //return itemList;
        double sum = 0;
        for (double sale : itemList) {
            sum += sale;
        }
        mean = sum / itemList.size();

        // Розрахунок суми квадратів відхилень
        double sumOfSquares = 0;
        for (double sale : itemList) {
            double deviation = sale - mean;
            sumOfSquares += deviation * deviation;
        }

        // Розрахунок середнього квадратичного відхилення
        double standardDeviation = Math.sqrt(sumOfSquares / itemList.size());
        safetyStock = 3.09 * standardDeviation;

        DecimalFormat df = new DecimalFormat("#.####");
        String formattedNumber = df.format(safetyStock);

        lb2.setText("safety_stock = " + formattedNumber);


    }

    private void showMaxOptimalStock() {
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "Select supply_time, check_time From itemProcurementCalcInfo where item_id = " + tf1.getText() + "";
        Statement st;
        ResultSet rs;


        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            //Item item;

            while (rs.next()){
                checkTime = rs.getInt("check_time");
                supply = rs.getInt("supply_time");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        maxOptimalStock = safetyStock + (mean/supply)*(supply + checkTime);
        DecimalFormat df = new DecimalFormat("#.####");
        String formattedNumber = df.format(maxOptimalStock);

        lb3.setText("max_optimal_stock = " + formattedNumber);
    }


    private void showQuantityOrder() {
        Connection databaseLink = ConnectDBController.connectDB;
        //
        String query = "Select last_order_quantity, check_time From itemProcurementCalcInfo where item_id = " + tf1.getText() + "";
        Statement st;
        ResultSet rs;


        try{
            st = databaseLink.createStatement();
            rs = st.executeQuery(query);
            //Item item;

            while (rs.next()){
                lastOrderQuantity = rs.getInt("last_order_quantity");
                checkTime = rs.getInt("check_time");

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        if (supply > checkTime) {


            orderQuantity = maxOptimalStock - quantityInStock - lastOrderQuantity;
        DecimalFormat df = new DecimalFormat("#.####");
        String formattedNumber = df.format(orderQuantity);

        lb4.setText("order_quantity = " + formattedNumber);
    }
    }


}
