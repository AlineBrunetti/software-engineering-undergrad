package exercicios_abstracao.ex8celular;

public class Celular {
    String marca;
    String modelo;
    String numeroDeSerie;

    void exibirDados() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Número de Série: " + numeroDeSerie);
    }
}
