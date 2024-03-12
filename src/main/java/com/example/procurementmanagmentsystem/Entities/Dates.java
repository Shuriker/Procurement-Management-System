package com.example.procurementmanagmentsystem.Entities;

public class Dates {
    private int po_id;
    private String date_end;
    private String date_register;
    private String date_arrival;

    public Dates(int po_id, String date_end, String date_register, String date_arrival) {
        this.po_id = po_id;
        this.date_end = date_end;
        this.date_register = date_register;
        this.date_arrival = date_arrival;
    }

    public int getPo_id() {
        return po_id;
    }

    public String getDate_end() {
        return date_end;
    }

    public String getDate_register() {
        return date_register;
    }

    public String getDate_arrival() {
        return date_arrival;
    }
}
