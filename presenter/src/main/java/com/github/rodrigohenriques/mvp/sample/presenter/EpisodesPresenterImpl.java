package com.github.rodrigohenriques.mvp.sample.presenter;

import android.support.annotation.Nullable;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;
import com.github.rodrigohenriques.mvp.sample.domain.entities.Season;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodesUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetSeasonDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.presenter.view.EpisodesView;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class EpisodesPresenterImpl implements EpisodesPresenter, EpisodesView {

    @Inject GetEpisodesUseCase mGetEpisodesUseCase;
    @Inject GetSeasonDetailUseCase mGetSeasonDetailUseCase;
    @Nullable EpisodesView mEpisodesView;

    Season mSeasonCache;
    List<Episode> mEpisodesCache;

    String mSerie;
    int mSeason;

    public EpisodesPresenterImpl() {
    }

    @Override
    public void loadEpisodes(String serie, int season) {
        showLoading();
        mSerie = serie;
        mSeason = season;

        mGetSeasonDetailUseCase.execute(serie, season, new GetSeasonDetailUseCase.Callback() {
            @Override
            public void onSuccess(Season season) {
                mSeasonCache = season;
                showSeasonPicture(season.getPictureUrl());
                showSeasonBanner(season.getSeasonBannerUrl());
                showSeasonRating(season.getSeasonRating());
            }

            @Override
            public void onException(Exception e) {
                showError(e.getMessage());
            }
        });

        mGetEpisodesUseCase.execute(serie, season, new GetEpisodesUseCase.Callback() {
            @Override
            public void onSuccess(List<Episode> episodes) {
                mEpisodesCache = episodes;
                showItems(episodes);
                hideLoading();
            }

            @Override
            public void onException(Exception e) {
                showError(e.getMessage());
            }
        });
    }

    @Override
    public void attachView(EpisodesView episodesView) {
        this.mEpisodesView = episodesView;

        if (mSeasonCache != null) {
            this.showSeasonPicture(mSeasonCache.getPictureUrl());
            this.showSeasonBanner(mSeasonCache.getSeasonBannerUrl());
            this.showSeasonRating(mSeasonCache.getSeasonRating());
        }

        if (mEpisodesCache != null) {
            this.showItems(mEpisodesCache);
        }

    }

    @Override
    public void showLoading() {
        if (mEpisodesView != null)
            mEpisodesView.showLoading();
    }

    @Override
    public void hideLoading() {
        if (mEpisodesView != null)
            mEpisodesView.hideLoading();
    }

    @Override
    public void showEmptyListTextView() {
        if (mEpisodesView != null)
            mEpisodesView.showEmptyListTextView();
    }

    @Override
    public void showItems(List<Episode> episodes) {
        if (mEpisodesView != null)
            mEpisodesView.showItems(episodes);
    }

    @Override
    public void showError(String error) {
        if (mEpisodesView != null)
            mEpisodesView.showError(error);
    }

    @Override
    public void showSeasonPicture(String imageUrl) {
        if (mEpisodesView != null)
            mEpisodesView.showSeasonPicture(imageUrl);
    }

    @Override
    public void showSeasonBanner(String bannerUrl) {
        if (mEpisodesView != null)
            mEpisodesView.showSeasonPicture(bannerUrl);
    }

    @Override
    public void showSeasonRating(String rating) {
        if (mEpisodesView != null)
            mEpisodesView.showSeasonPicture(rating);
    }
}
