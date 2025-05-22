package br.com.api.henriquelivros.controller;

import br.com.api.henriquelivros.model.dto.BookDTO;
import br.com.api.henriquelivros.model.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class BookController
{
    private List<Book> books = new ArrayList<>();

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Book> handleInvalidUUID(MethodArgumentTypeMismatchException ex) {
        if (ex.getRequiredType() == UUID.class) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/livros")
    public List<Book> findAllBooks() {
        return this.books;
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable UUID id) {
        return books.stream()
                .filter(book -> book.getUuid().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/livros")
    public Book saveBook(@RequestBody String title) {
        BookDTO bookDTO = new BookDTO(title);

        Book newBook = new Book(UUID.randomUUID(), bookDTO.title());
        books.add(newBook);

        return newBook;
    }
}
