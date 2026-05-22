package exercicios_abstracao.ex3restaurante;

public class Prato {
    String nome;
    double preco;

    void exibirDetalhes() {
        System.out.println("Prato: " + nome + ", Preço: R$" + preco);
    }
}
