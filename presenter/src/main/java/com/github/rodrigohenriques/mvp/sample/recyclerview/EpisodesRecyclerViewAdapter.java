package com.github.rodrigohenriques.mvp.sample.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.rodrigohenriques.mvp.sample.R;
import com.github.rodrigohenriques.mvp.sample.domain.entities.Episode;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class EpisodesRecyclerViewAdapter extends RecyclerView.Adapter<EpisodesRecyclerViewAdapter.ViewHolder> {

    TypedValue typedValue = new TypedValue();

    Context context;
    List<Episode> episodes;

    OnItemClickListener onItemClickListener;

    public EpisodesRecyclerViewAdapter(Context context, List<Episode> episodes) {
        this.context = context;
        this.episodes = episodes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.episode_item, parent, false);
        view.setBackgroundResource(typedValue.resourceId);
        return new ViewHolder(view);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        final Episode episode = episodes.get(position);

        holder.textViewNumber.setText(episode.getNumberPrettyPrint());
        holder.textViewTitle.setText(episode.getTitle());
        holder.view.setBackgroundResource(R.drawable.btn_flat_selector);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(episode);
            }
        });
    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final View view;

        @Bind(R.id.episode_number) TextView textViewNumber;
        @Bind(R.id.episode_title) TextView textViewTitle;

        public ViewHolder(View view) {
            super(view);
            this.view = view;

            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Episode episode);
    }
}
