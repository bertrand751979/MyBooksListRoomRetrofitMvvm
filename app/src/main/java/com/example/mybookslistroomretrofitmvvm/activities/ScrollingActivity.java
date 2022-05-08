package com.example.mybookslistroomretrofitmvvm.activities;

import static com.example.mybookslistroomretrofitmvvm.activities.SearchActivity.BOOK_EXTRA;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mybookslistroomretrofitmvvm.R;
import com.example.mybookslistroomretrofitmvvm.models.Item;

public class ScrollingActivity extends AppCompatActivity {
    private TextView scrTitle;
    private TextView scrWriter;
    private TextView scrDescription;
    private ImageView scrPhoto;
    private TextView scrDescPublished;
    private Item item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        item = (Item) getIntent().getSerializableExtra(BOOK_EXTRA);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        setViewItem();
    }

    private void setViewItem(){
        scrTitle = findViewById(R.id.scroll_title);
        scrWriter = findViewById(R.id.scroll_author);
        scrDescription =findViewById(R.id.scroll_description);
        scrPhoto = findViewById(R.id.scroll_picture);
        scrDescPublished =findViewById(R.id.scroll_description);
        scrTitle.setText(item.getVolumeInfo().getTitle());
        scrDescPublished.setText(item.getVolumeInfo().getPublishedDate());
        scrWriter.setText(item.getVolumeInfo().getAuthors().get(0));
        scrDescription.setText(item.getVolumeInfo().getDescription());
        if(item.getVolumeInfo().imageLinks!=null){
            Glide.with(this)
                    .load(item.getVolumeInfo()
                            .getImageLinks()
                            .getThumbnail())
                    .into(scrPhoto);
        }
        else{
            scrPhoto.setImageResource(R.drawable.ic_error);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();}
        return super.onOptionsItemSelected(item);
    }
}
