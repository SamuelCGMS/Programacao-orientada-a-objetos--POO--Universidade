import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ListaProdutos {
    private ArrayList<Produto> carrinho = new ArrayList<>();
    private static final String ARQUIVO_CARRINHOS = "carrinhos.txt";

    public void exibirJanelaCliente() {
        ArrayList<Produto> produtos = Loja.getProdutos();

        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A loja está atualizando o estoque. Tente novamente mais tarde.");
            return;
        }

        JFrame janela = new JFrame("Escolha Produtos");
        DefaultListModel<String> modeloListaProdutos = new DefaultListModel<>();
        DefaultListModel<String> modeloListaCarrinho = new DefaultListModel<>();

        for (Produto produto : produtos) {
            modeloListaProdutos.addElement(produto.getNome() + " - R$ " + produto.getPreco());
        }

        JList<String> listaProdutos = new JList<>(modeloListaProdutos);
        JList<String> listaCarrinho = new JList<>(modeloListaCarrinho);
        JButton botaoAdicionar = new JButton("Adicionar ao Carrinho");
        JButton botaoRemover = new JButton("Remover do Carrinho");
        JButton botaoVisualizarCarrinho = new JButton("Visualizar Carrinho");
        JButton botaoFinalizar = new JButton("Finalizar Pedido");

        // Configuração da janela
        janela.setLayout(null);
        JScrollPane scrollProdutos = new JScrollPane(listaProdutos);
        JScrollPane scrollCarrinho = new JScrollPane(listaCarrinho);
        scrollProdutos.setBounds(20, 20, 180, 150);
        scrollCarrinho.setBounds(210, 20, 180, 150);
        botaoAdicionar.setBounds(20, 180, 180, 30);
        botaoRemover.setBounds(210, 180, 180, 30);
        botaoVisualizarCarrinho.setBounds(20, 220, 180, 30);
        botaoFinalizar.setBounds(210, 220, 180, 30);

        janela.add(scrollProdutos);
        janela.add(scrollCarrinho);
        janela.add(botaoAdicionar);
        janela.add(botaoRemover);
        janela.add(botaoVisualizarCarrinho);
        janela.add(botaoFinalizar);

        // Adicionar produto ao carrinho
        botaoAdicionar.addActionListener(e -> {
            int index = listaProdutos.getSelectedIndex();
            if (index != -1) {
                Produto selecionado = produtos.get(index);
                carrinho.add(selecionado);
                modeloListaCarrinho.addElement(selecionado.getNome() + " - R$ " + selecionado.getPreco());
                JOptionPane.showMessageDialog(janela, "Produto adicionado ao carrinho!");
            } else {
                JOptionPane.showMessageDialog(janela, "Selecione um produto.");
            }
        });

        // Remover produto do carrinho
        botaoRemover.addActionListener(e -> {
            int index = listaCarrinho.getSelectedIndex();
            if (index != -1) {
                carrinho.remove(index);
                modeloListaCarrinho.remove(index);
                JOptionPane.showMessageDialog(janela, "Produto removido do carrinho!");
            } else {
                JOptionPane.showMessageDialog(janela, "Selecione um produto no carrinho para remover.");
            }
        });

        // Visualizar itens do carrinho
        botaoVisualizarCarrinho.addActionListener(e -> {
            if (carrinho.isEmpty()) {
                JOptionPane.showMessageDialog(janela, "O carrinho está vazio.");
            } else {
                StringBuilder resumoCarrinho = new StringBuilder("Itens no carrinho:\n");
                double total = 0;

                for (Produto produto : carrinho) {
                    resumoCarrinho.append("- ").append(produto.getNome())
                            .append(" (R$ ").append(produto.getPreco()).append(")\n");
                    total += produto.getPreco();
                }

                resumoCarrinho.append("\nTotal: R$ ").append(total);
                JOptionPane.showMessageDialog(janela, resumoCarrinho.toString());
            }
        });

        // Finalizar pedido
        botaoFinalizar.addActionListener(e -> {
            if (carrinho.isEmpty()) {
                JOptionPane.showMessageDialog(janela, "Adicione itens ao carrinho antes de finalizar.");
            } else {
                salvarCarrinho(carrinho); // Salvar carrinho em arquivo
                StringBuilder pedidoFinal = new StringBuilder("Pedido finalizado com sucesso!\n");
                double total = 0;

                for (Produto produto : carrinho) {
                    pedidoFinal.append("- ").append(produto.getNome())
                            .append(" (R$ ").append(produto.getPreco()).append(")\n");
                    total += produto.getPreco();
                }

                pedidoFinal.append("\nTotal: R$ ").append(total);
                JOptionPane.showMessageDialog(janela, pedidoFinal.toString());

                carrinho.clear(); // Limpa o carrinho após finalizar o pedido
                modeloListaCarrinho.clear(); // Limpa a lista do carrinho na interface
            }
        });

        janela.setSize(420, 300);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setVisible(true);
    }

    // Método para salvar o carrinho em um arquivo texto
    private void salvarCarrinho(ArrayList<Produto> carrinho) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_CARRINHOS, true))) {
            writer.write("Novo Pedido:\n");
            double total = 0;

            for (Produto produto : carrinho) {
                writer.write("ID: " + produto.getId() + " - " + produto.getNome() + " - R$ " + produto.getPreco() + "\n");
                total += produto.getPreco();
            }

            writer.write("Total do Pedido: R$ " + total + "\n");
            writer.write("------------------------------\n");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o carrinho: " + e.getMessage());
        }
    }
}
