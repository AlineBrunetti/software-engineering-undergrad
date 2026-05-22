package exercicios_abstracao.ex1livro;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro();
        livro1.titulo = "O Senhor dos Anéis";
        livro1.autor = "J.R.R. Tolkien";
        livro1.isbn = "923598763";
        livro1.exibirDados();
    }
}