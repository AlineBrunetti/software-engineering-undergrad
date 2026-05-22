package exercicioaula06.atividade3;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Maria", "20251234");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());
    }
}