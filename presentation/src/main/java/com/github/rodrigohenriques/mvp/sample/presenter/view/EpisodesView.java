package com.github.rodrigohenriques.mvp.sample.presenter.view;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;

import java.util.List;

public interface EpisodesView extends View {
    void showLoading();
    void hideLoading();
    void showEmptyListTextView();
    void showItems(List<Episode> episodes);
}
