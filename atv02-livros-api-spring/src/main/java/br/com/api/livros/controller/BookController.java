package br.com.api.livros.controller;

import br.com.api.livros.model.dtos.BookDto;
import br.com.api.livros.model.entities.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BookController
{
    private List<Book> books = new ArrayList<>();

    @GetMapping("/livros")
    public List<Book> findAllBooks() {
        return books;
    }

    @GetMapping("/livros/{id}")
    public Optional<Book> findBookById(@PathVariable UUID id) {
        return books.stream().filter(book -> (book.getId()).equals(id)).findFirst();
    }

    @PostMapping("/livros")
    public Book saveBook(@RequestBody String title) {
        BookDto bookDto = new BookDto(title);
        Book newBook = new Book(UUID.randomUUID(), bookDto.title());

        books.add(newBook);

        return newBook;
    }

    @PutMapping("/livros/{id}")
    public Book updateBook(@PathVariable UUID id, @RequestBody String title) {
        Optional<Book> searchedOptionalBook = books.stream().filter(book -> (book.getId()).equals(id)).findFirst();

        if (searchedOptionalBook.isPresent()) {
            Book bookToUpdate = searchedOptionalBook.get();
            bookToUpdate.setTitle(title);
            return bookToUpdate;
        } else {
            return null;
        }
    }

    @DeleteMapping("livros/{id}")
    public void deleteBook(@PathVariable UUID id) {
        books.removeIf(book -> (book.getId()).equals(id));
    }
}
