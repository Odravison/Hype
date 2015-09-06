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
        labelPercentualDesconto = new javax.swing.JLabel();
        campoPercentualDesconto = new javax.swing.JTextField();
        labelSimboloPorcento = new javax.swing.JLabel();
        labelTemporada = new javax.swing.JLabel();
        painelCor = new javax.swing.JPanel();
        sliderTemporada = new javax.swing.JSlider();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Temporada"));

        labelPercentualDesconto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPercentualDesconto.setText("Percentual de desconto da temporada:*");

        campoPercentualDesconto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoPercentualDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPercentualDescontoKeyTyped(evt);
            }
        });

        labelSimboloPorcento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelSimboloPorcento.setText("%");

        labelTemporada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTemporada.setText("Temporada Desativada:");

        painelCor.setBackground(new java.awt.Color(204, 0, 0));
        painelCor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout painelCorLayout = new javax.swing.GroupLayout(painelCor);
        painelCor.setLayout(painelCorLayout);
        painelCorLayout.setHorizontalGroup(
            painelCorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );
        painelCorLayout.setVerticalGroup(
            painelCorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        sliderTemporada.setBackground(new java.awt.Color(255, 255, 255));
        sliderTemporada.setPaintTrack(false);
        sliderTemporada.setSnapToTicks(true);
        sliderTemporada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sliderTemporada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderTemporada.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderTemporadaStateChanged(evt);
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
                        .addComponent(labelPercentualDesconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPercentualDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSimboloPorcento)
                        .addContainerGap(114, Short.MAX_VALUE))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(labelTemporada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sliderTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sliderTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPercentualDesconto)
                            .addComponent(campoPercentualDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSimboloPorcento))
                        .addGap(16, 16, 16)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTemporada)
                            .addComponent(painelCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        try {
            if(GerenciadorDoSistema.getInstance().isTemporadaAtivada()) {
                campoPercentualDesconto.setText(Integer.toString(GerenciadorDoSistema.getInstance().getPercentualDescontoTemporada()));
                campoPercentualDesconto.setEditable(false);
                painelCor.setBackground(new java.awt.Color(0, 153, 51));
                sliderTemporada.setValue(100);
                labelTemporada.setText("Temporada Ativada:");
            }
        } catch(TemporadaInexistenteException e) {
            sliderTemporada.setValue(0);
            labelTemporada.setText("Temporada Desativada:");
            painelCor.setBackground(new java.awt.Color(204, 0, 0));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar))
                    .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void sliderTemporadaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderTemporadaStateChanged
        if(sliderTemporada.getValue() > 60) {
            sliderTemporada.setBackground(new java.awt.Color(0, 153, 51));
            labelTemporada.setText("Temporada Ativada: ");
            painelCor.setBackground(new java.awt.Color(0, 153, 51));
            sliderTemporada.setValue(100);
            
        } else {
            labelTemporada.setText("Temporada desativada: ");
            sliderTemporada.setBackground(new java.awt.Color(204, 0, 0));
            painelCor.setBackground(new java.awt.Color(204, 0, 0));
            sliderTemporada.setValue(0);
            campoPercentualDesconto.setEditable(true);
        }
    }//GEN-LAST:event_sliderTemporadaStateChanged

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        try {
            if(campoPercentualDesconto.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o percentual de desconto", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoPercentualDesconto.getText().length() > 0 && Integer.parseInt(campoPercentualDesconto.getText()) > 100) { 
                JOptionPane.showMessageDialog(null, "O percentual de desconto não pode estar acima de 100%", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if (sliderTemporada.getValue() > 60) {
                System.out.println("ANTES DO SET TEMPORADA");
                GerenciadorDoSistema.getInstance().setTemporada();
                System.out.println("PASSOU DO SET TEMPORADA");
                GerenciadorDoSistema.getInstance().ativarTemporada(Integer.parseInt(campoPercentualDesconto.getText()));
                JOptionPane.showMessageDialog(null, "Temporada ativada com "+campoPercentualDesconto.getText()+"% de desconto", 
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                
            } else {
                try {
                    GerenciadorDoSistema.getInstance().getPercentualDescontoTemporada();
                    GerenciadorDoSistema.getInstance().desativarTemporada();
                    JOptionPane.showMessageDialog(null, "Temporada de descontos desativada", "Aviso", JOptionPane.WARNING_MESSAGE);
                } catch(TemporadaInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                } 
                
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void campoPercentualDescontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPercentualDescontoKeyTyped
        validarNumerosETamanho(evt, campoPercentualDesconto, maxCaracteresPercentual);
        
    }//GEN-LAST:event_campoPercentualDescontoKeyTyped

    public void validarNumerosETamanho(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int maxCaracteres) {
        if(!numeros.contains(evt.getKeyChar()+"")){// se o carácter que gerou o evento não estiver na lista 
            evt.consume();
        } 
        if(campo.getText().length()>= maxCaracteres){
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
    private javax.swing.JTextField campoPercentualDesconto;
    private javax.swing.JLabel labelPercentualDesconto;
    private javax.swing.JLabel labelSimboloPorcento;
    private javax.swing.JLabel labelTemporada;
    private javax.swing.JPanel painelCor;
    private javax.swing.JPanel painelDados;
    private javax.swing.JSlider sliderTemporada;
    // End of variables declaration//GEN-END:variables
}
