package com.github.rodrigohenriques.mvp.sample.domain.repository;

import com.github.rodrigohenriques.mvp.sample.domain.entities.Season;

public interface SeasonRepository extends Repository {
    Season retrieve(String serie, int seasonNumber);
}
