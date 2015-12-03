package com.github.rodrigohenriques.mvp.sample.domain.interactor;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Season;

public interface GetSeasonDetailUseCase extends UseCase {
    void execute(String tvShow, int season, Callback<Season> callback);
}
