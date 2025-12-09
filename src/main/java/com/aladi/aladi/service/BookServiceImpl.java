package com.aladi.aladi.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.aladi.aladi.entity.Book;
import com.aladi.aladi.entity.Editorial;
import com.aladi.aladi.entity.Genre;
import com.aladi.aladi.exception.EntityNotCreatedException;
import com.aladi.aladi.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final EditorialService editorialService;
    private final GenreService genreService;

    public BookServiceImpl(BookRepository bookRepository, EditorialService editorialService, GenreService genreService) {
        this.bookRepository = bookRepository;
        this.editorialService = editorialService;
        this.genreService = genreService;
    }

    @Override
    public Book createBook(Book book, String editorial) throws RuntimeException {
        
            Editorial foundEditorial = editorialService.getEditorialByName(editorial);
        if (foundEditorial == null || foundEditorial.getName().isEmpty()) {   
            foundEditorial = editorialService.createEditorialByName(editorial.toLowerCase());
        }
        book.setEditorial(foundEditorial);

        Set<Genre> genres = new HashSet<>(book.getGenres());
        book.getGenres().clear();

        for (Genre genre : genres) {
            Genre foundGenre = genreService.findGenreByName(genre.getName().toLowerCase());
            if(foundGenre == null) {
                foundGenre = genreService.createGenreByName(genre.getName().toLowerCase());
            }
            book.getGenres().add(foundGenre); 
        }
        try {
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new EntityNotCreatedException(Book.class);
        }
        
    }

    @Override
    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Libro con id: " + id + " no encontrado."));
        return book;
    }

}
