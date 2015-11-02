package com.github.rodrigohenriques.mvp.sample.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.github.rodrigohenriques.mvp.sample.R;
import com.github.rodrigohenriques.mvp.sample.data.entities.Marshaller;
import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;
import com.google.inject.Inject;

import butterknife.Bind;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectExtra;

public class EpisodeDetailActivity extends RoboActionBarActivity {

    public static final String SERIALIZED_EPISODE_DETAIL = "extra-episode-detail";

    @Inject Marshaller<EpisodeDetail, String> episodeDetailStringMarshaller;

    @Bind(R.id.textview_runtime) TextView textViewRuntime;
    @Bind(R.id.textview_plot) TextView textViewPlot;

    @InjectExtra(SERIALIZED_EPISODE_DETAIL) String serializedEpisodeDetail;

    EpisodeDetail episodeDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        episodeDetail = episodeDetailStringMarshaller.unmarshal(serializedEpisodeDetail);

        if (episodeDetail != null) {
            textViewRuntime.setText(episodeDetail.getRuntime());
            textViewPlot.setText(episodeDetail.getPlot());
        }
    }

}
