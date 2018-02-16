package dao;

import model.User;

import java.util.List;

public interface UserDao {

    public User save(User user);

    public void update(User user);

    public User getById(Long id);

    public List getAll();
}
