public class Produto {
    private int codigo;
    private String nome;
    private Float preco;

    public Produto(int codigo, String nome, Float preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Float getPreco() {
        return preco;
    }
}
