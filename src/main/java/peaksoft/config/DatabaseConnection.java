package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.models.Book;

import java.util.Properties;

public class DatabaseConnection {

    public static EntityManagerFactory createEntityManagerFactory() {
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/hb_practice");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "java");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Book.class);
        configuration.setProperties(properties);
        return configuration.buildSessionFactory().
                unwrap(EntityManagerFactory.class);
    }
}
