package com.aladi.aladi.service;

import org.springframework.stereotype.Service;

import com.aladi.aladi.entity.Book;
import com.aladi.aladi.entity.Editorial;
import com.aladi.aladi.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final EditorialService editorialService;

    public BookServiceImpl(BookRepository bookRepository, EditorialService editorialService) {
        this.bookRepository = bookRepository;
        this.editorialService = editorialService;
    }

    @Override
    public Book createBook(Book book, String editorial) {
        Editorial foundEditorial = editorialService.findOrCreateEditorialByName(editorial.toLowerCase());
        book.setEditorial(foundEditorial);
        return bookRepository.save(book);
    }

}
