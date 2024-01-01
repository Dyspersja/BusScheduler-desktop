package com.dyspersja.database.tables;

import org.hibernate.HibernateException;

import java.util.List;

public interface TableRepository<T> {
    void save(T entity) throws HibernateException;
    T getById(Long id) throws HibernateException;
    List<T> getAll() throws HibernateException;
    void update(T entity) throws HibernateException;
    void delete(Long id) throws HibernateException;
}
