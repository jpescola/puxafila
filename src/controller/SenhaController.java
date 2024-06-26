/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Caixa;
import model.Fila;
import model.Senha;

/**
 *
 * @author jpescola
 */
public class SenhaController extends Controller<Senha> {

    @Override
    public boolean salvar(Senha t) {
        return super.salvar(t);
    }

    @Override
    public boolean excluir(Senha t) {
        return super.excluir(t);
    }

    public List<Senha> buscar(String campo, String valor) {
        return super.listar(Senha.class, campo, valor);
    }

    public Senha get(int id) {
        return super.get(Senha.class, id);
    }

    public List<Senha> listar() {
        return super.listar(Senha.class);
    }

    public List<Senha> listar(Fila fila) {
        return super.listar(Senha.class, "fila", fila.getId());
    }

    public List<Senha> listarAbertas(Caixa caixa) {
        List<Senha> lista = super.listarNulos(Senha.class, "atendimento");
        List<Senha> r = new ArrayList<>();
        for (Senha s : lista) {
            if (s.getFila().getTipo() == caixa.getFila().getTipo()) {
                r.add(s);
            }
        }
        if (r.isEmpty()) { // mostra todos caso a fila específica esteja vazia
            return lista;
        }
        return r;
    }

    public int gerar(Fila fila) {
        int s = 1;
        List<Senha> lista = listar(fila);

        if (!lista.isEmpty()) {
            Senha ultima = lista.get(lista.size() - 1);
            s = ultima.getNumero() + 1;
        }
        salvar(new Senha(0, s, new Date(), fila)); // cria uma nova senha
        return s;
    }
}
