package com.example.procurementmanagmentsystem.Entities;

public class SerialNumber {
    private String serial_no;
    private int item_id;
    private Float unit_price;

    public SerialNumber(String serial_no, int item_id, Float unit_price) {
        this.serial_no = serial_no;
        this.item_id = item_id;
        this.unit_price = unit_price;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public int getItem_id() {
        return item_id;
    }

    public Float getUnit_price() {
        return unit_price;
    }
}
