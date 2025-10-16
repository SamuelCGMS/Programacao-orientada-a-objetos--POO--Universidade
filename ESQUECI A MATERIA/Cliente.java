import javax.swing.*;
import java.util.ArrayList;

public class Cliente {

    public void exibirJanela() {
        JFrame janela = new JFrame("Produtos Disponíveis");
        JButton botaoEscolher = new JButton("Escolher Produto");
        JButton botaoSair = new JButton("Sair");

        janela.setLayout(null);

        JLabel rotuloProdutos = new JLabel("Produtos Disponíveis:");
        JTextArea areaProdutos = new JTextArea();
        areaProdutos.setEditable(false);

        rotuloProdutos.setBounds(30, 30, 200, 25);
        areaProdutos.setBounds(30, 60, 300, 150);
        botaoEscolher.setBounds(30, 220, 150, 30);
        botaoSair.setBounds(200, 220, 150, 30);

        janela.add(rotuloProdutos);
        janela.add(areaProdutos);
        janela.add(botaoEscolher);
        janela.add(botaoSair);

        // Carrega os produtos da loja
        ArrayList<Produto> produtos = Loja.getProdutos();
        if (produtos.isEmpty()) {
            areaProdutos.setText("A loja está atualizando o estoque.");
        } else {
            StringBuilder lista = new StringBuilder();
            for (Produto produto : produtos) {
                lista.append(produto.getNome())
                     .append(" (R$ ").append(produto.getPreco()).append(")\n");
            }
            areaProdutos.setText(lista.toString());
        }
 
        botaoEscolher.addActionListener(e -> {
            String escolha = JOptionPane.showInputDialog(janela, "Digite o nome do produto que deseja:");
            boolean encontrado = false;
            for (Produto produto : produtos) {
                if (produto.getNome().equalsIgnoreCase(escolha)) {
                    JOptionPane.showMessageDialog(janela, "Você escolheu: " + produto.getNome());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(janela, "Produto não encontrado.");
            }
        });

        botaoSair.addActionListener(e -> janela.setVisible(false)); // Fecha a janela do cliente sem fechar a aplicação

        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setVisible(true);
    }
}
