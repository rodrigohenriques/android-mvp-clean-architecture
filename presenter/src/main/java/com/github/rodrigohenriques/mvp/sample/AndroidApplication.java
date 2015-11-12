package com.github.rodrigohenriques.mvp.sample;

import android.app.Application;

import com.github.rodrigohenriques.mvp.sample.data.di.DataModule;
import com.github.rodrigohenriques.mvp.sample.di.ApplicationComponent;
import com.github.rodrigohenriques.mvp.sample.di.DaggerApplicationComponent;
import com.github.rodrigohenriques.mvp.sample.di.PresenterModule;

public class AndroidApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .presenterModule(new PresenterModule(this))
                .dataModule(new DataModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
