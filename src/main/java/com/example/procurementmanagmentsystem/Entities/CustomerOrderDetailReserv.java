package com.example.procurementmanagmentsystem.Entities;

public class CustomerOrderDetailReserv {
    private int co_item_id;
    private int co_id;
    private String serial_no;
    private int item_id;
    private int quantity;

    public CustomerOrderDetailReserv(int co_item_id, int co_id, String serial_no, int item_id, int quantity) {
        this.co_item_id = co_item_id;
        this.co_id = co_id;
        this.serial_no = serial_no;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    public int getCo_item_id() {
        return co_item_id;
    }

    public int getCo_id() {
        return co_id;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public int getItem_id() {
        return item_id;
    }

    public int getQuantity() {
        return quantity;
    }
}
