package com.aladi.aladi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aladi.aladi.entity.Reserve;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    List<Reserve> findByUsers_Id(Long userId);

}
