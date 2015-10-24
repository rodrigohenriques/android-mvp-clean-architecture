package com.github.rodrigohenriques.mvp.sample.interactor;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Season;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetSeasonDetailUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.repository.SeasonRepository;
import com.google.inject.Inject;

public class GetSeasonDetailUseCaseImpl implements GetSeasonDetailUseCase{
    @Inject SeasonRepository mSeasonRepository;

    GetSeasonDetailUseCase.Callback mCallback;
    Handler mHandler;

    public GetSeasonDetailUseCaseImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(final String serie, final int seasonNumber, final GetSeasonDetailUseCase.Callback callback) {
        this.mCallback = callback;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Season season =  mSeasonRepository.retrieve(serie, seasonNumber);
                    mHandler.postDelayed(new RunOnSuccess(season), 5000);
                } catch (Exception e) {
                    Log.e("GetEpisodesUseCase", e.getMessage(), e);
                    mHandler.postDelayed(new RunOnException(e), 5000);
                }
            }
        }).start();
    }

    class RunOnSuccess implements Runnable {
        Season season;

        public RunOnSuccess(Season season) {
            this.season = season;
        }

        @Override
        public void run() {
            mCallback.onSuccess(season);
        }
    }

    class RunOnException implements Runnable {
        Exception exception;

        public RunOnException(Exception exception) {
            this.exception = exception;
        }

        @Override
        public void run() {
            mCallback.onException(exception);
        }
    }
}
