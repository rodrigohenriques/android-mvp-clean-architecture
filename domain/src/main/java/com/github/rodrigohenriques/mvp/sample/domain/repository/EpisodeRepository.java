package com.github.rodrigohenriques.mvp.sample.domain.repository;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;
import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;

import java.util.List;

public interface EpisodeRepository extends Repository {
    List<Episode> listEpisodesFromTelevisionShowBySeason(String tvShow, int season) throws Exception;
    EpisodeDetail retrieveEpisodeDetail(String imdbId);
}
