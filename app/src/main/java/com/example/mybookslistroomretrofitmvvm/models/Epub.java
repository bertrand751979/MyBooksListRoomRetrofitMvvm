package com.example.mybookslistroomretrofitmvvm.models;

import java.io.Serializable;

public class Epub implements Serializable {
        public boolean isAvailable;

    public Epub(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
