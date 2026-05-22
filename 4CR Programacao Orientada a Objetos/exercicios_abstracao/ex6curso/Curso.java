package exercicios_abstracao.ex6curso;

public class Curso {
    String nome;
    String codigo;
    int cargaHoraria;
    
    public void exibirDados() {
        System.out.println("Curso: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Carga Horária: " + cargaHoraria + " horas");
    }
}
