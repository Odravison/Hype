/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDePessoas;
import br.oltecnologias.hype.model.Endereco;
import br.oltecnologias.hype.model.Fornecedor;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class CadastrarFornecedorDialog extends java.awt.Dialog {
    
    public CadastrarFornecedorDialog(Frame owner) {
        super(owner);
        initComponents();
        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Salvar.png")));
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Cancelar.png")));
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
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
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelObrigatorio = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setTitle("Cadastrar Fornecedor");
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
        labelRua.setText("Rua:");

        campoRua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoRuaKeyTyped(evt);
            }
        });

        labelNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumero.setText("Número:");

        labelBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelBairro.setText("Bairro:");

        campoBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBairroKeyTyped(evt);
            }
        });

        labelCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCidade.setText("Cidade:");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
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
        labelTelefone.setText("Telefone:");

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
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        labelObrigatorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelObrigatorio.setText("* Obrigatório");

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
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoSalvar)
                        .addComponent(botaoCancelar))
                    .addComponent(labelObrigatorio))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
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
        try {
            if(campoCnpj.getText().charAt(16) == ' ') {//O último caractere do número de CNPJ não pode ser vazio
                JOptionPane.showMessageDialog(null, "Informe o CNPJ completo do fornecedor", "Aviso", JOptionPane.WARNING_MESSAGE);
            }else if(campoNome.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o nome do fornecedor", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                // Nem todos os valores dos campos serão informados
                if(campoRua.getText().length() <= 0) {
                    campoRua.setText("Não informado");
                } 
                if(campoNumero.getText().length() <= 0) {
                    campoNumero.setText("0");
                } 
                if(campoBairro.getText().length() <= 0) {
                    campoBairro.setText("Não informado");
                } 
                if(campoCidade.getText().length() <= 0) {
                    campoCidade.setText("Não informado");
                } 
                if (campoTelefone.getText().indexOf(13) == ' ') {
                    campoTelefone.setText("Não informado"); //O valor do campo não está sendo alterado
                }

                Endereco endereco = new Endereco(campoRua.getText(), campoBairro.getText(), comboUf.getSelectedItem().toString(),
                    Integer.parseInt(campoNumero.getText()), campoCidade.getText());


                try {
                    novoFornecedor = new Fornecedor(campoCnpj.getText(), endereco, campoTelefone.getText(), campoNome.getText());
                            
                    GerenciadorDePessoas.getInstance().cadastrarFornecedor(novoFornecedor);
                    JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");

                    salvarSelecionado = true; //O botão Salvar foi selecionado
                    setVisible(false);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

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
    
    public boolean alterarDados() {        
        salvarSelecionado = false;  //Marcamos que o salavar não foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible ap�s ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return salvarSelecionado;   //Retornamos true, se ele pressionou ok.
    }
    
    public Fornecedor getNovoFornecedor() {
        return novoFornecedor;
    }

    protected boolean salvarSelecionado;
    protected Fornecedor novoFornecedor;
    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresNome = 40;
    private int maxCaracteresBairro = 30;
    private int maxCaracteresNumero = 4;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
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
