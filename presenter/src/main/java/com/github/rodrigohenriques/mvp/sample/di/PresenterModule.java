package com.github.rodrigohenriques.mvp.sample.di;

import android.app.Application;

import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodeDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodesUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetSeasonDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.UiThreadExecutor;
import com.github.rodrigohenriques.mvp.sample.presenter.SeasonPresenter;
import com.github.rodrigohenriques.mvp.sample.presenter.SeasonPresenterImpl;
import com.google.inject.AbstractModule;

public class PresenterModule extends AbstractModule{

    Application application;

    public PresenterModule(Application application) {
        this.application = application;
    }

    @Override
    protected void configure() {
        bind(SeasonPresenter.class).to(SeasonPresenterImpl.class);
        bind(GetEpisodesUseCase.class).toProvider(GetEpisodesUseCaseProvider.class);
        bind(GetSeasonDetailUseCase.class).toProvider(GetSeasonDetailUseCaseProvider.class);
        bind(GetEpisodeDetailUseCase.class).toProvider(GetEpisodeDetailUseCaseProvider.class);
        bind(UiThreadExecutor.class).toProvider(UiThreadExecutorProvider.class);
    }
}
