package exercicioaula07.exercicio01;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Forma> formas = new ArrayList<>();

        formas.add(new Retangulo("Retângulo 1", 5, 10));
        formas.add(new Circulo("Círculo 1", 4));

        double somaAreas = 0;
        for (Forma f : formas) {
            System.out.println(f); // chama o toString sobrescrito
            somaAreas += f.area();
        }

        System.out.println("\nSoma das áreas = " + somaAreas);
    }
}

