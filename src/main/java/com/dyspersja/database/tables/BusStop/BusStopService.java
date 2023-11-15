package com.dyspersja.database.tables.BusStop;

import com.dyspersja.database.tables.TableService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BusStopService implements TableService<BusStopEntity> {

    final BusStopRepository repository;

    public BusStopService() {
        repository = new BusStopRepository();
    }

    @Override
    public void deleteById(int id) {
        try {
            repository.deleteById(id);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public boolean existsById(int id) {
        try {
            return repository.existsById(id);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            return false;
        }
    }

    @Override
    public List<BusStopEntity> findAll() {
        try {
            return repository.findAll();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<BusStopEntity> findById(int id) {
        try {
            return repository.findById(id);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            return Optional.empty();
        }
    }

    @Override
    public void save(BusStopEntity entity) {
        try {
            repository.save(entity);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void update(BusStopEntity entity) {
        try {
            if (repository.existsById(entity.getId())) repository.update(entity);
            else System.out.printf("\nbus_stop with id: '%d' does not exist", entity.getId());
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}
