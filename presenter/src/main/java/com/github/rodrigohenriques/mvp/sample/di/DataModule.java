package com.github.rodrigohenriques.mvp.sample.di;

import android.app.Application;
import android.util.Log;

import com.github.rodrigohenriques.mvp.sample.data.api.TraktApi;
import com.github.rodrigohenriques.mvp.sample.data.remote.FakeSeasonRepository;
import com.github.rodrigohenriques.mvp.sample.data.remote.RemoteEpisodeRepository;
import com.github.rodrigohenriques.mvp.sample.domain.repository.EpisodeRepository;
import com.github.rodrigohenriques.mvp.sample.domain.repository.SeasonRepository;
import com.google.inject.AbstractModule;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class DataModule extends AbstractModule {

    private final Application application;

    public DataModule(Application application) {
        this.application = application;
    }

    @Override
    protected void configure() {
        bind(TraktApi.class).toInstance(getTraktApiInstance());
        bind(EpisodeRepository.class).to(RemoteEpisodeRepository.class);
        bind(SeasonRepository.class).to(FakeSeasonRepository.class);
    }

    public TraktApi getTraktApiInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-v2launch.trakt.tv/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.client().interceptors().add(new LoggingInterceptor());

        return retrofit.create(TraktApi.class);
    }

    private class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();

            Response response = chain.proceed(request);

            String bodyString = response.body().string();

            Log.d("Retrofit", "---------------------------------- REQUEST ----------------------------------");
            Log.d("Retrofit", String.format("%s - %s", request.method(), request.url()));
            Log.d("Retrofit", request.headers().toString());
            Log.d("Retrofit", "---------------------------------- REQUEST ----------------------------------");
            Log.d("Retrofit", "---------------------------------- RESPONSE ----------------------------------");
            Log.d("Retrofit", response.headers().toString());
            Log.d("Retrofit", "Body: " + bodyString);
            Log.d("Retrofit", "---------------------------------- RESPONSE ----------------------------------");

            return response.newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), bodyString))
                    .build();
        }
    }
}
