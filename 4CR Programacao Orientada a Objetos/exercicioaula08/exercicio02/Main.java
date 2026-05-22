package exercicioaula08.exercicio02;

public class Main {
    public static void main(String[] args) {
    
        Veiculo carro = new Carro("Toyota", "Corolla");
        Veiculo moto = new Moto("Honda", "CB 500");

        // Testando métodos
        carro.exibirDados();
        carro.acelerar();

        moto.exibirDados();
        moto.acelerar();
    }
}
