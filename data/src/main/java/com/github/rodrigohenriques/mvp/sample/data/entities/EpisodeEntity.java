package com.github.rodrigohenriques.mvp.sample.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class EpisodeEntity {

    @SerializedName("season") int season;
    @SerializedName("number") int number;
    @SerializedName("title") String title;
    @SerializedName("ids") HashMap<String, String> ids;


    public int getSeason() {
        return season;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public HashMap<String, String> getIds() {
        return ids;
    }
}
