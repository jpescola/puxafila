/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.SenhaController;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.Senha;

/**
 *
 * @author jpescola
 */
public class PainelView extends javax.swing.JFrame {

    private Senha ultimaChamada = null; // objeto default
    private Senha ultimaSenha = new Senha(); // objeto default
    private List<Senha> senhas = new ArrayList<>(); // list para jtable
    private final SenhaController con = new SenhaController(); // controller

    /**
     * Creates new form PainelView1
     */
    public PainelView() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // janela maximizada
        getContentPane().setBackground(Color.white); // background 
        new Thread(t1).start();
    }

    // notifica em caso de nova senha gerada
    private final Runnable t1 = new Runnable() {
        public void run() {
            try {

                while (true) {
                    senhas = con.listarUltimasChamadas();
                    ultimaSenha = senhas.get(0);
                    if (ultimaSenha != ultimaChamada) {
                        atualizar();
                        ultimaChamada = ultimaSenha;
                    }
                    Thread.sleep(3000);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    };

    private void atualizar() {

        // atualiza o painel
        lblSenha.setText(ultimaSenha.getFila().getPrefixoSenha() + ultimaSenha.getNumero());
        lblCaixa.setText(ultimaSenha.getCaixa().getNome());
        if (ultimaChamada != null) {
            util.Som.notificacao();
        }

        String r = "<html>";
        senhas = con.listarUltimasChamadas();
        for (Senha e : senhas.subList(0, (senhas.size() < 6) ? senhas.size() : 6)) {
            r += e.getFila().getPrefixoSenha() + e.getNumero() + " Caixa " + e.getCaixa().getNome() + "<br>";
        }
        lblUltimas.setText(r);

        ultimaChamada = senhas.get(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCaixa = new javax.swing.JLabel();
        lblUltimas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 45)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Últimas chamadas:");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Caixa:");

        lblSenha.setFont(new java.awt.Font("Liberation Sans", 0, 200)); // NOI18N
        lblSenha.setText("...");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Senha:");

        lblCaixa.setFont(new java.awt.Font("Liberation Sans", 0, 200)); // NOI18N
        lblCaixa.setForeground(new java.awt.Color(0, 0, 255));
        lblCaixa.setText("0");

        lblUltimas.setFont(new java.awt.Font("Liberation Sans", 0, 60)); // NOI18N
        lblUltimas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUltimas.setText("...");
        lblUltimas.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(196, 196, 196))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCaixa)
                        .addGap(276, 276, 276))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUltimas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(lblCaixa))
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblUltimas, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PainelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PainelView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCaixa;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUltimas;
    // End of variables declaration//GEN-END:variables
}
