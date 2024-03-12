package com.example.procurementmanagmentsystem.Entities;

public class PurchaseOrder {
    private int po_id;
    private int plan_id;
    private String date_register;
    private String description;
    private int supplier_id;

    public PurchaseOrder(int po_id, int plan_id, String date_register, String description, int supplier_id) {
        this.po_id = po_id;
        this.plan_id = plan_id;
        this.date_register = date_register;
        this.description = description;
        this.supplier_id = supplier_id;
    }

    public int getPo_id() {
        return po_id;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public String getDate_register() {
        return date_register;
    }

    public String getDescription() {
        return description;
    }

    public int getSupplier_id() {
        return supplier_id;
    }
}
