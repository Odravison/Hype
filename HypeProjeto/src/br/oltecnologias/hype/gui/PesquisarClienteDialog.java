/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDePessoas;
import br.oltecnologias.hype.model.Cliente;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luender Lima
 */
public class PesquisarClienteDialog extends java.awt.Dialog {

    public PesquisarClienteDialog(Frame owner) {
        super(owner);
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDados = new javax.swing.JPanel();
        campoCliente = new javax.swing.JTextField();
        botaoPesquisar = new javax.swing.JButton();
        scPnClientes = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        botaoOk = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Pesquisar Cliente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Cliente"));

        campoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        botaoPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        String[] nomesColunasTabelaClientes = {"CPF", "Nome do Cliente"};
        //Define a fonte do cabeçalho da tabela clientes
        tabelaClientes.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 14));
        //Altura da linha
        tabelaClientes.setRowHeight(20);

        //Lista que terá as linhas da tabela
        List<Object[]> listaLinhas = new ArrayList<>();

        //Adicionando valores nas linhas
        for (Cliente cliente : GerenciadorDePessoas.getInstance().getClientes()) {
            listaLinhas.add(new Object[]{cliente.getCpf(), cliente.getNome()});
        }
        //cria um defaultablemodel com as informações acima
        modeloTabelaClientes = new DefaultTableModel(
            listaLinhas.toArray(new Object[listaLinhas.size()][]), nomesColunasTabelaClientes){

            boolean[] canEdit = new boolean [] {false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex];
            }

        };

        //define o model da tabela
        tabelaClientes.setModel(modeloTabelaClientes);
        // Redimensionando a largura da coluna de CPF
        tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(130);
        // Redimensionando a largura da coluna de nome
        tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(366);
        tabelaClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scPnClientes.setViewportView(tabelaClientes);

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scPnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(campoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisar)))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar))
                .addGap(18, 18, 18)
                .addComponent(scPnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        botaoOk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoOk.setText("  OK  ");
        botaoOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        botaoVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVoltar)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoOk))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
        if(tabelaClientes.getSelectedRow() < 0) {
            JOptionPane pane = new JOptionPane();
            pane.setMessage("É preciso selecionar um cliente na lista antes de continuar");
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            JDialog dialog = pane.createDialog("Aviso");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            
        } else {
            okSelecionado = true; //O ok foi selecionado.
            setVisible(false);
        }
        
    }//GEN-LAST:event_botaoOkActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        if(campoCliente.getText().length() <= 0) {
            JOptionPane pane = new JOptionPane();
            pane.setMessage("É preciso informar um nome para a pesquisa de clientes");
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            JDialog dialog = pane.createDialog("Aviso");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        } else {
            modeloTabelaClientes.setRowCount(0);
            if(campoCliente.getText().toUpperCase().equals("TODOS")) {
                for (Cliente cliente : GerenciadorDePessoas.getInstance().getClientes()) {
                    modeloTabelaClientes.addRow(new Object[]{cliente.getCpf(), cliente.getNome()});
                }
            } else {
                for (Cliente cliente : GerenciadorDePessoas.getInstance().pesquisarClientesPorNome(campoCliente.getText())) {
                    modeloTabelaClientes.addRow(new Object[]{cliente.getCpf(), cliente.getNome()});
                }
            }
        }
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    public boolean alterarDados() {        
        okSelecionado = false;  //Marcamos que o ok n�o foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible ap�s ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return okSelecionado;   //Retornamos true, se ele pressionou ok.
    }
    
    public String getNomeClienteSelecionado() {
        //O nome do cliente está na segunda coluna da tabela
        return (String) tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 1);
    }
    
    public String getCpfLocador() {
        //O CPF do cliente está na primeira coluna da tabela
        return (String) tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0);
    }

    protected boolean okSelecionado;
    private DefaultTableModel modeloTabelaClientes;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoOk;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoCliente;
    private javax.swing.JPanel painelDados;
    private javax.swing.JScrollPane scPnClientes;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables
}
