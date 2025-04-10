package com.unicesumar.service;

import com.unicesumar.model.entities.Product;
import com.unicesumar.model.repository.ProductRepository;
import com.unicesumar.view.ConsoleView;

import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;
    private final ConsoleView consoleView;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.consoleView = new ConsoleView();
    }

    public void registerProduct() {
        String name = this.consoleView.getStringInput("--> Nome do produto: ");
        double price = this.consoleView.getDoubleInput("--> Preço do produto: ");
        productRepository.save(new Product(name, price));
        this.consoleView.displayMessage("\n>>> Produto cadastrado com sucesso.");
    }

    public void listProducts() {
        List<Product> products = productRepository.findAll();
        this.consoleView.displayProducts(products);
    }
}
