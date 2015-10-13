/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDeLocacao;
import br.oltecnologias.hype.controller.GerenciadorDePessoas;
import br.oltecnologias.hype.controller.GerenciadorDeProduto;
import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.exception.ClienteInexistenteException;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.exception.TemporadaInexistenteException;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Movimentacao;
import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.ProdutoLocado;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luender Lima
 */
public class RealizarLocacaoDialog extends java.awt.Dialog {

    public RealizarLocacaoDialog(Frame owner) {
        super(owner);
        initComponents();
        locador = null;
        valorGeral = 0;
        valorTotalComDescontos = 0;
        valorTotalLocacao = valorGeral;
        produtosLocados = new ArrayList<ProdutoLocado>();
        pane = new JOptionPane();
        dialog = null;
        listaRowProdutos = new ArrayList<>();
        produtosEmEstoque = GerenciadorDeProduto.getInstance().getProdutosDeLocacao();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
        botaoConcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Salvar.png")));
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Cancelar.png")));
        try {
            percentualDescontoTemporada = GerenciadorDoSistema.getInstance().getPercentualDescontoTemporada("LOCAÇÃO");
        } catch (TemporadaInexistenteException e) {
            pane.setMessage("Não foi possível atualizar o valor da temporada de desconto\n" + e.getMessage());
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            dialog = pane.createDialog("Aviso");
            dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelLocador = new javax.swing.JPanel();
        labelCliente = new javax.swing.JLabel();
        botaoSelecionarCliente = new javax.swing.JButton();
        labelNomeCliente = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoConcluir = new javax.swing.JButton();
        labelValorTotal = new javax.swing.JLabel();
        painelSelecionar = new javax.swing.JPanel();
        botaoSelecionarProdutos = new javax.swing.JButton();
        campoPesquisar = new javax.swing.JTextField();
        botaoPesquisar = new javax.swing.JButton();
        scPnProdutos = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        painelProdutos = new javax.swing.JPanel();
        botaoRemover = new javax.swing.JButton();
        scPnTabelaProdutosLocados = new javax.swing.JScrollPane();
        tabelaProdutosLocados = new javax.swing.JTable();
        painelContrato = new javax.swing.JPanel();
        labelDataInicial = new javax.swing.JLabel();
        dateDataInicialContrato = new com.toedter.calendar.JDateChooser();
        labelDataFinal = new javax.swing.JLabel();
        dateDataFinalContrato = new com.toedter.calendar.JDateChooser();
        labelMensagemContrato = new javax.swing.JLabel();
        botaoBuscar = new javax.swing.JButton();
        labelDesconto = new javax.swing.JLabel();
        campoValorDesconto = new javax.swing.JTextField();
        labelValorLocacao = new javax.swing.JLabel();
        painelFormaPagamento = new javax.swing.JPanel();
        radioAVista = new javax.swing.JRadioButton();
        radioCartao = new javax.swing.JRadioButton();
        radioPromissoria = new javax.swing.JRadioButton();
        labelEntrada = new javax.swing.JLabel();
        campoEntrada = new javax.swing.JTextField();
        labelParcelas = new javax.swing.JLabel();
        campoParcelas = new javax.swing.JTextField();
        radioCredito = new javax.swing.JRadioButton();
        radioDebito = new javax.swing.JRadioButton();
        comboFormaPagamentoEntrada = new javax.swing.JComboBox();
        labelValorParcelas = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        labelStatusTemporada = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
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
        painelLocador.setPreferredSize(new java.awt.Dimension(568, 79));
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
        labelNomeCliente.setPreferredSize(new java.awt.Dimension(10, 6));

        javax.swing.GroupLayout painelLocadorLayout = new javax.swing.GroupLayout(painelLocador);
        painelLocador.setLayout(painelLocadorLayout);
        painelLocadorLayout.setHorizontalGroup(
            painelLocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLocadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoSelecionarCliente)
                .addContainerGap())
        );
        painelLocadorLayout.setVerticalGroup(
            painelLocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLocadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelNomeCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoSelecionarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
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

        labelValorTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelValorTotal.setText("Valor Final: ");

        painelSelecionar.setBackground(new java.awt.Color(255, 255, 255));
        painelSelecionar.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos Disponíveis"));
        painelSelecionar.setPreferredSize(new java.awt.Dimension(564, 238));
        painelSelecionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelSelecionarMouseClicked(evt);
            }
        });

        botaoSelecionarProdutos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        campoPesquisar.setToolTipText("Pesquise pelo nome do produto");
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

        botaoPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        scPnProdutos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scPnProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scPnProdutos.setPreferredSize(new java.awt.Dimension(478, 402));

        tabelaProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Define a fonte do cabeçalho da tabela de produtos
        tabelaProdutos.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 14));
        // Altura das linhas
        tabelaProdutos.setRowHeight(20);

        String[] nomesColunasTabelaProdutos = {"Código", "Descrição", "Qtd"};
        //Essa lista terá as linhas da tabela
        List<Object[]> listaLinhasProdutos = new ArrayList<>();

        //cria um defaultablemodel com as informações acima
        modeloTabelaProdutos = new DefaultTableModel(
            listaLinhasProdutos.toArray(new Object[listaLinhasProdutos.size()][]), nomesColunasTabelaProdutos){

            boolean[] canEdit = new boolean [] {false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex];
            }

        };

        //define o model da tabela
        tabelaProdutos.setModel(modeloTabelaProdutos);
        // Redimensionando a largura da coluna de código
        tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(75);
        // Redimensionando a largura da coluna de descrição
        tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(392);
        // Redimensionando a largura da coluna de finalidade
        tabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(40);
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        scPnProdutos.setViewportView(tabelaProdutos);

        javax.swing.GroupLayout painelSelecionarLayout = new javax.swing.GroupLayout(painelSelecionar);
        painelSelecionar.setLayout(painelSelecionarLayout);
        painelSelecionarLayout.setHorizontalGroup(
            painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSelecionarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPesquisar)
                    .addComponent(scPnProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addGroup(painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSelecionarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botaoSelecionarProdutos))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSelecionarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisar)))
                .addContainerGap())
        );
        painelSelecionarLayout.setVerticalGroup(
            painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSelecionarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar))
                .addGap(18, 18, 18)
                .addGroup(painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSelecionarLayout.createSequentialGroup()
                        .addComponent(botaoSelecionarProdutos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scPnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelProdutos.setBackground(new java.awt.Color(255, 255, 255));
        painelProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos Locados"));
        painelProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelProdutosMouseClicked(evt);
            }
        });

        botaoRemover.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoRemover.setText("Remover");
        botaoRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });

        scPnTabelaProdutosLocados.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scPnTabelaProdutosLocados.setPreferredSize(new java.awt.Dimension(532, 402));

        tabelaProdutosLocados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Define a fonte do cabeçalho da tabela de produtos
        tabelaProdutosLocados.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 14));
        // Altura das linhas
        tabelaProdutosLocados.setRowHeight(20);

        String[] nomesColunasTabelaProdutosLocados = {"Código", "Descrição", "Qtd"};
        //Essa lista terá as linhas da tabela
        List<Object[]> listaLinhasProdutosLocados = new ArrayList<>();

        //cria um defaultablemodel com as informações acima
        modeloTabelaProdutosLocados = new DefaultTableModel(
            listaLinhasProdutosLocados.toArray(new Object[listaLinhasProdutosLocados.size()][]), nomesColunasTabelaProdutosLocados){

            boolean[] canEdit = new boolean [] {false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex];
            }

        };

        //define o model da tabela
        tabelaProdutosLocados.setModel(modeloTabelaProdutosLocados);
        // Redimensionando a largura da coluna de código
        tabelaProdutosLocados.getColumnModel().getColumn(0).setPreferredWidth(75);
        // Redimensionando a largura da coluna de descrição
        tabelaProdutosLocados.getColumnModel().getColumn(1).setPreferredWidth(392);
        // Redimensionando a largura da coluna de finalidade
        tabelaProdutosLocados.getColumnModel().getColumn(2).setPreferredWidth(40);
        tabelaProdutosLocados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaProdutosLocados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosLocadosMouseClicked(evt);
            }
        });
        scPnTabelaProdutosLocados.setViewportView(tabelaProdutosLocados);

        javax.swing.GroupLayout painelProdutosLayout = new javax.swing.GroupLayout(painelProdutos);
        painelProdutos.setLayout(painelProdutosLayout);
        painelProdutosLayout.setHorizontalGroup(
            painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scPnTabelaProdutosLocados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoRemover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelProdutosLayout.setVerticalGroup(
            painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoRemover)
                    .addComponent(scPnTabelaProdutosLocados, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelContrato.setBackground(new java.awt.Color(255, 255, 255));
        painelContrato.setBorder(javax.swing.BorderFactory.createTitledBorder("Contrato"));
        painelContrato.setPreferredSize(new java.awt.Dimension(571, 130));

        labelDataInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDataInicial.setText("Data Inicial:*");

        labelDataFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDataFinal.setText("Data Final:*");

        labelMensagemContrato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMensagemContrato.setText("Informe a duração do contrato:");

        botaoBuscar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        botaoBuscar.setText("Buscar");
        botaoBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelContratoLayout = new javax.swing.GroupLayout(painelContrato);
        painelContrato.setLayout(painelContratoLayout);
        painelContratoLayout.setHorizontalGroup(
            painelContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelContratoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelDataInicial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateDataInicialContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(labelDataFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateDataFinalContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(botaoBuscar)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelContratoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelMensagemContrato)
                .addGap(217, 217, 217))
        );
        painelContratoLayout.setVerticalGroup(
            painelContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelContratoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelContratoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoBuscar))
                    .addGroup(painelContratoLayout.createSequentialGroup()
                        .addComponent(labelMensagemContrato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(painelContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateDataFinalContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateDataInicialContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDataInicial)
                            .addComponent(labelDataFinal))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        labelDesconto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelDesconto.setText("Desconto:");

        campoValorDesconto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoValorDesconto.setEnabled(false);
        campoValorDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoValorDescontoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoValorDescontoKeyTyped(evt);
            }
        });

        labelValorLocacao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelValorLocacao.setForeground(new java.awt.Color(0, 153, 0));

        painelFormaPagamento.setBackground(new java.awt.Color(255, 255, 255));
        painelFormaPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma de Pagamento"));
        painelFormaPagamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelFormaPagamento.setPreferredSize(new java.awt.Dimension(636, 130));

        radioAVista.setBackground(new java.awt.Color(255, 255, 255));
        radioAVista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioAVista.setSelected(true);
        radioAVista.setText("À Vista");
        radioAVista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioAVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAVistaActionPerformed(evt);
            }
        });
        radioAVista.setSelected(true);
        labelEntrada.setVisible(false);
        labelParcelas.setVisible(false);
        campoEntrada.setVisible(false);
        campoParcelas.setVisible(false);

        radioCartao.setBackground(new java.awt.Color(255, 255, 255));
        radioCartao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioCartao.setText("Cartão");
        radioCartao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCartaoActionPerformed(evt);
            }
        });

        radioPromissoria.setBackground(new java.awt.Color(255, 255, 255));
        radioPromissoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioPromissoria.setText("Promissória");
        radioPromissoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioPromissoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPromissoriaActionPerformed(evt);
            }
        });

        labelEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelEntrada.setText("Entrada: R$");

        campoEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoEntradaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoEntradaKeyTyped(evt);
            }
        });

        labelParcelas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelParcelas.setText("Qtd. Parcelas:*");

        campoParcelas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoParcelasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoParcelasKeyTyped(evt);
            }
        });

        radioCredito.setBackground(new java.awt.Color(255, 255, 255));
        radioCredito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioCredito.setText("Crédito");
        radioCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioCredito.setVisible(false);
        radioCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCreditoActionPerformed(evt);
            }
        });

        radioDebito.setBackground(new java.awt.Color(255, 255, 255));
        radioDebito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioDebito.setSelected(true);
        radioDebito.setText("Débito");
        radioDebito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioDebito.setVisible(false);
        radioDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDebitoActionPerformed(evt);
            }
        });

        comboFormaPagamentoEntrada.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        comboFormaPagamentoEntrada.setMaximumRowCount(3);
        comboFormaPagamentoEntrada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cartão" }));
        comboFormaPagamentoEntrada.setVisible(false);

        javax.swing.GroupLayout painelFormaPagamentoLayout = new javax.swing.GroupLayout(painelFormaPagamento);
        painelFormaPagamento.setLayout(painelFormaPagamentoLayout);
        painelFormaPagamentoLayout.setHorizontalGroup(
            painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormaPagamentoLayout.createSequentialGroup()
                .addGroup(painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelFormaPagamentoLayout.createSequentialGroup()
                        .addGap(20, 202, Short.MAX_VALUE)
                        .addGroup(painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelFormaPagamentoLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(radioCredito)
                                .addGap(77, 77, 77)
                                .addComponent(radioDebito))
                            .addGroup(painelFormaPagamentoLayout.createSequentialGroup()
                                .addComponent(radioAVista)
                                .addGap(18, 18, 18)
                                .addComponent(radioCartao)
                                .addGap(18, 18, 18)
                                .addComponent(radioPromissoria))))
                    .addGroup(painelFormaPagamentoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(comboFormaPagamentoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(labelParcelas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        painelFormaPagamentoLayout.setVerticalGroup(
            painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormaPagamentoLayout.createSequentialGroup()
                .addGroup(painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioAVista)
                    .addComponent(radioCartao)
                    .addComponent(radioPromissoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addGroup(painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioCredito)
                    .addComponent(radioDebito))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEntrada)
                    .addComponent(campoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelParcelas)
                    .addComponent(campoParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFormaPagamentoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelValorParcelas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelValorParcelas.setForeground(new java.awt.Color(0, 0, 102));

        labelStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelStatus.setText("Temporada de descontos");

        labelStatusTemporada.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        try {
            if(GerenciadorDoSistema.getInstance().isTemporadaAtivada("LOCAÇÃO")) {
                labelStatusTemporada.setForeground(new java.awt.Color(0, 153, 0));
                labelStatusTemporada.setText("ON");
            } else {
                labelStatusTemporada.setText("OFF");
                labelStatusTemporada.setForeground(new java.awt.Color(255, 0, 0));
            }
        } catch(TemporadaInexistenteException e) {
            labelStatusTemporada.setText("OFF");
            labelStatusTemporada.setForeground(new java.awt.Color(255, 0, 0));
        } catch (Exception e) {
            labelStatusTemporada.setText("OFF");
            labelStatusTemporada.setForeground(new java.awt.Color(255, 0, 0));
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("R$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(painelSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                        .addComponent(painelFormaPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(labelDesconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoValorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelStatus)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelStatusTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoConcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botaoCancelar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painelContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(painelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(painelLocador, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelLocador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(painelSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoCancelar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoConcluir)
                        .addComponent(labelValorTotal)
                        .addComponent(labelDesconto)
                        .addComponent(campoValorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelValorLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelValorParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelStatus)
                        .addComponent(labelStatusTemporada)
                        .addComponent(jLabel1)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConcluirActionPerformed
        try {
            if (labelNomeCliente.getText().length() <= 0) {
                pane.setMessage("Selecione o cliente que irá realizar a locação");
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else if (produtosLocados.size() <= 0) {
                pane.setMessage("Selecione os produtos para a locação");
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else if (campoValorDesconto.getText().length() > valorTotalComDescontos) {
                pane.setMessage("O valor de desconto não pode ser maior do que o valor total da locação");
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else if (!radioAVista.isSelected() && !radioCartao.isSelected() && !radioPromissoria.isSelected()) {
                pane.setMessage("Informe a forma de pagamento da locação");
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else if (radioCartao.isSelected() && !radioCredito.isSelected() && !radioDebito.isSelected()) {
                pane.setMessage("Informe a forma de pagamento da locação");
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            } else if ((radioCredito.isSelected() || radioPromissoria.isSelected()) && campoParcelas.getText().length() <= 0) {
                pane.setMessage("Informe a quantidade de parcelas da locação");
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else if (dateDataFinalContrato.getCalendar().before(dateDataInicialContrato.getCalendar())) {
                pane.setMessage("A data final do contrato não pode ser anterior a data inicial");
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            } else {

                //Se o campo de desconto estiver em branco, a locação terá 0% de desconto
                if (campoValorDesconto.getText().length() <= 0) {
                    campoValorDesconto.setText("0");
                } else {
                    calcularValorTotal();
                }
                //Se o campo de entrada estiver em branco, a locação terá R$ 0 de entrada
                if (campoEntrada.getText().length() <= 0) {
                    campoEntrada.setText("0");
                } 
                //Se o campo de parcelas estiver em branco, a quantidade de parcelas será 0
                if (campoParcelas.getText().length() <= 0) {
                    campoParcelas.setText("0");
                }
                
                if (radioCartao.isSelected()) {
                    if (radioCartao.isSelected()) {
                        formaPagamento = "Cartão - Crédito";
                    } else {
                        formaPagamento = "Cartão - Débito";
                    }
                } else if (radioPromissoria.isSelected()) {
                    formaPagamento = "Promissória";
                    formaPagamentoEntrada = (String) comboFormaPagamentoEntrada.getSelectedItem();
                  
                } else {
                    formaPagamento = "À Vista";
                    campoEntrada.setText("0");
                    campoParcelas.setText("0");
                }

                try {
                    aguarde.setLocationRelativeTo(null);
                    this.setAlwaysOnTop(false);
                    aguarde.setAlwaysOnTop(true);
                    aguarde.setVisible(true);

                    new SwingWorker() {
                        @Override
                        protected Object doInBackground() throws Exception {
                            novaLocacao = GerenciadorDeLocacao.getInstance().realizarLocacao(locador, produtosLocados, valorTotalComDescontos, dateDataInicialContrato.getCalendar(),
                                    dateDataFinalContrato.getCalendar(), formaPagamento, Integer.parseInt(campoParcelas.getText()),
                                    Double.parseDouble(campoEntrada.getText()), Integer.parseInt(campoValorDesconto.getText()), formaPagamentoEntrada);

                            novaMovimentacao = GerenciadorDoSistema.getInstance().adicionarMovimentacaoDeLocacao(novaLocacao);

                            //O botão concluir foi selecionado
                            concluirSelecionado = true;
                            return null;
                        }

                        @Override
                        protected void done() {
                            aguarde.dispose();
                            pane.setMessage("Locação efetuada com sucesso!");
                            pane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                            dialog = pane.createDialog("Mensagem");
                            dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);
                            //Fecha janela
                            setVisible(false);

                        }
                    }.execute();

                } catch (Exception e) {
                    pane.setMessage(e.getMessage());
                    pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                    dialog = pane.createDialog("Erro");
                    dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    this.setAlwaysOnTop(true);
                }

            }
        } catch (Exception e) {
            pane.setMessage("Informe corretamente todos os dados necessários");
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            dialog = pane.createDialog("Aviso");
            dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            this.setAlwaysOnTop(true);
        }


    }//GEN-LAST:event_botaoConcluirActionPerformed

    private void botaoSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarClienteActionPerformed
        PesquisarClienteDialog dialogPesquisarCliente = new PesquisarClienteDialog(null);
        dialogPesquisarCliente.setLocationRelativeTo(null);
        if (dialogPesquisarCliente.alterarDados()) {
            labelNomeCliente.setText(dialogPesquisarCliente.getNomeClienteSelecionado());
            try {
                locador = GerenciadorDePessoas.getInstance().pesquisarCliente(dialogPesquisarCliente.getCpfLocador());
            } catch (ClienteInexistenteException e) {
                pane.setMessage(e.getMessage());
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }
        dialogPesquisarCliente.dispose();
    }//GEN-LAST:event_botaoSelecionarClienteActionPerformed

    private void campoPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarKeyTyped
        if (campoPesquisar.getText().equals("Pesquisar Produto")) {
            eliminarTextoDeCampo(campoPesquisar);
        }

    }//GEN-LAST:event_campoPesquisarKeyTyped

    private void campoPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarMouseClicked
        if (campoPesquisar.getText().equals("Pesquisar Produto")) {
            eliminarTextoDeCampo(campoPesquisar);
        }

    }//GEN-LAST:event_campoPesquisarMouseClicked

    private void painelSelecionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelSelecionarMouseClicked
        if (campoPesquisar.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisar, "Pesquisar Produto");
        }
        //Se alguma linha da tabela estiver selecionada
        if (tabelaProdutos.getSelectedRow() >= 0) {
            tabelaProdutos.clearSelection();
        }
    }//GEN-LAST:event_painelSelecionarMouseClicked

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        if (campoPesquisar.getText().length() <= 0) {
            pane.setMessage("É preciso informar o nome ou o código do produto para a pesquisa");
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            dialog = pane.createDialog("Aviso");
            dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        } else {
            //Limpa a tabela de produtos
            modeloTabelaProdutos.setRowCount(0);
            aguarde.setLocationRelativeTo(null);
            aguarde.setVisible(true);
            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    for (Object[] row : listaRowProdutos) {
                        if(((String)row[1]).toUpperCase().contains(campoPesquisar.getText().toUpperCase())) {
                            modeloTabelaProdutos.addRow(row);
                        }
                    }

                    return null;
                }

                @Override
                protected void done() {
                    aguarde.dispose();
                }
            }.execute();
        }
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void botaoSelecionarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarProdutosActionPerformed
        if (tabelaProdutos.getSelectedRow() < 0) {
            pane.setMessage("Selecione um produto na lista para poder adicioná-lo aos produtos locados");
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            dialog = pane.createDialog("Aviso");
            dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);

        } else {
            try {
                adicionarProdutoALocacao(GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(
                        (String) modeloTabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0)));
                calcularValorTotal();
                campoValorDesconto.setEnabled(true);
                campoParcelas.setEnabled(true);
                campoEntrada.setEnabled(true);
            } catch (ProdutoInexistenteException e) {
                pane.setMessage(e.getMessage());
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_botaoSelecionarProdutosActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        if (tabelaProdutosLocados.getSelectedRow() < 0) {
            pane.setMessage("Selecione um produto para remoção");
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            dialog = pane.createDialog("Aviso");
            dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        } else {
            removerProdutoDaLocacao(tabelaProdutosLocados.getSelectedRow(), (String) modeloTabelaProdutosLocados.getValueAt(tabelaProdutosLocados.getSelectedRow(), 0));
            calcularValorTotal();
            campoValorDesconto.setEnabled(false);
            campoParcelas.setEnabled(false);
            campoEntrada.setEnabled(false);
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (campoPesquisar.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisar, "Pesquisar Produto");
        }

    }//GEN-LAST:event_formMouseClicked

    private void painelLocadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelLocadorMouseClicked
        if (campoPesquisar.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisar, "Pesquisar Produto");
        }

    }//GEN-LAST:event_painelLocadorMouseClicked

    private void painelProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelProdutosMouseClicked
        if (campoPesquisar.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisar, "Pesquisar Produto");
        }
        //Se alguma linha da tabela estiver selecionada
        if (tabelaProdutosLocados.getSelectedRow() >= 0) {
            tabelaProdutosLocados.clearSelection();
        }
    }//GEN-LAST:event_painelProdutosMouseClicked

    private void campoValorDescontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoValorDescontoKeyTyped
        if ((!numeros.contains(evt.getKeyChar() + "") && evt.getKeyChar() != '.') || campoValorDesconto.getText().length() >= maxCaracteresDesconto
                || Double.parseDouble(campoValorDesconto.getText() + evt.getKeyChar()) > valorTotalComDescontos
                || Double.parseDouble(campoValorDesconto.getText() + evt.getKeyChar()) == 0) {
            evt.consume();
        }
    }//GEN-LAST:event_campoValorDescontoKeyTyped

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        if (evt.getClickCount() == 2 && modeloTabelaProdutos.getRowCount() > 0) {
            try {
                adicionarProdutoALocacao(GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(
                        (String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0)));

                calcularValorTotal();
                
                campoValorDesconto.setEnabled(true);
                campoParcelas.setEnabled(true);
                campoEntrada.setEnabled(true);
            } catch (ProdutoInexistenteException e) {
                pane.setMessage(e.getMessage());
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void tabelaProdutosLocadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosLocadosMouseClicked
        if (evt.getClickCount() == 2 && modeloTabelaProdutosLocados.getRowCount() > 0) {
            removerProdutoDaLocacao(tabelaProdutosLocados.getSelectedRow(), (String) tabelaProdutosLocados.getValueAt(tabelaProdutosLocados.getSelectedRow(), 0));
            calcularValorTotal();
            //calcularValorTotalLocacao();
        }
        if (produtosLocados.size() <= 0) {
            campoValorDesconto.setEnabled(false);
            campoParcelas.setEnabled(false);
            campoEntrada.setEnabled(false);
            campoValorDesconto.setText("");
            labelValorLocacao.setText("");
        }
    }//GEN-LAST:event_tabelaProdutosLocadosMouseClicked

    private void radioAVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAVistaActionPerformed
        radioCartao.setSelected(false);
        radioPromissoria.setSelected(false);
        desabilitarCampos();
        desabilitarRadios();  
        if(campoParcelas.getText().length() > 0 || campoEntrada.getText().length() > 0) {
            limparValores();
        }
    }//GEN-LAST:event_radioAVistaActionPerformed

    private void radioCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCartaoActionPerformed
        radioAVista.setSelected(false);
        radioPromissoria.setSelected(false);
        habilitarRadios();
        desabilitarCampos();
        if(campoParcelas.getText().length() > 0 || campoEntrada.getText().length() > 0) {
            limparValores();
        }
    }//GEN-LAST:event_radioCartaoActionPerformed

    private void radioPromissoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPromissoriaActionPerformed
        radioCartao.setSelected(false);
        radioAVista.setSelected(false);
        comboFormaPagamentoEntrada.setVisible(true);
        habilitarCampos();
        desabilitarRadios();
        if(campoParcelas.getText().length() > 0 || campoEntrada.getText().length() > 0) {
            limparValores();
        }
    }//GEN-LAST:event_radioPromissoriaActionPerformed

    private void radioCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCreditoActionPerformed
        radioDebito.setSelected(false);
        habilitarCampos();
    }//GEN-LAST:event_radioCreditoActionPerformed

    private void radioDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDebitoActionPerformed
        radioCredito.setSelected(false);
        desabilitarCampos();
    }//GEN-LAST:event_radioDebitoActionPerformed

    private void campoParcelasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoParcelasKeyTyped
        if (!numeros.contains(evt.getKeyChar() + "") || campoParcelas.getText().length() >= maxCaracteresParcelas
                || Integer.parseInt(campoParcelas.getText() + evt.getKeyChar()) > maxParcelas
                || Integer.parseInt(campoParcelas.getText() + evt.getKeyChar()) == 0) {
            evt.consume();
        }
    }//GEN-LAST:event_campoParcelasKeyTyped

    private void campoParcelasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoParcelasKeyReleased
        if ((numeros.contains(evt.getKeyChar() + "") && campoParcelas.getText().length() < maxCaracteresParcelas
                && Integer.parseInt(campoParcelas.getText()) <= maxParcelas) || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
                || Integer.parseInt(campoParcelas.getText()) > 0
                || evt.getKeyCode() == KeyEvent.VK_DELETE) {

            calcularValorTotal();

        }
    }//GEN-LAST:event_campoParcelasKeyReleased

    private void campoValorDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoValorDescontoKeyReleased
        if (((numeros.contains(evt.getKeyChar() + "") || evt.getKeyChar() == '.') && campoValorDesconto.getText().length() <= maxCaracteresDesconto
                && (Double.parseDouble(campoValorDesconto.getText()) < valorTotalComDescontos && Double.parseDouble(campoValorDesconto.getText()) > 0))
                || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
                || evt.getKeyCode() == KeyEvent.VK_DELETE) {

            calcularValorTotal();
        }
    }//GEN-LAST:event_campoValorDescontoKeyReleased

    private void campoEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEntradaKeyTyped
        if ((!numeros.contains(evt.getKeyChar() + "") && evt.getKeyChar() != '.') || campoEntrada.getText().length() >= maxCaracteresEntrada
                || Double.parseDouble(campoEntrada.getText() + evt.getKeyChar()) >= valorTotalComDescontos
                || Double.parseDouble(campoEntrada.getText() + evt.getKeyChar()) == 0) {

            evt.consume();
        }
    }//GEN-LAST:event_campoEntradaKeyTyped

    private void campoEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEntradaKeyReleased
        if (((numeros.contains(evt.getKeyChar() + "") || evt.getKeyChar() == '.')
                && campoEntrada.getText().length() <= maxCaracteresEntrada && (Double.parseDouble(campoEntrada.getText()) > 0
                && Double.parseDouble(campoEntrada.getText()) < valorTotalComDescontos))
                || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
                || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            calcularValorTotal();
            
        }
    }//GEN-LAST:event_campoEntradaKeyReleased

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarActionPerformed
        try {
            Calendar dataInicial = dateDataInicialContrato.getCalendar();
            Calendar dataFinal = dateDataFinalContrato.getCalendar();
            modeloTabelaProdutos.setRowCount(0);
            
            zerarValores();
            
            aguarde.setLocationRelativeTo(null);
            this.setAlwaysOnTop(false);
            aguarde.setAlwaysOnTop(true);
            aguarde.setVisible(true);
            
            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    for(Produto produto: GerenciadorDeProduto.getInstance().getProdutosDisponiveisEntreDatas(dataInicial, dataFinal)) {
                        modeloTabelaProdutos.addRow(new Object[]{produto.getCodigo(), produto.getDescricao(), produto.getQuantidade()});
                        listaRowProdutos.add(new Object[]{produto.getCodigo(), produto.getDescricao(), produto.getQuantidade()});
                    }
                    return null;
                }

                @Override
                protected void done() {
                    aguarde.dispose();
                    setAlwaysOnTop(true);
                }
            }.execute();
                
        } catch(Exception e) {
            pane.setMessage("Informe as datas para a pesquisa dos produtos corretamente");
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            dialog = pane.createDialog("Aviso");
            dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_botaoBuscarActionPerformed

    public void calcularValorTotal() {
        try {
            valorTotalLocacao = valorGeral;
            if (GerenciadorDoSistema.getInstance().isTemporadaAtivada("LOCAÇÃO")) {
                valorTotalLocacao = valorTotalLocacao
                        - ((valorTotalLocacao * percentualDescontoTemporada) / 100);
            }

        } catch (Exception e) {
        }

        if (campoValorDesconto.getText().length() > 0) {
            valorTotalLocacao = valorTotalLocacao - Double.parseDouble(campoValorDesconto.getText());
        }
        valorTotalComDescontos = valorTotalLocacao;
        if (campoEntrada.getText().length() > 0) {
            valorTotalLocacao -= Double.parseDouble(campoEntrada.getText());
        }
        valorTotalArredondado = new BigDecimal(valorTotalLocacao).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        labelValorLocacao.setText(NumberFormat.getCurrencyInstance().format(valorTotalArredondado));

        if (campoParcelas.getText().length() <= 0) {
            labelValorParcelas.setText("");

        } else {
            valorParcelasArredondado = new BigDecimal(valorTotalLocacao / Integer.parseInt(campoParcelas.getText())
                    ).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            labelValorParcelas.setText(" = " + campoParcelas.getText() + " X " + NumberFormat.getCurrencyInstance().format(valorParcelasArredondado));
        }
    }

    public void calcularValorTotalComDesconto() {
        double valor;
        if (campoValorDesconto.getText().length() > 0) {
            valor = new BigDecimal(valorTotalLocacao - ((valorTotalLocacao * Integer.parseInt(
                    campoValorDesconto.getText())) / 100)).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            labelValorLocacao.setText(NumberFormat.getCurrencyInstance().format(valor));
        } else {
            valor = new BigDecimal(valorTotalLocacao).doubleValue();
            labelValorLocacao.setText(NumberFormat.getCurrencyInstance().format(valor));
        }
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

    public void validarNumerosETamanho(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int maxCaracteres) {
        if (!numeros.contains(evt.getKeyChar() + "") || campo.getText().length() >= maxCaracteres) {// se o carácter que gerou o evento não estiver na lista 
            evt.consume();
        }
    }

    public void habilitarCampos() {
        labelEntrada.setVisible(true);
        labelParcelas.setVisible(true);
        campoEntrada.setVisible(true);
        campoParcelas.setVisible(true);
        if (produtosLocados.isEmpty()) {
            campoEntrada.setEnabled(false);
            campoParcelas.setEnabled(false);
        }
    }

    public void desabilitarCampos() {
        labelEntrada.setVisible(false);
        labelParcelas.setVisible(false);
        campoEntrada.setVisible(false);
        campoParcelas.setVisible(false);
        comboFormaPagamentoEntrada.setVisible(false);
    }

    public void habilitarRadios() {
        radioCredito.setSelected(false);
        radioDebito.setSelected(true);
        radioCredito.setVisible(true);
        radioDebito.setVisible(true);
    }

    public void desabilitarRadios() {
        radioCredito.setVisible(false);
        radioDebito.setVisible(false);
    }
    
    public void limparValores() {
        campoParcelas.setText("");
        campoEntrada.setText("");
        calcularValorTotal();
    }

    public boolean alterarDados() {
        concluirSelecionado = false;  //Marcamos que o salvar não foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible ap�s ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return concluirSelecionado;   //Retornamos true, se ele pressionou concluir
    }

    public void adicionarProdutoALocacao(Produto produto) {
        ProdutoLocado produtoLocado = getProdutoLocado(produto.getCodigo());
        if (produtoLocado != null) {
            if (getProdutoEmEstoque(produto.getCodigo()).getQuantidade() > 0) {
                //Atualiza a quantidade do produto na locação
                produtoLocado.setQuantidade(produtoLocado.getQuantidade() + 1);
                //Atualiza a linha da tabela (2 = terceira coluna da tabela)
                for (int i = 0; i < modeloTabelaProdutosLocados.getRowCount(); i++) {
                    if (modeloTabelaProdutosLocados.getValueAt(i, 0).equals(produto.getCodigo())) {
                        modeloTabelaProdutosLocados.setValueAt(produtoLocado.getQuantidade(), i, 2);
                        //Atualiza a quantidade de produtos em estoque
                        removerProdutoDoEstoque(tabelaProdutos.getSelectedRow(), produto.getCodigo());

                        //Atualiza o valor total da locação
                        //valorTotalLocacao += produto.getValor();
                        valorGeral += produto.getValor(); //TESTAR
                    }
                }
            } else {
                pane.setMessage("Este produto não pode ser locado! \n\nQuantidade de produtos insuficiente no estoque");
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        } else {
            if (getProdutoEmEstoque(produto.getCodigo()).getQuantidade() > 0) {
                ProdutoLocado novoProdutoLocado = new ProdutoLocado(produto.getCodigo(), 1); //trocar para receber quant, código
                produtosLocados.add(novoProdutoLocado);
                //Adiciona os dados do novo produto na tabela
                modeloTabelaProdutosLocados.addRow(new Object[]{produto.getCodigo(), produto.getDescricao(), novoProdutoLocado.getQuantidade()});
                //Atualiza a quantidade de produtos em estoque
                removerProdutoDoEstoque(tabelaProdutos.getSelectedRow(), produto.getCodigo());

                //Atualiza o valor total da locação
                //valorTotalLocacao += produto.getValor();
                valorGeral += produto.getValor(); //TESTAR
            } else {
                pane.setMessage("Este produto não pode ser locado! \n\nQuantidade de produtos insuficiente no estoque");
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }

    }

    public void removerProdutoDaLocacao(int linhaSelecionada, String codigo) {
        ProdutoLocado produtoLocado = getProdutoLocado(codigo);
        if (produtoLocado != null) {
            //Decrementa o valor da quantidade de produtos que está no map, caso a chave já exista
            int quantidade = produtoLocado.getQuantidade() - 1;
            //Remove o produto selecionada da lista de locação
            if (quantidade == 0) {
                modeloTabelaProdutosLocados.removeRow(linhaSelecionada);
                produtosLocados.remove(produtoLocado);
            } else {
                //Atualiza o valor da coluna de quantidade (segunda coluna) da tabela de produtos locados
                modeloTabelaProdutosLocados.setValueAt(quantidade + "", linhaSelecionada, 2);
            }
            //Atualiza a quantidade do produto no estoque
            adicionarProdutoAoEstoque(codigo);
            //Atualiza a quantidade no produto referente
            produtoLocado.setQuantidade(quantidade);

            try {
                //Atualiza o valor total da locação
                //valorTotalLocacao -= GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(codigo).getValor();

                valorGeral -= GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(codigo).getValor(); 

            } catch (ProdutoInexistenteException e) {
                pane.setMessage(e.getMessage());
                pane.setMessageType(JOptionPane.WARNING_MESSAGE);
                dialog = pane.createDialog("Aviso");
                dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        } else {
            pane.setMessage("O produto não foi encontrado");
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            dialog = pane.createDialog("Aviso");
            dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }

    }

    public ProdutoLocado getProdutoLocado(String codigo) {
        for (ProdutoLocado produto : this.produtosLocados) {
            if (produto.getCodigoProduto().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    public void removerProdutoDoEstoque(int linhaSelecionada, String codigo) {
        int quantProdutoEmEstoque = ((Integer) modeloTabelaProdutos.getValueAt(linhaSelecionada, 2)) - 1;
        modeloTabelaProdutos.setValueAt(quantProdutoEmEstoque, linhaSelecionada, 2);
        //Atualiza a quantidade do produto na lista de produtos em estoque
        getProdutoEmEstoque(codigo).setQuantidade(quantProdutoEmEstoque);
    }

    public void adicionarProdutoAoEstoque(String codigo) {
        boolean atualizou = false;

        Produto produtoEmEstoque = getProdutoEmEstoque(codigo);

        //Atualiza a quantidade em estoque do produto
        produtoEmEstoque.setQuantidade(produtoEmEstoque.getQuantidade() + 1);

        for (int i = 0; i < modeloTabelaProdutos.getRowCount(); i++) {
            if (modeloTabelaProdutos.getValueAt(i, 0).equals(codigo)) {
                //Atualiza a linha da tabela (2 = coluna de quantidade da tabela)
                modeloTabelaProdutos.setValueAt(produtoEmEstoque.getQuantidade(), i, 2);
                atualizou = true;
                break;
            }
        }

        if (!atualizou) {
            pane.setMessage("Não foi possível atualizar a quantidade em estoque do produto");
            pane.setMessageType(JOptionPane.WARNING_MESSAGE);
            dialog = pane.createDialog("Aviso");
            dialog.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }

    public Produto getProdutoEmEstoque(String codigo) {
        for (Produto produto : this.produtosEmEstoque) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }
    
    public void zerarValores() {
        //Limpa a lista e a tabela dos produtos locados
        modeloTabelaProdutosLocados.setRowCount(0);
        produtosLocados.clear();
        valorGeral = 0;
        
        campoParcelas.setText("");
        campoEntrada.setText("");
        campoValorDesconto.setText("");
        labelValorLocacao.setText("");
        labelValorParcelas.setText("");
    }

    public Locacao getNovaLocacao() {
        return novaLocacao;
    }

    public Movimentacao getNovaMovimentacao() {
        return novaMovimentacao;
    }

    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresDesconto = 7;
    private int maxCaracteresParcelas = 2;
    private Cliente locador;
    private ArrayList<ProdutoLocado> produtosLocados;
    private List<Produto> produtosEmEstoque;
    private double valorTotalLocacao;
    private double valorGeral;
    protected boolean concluirSelecionado;
    protected Locacao novaLocacao;
    private Movimentacao novaMovimentacao;
    private DefaultTableModel modeloTabelaProdutos;
    private DefaultTableModel modeloTabelaProdutosLocados;
    private JOptionPane pane;
    private JDialog dialog;
    private int maxParcelas = 6;
    private int maxCaracteresEntrada = 7;
    private int percentualDescontoTemporada;
    private double valorTotalComDescontos;
    private final AguardeDialog aguarde = new AguardeDialog(null);
    private String formaPagamento = "";
    private String formaPagamentoEntrada = "";
    private double valorTotalArredondado;
    private double valorParcelasArredondado;
    private List<Object[]> listaRowProdutos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConcluir;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoSelecionarCliente;
    private javax.swing.JButton botaoSelecionarProdutos;
    private javax.swing.JTextField campoEntrada;
    private javax.swing.JTextField campoParcelas;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JTextField campoValorDesconto;
    private javax.swing.JComboBox comboFormaPagamentoEntrada;
    private com.toedter.calendar.JDateChooser dateDataFinalContrato;
    private com.toedter.calendar.JDateChooser dateDataInicialContrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelDataFinal;
    private javax.swing.JLabel labelDataInicial;
    private javax.swing.JLabel labelDesconto;
    private javax.swing.JLabel labelEntrada;
    private javax.swing.JLabel labelMensagemContrato;
    private javax.swing.JLabel labelNomeCliente;
    private javax.swing.JLabel labelParcelas;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelStatusTemporada;
    private javax.swing.JLabel labelValorLocacao;
    private javax.swing.JLabel labelValorParcelas;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JPanel painelContrato;
    private javax.swing.JPanel painelFormaPagamento;
    private javax.swing.JPanel painelLocador;
    private javax.swing.JPanel painelProdutos;
    private javax.swing.JPanel painelSelecionar;
    private javax.swing.JRadioButton radioAVista;
    private javax.swing.JRadioButton radioCartao;
    private javax.swing.JRadioButton radioCredito;
    private javax.swing.JRadioButton radioDebito;
    private javax.swing.JRadioButton radioPromissoria;
    private javax.swing.JScrollPane scPnProdutos;
    private javax.swing.JScrollPane scPnTabelaProdutosLocados;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTable tabelaProdutosLocados;
    // End of variables declaration//GEN-END:variables

}
