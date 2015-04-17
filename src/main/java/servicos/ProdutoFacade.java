package servicos;

import entidades.Produto;
import dao.ProdutoDAO;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Jefferson Neves
 */
@Path("/produtos")
public class ProdutoFacade {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listar() {
        return ProdutoDAO.getInstance().listar();
    }
    
}
