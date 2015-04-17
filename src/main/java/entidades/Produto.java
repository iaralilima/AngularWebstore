package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jefferson Neves
 */
public class Produto {
    
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private List<String> imagens = new ArrayList<String>();

    public Produto() {}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }
    
}
