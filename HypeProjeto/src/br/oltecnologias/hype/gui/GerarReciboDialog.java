/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.model.GeradorDeRecibo;
import br.oltecnologias.hype.model.Locacao;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class GerarReciboDialog extends java.awt.Dialog {

    public GerarReciboDialog(java.awt.Frame parent, Locacao locacao) {
        super(parent);
        this.locacao = locacao;
        valorQueResta = locacao.getValorLocacao() - locacao.getJaPago();
        this.valorParcela = (locacao.getValorLocacao()-locacao.getValorDeEntrada())/locacao.getParcelas();
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelObrigatorio = new javax.swing.JLabel();
        botaoGerar = new javax.swing.JButton();
        painelDados = new javax.swing.JPanel();
        labelValor = new javax.swing.JLabel();
        labelValorRecibo = new javax.swing.JLabel();
        labelQtdParcelas = new javax.swing.JLabel();
        labelValorTotal = new javax.swing.JLabel();
        labelValorResta = new javax.swing.JLabel();
        campoQuantParcelas = new javax.swing.JTextField();
        botaoDiminuirParcela = new javax.swing.JButton();
        botaoAumentarParcela = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Gerar Recibo");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        labelObrigatorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelObrigatorio.setText("Obrigatório *");

        botaoGerar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoGerar.setText(" Gerar ");
        botaoGerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarActionPerformed(evt);
            }
        });

        painelDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Recibo"));

        labelValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValor.setText("Valor do recibo:* ");

        labelValorRecibo.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        labelValorRecibo.setForeground(new java.awt.Color(0, 153, 51));
        labelValorRecibo.setText("R$ "+new BigDecimal(valorParcela).setScale(2, RoundingMode.HALF_EVEN).doubleValue());

        labelQtdParcelas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQtdParcelas.setText("Quantas parcelas serão pagas?");

        labelValorTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValorTotal.setText("Valor total desta locação: R$ "+new BigDecimal(locacao.getValorLocacao()).setScale(2, RoundingMode.HALF_EVEN).doubleValue());

        labelValorResta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValorResta.setText("Restará a ser pago: R$ "+new BigDecimal(valorQueResta-valorParcela).setScale(2, RoundingMode.HALF_EVEN).doubleValue());

        campoQuantParcelas.setEditable(false);
        campoQuantParcelas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoQuantParcelas.setText("1");

        botaoDiminuirParcela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoDiminuirParcela.setText("-");
        botaoDiminuirParcela.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoDiminuirParcela.setPreferredSize(new java.awt.Dimension(45, 25));
        botaoDiminuirParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDiminuirParcelaActionPerformed(evt);
            }
        });

        botaoAumentarParcela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoAumentarParcela.setText("+");
        botaoAumentarParcela.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoAumentarParcela.setMinimumSize(new java.awt.Dimension(45, 25));
        botaoAumentarParcela.setPreferredSize(new java.awt.Dimension(45, 25));
        botaoAumentarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAumentarParcelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelValorResta, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                    .addGap(180, 180, 180)
                    .addComponent(labelValor)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelValorRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(72, 72, 72))
                .addGroup(painelDadosLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelQtdParcelas)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(campoQuantParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(botaoDiminuirParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(botaoAumentarParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(55, 55, 55)))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValorResta, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQtdParcelas)
                    .addComponent(campoQuantParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoDiminuirParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAumentarParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelValor)
                    .addComponent(labelValorRecibo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelObrigatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoGerar))
                    .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoGerar)
                    .addComponent(labelObrigatorio))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarActionPerformed
        try {
            GeradorDeRecibo.getInstance().gerarEImprimirPxReciboDeLocacao(locacao, new BigDecimal(valorRecibo).setScale(2, RoundingMode.HALF_EVEN).doubleValue());

            JOptionPane.showMessageDialog(null, "O recibo foi gerado com sucesso!");
            setVisible(false);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível imprimir o recibo\n\n" + e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoGerarActionPerformed

    private void botaoDiminuirParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDiminuirParcelaActionPerformed
        if(Integer.parseInt(campoQuantParcelas.getText()) > 1){
            valorRecibo = valorParcela * (Integer.parseInt(campoQuantParcelas.getText())-1);
            campoQuantParcelas.setText((Integer.parseInt(campoQuantParcelas.getText())-1)+"");
            labelValorResta.setText("Restará a ser pago: R$ " + new BigDecimal(valorQueResta - valorRecibo).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
            labelValorRecibo.setText("R$ " + new BigDecimal(valorRecibo).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
        } 
    }//GEN-LAST:event_botaoDiminuirParcelaActionPerformed

    private void botaoAumentarParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAumentarParcelaActionPerformed
        valorRecibo = valorParcela * (Integer.parseInt(campoQuantParcelas.getText())+1);
        if((new BigDecimal(valorQueResta - valorRecibo).setScale(2, RoundingMode.HALF_EVEN).doubleValue()) >= 0) {
            campoQuantParcelas.setText((Integer.parseInt(campoQuantParcelas.getText())+1)+"");
            labelValorResta.setText("Resta a ser pago: R$ " + new BigDecimal(valorQueResta - valorRecibo).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
        } else {
            valorRecibo = valorParcela * Integer.parseInt(campoQuantParcelas.getText());
        }
        labelValorRecibo.setText("R$ " + new BigDecimal(valorRecibo).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
    }//GEN-LAST:event_botaoAumentarParcelaActionPerformed

    private Locacao locacao;
    private double valorRecibo;
    private double valorParcela;
    private double valorQueResta;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAumentarParcela;
    private javax.swing.JButton botaoDiminuirParcela;
    private javax.swing.JButton botaoGerar;
    private javax.swing.JTextField campoQuantParcelas;
    private javax.swing.JLabel labelObrigatorio;
    private javax.swing.JLabel labelQtdParcelas;
    private javax.swing.JLabel labelValor;
    private javax.swing.JLabel labelValorRecibo;
    private javax.swing.JLabel labelValorResta;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JPanel painelDados;
    // End of variables declaration//GEN-END:variables
}
