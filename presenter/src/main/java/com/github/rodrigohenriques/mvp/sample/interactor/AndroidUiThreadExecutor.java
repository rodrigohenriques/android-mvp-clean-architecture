package com.github.rodrigohenriques.mvp.sample.interactor;

import android.os.Handler;
import android.os.Looper;

import com.github.rodrigohenriques.mvp.sample.domain.interactor.UiThreadExecutor;
import com.google.inject.Singleton;

@Singleton
public class AndroidUiThreadExecutor implements UiThreadExecutor {
    Handler handler;

    public AndroidUiThreadExecutor() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}
