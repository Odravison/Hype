/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDeProduto;
import br.oltecnologias.hype.controller.GerenciadorDeVenda;
import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.exception.TemporadaInexistenteException;
import br.oltecnologias.hype.model.Configuracao;
import br.oltecnologias.hype.model.Movimentacao;
import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.ProdutoVendido;
import br.oltecnologias.hype.model.Venda;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luender Lima
 */
public class RealizarVendaDialog extends java.awt.Dialog {

    public RealizarVendaDialog(Frame owner) {
        super(owner);
        initComponents();
        valorGeral = 0;
        valorTotalComDescontos = 0;
        produtosVendidos = new ArrayList<ProdutoVendido>();
        produtosEmEstoque = GerenciadorDeProduto.getInstance().getProdutosDeVenda();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
        botaoConcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Salvar.png")));
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Cancelar.png")));
        try {
            percentualDescontoTemporada = GerenciadorDoSistema.getInstance().getPercentualDescontoTemporada("VENDA");
        } catch (TemporadaInexistenteException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o valor da temporada de desconto\n" + e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelSelecionar = new javax.swing.JPanel();
        botaoSelecionarProdutos = new javax.swing.JButton();
        campoPesquisar = new javax.swing.JTextField();
        botaoBuscar = new javax.swing.JButton();
        labelPesquisar = new javax.swing.JLabel();
        scPnTabelaProdutos = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        painelProdutos = new javax.swing.JPanel();
        botaoRemover = new javax.swing.JButton();
        scPnTabelaProdutosLocados = new javax.swing.JScrollPane();
        tabelaProdutosVendidos = new javax.swing.JTable();
        painelFormaPagamento = new javax.swing.JPanel();
        radioAVista = new javax.swing.JRadioButton();
        radioCartao = new javax.swing.JRadioButton();
        labelEntrada = new javax.swing.JLabel();
        campoEntrada = new javax.swing.JTextField();
        labelParcelas = new javax.swing.JLabel();
        campoParcelas = new javax.swing.JTextField();
        radioCredito = new javax.swing.JRadioButton();
        radioDebito = new javax.swing.JRadioButton();
        botaoCancelar = new javax.swing.JButton();
        botaoConcluir = new javax.swing.JButton();
        labelValorTotal = new javax.swing.JLabel();
        labelValorVenda = new javax.swing.JLabel();
        campoPercentualDesconto = new javax.swing.JTextField();
        labelDesconto = new javax.swing.JLabel();
        labelSimboloPorcentagem = new javax.swing.JLabel();
        labelValorParcelas = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        labelStatusTemporada = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(885, 730));
        setResizable(false);
        setTitle("Realizar Venda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelSelecionar.setBackground(new java.awt.Color(255, 255, 255));
        painelSelecionar.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecionar Produtos"));
        painelSelecionar.setPreferredSize(new java.awt.Dimension(564, 238));
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
        campoPesquisar.setToolTipText("Pesquise o produto pelo nome");
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

        labelPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPesquisar.setText("Pesquisar:");

        tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Define a fonte do cabeçalho da tabela de produtos
        tabelaProdutos.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 14));
        // Altura das linhas
        tabelaProdutos.setRowHeight(20);

        String[] nomesColunasTabelaProdutos = {"Código", "Descrição", "Qtd"};
        //Essa lista terá as linhas da tabela
        List<Object[]> listaLinhasProdutos = new ArrayList<>();

        //Adicionando valores nas linhas
        for (Produto produto : GerenciadorDeProduto.getInstance().getProdutosDeVenda()) {
            listaLinhasProdutos.add(new Object[]{produto.getCodigo(), produto.getDescricao(), produto.getQuantidade()});
        }
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
        tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(45);
        // Redimensionando a largura da coluna de descrição
        tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(487);
        // Redimensionando a largura da coluna de finalidade
        tabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(20);
        tabelaProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        scPnTabelaProdutos.setViewportView(tabelaProdutos);

        javax.swing.GroupLayout painelSelecionarLayout = new javax.swing.GroupLayout(painelSelecionar);
        painelSelecionar.setLayout(painelSelecionarLayout);
        painelSelecionarLayout.setHorizontalGroup(
            painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSelecionarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSelecionarLayout.createSequentialGroup()
                        .addComponent(labelPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPesquisar))
                    .addComponent(scPnTabelaProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(painelSelecionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoSelecionarProdutos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoBuscar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
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
                    .addGroup(painelSelecionarLayout.createSequentialGroup()
                        .addComponent(botaoSelecionarProdutos)
                        .addGap(0, 157, Short.MAX_VALUE))
                    .addComponent(scPnTabelaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelProdutos.setBackground(new java.awt.Color(255, 255, 255));
        painelProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos Vendidos"));
        painelProdutos.setPreferredSize(new java.awt.Dimension(572, 200));
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

        tabelaProdutosVendidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Define a fonte do cabeçalho da tabela de produtos
        tabelaProdutosVendidos.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 14));
        // Altura das linhas
        tabelaProdutosVendidos.setRowHeight(20);

        String[] nomesColunasTabelaProdutosVendidos = {"Código", "Descrição", "Qtd"};
        //Essa lista terá as linhas da tabela
        List<Object[]> listaLinhasProdutosVendidos = new ArrayList<>();

        //cria um defaultablemodel com as informações acima
        modeloTabelaProdutosVendidos = new DefaultTableModel(
            listaLinhasProdutosVendidos.toArray(new Object[listaLinhasProdutosVendidos.size()][]), nomesColunasTabelaProdutosVendidos){

            boolean[] canEdit = new boolean [] {false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit [columnIndex];
            }

        };

        //define o model da tabela
        tabelaProdutosVendidos.setModel(modeloTabelaProdutosVendidos);
        // Redimensionando a largura da coluna de código
        tabelaProdutosVendidos.getColumnModel().getColumn(0).setPreferredWidth(45);
        // Redimensionando a largura da coluna de descrição
        tabelaProdutosVendidos.getColumnModel().getColumn(1).setPreferredWidth(487);
        // Redimensionando a largura da coluna de finalidade
        tabelaProdutosVendidos.getColumnModel().getColumn(2).setPreferredWidth(20);
        tabelaProdutosVendidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaProdutosVendidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosVendidosMouseClicked(evt);
            }
        });
        scPnTabelaProdutosLocados.setViewportView(tabelaProdutosVendidos);

        javax.swing.GroupLayout painelProdutosLayout = new javax.swing.GroupLayout(painelProdutos);
        painelProdutos.setLayout(painelProdutosLayout);
        painelProdutosLayout.setHorizontalGroup(
            painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scPnTabelaProdutosLocados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoRemover)
                .addContainerGap())
        );
        painelProdutosLayout.setVerticalGroup(
            painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoRemover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelProdutosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scPnTabelaProdutosLocados, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        painelFormaPagamento.setBackground(new java.awt.Color(255, 255, 255));
        painelFormaPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma de Pagamento"));
        painelFormaPagamento.setPreferredSize(new java.awt.Dimension(336, 130));

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

        javax.swing.GroupLayout painelFormaPagamentoLayout = new javax.swing.GroupLayout(painelFormaPagamento);
        painelFormaPagamento.setLayout(painelFormaPagamentoLayout);
        painelFormaPagamentoLayout.setHorizontalGroup(
            painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormaPagamentoLayout.createSequentialGroup()
                .addGroup(painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFormaPagamentoLayout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(radioAVista)
                        .addGap(18, 18, 18)
                        .addComponent(radioCartao))
                    .addGroup(painelFormaPagamentoLayout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(radioCredito)
                        .addGap(77, 77, 77)
                        .addComponent(radioDebito))
                    .addGroup(painelFormaPagamentoLayout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(labelEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(labelParcelas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelFormaPagamentoLayout.setVerticalGroup(
            painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormaPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioAVista)
                    .addComponent(radioCartao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioCredito)
                    .addComponent(radioDebito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(painelFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEntrada)
                    .addComponent(campoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelParcelas)
                    .addComponent(campoParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        labelValorVenda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelValorVenda.setForeground(new java.awt.Color(0, 153, 0));

        campoPercentualDesconto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoPercentualDesconto.setEnabled(false);
        campoPercentualDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoPercentualDescontoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPercentualDescontoKeyTyped(evt);
            }
        });

        labelDesconto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelDesconto.setText("Desconto:");

        labelSimboloPorcentagem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelSimboloPorcentagem.setText("%");

        labelValorParcelas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelValorParcelas.setForeground(new java.awt.Color(0, 0, 102));

        labelStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelStatus.setText("Temporada de descontos");

        labelStatusTemporada.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        try {
            if(GerenciadorDoSistema.getInstance().isTemporadaAtivada("VENDA")) {
                labelStatusTemporada.setForeground(new java.awt.Color(0, 153, 0));
                labelStatusTemporada.setText("ON");
            } else {
                labelStatusTemporada.setText("OFF");
                labelStatusTemporada.setForeground(new java.awt.Color(255, 0, 0));
            }
        } catch(TemporadaInexistenteException e) {
            System.out.println("LANÇOU A EXCEÇÃO "+e.getMessage());
            labelStatusTemporada.setText("OFF");
            labelStatusTemporada.setForeground(new java.awt.Color(255, 0, 0));
        } catch (Exception e) {
            System.out.println("LANÇOU A EXCEÇÃO "+e.getMessage());
            labelStatusTemporada.setText("OFF");
            labelStatusTemporada.setForeground(new java.awt.Color(255, 0, 0));
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(painelFormaPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(painelProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(painelSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelValorParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelStatusTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelDesconto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoPercentualDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelSimboloPorcentagem)
                                .addGap(87, 87, 87)
                                .addComponent(botaoConcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoCancelar)))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoConcluir)
                        .addComponent(botaoCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(labelValorParcelas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelValorVenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoPercentualDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDesconto)
                            .addComponent(labelSimboloPorcentagem)
                            .addComponent(labelValorTotal))))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStatus)
                    .addComponent(labelStatusTemporada))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoSelecionarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarProdutosActionPerformed
        if (tabelaProdutos.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um produto na lista para poder adicioná-lo aos produtos vendidos", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                adicionarProdutoAVenda(GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(
                        (String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0)));

                calcularValorTotal();
                campoPercentualDesconto.setEnabled(true);
                campoParcelas.setEnabled(true);
                campoEntrada.setEnabled(true);
            } catch (ProdutoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoSelecionarProdutosActionPerformed

    private void campoPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarMouseClicked
        if (campoPesquisar.getText().equals("Pesquisar Produto")) {
            eliminarTextoDeCampo(campoPesquisar);
        }

    }//GEN-LAST:event_campoPesquisarMouseClicked

    private void campoPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarKeyTyped
        if (campoPesquisar.getText().equals("Pesquisar Produto")) {
            eliminarTextoDeCampo(campoPesquisar);
        }

    }//GEN-LAST:event_campoPesquisarKeyTyped

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarActionPerformed
        if (campoPesquisar.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "É preciso informar o nome ou o código do produto para a pesquisa", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            //Limpar o model dos produtos antes de acrescentar os objetos da pesquisa
            modeloTabelaProdutos.setRowCount(0);
            for (Produto produto : GerenciadorDeProduto.getInstance().pesquisarProdutosDeVendaPeloNome(campoPesquisar.getText())) {
                modeloTabelaProdutos.addRow(new Object[]{produto.getCodigo(), produto.getDescricao(), produto.getQuantidade()});
            }
        }
    }//GEN-LAST:event_botaoBuscarActionPerformed

    private void painelSelecionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelSelecionarMouseClicked
        if (campoPesquisar.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisar, "Pesquisar Produto");
        }
        //Se alguma linha da tabela estiver selecionada
        if (tabelaProdutos.getSelectedRow() >= 0) {
            tabelaProdutos.clearSelection();
        }
    }//GEN-LAST:event_painelSelecionarMouseClicked

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        if (tabelaProdutosVendidos.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para remoção", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            removerProdutoDaVenda(tabelaProdutosVendidos.getSelectedRow(), (String) tabelaProdutosVendidos.getValueAt(tabelaProdutosVendidos.getSelectedRow(), 0));
            calcularValorTotal();
            //calcularValorTotalVenda();
            campoPercentualDesconto.setEnabled(false);
            campoParcelas.setEnabled(false);
            campoEntrada.setEnabled(false);
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void painelProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelProdutosMouseClicked
        if (campoPesquisar.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisar, "Pesquisar Produto");
        }
        //Se alguma linha da tabela estiver selecionada
        if (tabelaProdutosVendidos.getSelectedRow() >= 0) {
            tabelaProdutosVendidos.clearSelection();
        }
    }//GEN-LAST:event_painelProdutosMouseClicked

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConcluirActionPerformed
        try {
            if (produtosVendidos.size() <= 0) {
                JOptionPane.showMessageDialog(null, "Selecione os produtos para a venda", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if (campoPercentualDesconto.getText().length() > 0 && Integer.parseInt(campoPercentualDesconto.getText()) > 100) {
                JOptionPane.showMessageDialog(null, "O percentual de desconto não pode estar acima de 100%", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if ((radioCartao.isSelected() && radioCredito.isSelected()) && campoParcelas.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a quantidade de parcelas da locação", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if (campoEntrada.getText().length() > 0 && Double.parseDouble(campoEntrada.getText()) < (valorTotalVenda / 2)) {
                JOptionPane.showMessageDialog(null, "O valor de entrada deve ser de, no mínimo, metade do valor total da compra", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                aguarde.setLocationRelativeTo(null);
                aguarde.setVisible(true);

                new SwingWorker() {
                    @Override
                    protected Object doInBackground() throws Exception {
                        String formaPagamento = "";
                        //Se o campo de desconto estiver em branco, a locação terá 0% de desconto
                        if (campoPercentualDesconto.getText().length() <= 0) {
                            campoPercentualDesconto.setText("0");
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
                        } else {
                            formaPagamento = "À Vista";
                            campoEntrada.setText("0");
                            campoParcelas.setText("0");
                        }

                        try {

                            novaVenda = GerenciadorDeVenda.getInstance().realizarVenda(new Venda(produtosVendidos, valorTotalComDescontos, formaPagamento,
                                    Calendar.getInstance(), Integer.parseInt(campoParcelas.getText()),
                                    Double.parseDouble(campoEntrada.getText()), Integer.parseInt(campoPercentualDesconto.getText())));

                            novaMovimentacao = GerenciadorDoSistema.getInstance().adicionarMovimentacaoDeVenda(novaVenda);

                            //O botão concluir foi selecionado
                            concluirSelecionado = true;

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                        }
                        
                        return null;
                    }

                    

                @Override
                    protected void done() {
                        aguarde.dispose();
                        JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso!");
                        //Fecha janela
                        setVisible(false);

                    }
                }.execute();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Informe corretamente todos os dados necessários", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_botaoConcluirActionPerformed

    private void campoPercentualDescontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPercentualDescontoKeyTyped
        if (!numeros.contains(evt.getKeyChar() + "") || campoPercentualDesconto.getText().length() >= maxCaracteresDesconto
                || Integer.parseInt(campoPercentualDesconto.getText() + evt.getKeyChar()) > 100
                || Integer.parseInt(campoPercentualDesconto.getText() + evt.getKeyChar()) == 0) {
            evt.consume();
        }
    }//GEN-LAST:event_campoPercentualDescontoKeyTyped

    private void radioAVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAVistaActionPerformed
        radioCartao.setSelected(false);
        desabilitarCampos();
        desabilitarRadios();
        limparValores();
    }//GEN-LAST:event_radioAVistaActionPerformed

    private void radioCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCartaoActionPerformed
        radioAVista.setSelected(false);
        habilitarRadios();
        desabilitarCampos();
        limparValores();
    }//GEN-LAST:event_radioCartaoActionPerformed

    private void radioCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCreditoActionPerformed
        radioDebito.setSelected(false);
        habilitarCampos();
    }//GEN-LAST:event_radioCreditoActionPerformed

    private void radioDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDebitoActionPerformed
        radioCredito.setSelected(false);
        desabilitarCampos();
    }//GEN-LAST:event_radioDebitoActionPerformed

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                adicionarProdutoAVenda(GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(
                        (String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0)));

                calcularValorTotal();
                campoPercentualDesconto.setEnabled(true);
                campoParcelas.setEnabled(true);
                campoEntrada.setEnabled(true);
            } catch (ProdutoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void tabelaProdutosVendidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosVendidosMouseClicked
        if (evt.getClickCount() == 2) {
            removerProdutoDaVenda(tabelaProdutosVendidos.getSelectedRow(), (String) tabelaProdutosVendidos.getValueAt(tabelaProdutosVendidos.getSelectedRow(), 0));
            calcularValorTotal();
        }
        if (produtosVendidos.size() <= 0) {
            campoPercentualDesconto.setEnabled(false);
            campoParcelas.setEnabled(false);
            campoEntrada.setEnabled(false);
            campoPercentualDesconto.setText("");
            labelValorVenda.setText("");
        }
    }//GEN-LAST:event_tabelaProdutosVendidosMouseClicked

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
        /*if ((numeros.contains(evt.getKeyChar() + "") && campoParcelas.getText().length() < maxCaracteresParcelas 
         && Integer.parseInt(campoParcelas.getText()) <= maxParcelas) || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
         || Integer.parseInt(campoParcelas.getText()) > 0) {
         try {
         //Se o usuário estiver apagando o conteúdo do campo
         if (campoParcelas.getText().length() <= 0) { 
         labelValorParcelas.setText("");

         } else {
         labelValorParcelas.setText(" = "+campoParcelas.getText()+" X R$ "+new BigDecimal(valorTotalVenda / Integer.parseInt(campoParcelas.getText())
         ).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
                            
         }
         } catch(Exception e) {
         JOptionPane.showMessageDialog(null, "Não foi possível realizar o cálculo do valor das parcelas da venda."+"\n"+e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
         }  
         }*/
    }//GEN-LAST:event_campoParcelasKeyReleased

    private void campoPercentualDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPercentualDescontoKeyReleased
        if ((numeros.contains(evt.getKeyChar() + "") && campoPercentualDesconto.getText().length() <= maxCaracteresDesconto
                && (Integer.parseInt(campoPercentualDesconto.getText()) <= 100 && Integer.parseInt(campoPercentualDesconto.getText()) > 0))
                || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
                || evt.getKeyCode() == KeyEvent.VK_DELETE) {

            calcularValorTotalComDesconto();
        }
        /*
         if ((numeros.contains(evt.getKeyChar() + "") && campoPercentualDesconto.getText().length() <= maxCaracteresDesconto
         && Integer.parseInt(campoPercentualDesconto.getText()) <= 100) || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
         || Integer.parseInt(campoParcelas.getText()) > 0) {
         try {
         //Se o usuário estiver apagando o conteúdo do campo
         if (campoPercentualDesconto.getText().length() > 0) {
         labelValorVenda.setText("R$ " + new BigDecimal(valorTotalVenda - ((valorTotalVenda * Integer.parseInt(
         campoPercentualDesconto.getText())) / 100)).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
   
         } else {
         labelValorVenda.setText("R$ " + valorTotalVenda);
         }
         } catch(Exception e) {
         JOptionPane.showMessageDialog(null, "Não foi possível realizar o cálculo do valor das parcelas da venda."+"\n"+e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
         }  
         } */
    }//GEN-LAST:event_campoPercentualDescontoKeyReleased

    private void campoEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEntradaKeyTyped
        //double metadeValor = valorTotal;
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

    public void calcularValorTotal() {
        try {
            valorTotalVenda = valorGeral;
            if (GerenciadorDoSistema.getInstance().isTemporadaAtivada("VENDA")) {
                valorTotalVenda = valorTotalVenda
                        - ((valorTotalVenda * percentualDescontoTemporada) / 100);
            }

        } catch (Exception e) {
        }

        if (campoPercentualDesconto.getText().length() > 0) {
            valorTotalVenda = valorTotalVenda - ((valorTotalVenda * Integer.parseInt(
                    campoPercentualDesconto.getText())) / 100);
        }
        valorTotalComDescontos = valorTotalVenda;
        if (campoEntrada.getText().length() > 0) {
            valorTotalVenda -= Double.parseDouble(campoEntrada.getText());
        }
        
        valorTotalArredondado = new BigDecimal(valorTotalVenda).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        labelValorVenda.setText(NumberFormat.getCurrencyInstance().format(valorTotalArredondado));

        if (campoParcelas.getText().length() <= 0) {
            labelValorParcelas.setText("");

        } else {
            valorParcelasArredondado = new BigDecimal(valorTotalVenda / Integer.parseInt(campoParcelas.getText())
                                                                            ).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            labelValorParcelas.setText(" = " + campoParcelas.getText() + " X " + NumberFormat.getCurrencyInstance().format(valorParcelasArredondado));

        }
    }

    public void calcularValorTotalComDesconto() {
        if (campoPercentualDesconto.getText().length() > 0) {
            labelValorVenda.setText("R$ " + new BigDecimal(valorTotalVenda - ((valorTotalVenda * Integer.parseInt(
                                        campoPercentualDesconto.getText())) / 100)).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
        } else {
            labelValorVenda.setText("R$ " + new BigDecimal(valorTotalVenda).doubleValue());
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
        if (!numeros.contains(evt.getKeyChar() + "")) {// se o carácter que gerou o evento não estiver na lista 
            evt.consume();
        }
        if (campo.getText().length() >= maxCaracteres) {
            evt.consume();
        }
    }

    public void habilitarCampos() {
        labelEntrada.setVisible(true);
        labelParcelas.setVisible(true);
        campoEntrada.setVisible(true);
        campoParcelas.setVisible(true);
        if (produtosVendidos.isEmpty()) {
            campoEntrada.setEnabled(false);
            campoParcelas.setEnabled(false);
        }
    }

    public void desabilitarCampos() {
        labelEntrada.setVisible(false);
        labelParcelas.setVisible(false);
        campoEntrada.setVisible(false);
        campoParcelas.setVisible(false);
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
        valorTotalVenda = valorGeral;
        calcularValorTotalComDesconto();
    }

    public void adicionarProdutoAVenda(Produto produto) {
        ProdutoVendido produtoVendido = getProdutoVendido(produto.getCodigo());
        if (produtoVendido != null) {
            if (getProdutoEmEstoque(produto.getCodigo()).getQuantidade() > 0) {
                //Atualiza a quantidade do produto na locação
                produtoVendido.setQuantidade(produtoVendido.getQuantidade() + 1);
                //Atualiza a linha da tabela (2 = terceira coluna da tabela)
                for (int i = 0; i < modeloTabelaProdutosVendidos.getRowCount(); i++) {
                    if (modeloTabelaProdutosVendidos.getValueAt(i, 0).equals(produto.getCodigo())) {
                        modeloTabelaProdutosVendidos.setValueAt(produtoVendido.getQuantidade(), i, 2);
                        //Atualiza a quantidade de produtos em estoque
                        removerProdutoDoEstoque(tabelaProdutos.getSelectedRow(), produto.getCodigo());

                        //Atualiza o valor total da Venda
                        //valorTotalVenda += produto.getValor();
                        valorGeral += produto.getValor();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este produto não pode ser vendido! \n\nQuantidade de produtos insuficiente no estoque", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (getProdutoEmEstoque(produto.getCodigo()).getQuantidade() > 0) {
                ProdutoVendido novoProdutoVendido = new ProdutoVendido(produto.getCodigo(), 1);
                produtosVendidos.add(novoProdutoVendido);
                //Adiciona os dados do novo produto na tabela
                modeloTabelaProdutosVendidos.addRow(new Object[]{produto.getCodigo(), produto.getDescricao(), novoProdutoVendido.getQuantidade()});
                //Atualiza a quantidade de produtos em estoque
                removerProdutoDoEstoque(tabelaProdutos.getSelectedRow(), produto.getCodigo());

                //Atualiza o valor total da locação
                valorGeral += produto.getValor();
            } else {
                JOptionPane.showMessageDialog(null, "Este produto não pode ser vendido! \n\nQuantidade de produtos insuficiente no estoque", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    public void removerProdutoDaVenda(int linhaSelecionada, String codigo) {
        ProdutoVendido produtoVendido = getProdutoVendido(codigo);
        if (produtoVendido != null) {
            //Decrementa o valor da quantidade de produtos que está no map, caso a chave já exista
            int quantidade = produtoVendido.getQuantidade() - 1;
            //Remove o produto selecionada da lista de locação
            if (quantidade <= 0) {
                modeloTabelaProdutosVendidos.removeRow(linhaSelecionada);
                //Remove o produto da lista de produtos vendidos
                produtosVendidos.remove(produtoVendido);
            } else {
                //Atualiza o valor da coluna de quantidade (segunda coluna) da tabela de produtos locados
                modeloTabelaProdutosVendidos.setValueAt(quantidade + "", linhaSelecionada, 2);
            }
            //Atualiza a quantidade do produto no estoque
            adicionarProdutoAoEstoque(codigo);
            //Atualiza a quantidade no produto referente
            produtoVendido.setQuantidade(quantidade);

            try {
                //Atualiza o valor total da venda
                valorGeral -= GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(codigo).getValor();
            } catch (ProdutoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "O produto não foi encontrado", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

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
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar a quantidade em estoque do produto", "Aviso", JOptionPane.WARNING_MESSAGE);
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

    public ProdutoVendido getProdutoVendido(String codigo) {
        for (ProdutoVendido produto : this.produtosVendidos) {
            if (produto.getCodigoProduto().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    public void calcularValorTotalVenda() {
        /*try {
         if (GerenciadorDoSistema.getInstance().isTemporadaAtivada("VENDA")) {
         valorTotalVenda = new BigDecimal(valorTotalVenda
         - ((valorTotalVenda * GerenciadorDoSistema.getInstance().getPercentualDescontoTemporada("VENDA")) / 100)
         ).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
                
         labelValorVenda.setText("R$ " + valorTotalVenda);
                
         } else {
         valorTotalVenda = new BigDecimal(valorTotalVenda).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
         labelValorVenda.setText("R$ " + valorTotalVenda);
         }
         } catch (TemporadaInexistenteException e) {
         valorTotalVenda = new BigDecimal(valorTotalVenda).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
         labelValorVenda.setText("R$ " + valorTotalVenda);
         } catch (Exception e) {
         valorTotalVenda = new BigDecimal(valorTotalVenda).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
         labelValorVenda.setText("R$ " + valorTotalVenda);
         }*/
    }
    /*
     public void calcularValorTotalVendaComDesconto(int valorDesconto) {
     try {
     if (GerenciadorDoSistema.getInstance().isTemporadaAtivada("VENDA")) {
     double valorTotalComDescontoTemporada = valorTotalVenda
     - ((valorTotalVenda * GerenciadorDoSistema.getInstance().getPercentualDescontoTemporada("VENDA")) / 100);
                
     valorTotalVenda = new BigDecimal(valorTotalComDescontoTemporada 
     - ((valorTotalComDescontoTemporada * valorDesconto)/100)).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
                
     labelValorVenda.setText("R$ " + valorTotalVenda);
     } 
     } catch (TemporadaInexistenteException e) {
     //Se a temporada não existir, o cálculo será feito apenas com o desconto dado
     valorTotalVenda = new BigDecimal(valorTotalVenda
     - ((valorTotalVenda * valorDesconto) / 100)).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
     labelValorVenda.setText("R$ " + valorTotalVenda);
     }
     }*/

    public boolean alterarDados() {
        concluirSelecionado = false;  //Marcamos que o salavar não foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible ap�s ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return concluirSelecionado;   //Retornamos true, se ele pressionou ok.
    }

    public Venda getNovaVenda() {
        return novaVenda;
    }

    public Movimentacao getNovaMovimentacao() {
        return novaMovimentacao;
    }

    private DefaultListModel modeloProdutosVendidos;
    private DefaultListModel modeloProdutos;
    private List<ProdutoVendido> produtosVendidos;
    private List<Produto> produtosEmEstoque;
    protected boolean concluirSelecionado;
    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresDesconto = 3;
    private int maxCaracteresParcelas = 2;
    protected Venda novaVenda;
    private double valorTotalVenda;
    protected Movimentacao novaMovimentacao;
    private DefaultTableModel modeloTabelaProdutos;
    private DefaultTableModel modeloTabelaProdutosVendidos;
    private int maxParcelas = 6;
    private double valorGeral;
    private int percentualDescontoTemporada;
    private int maxCaracteresEntrada = 7;
    private double valorTotalComDescontos;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("0.00");
    private final AguardeDialog aguarde = new AguardeDialog(null);
    private double valorTotalArredondado;
    private double valorParcelasArredondado;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConcluir;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoSelecionarProdutos;
    private javax.swing.JTextField campoEntrada;
    private javax.swing.JTextField campoParcelas;
    private javax.swing.JTextField campoPercentualDesconto;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JLabel labelDesconto;
    private javax.swing.JLabel labelEntrada;
    private javax.swing.JLabel labelParcelas;
    private javax.swing.JLabel labelPesquisar;
    private javax.swing.JLabel labelSimboloPorcentagem;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelStatusTemporada;
    private javax.swing.JLabel labelValorParcelas;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JLabel labelValorVenda;
    private javax.swing.JPanel painelFormaPagamento;
    private javax.swing.JPanel painelProdutos;
    private javax.swing.JPanel painelSelecionar;
    private javax.swing.JRadioButton radioAVista;
    private javax.swing.JRadioButton radioCartao;
    private javax.swing.JRadioButton radioCredito;
    private javax.swing.JRadioButton radioDebito;
    private javax.swing.JScrollPane scPnTabelaProdutos;
    private javax.swing.JScrollPane scPnTabelaProdutosLocados;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTable tabelaProdutosVendidos;
    // End of variables declaration//GEN-END:variables
}
