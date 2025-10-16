import java.io.Serializable;

public class Produto implements Serializable {
    private static int contadorId = 1;  // Contador estático para gerar IDs únicos
    private int id;  // ID único do produto
    private String nome;
    private double preco;

    // Construtor da classe Produto
    public Produto(String nome, double preco) {
        this.id = contadorId++;  // Atribui o ID único e incrementa o contador
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Modificado para incluir o ID do produto
    @Override
    public String toString() {
        return "Produto ID: " + id + " - " + nome + " (R$ " + preco + ")";
    }
}