package com.github.rodrigohenriques.mvp.sample.presenter;

import com.github.rodrigohenriques.mvp.sample.presenter.view.EpisodesView;

public interface SeasonPresenter extends Presenter {
    void loadData(String tvShow, int season);
    void attachView(EpisodesView episodesView);
}
