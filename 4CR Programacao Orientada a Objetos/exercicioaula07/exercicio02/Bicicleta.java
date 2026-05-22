package exercicioaula07.exercicio02;

public class Bicicleta extends Veiculo {

    public Bicicleta(String nome) {
        super(nome);
    }

    @Override
    public void mover() {
        System.out.println("A bicicleta " + getNome() + " está se movendo.");
    }
}
