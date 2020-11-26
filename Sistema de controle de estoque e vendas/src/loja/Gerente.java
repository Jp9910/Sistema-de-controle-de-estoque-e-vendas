package loja;
public class Gerente extends Funcionario{
    
    public Gerente(int codigo, String nome, double salario,String usuario, String senha) {
        super(codigo, nome, salario);
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    

}
