package exercicioaula09.exercicio01;

public class Main {
    public static void main (String args[]){
        Circulo c = new Circulo(3);
        Retangulo r = new Retangulo(5, 3);

        System.out.println("A area do circulo é " + c.CalcularArea());
        System.out.println("A area do retangulo é " + r.CalcularArea());
    }
}
