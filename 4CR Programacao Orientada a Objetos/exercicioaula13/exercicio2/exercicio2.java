package exercicioaula13.exercicio2;

enum StatusPedido {
    NOVO,
    PROCESSANDO,
    ENVIADO,
    ENTREGUE
}

class PedidoComViolacao {
    private StatusPedido status;
    private double valor;
    private String cliente;

    public PedidoComViolacao() {
        this.status = StatusPedido.NOVO;
        this.valor = 0.0;
        this.cliente = "";
    }

    public void processarPedido(double valor, String cliente) {
        if (valor > 0) {
            if (!cliente.isEmpty()) {
                this.valor = valor;
                this.cliente = cliente;
                this.status = StatusPedido.PROCESSANDO;
            }
        }
    }
}

class Pedido {
    private StatusPedido status;
    private double valor;

    public Pedido() {
        this.status = StatusPedido.NOVO;
        this.valor = 0.0;
    }

    public void processarPedido(double valor) {
        if (valor <= 0) {
            return;
        }
        this.valor = valor;
        this.status = StatusPedido.PROCESSANDO;
    }
}

public class exercicio2 {

}
