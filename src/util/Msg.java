/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.swing.JOptionPane;

/**
 *
 * @author jpescola
 */
public abstract class Msg {

    private static String titulo = "PuxaFila";
    private static String sobre = "Software PuxaFila 1.0";

    public static void infoSalvar() {
        JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
    }

    public static void erroSalvar() {
        JOptionPane.showMessageDialog(null, "Erro ao salvar, procure o administrador!", titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void erroUpload() {
        JOptionPane.showMessageDialog(null, "Erro ao copiar arquivo, procure o administrador!", titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void sobre() {
        JOptionPane.showMessageDialog(null, sobre);
    }

}
