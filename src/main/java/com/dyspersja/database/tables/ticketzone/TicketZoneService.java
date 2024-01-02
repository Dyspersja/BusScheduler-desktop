package com.dyspersja.database.tables.ticketzone;

import com.dyspersja.database.tables.TableService;
import org.hibernate.HibernateException;

import java.util.Collections;
import java.util.List;

public class TicketZoneService implements TableService<TicketZone> {

    private final TicketZoneRepository repository;

    public TicketZoneService() {
        repository = new TicketZoneRepository();
    }

    @Override
    public void save(TicketZone ticketZone) {
        try {
            repository.save(ticketZone);
        } catch (HibernateException e) {}
    }

    @Override
    public TicketZone getById(Long id) {
        try {
            return repository.getById(id);
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public List<TicketZone> getAll() {
        try {
            return repository.getAll();
        } catch (HibernateException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public void update(TicketZone ticketZone) {
        try {
            repository.update(ticketZone);
        } catch (HibernateException e) {}
    }

    @Override
    public void delete(Long id) {
        try {
            repository.delete(id);
        } catch (HibernateException e) {}
    }
}
