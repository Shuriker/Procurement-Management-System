package com.example.procurementmanagmentsystem.Entities;

public class PlanOrderDetail {
    private int item_id;
    private int order_plan_id;
    private int plan_id;
    private int quantity_plan;

    public PlanOrderDetail(int item_id, int order_plan_id, int plan_id, int quantity_plan) {
        this.item_id = item_id;
        this.order_plan_id = order_plan_id;
        this.plan_id = plan_id;
        this.quantity_plan = quantity_plan;
    }

    public int getItem_id() {
        return item_id;
    }

    public int getOrder_plan_id() {
        return order_plan_id;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public int getQuantity_plan() {
        return quantity_plan;
    }
}
