package com.sloyard.sdjpaintro.repositories;

import com.sloyard.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
