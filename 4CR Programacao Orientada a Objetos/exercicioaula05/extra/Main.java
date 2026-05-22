package exercicioaula05.extra;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();

        String continuar;
        do {
            System.out.print("Digite o título do livro: ");
            String titulo = sc.nextLine();

            System.out.print("Digite o autor do livro: ");
            String autor = sc.nextLine();

            livros.add(new Livro(titulo, autor));

            System.out.print("Cadastrar outro livro? (s/n): ");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("\nLivros cadastrados:");
        for (Livro livro : livros) {
            System.out.println(livro);
        }

        sc.close();
    }
}