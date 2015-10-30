package com.github.rodrigohenriques.mvp.sample.domain.interactor;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Season;
import com.github.rodrigohenriques.mvp.sample.domain.repository.SeasonRepository;

public class GetSeasonDetailUseCaseImpl extends AbstractUseCase implements GetSeasonDetailUseCase {
    private String mSerie;
    private int mSeasonNumber;
    private Callback<Season> mCallback;
    private SeasonRepository mSeasonRepository;

    public GetSeasonDetailUseCaseImpl(UiThreadExecutor uiThreadExecutor, SeasonRepository seasonRepository) {
        super(uiThreadExecutor);
        this.mSeasonRepository = seasonRepository;
    }

    @Override
    public void execute(String serie, int season, Callback<Season> callback) {
        mSerie = serie;
        mSeasonNumber = season;
        mCallback = callback;
        mCallback.setUiThreadExecutor(mUiThreadExecutor);

        executeAsync(this);
    }

    @Override
    public void run() {
        try {
            final Season season = mSeasonRepository.retrieve(mSerie, mSeasonNumber);

            mCallback.dispatchResult(season);
        } catch (final Exception e) {
            mCallback.dispatchException(e);
        }
    }
}
