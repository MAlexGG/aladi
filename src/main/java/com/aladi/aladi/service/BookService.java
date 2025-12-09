package com.aladi.aladi.service;

import java.util.List;

import com.aladi.aladi.entity.Book;

public interface BookService {

    public Book createBook(Book book, String editorial);
    public Book getBookById(Long id);
    public List<Book> getAllBooksByEditorial(String editorialName);

}
