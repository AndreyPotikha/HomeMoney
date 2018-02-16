package service;

import model.User;

import java.util.List;

public interface UserService {

    public User save(User user);

    public void update(User user);

    public User getById(Long id);

    public List getAll();
}
