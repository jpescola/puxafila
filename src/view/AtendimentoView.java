/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.LoginController;
import controller.SenhaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import model.Caixa;
import model.Senha;
import util.Msg;

/**
 *
 * @author jpescola
 */
public class AtendimentoView extends javax.swing.JFrame {

    private Caixa caixa = null;
    private int n = -1;
    private NotificacaoView v = null;

    private final String[] colunas = {"Senha", "Data", "Fila"};

    private Senha senha = new Senha(); // objeto default
    private List<Senha> senhas = new ArrayList<>(); // list para jtable
    private final SenhaController con = new SenhaController(); // controller

    /**
     * Creates new form AtendimentoView
     */
    public AtendimentoView() {
        initComponents();
//        setIconImage(new ImageIcon(getClass().getResource("/icons/Add_16x16.png")).getImage());

        tblDados.setDefaultEditor(Object.class, null); // desativa edição
        caixa = LoginController.getInstance().getCaixa();

        new Thread(t1).start();

    }

    // notifica em caso de nova senha gerada
    private final Runnable t1 = new Runnable() {
        public void run() {
            try {

                while (true) {

                    senhas = con.listarAbertas(caixa); // atualiza o arraylist com o bd
                    if (senhas.size() > n) {
                        atualizar();
                    }
                    Thread.sleep(3000);
                }

            } catch (Exception e) {
            }

        }
    };

    private void atualizar() {

        // cria o modelo novo
        DefaultTableModel m = new DefaultTableModel();
        // define os nomes das colunas
        m.setColumnIdentifiers(colunas);

        // laço para recuperar cada linha do modelo atual
        senhas = con.listarAbertas(caixa); // atualiza o arraylist com o bd
        for (Senha e : senhas) {
            m.addRow(new String[]{e.getFila().getPrefixoSenha() + e.getNumero(), util.Data.dateToString(e.getCriacao()), e.getFila().getTipo().getNome()});
        }
        // ativo o novo modelo
        tblDados.setModel(m);

        if (n != -1) { // não notificar ao iniciar a tela atual
            Senha s = senhas.get(senhas.size() - 1);
            v = new NotificacaoView("", false);
            v.setNotificacaoSenha("" + s.getFila().getPrefixoSenha() + s.getNumero());
            v.setVisible(true);
        }

        limpar();

        n = senhas.size();

    }

    private void limpar() {
        senha = new Senha();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Senhas");

        tblDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadosMouseClicked
        atender();
    }//GEN-LAST:event_tblDadosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AtendimentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtendimentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtendimentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtendimentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtendimentoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDados;
    // End of variables declaration//GEN-END:variables

    private void atender() {

        // busca o índice da linha selecionada
        int i_senha = tblDados.getSelectedRow();
        // busca o cliente correspondente ao índice selecionado na tabela
        senha = senhas.get(i_senha);

        // confirma atendimento
        if (Msg.confirmarAtendimento(senha.toString())) {

            // registra o atendimento
            senha.setAtendimento(new Date());
            senha.setCaixa(caixa);
            con.salvar(senha);

            // limpa a lista
            senhas.remove(i_senha);
            n = -1;
            atualizar();

        }

    }
}
