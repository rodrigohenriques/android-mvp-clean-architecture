package com.github.rodrigohenriques.mvp.sample.presenter.view;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;

import java.util.List;

public interface SeasonView extends View {
    void showLoading();
    void hideLoading();
    void showEmptyListTextView();
    void showItems(List<Episode> episodes);
    void showError(String error);
    void showSeasonPicture(String imageUrl);
    void showSeasonBanner(String bannerUrl);
    void showSeasonRating(String rating);
    void showEpisodeDetail(String serializedEpisodeDetail);
}
