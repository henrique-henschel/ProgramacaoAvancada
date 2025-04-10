package com.unicesumar.view;

import com.unicesumar.model.entities.Product;
import com.unicesumar.model.entities.User;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        System.out.println("\n---MENU---");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Cadastrar Usuário");
        System.out.println("4 - Listar Usuários");
        System.out.println("5 - Sair");
        System.out.println("Escolha uma opção: ");
    }

    public int getOption() {
        return scanner.nextInt();
    }

    public String getStringInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public double getDoubleInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayProducts(List<Product> products) {
        System.out.println("\n--- Lista de Produtos ---");
        if (products == null || products.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void displayUsers(List<User> users) {
        System.out.println("\n--- Lista de Usuários ---");
        if (users == null || users.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
