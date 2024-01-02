package com.dyspersja.database.tables.route;

import com.dyspersja.database.tables.TableService;
import org.hibernate.HibernateException;

import java.util.Collections;
import java.util.List;

public class RouteService implements TableService<Route> {

    private final RouteRepository repository;

    public RouteService() {
        repository = new RouteRepository();
    }

    @Override
    public void save(Route route) {
        try {
            repository.save(route);
        } catch (HibernateException e) {}
    }

    @Override
    public Route getById(Long id) {
        try {
            return repository.getById(id);
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public List<Route> getAll() {
        try {
            return repository.getAll();
        } catch (HibernateException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public void update(Route route) {
        try {
            repository.update(route);
        } catch (HibernateException e) {}
    }

    @Override
    public void delete(Long id) {
        try {
            repository.delete(id);
        } catch (HibernateException e) {}
    }
}
