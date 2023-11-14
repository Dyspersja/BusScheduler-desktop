package com.dyspersja.database.tables;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface TableRepository<T> {
    void deleteById(int id) throws SQLException;
    boolean existsById(int id) throws SQLException;
    List<T> findAll() throws SQLException;
    Optional<T> findById(int id) throws SQLException;
    void save(T entity) throws SQLException;
    void update(T entity) throws SQLException;
}
