package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jefferson Neves
 */
public class CarrinhoDeCompras {
    
    private int id;
    private List<Produto> produtos = new ArrayList<Produto>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }
    
}
