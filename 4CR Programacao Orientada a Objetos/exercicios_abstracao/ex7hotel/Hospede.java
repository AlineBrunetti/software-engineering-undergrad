package exercicios_abstracao.ex7hotel;

public class Hospede {
    String nome;
    String documento;
    
    void exibirDados() {
        System.out.println("Nome do Hóspede: " + nome);
        System.out.println("Documento: " + documento);
    }
}