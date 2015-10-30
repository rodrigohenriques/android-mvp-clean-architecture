package com.github.rodrigohenriques.mvp.sample.domain.interactor;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;
import com.github.rodrigohenriques.mvp.sample.domain.repository.EpisodeRepository;

import java.util.List;

public class GetEpisodesUseCaseImpl extends AbstractUseCase implements GetEpisodesUseCase {
    private String mSerie;
    private int mSeasonNumber;
    private Callback<List<Episode>> mCallback;
    private EpisodeRepository mEpisodeRepository;

    public GetEpisodesUseCaseImpl(UiThreadExecutor mUiThread, EpisodeRepository mEpisodeRepository) {
        super(mUiThread);
        this.mEpisodeRepository = mEpisodeRepository;
    }

    @Override
    public void execute(final String serie, final int seasonNumber, final Callback<List<Episode>> callback) {
        mSerie = serie;
        mSeasonNumber = seasonNumber;
        mCallback = callback;
        mCallback.setUiThreadExecutor(mUiThreadExecutor);

        executeAsync(this);
    }

    @Override
    public void run() {
        try {
            List<Episode> episodes = mEpisodeRepository.listEpisodesFromTelevisionShowBySeason(mSerie, mSeasonNumber);

            mCallback.dispatchResult(episodes);
        } catch (final Exception e) {
            mCallback.dispatchException(e);
        }
    }
}
