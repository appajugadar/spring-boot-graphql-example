package com.springboot.graphql.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.springboot.graphql.demo.model.Author;
import com.springboot.graphql.demo.model.Book;
import com.springboot.graphql.demo.repository.AuthorRepository;
import com.springboot.graphql.demo.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
