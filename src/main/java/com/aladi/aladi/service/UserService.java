package com.aladi.aladi.service;

import com.aladi.aladi.entity.User;

public interface UserService {

    public User getUserById(Long id);
    public User createUser(User user);

}
