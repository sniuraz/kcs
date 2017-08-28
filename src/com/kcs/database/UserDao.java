package com.kcs.database;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

public class UserDao {

    public void addUser(User user) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if(trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteUser(int userId) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            User user = session.load(User.class, userId);
            session.delete(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if(trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateUser(User user) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if(trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            users = session.createQuery("FROM User ").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }

    public List<User> getUsersByName(String name) {
        List<User> users = new ArrayList<User>();
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE firstName = :name");
            query.setParameter("name", name);
            users = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }

    public User getUserById(int userId) {
        User user = null;
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE id = :id");
            query.setInteger("id", userId);
            user = (User) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }
    
    public User validateUserCredentials(String username, String password) {
        User user = null;
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE uname = :uname AND pass = :pass");
            query.setParameter("uname", username);
            query.setParameter("pass", password);
            user = (User) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }
    
}