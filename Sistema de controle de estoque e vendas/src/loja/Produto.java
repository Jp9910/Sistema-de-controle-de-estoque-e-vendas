package loja;

public class Produto implements InterfaceProduto{

	protected int codigo;
	protected String nome;
	protected int qntEmEstoque;
	protected double preco;
        protected String categoria;
	protected int diaValidade;
        protected int mesValidade;
        protected int anoValidade;
	public Produto(int codigo, String nome1, int qntEmEstoque1, double preco1, String categoria, int diaValidade1, int mesValidade1,int anoValidade1) {
		this.codigo = codigo;
		nome = nome1;
		qntEmEstoque = qntEmEstoque1;
		preco = preco1;
                this.categoria = categoria;
                diaValidade=diaValidade1;
                mesValidade=mesValidade1;
                anoValidade=anoValidade1;
	}
        
        @Override
	public void vender(int qnt) {
		this.qntEmEstoque -= qnt;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public int getQntEmEstoque() {
		return qntEmEstoque;
	}
	public double getPreco() {
		return preco;
	}
        public String getCategoria() {
		return categoria;
	}
	public void setCodigo(int codigo1) {
		codigo = codigo1;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setQntEmEstoque(int qntEmEstoque) {
		this.qntEmEstoque = qntEmEstoque;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

    public int getDiaValidade() {
        return diaValidade;
    }

    public void setDiaValidade(int diaValidade) {
        this.diaValidade = diaValidade;
    }
    
    public int getMesValidade() {
        return mesValidade;
    }

    public void setMesValidade(int mesValidade) {
        this.mesValidade = mesValidade;
    }
    public int getAnoValidade() {
        return anoValidade;
    }

    public void setAnoValidade(int anoValidade) {
        this.anoValidade = anoValidade;
    }
        
}
