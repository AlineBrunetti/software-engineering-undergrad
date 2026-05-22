package exercicioaula05.exercicio03;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    ArrayList<String> nomes = new ArrayList<>();

    public Main() {
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");
        nomes.add("Diana");
        nomes.add("Eduardo");

        Random aleatorio = new Random();
        int indiceSorteado = aleatorio.nextInt(nomes.size());
        String nomeSorteado = nomes.get(indiceSorteado);

        System.out.println("Nome sorteado: " + nomeSorteado);
    }

    public static void main(String[] args) {
        new Main();
    }
}