package com.aladi.aladi.service;

import com.aladi.aladi.entity.Genre;

public interface GenreService {

    public Genre findOrCreateByName(String name);

}
