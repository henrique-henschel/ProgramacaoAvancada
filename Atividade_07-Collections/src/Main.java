import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        int codigo;
        String nome;
        Float preco;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("Opção de cadastro selecionada.");
                    System.out.print("--> Digite o código do novo produto: ");
                    codigo = scanner.nextInt();
                    System.out.print("--> Digite o nome do novo produto: ");
                    nome = scanner.next();
                    System.out.print("--> Digite o preço do novo produto: ");
                    preco = scanner.nextFloat();
                    Produto produto = new Produto(codigo, nome, preco);
                    listaProdutos.add(produto);
                    break;

                case 2:
                    System.out.println("Opção de busca selecionada.");
                    System.out.print("--> Digite o código do produto buscado: ");
                    codigo = scanner.nextInt();
                    boolean produtoEncontrado = false;

                    for (Produto p : listaProdutos) {
                        if (p.getCodigo() == codigo) {
                            System.out.println("Produto encontrado: " +
                                    "\nCódigo: " + p.getCodigo() +
                                    "\nNome: " + p.getNome() +
                                    "\nPreço: R$ " + p.getPreco());
                            produtoEncontrado = true;
                            break;
                        }

                        if (!produtoEncontrado) {
                            System.out.println("O produto não foi encontrado.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}
