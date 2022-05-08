package com.example.mybookslistroomretrofitmvvm.viewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mybookslistroomretrofitmvvm.models.Item;
import com.example.mybookslistroomretrofitmvvm.repository.RepositoryBook;

import java.util.List;

public class FavoryListFragmentViewModel extends ViewModel {
    public LiveData<List<Item>> getFavoriteList(Context context){
        return RepositoryBook.getInstance().getFavoriteBooks(context);
    }

    public void deleteBookFavorir(Item item, Context context){
        RepositoryBook.getInstance().delete(item, context);
    }


}
