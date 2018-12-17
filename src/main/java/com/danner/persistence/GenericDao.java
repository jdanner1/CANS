package com.danner.persistence;

import com.danner.entity.User;
import com.danner.entity.Vocalization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

/**
 * The type Generic dao.
 * @author jdanner
 *
 * @param <T> the type parameter
 */
public class GenericDao<T> {

    private Class<T> type;

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the type
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    private Session getSession()  {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Gets entity by id.
     *
     * @param <T> the type parameter
     * @param id  the id
     * @return the entity by id
     */
    public <T>T getEntityByID(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Delete entity.
     *
     * @param entity the entity
     */
    public void deleteEntity(T entity)  {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }


    /**
     * Add entity int.
     *
     * @param entity the entity
     * @return the int
     */
    public int addEntity(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Update entity.
     *
     * @param entity the entity
     */
    public void updateEntity(T entity)  {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }
}
