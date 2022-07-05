package com.movieRate.repositories;

import com.movieRate.entities.Movie;
import com.movieRate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}