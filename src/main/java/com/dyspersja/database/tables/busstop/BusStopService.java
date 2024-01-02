package com.dyspersja.database.tables.busstop;

import com.dyspersja.database.tables.TableService;
import org.hibernate.HibernateException;

import java.util.Collections;
import java.util.List;

public class BusStopService implements TableService<BusStop> {

    private final BusStopRepository repository;

    public BusStopService() {
        repository = new BusStopRepository();
    }

    @Override
    public void save(BusStop busStop) {
        try {
            repository.save(busStop);
        } catch (HibernateException e) {}
    }

    @Override
    public BusStop getById(Long id) {
        try {
            return repository.getById(id);
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public List<BusStop> getAll() {
        try {
            return repository.getAll();
        } catch (HibernateException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public void update(BusStop busStop) {
        try {
            repository.update(busStop);
        } catch (HibernateException e) {}
    }

    @Override
    public void delete(Long id) {
        try {
            repository.delete(id);
        } catch (HibernateException e) {}
    }
}
