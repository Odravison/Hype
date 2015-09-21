/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class GerarRelatorioDialog extends java.awt.Dialog {

    public GerarRelatorioDialog(java.awt.Frame parent) {
        super(parent);
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPeriodo = new javax.swing.JPanel();
        labelGerarRelatorio = new javax.swing.JLabel();
        labelDataInicial = new javax.swing.JLabel();
        labelDataFinal = new javax.swing.JLabel();
        dateDataInicial = new com.toedter.calendar.JDateChooser();
        dateDataFinal = new com.toedter.calendar.JDateChooser();
        botaoCancelar = new javax.swing.JButton();
        botaoGerar = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Gerar Relatório");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelPeriodo.setBackground(new java.awt.Color(255, 255, 255));
        painelPeriodo.setBorder(javax.swing.BorderFactory.createTitledBorder("Período"));

        labelGerarRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelGerarRelatorio.setText("Gerar relatório entre as datas:");

        labelDataInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDataInicial.setText("Data Inicial:");

        labelDataFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDataFinal.setText("Data Final:");

        javax.swing.GroupLayout painelPeriodoLayout = new javax.swing.GroupLayout(painelPeriodo);
        painelPeriodo.setLayout(painelPeriodoLayout);
        painelPeriodoLayout.setHorizontalGroup(
            painelPeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPeriodoLayout.createSequentialGroup()
                .addGroup(painelPeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPeriodoLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(labelGerarRelatorio))
                    .addGroup(painelPeriodoLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(labelDataInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(labelDataFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        painelPeriodoLayout.setVerticalGroup(
            painelPeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPeriodoLayout.createSequentialGroup()
                .addComponent(labelGerarRelatorio)
                .addGap(32, 32, 32)
                .addGroup(painelPeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDataInicial)
                    .addComponent(labelDataFinal)
                    .addComponent(dateDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoGerar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoGerar.setText("  Gerar  ");
        botaoGerar.setToolTipText("Gerar Relatório");
        botaoGerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoGerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar))
                    .addComponent(painelPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoGerar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarActionPerformed
        try {
            if(dateDataFinal.getCalendar().before(dateDataInicial.getCalendar())) {
                JOptionPane.showMessageDialog(null, "A data final do contrato não pode ser anterior a data inicial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "O relatório será gerado em instantes. Por favor, aguarde...");
                GerenciadorDoSistema.getInstance().gerarRelatorioDeCaixa(dateDataInicial.getCalendar(), dateDataFinal.getCalendar());
            }
            setVisible(false);
            dispose();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema na geração do relatório", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoGerarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoGerar;
    private com.toedter.calendar.JDateChooser dateDataFinal;
    private com.toedter.calendar.JDateChooser dateDataInicial;
    private javax.swing.JLabel labelDataFinal;
    private javax.swing.JLabel labelDataInicial;
    private javax.swing.JLabel labelGerarRelatorio;
    private javax.swing.JPanel painelPeriodo;
    // End of variables declaration//GEN-END:variables
}
