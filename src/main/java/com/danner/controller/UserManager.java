package com.danner.controller;

import com.danner.entity.User;
import com.danner.entity.Vocalization;
import com.danner.persistence.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 * The type User manager.
 * @author jdanner
 */
public class UserManager {
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Gets users.
     *
     * @return the users
     */
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

    /**
     * Gets vocalizations.
     *
     * @return the vocalizations
     */
    public List<Vocalization> getVocalizations() {
        List<Vocalization> vocalization = null;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        vocalization = session.createQuery(
                "select v from Vocalization v", Vocalization.class).getResultList();
        transaction.commit();
        session.close();
        return vocalization;
    }
}
