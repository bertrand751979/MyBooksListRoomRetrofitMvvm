package com.example.mybookslistroomretrofitmvvm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mybookslistroomretrofitmvvm.OnButtonAddClickedAction;
import com.example.mybookslistroomretrofitmvvm.OnItemClickedGoToDescription;
import com.example.mybookslistroomretrofitmvvm.R;
import com.example.mybookslistroomretrofitmvvm.models.Item;
import com.example.mybookslistroomretrofitmvvm.viewHolders.BookViewHolder;
import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private ArrayList<Item> listBookAdapter = new ArrayList<>();
    private OnButtonAddClickedAction  onButtonAddClickedAction;
    private OnItemClickedGoToDescription onItemClickedGoToDescription;

    public BookAdapter(OnButtonAddClickedAction onButtonAddClickedAction, OnItemClickedGoToDescription onItemClickedGoToDescription) {
        this.onButtonAddClickedAction = onButtonAddClickedAction;
        this.onItemClickedGoToDescription = onItemClickedGoToDescription;
    }

    public void setListBookAdapter(ArrayList<Item> listBookAdapter) {
        this.listBookAdapter = listBookAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_display_book,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bind(listBookAdapter.get(position),onButtonAddClickedAction,onItemClickedGoToDescription );
    }

    @Override
    public int getItemCount() {
        return listBookAdapter.size();
    }

}
