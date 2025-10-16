import java.util.Scanner;

public class CalculadoraBasicaMain {

    public static void main(String[] args) {
        GerenciadorCalculadora gerenciador = new GerenciadorCalculadora();
        gerenciador.iniciar();
    }
}

class GerenciadorCalculadora {

    private Scanner scanner;
    private Calculadora calculadora;

    public GerenciadorCalculadora() {
        this.scanner = new Scanner(System.in);
        this.calculadora = new Calculadora();
    }

    public void iniciar() {
        System.out.println("Calculadora Simples");

        System.out.print("Escolha a operação (1: Somar, 2: Subtrair, 3: Multiplicar, 4: Dividir): ");
        int operacao = scanner.nextInt();

        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        double resultado = 0;

        switch (operacao) {
            case 1:
                resultado = calculadora.somar(num1, num2);
                System.out.println("Resultado da soma: " + resultado);
                break;
            case 2:
                resultado = calculadora.subtrair(num1, num2);
                System.out.println("Resultado da subtração: " + resultado);
                break;
            case 3:
                resultado = calculadora.multiplicar(num1, num2);
                System.out.println("Resultado da multiplicação: " + resultado);
                break;
            case 4:
                resultado = calculadora.dividir(num1, num2);
                if (num2 != 0) {  // Apenas imprime o resultado se não for divisão por zero
                    System.out.println("Resultado da divisão: " + resultado);
                }
                break;
            default:
                System.out.println("Operação inválida.");
        }

        scanner.close();
    }
}

class Calculadora {

    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            System.out.println("Divisão por zero não é permitida.");
            return 0; // Retorna 0, mas isso pode ser tratado de outras formas
        }
        return a / b;
    }
}
