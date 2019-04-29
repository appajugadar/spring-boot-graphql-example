package com.springboot.graphql.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.springboot.graphql.demo.model.Author;
import com.springboot.graphql.demo.model.Book;
import com.springboot.graphql.demo.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).get();
    }
}
