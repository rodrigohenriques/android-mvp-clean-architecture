package com.github.rodrigohenriques.mvp.sample.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.github.rodrigohenriques.mvp.sample.R;
import com.github.rodrigohenriques.mvp.sample.data.entities.Marshaller;
import com.github.rodrigohenriques.mvp.sample.domain.entities.EpisodeDetail;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EpisodeDetailActivity extends BaseActivity {

    public static final String SERIALIZED_EPISODE_DETAIL = "extra-episode-detail";

    @Inject Marshaller<EpisodeDetail, String> mEpisodeDetailStringMarshaller;

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.textview_runtime) TextView mTextViewRuntime;
    @Bind(R.id.textview_plot) TextView mTextViewPlot;

    String serializedEpisodeDetail;

    EpisodeDetail episodeDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_detail);

        ButterKnife.bind(this);
        mApplicationComponent.inject(this);

        serializedEpisodeDetail = getIntent().getStringExtra(SERIALIZED_EPISODE_DETAIL);

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
