package exercicioaula10.exercicio02;

public class Usuario {
    private String nome;
    private int idade;

    /**
     * Construtor da classe Usuario.
     * Valida se a idade é 18 anos ou mais.
     *
     * @param nome O nome do usuário.
     * @param idade A idade do usuário.
     * @throws IdadeInvalida se a idade for menor que 18.
     */
    public Usuario(String nome, int idade) throws IdadeInvalida {
        // 1. Regra de negócio: verificar a idade do usuário.
        if (idade < 18) {
            // 2. Se a regra não for atendida, lança a nossa exceção personalizada.
            throw new IdadeInvalida("Idade inválida. O usuário deve ter no mínimo 18 anos. Idade fornecida: " + idade);
        }

        // 3. Se a exceção não for lançada, o objeto é criado normalmente.
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Usuário [Nome: " + nome + ", Idade: " + idade + "]";
    }
}