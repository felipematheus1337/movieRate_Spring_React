package com.movieRate.controllers;

import com.movieRate.dto.MovieDTO;
import com.movieRate.dto.ScoreDTO;
import com.movieRate.services.MovieService;
import com.movieRate.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {


    @Autowired
    private ScoreService service;


    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO) {
        MovieDTO dto = service.saveScore(scoreDTO);
        return dto;
    }





}
