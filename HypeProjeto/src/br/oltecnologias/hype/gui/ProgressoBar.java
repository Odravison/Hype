/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Odravison
 */
public class ProgressoBar extends javax.swing.JDialog {

    public ProgressoBar(String mensagem) {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelGeral = new javax.swing.JPanel();
        barAguarde = new javax.swing.JProgressBar();
        labelAguarde = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        painelGeral.setBackground(new java.awt.Color(255, 255, 255));

        labelAguarde.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAguarde.setText("Por favor, aguarde");

        javax.swing.GroupLayout painelGeralLayout = new javax.swing.GroupLayout(painelGeral);
        painelGeral.setLayout(painelGeralLayout);
        painelGeralLayout.setHorizontalGroup(
            painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGeralLayout.createSequentialGroup()
                .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelGeralLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(barAguarde, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelGeralLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(labelAguarde)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        painelGeralLayout.setVerticalGroup(
            painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGeralLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelAguarde)
                .addGap(18, 18, 18)
                .addComponent(barAguarde, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setIndeterminate(boolean b) {
        //barraAguarde.setIndeterminate(b);
        new Thread() {
            public void run() {
                String mensagem = labelAguarde.getText();
                String pontosTxt = "";
                while (b) {
                    for (int i = 0; i < 100; i++) {
                        try {
                            sleep(25);
                            barAguarde.setValue(i);
                        } catch (InterruptedException e) {
                        }
                        if (i == 99) {
                            pontosTxt = ".";
                        } else if (i % 35 == 0 && i > 0) {
                            pontosTxt += ".";
                        }
                        labelAguarde.setText(mensagem + pontosTxt);
                    }
                }
            }
        }.start();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barAguarde;
    private javax.swing.JLabel labelAguarde;
    private javax.swing.JPanel painelGeral;
    // End of variables declaration//GEN-END:variables

}
