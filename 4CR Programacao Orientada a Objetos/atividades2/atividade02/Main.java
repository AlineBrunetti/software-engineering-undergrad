package atividades2.atividade02;

public class Main {
public static void main(String args[]){
    Calculadora c = new Calculadora();
    int Resultado01 = c.soma(5,5);
    double Resultado02 = c.soma(2.2,5.4);
    int Resultado03 = c.soma(3,6,7);

    System.out.println("Resultado01: " + Resultado01);
    System.out.println("Resultado02: "+ Resultado02);
    System.out.println("Resultado03: "+ Resultado03);

}
}
