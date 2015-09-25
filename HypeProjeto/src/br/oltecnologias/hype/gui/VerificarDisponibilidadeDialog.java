/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDeProduto;
import br.oltecnologias.hype.model.Produto;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class VerificarDisponibilidadeDialog extends java.awt.Dialog {

    public VerificarDisponibilidadeDialog(java.awt.Frame parent, Produto produto) {
        super(parent);
        this.produto = produto;
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDadosConsulta = new javax.swing.JPanel();
        labelOrientacaoConsulta = new javax.swing.JLabel();
        labelDataInicial = new javax.swing.JLabel();
        dateDataInicial = new com.toedter.calendar.JDateChooser();
        labelDataFinal = new javax.swing.JLabel();
        dateDataFinal = new com.toedter.calendar.JDateChooser();
        botaoVerificar = new javax.swing.JButton();
        labelFechar = new javax.swing.JButton();
        painelResultadoConsulta = new javax.swing.JPanel();
        labelDescricaoProduto = new javax.swing.JLabel();
        labelDisponibilidade = new javax.swing.JLabel();
        labelTextoFinalResultado = new javax.swing.JLabel();
        labelObrigatorio = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setTitle("Verificar Disponibilidade de Produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDadosConsulta.setBackground(new java.awt.Color(255, 255, 255));
        painelDadosConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Consulta"));

        labelOrientacaoConsulta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelOrientacaoConsulta.setText("Informe as datas em que deseja verificar a disponibilidade do produto:");

        labelDataInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDataInicial.setText("Data Inicial:*");

        labelDataFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDataFinal.setText("Data Final:*");

        javax.swing.GroupLayout painelDadosConsultaLayout = new javax.swing.GroupLayout(painelDadosConsulta);
        painelDadosConsulta.setLayout(painelDadosConsultaLayout);
        painelDadosConsultaLayout.setHorizontalGroup(
            painelDadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosConsultaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelOrientacaoConsulta)
                .addGap(75, 75, 75))
            .addGroup(painelDadosConsultaLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(labelDataInicial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(labelDataFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        painelDadosConsultaLayout.setVerticalGroup(
            painelDadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosConsultaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelOrientacaoConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(painelDadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDataInicial)
                    .addComponent(labelDataFinal)
                    .addComponent(dateDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        botaoVerificar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoVerificar.setText("Verificar");
        botaoVerificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVerificarActionPerformed(evt);
            }
        });

        labelFechar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        labelFechar.setText("Fechar");
        labelFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelFecharActionPerformed(evt);
            }
        });

        painelResultadoConsulta.setBackground(new java.awt.Color(255, 255, 255));
        painelResultadoConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado da Consulta"));

        labelDescricaoProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelDisponibilidade.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        labelTextoFinalResultado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTextoFinalResultado.setText("para o período pesquisado");
        labelTextoFinalResultado.setVisible(false);

        javax.swing.GroupLayout painelResultadoConsultaLayout = new javax.swing.GroupLayout(painelResultadoConsulta);
        painelResultadoConsulta.setLayout(painelResultadoConsultaLayout);
        painelResultadoConsultaLayout.setHorizontalGroup(
            painelResultadoConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelResultadoConsultaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelDescricaoProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDisponibilidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTextoFinalResultado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelResultadoConsultaLayout.setVerticalGroup(
            painelResultadoConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelResultadoConsultaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(painelResultadoConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTextoFinalResultado))
                .addGap(23, 23, 23))
        );

        labelObrigatorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelObrigatorio.setText("Obrigatório *");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelObrigatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVerificar))
                    .addComponent(painelDadosConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelResultadoConsulta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDadosConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelResultadoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoVerificar)
                        .addComponent(labelFechar))
                    .addComponent(labelObrigatorio))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerificarActionPerformed
        try {
            if (dateDataFinal.getCalendar().before(dateDataInicial.getCalendar())) {
                JOptionPane.showMessageDialog(null, "A data final da consulta não pode ser anterior a data inicial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                labelDescricaoProduto.setText("O produto " + produto.getNome() + " estará");
                
                if (GerenciadorDeProduto.getInstance().consultarDisponibilidadeDeProdutoEntreDatas(
                        dateDataInicial.getCalendar(), dateDataFinal.getCalendar(), produto.getCodigo())) {

                    labelDisponibilidade.setText("DISPONÍVEL");
                    labelDisponibilidade.setForeground(new java.awt.Color(0, 153, 0));
                } else {
                    labelDisponibilidade.setText("INDISPONÍVEL");
                    labelDisponibilidade.setForeground(new java.awt.Color(255, 0, 0));
                }
                labelTextoFinalResultado.setVisible(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "É preciso informar todos os campos corretamente", "Aviso", JOptionPane.WARNING_MESSAGE);
        }        
    }//GEN-LAST:event_botaoVerificarActionPerformed

    private void labelFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelFecharActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_labelFecharActionPerformed

    private Produto produto;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVerificar;
    private com.toedter.calendar.JDateChooser dateDataFinal;
    private com.toedter.calendar.JDateChooser dateDataInicial;
    private javax.swing.JLabel labelDataFinal;
    private javax.swing.JLabel labelDataInicial;
    private javax.swing.JLabel labelDescricaoProduto;
    private javax.swing.JLabel labelDisponibilidade;
    private javax.swing.JButton labelFechar;
    private javax.swing.JLabel labelObrigatorio;
    private javax.swing.JLabel labelOrientacaoConsulta;
    private javax.swing.JLabel labelTextoFinalResultado;
    private javax.swing.JPanel painelDadosConsulta;
    private javax.swing.JPanel painelResultadoConsulta;
    // End of variables declaration//GEN-END:variables
}
