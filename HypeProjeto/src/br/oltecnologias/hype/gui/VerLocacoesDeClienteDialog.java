/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDeLocacao;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Locacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luender Lima
 */
public class VerLocacoesDeClienteDialog extends java.awt.Dialog {

    public VerLocacoesDeClienteDialog(java.awt.Frame parent, Cliente cliente) {
        super(parent);
        this.cliente = cliente;
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelLocacoesFeitas = new javax.swing.JPanel();
        pnRlCliente = new javax.swing.JScrollPane();
        tabelaLocacoes = new javax.swing.JTable();
        botaoOk = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Ver Locações Feitas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelLocacoesFeitas.setBackground(new java.awt.Color(255, 255, 255));
        painelLocacoesFeitas.setBorder(javax.swing.BorderFactory.createTitledBorder("Locações Feitas"));

        pnRlCliente.setBackground(new java.awt.Color(255, 255, 255));
        pnRlCliente.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnRlCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnRlCliente.setPreferredSize(new java.awt.Dimension(826, 340));

        tabelaLocacoes.setAutoCreateRowSorter(true);
        tabelaLocacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaLocacoes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelaLocacoes.getTableHeader().setResizingAllowed(false);
        tabelaLocacoes.getTableHeader().setReorderingAllowed(false);
        tabelaLocacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Define a fonte do cabeçalho da tabela fornecedores
        tabelaLocacoes.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 15));
        // Altura das linhas
        tabelaLocacoes.setRowHeight(25);
        String[] nomesColunasTabelaLocacoes = {"Data da Locação", "Produtos Locados", "Valor Total", ""};
        //Essa lista terá as linhas da tabela
        List<Object[]> listaLinhasLocacoes = new ArrayList<>();
        //Adicionando valores nas linhas
        for (Locacao locacao : GerenciadorDeLocacao.getInstance().pesquisarLocacoesDeCliente(cliente.getCpf())) {
            try {
                listaLinhasLocacoes.add(new Object[]{locacao.getDataLocacaoInString(),
                    GerenciadorDeLocacao.getInstance().getProdutosDeLocacaoInString(locacao.getId()), "R$ "+locacao.getValorLocacaoInString(), Long.toString(locacao.getId())});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na hora de buscar os dados da locação", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    //cria um defaultablemodel com as informações acima
    modeloTabelaLocacoes = new DefaultTableModel(
        listaLinhasLocacoes.toArray(new Object[listaLinhasLocacoes.size()][]), nomesColunasTabelaLocacoes){

        boolean[] canEdit = new boolean [] {false, false, false};

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
        }

    };

    //define o model da tabela
    tabelaLocacoes.setModel(modeloTabelaLocacoes);
    // Redimensionando a largura da coluna de data
    tabelaLocacoes.getColumnModel().getColumn(0).setPreferredWidth(150);
    // Redimensionando a largura da coluna de produtos locados
    tabelaLocacoes.getColumnModel().getColumn(1).setPreferredWidth(957);
    // Redimensionando a largura da coluna de valor total
    tabelaLocacoes.getColumnModel().getColumn(2).setPreferredWidth(160);
    // Redimensionando a largura da coluna id da locação
    tabelaLocacoes.getColumnModel().getColumn(3).setPreferredWidth(0);
    pnRlCliente.setViewportView(tabelaLocacoes);

    javax.swing.GroupLayout painelLocacoesFeitasLayout = new javax.swing.GroupLayout(painelLocacoesFeitas);
    painelLocacoesFeitas.setLayout(painelLocacoesFeitasLayout);
    painelLocacoesFeitasLayout.setHorizontalGroup(
        painelLocacoesFeitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelLocacoesFeitasLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(pnRlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE)
            .addContainerGap())
    );
    painelLocacoesFeitasLayout.setVerticalGroup(
        painelLocacoesFeitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelLocacoesFeitasLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(pnRlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
            .addContainerGap())
    );

    botaoOk.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
    botaoOk.setText("  OK  ");
    botaoOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoOk.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoOkActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(painelLocacoesFeitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoOk))
            .addGap(23, 23, 23))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(painelLocacoesFeitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(botaoOk)
            .addGap(25, 25, 25))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoOkActionPerformed

    private Cliente cliente;
    private DefaultTableModel modeloTabelaLocacoes;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoOk;
    private javax.swing.JPanel painelLocacoesFeitas;
    private javax.swing.JScrollPane pnRlCliente;
    private javax.swing.JTable tabelaLocacoes;
    // End of variables declaration//GEN-END:variables
}
