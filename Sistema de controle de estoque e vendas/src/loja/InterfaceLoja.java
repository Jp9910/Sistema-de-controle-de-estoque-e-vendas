package loja;

import javax.swing.JTextArea;

public interface InterfaceLoja {
    void ProdutosClientesEVendasPreCadastrados();
    void cadastrarCliente(JTextArea txtrSistema);
    public void cadastrarProduto(JTextArea txtrSistema);
    void realizarVenda(JTextArea txtrSistema);
    void aumentarQuantidadeEmEstoque(JTextArea txtrSistema);
    void listarClientes(JTextArea txtrSistema);
    void listarProdutos(JTextArea txtrSistema);
    void listarProdutosEmEstoque(JTextArea txtrSistema);
    void listarProdutosEsgotados(JTextArea txtrSistema);
    void listarVendas(JTextArea txtrSistema);
    void listarVendasCliente(JTextArea txtrSistema);
    void listarProdutosCategoria(JTextArea txtrSistema);
    void listarClientesExcluidos(JTextArea txtrSistema);
    void consultarCompraNotaFiscal(JTextArea txtrSistema);
    void excluirProduto(JTextArea txtrSistema);
    void excluirCliente(JTextArea txtrSistema);
    void alterarDesconto(JTextArea txtrSistema);
}
