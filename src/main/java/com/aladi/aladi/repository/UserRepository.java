package com.aladi.aladi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aladi.aladi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
