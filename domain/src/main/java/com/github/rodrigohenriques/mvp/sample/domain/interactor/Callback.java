package com.github.rodrigohenriques.mvp.sample.domain.interactor;

public abstract class Callback<Result> {
    private UiThreadExecutor mUiThreadExecutor;

    public abstract void onSuccess(Result result);
    public abstract void onException(Exception e);
    public abstract void onPostExecute();

    public void setUiThreadExecutor(UiThreadExecutor uiThreadExecutor) {
        this.mUiThreadExecutor = uiThreadExecutor;
    }

    protected void dispatchResult(final Result result) {
        if (mUiThreadExecutor != null) {
            mUiThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    onPostExecute();
                    onSuccess(result);
                }
            });
        }
    }

    protected void dispatchException(final Exception e) {
        if (mUiThreadExecutor != null) {
            mUiThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    onPostExecute();
                    onException(e);
                }
            });
        }
    }
}
