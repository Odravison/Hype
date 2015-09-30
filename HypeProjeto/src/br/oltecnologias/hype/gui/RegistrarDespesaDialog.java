/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.model.Despesa;
import br.oltecnologias.hype.model.Movimentacao;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class RegistrarDespesaDialog extends java.awt.Dialog {
    
    public RegistrarDespesaDialog(java.awt.Frame owner) {
        super(owner);
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Salvar.png")));
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Cancelar.png")));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDadosGerais = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelValor = new javax.swing.JLabel();
        campoValor = new javax.swing.JTextField();
        labelFavorecido = new javax.swing.JLabel();
        campoFavorecido = new javax.swing.JTextField();
        labelObservacao = new javax.swing.JLabel();
        scPnObservacao = new javax.swing.JScrollPane();
        areaObservacao = new javax.swing.JTextArea();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelObrigatorio = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Registro de Despesa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDadosGerais.setBackground(new java.awt.Color(255, 255, 255));
        painelDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"));

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNome.setText("Nome:*");

        campoNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNomeKeyTyped(evt);
            }
        });

        labelValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValor.setText("Valor:* R$ ");

        campoValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoValorKeyTyped(evt);
            }
        });

        labelFavorecido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelFavorecido.setText("Favorecido:*");

        campoFavorecido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoFavorecido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoFavorecidoKeyTyped(evt);
            }
        });

        labelObservacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelObservacao.setText("Observação:");

        scPnObservacao.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        areaObservacao.setColumns(20);
        areaObservacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        areaObservacao.setLineWrap(true);
        areaObservacao.setRows(5);
        areaObservacao.setWrapStyleWord(true);
        areaObservacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaObservacaoKeyTyped(evt);
            }
        });
        scPnObservacao.setViewportView(areaObservacao);

        javax.swing.GroupLayout painelDadosGeraisLayout = new javax.swing.GroupLayout(painelDadosGerais);
        painelDadosGerais.setLayout(painelDadosGeraisLayout);
        painelDadosGeraisLayout.setHorizontalGroup(
            painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosGeraisLayout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosGeraisLayout.createSequentialGroup()
                        .addGroup(painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosGeraisLayout.createSequentialGroup()
                                .addComponent(labelObservacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scPnObservacao))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosGeraisLayout.createSequentialGroup()
                                .addComponent(labelValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(labelFavorecido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoFavorecido, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))))
        );
        painelDadosGeraisLayout.setVerticalGroup(
            painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValor)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFavorecido)
                    .addComponent(campoFavorecido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObservacao)
                    .addComponent(scPnObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoSalvar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoSalvar.setText(" Salvar ");
        botaoSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        labelObrigatorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelObrigatorio.setText("Obrigatório *");

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
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar))
                    .addComponent(painelDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoSalvar)
                        .addComponent(botaoCancelar))
                    .addComponent(labelObrigatorio))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        try {
            if(campoNome.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o nome da despesa", "Aviso", JOptionPane.WARNING_MESSAGE);
            }else if(campoValor.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o valor da despesa", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoFavorecido.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o favorecido da despesa", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                
                novaDespesa = GerenciadorDoSistema.getInstance().cadastrarDespesa(new Despesa(campoNome.getText(), areaObservacao.getText(), 
                        Calendar.getInstance(), Double.parseDouble(campoValor.getText()), GerenciadorDoSistema.getInstance().getUsuarioLogado().getNome(),
                        campoFavorecido.getText()));
                        
                novaMovimentacao = GerenciadorDoSistema.getInstance().adicionarMovimentacaoDeDespesa(novaDespesa);
                
                JOptionPane.showMessageDialog(null, "Despesa registrada com sucesso!");
                
                salvarSelecionado = true; //O botão Salvar foi selecionado
                setVisible(false);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void campoNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeKeyTyped
        validarLetrasETamanho(evt, campoNome, maxCaracteresNome);
    }//GEN-LAST:event_campoNomeKeyTyped

    private void campoValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoValorKeyTyped
        if((!numeros.contains(evt.getKeyChar()+"") && evt.getKeyChar() != '.')
                || campoValor.getText().length() >= maxCaracteresValor) {
            
            evt.consume(); 
        }
    }//GEN-LAST:event_campoValorKeyTyped

    private void campoFavorecidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFavorecidoKeyTyped
        if(campoFavorecido.getText().length()>= maxCaracteresNome){ 
            evt.consume(); 
        }
    }//GEN-LAST:event_campoFavorecidoKeyTyped

    private void areaObservacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaObservacaoKeyTyped
        if(areaObservacao.getText().length()+1 >= maxCaracteresObs) {
            evt.consume();
        }
    }//GEN-LAST:event_areaObservacaoKeyTyped

    private void validarLetrasETamanho(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int maxCaracteres) { 
        if(numeros.contains(evt.getKeyChar()+"")){// se o carácter que gerou o evento estiver na lista 
            evt.consume();
        } 
        if(campo.getText().length()>= maxCaracteres){
            evt.consume();
        }
    }
    
    public void validarNumerosETamanho(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int maxCaracteres) {
        if(!numeros.contains(evt.getKeyChar()+"")){// se o carácter que gerou o evento não estiver na lista 
            evt.consume();
        } 
        if(campo.getText().length()>= maxCaracteres){
            evt.consume();
        }
    }
    
    public boolean alterarDados() {        
        salvarSelecionado = false;  //Marcamos que o ok n�o foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible ap�s ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return salvarSelecionado;   //Retornamos true, se ele pressionou ok.
    }
    
    public Movimentacao getNovaMovimentacao() {
        return novaMovimentacao;
    }

    protected boolean salvarSelecionado;
    protected Movimentacao novaMovimentacao;
    protected Despesa novaDespesa;
    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresNome = 30;
    private int maxCaracteresValor = 10;
    private int maxCaracteresObs = 250;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaObservacao;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoFavorecido;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoValor;
    private javax.swing.JLabel labelFavorecido;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelObrigatorio;
    private javax.swing.JLabel labelObservacao;
    private javax.swing.JLabel labelValor;
    private javax.swing.JPanel painelDadosGerais;
    private javax.swing.JScrollPane scPnObservacao;
    // End of variables declaration//GEN-END:variables
}
