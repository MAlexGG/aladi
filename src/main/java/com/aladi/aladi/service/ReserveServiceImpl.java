package com.aladi.aladi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aladi.aladi.entity.Book;
import com.aladi.aladi.entity.Reserve;
import com.aladi.aladi.entity.User;
import com.aladi.aladi.repository.ReserveRepository;

@Service
public class ReserveServiceImpl implements ReserveService {
    
    private final ReserveRepository reserveRepository;
    private final UserService userService;
    private final BookService bookService;

    public ReserveServiceImpl(ReserveRepository reserveRepository, UserService userService, BookService bookService) {
        this.reserveRepository = reserveRepository;
        this.userService = userService;
        this.bookService = bookService;
    }

    @Override
    public Reserve saveReserve(Reserve reserve, Long userId, Long bookId){
        User user = userService.getUserById(userId);
        reserve.getUsers().add(user);   

        Book book = bookService.getBookById(bookId);
        reserve.getBooks().add(book);

        LocalDate returnDate = LocalDate.now().plusDays(30);
        reserve.setReturnDate(returnDate);

        return reserveRepository.save(reserve);
    }

    @Override
    public List<Reserve> getReservesByUser(Long userId) {
        List<Reserve> reserves = reserveRepository.findByUsers_Id(userId);
        if(reserves.isEmpty()) {
            throw new RuntimeException("No se han encontrado reservas para el usuario con id: " + userId);
        }
        return reserves;    
    }

}
