package com.springboot.graphql.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.springboot.graphql.demo.model.Author;
import com.springboot.graphql.demo.model.Book;
import com.springboot.graphql.demo.repository.AuthorRepository;
import com.springboot.graphql.demo.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        bookRepository.save(book);
        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookIsbn(String isbn, Long id) throws Exception {
        Optional<Book> obook = bookRepository.findById(id);
        if (!obook.isPresent()) {
            throw new Exception("The book to be updated was found " + id);
        }
        Book book = obook.get();
        book.setIsbn(isbn);
        bookRepository.save(book);
        return book;
    }
}
