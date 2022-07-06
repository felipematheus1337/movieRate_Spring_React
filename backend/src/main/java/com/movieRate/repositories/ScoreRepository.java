package com.movieRate.repositories;

import com.movieRate.entities.Score;
import com.movieRate.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {



}
