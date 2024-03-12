package com.example.procurementmanagmentsystem.Entities;

public class PlanOrders {

    private int item_id;
    private String item_name;
    private int quantity_plan_all;
    private int quantity_order_all;

    public PlanOrders(int item_id, String item_name, int quantity_plan_all, int quantity_order_all) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.quantity_plan_all = quantity_plan_all;
        this.quantity_order_all = quantity_order_all;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getQuantity_plan_all() {
        return quantity_plan_all;
    }

    public int getQuantity_order_all() {
        return quantity_order_all;
    }
}
