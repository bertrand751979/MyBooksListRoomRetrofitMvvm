package com.example.mybookslistroomretrofitmvvm.models;

import com.example.mybookslistroomretrofitmvvm.models.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class Root implements Serializable {
        public String kind;
        public int totalItems;
        public ArrayList<Item> items;

    public Root(String kind, int totalItems, ArrayList<Item> items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
