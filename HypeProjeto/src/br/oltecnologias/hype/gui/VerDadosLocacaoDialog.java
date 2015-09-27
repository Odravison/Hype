/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDeLocacao;
import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.model.GeradorDeContrato;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.ProdutoLocado;
import java.awt.Desktop;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class VerDadosLocacaoDialog extends java.awt.Dialog {

    public VerDadosLocacaoDialog(java.awt.Frame parent, Locacao locacao) {
        super(parent);
        this.locacao = locacao;
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDados = new javax.swing.JPanel();
        labelProdutosLocados = new javax.swing.JLabel();
        scPnProdutosVendidos = new javax.swing.JScrollPane();
        areaProdutosLocados = new javax.swing.JTextArea();
        painelDadosContrato = new javax.swing.JPanel();
        labelDataInicial = new javax.swing.JLabel();
        labelDataFinal = new javax.swing.JLabel();
        painelPagamento = new javax.swing.JPanel();
        labelFormaPagamento = new javax.swing.JLabel();
        labelParcelas = new javax.swing.JLabel();
        labelDesconto = new javax.swing.JLabel();
        labelValorTotal = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        labelValorResta = new javax.swing.JLabel();
        labelFormaPagamentoEntrada = new javax.swing.JLabel();
        labelEntrada = new javax.swing.JLabel();
        labelValorPago = new javax.swing.JLabel();
        botaoOk = new javax.swing.JButton();
        botaoGerarContrato = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Ver Locação");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Locação"));

        labelProdutosLocados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelProdutosLocados.setText("Produtos Locados:");

        areaProdutosLocados.setEditable(false);
        areaProdutosLocados.setColumns(20);
        areaProdutosLocados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        areaProdutosLocados.setLineWrap(true);
        areaProdutosLocados.setRows(5);
        areaProdutosLocados.setWrapStyleWord(true);
        String descricaoProdutosLocados = "";
        try {
            for(Produto produto: GerenciadorDeLocacao.getInstance().getProdutosDeLocacao(locacao.getId())) {
                for (ProdutoLocado pl: locacao.getProdutos()){
                    if (pl.getCodigoProduto().toUpperCase().equals(produto.getCodigo().toUpperCase())){
                        descricaoProdutosLocados += pl.getQuantidade() + " - " + produto.getDescricao()+"\n";
                    }
                }
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível exibir os produtos locado:\n"+e.getMessage(),
                "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        areaProdutosLocados.setText(descricaoProdutosLocados);
        scPnProdutosVendidos.setViewportView(areaProdutosLocados);

        painelDadosContrato.setBackground(new java.awt.Color(255, 255, 255));
        painelDadosContrato.setBorder(javax.swing.BorderFactory.createTitledBorder("Datas do Contrato"));

        labelDataInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDataInicial.setText("Data Inicial: "+locacao.getDataLocacaoInString());

        labelDataFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDataFinal.setText("Data Final: "+locacao.getDataDevolucaoInString());

        javax.swing.GroupLayout painelDadosContratoLayout = new javax.swing.GroupLayout(painelDadosContrato);
        painelDadosContrato.setLayout(painelDadosContratoLayout);
        painelDadosContratoLayout.setHorizontalGroup(
            painelDadosContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosContratoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelDataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(labelDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelDadosContratoLayout.setVerticalGroup(
            painelDadosContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosContratoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelPagamento.setBackground(new java.awt.Color(255, 255, 255));
        painelPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagamento"));

        labelFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelFormaPagamento.setText("Forma de Pagamento: "+locacao.getFormaDePagamento());

        labelParcelas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelParcelas.setText("Parcelas: "+locacao.getParcelas());

        labelDesconto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDesconto.setText("Desconto: "+locacao.getPercentualDesconto());

        labelValorTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValorTotal.setText("Valor Total: "+locacao.getValorLocacaoInString());

        labelStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelStatus.setText("Status: "+locacao.getStatus());

        labelValorResta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        double valorResta = new BigDecimal(locacao.getValorLocacao()-locacao.getJaPago()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        labelValorResta.setText("Resta a ser pago: "+NumberFormat.getCurrencyInstance().format(valorResta));

        labelFormaPagamentoEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        if(locacao.getFormaDePagamento().toUpperCase().equals("PROMISSÓRIA")) {
            labelFormaPagamentoEntrada.setText("Entrada Paga em: "+locacao.getTipoEntradaDePromissoria());
        }

        labelEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelEntrada.setText("Entrada: "+locacao.getEntradaInString());

        javax.swing.GroupLayout painelPagamentoLayout = new javax.swing.GroupLayout(painelPagamento);
        painelPagamento.setLayout(painelPagamentoLayout);
        painelPagamentoLayout.setHorizontalGroup(
            painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPagamentoLayout.createSequentialGroup()
                        .addComponent(labelFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(painelPagamentoLayout.createSequentialGroup()
                        .addGroup(painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPagamentoLayout.createSequentialGroup()
                                .addComponent(labelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelValorResta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(painelPagamentoLayout.createSequentialGroup()
                                .addComponent(labelEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelFormaPagamentoEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPagamentoLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelPagamentoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        painelPagamentoLayout.setVerticalGroup(
            painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFormaPagamentoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addComponent(labelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labelValorResta, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelValorPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValorPago.setText("Valor já pago: "+NumberFormat.getCurrencyInstance().format(locacao.getJaPago()));

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scPnProdutosVendidos, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(labelProdutosLocados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(painelPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelDadosContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProdutosLocados)
                    .addComponent(labelValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scPnProdutosVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelDadosContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        botaoOk.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoOk.setText("    OK    ");
        botaoOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        botaoGerarContrato.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoGerarContrato.setText("Gerar Contrato");
        botaoGerarContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoGerarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarContratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoGerarContrato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoOk)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoOk)
                    .addComponent(botaoGerarContrato))
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

    private void botaoGerarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarContratoActionPerformed
        try {
            GeradorDeContrato.getInstance().gerarContrato(locacao); 
            JOptionPane.showMessageDialog(null, "Contrato da locação gerado com sucesso!");
            Desktop.getDesktop().open(new File(GerenciadorDoSistema.getInstance().getConfiguracao().getDiretorioDeDocumentos()
                        +"\\"+locacao.getCliente().getNome()+"\\Contratos"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o contrato da locação", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoGerarContratoActionPerformed

    private Locacao locacao;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaProdutosLocados;
    private javax.swing.JButton botaoGerarContrato;
    private javax.swing.JButton botaoOk;
    private javax.swing.JLabel labelDataFinal;
    private javax.swing.JLabel labelDataInicial;
    private javax.swing.JLabel labelDesconto;
    private javax.swing.JLabel labelEntrada;
    private javax.swing.JLabel labelFormaPagamento;
    private javax.swing.JLabel labelFormaPagamentoEntrada;
    private javax.swing.JLabel labelParcelas;
    private javax.swing.JLabel labelProdutosLocados;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelValorPago;
    private javax.swing.JLabel labelValorResta;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelDadosContrato;
    private javax.swing.JPanel painelPagamento;
    private javax.swing.JScrollPane scPnProdutosVendidos;
    // End of variables declaration//GEN-END:variables
}
