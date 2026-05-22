package exercicioaula08.exercicio03;

abstract class Funcionario {
    protected String nome;
    protected double salario;

    // Construtor
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // Método abstrato
    public abstract double calcularBonus();

    // Método para exibir dados
    public void exibirDados() {
        System.out.println("Nome: " + nome + " | Salário: " + salario);
    }
}
