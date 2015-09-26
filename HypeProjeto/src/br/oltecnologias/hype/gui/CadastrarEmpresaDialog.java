/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.model.Configuracao;
import br.oltecnologias.hype.model.Empresa;
import br.oltecnologias.hype.model.Endereco;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class CadastrarEmpresaDialog extends java.awt.Dialog {

    public CadastrarEmpresaDialog(java.awt.Frame parent) {
        super(parent);
        initComponents();
        icone = new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage();
        this.setIconImage(icone);
        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Salvar.png")));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDadosPessoais = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelCNPJ = new javax.swing.JLabel();
        painelEndereco = new javax.swing.JPanel();
        labelRua = new javax.swing.JLabel();
        campoRua = new javax.swing.JTextField();
        labelNumero = new javax.swing.JLabel();
        labelBairro = new javax.swing.JLabel();
        campoBairro = new javax.swing.JTextField();
        labelCidade = new javax.swing.JLabel();
        campoCidade = new javax.swing.JTextField();
        labelUf = new javax.swing.JLabel();
        comboUf = new javax.swing.JComboBox();
        campoNumero = new javax.swing.JTextField();
        labelTelefone = new javax.swing.JLabel();
        campoCnpj = new javax.swing.JFormattedTextField();
        campoTelefone = new javax.swing.JFormattedTextField();
        labelObrigatorio = new javax.swing.JLabel();
        botaoSalvar = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Cadastrar Empresa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDadosPessoais.setBackground(new java.awt.Color(255, 255, 255));
        painelDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"));

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNome.setText("Nome:*");

        campoNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNomeKeyTyped(evt);
            }
        });

        labelCNPJ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCNPJ.setText("CNPJ:*");

        painelEndereco.setBackground(new java.awt.Color(255, 255, 255));
        painelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        labelRua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelRua.setText("Rua:*");

        campoRua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoRuaKeyTyped(evt);
            }
        });

        labelNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumero.setText("Número:*");

        labelBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelBairro.setText("Bairro:*");

        campoBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBairroKeyTyped(evt);
            }
        });

        labelCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCidade.setText("Cidade:*");

        campoCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCidadeKeyTyped(evt);
            }
        });

        labelUf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelUf.setText("UF:*");

        comboUf.setMaximumRowCount(20);
        comboUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PB", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        comboUf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        campoNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumeroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout painelEnderecoLayout = new javax.swing.GroupLayout(painelEndereco);
        painelEndereco.setLayout(painelEnderecoLayout);
        painelEnderecoLayout.setHorizontalGroup(
            painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                        .addComponent(labelRua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(labelNumero))
                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                        .addComponent(labelBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(labelCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(labelUf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelEnderecoLayout.setVerticalGroup(
            painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRua)
                    .addComponent(campoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumero)
                    .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBairro)
                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCidade)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUf)
                    .addComponent(comboUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        labelTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTelefone.setText("Telefone:*");

        try {
            campoCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCnpj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            campoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout painelDadosPessoaisLayout = new javax.swing.GroupLayout(painelDadosPessoais);
        painelDadosPessoais.setLayout(painelDadosPessoaisLayout);
        painelDadosPessoaisLayout.setHorizontalGroup(
            painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(painelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCNPJ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(labelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelDadosPessoaisLayout.setVerticalGroup(
            painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCNPJ)
                    .addComponent(campoCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(painelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefone)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        labelObrigatorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelObrigatorio.setText("* Obrigatório");

        botaoSalvar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoSalvar.setText(" Salvar ");
        botaoSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Salvar.png")));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelObrigatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSalvar)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoSalvar)
                    .addComponent(labelObrigatorio))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *Este dialog não pode ser fechado até que os dados sejam cadastrados
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        
    }//GEN-LAST:event_closeDialog

    private void campoNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeKeyTyped
        validarLetrasETamanho(evt, campoNome, maxCaracteresNome);
    }//GEN-LAST:event_campoNomeKeyTyped

    private void campoRuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoRuaKeyTyped
        if(campoRua.getText().length()>= maxCaracteresNome){
            evt.consume();
        }
    }//GEN-LAST:event_campoRuaKeyTyped

    private void campoBairroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBairroKeyTyped
        if(campoBairro.getText().length()>= maxCaracteresBairro){
            evt.consume();
        }
    }//GEN-LAST:event_campoBairroKeyTyped

    private void campoCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCidadeKeyTyped
        validarLetrasETamanho(evt, campoCidade, maxCaracteresBairro); // Mesmo tamanho para nomes de bairros e cidades
    }//GEN-LAST:event_campoCidadeKeyTyped

    private void campoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumeroKeyTyped
        validarNumerosETamanho(evt, campoNumero, maxCaracteresNumero);
    }//GEN-LAST:event_campoNumeroKeyTyped

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        JOptionPane pane = new JOptionPane();
        JDialog messageDialog = new JDialog();
        messageDialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
        
        try {
            if(campoNome.getText().length() <= 0) {
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                pane.setMessage("Informe o nome do estabelecimento comercial");
                messageDialog = pane.createDialog("Aviso");
                messageDialog.setIconImage(icone);
                messageDialog.setAlwaysOnTop(true);
                messageDialog.setVisible(true);
                
            } else if(campoCnpj.getText().charAt(16) == ' ') {//O último caractere do número de CNPJ não pode ser vazio
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                pane.setMessage("Informe o CNPJ da empresa");
                messageDialog = pane.createDialog("Aviso");
                messageDialog.setIconImage(icone);
                messageDialog.setAlwaysOnTop(true);
                messageDialog.setVisible(true);
                
            } else if(campoRua.getText().length() <= 0) {
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                pane.setMessage("Informe a rua do estabelecimento comercial");
                messageDialog = pane.createDialog("Aviso");
                messageDialog.setIconImage(icone);
                messageDialog.setAlwaysOnTop(true);
                messageDialog.setVisible(true);
                
            } else if(campoCidade.getText().length() <= 0) {
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                pane.setMessage("Informe a cidade do estabelecimento comercial");
                messageDialog = pane.createDialog("Aviso");
                messageDialog.setIconImage(icone);
                messageDialog.setAlwaysOnTop(true);
                messageDialog.setVisible(true);
                
            } else if(campoBairro.getText().length() <= 0) {
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                pane.setMessage("Informe o bairro do estabelecimento comercial");
                messageDialog = pane.createDialog("Aviso");
                messageDialog.setIconImage(icone);
                messageDialog.setAlwaysOnTop(true);
                messageDialog.setVisible(true);
                
            } else if(campoNumero.getText().length() <= 0) {
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                pane.setMessage("Informe o número do estabelecimento comercial");
                messageDialog = pane.createDialog("Aviso");
                messageDialog.setIconImage(icone);
                messageDialog.setAlwaysOnTop(true);
                messageDialog.setVisible(true);
                
            } else if(campoTelefone.getText().charAt(13) == ' ') { //O último caractere do número de telefone não pode ser vazio
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                pane.setMessage("Informe o número de telefone do estabelecimento comercial");
                messageDialog = pane.createDialog("Aviso");
                messageDialog.setIconImage(icone);
                messageDialog.setAlwaysOnTop(true);
                messageDialog.setVisible(true);
                
            } else {

                try {
                    //GerenciadorDoSistema.getInstance().cadastrarEmpresa(new Empresa(campoNome.getText(), campoCnpj.getText(),
                      //  campoTelefone.getText(), new Endereco(campoRua.getText(), campoBairro.getText(), comboUf.getSelectedItem().toString(),
                      //  Integer.parseInt(campoNumero.getText()), campoCidade.getText())));
                    Configuracao configuracao = GerenciadorDoSistema.getInstance().getConfiguracao();
                    
                    configuracao.setEmpresa(new Empresa(campoCnpj.getText(), campoNome.getText(),
                        campoTelefone.getText(), new Endereco(campoRua.getText(), campoBairro.getText(), comboUf.getSelectedItem().toString(),
                        Integer.parseInt(campoNumero.getText()), campoCidade.getText())));
                    
                    GerenciadorDoSistema.getInstance().salvarEstadoDeConfiguracao(configuracao);
                    
                    pane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    pane.setMessage("Empresa cadastrada com sucesso!");
                    messageDialog = pane.createDialog("Aviso");
                    messageDialog.setIconImage(icone);
                    messageDialog.setAlwaysOnTop(true);
                    messageDialog.setVisible(true);
                    
                    salvarSelecionado = true; //O botão Salvar foi selecionado
                    setVisible(false);
                    
                } catch (Exception e) {
                    pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                    pane.setMessage(e.getMessage());
                    messageDialog = pane.createDialog("Erro");
                    messageDialog.setIconImage(icone);
                    messageDialog.setAlwaysOnTop(true);
                    messageDialog.setVisible(true);
                }
            }
        } catch(Exception e) {
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            pane.setMessage(e.getMessage());
            messageDialog = pane.createDialog("Erro");
            messageDialog.setIconImage(icone);
            messageDialog.setAlwaysOnTop(true);
            messageDialog.setVisible(true);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void validarLetrasETamanho(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int maxCaracteres) { 
        if(numeros.contains(evt.getKeyChar()+"")){// se o caracter que gerou o evento estiver na lista 
            evt.consume();
        } 
        if(campo.getText().length()>= maxCaracteres) {
            evt.consume();
        }
    }
    
    public void validarNumerosETamanho(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int maxCaracteres) {
        if(!numeros.contains(evt.getKeyChar()+"")){// se o caracter que gerou o evento não estiver na lista 
            evt.consume();
        } if(campo.getText().length()>= maxCaracteres){ 
            evt.consume(); 
        }
    }

    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresNome = 35;
    private int maxCaracteresBairro = 30;
    private int maxCaracteresNumero = 4;
    protected boolean salvarSelecionado;
    private Image icone;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JFormattedTextField campoCnpj;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoRua;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.JComboBox comboUf;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCNPJ;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelObrigatorio;
    private javax.swing.JLabel labelRua;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelUf;
    private javax.swing.JPanel painelDadosPessoais;
    private javax.swing.JPanel painelEndereco;
    // End of variables declaration//GEN-END:variables
}
