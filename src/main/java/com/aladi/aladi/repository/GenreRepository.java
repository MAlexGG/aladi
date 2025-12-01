package com.aladi.aladi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aladi.aladi.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
