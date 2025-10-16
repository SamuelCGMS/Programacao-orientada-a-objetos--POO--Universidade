import java.io.*;
import java.util.ArrayList;

public class GerenciadorProduto {
    private static final String ARQUIVO_PRODUTOS = "produtos.txt";

    // Salva os produtos no arquivo texto
    public static void salvarProdutos(ArrayList<Produto> produtos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_PRODUTOS))) {
            for (Produto produto : produtos) {
                writer.write(produto.getNome() + "|" + produto.getPreco());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os produtos: " + e.getMessage());
        }
    }

    // Carrega os produtos do arquivo texto
    public static ArrayList<Produto> carregarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_PRODUTOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length == 2) {
                    String nome = partes[0];
                    double preco = Double.parseDouble(partes[1]);
                    produtos.add(new Produto(nome, preco));
                }
            }
        } catch (FileNotFoundException e) {
            // Arquivo não existe, retornamos uma lista vazia
        } catch (IOException e) {
            System.err.println("Erro ao carregar os produtos: " + e.getMessage());
        }
        return produtos;
    }
}
