/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.model.Empresa;
import br.oltecnologias.hype.model.Endereco;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class EditarEmpresaDialog extends java.awt.Dialog {

    public EditarEmpresaDialog(java.awt.Frame parent, Empresa empresa) {
        super(parent);
        this.empresa = empresa;
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Salvar.png")));
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Cancelar.png")));
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDadosPessoais2 = new javax.swing.JPanel();
        labelNome2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelCNPJ2 = new javax.swing.JLabel();
        painelEndereco2 = new javax.swing.JPanel();
        labelRua2 = new javax.swing.JLabel();
        campoRua = new javax.swing.JTextField();
        labelNumero2 = new javax.swing.JLabel();
        labelBairro2 = new javax.swing.JLabel();
        campoBairro = new javax.swing.JTextField();
        labelCidade2 = new javax.swing.JLabel();
        campoCidade = new javax.swing.JTextField();
        labelUf2 = new javax.swing.JLabel();
        comboUf = new javax.swing.JComboBox();
        campoNumero = new javax.swing.JTextField();
        labelTelefone = new javax.swing.JLabel();
        campoCnpj = new javax.swing.JFormattedTextField();
        campoTelefone = new javax.swing.JFormattedTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelObrigatorio = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Editar Empresa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDadosPessoais2.setBackground(new java.awt.Color(255, 255, 255));
        painelDadosPessoais2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"));

        labelNome2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNome2.setText("Nome:");

        campoNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNomeKeyTyped(evt);
            }
        });

        labelCNPJ2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCNPJ2.setText("CNPJ:");

        painelEndereco2.setBackground(new java.awt.Color(255, 255, 255));
        painelEndereco2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        labelRua2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelRua2.setText("Rua:");

        campoRua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoRuaKeyTyped(evt);
            }
        });

        labelNumero2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumero2.setText("Número:");

        labelBairro2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelBairro2.setText("Bairro:");

        campoBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBairroKeyTyped(evt);
            }
        });

        labelCidade2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCidade2.setText("Cidade:");

        campoCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCidadeKeyTyped(evt);
            }
        });

        labelUf2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelUf2.setText("UF:");

        comboUf.setMaximumRowCount(20);
        comboUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PB", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        comboUf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        campoNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumeroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout painelEndereco2Layout = new javax.swing.GroupLayout(painelEndereco2);
        painelEndereco2.setLayout(painelEndereco2Layout);
        painelEndereco2Layout.setHorizontalGroup(
            painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEndereco2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEndereco2Layout.createSequentialGroup()
                        .addComponent(labelRua2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(labelNumero2))
                    .addGroup(painelEndereco2Layout.createSequentialGroup()
                        .addComponent(labelBairro2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(labelCidade2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEndereco2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(labelUf2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(painelEndereco2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelEndereco2Layout.setVerticalGroup(
            painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEndereco2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRua2)
                    .addComponent(campoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumero2)
                    .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBairro2)
                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCidade2)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUf2)
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

        javax.swing.GroupLayout painelDadosPessoais2Layout = new javax.swing.GroupLayout(painelDadosPessoais2);
        painelDadosPessoais2.setLayout(painelDadosPessoais2Layout);
        painelDadosPessoais2Layout.setHorizontalGroup(
            painelDadosPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoais2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosPessoais2Layout.createSequentialGroup()
                        .addComponent(painelEndereco2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(painelDadosPessoais2Layout.createSequentialGroup()
                        .addComponent(labelNome2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCNPJ2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(painelDadosPessoais2Layout.createSequentialGroup()
                        .addComponent(labelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelDadosPessoais2Layout.setVerticalGroup(
            painelDadosPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoais2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome2)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCNPJ2)
                    .addComponent(campoCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(painelEndereco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefone)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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
        labelObrigatorio.setText("* Obrigatório");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelObrigatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar))
                    .addComponent(painelDadosPessoais2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDadosPessoais2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoSalvar)
                        .addComponent(botaoCancelar))
                    .addComponent(labelObrigatorio))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        Empresa empresa = GerenciadorDoSistema.getInstance().getConfiguracao().getEmpresa();
        campoNome.setText(empresa.getNome());
        campoCnpj.setText(empresa.getCnpj());
        campoTelefone.setText(empresa.getTelefone());
        campoRua.setText(empresa.getEndereco().getRua());
        campoBairro.setText(empresa.getEndereco().getBairro());
        campoCidade.setText(empresa.getEndereco().getCidade());
        campoNumero.setText(empresa.getEndereco().getNumeroCasa()+"");
        comboUf.setSelectedItem(empresa.getEndereco().getUf());

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
                JOptionPane.showMessageDialog(null, "Informe o CNPJ da empresa", "Aviso", JOptionPane.WARNING_MESSAGE);
            }else if(campoNome.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o nome do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoRua.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a rua do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoCidade.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a cidade do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoBairro.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o bairro do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoNumero.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o número do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoTelefone.getText().charAt(13) == ' ') { //O último caractere do número de telefone não pode ser vazio
                JOptionPane.showMessageDialog(null, "Informe o número de telefone do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                
                try {
                    Endereco endereco = empresa.getEndereco();
                    endereco.setCidade(campoCidade.getText());
                    endereco.setNumeroCasa(Integer.parseInt(campoNumero.getText()));
                    endereco.setRua(campoRua.getText());
                    endereco.setBairro(campoBairro.getText());
                    endereco.setUf(comboUf.getSelectedItem().toString());
                    
                    empresa.setCnpj(campoCnpj.getText());
                    empresa.setNome(campoNome.getText());
                    empresa.setTelefone(campoTelefone.getText());
                    
                    GerenciadorDoSistema.getInstance().editarEmpresa(empresa);

                    JOptionPane.showMessageDialog(null, "Empresa editada com sucesso!");
                    
                    setVisible(false);
                    dispose();

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
        if(numeros.contains(evt.getKeyChar()+"")){
            evt.consume();
        } 
        if(campo.getText().length()>= maxCaracteres) {
            evt.consume();
        }
    }
    
    public void validarNumerosETamanho(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int maxCaracteres) {
        if(!numeros.contains(evt.getKeyChar()+"")){ 
            evt.consume();
        } if(campo.getText().length()>= maxCaracteres){ 
            evt.consume(); 
        }
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }

    private Empresa empresa;
    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresNome = 35;
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
    private javax.swing.JLabel labelBairro2;
    private javax.swing.JLabel labelCNPJ2;
    private javax.swing.JLabel labelCidade2;
    private javax.swing.JLabel labelNome2;
    private javax.swing.JLabel labelNumero2;
    private javax.swing.JLabel labelObrigatorio;
    private javax.swing.JLabel labelRua2;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelUf2;
    private javax.swing.JPanel painelDadosPessoais2;
    private javax.swing.JPanel painelEndereco2;
    // End of variables declaration//GEN-END:variables
}
