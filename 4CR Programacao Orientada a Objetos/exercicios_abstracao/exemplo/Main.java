package exercicios_abstracao.exemplo;

public class Main {
    public static void main (String[] args){
        Cliente cliente1 = new Cliente();
        Filme filme1 = new Filme();

        cliente1.nome = "Nicolas";
        cliente1.idade = 19;

        filme1.nome = "Sherek"; 
        filme1.estoque = 3;
        filme1.genero = "Animação";

        cliente1.alugarFilme(filme1);
    } 
}