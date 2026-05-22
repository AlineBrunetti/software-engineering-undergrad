package exercicioaula05.exercicio02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pessoa pessoa = new Pessoa();

        System.out.print("Digite o nome: ");
        pessoa.nome = sc.nextLine();

        System.out.print("Digite a idade: ");
        pessoa.idade = sc.nextInt();

        System.out.println("Nome: " + pessoa.nome);
        System.out.println("Idade: " + pessoa.idade);

        sc.close();
    }
}