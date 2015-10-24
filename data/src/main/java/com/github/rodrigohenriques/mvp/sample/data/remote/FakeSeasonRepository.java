package com.github.rodrigohenriques.mvp.sample.data.remote;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Season;
import com.github.rodrigohenriques.mvp.sample.domain.repository.SeasonRepository;

public class FakeSeasonRepository implements SeasonRepository {

    public FakeSeasonRepository() {
    }

    @Override
    public Season retrieve(String serie, int seasonNumber) {
        Season season = new Season();

        String showThumbUrl = "https://walter.trakt.us/images/shows/000/001/390/posters/thumb/93df9cd612.jpg";
        String seasonThumbUrl = "https://walter.trakt.us/images/seasons/000/003/963/thumbs/original/6c996deed7.jpg";
        String seasonRating = "9.5";

        season.setSeasonThumbUrl(showThumbUrl);
        season.setShowThumbUrl(showThumbUrl);
        season.setSeasonRating(season.getSeasonRating());

        return season;
    }
}
