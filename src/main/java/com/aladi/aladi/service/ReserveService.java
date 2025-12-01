package com.aladi.aladi.service;

import com.aladi.aladi.entity.Reserve;

public interface ReserveService {

    public Reserve saveReserve(Reserve reserve, Long userId, Long bookId);
}
