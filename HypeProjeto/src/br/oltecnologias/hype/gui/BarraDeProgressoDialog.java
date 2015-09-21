/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

/**
 *
 * @author Luender Lima
 */
public class BarraDeProgressoDialog extends java.awt.Dialog {

    public BarraDeProgressoDialog(java.awt.Frame parent, String mensagem) {
        super(parent);
        initComponents();
        this.mensagem = mensagem;
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMensagemCarregando = new javax.swing.JLabel();
        barCarregando = new javax.swing.JProgressBar();

        setBackground(java.awt.Color.white);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        labelMensagemCarregando.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(barCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(labelMensagemCarregando)))
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelMensagemCarregando)
                .addGap(31, 31, 31)
                .addComponent(barCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void exibirProgresso() {
        //barCarregando.setVisible(true);
        //labelMensagemCarregando.setVisible(true);
        
        threadCarregandoSistema = new Thread() {
            public void run() {
                String pontosTxt = "";
                while (isVisible()) {                    
                    for (int i = 0; i < 100; i++) {
                        try {
                            sleep(70);
                            barCarregando.setValue(i);
                        } catch (InterruptedException e) {
                        }
                        if (i == 99) {
                            pontosTxt = "";
                        } else if (i % 25 == 0 && i > 0) {
                            pontosTxt += ".";
                        }
                        labelMensagemCarregando.setText(mensagem + " Aguarde" + pontosTxt);
                    }
                }
                
            }
        };        
        threadCarregandoSistema.start();
    }
    
    public void fecharThreadDeCarregamento() {
        threadCarregandoSistema.interrupt();
    }
    
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private String mensagem;
    private Thread threadCarregandoSistema;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barCarregando;
    private javax.swing.JLabel labelMensagemCarregando;
    // End of variables declaration//GEN-END:variables
}
