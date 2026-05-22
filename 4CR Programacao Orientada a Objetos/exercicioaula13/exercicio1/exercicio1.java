package exercicioaula13.exercicio1;

enum StatusPedido {
    NOVO,
    PROCESSANDO,
    ENVIADO,
    ENTREGUE
}

public class exercicio1 {
    private StatusPedido status;

    public exercicio1() {
        this.status = StatusPedido.NOVO;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
