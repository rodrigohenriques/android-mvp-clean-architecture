package com.github.rodrigohenriques.mvp.sample.domain.entities;

public class Season {
    private String seasonPictureUrl;
    private String seasonBannerUrl;
    private String seasonRating;

    public String getSeasonPictureUrl() {
        return seasonPictureUrl;
    }

    public void setSeasonPictureUrl(String seasonPictureUrl) {
        this.seasonPictureUrl = seasonPictureUrl;
    }

    public String getSeasonBannerUrl() {
        return seasonBannerUrl;
    }

    public void setSeasonBannerUrl(String seasonBannerUrl) {
        this.seasonBannerUrl = seasonBannerUrl;
    }

    public String getSeasonRating() {
        return seasonRating;
    }

    public void setSeasonRating(String seasonRating) {
        this.seasonRating = seasonRating;
    }
}
