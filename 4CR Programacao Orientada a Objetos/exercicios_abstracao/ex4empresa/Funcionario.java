package exercicios_abstracao.ex4empresa;

public class Funcionario {
    String nome;
    Departamento departamento;

    public Funcionario(String nome, Departamento departamento) {
        this.nome = nome;
        this.departamento = departamento;
        departamento.adicionarFuncionario(this);
    }
}