package com.manager.lastfm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Album implements Parcelable {
    @SerializedName("image")
    private Image[] image;

    @SerializedName("mbid")
    private String mbid;

    @SerializedName("artist")
    private String artist;

    @SerializedName("streamable")
    private String streamable;

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public boolean isExpanded;

    protected Album(Parcel in) {
        mbid = in.readString();
        artist = in.readString();
        streamable = in.readString();
        name = in.readString();
        url = in.readString();
        isExpanded = in.readByte() != 0;
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public Image[] getImage() {
        return image;
    }

    public String getMbid() {
        return mbid;
    }

    public String getArtist() {
        return artist;
    }

    public String getStreamable() {
        return streamable;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public boolean isExpanded(){
        return isExpanded;
    }

    public void setIsExpanded(boolean isExpanded){
        this.isExpanded = isExpanded;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeArray(image);
        parcel.writeString(mbid);
        parcel.writeString(artist);
        parcel.writeString(streamable);
        parcel.writeString(name);
        parcel.writeString(url);
    }
}