package com.dyspersja.database;

import com.dyspersja.model.*;
import com.dyspersja.properties.PropertiesLoader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DatabaseSessionManager {

    private static DatabaseSessionManager instance;
    private final SessionFactory sessionFactory;

    private DatabaseSessionManager() {
        Configuration configuration = new Configuration();
        var propertiesLoader = PropertiesLoader.getInstance();

        Properties properties = new Properties();
        properties.put(Environment.URL, propertiesLoader.getDatabaseUrl());
        properties.put(Environment.USER, propertiesLoader.getDatabaseUsername());
        properties.put(Environment.PASS, propertiesLoader.getDatabasePassword());

        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "none");

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(BusLine.class);
        configuration.addAnnotatedClass(BusStop.class);
        configuration.addAnnotatedClass(CityDistrict.class);
        configuration.addAnnotatedClass(LineStop.class);
        configuration.addAnnotatedClass(Route.class);
        configuration.addAnnotatedClass(TicketZone.class);

        this.sessionFactory = configuration.buildSessionFactory();
    }

    public static DatabaseSessionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseSessionManager();
        }
        return instance;
    }

    public void closeSessionFactory() {
        if (sessionFactory!=null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }

    public Session getNewSession() {
        return sessionFactory.openSession();
    }
}
