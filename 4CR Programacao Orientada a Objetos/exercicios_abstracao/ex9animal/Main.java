package exercicios_abstracao.ex9animal;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.nome = "Rex";
        animal.especie = "Cachorro";
        animal.idade = 5;
        animal.fazerBarulho();
        System.out.println("-------------------");
        Animal gato = new Animal();
        gato.nome = "Mia";
        gato.especie = "Gato";
        gato.idade = 3;
        gato.fazerBarulho();
    }
}
