package exercicioaula09.exercicio02;

public class Administrador implements Autenticavel{
    private String senha;

    public Administrador(String senha){
        this.senha = senha;
    }

    @Override
    public boolean Autenticar(String senha){
        if (senha.equals(this.senha)) {
            return true;
        }
        return false;
    }
}
