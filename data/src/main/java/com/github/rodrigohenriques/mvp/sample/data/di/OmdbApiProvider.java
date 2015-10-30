package com.github.rodrigohenriques.mvp.sample.data.di;

import com.github.rodrigohenriques.mvp.sample.data.api.OmdbApi;
import com.google.inject.Provider;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class OmdbApiProvider implements Provider<OmdbApi> {
    @Override
    public OmdbApi get() {
        return new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OmdbApi.class);
    }
}
