package com.dyspersja.database.tables.citydistrict;

import com.dyspersja.database.tables.TableService;
import org.hibernate.HibernateException;

import java.util.Collections;
import java.util.List;

public class CityDistrictService implements TableService<CityDistrict> {

    private final CityDistrictRepository repository;

    public CityDistrictService() {
        repository = new CityDistrictRepository();
    }

    @Override
    public void save(CityDistrict cityDistrict) {
        try {
            repository.save(cityDistrict);
        } catch (HibernateException e) {}
    }

    @Override
    public CityDistrict getById(Long id) {
        try {
            return repository.getById(id);
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public List<CityDistrict> getAll() {
        try {
            return repository.getAll();
        } catch (HibernateException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public void update(CityDistrict cityDistrict) {
        try {
            repository.update(cityDistrict);
        } catch (HibernateException e) {}
    }

    @Override
    public void delete(Long id) {
        try {
            repository.delete(id);
        } catch (HibernateException e) {}
    }
}
