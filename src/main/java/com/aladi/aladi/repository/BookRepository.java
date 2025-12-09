package com.aladi.aladi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aladi.aladi.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findAllByEditorial_Name(String editorialName);

}
