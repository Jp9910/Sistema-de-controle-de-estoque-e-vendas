package loja;

import java.util.Calendar;

public class Venda {

	private int codigo;
	private Cliente comprador;
	private int dia;
    private int mes;
    private int ano;
	private Item[] itens;
	private int qntDeProdutosDiferentes;
	Calendar hoje = Calendar.getInstance();
	
	public Venda(int codigo, Cliente comprador, Item[] itens, int qntProdutosDif) {
		this.codigo=codigo;
		this.comprador=comprador;
		this.itens = itens;
		this.qntDeProdutosDiferentes = qntProdutosDif;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public Cliente getComprador() {
		return comprador;
	}
	public Item[] getItens() {
		return itens;
	}
	public int getQntProdutosDiferentes() {
		return qntDeProdutosDiferentes;
	}

    public int getDia() {
    	return hoje.get(Calendar.DAY_OF_MONTH);
    }

    public int getMes() {
    	return hoje.get(Calendar.MONTH)+1;
    }

    public int getAno() {
    	return hoje.get(Calendar.YEAR);
    }       
}

