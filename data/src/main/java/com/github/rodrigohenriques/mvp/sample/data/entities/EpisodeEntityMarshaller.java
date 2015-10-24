package com.github.rodrigohenriques.mvp.sample.data.entities;


import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;

public class EpisodeEntityMarshaller implements Marshaller<EpisodeEntity, Episode> {

    @Override
    public Episode marshal(EpisodeEntity input) {
        return new Episode(input.getSeason(), input.getNumber(), input.getTitle());
    }
}
