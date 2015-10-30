package com.github.rodrigohenriques.mvp.sample.domain.interactor;

public class AbstractUseCase {
    protected UiThreadExecutor mUiThreadExecutor;
    protected Thread mProcess;

    public AbstractUseCase(UiThreadExecutor mUiThreadExecutor) {
        this.mUiThreadExecutor = mUiThreadExecutor;
    }

    protected void executeAsync(Runnable runnable) {
        mProcess = new Thread(runnable);
        mProcess.start();
    }
}
