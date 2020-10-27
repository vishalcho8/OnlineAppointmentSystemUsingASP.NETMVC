package com.online.appointmentt.service;

import com.online.appointmentt.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
