/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import javax.swing.SwingWorker;

/**
 *
 * @author Luender Lima
 */
public class AguardeDialog extends java.awt.Dialog {

    public AguardeDialog(java.awt.Frame parent, String mensagem) {
        super(parent);
        this.mensagem = mensagem;
        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelAguarde = new javax.swing.JPanel();
        labelMensagem = new javax.swing.JLabel();
        barCarregando = new javax.swing.JProgressBar();

        setBackground(java.awt.Color.white);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelAguarde.setBackground(new java.awt.Color(255, 255, 255));

        labelMensagem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout painelAguardeLayout = new javax.swing.GroupLayout(painelAguarde);
        painelAguarde.setLayout(painelAguardeLayout);
        painelAguardeLayout.setHorizontalGroup(
            painelAguardeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAguardeLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(painelAguardeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAguardeLayout.createSequentialGroup()
                        .addComponent(labelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAguardeLayout.createSequentialGroup()
                        .addComponent(barCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))))
        );
        painelAguardeLayout.setVerticalGroup(
            painelAguardeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAguardeLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(labelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(barCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelAguarde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelAguarde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class ProgressoAguarde extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() throws Exception {
            System.out.println("EXECUTOU O PROGRESSOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
            String pontosTxt = "";
            int cont = 0;
            while (cont <= 900) {
                System.out.println("EXECUTOU O WHILE DO DO INBACKGROUNDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                for (int i = 0; i < 100; i++) {
                    System.out.println("VALOR DE I NO DOINBACKGROUNDddddddddddddddddddddddddddddddddddddddddddddddddddd:  "+i);
                    try {
                        Thread.sleep(40);
                        barCarregando.setValue(i);
                    } catch (InterruptedException e) {
                    }
                    if (i == 99) {
                        pontosTxt = "";
                    } else if (i % 25 == 0 && i > 0) {
                        pontosTxt += ".";
                    }
                    labelMensagem.setText(mensagem + ". Aguarde" + pontosTxt);
                }
                cont++;
            }
            return null;
        }
    }
    
    public void executarProgresso() {
        /*barCarregando.setVisible(true);
        labelMensagem.setVisible(true);
        progresso = new ProgressoAguarde();
        progresso.execute();*/
        new Thread() {
                        public void run() {
                            System.out.println("EXECUTOU O PROGRESSOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
            String pontosTxt = "";
            int cont = 0;
            while (cont <= 900) {
                System.out.println("EXECUTOU O WHILE DO DO INBACKGROUNDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                for (int i = 0; i < 100; i++) {
                    System.out.println("VALOR DE I NO DOINBACKGROUNDddddddddddddddddddddddddddddddddddddddddddddddddddd:  "+i);
                    try {
                        Thread.sleep(40);
                        barCarregando.setValue(i);
                    } catch (InterruptedException e) {
                    }
                    if (i == 99) {
                        pontosTxt = "";
                    } else if (i % 25 == 0 && i > 0) {
                        pontosTxt += ".";
                    }
                    labelMensagem.setText(mensagem + ". Aguarde" + pontosTxt);
                }
                cont++;
            }

                        }
                    }.start();
        
    }
    
    public void interromperProgresso() {
        progresso.cancel(true);
        
    }
    
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    private String mensagem;
    private ProgressoAguarde progresso;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barCarregando;
    private javax.swing.JLabel labelMensagem;
    private javax.swing.JPanel painelAguarde;
    // End of variables declaration//GEN-END:variables
}
