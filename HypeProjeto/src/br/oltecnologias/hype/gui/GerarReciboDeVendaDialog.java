/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.model.GeradorDeRecibo;
import br.oltecnologias.hype.model.Venda;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class GerarReciboDeVendaDialog extends java.awt.Dialog {

    public GerarReciboDeVendaDialog(java.awt.Frame parent, Venda venda) {
        super(parent);
        this.venda = venda;
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
        valorQueResta = venda.getValor() - venda.getJaPago();
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

        labelValorRecibo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelValorRecibo.setForeground(new java.awt.Color(0, 153, 51));
        this.valorRecibo = new BigDecimal(venda.getValor()/venda.getQuantidadeParcelas()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
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

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(labelQtdParcelas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboQuantidadeParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(labelValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelValorRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQtdParcelas)
                    .addComponent(comboQuantidadeParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValor)
                    .addComponent(labelValorRecibo))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelObrigatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoGerar)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoGerar)
                    .addComponent(labelObrigatorio))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarActionPerformed
        try {
            GeradorDeRecibo.getInstance().gerarEImprimirPxReciboDeVenda(venda, valorRecibo);

            //gerarSelecionado = true; //O botão gerar foi selecionado
            setVisible(false);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel imprimir o recibo"+e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoGerarActionPerformed

    private void comboQuantidadeParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboQuantidadeParcelasActionPerformed
        valorRecibo = new BigDecimal(valorQueResta/Integer.parseInt((String) comboQuantidadeParcelas.getSelectedItem())).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        labelValorRecibo.setText("R$ "+valorRecibo);
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
    
    /*public boolean alterarDados() {        
        gerarSelecionado = false;  //Marcamos que o salvar não foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible após ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return gerarSelecionado;   //Retornamos true, se ele pressionou ok.
    }
    
    public double getValorRecibo() {
        return valorRecibo;
    }*/

    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresPreco = 10;
    //protected boolean gerarSelecionado;
    private Venda venda;
    private double valorRecibo;
    private double valorQueResta;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoGerar;
    private javax.swing.JComboBox comboQuantidadeParcelas;
    private javax.swing.JLabel labelObrigatorio;
    private javax.swing.JLabel labelQtdParcelas;
    private javax.swing.JLabel labelValor;
    private javax.swing.JLabel labelValorRecibo;
    private javax.swing.JPanel painelDados;
    // End of variables declaration//GEN-END:variables
}
