package com.github.rodrigohenriques.mvp.sample.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EpisodeOmdbEntity {
    @JsonProperty("Title")    private String title;
    @JsonProperty("Year")     private String year;
    @JsonProperty("Rated")    private String rated;
    @JsonProperty("Released") private String released;
    @JsonProperty("Season")   private String season;
    @JsonProperty("Episode")  private String episode;
    @JsonProperty("Runtime")  private String runtime;
    @JsonProperty("Genre")    private String genre;
    @JsonProperty("Director") private String director;
    @JsonProperty("Writer")   private String writer;
    @JsonProperty("Actors")   private String actors;
    @JsonProperty("Plot")     private String plot;
    @JsonProperty("Language") private String language;
    @JsonProperty("Country")  private String country;
    @JsonProperty("Awards")   private String awards;
    @JsonProperty("Poster")   private String poster;
    @JsonProperty("Metascore")    private String metascore;
    @JsonProperty("imdbRating")   private String imdbRating;
    @JsonProperty("imdbVotes")    private String imdbVotes;
    @JsonProperty("imdbID")   private String imdbID;
    @JsonProperty("seriesID") private String seriesID;
    @JsonProperty("Type")     private String type;
    @JsonProperty("Response") private String response;

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
