package com.github.rodrigohenriques.mvp.sample.di;

import android.app.Application;

import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodesUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetSeasonDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.UiThreadExecutor;
import com.github.rodrigohenriques.mvp.sample.presenter.EpisodesPresenter;
import com.github.rodrigohenriques.mvp.sample.presenter.EpisodesPresenterImpl;
import com.google.inject.AbstractModule;

public class PresenterModule extends AbstractModule{

    Application application;

    public PresenterModule(Application application) {
        this.application = application;
    }

    @Override
    protected void configure() {
        bind(EpisodesPresenter.class).to(EpisodesPresenterImpl.class);
        bind(GetEpisodesUseCase.class).toProvider(GetEpisodesUseCaseProvider.class);
        bind(GetSeasonDetailUseCase.class).toProvider(GetSeasonDetailUseCaseProvider.class);
        bind(UiThreadExecutor.class).toProvider(UiThreadExecutorProvider.class);
    }
}
