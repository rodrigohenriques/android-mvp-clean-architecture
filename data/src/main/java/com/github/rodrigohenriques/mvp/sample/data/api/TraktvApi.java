package com.github.rodrigohenriques.mvp.sample.data.api;

import com.github.rodrigohenriques.mvp.sample.data.entities.EpisodeEntity;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface TraktvApi {

    String FIELD_TRAKT_ID = "trakt";
    String FIELD_TVDB_ID= "tvdb";
    String FIELD_IMDB_ID = "imdb";
    String FIELD_TMDB_ID = "tmdb";
    String FIELD_TVRAGE_ID = "tvrage";

    @GET("shows/{showId}/seasons/{seasonId}")
    Call<List<EpisodeEntity>> episodes(@Path("showId") String showId, @Path("seasonId") int seasonId);
}
