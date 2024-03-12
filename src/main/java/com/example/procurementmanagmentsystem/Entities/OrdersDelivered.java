package com.example.procurementmanagmentsystem.Entities;

public class OrdersDelivered {
    private int item_id;
    private String item_name;
    private int quantity_order;
    private int quantity_delivered;

    public OrdersDelivered(int item_id, String item_name, int quantity_order, int quantity_delivered) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.quantity_order = quantity_order;
        this.quantity_delivered = quantity_delivered;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getQuantity_order() {
        return quantity_order;
    }

    public int getQuantity_delivered() {
        return quantity_delivered;
    }
}
