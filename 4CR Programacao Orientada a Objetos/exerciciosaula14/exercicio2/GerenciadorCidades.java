import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorCidades {

    /**
     * (a) Adiciona uma cidade a um estado específico no mapa.
     * Se o estado não existir, ele é criado.
     */
    public static void adicionarCidade(Map<String, List<String>> mapa, String estado, String cidade) {
        mapa.computeIfAbsent(estado, k -> new ArrayList<>()).add(cidade);
    }

    /**
     * (b) Retorna a lista de cidades de um determinado estado.
     * Retorna uma lista vazia se o estado não for encontrado.
     */
    public static List<String> cidadesDoEstado(Map<String, List<String>> mapa, String estado) {
        return mapa.getOrDefault(estado, new ArrayList<>());
    }

    public static void main(String[] args) {
        [cite_start]
        Map<String, List<String>> estadosCidades = new HashMap<>();

        adicionarCidade(estadosCidades, "Paraná", "Guarapuava");
        adicionarCidade(estadosCidades, "Paraná", "Curitiba");
        adicionarCidade(estadosCidades, "São Paulo", "São Paulo");
        adicionarCidade(estadosCidades, "São Paulo", "Campinas");
        adicionarCidade(estadosCidades, "Rio de Janeiro", "Rio de Janeiro");

        adicionarCidade(estadosCidades, "Paraná", "Cascavel");

        [cite_start]
        System.out.println("### Cidades por Estado ###");
        for (String estado : estadosCidades.keySet()) {
            System.out.println("\nCidades do estado de " + estado + ":");
            List<String> cidades = cidadesDoEstado(estadosCidades, estado);
            for (String cidade : cidades) {
                System.out.println("- " + cidade);
            }
        }
    }
}