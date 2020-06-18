package com.manager.lastfm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Albums implements Parcelable {

    @SerializedName("results")
    private Results results;

    protected Albums(Parcel in) {
        results = in.readParcelable(Results.class.getClassLoader());
    }

    public static final Creator<Albums> CREATOR = new Creator<Albums>() {
        @Override
        public Albums createFromParcel(Parcel in) {
            return new Albums(in);
        }

        @Override
        public Albums[] newArray(int size) {
            return new Albums[size];
        }
    };

    public Results getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "ClassPojo [results = " + results + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(results,i);
    }
}
