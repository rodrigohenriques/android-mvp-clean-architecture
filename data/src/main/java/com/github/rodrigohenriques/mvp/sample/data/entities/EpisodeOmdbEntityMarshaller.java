package com.github.rodrigohenriques.mvp.sample.data.entities;

import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;

public class EpisodeOmdbEntityMarshaller implements Marshaller<EpisodeOmdbEntity, EpisodeDetail> {
    @Override
    public EpisodeDetail marshal(EpisodeOmdbEntity episodeOmdbEntity) {
        int season = Integer.parseInt(episodeOmdbEntity.getSeason());
        int number = Integer.parseInt(episodeOmdbEntity.getEpisode());
        String title = episodeOmdbEntity.getTitle();

        EpisodeDetail episodeDetail = new EpisodeDetail(season, number, title);

        return episodeDetail;
    }
}
