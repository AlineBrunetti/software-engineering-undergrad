package exercicios_abstracao.ex4empresa;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    String nome;
    List<Funcionario> funcionarios = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public void listarFuncionarios() {
        System.out.println("Departamento: " + nome);
        for (Funcionario f : funcionarios) {
            System.out.println("- " + f.nome);
        }
    }
}