package exercicioaula07.exercicio02;

public class Veiculo {  
    protected String nome;

    public Veiculo(String nome) {
        this.nome = nome;
    }

    public void mover(){
        System.out.println("O veículo " + nome + " está se movendo.");
    }

    public String getNome() {
        return nome;
    }
}