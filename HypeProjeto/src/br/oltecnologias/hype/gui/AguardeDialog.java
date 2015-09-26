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

    public AguardeDialog(java.awt.Frame parent) {
        super(parent);
        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelAguarde = new javax.swing.JPanel();
        labelAguarde = new javax.swing.JLabel();

        setAlwaysOnTop(true);
        setBackground(java.awt.Color.white);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelAguarde.setBackground(new java.awt.Color(255, 255, 255));
        painelAguarde.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), null));

        labelAguarde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Aguarde.gif"))); // NOI18N

        javax.swing.GroupLayout painelAguardeLayout = new javax.swing.GroupLayout(painelAguarde);
        painelAguarde.setLayout(painelAguardeLayout);
        painelAguardeLayout.setHorizontalGroup(
            painelAguardeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAguardeLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(labelAguarde, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        painelAguardeLayout.setVerticalGroup(
            painelAguardeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAguardeLayout.createSequentialGroup()
                .addComponent(labelAguarde, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelAguarde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelAguarde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelAguarde;
    private javax.swing.JPanel painelAguarde;
    // End of variables declaration//GEN-END:variables
}
