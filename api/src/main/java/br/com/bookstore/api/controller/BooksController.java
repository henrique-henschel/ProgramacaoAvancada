package br.com.bookstore.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class BooksController {

    private final ArrayList<String> livros = new ArrayList<>();

    @GetMapping("/livros")
    public ArrayList<String> hello() {
        return this.livros;
    }
}
