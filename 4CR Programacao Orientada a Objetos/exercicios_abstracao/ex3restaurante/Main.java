package exercicios_abstracao.ex3restaurante;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.nome = "Maria Oliveira";
        cliente.exibirNome();
        Prato prato1 = new Prato();
        prato1.nome = "Spaghetti Carbonara";
        prato1.preco = 45.90;
        prato1.exibirDetalhes();
        Prato prato2 = new Prato();
        prato2.nome = "Pizza Margherita";
        prato2.preco = 39.90;
        prato2.exibirDetalhes();
        Pedido pedido = new Pedido();
        pedido.cliente = cliente.nome;
        pedido.pratos = new String[]{prato1.nome, prato2.nome};
        pedido.exibirPedido();
    }
}
