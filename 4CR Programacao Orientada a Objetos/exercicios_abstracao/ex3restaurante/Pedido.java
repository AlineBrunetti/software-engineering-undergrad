package exercicios_abstracao.ex3restaurante;

public class Pedido {
    String cliente;
    String[] pratos;

    void exibirPedido() {
        System.out.println("Pedido do Cliente: " + cliente);
        System.out.println("Pratos:");
        for (String prato : pratos) {
            System.out.println("- " + prato);
        }
    }
}
