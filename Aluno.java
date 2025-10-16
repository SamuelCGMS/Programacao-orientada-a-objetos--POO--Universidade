
public class Aluno {
    
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