package com.github.rodrigohenriques.mvp.sample.domain.interactor;

public abstract class Callback<T> {
    private UiThreadExecutor mUiThreadExecutor;

    public abstract void onSuccess(T result);
    public abstract void onException(Exception e);

    public void setUiThreadExecutor(UiThreadExecutor uiThreadExecutor) {
        this.mUiThreadExecutor = uiThreadExecutor;
    }

    public void dispatchResult(final T result) {
        if (mUiThreadExecutor != null) {
            mUiThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    onSuccess(result);
                }
            });
        }
    }

    public void dispatchException(final Exception e) {
        if (mUiThreadExecutor != null) {
            mUiThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    onException(e);
                }
            });
        }
    }
}
