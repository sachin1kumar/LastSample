package com.manager.lastfm.model;

import com.google.gson.annotations.SerializedName;

public class Album {
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

    @Override
    public String toString() {
        return "ClassPojo [image = " + image + ", mbid = " + mbid + ", artist = " + artist + ", streamable = " + streamable + ", name = " + name + ", url = " + url + "]";
    }
}