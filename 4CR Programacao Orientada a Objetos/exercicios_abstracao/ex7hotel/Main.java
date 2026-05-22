package exercicios_abstracao.ex7hotel;

public class Main {
    public static void main(String[] args) {
        Quarto quarto1 = new Quarto();
        quarto1.numero = 101;
        quarto1.tipo = "Duplo";
        quarto1.status = "Disponível";
        System.out.println("-------------------");
        quarto1.exibirDados();
        System.out.println("-------------------");
        Hospede hospede1 = new Hospede();
        hospede1.nome = "João Silva";
        hospede1.documento = "123456789";
        hospede1.exibirDados();
        System.out.println("-------------------");
        Reserva reserva1 = new Reserva();
        reserva1.quarto = quarto1;
        reserva1.hospede = hospede1;
        reserva1.dataEntrada = "01/01/2023";
        reserva1.dataSaida = "05/01/2023";
        reserva1.exibirDados();
        System.out.println("-------------------");
    }
}
