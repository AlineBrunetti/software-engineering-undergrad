package exercicios_abstracao.ex7hotel;

public class Reserva {
    Quarto quarto;
    Hospede hospede;
    String dataEntrada;
    String dataSaida;

    void exibirDados() {
        System.out.println("Dados da Reserva:");
        System.out.println("Quarto:");
        quarto.exibirDados();
        System.out.println("Hóspede:");
        hospede.exibirDados();
        System.out.println("Data de Entrada: " + dataEntrada);
        System.out.println("Data de Saída: " + dataSaida);
    }
}
