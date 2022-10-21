package com.as.servise;

import com.as.model.User;

import java.util.List;

public interface UserServise {
    User getUserById(long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(long id, User updateUser);

    void removeUserById(long id);
}
