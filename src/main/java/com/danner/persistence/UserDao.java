package com.danner.persistence;

import com.danner.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public int addUser(User user) {
        int userID = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        userID = (int)session.save(user);
        transaction.commit();
        session.close();
        return userID;
    }

    public User getUserByID(int userID) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userID);
        session.close();
        return user;
    }

    public void updateUser(User user)  {
        user.setModifyDate(LocalDate.now());
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    public void deleteUser(User user)  {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
