package com.github.rodrigohenriques.mvp.sample.di;

import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodeDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodeDetailUseCaseImpl;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.UiThreadExecutor;
import com.github.rodrigohenriques.mvp.sample.domain.repository.EpisodeRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class GetEpisodeDetailUseCaseProvider implements Provider<GetEpisodeDetailUseCase> {

    @Inject EpisodeRepository episodeRepository;
    @Inject UiThreadExecutor uiThreadExecutor;

    @Override
    public GetEpisodeDetailUseCase get() {
        return new GetEpisodeDetailUseCaseImpl(uiThreadExecutor, episodeRepository);
    }
}
