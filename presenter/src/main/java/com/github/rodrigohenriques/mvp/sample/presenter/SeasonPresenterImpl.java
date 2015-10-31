package com.github.rodrigohenriques.mvp.sample.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;
import com.github.rodrigohenriques.mvp.sample.domain.entities.Season;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.Callback;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodesUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetSeasonDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.presenter.view.EpisodesView;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class SeasonPresenterImpl implements SeasonPresenter, EpisodesView {

    @Inject GetEpisodesUseCase mGetEpisodesUseCase;
    @Inject GetSeasonDetailUseCase mGetSeasonDetailUseCase;
    @Nullable EpisodesView mEpisodesView;

    Season mSeasonCache;
    List<Episode> mEpisodesCache;

    String mTvShow;
    int mSeason;
    boolean mLoadingData;

    public SeasonPresenterImpl() {}

    @Override
    public void loadData(final String tvShow, final int seasonNumber) {
        showLoading();

        mTvShow = tvShow;
        mSeason = seasonNumber;

        mGetSeasonDetailUseCase.execute(tvShow, seasonNumber, new Callback<Season>() {
            @Override
            public void onSuccess(Season season) {
                mSeasonCache = season;

                showSeasonPicture(season.getSeasonPictureUrl());
                showSeasonBanner(season.getSeasonBannerUrl());
                showSeasonRating(season.getSeasonRating());

                mGetEpisodesUseCase.execute(tvShow, seasonNumber, new Callback<List<Episode>>() {
                    @Override
                    public void onSuccess(List<Episode> episodes) {
                        mEpisodesCache = episodes;
                        showItems(episodes);
                        hideLoading();
                    }

                    @Override
                    public void onException(Exception e) {
                        hideLoading();
                        showError(e.getMessage());
                    }
                });
            }

            @Override
            public void onException(Exception e) {
                hideLoading();
                showError(e.getMessage());
            }
        });
    }

    @Override
    public void attachView(@NonNull EpisodesView episodesView) {
        this.mEpisodesView = episodesView;

        if (mLoadingData) {
            this.mEpisodesView.showLoading();
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

    @Override
    public void showLoading() {
        mLoadingData = true;

        if (mEpisodesView != null)
            mEpisodesView.showLoading();
    }

    @Override
    public void hideLoading() {
        mLoadingData = false;

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
            mEpisodesView.showSeasonRating(rating);
    }
}
