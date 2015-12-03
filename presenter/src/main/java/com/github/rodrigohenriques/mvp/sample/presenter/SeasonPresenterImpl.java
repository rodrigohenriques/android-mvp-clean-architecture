package com.github.rodrigohenriques.mvp.sample.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.rodrigohenriques.mvp.sample.data.entities.Marshaller;
import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;
import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;
import com.github.rodrigohenriques.mvp.sample.domain.entities.Season;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.Callback;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodeDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodesUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetSeasonDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.presenter.view.SeasonView;

import java.util.List;

import javax.inject.Inject;

public class SeasonPresenterImpl implements SeasonPresenter {

    @Inject GetEpisodesUseCase mGetEpisodesUseCase;
    @Inject GetSeasonDetailUseCase mGetSeasonDetailUseCase;
    @Inject GetEpisodeDetailUseCase mGetEpisodeDetailUseCase;
    @Inject Marshaller<EpisodeDetail, String> episodeDetailStringMarshaller;
    @Nullable SeasonView mSeasonView;

    Season mSeasonCache;
    List<Episode> mEpisodesCache;

    String mTvShow;
    int mSeason;
    boolean mLoadingData;

    @Inject
    public SeasonPresenterImpl() {}

    @Override
    public void loadData(final String tvShow, final int seasonNumber) {
        showLoading();

        if (hasCachedResult(tvShow, seasonNumber)) {
            showItems(mEpisodesCache);
        } else {
            mTvShow = tvShow;
            mSeason = seasonNumber;

            mGetSeasonDetailUseCase.execute(tvShow, seasonNumber, new Callback<Season>() {
                @Override
                public void onSuccess(Season season) {
                    mSeasonCache = season;

                    showSeasonPicture(season.getSeasonPictureUrl());
                    showSeasonBanner(season.getSeasonBannerUrl());
                    showSeasonRating(season.getSeasonRating());

                    showLoading();

                    mGetEpisodesUseCase.execute(tvShow, seasonNumber, new Callback<List<Episode>>() {
                        @Override
                        public void onSuccess(List<Episode> episodes) {
                            mEpisodesCache = episodes;
                            showItems(episodes);
                        }

                        @Override
                        public void onException(Exception e) {
                            showError(e.getMessage());
                        }

                        @Override
                        public void onPostExecute() {
                            hideLoading();
                        }
                    });
                }

                @Override
                public void onException(Exception e) {
                    showError(e.getMessage());
                }

                @Override
                public void onPostExecute() {
                    hideLoading();
                }
            });
        }
    }

    private boolean hasCachedResult(String tvShow, int seasonNumber) {
        return mTvShow != null && mTvShow.equals(tvShow) && mSeason == seasonNumber && mEpisodesCache != null;
    }

    @Override
    public void attachView(@NonNull SeasonView seasonView) {
        this.mSeasonView = seasonView;

        if (mLoadingData) {
            this.mSeasonView.showLoading();
        } else {
            if (mSeasonCache != null) {
                this.showSeasonPicture(mSeasonCache.getSeasonPictureUrl());
                this.showSeasonBanner(mSeasonCache.getSeasonBannerUrl());
                this.showSeasonRating(mSeasonCache.getSeasonRating());
            }

            if (mEpisodesCache != null) {
                this.showItems(mEpisodesCache);
            }
        }
    }

    public void clickedOnEpisode(Episode episode) {
        showLoading();

        String imdbId = episode.getImdbId();

        mGetEpisodeDetailUseCase.execute(imdbId, new Callback<EpisodeDetail>() {
            @Override
            public void onSuccess(EpisodeDetail episodeDetail) {
                showEpisodeDetail(episodeDetail);
            }

            @Override
            public void onException(Exception e) {
                showError(e.getMessage());
            }

            @Override
            public void onPostExecute() {
                hideLoading();
            }
        });
    }

    @Override
    public void detachView() {
        mSeasonView = null;
    }

    public void showLoading() {
        mLoadingData = true;

        if (mSeasonView != null)
            mSeasonView.showLoading();
    }

    public void hideLoading() {
        mLoadingData = false;

        if (mSeasonView != null)
            mSeasonView.hideLoading();
    }

    public void showEmptyListTextView() {
        if (mSeasonView != null)
            mSeasonView.showEmptyListTextView();
    }

    public void showItems(List<Episode> episodes) {
        if (mSeasonView != null)
            mSeasonView.showItems(episodes);
    }

    public void showError(String error) {
        if (mSeasonView != null)
            mSeasonView.showError(error);
    }

    public void showSeasonPicture(String imageUrl) {
        if (mSeasonView != null)
            mSeasonView.showSeasonPicture(imageUrl);
    }

    public void showSeasonBanner(String bannerUrl) {
        if (mSeasonView != null)
            mSeasonView.showSeasonPicture(bannerUrl);
    }

    public void showSeasonRating(String rating) {
        if (mSeasonView != null)
            mSeasonView.showSeasonRating(rating);
    }

    public void showEpisodeDetail(EpisodeDetail episodeDetail) {
        if (mSeasonView != null) {
            try {
                String serializedEpisodeDetail = episodeDetailStringMarshaller.marshal(episodeDetail);
                mSeasonView.showEpisodeDetail(serializedEpisodeDetail);
            } catch (Exception e) {
                showError("Não foi possível exibir o episodio no momento");
            }
        }
    }
}
