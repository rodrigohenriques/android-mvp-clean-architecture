package com.github.rodrigohenriques.mvp.sample.di;

import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodesUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodesUseCaseImpl;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.UiThreadExecutor;
import com.github.rodrigohenriques.mvp.sample.domain.repository.EpisodeRepository;

import javax.inject.Inject;
import javax.inject.Provider;

public class GetEpisodesUseCaseProvider implements Provider<GetEpisodesUseCase> {

    @Inject
    EpisodeRepository episodeRepository;
    @Inject UiThreadExecutor uiThreadExecutor;

    @Override
    public GetEpisodesUseCase get() {
        return new GetEpisodesUseCaseImpl(uiThreadExecutor, episodeRepository);
    }
}
