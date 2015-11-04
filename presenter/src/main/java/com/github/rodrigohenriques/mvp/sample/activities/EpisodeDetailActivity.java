package com.github.rodrigohenriques.mvp.sample.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.github.rodrigohenriques.mvp.sample.R;
import com.github.rodrigohenriques.mvp.sample.data.entities.Marshaller;
import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;
import com.google.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectExtra;

public class EpisodeDetailActivity extends RoboActionBarActivity {

    public static final String SERIALIZED_EPISODE_DETAIL = "extra-episode-detail";

    @Inject Marshaller<EpisodeDetail, String> mEpisodeDetailStringMarshaller;

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.textview_runtime) TextView mTextViewRuntime;
    @Bind(R.id.textview_plot) TextView mTextViewPlot;

    @InjectExtra(SERIALIZED_EPISODE_DETAIL) String mSerializedEpisodeDetail;

    EpisodeDetail episodeDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_detail);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setHomeButtonEnabled(true);

        episodeDetail = mEpisodeDetailStringMarshaller.unmarshal(mSerializedEpisodeDetail);

        if (episodeDetail != null) {
            setTitle(episodeDetail.getTitle());
            mTextViewRuntime.setText(episodeDetail.getRuntime());
            mTextViewPlot.setText(episodeDetail.getPlot());
        }
    }
}
