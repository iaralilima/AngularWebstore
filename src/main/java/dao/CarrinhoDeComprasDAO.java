package dao;

import entidades.Produto;
import entidades.CarrinhoDeCompras;
import java.util.ArrayList;

/**
 * @author Jefferson Neves
 */
public class CarrinhoDeComprasDAO {

    private static CarrinhoDeComprasDAO instance;
    
    private CarrinhoDeComprasDAO() {
        this.cadastrarMocks();
    }
    
    public static CarrinhoDeComprasDAO getInstance() {
        if (instance == null) {
            instance = new CarrinhoDeComprasDAO();
        }
        return instance;
    }
    
    private CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
    
    public CarrinhoDeCompras listar() {
//        this.cadastrarMocks();
        return this.carrinho;
    }
    
    public void adicionarProduto(Produto produto) {
        this.carrinho.adicionarProduto(produto);
    }
    
    private void cadastrarMocks()
    {
        Produto p1 = new Produto();
        p1.setCodigo(1);
        p1.setNome("Leffe Blonde 330ml");
        p1.setDescricao("A Leffe Blonde tem maltes selecionados que criam uma cerveja mais encorpada e turva. Seu aroma é extremamente maltado, com notas leves de fermento. Já seu sabor é único, com notas adocicadas e refrescantes e, ainda assim, lúpulo marcante.");
        p1.setPreco(8.9);
        ArrayList<String> imgs1 = new ArrayList<String>();
        imgs1.add("http://statick3.bseller.com.br/product/57381/3479849_Lef-blo-01w.jpg");
        imgs1.add("http://statick3.bseller.com.br/product/57381/3479849_Lef-blo-02w.jpg");
        imgs1.add("http://statick3.bseller.com.br/product/57381/3479849_Lef-blo-03w.jpg");
        p1.setImagens(imgs1);
        
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        produtos.add(p1);
        
        this.carrinho.setId(777);
        this.carrinho.setProdutos(produtos);
    }
    
    public void limpar() {
        carrinho.limpar();
    }
    
}
