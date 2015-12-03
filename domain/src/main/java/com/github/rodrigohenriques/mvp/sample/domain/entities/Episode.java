package com.github.rodrigohenriques.mvp.sample.domain.entities;


public class Episode {
    int season;
    int number;
    String title;
    String tvShow;
    String imdbId;

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

    public String getTvShow() {
        return tvShow;
    }

    public void setTvShow(String tvShow) {
        this.tvShow = tvShow;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}
