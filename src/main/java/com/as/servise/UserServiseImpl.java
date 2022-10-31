package com.as.servise;

import com.as.dao.UserDao;
import com.as.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiseImpl implements UserServise {
    private final UserDao userDAO;

    public UserServiseImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(long id, User updateUser) {
        userDAO.updateUser(id, updateUser);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        userDAO.removeUserById(id);
    }
}
