package com.sloyard.sdjpaintro;

import com.sloyard.sdjpaintro.repositories.BookRepository;
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

		 assert count > 0;
	}

	@Test
	void contextLoads() {
	}

}
