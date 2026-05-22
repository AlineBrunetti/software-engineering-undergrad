package atividades2.atividade04;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        pedido.adicionarItem("Camiseta", 2, 50.0);
        pedido.adicionarItem("Calça", 1, 120.0);
        pedido.adicionarItem("Tênis", 1, 200.0);

        pedido.removerItem("Calça");

        System.out.println("Valor total do pedido: R$ " + pedido.valorTotal());
    }
}