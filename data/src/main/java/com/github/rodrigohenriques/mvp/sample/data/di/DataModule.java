package com.github.rodrigohenriques.mvp.sample.data.di;

import com.github.rodrigohenriques.mvp.sample.data.api.OmdbApi;
import com.github.rodrigohenriques.mvp.sample.data.api.TraktvApi;
import com.github.rodrigohenriques.mvp.sample.data.entities.EpisodeDetailJsonMarshaller;
import com.github.rodrigohenriques.mvp.sample.data.entities.Marshaller;
import com.github.rodrigohenriques.mvp.sample.data.remote.FakeSeasonRepository;
import com.github.rodrigohenriques.mvp.sample.data.remote.RemoteEpisodeRepository;
import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;
import com.github.rodrigohenriques.mvp.sample.domain.repository.EpisodeRepository;
import com.github.rodrigohenriques.mvp.sample.domain.repository.SeasonRepository;

import dagger.Module;
import dagger.Provides;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

@Module
public class DataModule {
    public static final String TRAKTV_API_URL = "https://api-v2launch.trakt.tv/";

    @Provides
    public TraktvApi provideTraktvApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TRAKTV_API_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        retrofit.client().interceptors().add(new TraktvApiInterceptor());

        return retrofit.create(TraktvApi.class);
    }

    @Provides
    public OmdbApi provideOmdbApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(OmdbApi.class);
    }

    @Provides
    public EpisodeRepository provideEpisodeRepository(RemoteEpisodeRepository remoteEpisodeRepository) {
        return remoteEpisodeRepository;
    }

    @Provides
    public SeasonRepository provideSeasonRepository(FakeSeasonRepository fakeSeasonRepository) {
        return fakeSeasonRepository;
    }

    @Provides
    public Marshaller<EpisodeDetail, String> provideEpisodeDetailMarshaller(EpisodeDetailJsonMarshaller episodeDetailJsonMarshaller) {
        return episodeDetailJsonMarshaller;
    }
}
