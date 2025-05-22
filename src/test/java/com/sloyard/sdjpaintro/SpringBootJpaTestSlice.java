package com.sloyard.sdjpaintro;

import com.sloyard.sdjpaintro.domain.Book;
import com.sloyard.sdjpaintro.repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = "com.sloyard.sdjpaintro.bootstrap")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    //Commit is to make test2 see the data persisted by test1
    @Commit
    @Order(1)
    @Test
    void testJpaTestSlice(){
        long countBefore = bookRepository.count();
        Assertions.assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book(null, "My Book", "978-0321125215", "Self"));

        long countAfter = bookRepository.count();

        Assertions.assertThat(countAfter).isGreaterThan(countBefore);
    }

    @Order(2)
    @Test
    void testJpaTestSliceTransaction(){
        long countBefore = bookRepository.count();
        Assertions.assertThat(countBefore).isEqualTo(3);


    }
}
