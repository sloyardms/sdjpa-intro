package com.sloyard.sdjpaintro.bootstrap;

import com.sloyard.sdjpaintro.domain.Book;
import com.sloyard.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book bookDDD = new Book(null, "Domain Driven Design", "978-0321125215", "Addison-Wesley");

        System.out.println("Id: "+bookDDD.getId());

        Book savedDDD = bookRepository.save(bookDDD);

        System.out.println("Id: "+savedDDD.getId());

        Book bookSIA = new Book(null, "Software Architecture in Practice", "978-0134494166", "Addison-Wesley");

        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book->{
            System.out.println("Book: "+book.getId());
            System.out.println("Title: "+book.getTitle());
        });


    }
}
