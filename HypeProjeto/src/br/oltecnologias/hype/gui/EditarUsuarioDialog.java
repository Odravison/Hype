/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDePessoas;
import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class EditarUsuarioDialog extends java.awt.Dialog {
    
    public EditarUsuarioDialog(java.awt.Frame parent, Usuario usuario) {
        super(parent);
        this.usuario = usuario;
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
        labelNickName = new javax.swing.JLabel();
        campoNickName = new javax.swing.JTextField();
        radioAdm = new javax.swing.JRadioButton();
        radioFuncionario = new javax.swing.JRadioButton();
        labelCategoria = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(598, 288));
        setResizable(false);
        setTitle("Editar Usuário");
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
        campoNome.setText(usuario.getNome());

        labelNickName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNickName.setText("Login:*");

        campoNickName.setEditable(false);
        campoNickName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNickName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNickNameKeyTyped(evt);
            }
        });
        campoNickName.setText(usuario.getNickName());

        radioAdm.setBackground(new java.awt.Color(255, 255, 255));
        radioAdm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioAdm.setText("Administrador");
        radioAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAdmActionPerformed(evt);
            }
        });

        radioFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        radioFuncionario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioFuncionario.setText("Funcionário");
        radioFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFuncionarioActionPerformed(evt);
            }
        });

        labelCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCategoria.setText("Categoria:*");

        labelSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSenha.setText("Senha:*");

        campoSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoSenhaKeyTyped(evt);
            }
        });
        campoSenha.setText(usuario.getSenha());

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
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDadosGeraisLayout.createSequentialGroup()
                        .addGroup(painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosGeraisLayout.createSequentialGroup()
                                .addComponent(labelNickName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelSenha))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosGeraisLayout.createSequentialGroup()
                                .addComponent(labelCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioAdm)
                                .addGap(18, 18, 18)
                                .addComponent(radioFuncionario)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(labelNickName)
                    .addComponent(campoNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSenha)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioAdm)
                    .addComponent(radioFuncionario)
                    .addComponent(labelCategoria))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        if(usuario.isAdministrador()) {
            radioAdm.setSelected(true);
            radioFuncionario.setSelected(false);
        } else {
            radioFuncionario.setSelected(true);
            radioAdm.setSelected(false);
        }

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(botaoSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoCancelar)
                .addGap(23, 36, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDadosGerais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addContainerGap(42, Short.MAX_VALUE))
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

    private void campoNickNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNickNameKeyTyped
        if(campoNickName.getText().length() >= maxCaracteresNickName){// se o carácter que gerou o evento estiver na lista
            evt.consume();
        }
    }//GEN-LAST:event_campoNickNameKeyTyped

    private void radioAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAdmActionPerformed
        radioFuncionario.setSelected(false);
    }//GEN-LAST:event_radioAdmActionPerformed

    private void radioFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFuncionarioActionPerformed
        radioAdm.setSelected(false);
    }//GEN-LAST:event_radioFuncionarioActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        try {
            // Validar campos para cadastro
            if(campoNome.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o nome do usuário", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(new String(campoSenha.getPassword()).length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a senha do usuário", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(!radioAdm.isSelected() && !radioFuncionario.isSelected()) {
                JOptionPane.showMessageDialog(null, "Informe a categoria do usuário", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    boolean editar = true;
                    if(!(new String(campoSenha.getPassword()).equals(usuario.getSenha()))) {
                        ConfirmarSenhaDialog dialog = new ConfirmarSenhaDialog(null);
                        dialog.setLocationRelativeTo(null);
                        if (dialog.alterarDados()) {
                            if(GerenciadorDoSistema.getInstance().getUsuarioLogado().getSenha().equals(dialog.getSenhaInformada())) {
                                usuario.setSenha(new String(campoSenha.getPassword()));
                            } else {
                                editar = false;
                                JOptionPane.showMessageDialog(null, "Não foi possível realizar a edição de usuário\n\nSenhas incompatíveis.");
                            }
                        }
                        dialog.dispose();
                        
                    }
                    if(editar) {
                        usuario.setNome(campoNome.getText());
                        usuario.setIsAdministrador(radioAdm.isSelected());
                    
                        GerenciadorDePessoas.getInstance().editarUsuario(usuario);

                        JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");

                        salvarSelecionado = true;
                        setVisible(false);
                    } else {
                        setVisible(false);
                    }
                    dispose();
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void campoSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyTyped
        if(new String(campoSenha.getPassword()).length() >= maxCaracteresSenha){ 
            evt.consume(); 
        }
    }//GEN-LAST:event_campoSenhaKeyTyped

    private void validarLetrasETamanho(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int maxCaracteres) { 
        if(numeros.contains(evt.getKeyChar()+"")){// se o carácter que gerou o evento estiver na lista 
            evt.consume();
        } 
        if(campo.getText().length() >= maxCaracteres){// se o carácter que gerou o evento estiver na lista 
            evt.consume();
        } 
    }
    
    public boolean alterarDados() {        
        salvarSelecionado = false;  //Marcamos que o salvar não foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible ap�s ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return salvarSelecionado;   //Retornamos true, se ele pressionou ok.
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    protected boolean salvarSelecionado;
    private int maxCaracteresNome = 30;
    private int maxCaracteresNickName = 15;
    private int maxCaracteresSenha = 12;
    private Usuario usuario;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoNickName;
    private javax.swing.JTextField campoNome;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelNickName;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JPanel painelDadosGerais;
    private javax.swing.JRadioButton radioAdm;
    private javax.swing.JRadioButton radioFuncionario;
    // End of variables declaration//GEN-END:variables
}
