package dao.impl;

import dao.UserDao;
import model.Income;
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

    public Income saveIncome(Income income) {
        Session session = getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.save(income);
        transaction.commit();
        session.close();
        Session session2 = getSession();
        Transaction transaction2 = null;
        transaction2 = session2.beginTransaction();
        List from_incomes = session2.createQuery("FROM incomes").list();
        transaction.commit();
        session.close();
        for (Object elem : from_incomes) {
            System.out.println(elem);
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

        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setEmail("test3.com");
        user.setPassword("3333");
        Income income = new Income();
        income.setMain_income("work3");
        income.setAdditionalIncome("free3");
        user.getIncomes().add(income);
        userDao.save(user);
    }
}
