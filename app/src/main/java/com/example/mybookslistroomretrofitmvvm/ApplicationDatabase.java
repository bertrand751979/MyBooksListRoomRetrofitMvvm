package com.example.mybookslistroomretrofitmvvm;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.mybookslistroomretrofitmvvm.converters.Converters;
import com.example.mybookslistroomretrofitmvvm.converters.VolumeInfoConverter;
import com.example.mybookslistroomretrofitmvvm.models.Item;


@Database(entities = {Item.class},version = 1)
@TypeConverters({Converters.class, VolumeInfoConverter.class})
public abstract class ApplicationDatabase extends RoomDatabase {
    private static ApplicationDatabase INSTANCE;
    public abstract ItemDao getItemDao();
    public static synchronized ApplicationDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ApplicationDatabase.class, "volumeInfo_app").build();
        }
        return INSTANCE;
    }
}
