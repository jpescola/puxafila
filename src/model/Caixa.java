/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 *
 * @author jpescola
 */
@Entity
public class Caixa implements Serializable{    
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String login;
    private String senha;
    @ManyToOne
    private Fila fila;

    public Caixa() {
    }

    public Caixa(int id, String nome, String login, String senha, Fila fila) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.fila = fila;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    
}
