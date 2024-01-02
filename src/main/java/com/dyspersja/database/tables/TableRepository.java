package com.dyspersja.database.tables;

import com.dyspersja.database.DatabaseSessionManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TableRepository<T> {

    private final DatabaseSessionManager sessionManager;
    private final Class<T> entityClass;

    public TableRepository(Class<T> entityClass) {
        sessionManager = DatabaseSessionManager.getInstance();
        this.entityClass = entityClass;
    }

    public void save(T entity) throws HibernateException {
        try (Session session = sessionManager.getNewSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    public T getById(Long id) throws HibernateException {
        try (Session session = sessionManager.getNewSession()) {
            return session.get(entityClass, id);
        }
    }

    public List<T> getAll() throws HibernateException {
        try (Session session = sessionManager.getNewSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(entityClass);
            Root<T> root = query.from(entityClass);
            query.select(root);
            return session.createQuery(query).getResultList();
        }
    }

    public void update(T entity) throws HibernateException {
        try (Session session = sessionManager.getNewSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }

    public void delete(Long id) throws HibernateException {
        try (Session session = sessionManager.getNewSession()) {
            Transaction transaction = session.beginTransaction();
            T entity = session.get(entityClass, id);
            if (entity != null) {
                session.remove(entity);
                transaction.commit();
            }
        }
    }
}
