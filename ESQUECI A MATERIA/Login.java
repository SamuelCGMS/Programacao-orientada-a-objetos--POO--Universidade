import javax.swing.*;

public class Login {
    public void exibirJanela() {
        JFrame janela = new JFrame("Login");
        JLabel rotuloUsuario = new JLabel("Usuário:");
        JLabel rotuloSenha = new JLabel("Senha:");
        JTextField campoUsuario = new JTextField(15);
        JPasswordField campoSenha = new JPasswordField(15);
        JLabel rotuloEscolha = new JLabel("Entrar como:");
        JRadioButton opcaoLoja = new JRadioButton("Loja");
        JRadioButton opcaoCliente = new JRadioButton("Cliente");
        ButtonGroup grupoEscolha = new ButtonGroup();
        JButton botaoEntrar = new JButton("Entrar");
        JButton botaoEsqueciSenha = new JButton("Esqueci minha senha");

        // Agrupando os botões de escolha
        grupoEscolha.add(opcaoLoja);
        grupoEscolha.add(opcaoCliente);

        janela.setLayout(null);

        // Configuração dos componentes na tela
        rotuloUsuario.setBounds(30, 30, 80, 25);
        campoUsuario.setBounds(100, 30, 150, 25);
        rotuloSenha.setBounds(30, 70, 80, 25);
        campoSenha.setBounds(100, 70, 150, 25);
        rotuloEscolha.setBounds(30, 110, 100, 25);
        opcaoLoja.setBounds(130, 110, 80, 25);
        opcaoCliente.setBounds(210, 110, 80, 25);
        botaoEntrar.setBounds(100, 150, 80, 25);
        botaoEsqueciSenha.setBounds(190, 150, 150, 25);

        // Adicionando os componentes à janela
        janela.add(rotuloUsuario);
        janela.add(campoUsuario);
        janela.add(rotuloSenha);
        janela.add(campoSenha);
        janela.add(rotuloEscolha);
        janela.add(opcaoLoja);
        janela.add(opcaoCliente);
        janela.add(botaoEntrar);
        janela.add(botaoEsqueciSenha);

        // Ação ao clicar em "Entrar"
        botaoEntrar.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());

            if (opcaoLoja.isSelected()) {
                if (autenticarLoja(usuario, senha)) {
                    JOptionPane.showMessageDialog(janela, "Login como Loja bem-sucedido!");
                    janela.dispose(); // Fecha a janela atual
                    new Loja().exibirJanela(); // Abre a janela da loja
                } else {
                    JOptionPane.showMessageDialog(janela, "Credenciais inválidas para Loja!");
                }
            } else if (opcaoCliente.isSelected()) {
                if (autenticarCliente(usuario, senha)) {
                    JOptionPane.showMessageDialog(janela, "Login como Cliente bem-sucedido!");
                    janela.dispose(); // Fecha a janela atual
                    new ListaProdutos().exibirJanelaCliente(); // Abre a janela do cliente
                } else {
                    JOptionPane.showMessageDialog(janela, "Credenciais inválidas para Cliente!");
                }
            } else {
                JOptionPane.showMessageDialog(janela, "Por favor, selecione uma opção de login.");
            }
        });

        // Ação ao clicar em "Esqueci minha senha"
        botaoEsqueciSenha.addActionListener(e -> {
            JOptionPane.showMessageDialog(janela, "Entre em contato com o suporte para redefinir sua senha.");
        });

        // Configurações da janela
        janela.setSize(400, 250);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    // Método de autenticação para Loja
    public boolean autenticarLoja(String usuario, String senha) {
        return usuario.equals("admin") && senha.equals("1234");
    }

    // Método de autenticação para Cliente
    public boolean autenticarCliente(String usuario, String senha) {
        return usuario.equals("cliente") && senha.equals("1234");
    }
}





MODIFICAÇÃO: ao iniciar o sistema agora tem uma mensagem de boas vindas 
BOTÃO DE ESQUECI A SENHA ADICIONADO AO MENU.
Caso erre login ou senha da um aviso (Credenciais inválidas)
No menu da loja foi adicionado o botão EDITAR PREÇOS
Ao cadastrar PRODUTO ele automaticamente gera o relatorio de produto com o produto cadastrado e 
se editar o preço ele muda automaticamente o preço no relatorio
ID do produto adicionado no relatorio de produto.
No menu cliente foi adicionado uma tela para ver automaticamente os itens adicionados no carrinho
Foi adicionado um botão para remover itens do carrinho. 
Ao finalizar a venda gera o relátorio de Pedido constando o id do produto o valor do produto e o valor total da venda.
O relatorio foi mudado de .dat para .txt para facilitar a visualização


