package com.unicesumar;

import com.unicesumar.controller.MenuController;
import com.unicesumar.model.repository.ProductRepository;
import com.unicesumar.model.repository.UserRepository;
import com.unicesumar.service.ProductService;
import com.unicesumar.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database.sqlite";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
            return;
        }

        ProductRepository productRepository = new ProductRepository(conn);
        UserRepository userRepository = new UserRepository(conn);

        ProductService productService = new ProductService(productRepository);
        UserService userService = new UserService(userRepository);

        MenuController menuController = new MenuController(productService, userService);

        menuController.startMenu();

        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}
