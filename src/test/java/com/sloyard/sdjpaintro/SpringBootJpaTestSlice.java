package com.sloyard.sdjpaintro;

import com.sloyard.sdjpaintro.domain.Book;
import com.sloyard.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testJpaTestSlice(){
        long count = bookRepository.count();

        bookRepository.save(new Book(null, "My Book", "978-0321125215", "Self"));

        long countAfter = bookRepository.count();

        assert countAfter > count;
    }
}
