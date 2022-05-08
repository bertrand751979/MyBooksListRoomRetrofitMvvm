package com.example.mybookslistroomretrofitmvvm.repository;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.mybookslistroomretrofitmvvm.ApplicationDatabase;
import com.example.mybookslistroomretrofitmvvm.adapters.BookAdapter;
import com.example.mybookslistroomretrofitmvvm.models.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class RepositoryBook {
    public ArrayList<Item> bookList = new ArrayList<>();
    public ArrayList<Item> favList = new ArrayList<>();
    private RepositoryBook(){}
    private static RepositoryBook INSTANCE = null;
    public static RepositoryBook getInstance(){
        if (INSTANCE == null){
            INSTANCE = new RepositoryBook();
        }
        return INSTANCE;
    }

    public ArrayList<Item> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Item> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Item> getFavList() {
        return favList;
    }

    public void setFavList(ArrayList<Item> favList) {
        this.favList = favList;
    }


    public boolean isFavorite(Item itemSelected){
        boolean result =false;
        for(Item itemfav:favList){
            if(itemSelected.getVolumeInfo().getTitle().equals(itemfav.getVolumeInfo().getTitle())){
                if(itemSelected.getVolumeInfo().getDescription()!=null){
                    if(itemSelected.getVolumeInfo().getDescription().equals(itemfav.getVolumeInfo().getDescription())) {
                        if(itemSelected.getVolumeInfo().getPublishedDate().equalsIgnoreCase(itemfav.getVolumeInfo().getPublishedDate())){
                            if(itemSelected.getVolumeInfo().getAuthors().equals(itemfav.getVolumeInfo().getAuthors())){
                                result = true;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public boolean isDetailView(Item itemSelected){
        boolean result=false;
        for(Item item:favList){
            if(itemSelected.getVolumeInfo().getPublishedDate().equalsIgnoreCase(item.getVolumeInfo().getPublishedDate())){
                if(itemSelected.getVolumeInfo().getDescription().equalsIgnoreCase(item.getVolumeInfo().getDescription())){
                    result=true;
                }
            }
        }
        return result;
    }


    public void add(Item item, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDatabase.getInstance(context).getItemDao().insertFavori(item);
            }
        });
    }

    public void delete(Item item, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDatabase.getInstance(context).getItemDao().deleteFavori(item);
            }
        });
    }


    public LiveData<List<Item>> getFavoriteBooks (Context context){
        return ApplicationDatabase.getInstance(context).getItemDao().getFavItems();
    }
    



    }
