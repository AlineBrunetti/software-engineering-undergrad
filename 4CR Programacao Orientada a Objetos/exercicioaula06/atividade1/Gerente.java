package exercicioaula06.atividade1;

class Gerente extends Funcionario {
    private String setor;
    public String getSetor() {
        return setor;
    }   
    public void setSetor(String setor) {
        this.setor = setor;
    }
    @Override
    public String getNome() {
        return super.getNome();
    }
    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }
    @Override
    public double getSalario() {
        return super.getSalario();
    }

    public void exibirDados() {
        System.out.println("Nome: " + getNome());;
        System.out.println("Salário: " + getSalario());
        System.out.println("Setor: " + setor);
    }
}
