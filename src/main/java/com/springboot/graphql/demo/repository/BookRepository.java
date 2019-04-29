package com.springboot.graphql.demo.repository;

import com.springboot.graphql.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
