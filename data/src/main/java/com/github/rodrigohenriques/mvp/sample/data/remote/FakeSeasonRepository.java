package com.github.rodrigohenriques.mvp.sample.data.remote;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Season;
import com.github.rodrigohenriques.mvp.sample.domain.repository.SeasonRepository;

import javax.inject.Inject;

public class FakeSeasonRepository implements SeasonRepository {
    @Inject
    public FakeSeasonRepository() {
    }

    @Override
    public Season retrieve(String tvShow, int seasonNumber) {
        Season season = new Season();

        String seasonPictureUrl = "https://walter.trakt.us/images/shows/000/001/390/posters/thumb/93df9cd612.jpg";
        String seasonBannerUrl = "https://walter.trakt.us/images/seasons/000/003/963/thumbs/original/6c996deed7.jpg";
        String seasonRating = "9.5";

        season.setSeasonPictureUrl(seasonPictureUrl);
        season.setSeasonBannerUrl(seasonBannerUrl);
        season.setSeasonRating(seasonRating);

        return season;
    }
}
