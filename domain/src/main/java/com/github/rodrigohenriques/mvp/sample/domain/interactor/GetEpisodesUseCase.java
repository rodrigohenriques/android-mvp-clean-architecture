package com.github.rodrigohenriques.mvp.sample.domain.interactor;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;

import java.util.List;

public interface GetEpisodesUseCase extends UseCase {
    void execute(String serie, int season, Callback<List<Episode>> callback);
}
