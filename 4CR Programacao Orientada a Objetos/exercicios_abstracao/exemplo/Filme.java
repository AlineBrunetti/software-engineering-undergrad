package exercicios_abstracao.exemplo;

class Filme{
    String nome;
    String genero;
    int estoque;

    void alugar(){
        System.out.println("Filme alugado");
    }

    void devolver(){
        System.out.println("Filme devolvido");
    }

}