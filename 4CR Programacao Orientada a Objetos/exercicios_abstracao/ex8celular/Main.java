package exercicios_abstracao.ex8celular;

public class Main {
    public static void main(String[] args) {
        Celular celular = new Celular();
        celular.marca = "Samsung";
        celular.modelo = "Galaxy S21";
        celular.numeroDeSerie = "SN123456789";
        celular.exibirDados();
    }
}
