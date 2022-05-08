package com.example.mybookslistroomretrofitmvvm.models;

import java.io.Serializable;

public class Pdf implements Serializable {
        public boolean isAvailable;

    public Pdf(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
