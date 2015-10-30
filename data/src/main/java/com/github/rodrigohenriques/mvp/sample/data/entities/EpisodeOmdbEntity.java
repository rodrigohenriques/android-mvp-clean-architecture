package com.github.rodrigohenriques.mvp.sample.data.entities;

import com.google.gson.annotations.SerializedName;

public class EpisodeOmdbEntity {
    @SerializedName("Title")    private String title;
    @SerializedName("Year")     private String year;
    @SerializedName("Rated")    private String rated;
    @SerializedName("Released") private String released;
    @SerializedName("Season")   private String season;
    @SerializedName("Episode")  private String episode;
    @SerializedName("Runtime")  private String runtime;
    @SerializedName("Genre")    private String genre;
    @SerializedName("Director") private String director;
    @SerializedName("Writer")   private String writer;
    @SerializedName("Actors")   private String actors;
    @SerializedName("Plot")     private String plot;
    @SerializedName("Language") private String language;
    @SerializedName("Country")  private String country;
    @SerializedName("Awards")   private String awards;
    @SerializedName("Poster")   private String poster;
    @SerializedName("Metascore")    private String metascore;
    @SerializedName("imdbRating")   private String imdbRating;
    @SerializedName("imdbVotes")    private String imdbVotes;
    @SerializedName("imdbID")   private String imdbID;
    @SerializedName("seriesID") private String seriesID;
    @SerializedName("Type")     private String type;
    @SerializedName("Response") private String response;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getSeason() {
        return season;
    }

    public String getEpisode() {
        return episode;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return poster;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getSeriesID() {
        return seriesID;
    }

    public String getType() {
        return type;
    }

    public String getResponse() {
        return response;
    }
}
