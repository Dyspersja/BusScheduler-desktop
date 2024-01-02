package com.dyspersja.database.tables.linestop;

import com.dyspersja.database.tables.TableService;
import org.hibernate.HibernateException;

import java.util.Collections;
import java.util.List;

public class LineStopService implements TableService<LineStop> {

    private final LineStopRepository repository;

    public LineStopService() {
        repository = new LineStopRepository();
    }

    @Override
    public void save(LineStop lineStop) {
        try {
            repository.save(lineStop);
        } catch (HibernateException e) {}
    }

    @Override
    public LineStop getById(Long id) {
        try {
            return repository.getById(id);
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public List<LineStop> getAll() {
        try {
            return repository.getAll();
        } catch (HibernateException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public void update(LineStop lineStop) {
        try {
            repository.update(lineStop);
        } catch (HibernateException e) {}
    }

    @Override
    public void delete(Long id) {
        try {
            repository.delete(id);
        } catch (HibernateException e) {}
    }
}
