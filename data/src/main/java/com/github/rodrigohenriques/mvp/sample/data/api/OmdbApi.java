package com.github.rodrigohenriques.mvp.sample.data.api;

import com.github.rodrigohenriques.mvp.sample.data.entities.EpisodeOmdbEntity;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface OmdbApi {
    @GET("?plot=short&r=json&type=episode")
    Call<EpisodeOmdbEntity> findEpisodeInfoByImdbId(@Query("i") String imdbId);
}
