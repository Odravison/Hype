/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.exception.TemporadaInexistenteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class AtivarTemporadaDialog extends java.awt.Dialog {


    public AtivarTemporadaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDados = new javax.swing.JPanel();
        labelPercentualDescontoLocacao = new javax.swing.JLabel();
        campoPercentualDescontoLocacao = new javax.swing.JTextField();
        labelSimboloPorcento = new javax.swing.JLabel();
        labelTemporadaLocacao = new javax.swing.JLabel();
        painelCorLocacao = new javax.swing.JPanel();
        sliderTemporadaLocacao = new javax.swing.JSlider();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelDados1 = new javax.swing.JPanel();
        labelPercentualDescontoVenda = new javax.swing.JLabel();
        campoPercentualDescontoVenda = new javax.swing.JTextField();
        labelSimboloPorcento1 = new javax.swing.JLabel();
        labelTemporadaVenda = new javax.swing.JLabel();
        painelCorVenda = new javax.swing.JPanel();
        sliderTemporadaVenda = new javax.swing.JSlider();

        setBackground(java.awt.Color.white);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Temporada de Desconto de Locações"));

        labelPercentualDescontoLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPercentualDescontoLocacao.setText("Percentual de desconto para produtos de locação: ");

        campoPercentualDescontoLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoPercentualDescontoLocacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPercentualDescontoLocacaoKeyTyped(evt);
            }
        });

        labelSimboloPorcento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelSimboloPorcento.setText("%");

        labelTemporadaLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTemporadaLocacao.setText("Temporada Desativada:");

        painelCorLocacao.setBackground(new java.awt.Color(204, 0, 0));
        painelCorLocacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout painelCorLocacaoLayout = new javax.swing.GroupLayout(painelCorLocacao);
        painelCorLocacao.setLayout(painelCorLocacaoLayout);
        painelCorLocacaoLayout.setHorizontalGroup(
            painelCorLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );
        painelCorLocacaoLayout.setVerticalGroup(
            painelCorLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        sliderTemporadaLocacao.setBackground(new java.awt.Color(255, 255, 255));
        sliderTemporadaLocacao.setPaintTrack(false);
        sliderTemporadaLocacao.setSnapToTicks(true);
        sliderTemporadaLocacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sliderTemporadaLocacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderTemporadaLocacao.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderTemporadaLocacaoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(labelPercentualDescontoLocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPercentualDescontoLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSimboloPorcento)
                        .addContainerGap(90, Short.MAX_VALUE))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(labelTemporadaLocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelCorLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sliderTemporadaLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPercentualDescontoLocacao)
                    .addComponent(campoPercentualDescontoLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSimboloPorcento))
                .addGap(16, 16, 16)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTemporadaLocacao)
                    .addComponent(painelCorLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sliderTemporadaLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        try {
            if(GerenciadorDoSistema.getInstance().isTemporadaAtivada("LOCAÇÃO")) {
                campoPercentualDescontoLocacao.setText(Integer.toString(GerenciadorDoSistema.getInstance().getPercentualDescontoTemporada("LOCAÇÃO")));
                campoPercentualDescontoLocacao.setEditable(false);
                painelCorLocacao.setBackground(new java.awt.Color(0, 153, 51));
                sliderTemporadaLocacao.setValue(100);
                labelTemporadaLocacao.setText("Temporada Ativada:");
            }
        } catch(TemporadaInexistenteException e) {
            sliderTemporadaLocacao.setValue(0);
            labelTemporadaLocacao.setText("Temporada Desativada:");
            painelCorLocacao.setBackground(new java.awt.Color(204, 0, 0));
        }

        botaoSalvar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoSalvar.setText(" Salvar ");
        botaoSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSalvar.setIcon(new ImageIcon("Imagens\\Salvar.png"));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.setIcon(new ImageIcon("Imagens\\Cancelar.png"));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        painelDados1.setBackground(new java.awt.Color(255, 255, 255));
        painelDados1.setBorder(javax.swing.BorderFactory.createTitledBorder("Temporada de Desconto de Vendas"));

        labelPercentualDescontoVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPercentualDescontoVenda.setText("Percentual de desconto para produtos de venda:");

        campoPercentualDescontoVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoPercentualDescontoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPercentualDescontoVendaKeyTyped(evt);
            }
        });

        labelSimboloPorcento1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelSimboloPorcento1.setText("%");

        labelTemporadaVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTemporadaVenda.setText("Temporada Desativada:");

        painelCorVenda.setBackground(new java.awt.Color(204, 0, 0));
        painelCorVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout painelCorVendaLayout = new javax.swing.GroupLayout(painelCorVenda);
        painelCorVenda.setLayout(painelCorVendaLayout);
        painelCorVendaLayout.setHorizontalGroup(
            painelCorVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );
        painelCorVendaLayout.setVerticalGroup(
            painelCorVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        sliderTemporadaVenda.setBackground(new java.awt.Color(255, 255, 255));
        sliderTemporadaVenda.setPaintTrack(false);
        sliderTemporadaVenda.setSnapToTicks(true);
        sliderTemporadaVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sliderTemporadaVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderTemporadaVenda.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderTemporadaVendaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout painelDados1Layout = new javax.swing.GroupLayout(painelDados1);
        painelDados1.setLayout(painelDados1Layout);
        painelDados1Layout.setHorizontalGroup(
            painelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDados1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDados1Layout.createSequentialGroup()
                        .addComponent(labelPercentualDescontoVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPercentualDescontoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSimboloPorcento1)
                        .addContainerGap(102, Short.MAX_VALUE))
                    .addGroup(painelDados1Layout.createSequentialGroup()
                        .addComponent(labelTemporadaVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelCorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sliderTemporadaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        painelDados1Layout.setVerticalGroup(
            painelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDados1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPercentualDescontoVenda)
                    .addComponent(campoPercentualDescontoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSimboloPorcento1))
                .addGroup(painelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDados1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(painelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTemporadaVenda)
                            .addComponent(painelCorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDados1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(sliderTemporadaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        try {
            if(GerenciadorDoSistema.getInstance().isTemporadaAtivada("VENDA")) {
                campoPercentualDescontoVenda.setText(Integer.toString(GerenciadorDoSistema.getInstance().getPercentualDescontoTemporada("VENDA")));
                campoPercentualDescontoVenda.setEditable(false);
                painelCorVenda.setBackground(new java.awt.Color(0, 153, 51));
                sliderTemporadaVenda.setValue(100);
                labelTemporadaVenda.setText("Temporada Ativada:");
            }
        } catch(TemporadaInexistenteException e) {
            sliderTemporadaVenda.setValue(0);
            labelTemporadaVenda.setText("Temporada Desativada:");
            painelCorVenda.setBackground(new java.awt.Color(204, 0, 0));
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelDados1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDados1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void sliderTemporadaLocacaoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderTemporadaLocacaoStateChanged
        if(sliderTemporadaLocacao.getValue() > 60) {
            sliderTemporadaLocacao.setBackground(new java.awt.Color(0, 153, 51));
            labelTemporadaLocacao.setText("Temporada Ativada: ");
            painelCorLocacao.setBackground(new java.awt.Color(0, 153, 51));
            sliderTemporadaLocacao.setValue(100);
            
        } else {
            labelTemporadaLocacao.setText("Temporada desativada: ");
            sliderTemporadaLocacao.setBackground(new java.awt.Color(204, 0, 0));
            painelCorLocacao.setBackground(new java.awt.Color(204, 0, 0));
            sliderTemporadaLocacao.setValue(0);
            campoPercentualDescontoLocacao.setEditable(true);
        }
    }//GEN-LAST:event_sliderTemporadaLocacaoStateChanged

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        try {            
            boolean ativou = false;
            
            if(sliderTemporadaLocacao.getValue() > 60) {
                String percentualDescontoLocacao = campoPercentualDescontoLocacao.getText();
                if (percentualDescontoLocacao.length() <= 0) {
                    JOptionPane.showMessageDialog(null, "Informe o percentual de desconto para os produtos de locação", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else if (percentualDescontoLocacao.length() > 0 && Integer.parseInt(percentualDescontoLocacao) > 100) {
                    JOptionPane.showMessageDialog(null, "O percentual de desconto não pode estar acima de 100%", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                
                    GerenciadorDoSistema.getInstance().setTemporada(); 
                    GerenciadorDoSistema.getInstance().ativarTemporada(Integer.parseInt(percentualDescontoLocacao),
                            "LOCAÇÃO");
                    JOptionPane.showMessageDialog(null, "Temporada ativada para produtos de locação com "+percentualDescontoLocacao+"% de desconto");
                    ativou = true;
                }
            } else {
                try {
                    if(GerenciadorDoSistema.getInstance().isTemporadaAtivada("LOCAÇÃO")) {
                        GerenciadorDoSistema.getInstance().desativarTemporada("LOCAÇÃO"); //de locação
                        JOptionPane.showMessageDialog(null, "Temporada de descontos para produtos de locação desativada");
                        ativou = true;
                    }
                } catch(TemporadaInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                } 
            } 
            if(sliderTemporadaVenda.getValue() > 60) {
                String percentualDescontoVenda =  campoPercentualDescontoVenda.getText();
                if (percentualDescontoVenda.length() <= 0) {
                    JOptionPane.showMessageDialog(null, "Informe o percentual de desconto para os produtos de venda", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else if (percentualDescontoVenda.length() > 0 && Integer.parseInt(percentualDescontoVenda) > 100) {
                    JOptionPane.showMessageDialog(null, "O percentual de desconto não pode estar acima de 100%", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    GerenciadorDoSistema.getInstance().setTemporada(); //Ativar temporada de venda
                    GerenciadorDoSistema.getInstance().ativarTemporada(Integer.parseInt(percentualDescontoVenda),
                            "VENDA");
                    JOptionPane.showMessageDialog(null, "Temporada ativada para produtos de venda com " + percentualDescontoVenda + "% de desconto");
                    ativou = true;
                }
            } else {
                try {
                    if(GerenciadorDoSistema.getInstance().isTemporadaAtivada("VENDA")) {
                        GerenciadorDoSistema.getInstance().desativarTemporada("VENDA"); //de venda
                        JOptionPane.showMessageDialog(null, "Temporada de descontos para produtos de venda desativada");
                        ativou = true;
                    } 
                } catch(TemporadaInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                } 
            }
            
            if(ativou) {
                setVisible(false);
            } 
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void campoPercentualDescontoLocacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPercentualDescontoLocacaoKeyTyped
        validarNumerosETamanho(evt, campoPercentualDescontoLocacao, maxCaracteresPercentual);
    }//GEN-LAST:event_campoPercentualDescontoLocacaoKeyTyped

    private void campoPercentualDescontoVendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPercentualDescontoVendaKeyTyped
        validarNumerosETamanho(evt, campoPercentualDescontoVenda, maxCaracteresPercentual);
    }//GEN-LAST:event_campoPercentualDescontoVendaKeyTyped

    private void sliderTemporadaVendaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderTemporadaVendaStateChanged
        if(sliderTemporadaVenda.getValue() > 60) {
            sliderTemporadaVenda.setBackground(new java.awt.Color(0, 153, 51));
            labelTemporadaVenda.setText("Temporada Ativada: ");
            painelCorVenda.setBackground(new java.awt.Color(0, 153, 51));
            sliderTemporadaVenda.setValue(100);
            
        } else {
            labelTemporadaVenda.setText("Temporada desativada: ");
            sliderTemporadaVenda.setBackground(new java.awt.Color(204, 0, 0));
            painelCorVenda.setBackground(new java.awt.Color(204, 0, 0));
            sliderTemporadaVenda.setValue(0);
            campoPercentualDescontoVenda.setEditable(true);
        }
    }//GEN-LAST:event_sliderTemporadaVendaStateChanged

    public void validarNumerosETamanho(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int maxCaracteres) {
        if(!numeros.contains(evt.getKeyChar()+"") || campo.getText().length()>= maxCaracteres
                || Integer.parseInt(campo.getText()+evt.getKeyChar()) > 100){
            evt.consume();
        } 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AtivarTemporadaDialog dialog = new AtivarTemporadaDialog(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresPercentual = 3;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoPercentualDescontoLocacao;
    private javax.swing.JTextField campoPercentualDescontoVenda;
    private javax.swing.JLabel labelPercentualDescontoLocacao;
    private javax.swing.JLabel labelPercentualDescontoVenda;
    private javax.swing.JLabel labelSimboloPorcento;
    private javax.swing.JLabel labelSimboloPorcento1;
    private javax.swing.JLabel labelTemporadaLocacao;
    private javax.swing.JLabel labelTemporadaVenda;
    private javax.swing.JPanel painelCorLocacao;
    private javax.swing.JPanel painelCorVenda;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelDados1;
    private javax.swing.JSlider sliderTemporadaLocacao;
    private javax.swing.JSlider sliderTemporadaVenda;
    // End of variables declaration//GEN-END:variables
}
