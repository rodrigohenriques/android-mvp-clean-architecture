package com.github.rodrigohenriques.mvp.sample.presenter;

import com.github.rodrigohenriques.mvp.sample.presenter.view.EpisodesView;

public interface EpisodesPresenter extends Presenter {
    void loadData(String serie, int season);
    void attachView(EpisodesView episodesView);
}
