package com.github.rodrigohenriques.mvp.sample.presenter;

import com.github.rodrigohenriques.mvp.sample.presenter.view.EpisodesView;

public interface EpisodesPresenter extends Presenter {
    void loadEpisodes(String serie, int season);
    void attachView(EpisodesView episodesView);
}
