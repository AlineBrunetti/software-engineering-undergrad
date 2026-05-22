package exercicios_abstracao.ex6curso;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso();
        curso.nome = "Programação Orientada a Objetos";
        curso.codigo = "1234567";
        curso.cargaHoraria = 60;
        curso.exibirDados();
    }
}

