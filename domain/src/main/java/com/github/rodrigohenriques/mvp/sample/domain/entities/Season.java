package com.github.rodrigohenriques.mvp.sample.domain.entities;

public class Season {
    private String showThumbUrl;
    private String seasonThumbUrl;
    private String seasonRating;

    public void setShowThumbUrl(String showThumbUrl) {
        this.showThumbUrl = showThumbUrl;
    }

    public void setSeasonThumbUrl(String seasonThumbUrl) {
        this.seasonThumbUrl = seasonThumbUrl;
    }

    public void setSeasonRating(String seasonRating) {
        this.seasonRating = seasonRating;
    }

    public String getPictureUrl() {
        return showThumbUrl;
    }

    public String getSeasonBannerUrl() {
        return seasonThumbUrl;
    }

    public String getSeasonRating() {
        return seasonRating;
    }
}
