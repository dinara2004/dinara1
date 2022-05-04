package peaksoft.repositories;

import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DatabaseConnection;

public class VendorRepository implements AutoCloseable{

    private final EntityManagerFactory entityManagerFactory
            = DatabaseConnection.createEntityManagerFactory();

    
    @Override
    public void close() throws Exception {

    }
}
