package com.github.rodrigohenriques.mvp.sample.di;

import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetSeasonDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetSeasonDetailUseCaseImpl;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.UiThreadExecutor;
import com.github.rodrigohenriques.mvp.sample.domain.repository.SeasonRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class GetSeasonDetailUseCaseProvider implements Provider<GetSeasonDetailUseCase>{
    @Inject SeasonRepository mSeasonRepository;
    @Inject UiThreadExecutor mUiThreadExecutor;

    @Override
    public GetSeasonDetailUseCase get() {
        return new GetSeasonDetailUseCaseImpl(mUiThreadExecutor, mSeasonRepository);
    }
}
