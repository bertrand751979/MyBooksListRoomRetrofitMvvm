package com.example.mybookslistroomretrofitmvvm.viewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mybookslistroomretrofitmvvm.models.Item;
import com.example.mybookslistroomretrofitmvvm.repository.RepositoryBook;

import java.util.List;

public class SearchActivityViewModel extends ViewModel {
    public LiveData<List<Item>> getForBeginingFavList(Context context) {
        return RepositoryBook.getInstance().getFavoriteBooks(context);
    }

    public LiveData<List<Item>> getFavoriteItem(Context context){
        return RepositoryBook.getInstance().getFavoriteBooks(context);
    }

}
