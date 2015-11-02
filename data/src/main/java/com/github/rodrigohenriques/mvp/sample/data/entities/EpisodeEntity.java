package com.github.rodrigohenriques.mvp.sample.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class EpisodeEntity {

    @JsonProperty("season") int season;
    @JsonProperty("number") int number;
    @JsonProperty("title") String title;
    @JsonProperty("ids") HashMap<String, String> ids;


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
