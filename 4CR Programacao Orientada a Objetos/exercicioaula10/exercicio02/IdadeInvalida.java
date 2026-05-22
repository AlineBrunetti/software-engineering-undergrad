package exercicioaula10.exercicio02;

public class IdadeInvalida extends Exception {

    /**
     * Construtor que aceita uma mensagem de erro detalhada.
     * @param mensagem A mensagem explicando por que a exceção foi lançada.
     */
    public IdadeInvalida(String mensagem) {
        // A palavra-chave 'super' chama o construtor da classe pai (Exception),
        // passando a mensagem de erro para ele.
        super(mensagem);
    }
}
