package com.app.atividaderecyclerview.models;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

public class Photo implements Parcelable {

    private int albumId;
    private int id;
    private String title;
    private String url;

    public Photo(int albumId, int id, String title, String url) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public Photo(JSONObject json){
        super();
        try{
            this.id = json.getInt("id");
            this.albumId = json.getInt("albumId");
            this.title = json.getString("title");
            this.url = json.getString("url");
        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    protected Photo(Parcel in) {
        id = in.readInt();
        albumId = in.readInt();
        title = in.readString();
        url = in.readString();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public void setAlbumId(int albumId){
        this.albumId = albumId;
    }

    public int getAlbumId(){
        return albumId;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.albumId);
        dest.writeString(this.title);
        dest.writeString(this.url);
    }
}
