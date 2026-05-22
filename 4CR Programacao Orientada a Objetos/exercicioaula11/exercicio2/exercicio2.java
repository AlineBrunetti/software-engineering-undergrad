package atividadesaula11.exercicio1;
class BancoDeDados {
    void lerDados() {
        System.out.println("Lendo dados do banco...");
    }}
public class Relatorio {
    private BancoDeDados bd;
    public Relatorio(BancoDeDados bd) {
        this.bd = bd;}
    void gerar() {
        bd.lerDados();  }}
