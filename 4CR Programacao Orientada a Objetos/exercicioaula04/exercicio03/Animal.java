package exercicioaula04.exercicio03;

public class Animal {
    private String nome;
    private String especie;

    public Animal(String nome, String especie) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
        this.especie = especie;
    }

    public String consultarDados() {
        return "Nome: " + nome + ", Espécie: " + especie;
    }

    public boolean mudarNome(String novoNome) {
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            this.nome = novoNome;
            return true;
        }
        return false;
    }
}
