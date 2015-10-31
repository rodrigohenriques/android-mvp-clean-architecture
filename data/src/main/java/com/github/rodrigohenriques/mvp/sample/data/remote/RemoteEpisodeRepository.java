package com.github.rodrigohenriques.mvp.sample.data.remote;

import com.github.rodrigohenriques.mvp.sample.data.api.OmdbApi;
import com.github.rodrigohenriques.mvp.sample.data.api.TraktvApi;
import com.github.rodrigohenriques.mvp.sample.data.entities.EpisodeEntity;
import com.github.rodrigohenriques.mvp.sample.data.entities.EpisodeEntityListMarshaller;
import com.github.rodrigohenriques.mvp.sample.data.entities.EpisodeOmdbEntity;
import com.github.rodrigohenriques.mvp.sample.data.entities.EpisodeOmdbEntityMarshaller;
import com.github.rodrigohenriques.mvp.sample.data.exception.RemoteEpisodeRepositoryException;
import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;
import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;
import com.github.rodrigohenriques.mvp.sample.domain.repository.EpisodeRepository;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.Response;

@Singleton
public class RemoteEpisodeRepository implements EpisodeRepository {

    @Inject TraktvApi traktvApi;
    @Inject OmdbApi omdbApi;

    public RemoteEpisodeRepository() {
    }

    @Override
    public List<Episode> listEpisodesFromTelevisionShowBySeason(String tvShow, int season) throws Exception {
        Call<List<EpisodeEntity>> call = traktvApi.episodes(tvShow, season);

        Response<List<EpisodeEntity>> response;
        try {
            response = call.execute();

            if (response.isSuccess()) {
                List<EpisodeEntity> episodeEntities = response.body();

                return new EpisodeEntityListMarshaller(tvShow).marshal(episodeEntities);
            } else {
                throw new RemoteEpisodeRepositoryException("could not retrieve episodes from trakt api: " + response.message());
            }
        } catch (IOException e) {
            throw new RemoteEpisodeRepositoryException("could not retrieve episodes from trakt api: ", e);
        }
    }

    @Override
    public EpisodeDetail retrieveEpisodeDetail(String imdbId) throws Exception {
        Call<EpisodeOmdbEntity> call = omdbApi.findEpisodeInfoByImdbId(imdbId);

        Response<EpisodeOmdbEntity> response;

        try {
            response = call.execute();

            if (response.isSuccess()) {

                EpisodeOmdbEntity episodeOmdbEntity = response.body();
                return new EpisodeOmdbEntityMarshaller().marshal(episodeOmdbEntity);
            } else {
                throw new RemoteEpisodeRepositoryException("could not retrieve episode detail from omdb api: " + response.message());
            }
        } catch (IOException e) {
            throw new RemoteEpisodeRepositoryException("could not retrieve episodes from trakt api: ", e);
        }
    }
}
