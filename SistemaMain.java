import java.util.Scanner;


public class SistemaMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Cadastrar Pessoa");
        System.out.println("2. Cadastrar Livro");
        System.out.println("3. Cadastrar Carro");
        System.out.println("4. Cadastrar Conta Bancária");
        System.out.println("5. Cadastrar Cão");
        System.out.println("6. Cadastrar Aluno");
        System.out.print("Digite o número da opção escolhida: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();  

        switch (escolha) {
            case 1:
                GerenciadorPessoa.cadastrarPessoa(scanner);
                break;
            case 2:
                GerenciadorLivro.cadastrarLivro(scanner);
                break;
            case 3:
                GerenciadorCarro.cadastrarCarro(scanner);
                break;
            case 4:
                GerenciadorContaBancaria.cadastrarContaBancaria(scanner);
                break;
            case 5:
                GerenciadorCao.cadastrarCao(scanner);
                break;
            case 6:
                GerenciadorAluno.cadastrarAluno(scanner);
                break;
            default:
                System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}


class GerenciadorPessoa {
    public static void cadastrarPessoa(Scanner scanner) {
        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade da pessoa: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 

        Pessoa pessoa = new Pessoa(nome, idade);
        System.out.println("\nDados da Pessoa:");
        pessoa.imprimirDados();
    }
}


class GerenciadorLivro {
    public static void cadastrarLivro(Scanner scanner) {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        Livro livro = new Livro(titulo, autor);
        System.out.println("\nDados do Livro:");
        livro.imprimirDados();
    }
}


class GerenciadorCarro {
    public static void cadastrarCarro(Scanner scanner) {
        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite o ano do carro: ");
        int ano = scanner.nextInt();
        scanner.nextLine();  

        Carro carro = new Carro(modelo, ano);
        System.out.println("\nDados do Carro:");
        carro.imprimirDados();
    }
}


class GerenciadorContaBancaria {
    public static void cadastrarContaBancaria(Scanner scanner) {
        System.out.print("Digite o nome do titular da conta: ");
        String titular = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(titular);
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Verificar Saldo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Saldo atual: " + conta.verificarSaldo());
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }
}


class GerenciadorCao {
    public static void cadastrarCao(Scanner scanner) {
        System.out.print("Digite o nome do cão: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a raça do cão: ");
        String raca = scanner.nextLine();

        Cao cao = new Cao(nome, raca);
        System.out.println("\nDados do Cão:");
        cao.imprimirDados();
        cao.latir();

        System.out.print("Digite o tipo de comida que o cão vai comer: ");
        String comida = scanner.nextLine();
        cao.comer(comida);
    }
}


class GerenciadorAluno {
    public static void cadastrarAluno(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a nota da disciplina 1: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Digite a nota da disciplina 2: ");
        double nota2 = scanner.nextDouble();
        System.out.print("Digite a nota da disciplina 3: ");
        double nota3 = scanner.nextDouble();
        scanner.nextLine(); 

        Aluno aluno = new Aluno(nome, nota1, nota2, nota3);

        System.out.println("\nDados do Aluno:");
        aluno.imprimirDados();
    }
}


class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}


class Livro {
    private String titulo;
    private String autor;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void imprimirDados() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
    }
}


class Carro {
    private String modelo;
    private int ano;

    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public void imprimirDados() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
    }
}


class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saque inválido. Verifique o valor e seu saldo.");
        }
    }

    public double verificarSaldo() {
        return saldo;
    }

    public void imprimirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }
}


class Cao {
    private String nome;
    private String raca;

    public Cao(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    public void latir() {
        System.out.println(nome + " está latindo: Au Au");
    }

    public void comer(String comida) {
        System.out.println(nome + " está comendo: " + comida);
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Raça: " + raca);
    }
}


class Aluno {
    private String nome;
    private double nota1;
    private double nota2;
    private double nota3;

    public Aluno(String nome, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double calcularMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Nota 3: " + nota3);
        System.out.println("Média: " + calcularMedia());
    }
}
