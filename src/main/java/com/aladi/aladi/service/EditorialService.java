package com.aladi.aladi.service;

import java.util.List;

import com.aladi.aladi.entity.Book;
import com.aladi.aladi.entity.Editorial;

public interface EditorialService {

    public Editorial getEditorialByName(String name);
    public Editorial createEditorialByName(String name);
    public List<Book> getAllBooksByEditorial(String name);

}
