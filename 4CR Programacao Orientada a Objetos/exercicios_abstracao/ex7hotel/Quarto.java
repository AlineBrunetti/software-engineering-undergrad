package exercicios_abstracao.ex7hotel;

public class Quarto {
    int numero;
    String tipo;
    String status;

    void exibirDados() {
        System.out.println("Número do Quarto: " + numero);
        System.out.println("Tipo: " + tipo);
        System.out.println("Status: " + status);
    }
}
