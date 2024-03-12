package com.example.procurementmanagmentsystem.Entities;

public class Demand {
    private int item_id;
    private String item_name;
    private int quantity_in_stock;
    private float safety_stock;
    private float quantity_max_optimal;
    private float quantity_order_recommended;

    /*
    public Demand(int item_id, String item_name, int quantity_in_stock, float safety_stock, float quantity_max_optimal, float quantity_order_recommended) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.quantity_in_stock = quantity_in_stock;
        this.safety_stock = safety_stock;
        this.quantity_max_optimal = quantity_max_optimal;
        this.quantity_order_recommended = quantity_order_recommended;
    }

     */

    public Demand(int item_id, String item_name, int quantity_in_stock) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.quantity_in_stock = quantity_in_stock;
        this.safety_stock = safety_stock;
        this.quantity_max_optimal = quantity_max_optimal;
        this.quantity_order_recommended = quantity_order_recommended;
    }


    public int getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public float getSafety_stock() {
        return safety_stock;
    }

    public float getQuantity_max_optimal() {
        return quantity_max_optimal;
    }

    public float getQuantity_order_recommended() {
        return quantity_order_recommended;
    }
}
