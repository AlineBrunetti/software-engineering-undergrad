package exercicioaula09.exercicio02;

public class Main {
    public static void main(String args[]){
        Usuario u = new Usuario("1234");
        Administrador a = new Administrador("5678");

        if (u.Autenticar("1234")) {
            System.out.println("Usuario logado");
        }else{
            System.out.println("Senha incorreta");
        }
        if (a.Autenticar("5678")) {
            System.out.println("Administrador logado");
        }else{
            System.out.println("Senha incorreta");
        }
        if (u.Autenticar("5432")) {
            System.out.println("Usuario logado");
        }else{
            System.out.println("Senha incorreta");
        }
        if (a.Autenticar("5234")) {
            System.out.println("Administrador logado");
        }else{
            System.out.println("Senha incorreta");
        }
    }
}
