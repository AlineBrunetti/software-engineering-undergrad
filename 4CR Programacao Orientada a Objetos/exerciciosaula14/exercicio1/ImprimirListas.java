import java.util.List;
import java.util.ArrayList;

public class ImprimirListas {
    public static void imprimirLista(List<?> lista) {
        System.out.println("--- Imprimindo os itens da lista ---");
        for (Object item : lista) {
            System.out.println(item);
        }
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");
        imprimirLista(nomes);

        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        imprimirLista(numeros);

        List<Double> precos = new ArrayList<>();
        precos.add(19.99);
        precos.add(25.50);
        imprimirLista(precos);
    }
}