package com.sloyard.sdjpaintro.bootstrap;

import com.sloyard.sdjpaintro.domain.Book;
import com.sloyard.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({ "local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book bookDDD = new Book(null, "Domain Driven Design", "978-0321125215", "Addison-Wesley");
        Book savedDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book(null, "Software Architecture in Practice", "978-0134494166", "Addison-Wesley");
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book->{
            System.out.println("Book: "+book.getId());
            System.out.println("Title: "+book.getTitle());
        });


    }
}
