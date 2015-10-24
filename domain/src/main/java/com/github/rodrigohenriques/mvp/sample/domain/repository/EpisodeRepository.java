package com.github.rodrigohenriques.mvp.sample.domain.repository;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;

import java.util.List;

public interface EpisodeRepository extends Repository {
    List<Episode> listEpisodesFromTelevisionShowBySeason(String serie, int season) throws Exception;
}
