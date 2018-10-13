package com.danner.persistence;

import com.danner.entity.Vocalization;
import com.danner.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class VocalizationDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public int addVocalization(Vocalization vocalization) {
        int vocalizationID = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        vocalizationID = (int)session.save(vocalization);
        transaction.commit();
        session.close();
        return vocalizationID;
    }

    public Vocalization getVocalizationByID(int vocalizationID) {
        Session session = sessionFactory.openSession();
        Vocalization vocalization = session.get(Vocalization.class, vocalizationID);
        session.close();
        return vocalization;
    }


    public void deleteVocalization(Vocalization vocalization)  {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(vocalization);
        transaction.commit();
        session.close();
    }
}
