/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Dao;
import java.util.List;

/**
 *
 * @author jpescola
 */
public class Controller<T> {

    private Dao dao = null;
    
    public Controller() {
        dao = Dao.getIntance();
    }    
    
    public boolean salvar(T t) {
        return dao.salvar(t);
    }
    
    public boolean excluir(T t){
        return dao.excluir(t);
    }
    
    public List<T> listar(Class c, String campo, String valor){
        return dao.listar(c, campo, valor);
    }
    
    public List<T> listar(Class c, String campo, int valor) {
        return dao.listar(c, campo, valor);
    }

    public List<T> listarNulos(Class c, String campo) {
        return dao.listarNulos(c, campo);
    }

    public List<T> listarNaoNulos(Class c, String campo, String order) {
        return dao.listarNaoNulos(c, campo, order);
    }

    public List<T> listar(Class c) {
        return dao.listar(c);
    }
    
    public T get(Class c, int id){
        return (T)dao.get(c, id);
    }
    
}
