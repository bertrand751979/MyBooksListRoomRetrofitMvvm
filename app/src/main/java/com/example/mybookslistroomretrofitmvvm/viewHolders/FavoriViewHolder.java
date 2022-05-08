package com.example.mybookslistroomretrofitmvvm.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mybookslistroomretrofitmvvm.R;
import com.example.mybookslistroomretrofitmvvm.adapters.FavoriAdapter;
import com.example.mybookslistroomretrofitmvvm.models.Item;

public class FavoriViewHolder extends RecyclerView.ViewHolder {
    private TextView vhFavoriteBookAuthorName;
    private ImageView vhFavoriteBookPicture;
    private TextView vhFavoritePublishedYear;
    private TextView vhFavoriteBookTitle;
    private ImageView vhBtnDelete;

    public FavoriViewHolder(@NonNull View view) {
        super(view);
        vhFavoriteBookAuthorName = view.findViewById(R.id.raw_fav_author);
        vhFavoriteBookPicture = view.findViewById(R.id.raw_fav_picture);
        vhFavoritePublishedYear = view.findViewById(R.id.raw_fav_publishedYear);
        vhFavoriteBookTitle = view.findViewById(R.id.raw_fav_title);
        vhBtnDelete = view.findViewById(R.id.raw_delete_btn);
    }

    public TextView getVhFavoriteBookAuthorName() {
        return vhFavoriteBookAuthorName;
    }

    public void setVhFavoriteBookAuthorName(TextView vhFavoriteBookAuthorName) {
        this.vhFavoriteBookAuthorName = vhFavoriteBookAuthorName;
    }

    public ImageView getVhFavoriteBookPicture() {
        return vhFavoriteBookPicture;
    }

    public void setVhFavoriteBookPicture(ImageView vhFavoriteBookPicture) {
        this.vhFavoriteBookPicture = vhFavoriteBookPicture;
    }

    public TextView getVhFavoritePublishedYear() {
        return vhFavoritePublishedYear;
    }

    public void setVhFavoritePublishedYear(TextView vhFavoritePublishedYear) {
        this.vhFavoritePublishedYear = vhFavoritePublishedYear;
    }

    public TextView getVhFavoriteBookTitle() {
        return vhFavoriteBookTitle;
    }

    public void setVhFavoriteBookTitle(TextView vhFavoriteBookTitle) {
        this.vhFavoriteBookTitle = vhFavoriteBookTitle;
    }

    public ImageView getVhBtnDelete() {
        return vhBtnDelete;
    }

    public void setVhBtnDelete(ImageView vhBtnDelete) {
        this.vhBtnDelete = vhBtnDelete;
    }
    public void bind(Item item, FavoriAdapter.BookFavoriteAdapterInteface favoriAdapterInteface){
        vhFavoriteBookAuthorName.setText(item.getVolumeInfo().getAuthors().get(0));
        vhFavoritePublishedYear.setText(item.getVolumeInfo().getPublishedDate());
        vhFavoriteBookTitle.setText(item.getVolumeInfo().getTitle());
        if(item.getVolumeInfo().imageLinks!=null){
            Glide.with(vhFavoriteBookPicture.getContext())
                    .load(item.getVolumeInfo()
                            .getImageLinks()
                            .getThumbnail())
                    .into(vhFavoriteBookPicture);
        }
        else{
            vhFavoriteBookPicture.setImageResource(R.drawable.ic_error);
        }

        vhBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoriAdapterInteface.delete(item);
            }
        });


    }




}
