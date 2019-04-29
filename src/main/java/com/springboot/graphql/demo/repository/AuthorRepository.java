package com.springboot.graphql.demo.repository;

import com.springboot.graphql.demo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
