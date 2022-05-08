package com.example.mybookslistroomretrofitmvvm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybookslistroomretrofitmvvm.R;
import com.example.mybookslistroomretrofitmvvm.adapters.FavoriAdapter;
import com.example.mybookslistroomretrofitmvvm.models.Item;
import com.example.mybookslistroomretrofitmvvm.repository.RepositoryBook;
import com.example.mybookslistroomretrofitmvvm.viewModels.FavoryListFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoryListFragment extends Fragment {
    private ArrayList<Item> displayFavoriteList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FavoriAdapter favoriteAdapter;
    public FavoryListFragmentViewModel viewModelFavorite;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayFavoriteList= RepositoryBook.getInstance().getFavList();
        viewModelFavorite = new ViewModelProvider(this).get(FavoryListFragmentViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_display_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView= view.findViewById(R.id.recyclerViewFavorite);
        setViewItem();
    }


    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        favoriteAdapter = new FavoriAdapter(new FavoriAdapter.BookFavoriteAdapterInteface() {
            @Override
            public void delete(Item item) {
                viewModelFavorite.deleteBookFavorir(item,getContext());
            }
        });
        recyclerView.setAdapter(favoriteAdapter);

        viewModelFavorite.getFavoriteList(getContext()).observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                favoriteAdapter.setListFavoriteAdapter(new ArrayList<>(items));
                RepositoryBook.getInstance().favList = (ArrayList<Item>) items;
            }
        });
    }









}
