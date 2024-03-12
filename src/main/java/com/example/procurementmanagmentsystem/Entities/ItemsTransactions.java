package com.example.procurementmanagmentsystem.Entities;

public class ItemsTransactions {
    private int transaction_id;
    private String transaction_code;
    private int item_id;
    private String serial_no;
    private String date;
    private int quantity;
    private int order_item_id;
    private int order_id;

    public ItemsTransactions(int transaction_id, String transaction_code, int item_id, String serial_no, String date, int quantity, int order_item_id, int order_id) {
        this.transaction_id = transaction_id;
        this.transaction_code = transaction_code;
        this.item_id = item_id;
        this.serial_no = serial_no;
        this.date = date;
        this.quantity = quantity;
        this.order_item_id = order_item_id;
        this.order_id = order_id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public String getTransaction_code() {
        return transaction_code;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public String getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getOrder_item_id() {
        return order_item_id;
    }

    public int getOrder_id() {
        return order_id;
    }
}
