package loja;
public class Vendedor extends Funcionario{
    
	int itensVendidos;
    
	public Vendedor(int codigo, String nome, double salario,String usuario,String senha) {
        super(codigo, nome, salario);
        itensVendidos = 0;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getItensVendidos() {
        return itensVendidos;
    }
}