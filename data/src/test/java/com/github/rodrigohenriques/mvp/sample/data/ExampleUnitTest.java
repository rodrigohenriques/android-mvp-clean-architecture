package com.github.rodrigohenriques.mvp.sample.data;

import com.github.rodrigohenriques.mvp.sample.data.api.OmdbApi;
import com.github.rodrigohenriques.mvp.sample.data.di.OmdbApiProvider;
import com.github.rodrigohenriques.mvp.sample.data.entities.EpisodeOmdbEntity;

import org.junit.Test;

import retrofit.Call;
import retrofit.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void testFindEpisodeInfoByImdbId() throws Exception {
        OmdbApi omdbApi = new OmdbApiProvider().get();

        Call<EpisodeOmdbEntity> call = omdbApi.findEpisodeInfoByImdbId("tt1480055");

        Response<EpisodeOmdbEntity> response = call.execute();

        assertTrue(response.isSuccess());

        EpisodeOmdbEntity episodeOmdbEntity = response.body();

        assertThat(episodeOmdbEntity.getTitle(), is("Winter Is Coming"));
    }
}