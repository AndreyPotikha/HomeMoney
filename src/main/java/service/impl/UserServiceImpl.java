package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.Income;
import model.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    public User save(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.save(user);
    }

    public void update(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.update(user);
    }

    public User getById(Long id) {
        UserDao userDao = new UserDaoImpl();
        return userDao.getById(id);
    }

    public List<User> getAll() {
        UserDao userDao = new UserDaoImpl();
        return userDao.getAll();
    }

}
