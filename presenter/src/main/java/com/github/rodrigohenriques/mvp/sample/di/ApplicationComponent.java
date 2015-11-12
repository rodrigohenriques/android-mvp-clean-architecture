package com.github.rodrigohenriques.mvp.sample.di;

import android.content.Context;

import com.github.rodrigohenriques.mvp.sample.activities.SeasonActivity;
import com.github.rodrigohenriques.mvp.sample.data.di.DataModule;

import dagger.Component;

@Component(modules = { PresenterModule.class, DataModule.class })
public interface ApplicationComponent {
    void inject(SeasonActivity seasonActivity);

    Context provideContext();
}
