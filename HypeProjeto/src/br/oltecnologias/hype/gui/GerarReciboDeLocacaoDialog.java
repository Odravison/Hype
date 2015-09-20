/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDeLocacao;
import br.oltecnologias.hype.model.GeradorDeRecibo;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Venda;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class GerarReciboDeLocacaoDialog extends java.awt.Dialog {

    public GerarReciboDeLocacaoDialog(java.awt.Frame parent, Locacao locacao) {
        super(parent);
        this.locacao = locacao;
        valorQueResta = locacao.getValorLocacao() - locacao.getJaPago();
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
        calcularQuantidadeParcelas();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelObrigatorio = new javax.swing.JLabel();
        botaoGerar = new javax.swing.JButton();
        painelDados = new javax.swing.JPanel();
        labelValor = new javax.swing.JLabel();
        labelValorRecibo = new javax.swing.JLabel();
        labelQtdParcelas = new javax.swing.JLabel();
        comboQuantidadeParcelas = new javax.swing.JComboBox();
        labelValorTotal = new javax.swing.JLabel();
        labelValorResta = new javax.swing.JLabel();

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
        this.valorRecibo = new BigDecimal(locacao.getValorLocacao()/locacao.getParcelas()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        labelValorRecibo.setText("R$ "+valorRecibo);

        labelQtdParcelas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQtdParcelas.setText("Quantas parcelas serão pagas?");

        comboQuantidadeParcelas.setMaximumRowCount(6);
        comboQuantidadeParcelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "  1  ", "  2  ", "  3  ", "  4  ", "  5  ", "  6  " }));
        comboQuantidadeParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboQuantidadeParcelasActionPerformed(evt);
            }
        });

        labelValorTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValorTotal.setText("Valor total desta locação: R$ "+locacao.getValorLocacao());

        labelValorResta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValorResta.setText("Resta a ser pago: R$"+valorQueResta);

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
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(labelQtdParcelas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboQuantidadeParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValorResta, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQtdParcelas)
                    .addComponent(comboQuantidadeParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
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
            GeradorDeRecibo.getInstance().gerarEImprimirPxReciboDeLocacao(locacao, valorRecibo);
            
            JOptionPane.showMessageDialog(null, "O recibo foi gerado com sucesso!");
            //gerarSelecionado = true; //O botão gerar foi selecionado
            setVisible(false);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível imprimir o recibo\n\n"+e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoGerarActionPerformed

    private void comboQuantidadeParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboQuantidadeParcelasActionPerformed
        valorRecibo = valorQueResta/((comboQuantidadeParcelas.getItemCount()+1)-(comboQuantidadeParcelas.getSelectedIndex()+1));
        labelValorRecibo.setText("R$ "+new BigDecimal(valorRecibo).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
        labelValorResta.setText("Resta a ser pago: R$ "+new BigDecimal(valorQueResta-valorRecibo).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
    }//GEN-LAST:event_comboQuantidadeParcelasActionPerformed

    public void calcularQuantidadeParcelas() {
        int quantParcelas = 1;
        while(valorQueResta/quantParcelas > valorRecibo) {
            quantParcelas++;
        }
        String[] valores = new String[quantParcelas];
        for(int i=0; i < quantParcelas; i++) {
            valores[i] = i+1+"";
        }
        comboQuantidadeParcelas.setMaximumRowCount(quantParcelas);
        comboQuantidadeParcelas.setModel(new javax.swing.DefaultComboBoxModel(valores));
    }
    
    /*
    public boolean alterarDados() {        
        gerarSelecionado = false;  //Marcamos que o salvar não foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible após ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return gerarSelecionado;   //Retornamos true, se ele pressionou ok.
    } 
    
    public double getValorRecibo() {
        return valorRecibo;
    } */

    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresPreco = 10;
    //protected boolean gerarSelecionado;
    private Locacao locacao;
    private double valorRecibo;
    private double valorQueResta;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoGerar;
    private javax.swing.JComboBox comboQuantidadeParcelas;
    private javax.swing.JLabel labelObrigatorio;
    private javax.swing.JLabel labelQtdParcelas;
    private javax.swing.JLabel labelValor;
    private javax.swing.JLabel labelValorRecibo;
    private javax.swing.JLabel labelValorResta;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JPanel painelDados;
    // End of variables declaration//GEN-END:variables
}
