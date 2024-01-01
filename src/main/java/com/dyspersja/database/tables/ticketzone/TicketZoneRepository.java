package com.dyspersja.database.tables.ticketzone;

import com.dyspersja.database.DatabaseSessionManager;
import com.dyspersja.database.tables.TableRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketZoneRepository implements TableRepository<TicketZone> {

    private final DatabaseSessionManager sessionManager;

    public TicketZoneRepository() {
        sessionManager = DatabaseSessionManager.getInstance();
    }

    @Override
    public void save(TicketZone ticketZone) throws HibernateException {
        try (Session session = sessionManager.getNewSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticketZone);
            transaction.commit();
        }
    }

    @Override
    public TicketZone getById(Long id) throws HibernateException {
        try (Session session = sessionManager.getNewSession()) {
            return session.get(TicketZone.class, id);
        }
    }

    @Override
    public List<TicketZone> getAll() throws HibernateException {
        try (Session session = sessionManager.getNewSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<TicketZone> query = builder.createQuery(TicketZone.class);
            Root<TicketZone> root = query.from(TicketZone.class);
            query.select(root);
            return session.createQuery(query).getResultList();
        }
    }

    @Override
    public void update(TicketZone ticketZone) throws HibernateException {
        try (Session session = sessionManager.getNewSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(ticketZone);
            transaction.commit();
        }
    }

    @Override
    public void delete(Long id) throws HibernateException {
        try (Session session = sessionManager.getNewSession()) {
            Transaction transaction = session.beginTransaction();
            TicketZone ticketZone = session.get(TicketZone.class, id);
            if (ticketZone != null) {
                session.remove(ticketZone);
                transaction.commit();
            }
        }
    }
}
