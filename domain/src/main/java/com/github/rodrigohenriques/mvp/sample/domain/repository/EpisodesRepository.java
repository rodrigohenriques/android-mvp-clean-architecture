package com.github.rodrigohenriques.mvp.sample.domain.repository;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;
import com.github.rodrigohenriques.mvp.sample.domain.exception.DomainError;

import java.util.List;

public interface EpisodesRepository extends Repository {
    void listEpisodesFromSerieBySeason(String serie, int season, Callback callback);

    interface Callback {
        void onSuccess(List<Episode> episodes);
        void onError(DomainError e);
    }
}
