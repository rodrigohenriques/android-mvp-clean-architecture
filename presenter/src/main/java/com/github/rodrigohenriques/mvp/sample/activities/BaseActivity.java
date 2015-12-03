package com.github.rodrigohenriques.mvp.sample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.rodrigohenriques.mvp.sample.AndroidApplication;
import com.github.rodrigohenriques.mvp.sample.di.ApplicationComponent;

public class BaseActivity extends AppCompatActivity {

    ApplicationComponent mApplicationComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApplicationComponent =  ((AndroidApplication) getApplication()).getApplicationComponent();
        mApplicationComponent.inject(this);
    }
}
