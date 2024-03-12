package com.example.procurementmanagmentsystem.Entities;

public class Item {

    private int item_id;
    private String item_name;
    private int category_id;
    private String category_name;

    public Item(int item_id,  String item_name, int category_id, String category_name) {
        this.item_id = item_id;
        this.category_id = category_id;
        this.item_name = item_name;
        this.category_name = category_name;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }
    public int getCategory_id() {
        return category_id;
    }



    public String getCategory_name() {
        return category_name;
    }




}
