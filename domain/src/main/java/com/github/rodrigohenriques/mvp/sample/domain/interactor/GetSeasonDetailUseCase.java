package com.github.rodrigohenriques.mvp.sample.domain.interactor;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Season;

public interface GetSeasonDetailUseCase extends UseCase {
    interface Callback {
        void onSuccess(Season season);
        void onException(Exception e);
    }

    void execute(String serie, int season, Callback callback);
}
