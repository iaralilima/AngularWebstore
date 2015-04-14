/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.ContatoDAO;
import entidades.Contato;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author LSI
 */
@Path("/contatos")
public class ContatoFacade {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contato> listar() {
        return ContatoDAO.getInstance().listar();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void cadastrar(Contato contato) {
        ContatoDAO.getInstance().cadastrar(contato);
    }
}
