package com.dyspersja.database.tables;

import java.util.List;

public interface TableService<T> {
    void save(T entity);
    T getById(Long id);
    List<T> getAll();
    void update(T entity);
    void delete(Long id);
}
