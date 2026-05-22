package exercicios_abstracao.exemplo;

public class Cliente {
    String nome;
    int idade;

    Filme filmeAlugado;
    void alugarFilme (Filme filme){
        if (filme.estoque > 0) {
            System.out.println("Filme alugado!");
            filme.estoque --;
            filmeAlugado = filme;
        }
        else{
            System.out.println("Sem estoque!");
        }
    }
}