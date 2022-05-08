package com.example.mybookslistroomretrofitmvvm.fragments;

import static com.example.mybookslistroomretrofitmvvm.activities.SearchActivity.BOOK_EXTRA;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mybookslistroomretrofitmvvm.OnButtonAddClickedAction;
import com.example.mybookslistroomretrofitmvvm.OnItemClickedGoToDescription;
import com.example.mybookslistroomretrofitmvvm.R;
import com.example.mybookslistroomretrofitmvvm.activities.ScrollingActivity;
import com.example.mybookslistroomretrofitmvvm.adapters.BookAdapter;
import com.example.mybookslistroomretrofitmvvm.models.Item;
import com.example.mybookslistroomretrofitmvvm.repository.RepositoryBook;
import com.example.mybookslistroomretrofitmvvm.viewModels.BookListFragmentViewModel;
import java.util.ArrayList;
import java.util.List;

public class BookListFragment extends Fragment {
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private ArrayList<Item> listBooks = new ArrayList<>();
    public BookListFragmentViewModel bookListFragmentViewModel;
    private ArrayList<Item> returnDescription = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listBooks = RepositoryBook.getInstance().bookList;
        bookListFragmentViewModel = new ViewModelProvider(this).get(BookListFragmentViewModel.class);}


    @Override
    public void onResume() {
        super.onResume();
        bookAdapter.setListBookAdapter(returnDescription);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_display_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView= view.findViewById(R.id.recyclerViewBook);
        setViewItem();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        OnItemClickedGoToDescription onItemClickedGoToDescription = new OnItemClickedGoToDescription() {
            @Override
            public void goToDescrition(Item item) {
                Intent intent = new Intent(BookListFragment.this.getContext(), ScrollingActivity.class);
                intent.putExtra(BOOK_EXTRA, item);
                startActivity(intent);
                Toast.makeText(BookListFragment.this.getContext(), "Vers Description", Toast.LENGTH_SHORT).show();
            }

        };
        OnButtonAddClickedAction onButtonAddClickedAction = new OnButtonAddClickedAction() {
            @Override
            public void addToFavorite(Item item) {
                        bookListFragmentViewModel.addToFavorite(item, getContext());
                        if(RepositoryBook.getInstance().isFavorite(item)){

                        }
            }

        };

        bookAdapter = new BookAdapter(onButtonAddClickedAction,onItemClickedGoToDescription);
        recyclerView.setAdapter(bookAdapter);
        bookListFragmentViewModel.itemLiveData.observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                bookAdapter.setListBookAdapter(new ArrayList<>(items));
                returnDescription= (ArrayList<Item>) items;
            }
        });
        bookListFragmentViewModel.toPostMyItemsList();

        bookListFragmentViewModel.getFavoriteList(getContext()).observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                RepositoryBook.getInstance().favList= (ArrayList<Item>) items;
            }
        });
    }



}
