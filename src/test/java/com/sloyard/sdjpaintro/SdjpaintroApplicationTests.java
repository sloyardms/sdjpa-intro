package com.sloyard.sdjpaintro;

import com.sloyard.sdjpaintro.repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SdjpaintroApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	void testBookRepository() {
	 	long count = bookRepository.count();

		Assertions.assertThat(count).isGreaterThan(0);
	}

	@Test
	void contextLoads() {
	}

}
