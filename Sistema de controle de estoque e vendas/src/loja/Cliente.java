package loja;

import loja.Venda;

public class Cliente implements InterfaceCliente {

	private int codigo;
	private String nome;
	private int qntCompras;
	private Venda[] compras;
	private boolean clienteAtivo;
	
    public Cliente(int codigo,String nome) {
		this.codigo=codigo;
		this.nome=nome;
		this.qntCompras=0;
		compras = new Venda[50];
		this.clienteAtivo = true;
	}
        @Override
	public void Comprar(Venda venda) {
		compras[qntCompras] = venda;
		qntCompras++;
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
	public Venda[] getCompras() {
		return compras;
	}
	public boolean getAtividadeCliente() {
		return clienteAtivo;
	}
        @Override
	public void setAtividadeCliente(boolean ativ) {
		this.clienteAtivo = ativ;
	}
}
