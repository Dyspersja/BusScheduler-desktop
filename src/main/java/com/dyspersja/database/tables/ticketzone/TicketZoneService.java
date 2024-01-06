package com.dyspersja.database.tables.ticketzone;

import com.dyspersja.database.tables.TableService;
import com.dyspersja.window.OperationService;
import org.hibernate.HibernateException;

import java.util.Collections;
import java.util.List;

public class TicketZoneService implements TableService<TicketZone> {

    private final TicketZoneRepository repository;
    private final OperationService operationService;

    public TicketZoneService() {
        repository = new TicketZoneRepository();
        operationService = OperationService.getInstance();
    }

    @Override
    public void save(TicketZone ticketZone) {
        operationService.performOperation("added record to ticket_zone table");
        try {
            repository.save(ticketZone);
        } catch (HibernateException e) {}
    }

    @Override
    public TicketZone getById(Long id) {
        operationService.performOperation("retrieved single record from ticket_zone table");
        try {
            return repository.getById(id);
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public List<TicketZone> getAll() {
        operationService.performOperation("retrieved all records from ticket_zone table");
        try {
            return repository.getAll();
        } catch (HibernateException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public void update(TicketZone ticketZone) {
        operationService.performOperation("updated record from ticket_zone table");
        try {
            repository.update(ticketZone);
        } catch (HibernateException e) {}
    }

    @Override
    public void delete(Long id) {
        operationService.performOperation("deleted record from ticket_zone table");
        try {
            repository.delete(id);
        } catch (HibernateException e) {}
    }
}
