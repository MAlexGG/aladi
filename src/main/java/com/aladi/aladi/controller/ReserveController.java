package com.aladi.aladi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aladi.aladi.entity.Reserve;
import com.aladi.aladi.service.ReserveService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/reserves")
public class ReserveController {

    private final ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @PostMapping("/user/{userId}/book/{bookId}")
    public ResponseEntity<Reserve> createReserve(@RequestBody Reserve reserve, @PathVariable Long userId, @PathVariable Long bookId) {
        return new ResponseEntity<>(reserveService.saveReserve(reserve, userId, bookId), HttpStatus.CREATED);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reserve>> getReservesByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(reserveService.getReservesByUser(userId), HttpStatus.OK);
    }
    

}
