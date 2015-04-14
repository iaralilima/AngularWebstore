/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Contato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LSI
 */
public class ContatoDAO {

    private static ContatoDAO instance;
    
    private ContatoDAO() {}
    
    public static ContatoDAO getInstance() {
        if (instance == null) {
            instance = new ContatoDAO();
        }
        return instance;
    }
    
    private List<Contato> contatos = new ArrayList<Contato>();
    
    public List<Contato> listar() {
        return contatos;
    }
    
    public void cadastrar(Contato contato) {
        contatos.add(contato);
    }
}
