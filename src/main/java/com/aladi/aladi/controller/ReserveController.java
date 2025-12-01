package com.aladi.aladi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aladi.aladi.entity.Reserve;
import com.aladi.aladi.service.ReserveService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/reserves")
public class ReserveController {

    private final ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @PostMapping("/{userId}/{bookId}")
    public ResponseEntity<Reserve> creatReserve(@RequestBody Reserve reserve, @PathVariable Long userId, @PathVariable Long bookId) {
        return new ResponseEntity<>(reserveService.saveReserve(reserve, userId, bookId), HttpStatus.CREATED);
    }
    

}
