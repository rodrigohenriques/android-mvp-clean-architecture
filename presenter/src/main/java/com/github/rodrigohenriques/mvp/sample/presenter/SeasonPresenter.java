package com.github.rodrigohenriques.mvp.sample.presenter;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;
import com.github.rodrigohenriques.mvp.sample.presenter.view.SeasonView;

public interface SeasonPresenter extends Presenter {
    void loadData(String tvShow, int season);
    void attachView(SeasonView seasonView);
    void clickedOnEpisode(Episode episode);
    void detachView();
}
