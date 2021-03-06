package com.example.mybookslistroomretrofitmvvm.models;

import java.io.Serializable;

public class IndustryIdentifier implements Serializable {
        public String type;
        public String identifier;

    public IndustryIdentifier(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
