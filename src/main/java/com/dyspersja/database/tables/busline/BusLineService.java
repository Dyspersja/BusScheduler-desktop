package com.dyspersja.database.tables.busline;

import com.dyspersja.database.tables.TableService;
import org.hibernate.HibernateException;

import java.util.Collections;
import java.util.List;

public class BusLineService implements TableService<BusLine> {

    private final BusLineRepository repository;

    public BusLineService() {
        repository = new BusLineRepository();
    }

    @Override
    public void save(BusLine busLine) {
        try {
            repository.save(busLine);
        } catch (HibernateException e) {}
    }

    @Override
    public BusLine getById(Long id) {
        try {
            return repository.getById(id);
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public List<BusLine> getAll() {
        try {
            return repository.getAll();
        } catch (HibernateException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public void update(BusLine busLine) {
        try {
            repository.update(busLine);
        } catch (HibernateException e) {}
    }

    @Override
    public void delete(Long id) {
        try {
            repository.delete(id);
        } catch (HibernateException e) {}
    }
}
