package com.github.rodrigohenriques.mvp.sample.di;

import com.github.rodrigohenriques.mvp.sample.domain.interactor.UiThreadExecutor;
import com.github.rodrigohenriques.mvp.sample.interactor.AndroidUiThreadExecutor;
import com.google.inject.Provider;

public class UiThreadExecutorProvider implements Provider<UiThreadExecutor> {
    @Override
    public UiThreadExecutor get() {
        return new AndroidUiThreadExecutor();
    }
}
