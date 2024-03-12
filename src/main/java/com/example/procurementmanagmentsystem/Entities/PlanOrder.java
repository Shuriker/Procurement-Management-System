package com.example.procurementmanagmentsystem.Entities;

public class PlanOrder {
    private int order_plan_id;
    private int plan_id;
    private int supplier_id;
    private String order_date;
    private String date_end;

    public PlanOrder(int order_plan_id, int plan_id, int supplier_id, String order_date, String date_end) {
        this.order_plan_id = order_plan_id;
        this.plan_id = plan_id;
        this.supplier_id = supplier_id;
        this.order_date = order_date;
        this.date_end = date_end;
    }

    public int getOrder_plan_id() {
        return order_plan_id;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public String getDate_end() {
        return date_end;
    }
}
