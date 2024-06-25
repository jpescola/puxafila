/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Caixa;

/**
 *
 * @author jpescola
 */
public class CaixaController extends Controller<Caixa>{

    @Override
    public boolean salvar(Caixa t) {
        return super.salvar(t); 
    }

    @Override
    public boolean excluir(Caixa t) {
        return super.excluir(t); 
    }
    
    public List<Caixa> buscar(String campo, String valor) {
        return super.listar(Caixa.class, campo, valor); 
    }

    public Caixa get(int id) {
        return super.get(Caixa.class, id); 
    }
    
    public List<Caixa> listar() {
        return super.listar(Caixa.class, "nome", ""); 
    }

    public Caixa acesso(String login, String senha) {
        for (Caixa c : buscar("login", login))
            if (c.getSenha().equals(senha))
                return c;
        return null;
    }
}
