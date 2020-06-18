package com.manager.lastfm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Results implements Parcelable {

    @SerializedName("albummatches")
    private Albummatches albummatches;

    protected Results(Parcel in) {
        albummatches = in.readParcelable(Albummatches.class.getClassLoader());
    }

    public static final Creator<Results> CREATOR = new Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };

    public Albummatches getAlbummatches() {
        return albummatches;
    }

    @Override
    public String toString() {
        return "ClassPojo [albummatches = " + albummatches + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(albummatches,i);
    }
}
