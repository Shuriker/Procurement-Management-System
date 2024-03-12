package com.example.procurementmanagmentsystem.Entities;

public class ProcurementPlan {
    private int plan_id;
    private String name;
    private String date_start;
    private String date_end;

    public ProcurementPlan(int plan_id, String name, String date_start, String date_end) {
        this.plan_id = plan_id;
        this.name = name;
        this.date_start = date_start;
        this.date_end = date_end;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public String getName() {
        return name;
    }

    public String getDate_start() {
        return date_start;
    }

    public String getDate_end() {
        return date_end;
    }
}
