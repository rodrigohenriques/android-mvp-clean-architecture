package com.github.rodrigohenriques.mvp.sample.data.entities;

import android.support.annotation.Nullable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;

import java.io.IOException;

import javax.inject.Inject;

public class EpisodeDetailJsonMarshaller implements Marshaller<EpisodeDetail, String> {
    ObjectMapper mObjectMapper;

    @Inject
    public EpisodeDetailJsonMarshaller() {
        mObjectMapper = new ObjectMapper();
        mObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override @Nullable
    public String marshal(EpisodeDetail episodeDetail) {
        try {
            return mObjectMapper.writeValueAsString(episodeDetail);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override @Nullable
    public EpisodeDetail unmarshal(String input) {
        try {
            return mObjectMapper.readValue(input, EpisodeDetail.class);
        } catch (IOException e) {
            return null;
        }
    }
}
