package loja;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class JanelaFuncionalidades{

	private static Loja loja;
	private JFrame frame;
	private JTextArea txtrSistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		loja = new Loja();
		loja.ProdutosClientesEVendasPreCadastrados();
		loja.Entrar(null);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaFuncionalidades window = new JanelaFuncionalidades();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaFuncionalidades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 623);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setBounds(7, 7, 280, 23);
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.cadastrarCliente(txtrSistema);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnCadastrarCliente);
		
		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.setBounds(7, 34, 280, 23);
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.cadastrarProduto(txtrSistema);
			}
		});
		frame.getContentPane().add(btnCadastrarProduto);
		
		JButton btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.setBounds(7, 61, 280, 23);
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.realizarVenda(txtrSistema);
			}
		});
		frame.getContentPane().add(btnRealizarVenda);
		
		JButton btnAumentarEstoque = new JButton("Aumentar Estoque");
		btnAumentarEstoque.setBounds(7, 88, 280, 23);
		btnAumentarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.aumentarQuantidadeEmEstoque(txtrSistema);
			}
		});
		frame.getContentPane().add(btnAumentarEstoque);
		
		JButton btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.setBounds(7, 115, 280, 23);
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.listarClientes(txtrSistema);
			}
		});
		frame.getContentPane().add(btnListarClientes);
		
		JButton btnListarProdutos = new JButton("Listar Produtos");
		btnListarProdutos.setBounds(7, 142, 280, 23);
		btnListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.listarProdutos(txtrSistema);
			}
		});
		frame.getContentPane().add(btnListarProdutos);
		
		JButton btnListarProdutosEm = new JButton("Listar Produtos Em Estoque");
		btnListarProdutosEm.setBounds(7, 169, 280, 23);
		btnListarProdutosEm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.listarProdutosEmEstoque(txtrSistema);
			}
		});
		frame.getContentPane().add(btnListarProdutosEm);
		
		JButton btnListarProdutosEsgotados = new JButton("Listar Produtos Esgotados ou Excluidos");
		btnListarProdutosEsgotados.setBounds(7, 196, 280, 23);
		btnListarProdutosEsgotados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.listarProdutosEsgotados(txtrSistema);
			}
		});
		frame.getContentPane().add(btnListarProdutosEsgotados);
		
		JButton btnListarVendasRealizadas = new JButton("Listar Vendas Realizadas");
		btnListarVendasRealizadas.setBounds(7, 223, 280, 23);
		btnListarVendasRealizadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.listarVendas(txtrSistema);
			}
		});
		frame.getContentPane().add(btnListarVendasRealizadas);
		
		JButton btnListarVendasPor = new JButton("Listar Vendas por Cliente");
		btnListarVendasPor.setBounds(7, 250, 280, 23);
		btnListarVendasPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.listarVendasCliente(txtrSistema);
			}
		});
		frame.getContentPane().add(btnListarVendasPor);
		
		JButton btnListarProdutosPor = new JButton("Listar Produtos por Categoria");
		btnListarProdutosPor.setBounds(7, 277, 280, 23);
		btnListarProdutosPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.listarProdutosCategoria(txtrSistema);
			}
		});
		frame.getContentPane().add(btnListarProdutosPor);
		
		JButton btnListarClientesExcluidos = new JButton("Listar Clientes Excluidos");
		btnListarClientesExcluidos.setBounds(7, 304, 280, 23);
		btnListarClientesExcluidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.listarClientesExcluidos(txtrSistema);
			}
		});
		frame.getContentPane().add(btnListarClientesExcluidos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(232, 538, 63, 32);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrSistema.append(">Loja Encerrada<");
				System.exit(0);
			}
		});
		
		JButton btnConsultarCompraPor = new JButton("Consultar Compra por nota fiscal");
		btnConsultarCompraPor.setBounds(7, 331, 280, 23);
		btnConsultarCompraPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.consultarCompraNotaFiscal(txtrSistema);
			}
		});
		frame.getContentPane().add(btnConsultarCompraPor);
		
		JButton btnExcluirProduto = new JButton("Excluir Produto (zerar estoque)");
		btnExcluirProduto.setBounds(7, 358, 280, 23);
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.excluirProduto(txtrSistema);
			}
		});
		frame.getContentPane().add(btnExcluirProduto);
		
		JButton btnExcluirCliente = new JButton("Excluir Cliente (encerrar atividade)");
		btnExcluirCliente.setBounds(7, 385, 280, 23);
		btnExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.excluirCliente(txtrSistema);
			}
		});
		frame.getContentPane().add(btnExcluirCliente);
		frame.getContentPane().add(btnSair);
		
		txtrSistema = new JTextArea(5,30);
		txtrSistema.setToolTipText("Mensagens do Sistema");
		txtrSistema.setEditable(false);
		txtrSistema.setBounds(297, 26, 427, 547);
		frame.getContentPane().add(txtrSistema);
		
		JLabel lblSistema = new JLabel("Sistema:");
		lblSistema.setBounds(297, 7, 63, 23);
		frame.getContentPane().add(lblSistema);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(694, 55, 2, 2);
		scrollPane.setSize(600, 200);
		scrollPane.setPreferredSize(new Dimension(600,200));
		txtrSistema.add(scrollPane,BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Limpar Mensagens do Sistema");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrSistema.setText("");
			}
		});
		btnNewButton.setBounds(10, 535, 212, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnTrocarUsuario = new JButton("Trocar Usuario");
		btnTrocarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JanelaLogin login = new JanelaLogin();
				//login.setVisible(true);
				loja.Entrar(txtrSistema);
			}
		});
		btnTrocarUsuario.setBounds(7, 463, 280, 23);
		frame.getContentPane().add(btnTrocarUsuario);
		
		JButton btnCadastrarFuncionario = new JButton("Cadastrar Vendedor");
		btnCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.cadastrarVendedor(txtrSistema);
			}
		});
		btnCadastrarFuncionario.setBounds(7, 411, 280, 23);
		frame.getContentPane().add(btnCadastrarFuncionario);
		
		JButton btnCadastrarGerente = new JButton("Cadastrar Gerente");
		btnCadastrarGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.cadastrarGerente(txtrSistema);
			}
		});
		btnCadastrarGerente.setBounds(7, 436, 280, 23);
		frame.getContentPane().add(btnCadastrarGerente);
		
	}
}
