package com.aladi.aladi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aladi.aladi.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
