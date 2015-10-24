package com.github.rodrigohenriques.mvp.sample.interactor;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;
import com.github.rodrigohenriques.mvp.sample.domain.interactor.GetEpisodesUseCase;
import com.github.rodrigohenriques.mvp.sample.domain.repository.EpisodeRepository;
import com.google.inject.Inject;

import java.util.List;

public class GetEpisodesUseCaseImpl implements GetEpisodesUseCase {

    @Inject
    EpisodeRepository episodeRepository;

    Callback callback;
    Handler handler;

    public GetEpisodesUseCaseImpl() {
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(final String serie, final int season, final Callback callback) {
        this.callback = callback;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final List<Episode> episodes =  episodeRepository.listEpisodesFromTelevisionShowBySeason(serie, season);
                    handler.postDelayed(new RunOnSuccess(episodes), 5000);
                } catch (Exception e) {
                    Log.e("GetEpisodesUseCase", e.getMessage(), e);
                    handler.postDelayed(new RunOnException(e), 5000);
                }
            }
        }).start();
    }

    class RunOnSuccess implements Runnable {
        List<Episode> episodes;

        public RunOnSuccess(List<Episode> episodes) {
            this.episodes = episodes;
        }

        @Override
        public void run() {
            callback.onSuccess(episodes);
        }
    }

    class RunOnException implements Runnable {
        Exception exception;

        public RunOnException(Exception exception) {
            this.exception = exception;
        }

        @Override
        public void run() {
            callback.onException(exception);
        }
    }
}
