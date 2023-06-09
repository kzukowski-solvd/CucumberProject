package com.solvd.carina.demo.gui.interfaces;

import com.solvd.carina.demo.gui.models.User;

public interface UserMapper {
    User getUserById(int id);
    void insertUser(User user);
}