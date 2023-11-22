package com.dyspersja.database.tables;

import java.util.List;
import java.util.Optional;

public interface TableService<T> {
    void deleteById(int id);
    boolean existsById(int id);
    List<T> findAll();
    Optional<T> findById(int id);
    void save(T entity);
    void update(T entity);
}
