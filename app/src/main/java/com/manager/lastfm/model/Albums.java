package com.manager.lastfm.model;

import com.google.gson.annotations.SerializedName;

public class Albums {

    @SerializedName("results")
    private Results results;

    public Results getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "ClassPojo [results = " + results + "]";
    }
}
