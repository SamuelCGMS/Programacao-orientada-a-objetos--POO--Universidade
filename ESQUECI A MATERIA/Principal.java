import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        // Exibindo a mensagem de boas-vindas assim que o programa iniciar
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema!", "Boas-vindas", JOptionPane.INFORMATION_MESSAGE);

        // Exibindo a janela de login após a mensagem de boas-vindas
        new Login().exibirJanela();
    }
}
