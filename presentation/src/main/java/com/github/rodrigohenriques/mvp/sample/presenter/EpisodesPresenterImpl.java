package com.github.rodrigohenriques.mvp.sample.presenter;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;
import com.github.rodrigohenriques.mvp.sample.domain.exception.DomainError;
import com.github.rodrigohenriques.mvp.sample.domain.repository.EpisodesRepository;
import com.github.rodrigohenriques.mvp.sample.presenter.view.EpisodesView;

import java.util.List;

public class EpisodesPresenterImpl implements EpisodesPresenter, EpisodesView {

    EpisodesView episodesView;
    EpisodesRepository episodesRepository;

    @Override
    public void loadEpisodes(String serie, int season) {
        showLoading();
        episodesRepository.listEpisodesFromSerieBySeason(serie, season, new EpisodesRepository.Callback() {
            @Override
            public void onSuccess(List<Episode> episodes) {
                hideLoading();
                showItems(episodes);
            }

            @Override
            public void onError(DomainError e) {

            }
        });
    }

    @Override
    public void attachView(EpisodesView episodesView) {
        this.episodesView = episodesView;
    }

    @Override
    public void showLoading() {
        if (episodesView != null)
            episodesView.showLoading();
    }

    @Override
    public void hideLoading() {
        if (episodesView != null)
            episodesView.hideLoading();
    }

    @Override
    public void showEmptyListTextView() {
        if (episodesView != null)
            episodesView.showEmptyListTextView();
    }

    @Override
    public void showItems(List<Episode> episodes) {
        if (episodesView != null)
            episodesView.showItems(episodes);
    }
}
