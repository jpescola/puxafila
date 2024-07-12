/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Fila;

/**
 *
 * @author jpescola
 */
public class FilaController extends Controller<Fila>{

    @Override
    public boolean salvar(Fila t) {
        return super.salvar(t); 
    }

    @Override
    public boolean excluir(Fila t) {
        return super.excluir(t); 
    }
    
    public List<Fila> buscar(String campo, String valor) {
        return super.listar(Fila.class, campo, valor); 
    }

    public List<Fila> buscar(String campo, int valor) {
        return super.listar(Fila.class, campo, valor); 
    }

    public Fila get(int id) {
        return super.get(Fila.class, id); 
    }
    
    public List<Fila> listar() {
        return super.listar(Fila.class, "nome", ""); 
    }
}
