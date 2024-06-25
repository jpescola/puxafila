/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;
import model.Caixa;
import model.Login;

/**
 *
 * @author jpescola
 */
public class LoginController extends Controller<Login> {

    private static Login instance = null;

    private LoginController(Caixa caixa) {
        try {
            instance = new Login(
                    0,
                    new Date(),
                    InetAddress.getLocalHost().getHostName(),
                    util.Net.getIps(),
                    caixa);
            salvar(instance);
        } catch (Exception e) {

        }
    }

    public static Login getInstance() {
        return instance;
    }

    public static Login getInstance(Caixa caixa) {
        if (instance == null) {
            new LoginController(caixa);
        }
        return instance;
    }

    public List<Login> buscar(String campo, String valor) {
        return super.listar(Login.class, campo, valor);
    }

    public Login get(int id) {
        return super.get(Login.class, id);
    }

    public List<Login> listar() {
        return super.listar(Login.class, "pc", "");
    }
}
