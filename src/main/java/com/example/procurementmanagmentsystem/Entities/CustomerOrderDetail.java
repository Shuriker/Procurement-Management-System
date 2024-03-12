package com.example.procurementmanagmentsystem.Entities;

public class CustomerOrderDetail {
    private int co_item_id;
    private int co_id;
    private int item_id;
    private int quantity_order;
    private float sale_item_cost;

    public CustomerOrderDetail(int co_item_id, int co_id, int item_id, int quantity_order, float sale_item_cost) {
        this.co_item_id = co_item_id;
        this.co_id = co_id;
        this.item_id = item_id;
        this.quantity_order = quantity_order;
        this.sale_item_cost = sale_item_cost;
    }

    public int getCo_item_id() {
        return co_item_id;
    }

    public int getCo_id() {
        return co_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public int getQuantity_order() {
        return quantity_order;
    }

    public float getSale_item_cost() {
        return sale_item_cost;
    }
}
