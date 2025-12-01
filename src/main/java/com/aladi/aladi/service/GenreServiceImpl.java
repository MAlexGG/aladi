package com.aladi.aladi.service;

import org.springframework.stereotype.Service;

import com.aladi.aladi.entity.Genre;
import com.aladi.aladi.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre findGenreByName(String name) {
        return genreRepository.findByName(name.toLowerCase());
    }

    @Override
    public Genre createGenreByName(String name) {
        Genre genre = new Genre();
        genre.setName(name.toLowerCase());
        genre = genreRepository.save(genre);
        return genre;
    }


}
