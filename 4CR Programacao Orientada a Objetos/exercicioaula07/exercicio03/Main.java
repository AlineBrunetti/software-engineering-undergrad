package exercicioaula07.exercicio03;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Camiseta", 29.99, 10));
        produtos.add(new Produto("Calça", 79.90, 5));
        produtos.add(new Produto("Tênis", 149.90, 3));

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}