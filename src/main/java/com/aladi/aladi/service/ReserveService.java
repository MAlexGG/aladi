package com.aladi.aladi.service;

import java.util.List;

import com.aladi.aladi.entity.Reserve;

public interface ReserveService {

    public Reserve saveReserve(Reserve reserve, Long userId, Long bookId);
    public List<Reserve> getReservesByUser(Long userId);
}
