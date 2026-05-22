package exercicios_abstracao.ex4empresa;

public class Main {
    public static void main(String[] args) {
        Departamento depTI = new Departamento("TI");

        Funcionario f1 = new Funcionario("Ana", depTI);
        Funcionario f2 = new Funcionario("Bruno", depTI);
        Funcionario f3 = new Funcionario("Carlos", depTI);

        depTI.listarFuncionarios();
    }
}


