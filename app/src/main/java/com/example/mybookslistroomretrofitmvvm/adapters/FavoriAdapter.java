package com.example.mybookslistroomretrofitmvvm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybookslistroomretrofitmvvm.R;
import com.example.mybookslistroomretrofitmvvm.models.Item;
import com.example.mybookslistroomretrofitmvvm.viewHolders.FavoriViewHolder;

import java.util.ArrayList;

public class FavoriAdapter extends RecyclerView.Adapter<FavoriViewHolder> {
    public interface BookFavoriteAdapterInteface {
        void delete(Item item);
    }

    private ArrayList<Item> listFavoriteAdapter = new ArrayList<>();
    private BookFavoriteAdapterInteface bookFavoriteAdapterInteface;

    public FavoriAdapter(BookFavoriteAdapterInteface bookFavoriteAdapterInteface) {
        this.bookFavoriteAdapterInteface = bookFavoriteAdapterInteface;
    }

    public void setListFavoriteAdapter(ArrayList<Item> listFavoriteAdapter) {
        this.listFavoriteAdapter = listFavoriteAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_display_favorite,parent,false);
        return new FavoriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriViewHolder holder, int position) {
        holder.bind(listFavoriteAdapter.get(position), bookFavoriteAdapterInteface);
    }

    @Override
    public int getItemCount() {
        return listFavoriteAdapter.size();
    }
}
