package com.manager.lastfm.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("#text")
    private String text;

    @SerializedName("size")
    private String size;

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
}
