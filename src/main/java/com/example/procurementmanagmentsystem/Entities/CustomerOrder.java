package com.example.procurementmanagmentsystem.Entities;

public class CustomerOrder {
    private int co_id;
    private int client_id;
    private String date_register;
    private String co_status;
    private String description;

    public CustomerOrder(int co_id, int client_id, String date_register, String co_status, String description) {
        this.co_id = co_id;
        this.client_id = client_id;
        this.date_register = date_register;
        this.co_status = co_status;
        this.description = description;
    }

    public int getCo_id() {
        return co_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getDate_register() {
        return date_register;
    }

    public String getCo_status() {
        return co_status;
    }

    public String getDescription() {
        return description;
    }

}
