package peaksoft;

import peaksoft.models.Book;
import peaksoft.repositories.BookRepository;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App {


    public static void main( String[] args ) throws Exception {

        BookRepository bookRepository = new BookRepository();

//        Book book = new Book("Toolor kulaganda", "Chyngyz Aitmatov", BigDecimal.valueOf(1000));
//        bookRepository.save(book);
        bookRepository.findAll().forEach(System.out::println);
        bookRepository.close();
    }
}
