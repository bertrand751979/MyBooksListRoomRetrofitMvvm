package com.example.mybookslistroomretrofitmvvm.viewHolders;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mybookslistroomretrofitmvvm.OnButtonAddClickedAction;
import com.example.mybookslistroomretrofitmvvm.OnItemClickedGoToDescription;
import com.example.mybookslistroomretrofitmvvm.R;
import com.example.mybookslistroomretrofitmvvm.adapters.BookAdapter;
import com.example.mybookslistroomretrofitmvvm.fragments.BookListFragment;
import com.example.mybookslistroomretrofitmvvm.models.Item;
import com.example.mybookslistroomretrofitmvvm.repository.RepositoryBook;
import com.google.android.material.card.MaterialCardView;

public class BookViewHolder extends RecyclerView.ViewHolder {
    private ImageView vhImgFavorite;
    private ImageView vhImgBook;
    private TextView vhAuthor;
    private TextView vhDescription;
    private TextView vhTitle;
    private TextView vhPublishedYear;
    private MaterialCardView materialCardView;

    public BookViewHolder(@NonNull View  view) {
        super(view);
        vhImgFavorite = view.findViewById(R.id.raw_btn_fav);
        vhImgBook = view.findViewById(R.id.raw_picture);
        vhAuthor = view.findViewById(R.id.raw_author);
        vhDescription = view.findViewById(R.id.raw_description);
        vhTitle = view.findViewById(R.id.raw_title);
        vhPublishedYear = view.findViewById(R.id.raw_publishedYear);
        materialCardView = view.findViewById(R.id.materCard);
    }

    public ImageView getVhImgFavorite() {
        return vhImgFavorite;
    }

    public void setVhImgFavorite(ImageView vhImgFavorite) {
        this.vhImgFavorite = vhImgFavorite;
    }

    public ImageView getVhImgBook() {
        return vhImgBook;
    }

    public void setVhImgBook(ImageView vhImgBook) {
        this.vhImgBook = vhImgBook;
    }

    public TextView getVhAuthor() {
        return vhAuthor;
    }

    public void setVhAuthor(TextView vhAuthor) {
        this.vhAuthor = vhAuthor;
    }

    public TextView getVhDescription() {
        return vhDescription;
    }

    public void setVhDescription(TextView vhDescription) {
        this.vhDescription = vhDescription;
    }

    public TextView getVhTitle() {
        return vhTitle;
    }

    public void setVhTitle(TextView vhTitle) {
        this.vhTitle = vhTitle;
    }

    public TextView getVhPublishedYear() {
        return vhPublishedYear;
    }

    public void setVhPublishedYear(TextView vhPublishedYear) {
        this.vhPublishedYear = vhPublishedYear;
    }
    public MaterialCardView getMaterialCardView() {
        return materialCardView;
    }

    public void setMaterialCardView(MaterialCardView materialCardView) {
        this.materialCardView = materialCardView;
    }
    public void bind(Item item, OnButtonAddClickedAction onButtonAddClickedAction, OnItemClickedGoToDescription onItemClickedGoToDescription){
        vhAuthor.setText(item.getVolumeInfo().getAuthors().get(0));
        vhDescription.setText(item.getVolumeInfo().getDescription());
        vhTitle.setText(item.getVolumeInfo().getTitle());
        vhPublishedYear.setText(item.getVolumeInfo().getPublishedDate());
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickedGoToDescription.goToDescrition(item);
            }
        });


        if (item.getVolumeInfo().getImageLinks() == null) {
            vhImgBook.setImageResource(R.drawable.ic_error);
        } else {
            Glide.with(vhImgBook.getContext())
                    .load(item.getVolumeInfo().getImageLinks().getSmallThumbnail())
                    .into(vhImgBook);
        }

        if (RepositoryBook.getInstance().isFavorite(item)) {
            vhImgFavorite.setImageResource(R.drawable.ic_full_star);
        } else {
            vhImgFavorite.setImageResource(R.drawable.ic_empty_star);
        }


        vhImgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(RepositoryBook.getInstance().isFavorite(item)){
                  vhImgFavorite.setImageResource(R.drawable.ic_error);
              }else{
                  onButtonAddClickedAction.addToFavorite(item);
                  vhImgFavorite.setImageResource(R.drawable.ic_full_star);
              }
            }
        });



    }






}
