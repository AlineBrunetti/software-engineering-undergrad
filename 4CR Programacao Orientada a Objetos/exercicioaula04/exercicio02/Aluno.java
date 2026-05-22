package exercicioaula04.exercicio02;

class Aluno {
    private final String nome;
    private double nota;

    public Aluno(String nome) {
        this.nome = nome;
        this.nota = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public double consultarNota() {
        return nota;
    }

    public boolean adicionarNota(double valor) {
        if (valor > 0 && valor + nota <= 10) {
            nota += valor;
            return true;
        }
        return false;
    }

    public boolean retirarNota(double valor) {
        if (valor > 0 && nota >= valor) {
            nota -= valor;
            return true;
        }
        return false;
    }
}

