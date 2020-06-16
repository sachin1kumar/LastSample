package com.manager.lastfm.model;

import com.google.gson.annotations.SerializedName;

public class Albummatches {

    @SerializedName("album")
    private Album[] album;

    public Album[] getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return "ClassPojo [album = " + album + "]";
    }
}
