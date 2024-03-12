package com.example.procurementmanagmentsystem.Entities;

public class SalesBetweenSupply {
    private int sales_period_no;
    private int item_id;
    private int quantity;

    public SalesBetweenSupply(int sales_period_no, int item_id, int quantity) {
        this.sales_period_no = sales_period_no;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    public int getSales_period_no() {
        return sales_period_no;
    }

    public int getItem_id() {
        return item_id;
    }

    public int getQuantity() {
        return quantity;
    }
}
