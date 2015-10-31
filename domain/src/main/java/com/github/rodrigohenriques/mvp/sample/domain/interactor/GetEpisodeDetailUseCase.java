package com.github.rodrigohenriques.mvp.sample.domain.interactor;

import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;

public interface GetEpisodeDetailUseCase extends UseCase {
    void execute(String imdbId, Callback<EpisodeDetail> callback);
}
