package com.manager.lastfm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Albummatches implements Parcelable {

    @SerializedName("album")
    private Album[] album;

    protected Albummatches(Parcel in) {
        album = in.createTypedArray(Album.CREATOR);
    }

    public static final Creator<Albummatches> CREATOR = new Creator<Albummatches>() {
        @Override
        public Albummatches createFromParcel(Parcel in) {
            return new Albummatches(in);
        }

        @Override
        public Albummatches[] newArray(int size) {
            return new Albummatches[size];
        }
    };

    public Album[] getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return "ClassPojo [album = " + album + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(album,i);
    }
}
