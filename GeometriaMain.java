import java.util.Scanner;

public class GeometriaMain {

    public static void main(String[] args) {
        GerenciadorGeometria gerenciador = new GerenciadorGeometria();
        gerenciador.iniciar();
    }
}

class GerenciadorGeometria {

    private Scanner scanner;

    public GerenciadorGeometria() {
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Escolha uma figura geométrica:");
        System.out.println("1. Triângulo");
        System.out.println("2. Retângulo");
        System.out.println("3. Círculo");
        System.out.print("Digite o número da opção escolhida: ");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                calcularTriangulo();
                break;
            case 2:
                calcularRetangulo();
                break;
            case 3:
                calcularCirculo();
                break;
            default:
                System.out.println("Opção inválida!");
        }

        scanner.close();
    }

    private void calcularTriangulo() {
        System.out.print("Digite o comprimento do lado A: ");
        double ladoA = scanner.nextDouble();

        System.out.print("Digite o comprimento do lado B: ");
        double ladoB = scanner.nextDouble();

        System.out.print("Digite o comprimento do lado C: ");
        double ladoC = scanner.nextDouble();

        Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);
        triangulo.imprimirDados();
    }

    private void calcularRetangulo() {
        System.out.print("Digite a largura do retângulo: ");
        double largura = scanner.nextDouble();

        System.out.print("Digite a altura do retângulo: ");
        double altura = scanner.nextDouble();

        Retangulo retangulo = new Retangulo(largura, altura);
        System.out.println("Área do Retângulo: " + retangulo.calcularArea());
        System.out.println("Perímetro do Retângulo: " + retangulo.calcularPerimetro());
    }

    private void calcularCirculo() {
        System.out.print("Digite o raio do círculo: ");
        double raio = scanner.nextDouble();

        Circulo circulo = new Circulo(raio);
        System.out.println("Área do Círculo: " + circulo.calcularArea());
        System.out.println("Perímetro do Círculo: " + circulo.calcularPerimetro());
    }
}

class Triangulo {

    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    public boolean verificaTriangulo() {
        return (ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA);
    }

    public String tipoTriangulo() {
        if (!verificaTriangulo()) {
            return "Não é um triângulo.";
        }
        if (ladoA == ladoB && ladoB == ladoC) {
            return "Triângulo Equilátero.";
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            return "Triângulo Isósceles.";
        } else {
            return "Triângulo Escaleno.";
        }
    }

    public void imprimirDados() {
        System.out.println("Lado A: " + ladoA);
        System.out.println("Lado B: " + ladoB);
        System.out.println("Lado C: " + ladoC);
        System.out.println("Tipo de triângulo: " + tipoTriangulo());
    }
}

class Retangulo {

    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double calcularArea() {
        return largura * altura;
    }

    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }
}

class Circulo {

    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * raio * raio; // PI * r²
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * raio; // 2 * PI * r
    }
}
