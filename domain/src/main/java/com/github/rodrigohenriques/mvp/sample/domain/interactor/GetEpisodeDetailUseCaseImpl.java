package com.github.rodrigohenriques.mvp.sample.domain.interactor;

import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;
import com.github.rodrigohenriques.mvp.sample.domain.repository.EpisodeRepository;

public class GetEpisodeDetailUseCaseImpl extends AbstractUseCase implements GetEpisodeDetailUseCase {
    private String mImdbId;
    private Callback<EpisodeDetail> mCallback;
    private EpisodeRepository mEpisodeRepository;

    public GetEpisodeDetailUseCaseImpl(UiThreadExecutor mUiThread, EpisodeRepository mEpisodeRepository) {
        super(mUiThread);
        this.mEpisodeRepository = mEpisodeRepository;
    }

    @Override
    public void execute(String imdbId, Callback<EpisodeDetail> callback) {
        mImdbId = imdbId;
        mCallback = callback;
        mCallback.setUiThreadExecutor(mUiThreadExecutor);

        executeAsync(this);
    }

    @Override
    public void run() {
        try {
            EpisodeDetail episodeDetail = mEpisodeRepository.retrieveEpisodeDetail(mImdbId);

            mCallback.dispatchResult(episodeDetail);
        } catch (final Exception e) {
            mCallback.dispatchException(e);
        }
    }
}
