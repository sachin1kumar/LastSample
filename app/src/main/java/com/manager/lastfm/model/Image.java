package com.manager.lastfm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Image implements Parcelable {

    @SerializedName("#text")
    private String text;

    @SerializedName("size")
    private String size;

    protected Image(Parcel in) {
        text = in.readString();
        size = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getText() {
        return text;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ClassPojo [#text = " + text + ", size = " + size + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text);
        parcel.writeString(size);
    }
}
