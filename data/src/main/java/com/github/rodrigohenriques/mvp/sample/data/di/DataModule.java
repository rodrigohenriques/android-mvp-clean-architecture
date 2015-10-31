package com.github.rodrigohenriques.mvp.sample.data.di;

import android.app.Application;

import com.github.rodrigohenriques.mvp.sample.data.api.OmdbApi;
import com.github.rodrigohenriques.mvp.sample.data.api.TraktvApi;
import com.github.rodrigohenriques.mvp.sample.data.remote.FakeSeasonRepository;
import com.github.rodrigohenriques.mvp.sample.data.remote.RemoteEpisodeRepository;
import com.github.rodrigohenriques.mvp.sample.domain.repository.EpisodeRepository;
import com.github.rodrigohenriques.mvp.sample.domain.repository.SeasonRepository;
import com.google.inject.AbstractModule;

public class DataModule extends AbstractModule {

    private final Application application;

    public DataModule(Application application) {
        this.application = application;
    }

    @Override
    protected void configure() {
        bind(TraktvApi.class).toProvider(new TraktvApiProvider());
        bind(OmdbApi.class).toProvider(new OmdbApiProvider());
        bind(EpisodeRepository.class).to(RemoteEpisodeRepository.class);
        bind(SeasonRepository.class).to(FakeSeasonRepository.class);
    }
}
