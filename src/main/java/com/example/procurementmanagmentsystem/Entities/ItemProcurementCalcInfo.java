package com.example.procurementmanagmentsystem.Entities;

public class ItemProcurementCalcInfo {
    private int item_id;
    private float unit_storage_cost;
    private float unit_shortage_cost;
    private int supply_time;
    private int last_order_quantity;
    private int check_time;



    public ItemProcurementCalcInfo(int item_id, float unit_storage_cost, float unit_shortage_cost, int supply_time, int last_order_quantity, int check_time) {
        this.item_id = item_id;
        this.unit_storage_cost = unit_storage_cost;
        this.unit_shortage_cost = unit_shortage_cost;
        this.supply_time = supply_time;
        this.last_order_quantity = last_order_quantity;
        this.check_time = check_time;



    }

    public int getItem_id() {
        return item_id;
    }

    public float getUnit_storage_cost() {
        return unit_storage_cost;
    }

    public float getUnit_shortage_cost() {
        return unit_shortage_cost;
    }

    public int getSupply_time() {
        return supply_time;
    }

    public int getLast_order_quantity() {
        return last_order_quantity;
    }

    public int getCheck_time() {
        return check_time;
    }
}
