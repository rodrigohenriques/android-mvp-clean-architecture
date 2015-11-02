package com.github.rodrigohenriques.mvp.sample.domain.entities;

public class EpisodeDetail extends Episode {

    private String runtime;
    private String plot;

    public EpisodeDetail(int season, int number, String title) {
        super(season, number, title);
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
