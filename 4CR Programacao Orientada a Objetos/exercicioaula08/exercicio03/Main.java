package exercicioaula08.exercicio03;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criando lista de funcionários
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Gerente("Carlos", 8000.00));
        funcionarios.add(new Vendedor("Ana", 3000.00));
        funcionarios.add(new Vendedor("João", 3500.00));

        // Exibindo bônus de cada funcionário
        for (Funcionario f : funcionarios) {
            f.exibirDados();
            System.out.println("Bônus: R$ " + f.calcularBonus());
            System.out.println("---------------------------");
        }
    }
}
