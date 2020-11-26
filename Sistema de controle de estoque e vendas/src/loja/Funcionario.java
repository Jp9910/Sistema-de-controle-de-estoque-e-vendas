package loja;
public abstract class Funcionario {

	protected int codigo;
	protected String nome;
	protected int qntCompras;
	protected boolean funcionarioAtivo;
	protected double salario;
	protected String usuario;
	protected String senha;
        
	public Funcionario(int codigo,String nome, double salario) {
		this.nome=nome;
		this.funcionarioAtivo = true;
		this.salario=salario;
	}
        
	public int getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public int getQntCompras() {
		return qntCompras;
	}
	
	public boolean getAtividadeFuncionario() {
		return funcionarioAtivo;
	}
        
	public void setAtividadeFuncionario(boolean ativ) {
		this.funcionarioAtivo = ativ;
	}
        
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}   
	
	public String getUsuario() {
		return usuario;
	}
	public String getSenha() {
		return senha;
	}
}
