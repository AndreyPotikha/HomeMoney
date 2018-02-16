package dao.impl;

import dao.UserDao;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.UserService;
import service.impl.UserServiceImpl;
import util.HibernateUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private final String getAllSql = "FROM User";

    public User save(User user) {
        Session session = getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        List<User> all = getAll();
        for (User elem : all) {
            if (elem.getEmail().equals(user.getEmail())) {
                return elem;
            }
        }
        return null;
    }

    public void update(User user) {
        Session session = getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public User getById(Long id) {
        Session session = getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        User user = session.load(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

    public List<User> getAll() {
        Session session = getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List users = session.createQuery(getAllSql).list();
        transaction.commit();
        session.close();
        return users;
    }

    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setEmail("ememe.com");
        user.setId(27);
        user.setPassword("55555");
        userService.update(user);
    }
}
