package com.danner.controller;

import com.danner.entity.User;
import com.danner.persistence.SessionFactoryProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;



public class UserManager {
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    private final Logger logger = LogManager.getLogger(this.getClass());


    public List<User> getUsers() {
        List<User> users = null;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        users = session.createQuery(
                "select u from User u", User.class).getResultList();
        transaction.commit();
        session.close();
        return users;
    }
}
