package com.example.procurementmanagmentsystem.Entities;

public class Client {
    private int client_id;
    private String name;
    private String type;
    private String number;

    public Client(int client_id, String name, String type, String number) {
        this.client_id = client_id;
        this.name = name;
        this.type = type;
        this.number = number;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
