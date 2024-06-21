/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author jpescola
 */

@Entity
public class Senha implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String numero;
    private Date criacao;
    
    @ManyToOne
    private Fila fila;

    public Senha() {
    }

    public Senha(int id, String numero, Date criacao, Fila fila) {
        this.id = id;
        this.numero = numero;
        this.criacao = criacao;
        this.fila = fila;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }
    
    
    
}
