package com.github.rodrigohenriques.mvp.sample.data.api;

import com.github.rodrigohenriques.mvp.sample.data.entities.EpisodeEntity;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface TraktvApi {
    @GET("shows/{showId}/seasons/{seasonId}")
    Call<List<EpisodeEntity>> episodes(@Path("showId") String showId, @Path("seasonId") int seasonId);
}
