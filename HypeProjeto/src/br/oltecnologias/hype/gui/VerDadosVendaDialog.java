/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDeVenda;
import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.Venda;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class VerDadosVendaDialog extends java.awt.Dialog {
    
    public VerDadosVendaDialog(java.awt.Frame parent, Venda venda) {
        super(parent);
        this.venda = venda;
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDados = new javax.swing.JPanel();
        labelProdutosVendidos = new javax.swing.JLabel();
        scPnProdutosVendidos = new javax.swing.JScrollPane();
        areaProdutosVendidos = new javax.swing.JTextArea();
        labelFormaPagamento = new javax.swing.JLabel();
        labelEntrada = new javax.swing.JLabel();
        labelParcelas = new javax.swing.JLabel();
        labelDesconto = new javax.swing.JLabel();
        labelValorTotal = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
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
        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Venda"));

        labelProdutosVendidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelProdutosVendidos.setText("Produtos Vendidos:");

        areaProdutosVendidos.setEditable(false);
        areaProdutosVendidos.setColumns(20);
        areaProdutosVendidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        areaProdutosVendidos.setRows(5);
        String descricaoProdutosVendidos = "";
        try {
            for(Produto produto: GerenciadorDeVenda.getInstance().getProdutosDeVenda(venda.getId())) {
                descricaoProdutosVendidos += produto.getDescricao()+"\n";
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível exibir os produtos vendidos:\n"+e.getMessage(),
                "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        areaProdutosVendidos.setText(descricaoProdutosVendidos);
        scPnProdutosVendidos.setViewportView(areaProdutosVendidos);

        labelFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelFormaPagamento.setText("Forma de Pagamento: "+venda.getFormaDePagamento());

        labelEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelEntrada.setText("Entrada: "+venda.getEntradaInString());

        labelParcelas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelParcelas.setText("Parcelas: "+venda.getQuantidadeParcelas());

        labelDesconto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDesconto.setText("Desconto: "+venda.getPercentualDesconto());

        labelValorTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValorTotal.setText("Valor Total: R$ "+venda.getValorInString());

        labelData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelData.setText("Data: "+venda.getDataVendaInString());

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scPnProdutosVendidos)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelProdutosVendidos)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosLayout.createSequentialGroup()
                                        .addComponent(labelDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosLayout.createSequentialGroup()
                                        .addComponent(labelFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelData, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                        .addGap(0, 68, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelProdutosVendidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scPnProdutosVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private Venda venda;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaProdutosVendidos;
    private javax.swing.JButton botaoOk;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelDesconto;
    private javax.swing.JLabel labelEntrada;
    private javax.swing.JLabel labelFormaPagamento;
    private javax.swing.JLabel labelParcelas;
    private javax.swing.JLabel labelProdutosVendidos;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JPanel painelDados;
    private javax.swing.JScrollPane scPnProdutosVendidos;
    // End of variables declaration//GEN-END:variables
}
