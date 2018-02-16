package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {

    private static SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure(new File("/home/andrey/IdeaProjects/HomeMoney/src/main/resources/hibernate.cfg.xml")).buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("Initialize session factory creation failed. " + e);
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdownSessionFactory() {
        getSessionFactory().close();
    }
}
