package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDeLocacao;
import br.oltecnologias.hype.controller.GerenciadorDePessoas;
import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.exception.ClienteExistenteException;
import br.oltecnologias.hype.exception.ClienteInexistenteException;
import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.exception.UsuarioExistenteException;
import br.oltecnologias.hype.exception.UsuarioInexistenteException;
import br.oltecnologias.hype.model.Configuracao;
import br.oltecnologias.hype.model.Empresa;
import br.oltecnologias.hype.model.Endereco;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Usuario;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.concurrent.Executors;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;


/**
 *
 * @author Luender Lima
 */
public class LoginFrame extends javax.swing.JFrame {

    public LoginFrame() {
        initComponents();
        getRootPane().setDefaultButton(botaoEntrar);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage()); 
        
        Configuracao configuracao = GerenciadorDoSistema.getInstance().getConfiguracao();
        if(configuracao.getDiretorioDeBackup() == null || configuracao.getDiretorioDeDocumentos() == null
                || configuracao.getDiretorioDeRelatorios() == null) {
            
            CadastrarDiretoriosDialog dialogDiretorios = new CadastrarDiretoriosDialog(null);
            dialogDiretorios.setLocationRelativeTo(null);
            dialogDiretorios.setAlwaysOnTop(true);
            dialogDiretorios.setVisible(true);
        }
        if(configuracao.getEmpresa() == null) {
            CadastrarEmpresaDialog dialogEmpresa = new CadastrarEmpresaDialog(null);
            dialogEmpresa.setLocationRelativeTo(null);
            dialogEmpresa.setAlwaysOnTop(true);
            dialogEmpresa.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelGeral = new javax.swing.JPanel();
        painelDeLogin = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        campoLogin = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        botaoEntrar = new javax.swing.JButton();
        labelLogo = new javax.swing.JLabel();
        labelIconeBotaoBranco = new javax.swing.JLabel();
        labelMensagemCarregando = new javax.swing.JLabel();
        barCarregando = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Closet");
        setName("frameLogin"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 730));

        painelGeral.setBackground(new java.awt.Color(255, 255, 255));
        painelGeral.setMinimumSize(new java.awt.Dimension(600, 500));
        painelGeral.setPreferredSize(new java.awt.Dimension(1366, 730));

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

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Logo Closet.png"))); // NOI18N

        labelIconeBotaoBranco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png"))); // NOI18N
        labelIconeBotaoBranco.setVisible(false);

        labelMensagemCarregando.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMensagemCarregando.setVisible(false);

        barCarregando.setBackground(new java.awt.Color(255, 255, 255));
        barCarregando.setVisible(false);

        javax.swing.GroupLayout painelGeralLayout = new javax.swing.GroupLayout(painelGeral);
        painelGeral.setLayout(painelGeralLayout);
        painelGeralLayout.setHorizontalGroup(
            painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGeralLayout.createSequentialGroup()
                .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelGeralLayout.createSequentialGroup()
                        .addGap(473, 473, 473)
                        .addComponent(painelDeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelGeralLayout.createSequentialGroup()
                        .addGap(505, 505, 505)
                        .addComponent(labelLogo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
                .addComponent(labelIconeBotaoBranco)
                .addContainerGap())
            .addGroup(painelGeralLayout.createSequentialGroup()
                .addGap(574, 574, 574)
                .addComponent(labelMensagemCarregando)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelGeralLayout.createSequentialGroup()
                    .addGap(536, 536, 536)
                    .addComponent(barCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(537, Short.MAX_VALUE)))
        );
        painelGeralLayout.setVerticalGroup(
            painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGeralLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(labelLogo)
                .addGap(23, 23, 23)
                .addComponent(labelMensagemCarregando)
                .addGap(32, 32, 32)
                .addComponent(painelDeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGeralLayout.createSequentialGroup()
                .addContainerGap(402, Short.MAX_VALUE)
                .addComponent(labelIconeBotaoBranco)
                .addGap(244, 244, 244))
            .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelGeralLayout.createSequentialGroup()
                    .addGap(339, 339, 339)
                    .addComponent(barCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(339, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
                    
        if(campoLogin.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe o login do usuário", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if(campoSenha.getPassword().length <= 0) {
            JOptionPane.showMessageDialog(null, "Informe a senha do usuário", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                
                // Validar usuário no sistema
                if (GerenciadorDePessoas.getInstance().validarUsuario(campoLogin.getText(), new String(campoSenha.getPassword()))) {
                    
                    try {
                        Usuario usuarioLogado = GerenciadorDePessoas.getInstance().pesquisarUsuarioPeloLogin(campoLogin.getText());
                        GerenciadorDoSistema.getInstance().setUsuarioLogado(usuarioLogado);
                    } catch (UsuarioInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                    
                    LoginFrame loginFrame = this;
                    Executors.newFixedThreadPool(7).execute(new Runnable() {
                        public void run() {
                            new PrincipalFrame(campoLogin.getText(), loginFrame).setVisible(true);
                        }
                    });
                    
                    painelDeLogin.setVisible(false);
                    barCarregando.setVisible(true);
                    labelMensagemCarregando.setVisible(true);
                    
                    new Thread() {
                        public void run() {
                            int pontos = 0;
                            String pontosTxt = "";
                            while(loginFrame.isVisible()) {
                                /*if(pontos == 3) {
                                    pontosTxt = "";
                                    pontos = 0;
                                } else {
                                    pontosTxt += ".";
                                    pontos++;
                                }*/
                                //labelMensagemCarregando.setText("Carregando o Closet. Aguarde"+pontosTxt);
                                    for (int i = 0; i < 100; i++) {
                                        try {
                                            sleep(30);
                                            barCarregando.setValue(i);
                                        } catch (InterruptedException e) {
                                            JOptionPane.showMessageDialog(null, "O sistema está sendo carregado\n\nAguarde...");
                                        }
                                        if(i == 99) {
                                            pontosTxt = "";
                                        } else if(i % 25 == 0 && i > 0) {
                                            pontosTxt += ".";
                                        } 
                                        labelMensagemCarregando.setText("Carregando o Closet. Aguarde"+pontosTxt);
                                    }
                            }

                                }
                    }.start(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não cadastrado no sistema. \n\nInforme os dados novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoEntrarActionPerformed

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
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrameTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */ //SwingUtilities.invokeLater
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    private int maxCaracteresNickName = 15;
    private int maxCaracteresSenha = 12;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barCarregando;
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JLabel labelIconeBotaoBranco;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelMensagemCarregando;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel painelDeLogin;
    private javax.swing.JPanel painelGeral;
    // End of variables declaration//GEN-END:variables
}
