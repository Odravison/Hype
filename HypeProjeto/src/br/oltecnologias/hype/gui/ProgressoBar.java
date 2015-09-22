/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

/**
 *
 * @author Odravison
 */
public class ProgressoBar extends javax.swing.JDialog {

    public ProgressoBar() {
        
    }
    
    public void iniciar(){
        initComponents();
        this.labelAguarde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Aguarde.gif")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelGeral = new javax.swing.JPanel();
        labelAguarde = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        painelGeral.setBackground(new java.awt.Color(255, 255, 255));
        painelGeral.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), null));

        labelAguarde.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAguarde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Aguarde.gif"))); // NOI18N

        javax.swing.GroupLayout painelGeralLayout = new javax.swing.GroupLayout(painelGeral);
        painelGeral.setLayout(painelGeralLayout);
        painelGeralLayout.setHorizontalGroup(
            painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGeralLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelAguarde)
                .addGap(60, 60, 60))
        );
        painelGeralLayout.setVerticalGroup(
            painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAguarde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelAguarde;
    private javax.swing.JPanel painelGeral;
    // End of variables declaration//GEN-END:variables

}
