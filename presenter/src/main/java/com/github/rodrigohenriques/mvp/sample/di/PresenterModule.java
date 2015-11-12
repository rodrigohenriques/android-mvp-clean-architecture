package com.github.rodrigohenriques.mvp.sample.di;

import android.app.Application;
import android.content.Context;

import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodeDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodeDetailUseCaseImpl;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodesUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodesUseCaseImpl;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetSeasonDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetSeasonDetailUseCaseImpl;
import com.github.rodrigohenriques.mvp.sample.domain.repository.EpisodeRepository;
import com.github.rodrigohenriques.mvp.sample.domain.repository.SeasonRepository;
import com.github.rodrigohenriques.mvp.sample.interactor.AndroidUiThreadExecutor;
import com.github.rodrigohenriques.mvp.sample.presenter.SeasonPresenter;
import com.github.rodrigohenriques.mvp.sample.presenter.SeasonPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    Application application;

    public PresenterModule(Application application) {
        this.application = application;
    }

    @Provides public Context provideContext() {
        return application;
    }

    @Provides public SeasonPresenter provideSeasonPresenter(SeasonPresenterImpl seasonPresenter) {
        return seasonPresenter;
    }

    @Provides public GetEpisodesUseCase provideGetEpisodesUseCase(AndroidUiThreadExecutor executor,
                                                                  EpisodeRepository repository) {
        return new GetEpisodesUseCaseImpl(executor, repository);
    }

    @Provides public GetSeasonDetailUseCase provideGetSeasonDetailUseCase(AndroidUiThreadExecutor executor,
                                                                  SeasonRepository repository) {
        return new GetSeasonDetailUseCaseImpl(executor, repository);
    }

    @Provides public GetEpisodeDetailUseCase provideGetEpisodeDetailUseCase(AndroidUiThreadExecutor executor,
                                                                  EpisodeRepository repository) {
        return new GetEpisodeDetailUseCaseImpl(executor, repository);
    }
}
