import javax.swing.*;
import java.util.ArrayList;

public class Loja {
    private static ArrayList<Produto> produtos = GerenciadorProduto.carregarProdutos();

    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void exibirJanela() {
        JFrame janela = new JFrame("Gestão de Produtos da Loja");
        JTextField campoNomeProduto = new JTextField();
        JTextField campoPrecoProduto = new JTextField();
        JButton botaoAdicionar = new JButton("Adicionar Produto");
        JButton botaoListar = new JButton("Listar Produtos");
        JButton botaoEditarPreco = new JButton("Editar Preço");
        JButton botaoSair = new JButton("Sair");

        janela.setLayout(null);

        JLabel rotuloNome = new JLabel("Nome do Produto:");
        JLabel rotuloPreco = new JLabel("Preço:");
        rotuloNome.setBounds(30, 30, 120, 25);
        campoNomeProduto.setBounds(150, 30, 150, 25);
        rotuloPreco.setBounds(30, 70, 120, 25);
        campoPrecoProduto.setBounds(150, 70, 150, 25);
        botaoAdicionar.setBounds(30, 110, 150, 30);
        botaoListar.setBounds(200, 110, 150, 30);
        botaoEditarPreco.setBounds(30, 150, 150, 30);
        botaoSair.setBounds(200, 150, 150, 30);

        janela.add(rotuloNome);
        janela.add(campoNomeProduto);
        janela.add(rotuloPreco);
        janela.add(campoPrecoProduto);
        janela.add(botaoAdicionar);
        janela.add(botaoListar);
        janela.add(botaoEditarPreco);
        janela.add(botaoSair);

        botaoAdicionar.addActionListener(e -> {
            String nome = campoNomeProduto.getText();
            double preco;
            try {
                preco = Double.parseDouble(campoPrecoProduto.getText());
                produtos.add(new Produto(nome, preco)); // Produto adicionado à lista
                GerenciadorProduto.salvarProdutos(produtos); // Salvando produtos no arquivo
                JOptionPane.showMessageDialog(janela, "Produto adicionado com sucesso!");
                campoNomeProduto.setText("");
                campoPrecoProduto.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "Preço inválido!");
            }
        });

        botaoListar.addActionListener(e -> {
            if (produtos.isEmpty()) {
                JOptionPane.showMessageDialog(janela, "Nenhum produto cadastrado.");
            } else {
                StringBuilder lista = new StringBuilder("Produtos cadastrados:\n");
                for (Produto produto : produtos) {
                    lista.append("- ").append(produto.getNome())
                         .append(" (R$ ").append(produto.getPreco()).append(")\n");
                }
                JOptionPane.showMessageDialog(janela, lista.toString());
            }
        });

        botaoEditarPreco.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog(janela, "Digite o nome do produto a editar:");
            Produto produtoEncontrado = null;

            for (Produto produto : produtos) {
                if (produto.getNome().equalsIgnoreCase(nome)) {
                    produtoEncontrado = produto;
                    break;
                }
            }

            if (produtoEncontrado != null) {
                String novoPreco = JOptionPane.showInputDialog(janela, "Digite o novo preço:");
                try {
                    produtoEncontrado.setPreco(Double.parseDouble(novoPreco));
                    GerenciadorProduto.salvarProdutos(produtos);
                    JOptionPane.showMessageDialog(janela, "Preço atualizado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(janela, "Preço inválido!");
                }
            } else {
                JOptionPane.showMessageDialog(janela, "Produto não encontrado.");
            }
        });

        botaoSair.addActionListener(e -> janela.setVisible(false)); // Fecha a janela da loja sem fechar a aplicação

        janela.setSize(400, 250);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setVisible(true);
    }
}