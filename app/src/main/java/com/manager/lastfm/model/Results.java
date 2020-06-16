package com.manager.lastfm.model;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("albummatches")
    private Albummatches albummatches;

    public Albummatches getAlbummatches() {
        return albummatches;
    }

    @Override
    public String toString() {
        return "ClassPojo [albummatches = " + albummatches + "]";
    }
}
