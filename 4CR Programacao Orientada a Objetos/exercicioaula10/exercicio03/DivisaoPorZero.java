package exercicioaula10.exercicio03;

public class DivisaoPorZero extends Exception{
    /**
     * Construtor que aceita uma mensagem de erro.
     * @param mensagem A mensagem que descreve o erro.
     */
    public DivisaoPorZero(String mensagem) {
        super(mensagem);
    }
}
