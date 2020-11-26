package loja;
import java.util.Scanner;


import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.*;
public class Loja implements InterfaceLoja{
	
	private static Scanner sc;
	private int qntClientes, qntFuncionarios, qntProdutos, qntVendas;
	List<Produto> produtos = new LinkedList<Produto>();
	List<Cliente> clientes = new LinkedList<Cliente>();
	List<Venda> vendas = new LinkedList<Venda>();
	List<Funcionario> funcionarios = new LinkedList<Funcionario>();
	private String usuario, senha;
	private int desconto=100;
    private int anoz;
    private int mesz;
    private int diaz;
    @Override
	public void ProdutosClientesEVendasPreCadastrados() {
    	Gerente gerente = new Gerente(12,"ally",800,"ally2019","abc123");
    	funcionarios.add(gerente);
    	qntFuncionarios++;
    	Vendedor vendedor = new Vendedor(13,"joao",700,"joao2019","qwer123");
    	funcionarios.add(vendedor);
    	qntFuncionarios++;
    	Cliente cliente1 = new Cliente(447,"Bob");
		clientes.add(cliente1);
		qntClientes++;
		Cliente cliente2 = new Cliente(557,"Ana");
		clientes.add(cliente2);
		qntClientes++;
		Produto produto1 = new Produto(91,"Leite",15,4.5,"alimentos",1,11,2020);
		produtos.add(produto1);
		qntProdutos++;
		Produto produto2 = new Produto(92,"Pao",30,1,"alimentos",1,9,2019);
		produtos.add(produto2);
		qntProdutos++;
		Produto produto3 = new Produto(93,"Detergente",0,4.2,"produtos de limpeza",28,8,2023);
		produtos.add(produto3);
		qntProdutos++;
		Item[] itens = new Item[2];
		produtos.get(produtos.indexOf(produto1)).vender(3);
		itens[0] = new Item(produtos.get(produtos.indexOf(produto1)).getCodigo(),"Leite",produtos.get(produtos.indexOf(produto1)).getQntEmEstoque(),produtos.get(produtos.indexOf(produto1)).getPreco(),"alimentos",3,1,11,2020);
		produtos.get(produtos.indexOf(produto2)).vender(6);
		itens[1] = new Item(produtos.get(produtos.indexOf(produto2)).getCodigo(),"Pao",produtos.get(produtos.indexOf(produto2)).getQntEmEstoque(),produtos.get(produtos.indexOf(produto2)).getPreco(),"alimentos",6,1,9,2019);
		Venda venda1 = new Venda(741,clientes.get(clientes.indexOf(cliente1)),itens,2);
		clientes.get(clientes.indexOf(cliente1)).Comprar(venda1);
		vendas.add(venda1);
		qntVendas++;
	}


    @Override
	public void cadastrarCliente(JTextArea txtrSistema) 
	{
		//JanelaCadastroClient cadastrar = new JanelaCadastroClient();
		//cadastrar.setVisible(true);
		int codigo=2019+qntClientes;
		String nome = JOptionPane.showInputDialog(txtrSistema,"Nome do cliente:");
		while(nome.matches("[a-zA-Z' ']+") == false) {
			txtrSistema.append("Nome invalido. Digite novamente.\n");
			nome = JOptionPane.showInputDialog(txtrSistema,"Cadastro de Cliente","Nome do cliente:");
			
		}
		for(int i=0;i<qntClientes;i++) 
		{
			if(nome.equalsIgnoreCase(clientes.get(i).getNome()))
			{
				txtrSistema.append(">ERRO: Cliente Ja Cadastrado.\n");
				if(clientes.get(i).getAtividadeCliente() == false) {
					String ativ = JOptionPane.showInputDialog(txtrSistema,"Cliente encontra-se inativo.\nDigite 1 para tornar o cliente ativo.");
					if(ativ.equalsIgnoreCase("1")) {
						clientes.get(i).setAtividadeCliente(true);
						txtrSistema.append("Cliente retornou a ser ativo.\n");
					}
				}
				txtrSistema.append("**************************************\n");
				return;
			}
		}
		Cliente cliente = new Cliente(codigo,nome);
		clientes.add(cliente);
		qntClientes++;
		txtrSistema.append("\nNome do cliente: "+nome);
		txtrSistema.append("\nCadastro efetuado. Codigo associado ao cliente: "+(2019+qntClientes-1)+"\n");
		txtrSistema.append("**************************************\n");
	}

	
    @Override
	public void cadastrarProduto(JTextArea txtrSistema) 
	{
		JTextField nomeP = new JTextField();
		JTextField qntEstoque = new JTextField();
		JTextField precoP = new JTextField();
		JTextField categoriaP = new JTextField();
		JTextField ano = new JTextField();
		JTextField mes = new JTextField();
		JTextField dia = new JTextField();
		Object[] cadastro = {
				"Nome: ", nomeP,
				"Quantidade Em Estoque: ",qntEstoque,
				"Preco: ",precoP,
				"Categoria: ",categoriaP,
				"Ano de validade: ",ano,
				"Mes de validade: ",mes,
				"Dia de validade: ",dia
		};
		JOptionPane.showConfirmDialog(txtrSistema,cadastro,"Cadastro de Produto",JOptionPane.OK_CANCEL_OPTION);
		int codigo = (2019*2)+(qntProdutos+1);
		String nome=nomeP.getText();
		for(int i=0;i<qntProdutos;i++) 
		{
			if(nome.equalsIgnoreCase(produtos.get(i).getNome()))
			{
				txtrSistema.append(">ERRO: Produto Ja Cadastrado.\n");
				txtrSistema.append("**************************************\n");
				return;
			}
		}
		String quant = qntEstoque.getText();
		int num0 = -7;
		try {
			num0 = Integer.parseInt(quant);
		}
		catch(java.lang.NumberFormatException a){
			txtrSistema.append(">ERRO: Campo \"Quantidade em Estoque\" invalido\n");
			return;
		}
		String prec = precoP.getText();
		double num1 = -7;
		try {
			num1 = Double.parseDouble(prec);
		}
		catch(java.lang.NumberFormatException e){
			txtrSistema.append(">ERRO: Campo \"Preco\" invalido\n");
			return;
		}
		String categoria=categoriaP.getText();
        String anoValidade=ano.getText();
        int num2 = -7;
		try {
			num2 = Integer.parseInt(anoValidade);
		}
		catch(java.lang.NumberFormatException a){
			txtrSistema.append(">ERRO: Campo \"Ano de Validade\" invalido\n");
			return;
		}
        String mesValidade=mes.getText();
        int num3 = -7;
		try {
			num3 = Integer.parseInt(mesValidade);
		}
		catch(java.lang.NumberFormatException a){
			txtrSistema.append(">ERRO: Campo \"Mes de Validade\" invalido\n");
			return;
		}
        String diaValidade=dia.getText();
        int num4 = -7;
		try {
			num4 = Integer.parseInt(diaValidade);
		}
		catch(java.lang.NumberFormatException a){
			txtrSistema.append(">ERRO: Campo \"Dia de Validade\" invalido\n");
			return;
		}
		Produto produto = new Produto(codigo,nome,num0,num1,categoria,num4,num3,num2);
		produtos.add(produto);
		qntProdutos++;
		txtrSistema.append("Codigo associado ao produto: "+(2019*2+qntProdutos)+"\n");
		txtrSistema.append("**************************************\n");
	}

	
    @Override
	public void realizarVenda(JTextArea txtrSistema) 
	{
    	sc = new Scanner(System.in);
    	JTextField nomeP = new JTextField();
		JTextField qntProdutosDif = new JTextField();
		Object[] vendaCampos = {
				"Nome ou codigo do cliente: ", nomeP,
				"Quantidade de Produtos Diferentes: ",qntProdutosDif
		};
		JOptionPane.showConfirmDialog(txtrSistema,vendaCampos,"Realizando Venda",JOptionPane.OK_CANCEL_OPTION);
		int codigo= (2019*3+qntVendas+1);
		String nome=nomeP.getText();
		int numero = -7;
		try {
			numero = Integer.parseInt(nome);
		}
		catch(java.lang.NumberFormatException a){numero = -7;}
		String quant = qntProdutosDif.getText();
		int num0 = -7;
		try {
			num0 = Integer.parseInt(quant);
		}
		catch(java.lang.NumberFormatException a){
			txtrSistema.append(">ERRO: Numero invalido\n");
			return;
		}
		boolean test = false;
		for(int i=0;i<qntClientes;i++) 
		{
			if(nome.equalsIgnoreCase(clientes.get(i).getNome()) || numero == clientes.get(i).getCodigo() )
			{
				test = true;
			}
		}
		if(test==false) {
			txtrSistema.append(">ERRO: Cliente invalido");
			return;
		}
		Calendar hoje = Calendar.getInstance();
		int ano = hoje.get(Calendar.YEAR);
		int mes = hoje.get(Calendar.MONTH);
		int dia = hoje.get(Calendar.DAY_OF_MONTH);
		int hora = hoje.get(Calendar.HOUR_OF_DAY);
		int minuto = hoje.get(Calendar.MINUTE);
		int segundo = hoje.get(Calendar.SECOND);
		txtrSistema.append("Data da venda: "+dia+"/"+(mes+1)+"/"+ano+" "+hora+":"+minuto+":"+segundo+"\n");
		//JanelaVendaSelecionarItens itensVenda = new JanelaVendaSelecionarItens();
		//JOptionPane.showConfirmDialog(txtrSistema,itensVenda,"Venda",JOptionPane.OK_CANCEL_OPTION);
		Item[] itens = new Item[num0];
		double precoTotal = 0;
		int cont1 = 0;
		for(int i=0;i<num0;i++) 
		{
			int test2 = 0;
			while(test2==0 || test2==2) 
			{
				System.out.print("Nome do produto "+i+": ");
				String nome1=sc.next();
				if(nome1.equalsIgnoreCase("cancelar")) {
					System.out.println("Venda cancelada.");
					return;
				}
				System.out.print("Quantidade: ");
				int quant1=0;
				quant1 = EscanearInteiroTratandoInputMismatch(quant1);
				for(int j=0;j<qntProdutos;j++) 
				{
					if(nome1.equalsIgnoreCase(produtos.get(j).getNome()))
					{
						test2 = 1;
						if(produtos.get(j).getQntEmEstoque() < quant1)
						{
							System.out.println(">ERRO: Quantidade em estoque deste produto eh insuficiente para a venda.");
							System.out.println(">Digite o produto novamente ou digite \"Cancelar\" para cancelar a operacao de venda.");
							test2 = 2;
							break;
						}
						else
						{
							produtos.get(j).vender(quant1);
							itens[cont1] = new Item(produtos.get(j).getCodigo(),nome1,produtos.get(j).getQntEmEstoque(),produtos.get(j).getPreco(),produtos.get(j).getCategoria(),quant1,produtos.get(j).getDiaValidade(),produtos.get(j).getMesValidade(),produtos.get(j).getAnoValidade());
							cont1++;
                                                                if((produtos.get(j).getAnoValidade() < ano) || (produtos.get(j).getAnoValidade() <= ano  && produtos.get(j).getMesValidade() < mes ) ||(produtos.get(j).getAnoValidade() <= ano &&produtos.get(j).getMesValidade() <= mes && produtos.get(j).getDiaValidade() < dia))
                                                                {
                                                                   produtos.remove(j);
                                                                }
                                                                else if((produtos.get(j).getAnoValidade() > anoz) || (produtos.get(j).getAnoValidade() >= anoz  && produtos.get(j).getMesValidade() > mesz ) ||(produtos.get(j).getAnoValidade() >= anoz &&produtos.get(j).getMesValidade() >= mesz && produtos.get(j).getDiaValidade() > diaz))
                                                                {
                                                                    System.out.println("--preco do produto "+": "+produtos.get(j).getPreco()+"--");                                                      
                                                                    precoTotal = precoTotal + (produtos.get(j).getPreco() * quant1);
                                                                }
                                                                else 
                                                                {
                                                                    System.out.println("--preco do produto com desconto de "+(100-desconto)+"%: "+produtos.get(j).getPreco()*desconto/100+"--");                                                      
                                                                    precoTotal = precoTotal + (produtos.get(j).getPreco() * quant1 * desconto/100);
                                                                }
                                                                
						}
					}
				}
				if(test2==0)
				{
					System.out.println(">ERRO: Produto Invalido.");
					System.out.println(">Digite o produto novamente ou digite \"Cancelar\" para cancelar a operacao de venda.");
				}
			}
		}

		int test2 = 0;
		while(test2 == 0) 
		{
			for(int i=0;i<qntClientes;i++) 
			{
				if((nome.equalsIgnoreCase(clientes.get(i).getNome()) || numero == clientes.get(i).getCodigo()) && clientes.get(i).getAtividadeCliente() == true) 
				{
					test2 = 1;
					Venda venda = new Venda(codigo,clientes.get(i),itens,num0);
					clientes.get(i).Comprar(venda);
					vendas.add(venda);
					qntVendas++;
					break;
				}
			}
			if(test2 == 0) 
			{
				System.out.println(">ERRO: Cliente inserido invalido ou inativo.");
				System.out.println(">Digite o nome novamente ou digite \"Cancelar\" para cancelar a operacao de venda.");
				nome=sc.next();
				if(nome.equalsIgnoreCase("cancelar")) {
					System.out.println("Venda cancelada.");
					return;
				}
			}
		}
                System.out.println("preço da compra: "+precoTotal);
		System.out.println("Venda efetuada. Numero da nota fiscal: "+codigo);
		System.out.println("**************************************");
		txtrSistema.append("Venda efetuada. Numero da nota fiscal: "+codigo+"\n");
		txtrSistema.append("**************************************\n");
	}

	
    @Override
	public void aumentarQuantidadeEmEstoque(JTextArea txtrSistema) 
	{
    	txtrSistema.append("Aumentando de estoque de um produto...\n");
		JTextField nomeP = new JTextField();
		JTextField qntAdicionada = new JTextField();
		Object[] campos = {
				"Nome ou codigo do produto: ", nomeP,
				"Quantidade a adicionar: ",qntAdicionada
		};
		JOptionPane.showConfirmDialog(txtrSistema,campos,"Aumentando Estoque de Produto",JOptionPane.OK_CANCEL_OPTION);
		String nome = nomeP.getText();
		int codigo = 0;
		try {
			codigo = Integer.parseInt(nome);
		}
		catch(java.lang.NumberFormatException a){codigo = 0;}
		String quant = qntAdicionada.getText();
		int quantidade = 0;
		try {
			quantidade = Integer.parseInt(quant);
		}
		catch(java.lang.NumberFormatException a){
			txtrSistema.append(">ERRO: Numero invalido\n");
			return;
		}
		boolean test = false;
		for(int j=0;j<qntProdutos;j++) 
		{
			if(nome.equalsIgnoreCase(produtos.get(j).getNome()) || codigo == produtos.get(j).getCodigo()) 
			{
				test = true;
				produtos.get(j).qntEmEstoque += quantidade;
				break;
			}
		}
		if(test == false) 
		{
			txtrSistema.append("ERRO: Produto Invalido\n");
		}
		else {
			txtrSistema.append("Estoque adicionado.\n");
		}
		txtrSistema.append("**************************************\n");
	}

	
    @Override
	public void listarClientes(JTextArea txtrSistema) 
	{
		txtrSistema.append("**************************************\n");
		txtrSistema.append("--Lista de clientes: --\n");
		for(int i=0;i<qntClientes;i++) 
		{
			if(clientes.get(i).getAtividadeCliente() == true) 
			{
				txtrSistema.append("\t"+clientes.get(i).getNome());
				txtrSistema.append("--> Codigo: "+clientes.get(i).getCodigo()+". Quantidade de compras: "+clientes.get(i).getQntCompras()+"\n");
			}
		}
		txtrSistema.append("**************************************\n");
	}

	
    @Override
	public void listarProdutos(JTextArea txtrSistema) 
	{
		txtrSistema.append("**************************************\n");
		txtrSistema.append("--Lista de produtos: --\n");
		for(int i=0;i<qntProdutos;i++) 
		{
			txtrSistema.append(""+produtos.get(i).getNome());
			txtrSistema.append("--> Codigo: "+produtos.get(i).getCodigo()+". Quantidade em estoque: "+produtos.get(i).getQntEmEstoque()+". Preco: "+produtos.get(i).getPreco()+" Categoria: "+produtos.get(i).getCategoria()+"\n");
		}
		txtrSistema.append("**************************************\n");
	}

	
    @Override
	public void listarProdutosEmEstoque(JTextArea txtrSistema) 
	{
		txtrSistema.append("**************************************\n");
		txtrSistema.append("--Lista de produtos em estoque: --\n");
		for(int i=0;i<qntProdutos;i++) 
		{
			if(produtos.get(i).getQntEmEstoque() > 0) 
			{
				txtrSistema.append(""+produtos.get(i).getNome());
				txtrSistema.append("--> Codigo: "+produtos.get(i).getCodigo()+". Quantidade em estoque: "+produtos.get(i).getQntEmEstoque()+". Preco: "+produtos.get(i).getPreco()+" Categoria: "+produtos.get(i).getCategoria()+"\n");
			}
		}
		txtrSistema.append("**************************************\n");
	}

	
    @Override
	public void listarProdutosEsgotados(JTextArea txtrSistema) 
	{
		txtrSistema.append("**************************************\n");
		txtrSistema.append("--Lista de produtos esgotados: --\n");
		for(int i=0;i<qntProdutos;i++) 
		{
			if(produtos.get(i).getQntEmEstoque() < 1) 
			{
				txtrSistema.append(""+produtos.get(i).getNome());
				txtrSistema.append("--> Codigo: "+produtos.get(i).getCodigo()+". Quantidade em estoque: "+produtos.get(i).getQntEmEstoque()+". Preco: "+produtos.get(i).getPreco()+" Categoria: "+produtos.get(i).getCategoria()+"\n");
			}
		}
		txtrSistema.append("**************************************\n");
	}

    
    @Override
	public void listarVendas(JTextArea txtrSistema) 
	{
		txtrSistema.append("**************************************\n");
		txtrSistema.append("Quantidade de vendas realizadas: "+qntVendas+"\n");
		txtrSistema.append("Lista de vendas realizadas: \n");
		for(int i=0;i<qntVendas;i++) 
		{
			Item[] itensAux = vendas.get(i).getItens();
			txtrSistema.append(">Venda de Codigo "+vendas.get(i).getCodigo()+"<\n");
			txtrSistema.append("\tComprador: "+vendas.get(i).getComprador().getNome()+"\n");
			txtrSistema.append("\tData: "+vendas.get(i).getDia()+"/"+ vendas.get(i).getMes()+"/"+ vendas.get(i).getAno()+"\n");
			txtrSistema.append("\tProdutos vendidos: \n");
			for(int j=0;j<vendas.get(i).getQntProdutosDiferentes();j++) 
			{
				txtrSistema.append("\t\t"+itensAux[j].getNome());
				txtrSistema.append("-> quantidade: ");
				txtrSistema.append(itensAux[j].getQntVendida()+"\n");
			}
		}
		txtrSistema.append("**************************************\n");
	}

    
    @Override
	public void listarVendasCliente(JTextArea txtrSistema) 
	{
		txtrSistema.append("**************************************\n");
		String nome = JOptionPane.showInputDialog(txtrSistema,"Nome ou codigo do cliente:");
		int codigo = 0;
		try {
			codigo = Integer.parseInt(nome);
		}
		catch(java.lang.NumberFormatException a){codigo = 0;}
		boolean test = false;
		for(int i=0;i<qntClientes;i++) 
		{
			if((nome.equalsIgnoreCase(clientes.get(i).getNome()) || codigo == clientes.get(i).getCodigo()) && clientes.get(i).getAtividadeCliente() == true) 
			{
				test = true;
				txtrSistema.append("Numero de compras:"+clientes.get(i).getQntCompras()+"\n");
				txtrSistema.append("--Lista de compras--\n");
				for(int j=0;j<clientes.get(i).getQntCompras();j++) 
				{
					txtrSistema.append(">Compra de codigo: "+clientes.get(i).getCompras()[j].getCodigo()+"<\n");
					txtrSistema.append("\tData:"+clientes.get(i).getCompras()[j].getDia()+"/"+ clientes.get(i).getCompras()[j].getMes()+"/"+ clientes.get(i).getCompras()[j].getAno()+"\n");
					txtrSistema.append("\tProdutos:\n");
					for(int k=0;k<clientes.get(i).getCompras()[j].getQntProdutosDiferentes();k++) 
					{
						txtrSistema.append("\t\t"+clientes.get(i).getCompras()[j].getItens()[k].getNome());
						txtrSistema.append("--> quantidade:"+clientes.get(i).getCompras()[j].getItens()[k].getQntVendida()+"\n");
						txtrSistema.append("\t\tpreco unitario:"+clientes.get(i).getCompras()[j].getItens()[k].getPreco()+"\n");
					}
				}
			}
		}
		if(test == false)
		{
			txtrSistema.append("ERRO: Cliente Invalido.\n");
		}
		txtrSistema.append("**************************************\n");
	}

    
    @Override
	public void listarProdutosCategoria(JTextArea txtrSistema) 
	{
    	txtrSistema.append("**************************************\n");
		String categoria = JOptionPane.showInputDialog(txtrSistema,"Categoria do produto:");
		boolean test = false;
		txtrSistema.append("--Lista de produtos da categoria \""+categoria+"\"--\n");
		for(int i=0;i<qntProdutos;i++) 
		{
			if(produtos.get(i).getCategoria().equalsIgnoreCase(categoria)) 
			{
				test = true;
				txtrSistema.append(""+produtos.get(i).getNome());
				txtrSistema.append("--> Codigo: "+produtos.get(i).getCodigo()+". Quantidade em estoque: "+produtos.get(i).getQntEmEstoque()+". Preco: "+produtos.get(i).getPreco()+"\n");
			}
		}
		if(test == false) {
			txtrSistema.append("-\n");
		}
		txtrSistema.append("**************************************\n");
	}
	
    
    @Override
	public void listarClientesExcluidos(JTextArea txtrSistema) 
	{
		txtrSistema.append("**************************************\n");
		txtrSistema.append("Lista de clientes excluidos: \n");
		for(int i=0;i<qntClientes;i++) 
		{
			if(clientes.get(i).getAtividadeCliente() == false)
			{
				txtrSistema.append("\t"+clientes.get(i).getNome());
				txtrSistema.append("--> Codigo: "+clientes.get(i).getCodigo()+". Quantidade de compras: "+clientes.get(i).getQntCompras()+"\n");
			}
		}
		txtrSistema.append("**************************************\n");
	}
	
    @Override
	public void consultarCompraNotaFiscal(JTextArea txtrSistema) 
	{
    	txtrSistema.append("**************************************\n");
    	txtrSistema.append("Consultando compra por numero da nota fiscal.\n");
    	String notaString = JOptionPane.showInputDialog(txtrSistema,"Numero da nota fiscal (codigo da compra):");
    	int nota = 0;
		try {
			nota = Integer.parseInt(notaString);
		}
		catch(java.lang.NumberFormatException a){nota = 0;}
		boolean test = false;
		for(int i=0;i<qntVendas;i++) 
		{
			Item[] itensAux = vendas.get(i).getItens();
			if(vendas.get(i).getCodigo() == nota) 
			{
				test = true;
				txtrSistema.append(">Compra de codigo "+nota+"<\n");
				txtrSistema.append("\tComprador: "+vendas.get(i).getComprador().getNome()+"\n");
				txtrSistema.append("\tData: "+vendas.get(i).getDia()+"/"+ vendas.get(i).getMes()+"/"+ vendas.get(i).getAno()+"\n");
				txtrSistema.append("\tProdutos vendidos: \n");
				for(int j=0;j<vendas.get(i).getQntProdutosDiferentes();j++) 
				{
					txtrSistema.append("\t\t"+itensAux[j].getNome());
					txtrSistema.append("-> quantidade: ");
					txtrSistema.append(itensAux[j].getQntVendida()+"\n");
				}
			}
		}
		if(test == false) {
			txtrSistema.append(">ERRO: Numero da nota fiscal invalida.<\n");
		}
		txtrSistema.append("**************************************\n");
	}
	
    @Override
	public void excluirProduto(JTextArea txtrSistema)
	{
    	txtrSistema.append("**************************************\n");
    	txtrSistema.append("Digite o nome ou codigo do produto: \n");
		String nome = JOptionPane.showInputDialog(txtrSistema,"Nome ou codigo do produto:");
		int numero = 0;
		try {
			numero = Integer.parseInt(nome);
		}
		catch(java.lang.NumberFormatException a){numero = 0;}
		boolean test = false;
		for(int i=0;i<qntProdutos;i++) 
		{
			if(nome.equalsIgnoreCase(produtos.get(i).getNome()) || numero == produtos.get(i).getCodigo()) 
			{
				produtos.get(i).setQntEmEstoque(0);
				test = true;
			}
		}
		if(test==false) {
			txtrSistema.append(">ERRO: Produto invalido.<\n");
		}
		else {
			txtrSistema.append("Exclusao concluida.\n");
		}
		txtrSistema.append("**************************************\n");
	}
	
    
    @Override
	public void excluirCliente(JTextArea txtrSistema)
	{
    	txtrSistema.append("**************************************\n");
    	/*for(int i=0;i<qntFuncionarios;i++) {
    		if(funcionarios.get(i).getUsuario().equalsIgnoreCase(this.usuario) && funcionarios.get(i) instanceof Gerente) {
    			
    		}
    		else {
    			txtrSistema.append(">ERRO: Vendedores nao possuem permissao para excluir clientes.\n");
    			return;
    		}
    	}*/
		String nome = JOptionPane.showInputDialog(txtrSistema,"Nome ou codigo do cliente:");
		int codigo = 0;
		try {
			codigo = Integer.parseInt(nome);
		}
		catch(java.lang.NumberFormatException a){codigo = 0;}
		boolean test = false;
		for(int i=0;i<qntClientes;i++) 
		{
			if((nome.equalsIgnoreCase(clientes.get(i).getNome()) || codigo == clientes.get(i).getCodigo()) && clientes.get(i).getAtividadeCliente() == true) 
			{
				clientes.get(i).setAtividadeCliente(false);;
				test = true;
			}
		}
		if(test==false) {
			txtrSistema.append(">ERRO: Cliente invalido ou ja inativo.<\n");
		}
		else {
			txtrSistema.append("Exclusao concluida.\n");
		}
		txtrSistema.append("**************************************\n");
	}
    
    public boolean Entrar(JTextArea txtrSistema) 
    {
    	if(txtrSistema != null) {txtrSistema.append("Login\n");}
		JTextField usuario = new JTextField();
		JTextField senha = new JTextField();
		Object[] campos = {
				"Usuario: ", usuario,
				"Senha: ",senha
		};
		JOptionPane.showConfirmDialog(txtrSistema,campos,"Login",JOptionPane.OK_CANCEL_OPTION);
		boolean test = false;
		//procurar usuario na lista de funcionarios
		for(int i=0;i<qntFuncionarios;i++) 
		{
			if(usuario.getText().equalsIgnoreCase(funcionarios.get(i).getUsuario()) && senha.getText().equalsIgnoreCase(funcionarios.get(i).getSenha())) 
			{
				this.usuario = usuario.getText();
				this.senha = senha.getText();
				test = true;
			}
		}
		if(txtrSistema != null) {
		if(test) {
			txtrSistema.append("Login concluido.");
			return true;
		}
		else {
			txtrSistema.append(">ERRO: Usuario ou senha invalidos");
			return false;
		}
		}
		return false;
    }
    
    public void cadastrarVendedor(JTextArea txtrSistema) 
    {
    	txtrSistema.append("Cadastro Funcionario.\n");
		JTextField usuario = new JTextField();
		JTextField senha = new JTextField();
		JTextField nome = new JTextField();
		Object[] campos = {
				"Nome: ", nome,
				"Usuario: ", usuario,
				"Senha: ",senha
		};
		JOptionPane.showConfirmDialog(txtrSistema,campos,"Login",JOptionPane.OK_CANCEL_OPTION);
		Vendedor func = new Vendedor(qntFuncionarios*2,nome.getText(),800,usuario.getText(),senha.getText());
		funcionarios.add(func);
		qntFuncionarios++;
    }
    
    public void cadastrarGerente(JTextArea txtrSistema) 
    {
    	if(txtrSistema != null) {txtrSistema.append("Cadastro Gerente.\n");}
		JTextField usuario = new JTextField();
		JTextField senha = new JTextField();
		JTextField nome = new JTextField();
		Object[] campos = {
				"Nome: ", nome,
				"Usuario: ", usuario,
				"Senha: ",senha
		};
		JOptionPane.showConfirmDialog(txtrSistema,campos,"Login",JOptionPane.OK_CANCEL_OPTION);
		Gerente func = new Gerente(qntFuncionarios*2,nome.getText(),800,usuario.getText(),senha.getText());
		funcionarios.add(func);
		qntFuncionarios++;
    }
	
    @Override
	public void alterarDesconto(JTextArea txtrSistema)
    {
		Calendar desc = Calendar.getInstance();
		System.out.println("**************************************");
		sc = new Scanner(System.in);
		System.out.print("Valor do desconto em %: ");
		desconto = sc.nextInt();
		desconto= 100-desconto;
		System.out.print("Dias antes da validade: ");
		int diasDesconto1 = sc.nextInt();
		desc.add(Calendar.DAY_OF_MONTH,diasDesconto1);
		anoz = desc.get(Calendar.YEAR);
		mesz = desc.get(Calendar.MONTH);
		diaz = desc.get(Calendar.DAY_OF_MONTH);
		System.out.println("**************************************");
    }

	private int EscanearInteiroTratandoInputMismatch(int inteiro) 
	{
		while(true) 
		{
			try {
				inteiro=sc.nextInt();
				break;
			}
			catch (java.util.InputMismatchException as) {
				System.out.println("Numero invalido. Digite novamente");
				sc.next();
				continue;
			}
		}
		return inteiro;
	}
	
}
