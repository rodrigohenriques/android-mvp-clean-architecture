package com.github.rodrigohenriques.mvp.sample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.github.rodrigohenriques.mvp.sample.R;
import com.github.rodrigohenriques.mvp.sample.data.entities.Marshaller;
import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;

import javax.inject.Inject;

import butterknife.Bind;

public class EpisodeDetailActivity extends AppCompatActivity {

    public static final String SERIALIZED_EPISODE_DETAIL = "extra-episode-detail";

    @Inject Marshaller<EpisodeDetail, String> episodeDetailStringMarshaller;

    @Bind(R.id.textview_runtime) TextView textViewRuntime;
    @Bind(R.id.textview_plot) TextView textViewPlot;

    String serializedEpisodeDetail;

    EpisodeDetail episodeDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        serializedEpisodeDetail = getIntent().getStringExtra(SERIALIZED_EPISODE_DETAIL);

        episodeDetail = episodeDetailStringMarshaller.unmarshal(serializedEpisodeDetail);

        if (episodeDetail != null) {
            textViewRuntime.setText(episodeDetail.getRuntime());
            textViewPlot.setText(episodeDetail.getPlot());
        }
    }
}
