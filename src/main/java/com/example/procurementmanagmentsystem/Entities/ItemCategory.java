package com.example.procurementmanagmentsystem.Entities;

public class ItemCategory {

    private int category_id;
    private String category_name;



    public ItemCategory(int category_id, String item_name) {

        this.category_id = category_id;
        this.category_name = item_name;
    }
    public int getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }
}
