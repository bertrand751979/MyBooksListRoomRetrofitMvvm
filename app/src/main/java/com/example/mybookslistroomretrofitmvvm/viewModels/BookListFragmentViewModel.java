package com.example.mybookslistroomretrofitmvvm.viewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mybookslistroomretrofitmvvm.models.Item;
import com.example.mybookslistroomretrofitmvvm.repository.RepositoryBook;

import java.util.List;

public class BookListFragmentViewModel extends ViewModel {
    private MutableLiveData<List<Item>> myItemsList = new MutableLiveData<>();
    public LiveData<List<Item>> itemLiveData = myItemsList;

    public LiveData<List<Item>> getFavoriteList(Context context){
        return RepositoryBook.getInstance().getFavoriteBooks(context);
    }
    public void toPostMyItemsList(){
        myItemsList.postValue(RepositoryBook.getInstance().getBookList());
    }

    public void addToFavorite(Item item, Context context){
        RepositoryBook.getInstance().add(item,context);
    }


}
