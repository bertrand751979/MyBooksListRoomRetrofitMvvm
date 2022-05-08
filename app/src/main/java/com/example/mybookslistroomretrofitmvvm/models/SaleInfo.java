package com.example.mybookslistroomretrofitmvvm.models;

import java.io.Serializable;

public class SaleInfo implements Serializable {
        public String country;
        public String saleability;
        public boolean isEbook;

    public SaleInfo(String country, String saleability, boolean isEbook) {
        this.country = country;
        this.saleability = saleability;
        this.isEbook = isEbook;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public boolean isEbook() {
        return isEbook;
    }

    public void setEbook(boolean ebook) {
        isEbook = ebook;
    }
}
