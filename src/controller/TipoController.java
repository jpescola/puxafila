/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Tipo;

/**
 *
 * @author jpescola
 */
public class TipoController extends Controller<Tipo>{

    @Override
    public boolean salvar(Tipo t) {
        return super.salvar(t); 
    }

    @Override
    public boolean excluir(Tipo t) {
        return super.excluir(t); 
    }
    
    public List<Tipo> buscar(String campo, String valor) {
        return super.listar(Tipo.class, campo, valor); 
    }

    public Tipo get(int id) {
        return super.get(Tipo.class, id); 
    }
    
    public List<Tipo> listar() {
        return super.listar(Tipo.class, "nome", ""); 
    }
}
