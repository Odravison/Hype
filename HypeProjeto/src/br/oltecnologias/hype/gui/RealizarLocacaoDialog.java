/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDeProduto;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Produto;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class RealizarLocacaoDialog extends java.awt.Dialog {

    /**
     * Creates new form RealizarLocacaoDialog
     */
    public RealizarLocacaoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        botaoConcluir.setIcon(new ImageIcon("Imagens\\Salvar.png"));
        botaoCancelar.setIcon(new ImageIcon("Imagens\\Cancelar.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelLocador = new javax.swing.JPanel();
        labelCliente = new javax.swing.JLabel();
        botaoSelecionarCliente = new javax.swing.JButton();
        labelNomeCliente = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoConcluir = new javax.swing.JButton();
        labelValorTotal = new javax.swing.JLabel();
        labelValorLocacao = new javax.swing.JLabel();
        painelSelecionar = new javax.swing.JPanel();
        botaoSelecionarProdutos = new javax.swing.JButton();
        campoPesquisar = new javax.swing.JTextField();
        botaoBuscar = new javax.swing.JButton();
        scPanelListarProdutos = new javax.swing.JScrollPane();
        listaProdutos = new javax.swing.JList();
        labelPesquisar = new javax.swing.JLabel();
        painelProdutos = new javax.swing.JPanel();
        botaoRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProdutosLocados = new javax.swing.JList();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(587, 650));
        setResizable(false);
        setTitle("Realizar Locação");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelLocador.setBackground(new java.awt.Color(255, 255, 255));
        painelLocador.setBorder(javax.swing.BorderFactory.createTitledBorder("Locador"));
        painelLocador.setPreferredSize(new java.awt.Dimension(488, 354));
        painelLocador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelLocadorMouseClicked(evt);
            }
        });

        labelCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCliente.setText("Cliente:*");

        botaoSelecionarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoSelecionarCliente.setText("Pesquisar");
        botaoSelecionarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarClienteActionPerformed(evt);
            }
        });

        labelNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout painelLocadorLayout = new javax.swing.GroupLayout(painelLocador);
        painelLocador.setLayout(painelLocadorLayout);
        painelLocadorLayout.setHorizontalGroup(
            painelLocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLocadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNomeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSelecionarCliente)
                .addContainerGap())
        );
        painelLocadorLayout.setVerticalGroup(
            painelLocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLocadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCliente)
                    .addComponent(botaoSelecionarCliente)
                    .addComponent(labelNomeCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoConcluir.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoConcluir.setText("Concluir");
        botaoConcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConcluirActionPerformed(evt);
            }
        });

        labelValorTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelValorTotal.setText("Valor Total: ");

        labelValorLocacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelValorLocacao.setForeground(new java.awt.Color(0, 153, 0));

        painelSelecionar.setBackground(new java.awt.Color(255, 255, 255));
        painelSelecionar.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecionar Produtos"));
        painelSelecionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelSelecionarMouseClicked(evt);
            }
        });

        botaoSelecionarProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoSelecionarProdutos.setText("Selecionar");
        botaoSelecionarProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSelecionarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarProdutosActionPerformed(evt);
            }
        });

        campoPesquisar.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        campoPesquisar.setForeground(new java.awt.Color(204, 204, 255));
        campoPesquisar.setText("Pesquisar Produto");
        campoPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoPesquisarMouseClicked(evt);
            }
        });
        campoPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPesquisarKeyTyped(evt);
            }
        });

        botaoBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoBuscar.setText("   Buscar  ");
        botaoBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarActionPerformed(evt);
            }
        });

        scPanelListarProdutos.setViewportView(listaProdutos);

        labelPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPesquisar.setText("Pesquisar:");

        javax.swing.GroupLayout painelSelecionarLayout = new javax.swing.GroupLayout(painelSelecionar);
        painelSelecionar.setLayout(painelSelecionarLayout);
        painelSelecionarLayout.setHorizontalGroup(
            painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSelecionarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSelecionarLayout.createSequentialGroup()
                        .addComponent(labelPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPesquisar)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSelecionarLayout.createSequentialGroup()
                        .addComponent(scPanelListarProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoBuscar)
                    .addComponent(botaoSelecionarProdutos))
                .addGap(14, 14, 14))
        );
        painelSelecionarLayout.setVerticalGroup(
            painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSelecionarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoBuscar)
                    .addComponent(labelPesquisar))
                .addGap(18, 18, 18)
                .addGroup(painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scPanelListarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSelecionarProdutos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelProdutos.setBackground(new java.awt.Color(255, 255, 255));
        painelProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos Locados"));
        painelProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelProdutosMouseClicked(evt);
            }
        });

        botaoRemover.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoRemover.setText("Remover");
        botaoRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaProdutosLocados);
        modeloProdutosLocados = new DefaultListModel();
        for (Produto produto : GerenciadorDeProduto.getInstance().getProdutosDeLocacao()) {
            modeloProdutosLocados.addElement(produto.getCodigo()+" | "+produto.getNome());
        }
        listaProdutos.setModel(modeloProdutosLocados);

        javax.swing.GroupLayout painelProdutosLayout = new javax.swing.GroupLayout(painelProdutos);
        painelProdutos.setLayout(painelProdutosLayout);
        painelProdutosLayout.setHorizontalGroup(
            painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoRemover)
                .addContainerGap())
        );
        painelProdutosLayout.setVerticalGroup(
            painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addGroup(painelProdutosLayout.createSequentialGroup()
                        .addComponent(botaoRemover)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(labelValorLocacao))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelValorTotal)
                        .addGap(274, 274, 274)
                        .addComponent(botaoConcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar))
                    .addComponent(painelSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelLocador, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addComponent(painelProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelLocador, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelValorLocacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoConcluir)
                        .addComponent(botaoCancelar))
                    .addComponent(labelValorTotal))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConcluirActionPerformed
        
    }//GEN-LAST:event_botaoConcluirActionPerformed

    private void botaoSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarClienteActionPerformed
        PesquisarClienteDialog dialog = new PesquisarClienteDialog(null);
        dialog.setLocationRelativeTo(null);
        if (dialog.alterarDados()) {
            labelNomeCliente.setText(dialog.getNomeClienteSelecionado());
        }
        dialog.dispose();
    }//GEN-LAST:event_botaoSelecionarClienteActionPerformed

    private void campoPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarKeyTyped
        if(campoPesquisar.getText().equals("Pesquisar Produto")) {
            eliminarTextoDeCampo(campoPesquisar);
        }
    }//GEN-LAST:event_campoPesquisarKeyTyped

    private void campoPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarMouseClicked
        if(campoPesquisar.getText().equals("Pesquisar Produto")) {
            eliminarTextoDeCampo(campoPesquisar);
        }
    }//GEN-LAST:event_campoPesquisarMouseClicked

    private void painelSelecionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelSelecionarMouseClicked
        if(campoPesquisar.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisar, "Pesquisar Produto");
        }
    }//GEN-LAST:event_painelSelecionarMouseClicked

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarActionPerformed
        if(campoPesquisar.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "É preciso informar o nome ou o código do produto para a pesquisa", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            DefaultListModel modelo = new DefaultListModel();
            for (Produto produto : GerenciadorDeProduto.getInstance().pesquisarProdutosPeloNome(campoPesquisar.getText())) {
                modelo.addElement(produto.getCodigo()+" | "+produto.getNome());
            }
            listaProdutos.setModel(modelo);
        }
    }//GEN-LAST:event_botaoBuscarActionPerformed

    private void botaoSelecionarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarProdutosActionPerformed
        if(listaProdutos.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um produto na lista para poder adicioná-lo aos produtos locados", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            modeloProdutosLocados.addElement(listaProdutosLocados.getSelectedValue().toString());
            listaProdutosLocados.setModel(modeloProdutosLocados);
        }
    }//GEN-LAST:event_botaoSelecionarProdutosActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        if(listaProdutosLocados.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para remoção", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            modeloProdutosLocados.removeElement(listaProdutosLocados.getSelectedValue().toString());
            listaProdutosLocados.setModel(modeloProdutosLocados);
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(campoPesquisar.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisar, "Pesquisar Produto");
        }
    }//GEN-LAST:event_formMouseClicked

    private void painelLocadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelLocadorMouseClicked
        if(campoPesquisar.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisar, "Pesquisar Produto");
        }
    }//GEN-LAST:event_painelLocadorMouseClicked

    private void painelProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelProdutosMouseClicked
        if(campoPesquisar.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisar, "Pesquisar Produto");
        }
    }//GEN-LAST:event_painelProdutosMouseClicked
   
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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RealizarLocacaoDialog dialog = new RealizarLocacaoDialog(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private DefaultListModel modeloProdutosLocados;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConcluir;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoSelecionarCliente;
    private javax.swing.JButton botaoSelecionarProdutos;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelNomeCliente;
    private javax.swing.JLabel labelPesquisar;
    private javax.swing.JLabel labelValorLocacao;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JList listaProdutos;
    private javax.swing.JList listaProdutosLocados;
    private javax.swing.JPanel painelLocador;
    private javax.swing.JPanel painelProdutos;
    private javax.swing.JPanel painelSelecionar;
    private javax.swing.JScrollPane scPanelListarProdutos;
    // End of variables declaration//GEN-END:variables
}
