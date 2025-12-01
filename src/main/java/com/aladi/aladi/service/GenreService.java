package com.aladi.aladi.service;

import com.aladi.aladi.entity.Genre;

public interface GenreService {

    public Genre findGenreByName(String name);
    public Genre createGenreByName(String name);

}
