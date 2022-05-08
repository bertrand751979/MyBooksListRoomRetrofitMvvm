package com.example.mybookslistroomretrofitmvvm.converters;

import androidx.room.TypeConverter;

import com.example.mybookslistroomretrofitmvvm.models.VolumeInfo;
import com.google.gson.Gson;

public class VolumeInfoConverter {

    @TypeConverter
    public static VolumeInfo fromString (String value){
        //Type listType =  new TypeToken<String>(){}.getType();
        return new Gson().fromJson(value,VolumeInfo.class);
    }

    @TypeConverter
    public static String fromVolumeInfo (VolumeInfo volumeInfo){
        Gson gson = new Gson();
        //toJson retourne un string
        String json = gson.toJson(volumeInfo);
        return json;
    }



}
