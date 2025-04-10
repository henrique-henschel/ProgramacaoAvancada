package com.unicesumar.controller;

import com.unicesumar.service.ProductService;
import com.unicesumar.service.UserService;
import com.unicesumar.view.ConsoleView;

public class MenuController {
    private final ProductService productService;
    private final UserService userService;
    private final ConsoleView consoleView;

    public MenuController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
        this.consoleView = new ConsoleView();
    }
    
    public void startMenu() {
        int option;
        
        do {
            this.consoleView.showMainMenu();
            option = this.consoleView.getOption();

            switch (option) {
                case 1:
                    this.productService.registerProduct();
                    break;

                case 2:
                    this.productService.listProducts();
                    break;

                case 3:
                    this.userService.registerUser();
                    break;

                case 4:
                    this.userService.listUsers();
                    break;

                case 5:
                    this.consoleView.displayMessage("Saindo...");
                    break;

                default:
                    this.consoleView.displayMessage("ERRO! Opção INVÁLIDA. Tente novamente.");
            }
        } while (option != 5);
        
        this.consoleView.close();
    }
}
