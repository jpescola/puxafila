/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Font;
import javax.swing.JLabel;
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

    public static void info(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public static void infoSenha(String s) {
        JLabel label = new JLabel(s);
        label.setFont(new Font("Arial", Font.BOLD, 58));
        JOptionPane.showMessageDialog(null, label, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirmar(String s) {
        return JOptionPane.showConfirmDialog(null, s, titulo, JOptionPane.QUESTION_MESSAGE) == 1;
    }

    public static boolean confirmarAtendimento(String senha) {
        return JOptionPane.showConfirmDialog(null, "Confirma atendimento da senha " + senha + "?", titulo, JOptionPane.YES_NO_OPTION) == 0;
    }

    public static void erroLogin() {
        JOptionPane.showMessageDialog(null, "Usuário e/ou Senha incorreto(s)", titulo, JOptionPane.ERROR_MESSAGE);
    }

}
