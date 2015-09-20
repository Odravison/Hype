/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.model.Movimentacao;
import java.text.SimpleDateFormat;

/**
 *
 * @author Luender Lima
 */
public class VerDadosMovimentacaoDialog extends java.awt.Dialog {
    
    public VerDadosMovimentacaoDialog(java.awt.Frame parent, Movimentacao movimentacao) {
        super(parent);
        this.movimentacao = movimentacao;
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDados = new javax.swing.JPanel();
        labelMovimento = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        labelResponsavel = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        labelBeneficiario = new javax.swing.JLabel();
        botaoOk = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Ver Venda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"));

        labelMovimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMovimento.setText("Movimento: "+movimentacao.getMovimento());

        labelValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValor.setText("Valor: "+movimentacao.getValorInString());

        labelResponsavel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelResponsavel.setText("Responsável: "+movimentacao.getResponsavel());

        labelData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelData.setText("Data: "+movimentacao.getDataInString());

        labelBeneficiario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelBeneficiario.setText("Beneficiário: "+movimentacao.getBeneficiario());

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(labelBeneficiario, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(labelMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelBeneficiario, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        botaoOk.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoOk.setText("  OK  ");
        botaoOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoOk)
                    .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoOk)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoOkActionPerformed

    private Movimentacao movimentacao;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoOk;
    private javax.swing.JLabel labelBeneficiario;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelMovimento;
    private javax.swing.JLabel labelResponsavel;
    private javax.swing.JLabel labelValor;
    private javax.swing.JPanel painelDados;
    // End of variables declaration//GEN-END:variables
}
