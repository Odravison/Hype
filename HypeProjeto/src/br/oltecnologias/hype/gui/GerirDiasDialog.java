/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.model.Configuracao;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class GerirDiasDialog extends java.awt.Dialog {

    public GerirDiasDialog(java.awt.Frame parent) {
        super(parent);
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Salvar.png")));
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Cancelar.png")));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelValores = new javax.swing.JPanel();
        labelQuantDiasAjuste = new javax.swing.JLabel();
        campoQuatDiasAjuste = new javax.swing.JTextField();
        labelQuatDiasManuntencao = new javax.swing.JLabel();
        campoQuatDiasManuntencao = new javax.swing.JTextField();
        labelQuatDiasExtravio = new javax.swing.JLabel();
        campoQuatDiasExtravio = new javax.swing.JTextField();
        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Gerir Quantidade de Dias");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelValores.setBackground(new java.awt.Color(255, 255, 255));
        painelValores.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidades"));

        labelQuantDiasAjuste.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQuantDiasAjuste.setText("Informe a quantidade de dias em que o produto locado estará em ajuste:");

        campoQuatDiasAjuste.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoQuatDiasAjuste.setPreferredSize(new java.awt.Dimension(40, 23));

        labelQuatDiasManuntencao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQuatDiasManuntencao.setText("Informe a quantidade de dias em que o produto locado ficará em manutenção:");

        campoQuatDiasManuntencao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoQuatDiasManuntencao.setPreferredSize(new java.awt.Dimension(40, 23));

        labelQuatDiasExtravio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQuatDiasExtravio.setText("Informe a quantidade de dias de atraso para que seja considerado um extravio:");

        campoQuatDiasExtravio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoQuatDiasExtravio.setPreferredSize(new java.awt.Dimension(40, 23));
        Configuracao configuracao = GerenciadorDoSistema.getInstance().getConfiguracao();
        campoQuatDiasAjuste.setText(configuracao.getDiasDaCostureira()+"");
        campoQuatDiasManuntencao.setText(configuracao.getDiasDeManutencao()+"");
        campoQuatDiasExtravio.setText(configuracao.getDiasDeExtravio()+"");

        javax.swing.GroupLayout painelValoresLayout = new javax.swing.GroupLayout(painelValores);
        painelValores.setLayout(painelValoresLayout);
        painelValoresLayout.setHorizontalGroup(
            painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelValoresLayout.createSequentialGroup()
                        .addComponent(labelQuantDiasAjuste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoQuatDiasAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelValoresLayout.createSequentialGroup()
                        .addComponent(labelQuatDiasManuntencao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoQuatDiasManuntencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelValoresLayout.createSequentialGroup()
                        .addComponent(labelQuatDiasExtravio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoQuatDiasExtravio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelValoresLayout.setVerticalGroup(
            painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelValoresLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantDiasAjuste)
                    .addComponent(campoQuatDiasAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuatDiasManuntencao)
                    .addComponent(campoQuatDiasManuntencao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuatDiasExtravio)
                    .addComponent(campoQuatDiasExtravio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoSalvar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
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
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar))
                    .addComponent(painelValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        try {
            if (campoQuatDiasAjuste.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a quantidade de dias que o produto locado ficará em ajuste", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if (campoQuatDiasManuntencao.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a quantidade de dias que o produto locado ficará em manutenção", "Aviso", JOptionPane.WARNING_MESSAGE);
            }  else if (campoQuatDiasExtravio.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a quantidade de dias de atraso para que seja considerado um extravio", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                Configuracao configuracao = GerenciadorDoSistema.getInstance().getConfiguracao();
                configuracao.setDiasDaCostureira(Integer.parseInt(campoQuatDiasAjuste.getText()));
                configuracao.setDiasDeManutencao(Integer.parseInt(campoQuatDiasManuntencao.getText()));
                configuracao.setDiasDeExtravio(Integer.parseInt(campoQuatDiasExtravio.getText()));
                GerenciadorDoSistema.getInstance().salvarEstadoDeConfiguracao(configuracao);
                
                JOptionPane.showMessageDialog(null, "Quantidades salvas com sucesso!");
                
                setVisible(false);
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoQuatDiasAjuste;
    private javax.swing.JTextField campoQuatDiasExtravio;
    private javax.swing.JTextField campoQuatDiasManuntencao;
    private javax.swing.JLabel labelQuantDiasAjuste;
    private javax.swing.JLabel labelQuatDiasExtravio;
    private javax.swing.JLabel labelQuatDiasManuntencao;
    private javax.swing.JPanel painelValores;
    // End of variables declaration//GEN-END:variables
}
