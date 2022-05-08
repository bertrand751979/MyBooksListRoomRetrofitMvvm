package com.example.mybookslistroomretrofitmvvm.models;

import java.io.Serializable;

public class SearchInfo implements Serializable {
        public String textSnippet;

    public SearchInfo(String textSnippet) {
        this.textSnippet = textSnippet;
    }

    public String getTextSnippet() {
        return textSnippet;
    }

    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }
}
