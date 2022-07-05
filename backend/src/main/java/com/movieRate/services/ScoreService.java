package com.movieRate.services;

import com.movieRate.dto.MovieDTO;
import com.movieRate.dto.ScoreDTO;
import com.movieRate.entities.Movie;
import com.movieRate.entities.Score;
import com.movieRate.entities.User;
import com.movieRate.repositories.MovieRepository;
import com.movieRate.repositories.ScoreRepository;
import com.movieRate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {


    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;


    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail());
        if(user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();

        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        scoreRepository.saveAndFlush(score);


        double sum = 0.0;

        for (Score s: movie.getScores()) {
          sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();



        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);

    }







}