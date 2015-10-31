package com.github.rodrigohenriques.mvp.sample.data.entities;


import com.github.rodrigohenriques.mvp.sample.data.api.TraktvApi;
import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;

public class EpisodeEntityMarshaller implements Marshaller<EpisodeEntity, Episode> {

    @Override
    public Episode marshal(EpisodeEntity input) {
        Episode episode = new Episode(input.getSeason(), input.getNumber(), input.getTitle());

        String imdbId = input.getIds().get(TraktvApi.FIELD_IMDB_ID);

        episode.setImdbId(imdbId);

        return episode;
    }
}
