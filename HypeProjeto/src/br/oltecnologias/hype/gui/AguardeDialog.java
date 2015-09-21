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
        jLabel1 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelAguarde.setBackground(new java.awt.Color(255, 255, 255));

        labelAguarde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Aguarde.gif"))); // NOI18N
        labelAguarde.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Aguarde...");

        javax.swing.GroupLayout painelAguardeLayout = new javax.swing.GroupLayout(painelAguarde);
        painelAguarde.setLayout(painelAguardeLayout);
        painelAguardeLayout.setHorizontalGroup(
            painelAguardeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAguardeLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(painelAguardeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAguardeLayout.createSequentialGroup()
                        .addComponent(labelAguarde, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAguardeLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(129, 129, 129))))
        );
        painelAguardeLayout.setVerticalGroup(
            painelAguardeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAguardeLayout.createSequentialGroup()
                .addComponent(labelAguarde, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(painelAguarde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelAguarde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelAguarde;
    private javax.swing.JPanel painelAguarde;
    // End of variables declaration//GEN-END:variables
}
