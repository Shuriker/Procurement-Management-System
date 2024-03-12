package com.example.procurementmanagmentsystem.Entities;

public class PurchaseOrderDetail {
    private int po_item_id;
    private int po_id;
    private int plan_id;
    private int item_id;
    private int quantity_order;
    private int unit_cost;

    public PurchaseOrderDetail(int po_item_id, int po_id, int plan_id, int item_id, int quantity_order, int unit_cost) {
        this.po_item_id = po_item_id;
        this.po_id = po_id;
        this.plan_id = plan_id;
        this.item_id = item_id;
        this.quantity_order = quantity_order;
        this.unit_cost = unit_cost;
    }

    public int getPo_item_id() {
        return po_item_id;
    }

    public int getPo_id() {
        return po_id;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public int getQuantity_order() {
        return quantity_order;
    }

    public int getUnit_cost() {
        return unit_cost;
    }
}
