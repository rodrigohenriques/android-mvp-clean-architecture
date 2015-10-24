package com.github.rodrigohenriques.mvp.sample.domain.entities;


public class Episode {
    int season;
    int number;
    String title;

    public Episode(int season, int number, String title) {
        this.season = season;
        this.number = number;
        this.title = title;
    }

    public int getSeason() {
        return season;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getNumberPrettyPrint() {
        return String.format("E%d", number);
    }
}
