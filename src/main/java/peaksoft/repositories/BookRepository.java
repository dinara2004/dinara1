package peaksoft.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DatabaseConnection;
import peaksoft.models.Book;

import java.util.List;

public class BookRepository implements AutoCloseable {

    private final EntityManagerFactory entityManagerFactory
            = DatabaseConnection.createEntityManagerFactory();

    public void save(Book newBook) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newBook);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Book> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Book> books = entityManager.createQuery("select b from Book b", Book.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return books;
    }
    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
