package com.github.rodrigohenriques.mvp.sample.data.di;

import android.util.Log;

import com.github.rodrigohenriques.mvp.sample.data.api.OmdbApi;
import com.google.inject.Provider;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

public class OmdbApiProvider implements Provider<OmdbApi> {
    @Override
    public OmdbApi get() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        retrofit.client().interceptors().add(new LoggingInterceptor());

        return retrofit.create(OmdbApi.class);
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
