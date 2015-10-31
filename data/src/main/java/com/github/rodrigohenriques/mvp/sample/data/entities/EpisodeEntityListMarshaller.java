package com.github.rodrigohenriques.mvp.sample.data.entities;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;

import java.util.ArrayList;
import java.util.List;

public class EpisodeEntityListMarshaller implements Marshaller<List<EpisodeEntity>, List<Episode>> {
    String tvShow;

    public EpisodeEntityListMarshaller(String tvShow) {
        this.tvShow = tvShow;
    }

    @Override
    public List<Episode> marshal(List<EpisodeEntity> episodeEntities) {
        List<Episode> episodes = new ArrayList<>(episodeEntities.size());

        EpisodeEntityMarshaller episodeEntityMarshaller = new EpisodeEntityMarshaller();

        for (EpisodeEntity entity : episodeEntities) {
            Episode episode = episodeEntityMarshaller.marshal(entity);
            episode.setTvShow(tvShow);
            episodes.add(episode);
        }

        return episodes;
    }
}
