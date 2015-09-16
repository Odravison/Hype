/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.model.Configuracao;
import javax.swing.ImageIcon;

import br.oltecnologias.hype.model.Configuracao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class CadastrarDiretoriosDialog extends java.awt.Dialog {


    public CadastrarDiretoriosDialog(java.awt.Frame parent) {
        super(parent);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDiretorios = new javax.swing.JPanel();
        campoDiretorioBackup = new javax.swing.JTextField();
        campoDiretorioDocumentos = new javax.swing.JTextField();
        campoDiretorioRelatorios = new javax.swing.JTextField();
        labelDiretorioRelatorios = new javax.swing.JLabel();
        labelDiretorioDocumentos = new javax.swing.JLabel();
        labelDiretorioBackups = new javax.swing.JLabel();
        botaoSalvar = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Cadastrar Diretórios");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDiretorios.setBackground(new java.awt.Color(255, 255, 255));
        painelDiretorios.setBorder(javax.swing.BorderFactory.createTitledBorder("Diretórios"));

        campoDiretorioBackup.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        campoDiretorioBackup.setForeground(new java.awt.Color(153, 153, 153));
        campoDiretorioBackup.setText("Caminho do diretório");
        campoDiretorioBackup.setToolTipText("Informe o caminho do diretório");
        campoDiretorioBackup.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        campoDiretorioBackup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoDiretorioBackupMouseClicked(evt);
            }
        });
        campoDiretorioBackup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDiretorioBackupKeyTyped(evt);
            }
        });

        campoDiretorioDocumentos.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        campoDiretorioDocumentos.setForeground(new java.awt.Color(153, 153, 153));
        campoDiretorioDocumentos.setText("Caminho do diretório");
        campoDiretorioDocumentos.setToolTipText("Informe o caminho do diretório");
        campoDiretorioDocumentos.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        campoDiretorioDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoDiretorioDocumentosMouseClicked(evt);
            }
        });
        campoDiretorioDocumentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDiretorioDocumentosKeyTyped(evt);
            }
        });

        campoDiretorioRelatorios.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        campoDiretorioRelatorios.setForeground(new java.awt.Color(153, 153, 153));
        campoDiretorioRelatorios.setText("Caminho do diretório");
        campoDiretorioRelatorios.setToolTipText("Informe o caminho do diretório");
        campoDiretorioRelatorios.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        campoDiretorioRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoDiretorioRelatoriosMouseClicked(evt);
            }
        });
        campoDiretorioRelatorios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDiretorioRelatoriosKeyTyped(evt);
            }
        });

        labelDiretorioRelatorios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDiretorioRelatorios.setText("Diretório de Relatórios");

        labelDiretorioDocumentos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDiretorioDocumentos.setText("Diretório de Documentos");

        labelDiretorioBackups.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDiretorioBackups.setText("Diretório de backups");

        javax.swing.GroupLayout painelDiretoriosLayout = new javax.swing.GroupLayout(painelDiretorios);
        painelDiretorios.setLayout(painelDiretoriosLayout);
        painelDiretoriosLayout.setHorizontalGroup(
            painelDiretoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDiretoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDiretoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDiretorioRelatorios)
                    .addComponent(labelDiretorioDocumentos)
                    .addComponent(labelDiretorioBackups)
                    .addComponent(campoDiretorioDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDiretorioBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDiretorioRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelDiretoriosLayout.setVerticalGroup(
            painelDiretoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDiretoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDiretorioBackups)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDiretorioBackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(labelDiretorioDocumentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDiretorioDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(labelDiretorioRelatorios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDiretorioRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoSalvar)
                    .addComponent(painelDiretorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDiretorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSalvar)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        //setVisible(false);
        //dispose();
    }//GEN-LAST:event_closeDialog

    private void campoDiretorioBackupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoDiretorioBackupMouseClicked
        if(campoDiretorioBackup.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioBackup);
        }
    }//GEN-LAST:event_campoDiretorioBackupMouseClicked

    private void campoDiretorioBackupKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDiretorioBackupKeyTyped
        if(campoDiretorioBackup.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioBackup);
        }
    }//GEN-LAST:event_campoDiretorioBackupKeyTyped

    private void campoDiretorioDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoDiretorioDocumentosMouseClicked
        if(campoDiretorioDocumentos.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioDocumentos);
        }
    }//GEN-LAST:event_campoDiretorioDocumentosMouseClicked

    private void campoDiretorioDocumentosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDiretorioDocumentosKeyTyped
        if(campoDiretorioDocumentos.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioDocumentos);
        }
    }//GEN-LAST:event_campoDiretorioDocumentosKeyTyped

    private void campoDiretorioRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoDiretorioRelatoriosMouseClicked
        if(campoDiretorioRelatorios.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioRelatorios);
        }
    }//GEN-LAST:event_campoDiretorioRelatoriosMouseClicked

    private void campoDiretorioRelatoriosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDiretorioRelatoriosKeyTyped
        if(campoDiretorioRelatorios.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioRelatorios);
        }
    }//GEN-LAST:event_campoDiretorioRelatoriosKeyTyped

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        boolean cadastrou = false;
        JOptionPane pane = new JOptionPane();
        JDialog messageDialog;
        
        if(campoDiretorioBackup.getText().length() <= 0 || campoDiretorioBackup.getText().equals("Caminho do diretório")) {
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            pane.setMessage("Informe o diretório de backup");
            messageDialog = pane.createDialog("Aviso");
            messageDialog.setAlwaysOnTop(true);
            messageDialog.setVisible(true);
            
        } else if(campoDiretorioDocumentos.getText().length() <= 0 || campoDiretorioDocumentos.getText().equals("Caminho do diretório")) {
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            pane.setMessage("Informe o diretório de documentos");
            messageDialog = pane.createDialog("Aviso");
            messageDialog.setAlwaysOnTop(true);
            messageDialog.setVisible(true);
            
        } else if(campoDiretorioRelatorios.getText().length() <= 0 || campoDiretorioRelatorios.getText().equals("Caminho do diretório")) {
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            pane.setMessage("Informe o diretório de relatórios");
            messageDialog = pane.createDialog("Aviso");
            messageDialog.setAlwaysOnTop(true);
            messageDialog.setVisible(true);
            
        } else {
            
            Configuracao.getInstance().setDiretorioDeBackup(campoDiretorioBackup.getText());
            Configuracao.getInstance().setDiretorioDeDocumentos(campoDiretorioDocumentos.getText());
            Configuracao.getInstance().setDiretorioDeRelatorios(campoDiretorioRelatorios.getText());
            try {
                GerenciadorDoSistema.getInstance().salvarEstadoDeConfiguracao(Configuracao.getInstance());
                
                pane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                pane.setMessage("Diretórios cadastrados com sucesso!");
                messageDialog = pane.createDialog("Aviso");
                messageDialog.setAlwaysOnTop(true);
                messageDialog.setVisible(true);

                salvarSelecionado = true; //O botão Salvar foi selecionado
                setVisible(false);
            } catch (Exception e) {
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                pane.setMessage(e.getMessage());
                messageDialog = pane.createDialog("Aviso");
                messageDialog.setAlwaysOnTop(true);
                messageDialog.setVisible(true);
            }
            
        }
        /*
        if(!cadastrou) {
            setVisible(true);
        }*/
    }//GEN-LAST:event_botaoSalvarActionPerformed
    
    public boolean alterarDados() {        
        salvarSelecionado = false;  //Marcamos que o salavar não foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible ap�s ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return salvarSelecionado;   //Retornamos true, se ele pressionou ok.
    }
    
    public void eliminarTextoDeCampo(javax.swing.JTextField campo) {
        campo.setText("");
        campo.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        campo.setForeground(new java.awt.Color(0, 0, 0));
    }
    
    public void criarTextoEmCampo(javax.swing.JTextField campo, String mensagem) {
        campo.setText(mensagem);
        campo.setForeground(new java.awt.Color(153, 153, 153));
        campo.setFont(new java.awt.Font("Tahoma", 2, 14));
    }

    protected boolean salvarSelecionado;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoDiretorioBackup;
    private javax.swing.JTextField campoDiretorioDocumentos;
    private javax.swing.JTextField campoDiretorioRelatorios;
    private javax.swing.JLabel labelDiretorioBackups;
    private javax.swing.JLabel labelDiretorioDocumentos;
    private javax.swing.JLabel labelDiretorioRelatorios;
    private javax.swing.JPanel painelDiretorios;
    // End of variables declaration//GEN-END:variables
}
