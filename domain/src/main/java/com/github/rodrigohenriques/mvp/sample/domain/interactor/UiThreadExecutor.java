package com.github.rodrigohenriques.mvp.sample.domain.interactor;

public interface UiThreadExecutor {
    void execute(Runnable runnable);
}
