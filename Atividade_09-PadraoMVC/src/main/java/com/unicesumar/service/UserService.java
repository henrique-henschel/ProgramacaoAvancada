package com.unicesumar.service;

import com.unicesumar.model.entities.User;
import com.unicesumar.model.repository.UserRepository;
import com.unicesumar.view.ConsoleView;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    private final ConsoleView consoleView;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.consoleView = new ConsoleView();
    }

    public void registerUser() {
        String name = this.consoleView.getStringInput("--> Nome do usuário: ");
        String email = this.consoleView.getStringInput("--> E-mail do usuário: ");
        String password = this.consoleView.getStringInput("--> Senha do usuário: ");
        userRepository.save(new User(name, email, password));
        this.consoleView.displayMessage("\n>>> Usuário cadastrado com sucesso.");
    }

    public void listUsers() {
        List<User> users = userRepository.findAll();
        this.consoleView.displayUsers(users);
    }
}
