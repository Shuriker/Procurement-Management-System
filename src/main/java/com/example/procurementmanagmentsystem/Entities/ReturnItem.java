package com.example.procurementmanagmentsystem.Entities;

public class ReturnItem {
    private int return_item_id;
    private String date_return;
    private String serial_no;
    private int item_id;
    private int po_item_id;
    private int po_id;
    private int quantity;

    public ReturnItem(int return_item_id, String date_return, String serial_no, int item_id, int po_item_id, int po_id, int quantity) {
        this.return_item_id = return_item_id;
        this.date_return = date_return;
        this.serial_no = serial_no;
        this.item_id = item_id;
        this.po_item_id = po_item_id;
        this.po_id = po_id;
        this.quantity = quantity;
    }

    public int getReturn_item_id() {
        return return_item_id;
    }

    public String getDate_return() {
        return date_return;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public int getItem_id() {
        return item_id;
    }

    public int getPo_item_id() {
        return po_item_id;
    }

    public int getPo_id() {
        return po_id;
    }

    public int getQuantity() {
        return quantity;
    }
}


