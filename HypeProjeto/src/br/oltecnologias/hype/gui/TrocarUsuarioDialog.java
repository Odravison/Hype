/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDePessoas;
import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.exception.UsuarioInexistenteException;
import br.oltecnologias.hype.model.Usuario;
import javax.swing.JOptionPane;
/**
 *
 * @author Luender Lima
 */
public class TrocarUsuarioDialog extends java.awt.Dialog {

    public TrocarUsuarioDialog(java.awt.Frame parent) {
        super(parent);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDeLogin = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        campoLogin = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        botaoEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setModal(true);
        setResizable(false);
        setTitle("Trocar Usuário");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDeLogin.setBackground(new java.awt.Color(243, 243, 243));
        painelDeLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        painelDeLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelDeLogin.setName("hype!\n"); // NOI18N
        painelDeLogin.setPreferredSize(new java.awt.Dimension(420, 350));

        labelUsuario.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelUsuario.setText("Login:");

        campoLogin.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        campoLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoLoginKeyTyped(evt);
            }
        });

        labelSenha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelSenha.setText("Senha:");

        campoSenha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoSenhaKeyTyped(evt);
            }
        });

        botaoEntrar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoEntrar.setText("Entrar");
        botaoEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDeLoginLayout = new javax.swing.GroupLayout(painelDeLogin);
        painelDeLogin.setLayout(painelDeLoginLayout);
        painelDeLoginLayout.setHorizontalGroup(
            painelDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDeLoginLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(painelDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoSenha)
                    .addGroup(painelDeLoginLayout.createSequentialGroup()
                        .addGap(0, 150, Short.MAX_VALUE)
                        .addComponent(botaoEntrar))
                    .addComponent(campoLogin))
                .addGap(65, 65, 65))
        );
        painelDeLoginLayout.setVerticalGroup(
            painelDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDeLoginLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(painelDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario))
                .addGap(39, 39, 39)
                .addGroup(painelDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSenha))
                .addGap(55, 55, 55)
                .addComponent(botaoEntrar)
                .addGap(70, 70, 70))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Trocar Usuário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(painelDeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(242, 242, 242))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(painelDeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void campoLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoLoginKeyTyped
        if(campoLogin.getText().length() >= maxCaracteresNickName) {
            evt.consume();
        }
    }//GEN-LAST:event_campoLoginKeyTyped

    private void campoSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyTyped
        if(new String (campoSenha.getPassword()).length() >= maxCaracteresSenha) {
            evt.consume();
        }
    }//GEN-LAST:event_campoSenhaKeyTyped

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed

        if(campoLogin.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe o login", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if(campoSenha.getPassword().length <= 0) {
            JOptionPane.showMessageDialog(null, "Informe a senha", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // Validar usuário no sistema
                if (GerenciadorDePessoas.getInstance().validarUsuario(campoLogin.getText(), new String(campoSenha.getPassword()))) {

                    try {
                        usuarioLogado = GerenciadorDePessoas.getInstance().pesquisarUsuarioPeloLogin(campoLogin.getText());
                        GerenciadorDoSistema.getInstance().setUsuarioLogado(usuarioLogado);
                                                
                        //O botão concluir foi selecionado
                        concluirSelecionado = true;
                        //Fecha janela
                        setVisible(false);
                    } catch (UsuarioInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não cadastrado no sistema. \n\nInforme os dados novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoEntrarActionPerformed

     public boolean alterarDados() {        
        concluirSelecionado = false;  //Marcamos que o salavar não foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible ap�s ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return concluirSelecionado;   //Retornamos true, se ele pressionou ok.
    }
    
    public boolean isUsuarioAdministrador() {
        return usuarioLogado.isAdministrador();
    }
    
    private int maxCaracteresNickName = 15;
    private int maxCaracteresSenha = 12;
    protected boolean concluirSelecionado;
    private Usuario usuarioLogado;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel painelDeLogin;
    // End of variables declaration//GEN-END:variables
}
