package dao;

import entidades.Produto;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Jefferson Neves
 */
public class ProdutoDAO {

    private static ProdutoDAO instance;
    private EntityManager em;
    
    private ProdutoDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("webstore");
        em = factory.createEntityManager();
    }
    
    public static ProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoDAO();
        }
        return instance;
    }
    
    private List<Produto> produtos = new ArrayList<Produto>();
    
    public List<Produto> listar() {
//        this.cadastrarMocks();
        Query query = em.createQuery("FROM Produto p ORDER BY p.nome");
        return query.getResultList();
    }
    
    public void cadastrar(Produto produto) {
        produtos.add(produto);
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
        
        Produto p2 = new Produto();
        p2.setCodigo(2);
        p2.setNome("Hoegaarden 330ml");
        p2.setDescricao("A Hoegaarden contém ingredientes especiais como sementes de coentro, e raspas de casca de laranja, o que lhe confere alta refrescância e drinkability.");
        p2.setPreco(9.9);
        ArrayList<String> imgs2 = new ArrayList<String>();
        imgs2.add("http://statick3.bseller.com.br/product/57288/3663658_Hoegaarden_nova1.jpg");
        imgs2.add("http://statick3.bseller.com.br/product/57288/3663658_Hoegaarden_nova2.jpg");
        imgs2.add("http://statick3.bseller.com.br/product/57288/3663658_Hoegaarden_nova3.jpg");
        p2.setImagens(imgs2);
        
        Produto p3 = new Produto();
        p3.setCodigo(3);
        p3.setNome("Franziskaner Dunkel 500ml");
        p3.setDescricao("Devido aos grãos de trigo torrados e adicionados no seu processo de produção, possui um sabor marcante e um pronunciado aroma torrado que agrada aos amantes de cerveja escura de todo o mundo. Traz um aroma marcante, sendo encorpada e refrescante.");
        p3.setPreco(11);
        ArrayList<String> imgs3 = new ArrayList<String>();
        imgs3.add("http://statick3.bseller.com.br/product/57299/3931821_Franz_Dunkel_1bco.jpg");
        imgs3.add("http://statick3.bseller.com.br/product/57299/3931830_Franz_Dunkel_zoom1.jpg");
        imgs3.add("http://statick3.bseller.com.br/product/57299/3932027_Franz_Dunkel_zoom2.jpg");
        p3.setImagens(imgs3);
        
        Produto p4 = new Produto();
        p4.setCodigo(4);
        p4.setNome("Patagonia Weisse 740ml");
        p4.setDescricao("De altíssima drinkability, a Patagonia Weisse é ideal para encontro de degustaçào, devido à sua refrescância e creme branco de excelente formação e persistência. O aroma traz notas cítricas, e suavemente frutado que contribuem para a sua leveza.");
        p4.setPreco(17.9);
        ArrayList<String> imgs4 = new ArrayList<String>();
        imgs4.add("http://statick3.bseller.com.br/product/57326/3479919_Pat-weisse-01w.jpg");
        imgs4.add("http://statick3.bseller.com.br/product/57326/3479920_Pat-weisse-02.jpg");
        imgs4.add("http://statick3.bseller.com.br/product/57326/3479921_Pat-weisse-03.jpg");
        p4.setImagens(imgs4);
        
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.getTransaction().commit();
    }
    
}
