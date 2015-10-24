package com.github.rodrigohenriques.mvp.sample.domain.interactor;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;

import java.util.List;

public interface GetEpisodesUseCase extends UseCase {

    interface Callback {
        void onSuccess(List<Episode> episodes);
        void onException(Exception e);
    }

    void execute(String serie, int season, Callback callback);
}
