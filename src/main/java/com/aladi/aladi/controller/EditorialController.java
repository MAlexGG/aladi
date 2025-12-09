package com.aladi.aladi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aladi.aladi.entity.Book;
import com.aladi.aladi.service.EditorialService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/editorials")
public class EditorialController {

    private final EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping("/{editorialName}")
    public ResponseEntity<List<Book>> getAllBooksByEditorial(@PathVariable String editorialName)
    {   
        List<Book> books = editorialService.getAllBooksByEditorial(editorialName);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    

}
