/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDePessoas;
import br.oltecnologias.hype.controller.GerenciadorDeProduto;
import br.oltecnologias.hype.exception.FornecedorInexistenteException;
import br.oltecnologias.hype.model.Fornecedor;
import br.oltecnologias.hype.model.Produto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class EditarProdutoDialog extends java.awt.Dialog {
    
    public EditarProdutoDialog(java.awt.Frame parent, Produto produto) {
        super(parent);
        this.produto = produto;
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Salvar.png")));
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Cancelar.png")));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoSalvar = new javax.swing.JButton();
        painelDadosGerais = new javax.swing.JPanel();
        painelIdentificacao = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelCodigo = new javax.swing.JLabel();
        labelCor = new javax.swing.JLabel();
        campoCor = new javax.swing.JTextField();
        radioVenda = new javax.swing.JRadioButton();
        radioAluguel = new javax.swing.JRadioButton();
        labelTipo = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        painelValores = new javax.swing.JPanel();
        labelTamanho = new javax.swing.JLabel();
        labelQuantidade = new javax.swing.JLabel();
        labelPreco = new javax.swing.JLabel();
        campoPreco = new javax.swing.JTextField();
        campoQuantidade = new javax.swing.JTextField();
        campoTamanho = new javax.swing.JTextField();
        labelFornecedor = new javax.swing.JLabel();
        comboFornecedor = new javax.swing.JComboBox();
        labelObrigatorio = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Editar Produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        botaoSalvar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoSalvar.setText(" Salvar ");
        botaoSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        painelDadosGerais.setBackground(new java.awt.Color(255, 255, 255));
        painelDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"));

        painelIdentificacao.setBackground(new java.awt.Color(255, 255, 255));
        painelIdentificacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificação"));

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNome.setText("Nome:*");

        campoNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNomeKeyTyped(evt);
            }
        });

        labelCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCodigo.setText("Código:*");

        labelCor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCor.setText("Cor:*");

        campoCor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoCor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCorKeyTyped(evt);
            }
        });

        radioVenda.setBackground(new java.awt.Color(255, 255, 255));
        radioVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioVenda.setText("Venda");
        radioVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        radioVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioVendaActionPerformed(evt);
            }
        });

        radioAluguel.setBackground(new java.awt.Color(255, 255, 255));
        radioAluguel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioAluguel.setSelected(true);
        radioAluguel.setText("Aluguel");
        radioAluguel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        radioAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAluguelActionPerformed(evt);
            }
        });

        labelTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTipo.setText("Finalidade:*");

        campoCodigo.setEditable(false);
        campoCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCodigoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout painelIdentificacaoLayout = new javax.swing.GroupLayout(painelIdentificacao);
        painelIdentificacao.setLayout(painelIdentificacaoLayout);
        painelIdentificacaoLayout.setHorizontalGroup(
            painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelIdentificacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelIdentificacaoLayout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(labelCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(painelIdentificacaoLayout.createSequentialGroup()
                        .addComponent(labelCor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioVenda)
                        .addGap(18, 18, 18)
                        .addComponent(radioAluguel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelIdentificacaoLayout.setVerticalGroup(
            painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelIdentificacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCodigo)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioVenda)
                        .addComponent(radioAluguel)
                        .addComponent(labelTipo))
                    .addGroup(painelIdentificacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelCor)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        painelValores.setBackground(new java.awt.Color(255, 255, 255));
        painelValores.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));
        painelValores.setPreferredSize(new java.awt.Dimension(629, 100));

        labelTamanho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTamanho.setText("Tamanho:");

        labelQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQuantidade.setText("Quantidade:*");

        labelPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPreco.setText("Preço:* R$");

        campoPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPrecoKeyTyped(evt);
            }
        });

        campoQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoQuantidadeKeyTyped(evt);
            }
        });

        campoTamanho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoTamanho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTamanhoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout painelValoresLayout = new javax.swing.GroupLayout(painelValores);
        painelValores.setLayout(painelValoresLayout);
        painelValoresLayout.setHorizontalGroup(
            painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTamanho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(labelQuantidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(labelPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelValoresLayout.setVerticalGroup(
            painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPreco)
                        .addComponent(campoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelQuantidade)
                        .addComponent(campoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTamanho)
                        .addComponent(campoTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        labelFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelFornecedor.setText("Fornecedor:");

        comboFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFornecedor.setMaximumRowCount(0);
        comboFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboFornecedor.addItem("Selecione");
        try {
            for(Fornecedor fornecedor: GerenciadorDePessoas.getInstance().getFornecedores()) {
                comboFornecedor.addItem(fornecedor.getNome());
            }
        } catch(FornecedorInexistenteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }

        comboFornecedor.setMaximumRowCount(comboFornecedor.getItemCount());

        comboFornecedor.setSelectedItem(produto.getFornecedor());

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
                .addComponent(labelFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFornecedor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        campoNome.setText(produto.getNome());
        campoCodigo.setText(produto.getCodigo());
        campoCor.setText(produto.getCor());
        campoTamanho.setText(produto.getTam()+"");
        campoQuantidade.setText(produto.getQuantidade()+"");
        campoPreco.setText(new BigDecimal(produto.getValor()).setScale(2, RoundingMode.HALF_EVEN).doubleValue()+"");
        campoPreco.setText(campoPreco.getText().replaceAll(",", "."));
        if(produto.isLocation()) {
            radioAluguel.setSelected(true);
            radioVenda.setSelected(false);
        } else {
            radioVenda.setSelected(true);
            radioAluguel.setSelected(false);
        }
        comboFornecedor.setSelectedItem(produto.getFornecedor());

        labelObrigatorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelObrigatorio.setText("* Obrigatório ");

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(painelDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(labelObrigatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObrigatorio)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoCancelar)
                        .addComponent(botaoSalvar)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        try {
            // Validar campos para edição
            if(campoNome.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o nome do produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoCor.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a cor do produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoQuantidade.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a quantidade de peças do produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoPreco.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o preço do produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(!radioAluguel.isSelected() && !radioVenda.isSelected()) {
                JOptionPane.showMessageDialog(null, "Informe a finalidade do produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                String fornecedor = "";
                if (comboFornecedor.getSelectedItem().toString().equals("Selecione")) {
                    fornecedor = "Não informado";
                } else {
                    fornecedor = comboFornecedor.getSelectedItem().toString();
                }

                if(campoTamanho.getText().length() == 0) {
                    campoTamanho.setText("0");
                }
                
                produto.setCor(campoCor.getText());
                produto.setFornecedor(fornecedor);
                produto.setIsLocation(radioAluguel.isSelected());
                produto.setNome(campoNome.getText());
                produto.setQuantidade(Integer.parseInt(campoQuantidade.getText()));
                produto.setTam(Integer.parseInt(campoTamanho.getText()));
                produto.setValor(Double.parseDouble(campoPreco.getText()));

                try {
                    GerenciadorDeProduto.getInstance().editarProduto(produto);

                    JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");

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

    private void campoNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeKeyTyped
        if(campoNome.getText().length() >= maxCaracteresNome) {
            evt.consume();
        }
    }//GEN-LAST:event_campoNomeKeyTyped

    private void campoCorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCorKeyTyped
        validarLetrasETamanho(evt, campoCor, maxCaracteresCor);
    }//GEN-LAST:event_campoCorKeyTyped

    private void radioVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioVendaActionPerformed
        radioAluguel.setSelected(false);
    }//GEN-LAST:event_radioVendaActionPerformed

    private void radioAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAluguelActionPerformed
        radioVenda.setSelected(false);
    }//GEN-LAST:event_radioAluguelActionPerformed

    private void campoCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCodigoKeyTyped
        if(campoCodigo.getText().length() >= maxCaracteresCodigo) {
            evt.consume();
        }
    }//GEN-LAST:event_campoCodigoKeyTyped

    private void campoPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPrecoKeyTyped
        if((campoPreco.getText().length() > 3 && !campoPreco.getText().contains(".")) ||
            (!numeros.contains(evt.getKeyChar()+"") && evt.getKeyChar() != '.')
            || campoPreco.getText().length() >= maxCaracteresPreco) {

            evt.consume();
        }
    }//GEN-LAST:event_campoPrecoKeyTyped

    private void campoQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoQuantidadeKeyTyped
        validarNumerosETamanho(evt, campoQuantidade, maxCaracteresQuantidade);
    }//GEN-LAST:event_campoQuantidadeKeyTyped

    private void campoTamanhoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTamanhoKeyTyped
        validarNumerosETamanho(evt, campoTamanho, maxCaracteresTamanho);
    }//GEN-LAST:event_campoTamanhoKeyTyped

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

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
        salvarSelecionado = false;  //Marcamos que o salvar não foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible após ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return salvarSelecionado;   //Retornamos true, se ele pressionou ok.
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    private Produto produto;
    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresNome = 40;
    private int maxCaracteresCor = 25;
    private int maxCaracteresPreco = 10;
    private int maxCaracteresCodigo = 8;
    private int maxCaracteresQuantidade = 4;
    private int maxCaracteresTamanho = 2;
    protected boolean salvarSelecionado;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoCor;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPreco;
    private javax.swing.JTextField campoQuantidade;
    private javax.swing.JTextField campoTamanho;
    private javax.swing.JComboBox comboFornecedor;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelCor;
    private javax.swing.JLabel labelFornecedor;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelObrigatorio;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JLabel labelTamanho;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JPanel painelDadosGerais;
    private javax.swing.JPanel painelIdentificacao;
    private javax.swing.JPanel painelValores;
    private javax.swing.JRadioButton radioAluguel;
    private javax.swing.JRadioButton radioVenda;
    // End of variables declaration//GEN-END:variables
}
