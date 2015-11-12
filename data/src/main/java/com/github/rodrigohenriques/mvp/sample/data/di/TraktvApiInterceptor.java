package com.github.rodrigohenriques.mvp.sample.data.di;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class TraktvApiInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        request = request.newBuilder()
                .addHeader("trakt-api-version", "2")
                .addHeader("trakt-api-key", "4122c40ed43a1f9a8f015538f4b6a80c8ef4e76601b91576982820d955df3f9f")
                .build();

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
