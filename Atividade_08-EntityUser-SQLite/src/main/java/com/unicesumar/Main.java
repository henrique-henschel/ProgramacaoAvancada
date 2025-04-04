package com.unicesumar;

import com.unicesumar.entities.Product;
import com.unicesumar.entities.User;
import com.unicesumar.repository.ProductRepository;
import com.unicesumar.repository.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductRepository listaDeProdutos = null;
        UserRepository listaDeUsuarios = null;
        Connection conn = null;
        
        // Parâmetros de conexão
        String url = "jdbc:sqlite:database.sqlite";

        // Tentativa de conexão
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                listaDeProdutos = new ProductRepository(conn);
                listaDeUsuarios = new UserRepository(conn);
            } else {
                System.out.println("Falha na conexão.");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n---MENU---");
            System.out.println("0 - Sair do sistema");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    System.out.println("Cadastrar Produto");
                    listaDeProdutos.save(new Product("Teste", 10));
                    listaDeProdutos.save(new Product("Computador", 3000));
                    break;
                case 2:
                    System.out.println("Listar Produtos");
                    List<Product> products = listaDeProdutos.findAll();
                    products.forEach(System.out::println);
                    break;
                case 3:
                    /* OBS: Fui obrigado a fazer desta forma (com a entrada, e não objetos idênticos toda vez
                    *       porque há a cláusula `UNIQUE` no campo/coluna de "email" da tabela "users" no SQLite.
                    *       Então se tentasse cadastrar novos usuários com o mesmo e-mail, a aplicação iria que-
                    *       brar. Por isso dava pra cadastrar usuários apenas uma vez, já que na segunda vez
                    *       os e-mails seriam os mesmos, e o programa portanto iria quebrar sua execução. Ago-
                    *       ra cadastrando um novo usuário manualmente a aplicação funciona perfeitamente, des-
                    *       de que não se tente cadastrar manualmente usuários com e-mails repetidos (daí ocor-
                    *       reria erro novamente). */

                    String tmpName;
                    String tmpEmail;
                    String tmpPassword;

                    System.out.println("Cadastrar Usuário");
                    System.out.println("--> Digite o NOME: ");
                    tmpName = scanner.next();
                    System.out.println("--> Digite o E-MAIL: ");
                    tmpEmail = scanner.next();
                    System.out.println("--> Digite a SENHA: ");
                    tmpPassword = scanner.next();
                    listaDeUsuarios.save(new User(tmpName, tmpEmail, tmpPassword));
                    break;
                case 4:
                    System.out.println("Listar Usuários");
                    List<User> users = listaDeUsuarios.findAll();
                    users.forEach(System.out::println);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        } while (option != 0);

        scanner.close();

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
