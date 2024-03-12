package com.example.procurementmanagmentsystem.Entities;

public class PlanDelivered {


    private int item_id;
    private String item_name;
    private int quantity_plan_all;
    private int quantity_delivered;

    public PlanDelivered(int item_id, String item_name, int quantity_plan_all, int quantity_delivered) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.quantity_plan_all = quantity_plan_all;
        this.quantity_delivered = quantity_delivered;
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

    public int getQuantity_delivered() {
        return quantity_delivered;
    }
}
