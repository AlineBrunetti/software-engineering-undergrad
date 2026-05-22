package exercicios_abstracao.ex2aluno;

public class Main {
        public static void main(String[] args) {
        Aluno aluno1 = new Aluno();
        aluno1.nome = "João Silva";
        aluno1.matricula = "2023001";
        aluno1.adicionarNota(7.5f);
        aluno1.adicionarNota(8.0f);
        aluno1.adicionarNota(6.5f);
        aluno1.adicionarNota(9.0f);
        aluno1.adicionarNota(5.5f);
        aluno1.exibirBoletim();
    }
}
