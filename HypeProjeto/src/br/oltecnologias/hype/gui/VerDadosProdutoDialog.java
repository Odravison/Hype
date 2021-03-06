/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.model.Produto;

/**
 *
 * @author Luender Lima
 */
public class VerDadosProdutoDialog extends java.awt.Dialog {

    public VerDadosProdutoDialog(java.awt.Frame parent, Produto produto) {
        super(parent);
        this.produto = produto;
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDadosGerais = new javax.swing.JPanel();
        painelIdentificacao = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        labelCor = new javax.swing.JLabel();
        labelFinalidade = new javax.swing.JLabel();
        painelValores = new javax.swing.JPanel();
        labelTamanho = new javax.swing.JLabel();
        labelQuantidade = new javax.swing.JLabel();
        labelPreco = new javax.swing.JLabel();
        labelFornecedor = new javax.swing.JLabel();
        botaook = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Dados do produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDadosGerais.setBackground(new java.awt.Color(255, 255, 255));
        painelDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"));

        painelIdentificacao.setBackground(new java.awt.Color(255, 255, 255));
        painelIdentificacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificação"));

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNome.setText("Nome: "+produto.getNome());

        labelCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCodigo.setText("Código: "+produto.getCodigo());

        labelCor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCor.setText("Cor: "+produto.getCor());

        labelFinalidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelFinalidade.setText("Finalidade: "+produto.getFinalidade());

        javax.swing.GroupLayout painelIdentificacaoLayout = new javax.swing.GroupLayout(painelIdentificacao);
        painelIdentificacao.setLayout(painelIdentificacaoLayout);
        painelIdentificacaoLayout.setHorizontalGroup(
            painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelIdentificacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelIdentificacaoLayout.createSequentialGroup()
                        .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(labelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelIdentificacaoLayout.createSequentialGroup()
                        .addComponent(labelCor, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(labelFinalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelIdentificacaoLayout.setVerticalGroup(
            painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelIdentificacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFinalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        painelValores.setBackground(new java.awt.Color(255, 255, 255));
        painelValores.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));
        painelValores.setPreferredSize(new java.awt.Dimension(629, 100));

        labelTamanho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTamanho.setText("Tamanho: "+produto.getTam());

        labelQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQuantidade.setText("Quantidade: "+produto.getQuantidade());

        labelPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPreco.setText("Preço: "+produto.getValorInString());

        javax.swing.GroupLayout painelValoresLayout = new javax.swing.GroupLayout(painelValores);
        painelValores.setLayout(painelValoresLayout);
        painelValoresLayout.setHorizontalGroup(
            painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelValoresLayout.setVerticalGroup(
            painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        labelFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelFornecedor.setText("Fornecedor: "+produto.getFornecedor());

        javax.swing.GroupLayout painelDadosGeraisLayout = new javax.swing.GroupLayout(painelDadosGerais);
        painelDadosGerais.setLayout(painelDadosGeraisLayout);
        painelDadosGeraisLayout.setHorizontalGroup(
            painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelValores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelIdentificacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(painelDadosGeraisLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelDadosGeraisLayout.setVerticalGroup(
            painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelValores, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        botaook.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaook.setText("  OK  ");
        botaook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaook)
                    .addComponent(painelDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaook)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaookActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaookActionPerformed


    private Produto produto;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaook;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelCor;
    private javax.swing.JLabel labelFinalidade;
    private javax.swing.JLabel labelFornecedor;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JLabel labelTamanho;
    private javax.swing.JPanel painelDadosGerais;
    private javax.swing.JPanel painelIdentificacao;
    private javax.swing.JPanel painelValores;
    // End of variables declaration//GEN-END:variables
}
