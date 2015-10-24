package com.github.rodrigohenriques.mvp.sample.data.entities;

import com.google.gson.annotations.SerializedName;

public class EpisodeEntity {

    @SerializedName("season")
    int season;
    @SerializedName("number")
    int number;
    @SerializedName("title")
    String title;

    public int getSeason() {
        return season;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }
}
