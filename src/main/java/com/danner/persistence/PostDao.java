package com.danner.persistence;

import com.danner.entity.Post;
import com.danner.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class PostDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public int addPost(Post post) {
        int postID = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        postID = (int)session.save(post);
        transaction.commit();
        session.close();
        return postID;
    }

    public Post getPostByID(int postID) {
        Session session = sessionFactory.openSession();
        Post post = session.get(Post.class, postID);
        session.close();
        return post;
    }

    public void updatePost(Post post)  {
        post.setModifyDate(LocalDate.now());
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(post);
        transaction.commit();
        session.close();
    }

    public void deletePost(Post post)  {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(post);
        transaction.commit();
        session.close();
    }
}
