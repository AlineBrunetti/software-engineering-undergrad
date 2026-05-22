package exercicioaula07.exercicio02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        Veiculo carro = new Carro("Fusca");
        Veiculo bicicleta = new Bicicleta("Caloi");

        veiculos.add(carro);
        veiculos.add(bicicleta);

        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
            veiculo.mover();
            System.out.println(veiculo);
        }
    }
}