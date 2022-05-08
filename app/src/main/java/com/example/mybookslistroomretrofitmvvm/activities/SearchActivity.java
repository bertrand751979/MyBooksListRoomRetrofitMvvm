package com.example.mybookslistroomretrofitmvvm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mybookslistroomretrofitmvvm.MyBooksRetrofitApi;
import com.example.mybookslistroomretrofitmvvm.R;
import com.example.mybookslistroomretrofitmvvm.models.Item;
import com.example.mybookslistroomretrofitmvvm.models.Root;
import com.example.mybookslistroomretrofitmvvm.repository.RepositoryBook;
import com.example.mybookslistroomretrofitmvvm.viewModels.SearchActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    private EditText editBookName;
    private Button btnSearchBook;
    public static String BOOK_EXTRA = "book_extra";
    private ArrayList<Item> keepFav =new ArrayList<>();
    public SearchActivityViewModel viewModelAtBeginigFav;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book);
        keepFav =RepositoryBook.getInstance().favList;
        viewModelAtBeginigFav = new ViewModelProvider(this).get(SearchActivityViewModel.class);
        editBookName = findViewById(R.id.edit_query);
        btnSearchBook = findViewById(R.id.btn_search);
        btnSearchBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchActivity.this, "Recherche lancée", Toast.LENGTH_SHORT).show();
                callService();
            }
        });
        putListFavatBegining();
    }
    public void callService(){
        MyBooksRetrofitApi.MyBooksRetrofitService service = MyBooksRetrofitApi.getInstance().getClient().create(MyBooksRetrofitApi.MyBooksRetrofitService.class);
        Call<Root> call= service.getRoot(editBookName.getText().toString());
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                updateView(response);
                Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "Erreur", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateView(Response<Root> response) {
        if (response.body().getItems().size() > 0) {
            RepositoryBook.getInstance().bookList = (ArrayList<Item>) response.body().getItems();
            Log.e("La taille de la liste", String.valueOf(RepositoryBook.getInstance().bookList.size()));
            Toast.makeText(SearchActivity.this, "Reponse du serveur", Toast.LENGTH_SHORT).show();
        }
    }

    private void putListFavatBegining(){
        viewModelAtBeginigFav.getForBeginingFavList(this).observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                RepositoryBook.getInstance().favList= (ArrayList<Item>) items;
            }
        });
    }








}
