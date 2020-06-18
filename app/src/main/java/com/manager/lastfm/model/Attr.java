package com.manager.lastfm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

class Attr implements Parcelable {

    @SerializedName("for")
    String form;

    protected Attr(Parcel in) {
        form = in.readString();
    }

    public static final Creator<Attr> CREATOR = new Creator<Attr>() {
        @Override
        public Attr createFromParcel(Parcel in) {
            return new Attr(in);
        }

        @Override
        public Attr[] newArray(int size) {
            return new Attr[size];
        }
    };

    public String getFor(){
        return form;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(form);
    }
}
