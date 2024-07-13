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

    private static final String TITULO = "PuxaFila";
    private static final String SOBRE = "Software PuxaFila 1.0";

    public static void infoSalvar() {
        JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
    }

    public static void erroSalvar() {
        JOptionPane.showMessageDialog(null, "Erro ao salvar, procure o administrador!", TITULO, JOptionPane.ERROR_MESSAGE);
    }

    public static void erroUpload() {
        JOptionPane.showMessageDialog(null, "Erro ao copiar arquivo, procure o administrador!", TITULO, JOptionPane.ERROR_MESSAGE);
    }

    public static void SOBRE() {
        JOptionPane.showMessageDialog(null, SOBRE);
    }

    public static void info(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public static void alert(String s) {
        JOptionPane.showMessageDialog(null, s, TITULO, JOptionPane.WARNING_MESSAGE);
    }

    public static void infoSenha(String s) {
        JLabel label = new JLabel(s);
        label.setFont(new Font("Arial", Font.BOLD, 58));
        JOptionPane.showMessageDialog(null, label, TITULO, JOptionPane.INFORMATION_MESSAGE);
    }

    private static int confirm(String s) {
        Object[] options = {"Sim", "Não"};
        return JOptionPane.showOptionDialog(null, s, TITULO,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]);
    }

    public static boolean confirmar(String s) {
        return confirm(s) == 1;
    }

    public static boolean confirmarAtendimento(String senha) {
        return confirm("Confirma atendimento da senha " + senha + "?") == 0;
    }

    public static void erroLogin() {
        JOptionPane.showMessageDialog(null, "Usuário e/ou Senha incorreto(s)", TITULO, JOptionPane.ERROR_MESSAGE);
    }

}
