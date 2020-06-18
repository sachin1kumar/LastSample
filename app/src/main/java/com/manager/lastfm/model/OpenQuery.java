package com.manager.lastfm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class OpenQuery implements Parcelable {

    @SerializedName("startPage")
    private String startPage;

    @SerializedName("#text")
    private String text;

    @SerializedName("role")
    private String role;

    @SerializedName("searchTerms")
    private String searchTerms;

    protected OpenQuery(Parcel in) {
        startPage = in.readString();
        text = in.readString();
        role = in.readString();
        searchTerms = in.readString();
    }

    public static final Creator<OpenQuery> CREATOR = new Creator<OpenQuery>() {
        @Override
        public OpenQuery createFromParcel(Parcel in) {
            return new OpenQuery(in);
        }

        @Override
        public OpenQuery[] newArray(int size) {
            return new OpenQuery[size];
        }
    };

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public String getText() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    @Override
    public String toString() {
        return "ClassPojo [startPage = " + startPage + ", #text = " +
        text + ", role = " + role + ", searchTerms = " + searchTerms + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(startPage);
        parcel.writeString(text);
        parcel.writeString(role);
        parcel.writeString(searchTerms);
    }
}
