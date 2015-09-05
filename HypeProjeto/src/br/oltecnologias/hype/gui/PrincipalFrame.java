/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDeLocacao;
import br.oltecnologias.hype.controller.GerenciadorDePessoas;
import br.oltecnologias.hype.controller.GerenciadorDeProduto;
import br.oltecnologias.hype.controller.GerenciadorDeVenda;
import br.oltecnologias.hype.controller.GerenciadorDoSistema;
import br.oltecnologias.hype.exception.ClienteInexistenteException;
import br.oltecnologias.hype.exception.DespesaInexistenteException;
import br.oltecnologias.hype.exception.FornecedorInexistenteException;
import br.oltecnologias.hype.exception.LocacaoInexistenteException;
import br.oltecnologias.hype.exception.MovimentacaoInexistenteException;
import br.oltecnologias.hype.exception.ProdutoInexistenteException;
import br.oltecnologias.hype.exception.UsuarioInexistenteException;
import br.oltecnologias.hype.exception.VendaInexistenteException;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Configuracao;
import br.oltecnologias.hype.model.Fornecedor;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Movimentacao;
import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.Usuario;
import br.oltecnologias.hype.model.Venda;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luender Lima
 */
public class PrincipalFrame extends javax.swing.JFrame {

    private String loginUsuario;

    /**
     * Cria um novo form PrincipalFrame
     */
    public PrincipalFrame(String login) {
        loginUsuario = login;
        initComponents();
        
        //labelLogoSistema.setIcon(new ImageIcon("Imagens\\.png"));
    }

    /**
     * Cria um novo form PrincipalFrame
     */
    public PrincipalFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelGeral = new javax.swing.JPanel();
        painelTopo = new javax.swing.JPanel();
        labelLogoEmpresa = new javax.swing.JLabel();
        labelLoginUsuario = new javax.swing.JLabel();
        botaoSair = new javax.swing.JLabel();
        abas = new javax.swing.JTabbedPane();
        painelClientes = new javax.swing.JPanel();
        botaoNovoCliente = new javax.swing.JButton();
        botaoPesquisarCliente = new javax.swing.JButton();
        campoPesquisarCliente = new javax.swing.JTextField();
        comboFiltrarCliente = new javax.swing.JComboBox();
        pnRlCliente = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        labelFiltrarClientes = new javax.swing.JLabel();
        botaoEditarCliente = new javax.swing.JButton();
        botaoExcluirCliente = new javax.swing.JButton();
        botaoVerLocacoesCliente = new javax.swing.JButton();
        painelProdutos = new javax.swing.JPanel();
        botaoNovoProduto = new javax.swing.JButton();
        botaoPesquisarProduto = new javax.swing.JButton();
        campoPesquisarProduto = new javax.swing.JTextField();
        pnRlProduto = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        labelFiltrarProdutos = new javax.swing.JLabel();
        comboBoxOrdenarProdutos = new javax.swing.JComboBox();
        botaoEditarProduto = new javax.swing.JButton();
        botaoExcluirProduto = new javax.swing.JButton();
        painelFornecedores = new javax.swing.JPanel();
        botaoNovoFornecedor = new javax.swing.JButton();
        botaoPesquisarFornecedor = new javax.swing.JButton();
        campoPesquisarFornecedor = new javax.swing.JTextField();
        pnRlFornecedores = new javax.swing.JScrollPane();
        tabelaFornecedores = new javax.swing.JTable();
        labelFiltrarFornecedores = new javax.swing.JLabel();
        comboBoxOrdenarFornecedores = new javax.swing.JComboBox();
        botaoEditarFornecedor = new javax.swing.JButton();
        botaoExcluirFornecedor = new javax.swing.JButton();
        painelLocacoes = new javax.swing.JPanel();
        botaoNovaLocacao = new javax.swing.JButton();
        botaoPesquisarLocacao = new javax.swing.JButton();
        campoPesquisarLocacao = new javax.swing.JTextField();
        pnRlLocacoes = new javax.swing.JScrollPane();
        tabelaLocacoes = new javax.swing.JTable();
        labelFiltrarLocacoes = new javax.swing.JLabel();
        comboBoxOrdenarFornecedores1 = new javax.swing.JComboBox();
        botaoVerContrato = new javax.swing.JButton();
        botaoFinalizarLocacao = new javax.swing.JButton();
        botaoGerarReciboLocacao = new javax.swing.JButton();
        botaoVerRecibosLocacao = new javax.swing.JButton();
        painelVendas = new javax.swing.JPanel();
        botaoNovaVenda = new javax.swing.JButton();
        botaoPesquisarFornecedor1 = new javax.swing.JButton();
        campoPesquisarVenda = new javax.swing.JTextField();
        comboBoxOrdenarCliente1 = new javax.swing.JComboBox();
        pnRlVendas = new javax.swing.JScrollPane();
        tabelaVendas = new javax.swing.JTable();
        labelFiltrarVenda = new javax.swing.JLabel();
        botaoExcluirVenda = new javax.swing.JButton();
        botaoVerRecibosVenda = new javax.swing.JButton();
        botaoGerarReciboVenda = new javax.swing.JButton();
        painelCaixaERelatorios = new javax.swing.JPanel();
        botaoGerarRelatorio = new javax.swing.JButton();
        botaoFecharCaixa = new javax.swing.JButton();
        pnRlCaixaERelatorios = new javax.swing.JScrollPane();
        tabelaMovimentacoes = new javax.swing.JTable();
        labelFiltrarMovimentacao = new javax.swing.JLabel();
        labelValorCaixa = new javax.swing.JLabel();
        comboBoxOrdenarCaixaEMovimentacao = new javax.swing.JComboBox();
        botaoExcluirDespesa = new javax.swing.JButton();
        labelValorEmCaixa = new javax.swing.JLabel();
        botaoEditarDespesa = new javax.swing.JButton();
        painelConfiguracoes = new javax.swing.JPanel();
        botaoSalvarDiretorioBackup = new javax.swing.JButton();
        campoDiretorioBackup = new javax.swing.JTextField();
        labelDiretorioBackups = new javax.swing.JLabel();
        botaoSalvarDiretorioDocumentos = new javax.swing.JButton();
        campoDiretorioDocumentos = new javax.swing.JTextField();
        labelDiretorioDocumentos = new javax.swing.JLabel();
        botaoAlterarDiretorioBackup = new javax.swing.JButton();
        botaoAlterarDiretorioDocumentos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botaoAlterarDiretorioRelatorios = new javax.swing.JButton();
        botaoSalvarDiretorioRelatorios = new javax.swing.JButton();
        campoDiretorioRelatorios = new javax.swing.JTextField();
        painelAdministrador = new javax.swing.JPanel();
        botaoNovoUsuario = new javax.swing.JButton();
        botaoPesquisarUsuario = new javax.swing.JButton();
        campoPesquisarUsuario = new javax.swing.JTextField();
        pnRlUsuario = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        labelFiltrarUsuario = new javax.swing.JLabel();
        comboBoxUsuario = new javax.swing.JComboBox();
        botaoAtivarTemporada = new javax.swing.JButton();
        botaoExcluirUsuario = new javax.swing.JButton();
        botaoEditarUsuario = new javax.swing.JButton();
        botaoRegistrarDespesa = new javax.swing.JButton();
        botaoEditarEmpresa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Closet");
        setPreferredSize(new java.awt.Dimension(1366, 731));
        setResizable(false);

        painelGeral.setBackground(new java.awt.Color(255, 255, 255));
        painelGeral.setPreferredSize(new java.awt.Dimension(1366, 725));

        painelTopo.setBackground(new java.awt.Color(255, 255, 255));

        labelLogoEmpresa.setIcon(new ImageIcon("Imagens\\Mini Logo Empresa.png"));
        labelLogoEmpresa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        labelLoginUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelLoginUsuario.setText("Logado com "+loginUsuario);

        botaoSair.setIcon(new ImageIcon("Imagens\\Sair do sistema.png"));
        botaoSair.setToolTipText("Sair do Sistema");
        botaoSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoSairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTopoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelLogoEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelLoginUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSair)
                .addGap(16, 16, 16))
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTopoLayout.createSequentialGroup()
                .addComponent(labelLogoEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addGap(8, 8, 8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTopoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLoginUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoSair, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        abas.setBackground(new java.awt.Color(255, 255, 255));
        abas.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(153, 153, 153)));
        abas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        abas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        abas.setPreferredSize(new java.awt.Dimension(1346, 700));

        painelClientes.setBackground(new java.awt.Color(255, 255, 255));
        painelClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelClientes.setPreferredSize(new java.awt.Dimension(1311, 735));
        painelClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelClientesMouseClicked(evt);
            }
        });

        botaoNovoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoNovoCliente.setText("Novo Cliente");
        botaoNovoCliente.setToolTipText("Criar novo cliente");
        botaoNovoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoClienteActionPerformed(evt);
            }
        });

        botaoPesquisarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoPesquisarCliente.setText("Pesquisar");
        botaoPesquisarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarClienteActionPerformed(evt);
            }
        });

        campoPesquisarCliente.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        campoPesquisarCliente.setForeground(new java.awt.Color(153, 153, 153));
        campoPesquisarCliente.setText("Pesquisar Cliente");
        campoPesquisarCliente.setToolTipText("Informe o nome do cliente");
        campoPesquisarCliente.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        campoPesquisarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoPesquisarClienteMouseClicked(evt);
            }
        });
        campoPesquisarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPesquisarClienteKeyTyped(evt);
            }
        });

        comboFiltrarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFiltrarCliente.setMaximumRowCount(3);
        comboFiltrarCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Últimos locatários", "Últimos cadastros" }));
        comboFiltrarCliente.setToolTipText("Selecionar tipo de filtro");
        comboFiltrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboFiltrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltrarClienteActionPerformed(evt);
            }
        });

        pnRlCliente.setBackground(new java.awt.Color(255, 255, 255));
        pnRlCliente.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnRlCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnRlCliente.setPreferredSize(new java.awt.Dimension(806, 359));

        tabelaClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelaClientes.getTableHeader().setResizingAllowed(false);
        tabelaClientes.getTableHeader().setReorderingAllowed(false);
        String[] nomesColunasTabelaClientes = {"CPF", "Nome do Cliente", "Contato", "Data do Cadastro"};
        //Define a fonte do cabeçalho da tabela clientes
        tabelaClientes.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 15));
        //Altura da linha
        tabelaClientes.setRowHeight(25);

        //Lista que terá as linhas da tabela
        List<Object[]> listaLinhas = new ArrayList<>();

        //Adicionando valores nas linhas
        for (Cliente cliente : GerenciadorDePessoas.getInstance().getClientes()) {
            listaLinhas.add(new Object[]{cliente.getCpf(), cliente.getNome(), cliente.getCelular(), cliente.getDataCadastroInString()});
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
        tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(140);
        // Redimensionando a largura da coluna de nome
        tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(380);
        // Redimensionando a largura da coluna de número do celular
        tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(150);
        // Redimensionando a largura da coluna de data de cadastro
        tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(130);
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        pnRlCliente.setViewportView(tabelaClientes);

        labelFiltrarClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelFiltrarClientes.setText("Filtrar por:");

        botaoEditarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoEditarCliente.setText("  Editar  ");
        botaoEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarClienteActionPerformed(evt);
            }
        });
        botaoEditarCliente.setVisible(false);

        botaoExcluirCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoExcluirCliente.setText("  Excluir  ");
        botaoExcluirCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirClienteActionPerformed(evt);
            }
        });
        botaoExcluirCliente.setVisible(false);

        botaoVerLocacoesCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoVerLocacoesCliente.setText("Locações Feitas");
        botaoVerLocacoesCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoVerLocacoesCliente.setVisible(false);
        botaoVerLocacoesCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVerLocacoesClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelClientesLayout = new javax.swing.GroupLayout(painelClientes);
        painelClientes.setLayout(painelClientesLayout);
        painelClientesLayout.setHorizontalGroup(
            painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClientesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoNovoCliente)
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addComponent(campoPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoPesquisarCliente))
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addComponent(labelFiltrarClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFiltrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(275, 275, 275)
                        .addComponent(botaoVerLocacoesCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoEditarCliente)
                        .addGap(4, 4, 4)
                        .addComponent(botaoExcluirCliente))
                    .addComponent(pnRlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(499, Short.MAX_VALUE))
        );
        painelClientesLayout.setVerticalGroup(
            painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClientesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(botaoNovoCliente)
                .addGap(50, 50, 50)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisarCliente))
                .addGap(37, 37, 37)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoEditarCliente)
                        .addComponent(botaoExcluirCliente)
                        .addComponent(botaoVerLocacoesCliente))
                    .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelFiltrarClientes)
                        .addComponent(comboFiltrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(pnRlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        abas.addTab("  Clientes  ", painelClientes);

        painelProdutos.setBackground(new java.awt.Color(255, 255, 255));
        painelProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelProdutosMouseClicked(evt);
            }
        });

        botaoNovoProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoNovoProduto.setText("Novo Produto");
        botaoNovoProduto.setToolTipText("Criar novo produto");
        botaoNovoProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoProdutoActionPerformed(evt);
            }
        });

        botaoPesquisarProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoPesquisarProduto.setText("Pesquisar");
        botaoPesquisarProduto.setToolTipText("Pesquisar produtos em estoque");
        botaoPesquisarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        campoPesquisarProduto.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        campoPesquisarProduto.setForeground(new java.awt.Color(153, 153, 153));
        campoPesquisarProduto.setText("Pesquisar Produto");
        campoPesquisarProduto.setToolTipText("Informe o nome do produto");
        campoPesquisarProduto.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        campoPesquisarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoPesquisarProdutoMouseClicked(evt);
            }
        });
        campoPesquisarProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPesquisarProdutoKeyTyped(evt);
            }
        });

        pnRlProduto.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnRlProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnRlProduto.setPreferredSize(new java.awt.Dimension(1176, 359));

        tabelaProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelaProdutos.getTableHeader().setResizingAllowed(false);
        tabelaProdutos.getTableHeader().setReorderingAllowed(false);
        //Define a fonte do cabeçalho da tabela de produtos
        tabelaProdutos.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 15));

        tabelaProdutos.setRowHeight(25); // Altura das linhas

        String[] nomesColunasTabelaProdutos = {"Código", "Descrição do Produto", "Valor", "Quantidade", "Finalidade"};
        //Essa lista terá as linhas da tabela
        List<Object[]> listaLinhasProdutos = new ArrayList<>();

        //Adicionando valores nas linhas
        for (Produto produto : GerenciadorDeProduto.getInstance().getProdutos()) {
            listaLinhasProdutos.add(new Object[]{produto.getCodigo(), produto.getDescricao(), "R$ "+produto.getValorInString(),
                produto.getQuantidade(), produto.getFinalidade()});
    }
    //cria um defaultablemodel com as informações acima
    modeloTabelaProdutos = new DefaultTableModel(
        listaLinhasProdutos.toArray(new Object[listaLinhasProdutos.size()][]), nomesColunasTabelaProdutos){

        boolean[] canEdit = new boolean [] {false, false, false, false, false};

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
        }

    };

    //define o model da tabela
    tabelaProdutos.setModel(modeloTabelaProdutos);
    // Redimensionando a largura da coluna de código
    tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(130);
    // Redimensionando a largura da coluna de descrição
    tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(710);
    // Redimensionando a largura da coluna de finalidade
    tabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(110);
    // Redimensionando a largura da coluna de quantidade em estoque
    tabelaProdutos.getColumnModel().getColumn(3).setPreferredWidth(110);
    // Redimensionando a largura da coluna de finalidade
    tabelaProdutos.getColumnModel().getColumn(4).setPreferredWidth(110);
    tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaProdutosMouseClicked(evt);
        }
    });
    pnRlProduto.setViewportView(tabelaProdutos);

    labelFiltrarProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelFiltrarProdutos.setText("Filtrar por:");

    comboBoxOrdenarProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comboBoxOrdenarProdutos.setMaximumRowCount(5);
    comboBoxOrdenarProdutos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Em estoque", "Produtos de locação", "Produtos de venda", "Últimos locados", "Últimos cadastros" }));
    comboBoxOrdenarProdutos.setToolTipText("Selecionar tipo de filtro");
    comboBoxOrdenarProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    botaoEditarProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoEditarProduto.setText("   Editar   ");
    botaoEditarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoEditarProduto.setVisible(false);
    botaoEditarProduto.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoEditarProdutoActionPerformed(evt);
        }
    });

    botaoExcluirProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoExcluirProduto.setText("   Excluir   ");
    botaoExcluirProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoExcluirProduto.setVisible(false);
    botaoExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoExcluirProdutoActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout painelProdutosLayout = new javax.swing.GroupLayout(painelProdutos);
    painelProdutos.setLayout(painelProdutosLayout);
    painelProdutosLayout.setHorizontalGroup(
        painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelProdutosLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoNovoProduto)
                .addGroup(painelProdutosLayout.createSequentialGroup()
                    .addComponent(campoPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(botaoPesquisarProduto))
                .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelProdutosLayout.createSequentialGroup()
                        .addComponent(labelFiltrarProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxOrdenarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoEditarProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluirProduto))
                    .addComponent(pnRlProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(129, Short.MAX_VALUE))
    );
    painelProdutosLayout.setVerticalGroup(
        painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelProdutosLayout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(botaoNovoProduto)
            .addGap(50, 50, 50)
            .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoPesquisarProduto))
            .addGap(40, 40, 40)
            .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelFiltrarProdutos)
                .addComponent(comboBoxOrdenarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoEditarProduto)
                .addComponent(botaoExcluirProduto))
            .addGap(18, 18, 18)
            .addComponent(pnRlProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    abas.addTab("  Produtos  ", painelProdutos);

    painelFornecedores.setBackground(new java.awt.Color(255, 255, 255));
    painelFornecedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    painelFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            painelFornecedoresMouseClicked(evt);
        }
    });

    botaoNovoFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoNovoFornecedor.setText("Novo Fornecedor");
    botaoNovoFornecedor.setToolTipText("Criar novo fornecedor");
    botaoNovoFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoNovoFornecedor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoNovoFornecedorActionPerformed(evt);
        }
    });

    botaoPesquisarFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoPesquisarFornecedor.setText("Pesquisar");
    botaoPesquisarFornecedor.setToolTipText("Pesquisar fornecedores cadastrados");
    botaoPesquisarFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    campoPesquisarFornecedor.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
    campoPesquisarFornecedor.setForeground(new java.awt.Color(153, 153, 153));
    campoPesquisarFornecedor.setText("Pesquisar Fornecedor");
    campoPesquisarFornecedor.setToolTipText("Informe o nome do fornecedor");
    campoPesquisarFornecedor.setDisabledTextColor(new java.awt.Color(204, 204, 204));
    campoPesquisarFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            campoPesquisarFornecedorMouseClicked(evt);
        }
    });
    campoPesquisarFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            campoPesquisarFornecedorKeyTyped(evt);
        }
    });

    pnRlFornecedores.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    pnRlFornecedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    pnRlFornecedores.setPreferredSize(new java.awt.Dimension(1130, 359));

    tabelaFornecedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabelaFornecedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tabelaFornecedores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    tabelaFornecedores.getTableHeader().setResizingAllowed(false);
    tabelaFornecedores.getTableHeader().setReorderingAllowed(false);
    //Define a fonte do cabeçalho da tabela fornecedores
    tabelaFornecedores.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 15));

    tabelaFornecedores.setRowHeight(25); // Altura das linhas

    String[] nomesColunasTabelaFornecedores = {"CNPJ", "Fornecedor", "Endereço", "Contato"};
    //Essa lista terá as linhas da tabela
    List<Object[]> listaLinhasFornecedores = new ArrayList<>();

    try{
        //Adicionando valores nas linhas
        for (Fornecedor fornecedor : GerenciadorDePessoas.getInstance().getFornecedores()) {
            listaLinhasFornecedores.add(new Object[]{fornecedor.getCnpj(), fornecedor.getNome(), fornecedor.getEnderecoInString(), fornecedor.getTelefone()});
        }
    } catch(FornecedorInexistenteException e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    //cria um defaultablemodel com as informações acima
    modeloTabelaFornecedores = new DefaultTableModel(
        listaLinhasFornecedores.toArray(new Object[listaLinhas.size()][]), nomesColunasTabelaFornecedores){

        boolean[] canEdit = new boolean [] {false, false, false, false};

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
        }

    };

    //define o model da tabela
    tabelaFornecedores.setModel(modeloTabelaFornecedores);
    // Redimensionando a largura da coluna de CPF
    tabelaFornecedores.getColumnModel().getColumn(0).setPreferredWidth(180);
    // Redimensionando a largura da coluna de nome
    tabelaFornecedores.getColumnModel().getColumn(1).setPreferredWidth(340);
    // Redimensionando a largura da coluna de número do celular
    tabelaFornecedores.getColumnModel().getColumn(2).setPreferredWidth(430);
    // Redimensionando a largura da coluna de número do celular
    tabelaFornecedores.getColumnModel().getColumn(3).setPreferredWidth(180);
    tabelaFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaFornecedoresMouseClicked(evt);
        }
    });
    pnRlFornecedores.setViewportView(tabelaFornecedores);

    labelFiltrarFornecedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelFiltrarFornecedores.setText("Filtrar por:");

    comboBoxOrdenarFornecedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comboBoxOrdenarFornecedores.setMaximumRowCount(3);
    comboBoxOrdenarFornecedores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Últimos cadastros" }));
    comboBoxOrdenarFornecedores.setToolTipText("Selecionar tipo de filtro");
    comboBoxOrdenarFornecedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    botaoEditarFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoEditarFornecedor.setText("   Editar   ");
    botaoEditarFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoEditarFornecedor.setVisible(false);
    botaoEditarFornecedor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoEditarFornecedorActionPerformed(evt);
        }
    });

    botaoExcluirFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoExcluirFornecedor.setText("   Excluir   ");
    botaoExcluirFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoExcluirFornecedor.setVisible(false);
    botaoExcluirFornecedor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoExcluirFornecedorActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout painelFornecedoresLayout = new javax.swing.GroupLayout(painelFornecedores);
    painelFornecedores.setLayout(painelFornecedoresLayout);
    painelFornecedoresLayout.setHorizontalGroup(
        painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelFornecedoresLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoNovoFornecedor)
                .addGroup(painelFornecedoresLayout.createSequentialGroup()
                    .addComponent(campoPesquisarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(botaoPesquisarFornecedor))
                .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelFornecedoresLayout.createSequentialGroup()
                        .addComponent(labelFiltrarFornecedores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxOrdenarFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoEditarFornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluirFornecedor))
                    .addComponent(pnRlFornecedores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(175, Short.MAX_VALUE))
    );
    painelFornecedoresLayout.setVerticalGroup(
        painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelFornecedoresLayout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(botaoNovoFornecedor)
            .addGap(50, 50, 50)
            .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoPesquisarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoPesquisarFornecedor))
            .addGap(39, 39, 39)
            .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEditarFornecedor)
                    .addComponent(botaoExcluirFornecedor))
                .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFiltrarFornecedores)
                    .addComponent(comboBoxOrdenarFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(pnRlFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(73, 73, 73))
    );

    abas.addTab("Fornecedores", painelFornecedores);

    painelLocacoes.setBackground(new java.awt.Color(255, 255, 255));
    painelLocacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    painelLocacoes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            painelLocacoesMouseClicked(evt);
        }
    });

    botaoNovaLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoNovaLocacao.setText("Nova Locação");
    botaoNovaLocacao.setToolTipText("Criar nova locação");
    botaoNovaLocacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoNovaLocacao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoNovaLocacaoActionPerformed(evt);
        }
    });

    botaoPesquisarLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoPesquisarLocacao.setText("Pesquisar");
    botaoPesquisarLocacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    campoPesquisarLocacao.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
    campoPesquisarLocacao.setForeground(new java.awt.Color(153, 153, 153));
    campoPesquisarLocacao.setText("Pesquisar Locação");
    campoPesquisarLocacao.setToolTipText("");
    campoPesquisarLocacao.setDisabledTextColor(new java.awt.Color(204, 204, 204));
    campoPesquisarLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            campoPesquisarLocacaoMouseClicked(evt);
        }
    });
    campoPesquisarLocacao.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            campoPesquisarLocacaoKeyTyped(evt);
        }
    });

    pnRlLocacoes.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    pnRlLocacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    pnRlLocacoes.setPreferredSize(new java.awt.Dimension(1066, 359));

    tabelaLocacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabelaLocacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tabelaLocacoes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    tabelaLocacoes.getTableHeader().setResizingAllowed(false);
    tabelaLocacoes.getTableHeader().setReorderingAllowed(false);
    //Define a fonte do cabeçalho da tabela fornecedores
    tabelaLocacoes.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 15));
    // Altura das linhas
    tabelaLocacoes.setRowHeight(25);

    String[] nomesColunasTabelaLocacoes = {"", "CPF Cliente", "Cliente", "Produtos Locados", "Valor Total", "Vencimento"};
    //Essa lista terá as linhas da tabela
    List<Object[]> listaLinhasLocacoes = new ArrayList<>();
    //Adicionando valores nas linhas
    for (Locacao locacao : GerenciadorDeLocacao.getInstance().getLocacoes()) {
        try {
            listaLinhasLocacoes.add(new Object[]{Long.toString(locacao.getId()), locacao.getCliente().getCpf(), locacao.getCliente().getNome(),
                GerenciadorDeLocacao.getInstance().getProdutosDeLocacaoInString(locacao.getId()), "R$ "+locacao.getValorLocacaoInString(), locacao.getVencimento()});
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro na hora de buscar os dados da locação", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    }
    //cria um defaultablemodel com as informações acima
    modeloTabelaLocacoes = new DefaultTableModel(
        listaLinhasLocacoes.toArray(new Object[listaLinhasLocacoes.size()][]), nomesColunasTabelaLocacoes){

        boolean[] canEdit = new boolean [] {false, false, false, false, false, false};

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
        }

    };

    //define o model da tabela
    tabelaLocacoes.setModel(modeloTabelaLocacoes);
    // Redimensionando a largura da coluna id da locação
    tabelaLocacoes.getColumnModel().getColumn(0).setPreferredWidth(0);
    // Redimensionando a largura da coluna de CPF do cliente
    tabelaLocacoes.getColumnModel().getColumn(1).setPreferredWidth(120);
    // Redimensionando a largura da coluna de nome do cliente
    tabelaLocacoes.getColumnModel().getColumn(2).setPreferredWidth(280);
    // Redimensionando a largura da coluna de produtos locados
    tabelaLocacoes.getColumnModel().getColumn(3).setPreferredWidth(660);
    // Redimensionando a largura da coluna de valor total
    tabelaLocacoes.getColumnModel().getColumn(4).setPreferredWidth(110);
    // Redimensionando a largura da coluna de data do vencimento
    tabelaLocacoes.getColumnModel().getColumn(5).setPreferredWidth(110);
    tabelaLocacoes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaLocacoesMouseClicked(evt);
        }
    });
    pnRlLocacoes.setViewportView(tabelaLocacoes);

    labelFiltrarLocacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelFiltrarLocacoes.setText("Filtrar por:");

    comboBoxOrdenarFornecedores1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comboBoxOrdenarFornecedores1.setMaximumRowCount(3);
    comboBoxOrdenarFornecedores1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Mais Recentes", "Mais Antigas", "Atrasadas", "Extraviadas" }));
    comboBoxOrdenarFornecedores1.setToolTipText("Selecionar tipo de filtro");
    comboBoxOrdenarFornecedores1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    botaoVerContrato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoVerContrato.setText("Ver Contrato");
    botaoVerContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoVerContrato.setVisible(false);

    botaoFinalizarLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoFinalizarLocacao.setText("Finalizar Locação");
    botaoFinalizarLocacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoFinalizarLocacao.setVisible(false);

    botaoGerarReciboLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoGerarReciboLocacao.setText("Gerar Recibo");
    botaoGerarReciboLocacao.setVisible(false);

    botaoVerRecibosLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoVerRecibosLocacao.setText("Ver Recibos");
    botaoVerRecibosLocacao.setVisible(false);

    javax.swing.GroupLayout painelLocacoesLayout = new javax.swing.GroupLayout(painelLocacoes);
    painelLocacoes.setLayout(painelLocacoesLayout);
    painelLocacoesLayout.setHorizontalGroup(
        painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelLocacoesLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoNovaLocacao)
                .addGroup(painelLocacoesLayout.createSequentialGroup()
                    .addComponent(campoPesquisarLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(botaoPesquisarLocacao))
                .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLocacoesLayout.createSequentialGroup()
                        .addComponent(labelFiltrarLocacoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxOrdenarFornecedores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoGerarReciboLocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVerRecibosLocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVerContrato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoFinalizarLocacao))
                    .addComponent(pnRlLocacoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1270, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(35, Short.MAX_VALUE))
    );
    painelLocacoesLayout.setVerticalGroup(
        painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelLocacoesLayout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(botaoNovaLocacao)
            .addGap(50, 50, 50)
            .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoPesquisarLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoPesquisarLocacao))
            .addGap(40, 40, 40)
            .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLocacoesLayout.createSequentialGroup()
                    .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelFiltrarLocacoes)
                        .addComponent(comboBoxOrdenarFornecedores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(pnRlLocacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelLocacoesLayout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoVerRecibosLocacao)
                            .addComponent(botaoGerarReciboLocacao))
                        .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoVerContrato)
                            .addComponent(botaoFinalizarLocacao)))))
            .addContainerGap(47, Short.MAX_VALUE))
    );

    abas.addTab("  Locações  ", painelLocacoes);

    painelVendas.setBackground(new java.awt.Color(255, 255, 255));
    painelVendas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    painelVendas.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            painelVendasMouseClicked(evt);
        }
    });

    botaoNovaVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoNovaVenda.setText("Nova Venda");
    botaoNovaVenda.setToolTipText("Criar nova locação");
    botaoNovaVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoNovaVenda.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoNovaVendaActionPerformed(evt);
        }
    });

    botaoPesquisarFornecedor1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoPesquisarFornecedor1.setText("Pesquisar");
    botaoPesquisarFornecedor1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    campoPesquisarVenda.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
    campoPesquisarVenda.setForeground(new java.awt.Color(153, 153, 153));
    campoPesquisarVenda.setText("Pesquisar Venda");
    campoPesquisarVenda.setDisabledTextColor(new java.awt.Color(204, 204, 204));
    campoPesquisarVenda.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            campoPesquisarVendaMouseClicked(evt);
        }
    });
    campoPesquisarVenda.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            campoPesquisarVendaKeyTyped(evt);
        }
    });

    comboBoxOrdenarCliente1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comboBoxOrdenarCliente1.setMaximumRowCount(3);
    comboBoxOrdenarCliente1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Últimas vendas", "Valor" }));
    comboBoxOrdenarCliente1.setToolTipText("Selecionar tipo de filtro");
    comboBoxOrdenarCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    pnRlVendas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    pnRlVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    pnRlVendas.setPreferredSize(new java.awt.Dimension(736, 359));

    tabelaVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabelaVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tabelaVendas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    tabelaVendas.getTableHeader().setResizingAllowed(false);
    tabelaVendas.getTableHeader().setReorderingAllowed(false);
    String[] nomesColunasTabelaVendas = {"", "Data da Venda", "Produtos Vendidos", "Valor Total", "Forma de pagamento"};
    //Define a fonte do cabeçalho da tabela
    tabelaVendas.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 15));
    //Altura das linhas
    tabelaVendas.setRowHeight(25);

    //Lista que terá as linhas da tabela
    List<Object[]> listaLinhasVendas = new ArrayList<>();

    //Adicionando valores nas linhas
    for (Venda venda : GerenciadorDeVenda.getInstance().getVendas()) {
        listaLinhasVendas.add(new Object[]{Long.toString(venda.getId()), venda.getDataVendaInString(), venda.getProdutosVendidos(), venda.getValorInString(), venda.getFormaDePagamento()});
    }
    //cria um defaultablemodel com as informações acima
    modeloTabelaVendas = new DefaultTableModel(
        listaLinhasVendas.toArray(new Object[listaLinhasVendas.size()][]), nomesColunasTabelaVendas){

        boolean[] canEdit = new boolean [] {false, false, false, false, false};

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
        }

    };

    //define o model da tabela
    tabelaVendas.setModel(modeloTabelaVendas);
    // Redimensionando a largura da coluna id da venda
    tabelaVendas.getColumnModel().getColumn(0).setPreferredWidth(0);
    // Redimensionando a largura da coluna data da venda
    tabelaVendas.getColumnModel().getColumn(1).setPreferredWidth(110);
    // Redimensionando a largura da coluna de nome
    tabelaVendas.getColumnModel().getColumn(2).setPreferredWidth(350);
    // Redimensionando a largura da coluna de número do celular
    tabelaVendas.getColumnModel().getColumn(3).setPreferredWidth(110);
    // Redimensionando a largura da coluna de última locação
    tabelaVendas.getColumnModel().getColumn(4).setPreferredWidth(160);
    tabelaVendas.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaVendasMouseClicked(evt);
        }
    });
    pnRlVendas.setViewportView(tabelaVendas);

    labelFiltrarVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelFiltrarVenda.setText("Filtrar por:");

    botaoExcluirVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoExcluirVenda.setText("   Excluir   ");
    botaoExcluirVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoExcluirVenda.setVisible(false);
    botaoExcluirVenda.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoExcluirVendaActionPerformed(evt);
        }
    });

    botaoVerRecibosVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoVerRecibosVenda.setText("Ver Recibos");
    botaoVerRecibosVenda.setVisible(false);

    botaoGerarReciboVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoGerarReciboVenda.setText("Gerar Recibo");
    botaoGerarReciboVenda.setVisible(false);

    javax.swing.GroupLayout painelVendasLayout = new javax.swing.GroupLayout(painelVendas);
    painelVendas.setLayout(painelVendasLayout);
    painelVendasLayout.setHorizontalGroup(
        painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelVendasLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoNovaVenda)
                .addGroup(painelVendasLayout.createSequentialGroup()
                    .addComponent(campoPesquisarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(botaoPesquisarFornecedor1))
                .addGroup(painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelVendasLayout.createSequentialGroup()
                        .addComponent(labelFiltrarVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxOrdenarCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoGerarReciboVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVerRecibosVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluirVenda))
                    .addComponent(pnRlVendas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(569, Short.MAX_VALUE))
    );
    painelVendasLayout.setVerticalGroup(
        painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelVendasLayout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(botaoNovaVenda)
            .addGap(50, 50, 50)
            .addGroup(painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoPesquisarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoPesquisarFornecedor1))
            .addGap(39, 39, 39)
            .addGroup(painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoExcluirVenda)
                    .addComponent(botaoVerRecibosVenda)
                    .addComponent(botaoGerarReciboVenda))
                .addGroup(painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFiltrarVenda)
                    .addComponent(comboBoxOrdenarCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(pnRlVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(73, 73, 73))
    );

    abas.addTab("   Vendas   ", painelVendas);

    painelCaixaERelatorios.setBackground(new java.awt.Color(255, 255, 255));
    painelCaixaERelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    painelCaixaERelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            painelCaixaERelatoriosMouseClicked(evt);
        }
    });

    botaoGerarRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoGerarRelatorio.setText("Gerar Relatório");
    botaoGerarRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoGerarRelatorioActionPerformed(evt);
        }
    });

    botaoFecharCaixa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoFecharCaixa.setText("Fechar Caixa");
    botaoFecharCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    pnRlCaixaERelatorios.setPreferredSize(new java.awt.Dimension(916, 359));

    tabelaMovimentacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabelaMovimentacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tabelaMovimentacoes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    tabelaMovimentacoes.getTableHeader().setResizingAllowed(false);
    tabelaMovimentacoes.getTableHeader().setReorderingAllowed(false);
    String[] nomesColunasTabelaMovimentacoes = { null, "Movimento", "Valor", "Data", "Responsável", "Beneficiário"};
    //Define a fonte do cabeçalho da tabela
    tabelaMovimentacoes.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 15));
    //Altura das linhas
    tabelaMovimentacoes.setRowHeight(25);

    //Lista que terá as linhas da tabela
    List<Object[]> listaLinhasMovimentacoes = new ArrayList<>();

    //Adicionando valores nas linhas
    for (Movimentacao movimentacao : GerenciadorDoSistema.getInstance().getMovimentacoes()) {
        listaLinhasMovimentacoes.add(new Object[]{Long.toString(movimentacao.getId()), movimentacao.getMovimento(), "R$ "+movimentacao.getValorInString(),
            movimentacao.getDataInString(), movimentacao.getResponsavel(), movimentacao.getBeneficiario()});
    }

    //cria um defaultablemodel com as informações acima
    modeloTabelaMovimentacoes = new DefaultTableModel(
        listaLinhasMovimentacoes.toArray(new Object[listaLinhasMovimentacoes.size()][]), nomesColunasTabelaMovimentacoes){

        boolean[] canEdit = new boolean [] {false, false, false, false, false, false};

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
        }

    };

    //define o model da tabela
    tabelaMovimentacoes.setModel(modeloTabelaMovimentacoes);
    // Redimensionando a largura da coluna de movimento
    tabelaMovimentacoes.getColumnModel().getColumn(0).setPreferredWidth(0);
    // Redimensionando a largura da coluna de movimento
    tabelaMovimentacoes.getColumnModel().getColumn(1).setPreferredWidth(110);
    // Redimensionando a largura da coluna de valor
    tabelaMovimentacoes.getColumnModel().getColumn(2).setPreferredWidth(110);
    // Redimensionando a largura da coluna de data
    tabelaMovimentacoes.getColumnModel().getColumn(3).setPreferredWidth(110);
    // Redimensionando a largura da coluna de responsável
    tabelaMovimentacoes.getColumnModel().getColumn(4).setPreferredWidth(340);
    // Redimensionando a largura da coluna de beneficiário
    tabelaMovimentacoes.getColumnModel().getColumn(5).setPreferredWidth(246);
    tabelaMovimentacoes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaMovimentacoesMouseClicked(evt);
        }
    });
    pnRlCaixaERelatorios.setViewportView(tabelaMovimentacoes);

    labelFiltrarMovimentacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelFiltrarMovimentacao.setText("Filtrar por:");

    labelValorCaixa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    labelValorCaixa.setText("Valor em Caixa:");

    comboBoxOrdenarCaixaEMovimentacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comboBoxOrdenarCaixaEMovimentacao.setMaximumRowCount(7);
    comboBoxOrdenarCaixaEMovimentacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Vendas", "Locações", "Despesas", "Mais Recentes", "Mias Antigas", "Pendências" }));
    comboBoxOrdenarCaixaEMovimentacao.setToolTipText("Selecionar tipo de filtro");
    comboBoxOrdenarCaixaEMovimentacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    botaoExcluirDespesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoExcluirDespesa.setText("Excluir Despesa   ");
    botaoExcluirDespesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoExcluirDespesa.setVisible(false);
    botaoExcluirDespesa.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoExcluirDespesaActionPerformed(evt);
        }
    });

    labelValorEmCaixa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    labelValorEmCaixa.setForeground(new java.awt.Color(0, 153, 0));

    botaoEditarDespesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoEditarDespesa.setText("Editar Despesa");
    botaoEditarDespesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoEditarDespesa.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoEditarDespesaActionPerformed(evt);
        }
    });
    botaoEditarDespesa.setVisible(false);

    javax.swing.GroupLayout painelCaixaERelatoriosLayout = new javax.swing.GroupLayout(painelCaixaERelatorios);
    painelCaixaERelatorios.setLayout(painelCaixaERelatoriosLayout);
    painelCaixaERelatoriosLayout.setHorizontalGroup(
        painelCaixaERelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelCaixaERelatoriosLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(painelCaixaERelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCaixaERelatoriosLayout.createSequentialGroup()
                    .addGroup(painelCaixaERelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(painelCaixaERelatoriosLayout.createSequentialGroup()
                            .addComponent(labelFiltrarMovimentacao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBoxOrdenarCaixaEMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoEditarDespesa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botaoExcluirDespesa))
                        .addComponent(pnRlCaixaERelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(389, Short.MAX_VALUE))
                .addGroup(painelCaixaERelatoriosLayout.createSequentialGroup()
                    .addComponent(botaoGerarRelatorio)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(botaoFecharCaixa)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelValorCaixa)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelValorEmCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49))))
    );
    painelCaixaERelatoriosLayout.setVerticalGroup(
        painelCaixaERelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelCaixaERelatoriosLayout.createSequentialGroup()
            .addGroup(painelCaixaERelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCaixaERelatoriosLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(painelCaixaERelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoGerarRelatorio)
                        .addComponent(botaoFecharCaixa)))
                .addGroup(painelCaixaERelatoriosLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(painelCaixaERelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelValorCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelValorEmCaixa))))
            .addGap(39, 39, 39)
            .addGroup(painelCaixaERelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCaixaERelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoExcluirDespesa)
                    .addComponent(botaoEditarDespesa))
                .addGroup(painelCaixaERelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFiltrarMovimentacao)
                    .addComponent(comboBoxOrdenarCaixaEMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(pnRlCaixaERelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(100, Short.MAX_VALUE))
    );

    abas.addTab("Relatório e Caixa", painelCaixaERelatorios);

    painelConfiguracoes.setBackground(new java.awt.Color(255, 255, 255));
    painelConfiguracoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    painelConfiguracoes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            painelConfiguracoesMouseClicked(evt);
        }
    });

    botaoSalvarDiretorioBackup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoSalvarDiretorioBackup.setText(" Salvar ");
    botaoSalvarDiretorioBackup.setToolTipText("Salvar diretório");
    botaoSalvarDiretorioBackup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoSalvarDiretorioBackup.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSalvarDiretorioBackupActionPerformed(evt);
        }
    });

    campoDiretorioBackup.setEditable(false);
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
    campoDiretorioBackup.setText(Configuracao.getInstance().getDiretorioDeBackup());
    campoDiretorioDocumentos.setText(Configuracao.getInstance().getDiretorioDeDocumentos());
    campoDiretorioRelatorios.setText(Configuracao.getInstance().getDiretorioDeRelatorios());

    labelDiretorioBackups.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelDiretorioBackups.setText("Diretório de backups");

    botaoSalvarDiretorioDocumentos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoSalvarDiretorioDocumentos.setText(" Salvar ");
    botaoSalvarDiretorioDocumentos.setToolTipText("Salvar diretório");
    botaoSalvarDiretorioDocumentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoSalvarDiretorioDocumentos.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSalvarDiretorioDocumentosActionPerformed(evt);
        }
    });

    campoDiretorioDocumentos.setEditable(false);
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

    labelDiretorioDocumentos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelDiretorioDocumentos.setText("Diretório de Documentos");

    botaoAlterarDiretorioBackup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoAlterarDiretorioBackup.setText("Alterar");
    botaoAlterarDiretorioBackup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoAlterarDiretorioBackup.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoAlterarDiretorioBackupActionPerformed(evt);
        }
    });

    botaoAlterarDiretorioDocumentos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoAlterarDiretorioDocumentos.setText("Alterar");
    botaoAlterarDiretorioDocumentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoAlterarDiretorioDocumentos.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoAlterarDiretorioDocumentosActionPerformed(evt);
        }
    });

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel1.setText("Diretório de Relatórios");

    botaoAlterarDiretorioRelatorios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoAlterarDiretorioRelatorios.setText("Alterar");
    botaoAlterarDiretorioRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoAlterarDiretorioRelatorios.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoAlterarDiretorioRelatoriosActionPerformed(evt);
        }
    });

    botaoSalvarDiretorioRelatorios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoSalvarDiretorioRelatorios.setText(" Salvar ");
    botaoSalvarDiretorioRelatorios.setToolTipText("Salvar diretório");
    botaoSalvarDiretorioRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoSalvarDiretorioRelatorios.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSalvarDiretorioRelatoriosActionPerformed(evt);
        }
    });

    campoDiretorioRelatorios.setEditable(false);
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

    javax.swing.GroupLayout painelConfiguracoesLayout = new javax.swing.GroupLayout(painelConfiguracoes);
    painelConfiguracoes.setLayout(painelConfiguracoesLayout);
    painelConfiguracoesLayout.setHorizontalGroup(
        painelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelConfiguracoesLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(painelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1)
                .addComponent(labelDiretorioDocumentos)
                .addComponent(labelDiretorioBackups)
                .addGroup(painelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelConfiguracoesLayout.createSequentialGroup()
                        .addComponent(campoDiretorioDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoAlterarDiretorioDocumentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSalvarDiretorioDocumentos))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelConfiguracoesLayout.createSequentialGroup()
                        .addComponent(campoDiretorioBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoAlterarDiretorioBackup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSalvarDiretorioBackup)))
                .addGroup(painelConfiguracoesLayout.createSequentialGroup()
                    .addComponent(campoDiretorioRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(botaoAlterarDiretorioRelatorios)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                    .addComponent(botaoSalvarDiretorioRelatorios)))
            .addContainerGap(686, Short.MAX_VALUE))
    );
    painelConfiguracoesLayout.setVerticalGroup(
        painelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelConfiguracoesLayout.createSequentialGroup()
            .addGap(66, 66, 66)
            .addComponent(labelDiretorioBackups)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoDiretorioBackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoSalvarDiretorioBackup)
                .addComponent(botaoAlterarDiretorioBackup))
            .addGap(30, 30, 30)
            .addComponent(labelDiretorioDocumentos)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoDiretorioDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoSalvarDiretorioDocumentos)
                .addComponent(botaoAlterarDiretorioDocumentos))
            .addGap(30, 30, 30)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(botaoSalvarDiretorioRelatorios)
                .addComponent(botaoAlterarDiretorioRelatorios)
                .addComponent(campoDiretorioRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(340, Short.MAX_VALUE))
    );

    try {
        if(GerenciadorDePessoas.getInstance().isAdministrador(loginUsuario)) {

            abas.addTab("Configuração", painelConfiguracoes);
        }
    } catch (UsuarioInexistenteException e) {
        setVisible(false);
        new LoginFrame().setVisible(true);
    }

    painelAdministrador.setBackground(new java.awt.Color(255, 255, 255));
    painelAdministrador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    painelAdministrador.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            painelAdministradorMouseClicked(evt);
        }
    });

    botaoNovoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoNovoUsuario.setText("Novo Usuário");
    botaoNovoUsuario.setToolTipText("Criar novo usuário");
    botaoNovoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoNovoUsuarioActionPerformed(evt);
        }
    });

    botaoPesquisarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoPesquisarUsuario.setText("Pesquisar");
    botaoPesquisarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    campoPesquisarUsuario.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
    campoPesquisarUsuario.setForeground(new java.awt.Color(153, 153, 153));
    campoPesquisarUsuario.setText("Pesquisar Usuário");
    campoPesquisarUsuario.setToolTipText("Informe o nome do usuário");
    campoPesquisarUsuario.setDisabledTextColor(new java.awt.Color(204, 204, 204));
    campoPesquisarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            campoPesquisarUsuarioMouseClicked(evt);
        }
    });
    campoPesquisarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            campoPesquisarUsuarioKeyTyped(evt);
        }
    });

    pnRlUsuario.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    pnRlUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    pnRlUsuario.setPreferredSize(new java.awt.Dimension(596, 359));

    tabelaUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tabelaUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    tabelaUsuarios.getTableHeader().setResizingAllowed(false);
    tabelaUsuarios.getTableHeader().setReorderingAllowed(false);
    String[] nomesColunasTabelaUsuarios = {"Nome do Usuário", "NickName", "Categoria"};
    //Define a fonte do cabeçalho da tabela usuários
    tabelaUsuarios.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 15));
    //Definindo o tamanho da linha
    tabelaUsuarios.setRowHeight(25);

    //Linhas da tabela
    List<Object[]> listaLinhasUsuarios = new ArrayList<>();

    //Adicionando valores nas linhas
    for (Usuario usuario : GerenciadorDePessoas.getInstance().getUsuarios()) {
        listaLinhasUsuarios.add(new Object[]{usuario.getNome(), usuario.getNickName(), usuario.getCategoria()});
    }
    //cria um defaultablemodel com as informações acima
    modeloTabelaUsuarios = new DefaultTableModel(
        listaLinhasUsuarios.toArray(new Object[listaLinhasUsuarios.size()][]), nomesColunasTabelaUsuarios){

        boolean[] canEdit = new boolean [] {false, false, false};

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
        }

    };

    //define o model da tabela
    tabelaUsuarios.setModel(modeloTabelaUsuarios);
    // Redimensionando a largura da coluna de nome
    tabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(300);
    // Redimensionando a largura da coluna de nickName
    tabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(170);
    // Redimensionando a largura da coluna de categoria
    tabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(120);
    tabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaUsuariosMouseClicked(evt);
        }
    });
    pnRlUsuario.setViewportView(tabelaUsuarios);

    labelFiltrarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelFiltrarUsuario.setText("Filtrar por:");

    comboBoxUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comboBoxUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Últimos cadastros" }));
    comboBoxUsuario.setToolTipText("Selecionar tipo de filtro");
    comboBoxUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    botaoAtivarTemporada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoAtivarTemporada.setText("Temporada de Desconto");
    botaoAtivarTemporada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoAtivarTemporada.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoAtivarTemporadaActionPerformed(evt);
        }
    });

    botaoExcluirUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoExcluirUsuario.setText("  Excluir  ");
    botaoExcluirUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoExcluirUsuarioActionPerformed(evt);
        }
    });
    botaoExcluirUsuario.setVisible(false);

    botaoEditarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoEditarUsuario.setText("  Editar  ");
    botaoEditarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoEditarUsuarioActionPerformed(evt);
        }
    });
    botaoEditarUsuario.setVisible(false);

    botaoRegistrarDespesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoRegistrarDespesa.setText("Registrar Despesa");
    botaoRegistrarDespesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoRegistrarDespesa.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoRegistrarDespesaActionPerformed(evt);
        }
    });

    botaoEditarEmpresa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoEditarEmpresa.setText("Editar Empresa");
    botaoEditarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoEditarEmpresa.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoEditarEmpresaActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout painelAdministradorLayout = new javax.swing.GroupLayout(painelAdministrador);
    painelAdministrador.setLayout(painelAdministradorLayout);
    painelAdministradorLayout.setHorizontalGroup(
        painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelAdministradorLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelAdministradorLayout.createSequentialGroup()
                    .addComponent(botaoNovoUsuario)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(botaoRegistrarDespesa)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(botaoAtivarTemporada)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(botaoEditarEmpresa))
                .addGroup(painelAdministradorLayout.createSequentialGroup()
                    .addComponent(campoPesquisarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(botaoPesquisarUsuario))
                .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelAdministradorLayout.createSequentialGroup()
                        .addComponent(labelFiltrarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoEditarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluirUsuario))
                    .addComponent(pnRlUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(709, Short.MAX_VALUE))
    );
    painelAdministradorLayout.setVerticalGroup(
        painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelAdministradorLayout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(botaoNovoUsuario)
                .addComponent(botaoAtivarTemporada)
                .addComponent(botaoRegistrarDespesa)
                .addComponent(botaoEditarEmpresa))
            .addGap(46, 46, 46)
            .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoPesquisarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoPesquisarUsuario))
            .addGap(39, 39, 39)
            .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEditarUsuario)
                    .addComponent(botaoExcluirUsuario))
                .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFiltrarUsuario)
                    .addComponent(comboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(pnRlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    try {
        if(GerenciadorDePessoas.getInstance().isAdministrador(loginUsuario)) {

            abas.addTab("Administrador", painelAdministrador);
        }
    } catch (UsuarioInexistenteException e) {
        setVisible(false);
        new LoginFrame().setVisible(true);
    }

    javax.swing.GroupLayout painelGeralLayout = new javax.swing.GroupLayout(painelGeral);
    painelGeral.setLayout(painelGeralLayout);
    painelGeralLayout.setHorizontalGroup(
        painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelGeralLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(abas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    painelGeralLayout.setVerticalGroup(
        painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelGeralLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(painelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
            .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(painelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(painelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
            .addGap(0, 0, 0))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoClienteActionPerformed
        CadastrarClienteDialog dialog = new CadastrarClienteDialog(null);
        dialog.setLocationRelativeTo(null);
        if (dialog.alterarDados()) {
            adicionarNovoClienteNaTabela(dialog.getNovoCliente());
        }
        dialog.dispose();
    }//GEN-LAST:event_botaoNovoClienteActionPerformed

    private void campoPesquisarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarClienteMouseClicked
        if(campoPesquisarCliente.getText().equals("Pesquisar Cliente")) {
            eliminarTextoDeCampo(campoPesquisarCliente);
        }
    }//GEN-LAST:event_campoPesquisarClienteMouseClicked

    private void campoPesquisarClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarClienteKeyTyped
        if(campoPesquisarCliente.getText().equals("Pesquisar Cliente")) {
            eliminarTextoDeCampo(campoPesquisarCliente);
        } 
    }//GEN-LAST:event_campoPesquisarClienteKeyTyped

    private void painelClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelClientesMouseClicked
        if(campoPesquisarCliente.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarCliente, "Pesquisar Cliente");
        }
        //Se alguma linha da tabela estiver selecionada
        if(tabelaClientes.getSelectedRow() >= 0) {
            botaoEditarCliente.setVisible(false);
            botaoExcluirCliente.setVisible(false);
            botaoVerLocacoesCliente.setVisible(false);
            tabelaClientes.clearSelection();
        }
    }//GEN-LAST:event_painelClientesMouseClicked

    private void botaoNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoProdutoActionPerformed
        CadastrarProdutoDialog dialog = new CadastrarProdutoDialog(null);
        dialog.setLocationRelativeTo(null);
        if (dialog.alterarDados()) {
            adicionarNovoProdutoNaTabela(dialog.getNovoProduto());
        }
        dialog.dispose();
    }//GEN-LAST:event_botaoNovoProdutoActionPerformed

    private void campoPesquisarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarProdutoMouseClicked
        if(campoPesquisarProduto.getText().equals("Pesquisar Produto")) {
            eliminarTextoDeCampo(campoPesquisarProduto);
        }
    }//GEN-LAST:event_campoPesquisarProdutoMouseClicked

    private void campoPesquisarProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarProdutoKeyTyped
        if(campoPesquisarProduto.getText().equals("Pesquisar Produto")) {
            eliminarTextoDeCampo(campoPesquisarProduto);
        } 
    }//GEN-LAST:event_campoPesquisarProdutoKeyTyped
    
    private void painelProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelProdutosMouseClicked
        if(campoPesquisarProduto.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarProduto, "Pesquisar Produto");
        }
        //Se alguma linha da tabela estiver selecionada
        if(tabelaProdutos.getSelectedRow() >= 0) {
            botaoEditarProduto.setVisible(false);
            botaoExcluirProduto.setVisible(false);
            tabelaProdutos.clearSelection();
        }
    }//GEN-LAST:event_painelProdutosMouseClicked

    private void botaoNovoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoFornecedorActionPerformed
        CadastrarFornecedorDialog dialog = new CadastrarFornecedorDialog(null);
        dialog.setLocationRelativeTo(null);
        if (dialog.alterarDados()) {
            adicionarNovoFornecedorNaTabela(dialog.getNovoFornecedor());
        }
        dialog.dispose();
    }//GEN-LAST:event_botaoNovoFornecedorActionPerformed

    private void campoPesquisarFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarFornecedorMouseClicked
        if(campoPesquisarFornecedor.getText().equals("Pesquisar Fornecedor")) {
            eliminarTextoDeCampo(campoPesquisarFornecedor);
        }
    }//GEN-LAST:event_campoPesquisarFornecedorMouseClicked

    private void campoPesquisarFornecedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarFornecedorKeyTyped
        if(campoPesquisarFornecedor.getText().equals("Pesquisar Fornecedor")) {
            eliminarTextoDeCampo(campoPesquisarFornecedor);
        } 
    }//GEN-LAST:event_campoPesquisarFornecedorKeyTyped

    private void painelFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelFornecedoresMouseClicked
        if(campoPesquisarFornecedor.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarFornecedor, "Pesquisar Fornecedor");
        }
        //Se alguma linha da tabela estiver selecionada
        if(tabelaFornecedores.getSelectedRow() >= 0) {
            botaoEditarFornecedor.setVisible(false);
            botaoExcluirFornecedor.setVisible(false);
            tabelaFornecedores.clearSelection();
        }
    }//GEN-LAST:event_painelFornecedoresMouseClicked

    private void botaoNovaLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovaLocacaoActionPerformed
        RealizarLocacaoDialog dialog = new RealizarLocacaoDialog(null);
        dialog.setLocationRelativeTo(null);
        if (dialog.alterarDados()) {
            adicionarNovaLocacaoNaTabela(dialog.getNovaLocacao());
            adicionarNovaMovimentacaoNaTabela(dialog.getNovaMovimentacao());
            atualizarValorEmCaixa();
        }
        dialog.dispose();
    }//GEN-LAST:event_botaoNovaLocacaoActionPerformed

    private void campoPesquisarLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarLocacaoMouseClicked
        if(campoPesquisarLocacao.getText().equals("Pesquisar Locação")) {
            eliminarTextoDeCampo(campoPesquisarLocacao);
        }
    }//GEN-LAST:event_campoPesquisarLocacaoMouseClicked

    private void campoPesquisarLocacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarLocacaoKeyTyped
        if(campoPesquisarLocacao.getText().equals("Pesquisar Locação")) {
            eliminarTextoDeCampo(campoPesquisarLocacao);
        }
    }//GEN-LAST:event_campoPesquisarLocacaoKeyTyped

    private void painelLocacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelLocacoesMouseClicked
        if(campoPesquisarLocacao.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarLocacao, "Pesquisar Locação");
        }
        //Se alguma linha da tabela estiver selecionada
        if(tabelaLocacoes.getSelectedRow() >= 0) {
            botaoVerRecibosLocacao.setVisible(false);
            botaoGerarReciboLocacao.setVisible(false);
            botaoVerContrato.setVisible(false);
            botaoFinalizarLocacao.setVisible(false);
            tabelaLocacoes.clearSelection();
        }
    }//GEN-LAST:event_painelLocacoesMouseClicked

    private void botaoNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovaVendaActionPerformed
        RealizarVendaDialog dialog = new RealizarVendaDialog(null);
        dialog.setLocationRelativeTo(null);
        if (dialog.alterarDados()) {
            adicionarNovaVendaNaTabela(dialog.getNovaVenda());
            adicionarNovaMovimentacaoNaTabela(dialog.getNovaMovimentacao());
            atualizarValorEmCaixa();
        }
        dialog.dispose();
    }//GEN-LAST:event_botaoNovaVendaActionPerformed

    private void campoPesquisarVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarVendaMouseClicked
        if(campoPesquisarVenda.getText().equals("Pesquisar Venda")) {
            eliminarTextoDeCampo(campoPesquisarVenda);
        }
    }//GEN-LAST:event_campoPesquisarVendaMouseClicked

    private void campoPesquisarVendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarVendaKeyTyped
        if(campoPesquisarVenda.getText().equals("Pesquisar Venda")) {
            eliminarTextoDeCampo(campoPesquisarVenda);
        }
    }//GEN-LAST:event_campoPesquisarVendaKeyTyped

    private void painelVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelVendasMouseClicked
        if(campoPesquisarVenda.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarVenda, "Pesquisar Venda");
        }
        //Se alguma linha da tabela estiver selecionada
        if(tabelaVendas.getSelectedRow() >= 0) {
            botaoGerarReciboVenda.setVisible(false);
            botaoVerRecibosVenda.setVisible(false);
            botaoExcluirVenda.setVisible(false);
            tabelaVendas.clearSelection();
        }
    }//GEN-LAST:event_painelVendasMouseClicked

    private void botaoGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarRelatorioActionPerformed
        GerarRelatorioDialog dialog = new GerarRelatorioDialog(new java.awt.Frame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_botaoGerarRelatorioActionPerformed

    private void botaoSalvarDiretorioBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarDiretorioBackupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoSalvarDiretorioBackupActionPerformed

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

    private void botaoSalvarDiretorioDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarDiretorioDocumentosActionPerformed
        if(campoDiretorioDocumentos.getText().length() <= 0) {
           JOptionPane.showMessageDialog(null, "Informe o caminho do diretório de documentos corretamente", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            Configuracao.getInstance().setDiretorioDeDocumentos(campoDiretorioDocumentos.getText());
        }
    }//GEN-LAST:event_botaoSalvarDiretorioDocumentosActionPerformed

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

    private void painelConfiguracoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelConfiguracoesMouseClicked
        desabilitarCamposDeDiretorios();
        if(campoDiretorioBackup.getText().length() <= 0) {
            criarTextoEmCampo(campoDiretorioBackup, "Caminho do diretório");
        }
        if(campoDiretorioDocumentos.getText().length() <= 0) {
            criarTextoEmCampo(campoDiretorioDocumentos, "Caminho do diretório");
        }
        if(campoDiretorioRelatorios.getText().length() <= 0) {
            criarTextoEmCampo(campoDiretorioRelatorios, "Caminho do diretório");
        }
    }//GEN-LAST:event_painelConfiguracoesMouseClicked

    private void botaoNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoUsuarioActionPerformed
        CadastrarUsuarioDialog dialog = new CadastrarUsuarioDialog(null);
        dialog.setLocationRelativeTo(null);
        if (dialog.alterarDados()) {
            adicionarNovoUsuarioNaTabela(dialog.getNovoUsuario());
        }
        dialog.dispose();
    }//GEN-LAST:event_botaoNovoUsuarioActionPerformed

    private void campoPesquisarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarUsuarioMouseClicked
        if(campoPesquisarUsuario.getText().equals("Pesquisar Usuário")) {
            eliminarTextoDeCampo(campoPesquisarUsuario);
        }
    }//GEN-LAST:event_campoPesquisarUsuarioMouseClicked

    private void campoPesquisarUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarUsuarioKeyTyped
        if(campoPesquisarUsuario.getText().equals("Pesquisar Usuário")) {
            eliminarTextoDeCampo(campoPesquisarUsuario);
        }
    }//GEN-LAST:event_campoPesquisarUsuarioKeyTyped

    private void painelAdministradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelAdministradorMouseClicked
        if(campoPesquisarUsuario.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarUsuario, "Pesquisar Usuário");
        }
        //Se alguma linha da tabela estiver selecionada
        if(tabelaUsuarios.getSelectedRow() >= 0) {
            botaoEditarUsuario.setVisible(false);
            botaoExcluirUsuario.setVisible(false);
            tabelaUsuarios.clearSelection();
        }
    }//GEN-LAST:event_painelAdministradorMouseClicked

    private void botaoPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarClienteActionPerformed
        if(campoPesquisarCliente.getText().equals("Pesquisar Cliente") || campoPesquisarCliente.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe um nome para a pesquisa de usuário", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            // atualizar o model da lista de clientes
            GerenciadorDePessoas.getInstance().pesquisarClientesPorNome(campoPesquisarCliente.getText());
        }
    }//GEN-LAST:event_botaoPesquisarClienteActionPerformed

    private void comboFiltrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltrarClienteActionPerformed
        switch (comboFiltrarCliente.getSelectedItem().toString()) {
            case "Todos":
                GerenciadorDePessoas.getInstance().pesquisarClientesPorNome(campoPesquisarCliente.getText());
                break;

            case "Últimos locatários":
                    // Método para pesquisar os clientes que fizeram locações mais recentemente
                //GerenciadorDePessoas.getInstance().pesquisarClientesPorNome(campoPesquisarCliente.getText());
                break;

            case "Últimos cadastros":
                    //Método para pesquisar os clientes que foram cadastrados mais recentemente
                //GerenciadorDePessoas.getInstance().pesquisarClientesPorNome(campoPesquisarCliente.getText());
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida\n\n Tente novamente", "Aviso", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_comboFiltrarClienteActionPerformed

    private void botaoAtivarTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtivarTemporadaActionPerformed
        AtivarTemporadaDialog dialog = new AtivarTemporadaDialog(new java.awt.Frame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_botaoAtivarTemporadaActionPerformed

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        if(evt.getClickCount() == 1) {
            botaoEditarProduto.setVisible(true);
            botaoExcluirProduto.setVisible(true);
        }
        if(evt.getClickCount() == 2) {
            Executors.newFixedThreadPool(10).execute(new Runnable() {
                public void run() {
                    try {
                        //Passa, como parâmetro, o produto pesquisado pelo código 
                        VerDadosProdutoDialog dialog = new VerDadosProdutoDialog(null, GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(
                                (String) modeloTabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0)));

                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    } catch (ProdutoInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        }
    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        if (evt.getClickCount() == 1) {
            botaoEditarCliente.setVisible(true);
            botaoExcluirCliente.setVisible(true);
            botaoVerLocacoesCliente.setVisible(true);
        }
        if (evt.getClickCount() == 2) {
            Executors.newFixedThreadPool(10).execute(new Runnable() {
                public void run() {
                    try {
                        VerDadosClienteDialog dialog = new VerDadosClienteDialog(null, GerenciadorDePessoas.getInstance().pesquisarCliente(
                                (String) modeloTabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0)));
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    } catch (ClienteInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }

                }
            });

        }
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void painelCaixaERelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelCaixaERelatoriosMouseClicked
        botaoExcluirDespesa.setVisible(false);
        botaoEditarDespesa.setVisible(false);
        if(tabelaMovimentacoes.getSelectedRow() >= 0) {
            tabelaMovimentacoes.clearSelection();
        }
    }//GEN-LAST:event_painelCaixaERelatoriosMouseClicked

    private void botaoEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarClienteActionPerformed
        if(tabelaClientes.getSelectedRow() >= 0) {
            
            Executors.newFixedThreadPool(10).execute(new Runnable() {
                public void run() {
                    try {
                        //Pesquisa o cliente selecionado através do seu CPF (0 = primeira coluna da tabela)
                        EditarClienteDialog dialog = new EditarClienteDialog(null, GerenciadorDePessoas.getInstance().pesquisarCliente(
                                (String) modeloTabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0)));

                        dialog.setLocationRelativeTo(null);
                        if (dialog.alterarDados()) {
                            atualizarDadosClienteNaTabela(dialog.getCliente(), tabelaClientes.getSelectedRow());
                        }
                        dialog.dispose();
                    } catch (ClienteInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }

                }
            });
        }
    }//GEN-LAST:event_botaoEditarClienteActionPerformed

    private void botaoExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirClienteActionPerformed
        if(tabelaClientes.getSelectedRow() >= 0) {
            int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o cliente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            //Sim = 0
            if(escolha == 0) { 
                try {
                    //Pesquisa o cliente selecionado através do seu CPF (0 = primeira coluna da tabela)
                    GerenciadorDePessoas.getInstance().removerCliente((String) modeloTabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0));
                    removerClienteDaTabela(tabelaClientes.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                } catch (ClienteInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } 
        }
    }//GEN-LAST:event_botaoExcluirClienteActionPerformed

    private void botaoExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirProdutoActionPerformed
        if(tabelaProdutos.getSelectedRow() >= 0) {
            int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este produto?", "Atenção!", JOptionPane.YES_NO_OPTION);
            //Sim = 0
            if(escolha == 0) { 
                try {
                    //Pesquisa o cliente selecionado através do seu código (0 = primeira coluna da tabela)
                    GerenciadorDeProduto.getInstance().removerProduto((String) modeloTabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0));
                    removerProdutoDaTabela(tabelaProdutos.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                } catch (ProdutoInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } 
        }
    }//GEN-LAST:event_botaoExcluirProdutoActionPerformed

    private void botaoExcluirFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirFornecedorActionPerformed
        if(tabelaFornecedores.getSelectedRow() >= 0) {
            int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este fornecedor?", "Atenção!", JOptionPane.YES_NO_OPTION);
            //Sim = 0
            if(escolha == 0) { 
                try {
                    //Pesquisa o cliente selecionado através do seu CNPJ (0 = primeira coluna da tabela)
                    GerenciadorDePessoas.getInstance().removerFornecedor((String) modeloTabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 0));
                    removerFornecedorDaTabela(tabelaFornecedores.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso!");
                } catch (FornecedorInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } 
        }
    }//GEN-LAST:event_botaoExcluirFornecedorActionPerformed

    private void botaoExcluirVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirVendaActionPerformed
        if(tabelaProdutos.getSelectedRow() >= 0) {
            int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este produto?", "Atenção!", JOptionPane.YES_NO_OPTION);
            //Sim = 0
            if(escolha == 0) { 
                try {
                    //Pesquisa o cliente selecionado através do seu código (0 = primeira coluna da tabela)
                    GerenciadorDeProduto.getInstance().removerProduto((String) modeloTabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0));
                    removerProdutoDaTabela(tabelaProdutos.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                } catch (ProdutoInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } 
        }
    }//GEN-LAST:event_botaoExcluirVendaActionPerformed

    private void botaoExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirUsuarioActionPerformed
        if(tabelaUsuarios.getSelectedRow() >= 0) {
            int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este usuário?", "Atenção!", JOptionPane.YES_NO_OPTION);
            //Sim = 0
            if(escolha == 0) { 
                try {
                   //Remove o usuário selecionado através do seu login
                    GerenciadorDePessoas.getInstance().removerUsuario((String) modeloTabelaUsuarios.getValueAt(tabelaUsuarios.getSelectedRow(), 1));
                    removerUsuarioDaTabela(tabelaUsuarios.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                } catch (UsuarioInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } 
        }
    }//GEN-LAST:event_botaoExcluirUsuarioActionPerformed

    private void botaoExcluirDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirDespesaActionPerformed
        if(tabelaMovimentacoes.getSelectedRow() >= 0) {
            if(((String )modeloTabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), 1)).toUpperCase().equals("DESPESA")) {
                int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta despesa?", "Atenção!", JOptionPane.YES_NO_OPTION);
                //Sim = 0
                if(escolha == 0) { 
                    try {
                        //Pesquisa o cliente selecionado através do seu código (0 = primeira coluna da tabela)
                        GerenciadorDoSistema.getInstance().removerDespesas(Long.parseLong((String) modeloTabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), 0)));
                        removerMovimentacaoDaTabela(tabelaMovimentacoes.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Despesa removida com sucesso!");
                    } catch (DespesaInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                } 
            } else {
                JOptionPane.showMessageDialog(null, "A despesa não pôde ser excluída", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar uma despesa na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoExcluirDespesaActionPerformed

    private void tabelaFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFornecedoresMouseClicked
        if (evt.getClickCount() == 1) {
            botaoEditarFornecedor.setVisible(true);
            botaoExcluirFornecedor.setVisible(true);
        }
        if(evt.getClickCount() == 2) {
            
            Executors.newFixedThreadPool(10).execute(new Runnable() {
                public void run() {
                    //Passa, como parâmetro, o fornecedor pesquisado pelo CNPJ
                    try {
                        VerDadosFornecedorDialog dialog = new VerDadosFornecedorDialog(null, GerenciadorDePessoas.getInstance().pesquisarFornecedorPeloCnpj(
                                (String) modeloTabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 0)));

                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    } catch (FornecedorInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            
        }
    }//GEN-LAST:event_tabelaFornecedoresMouseClicked

    private void tabelaVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendasMouseClicked
        if (evt.getClickCount() == 1) {
            botaoGerarReciboVenda.setVisible(true);
            botaoVerRecibosVenda.setVisible(true);
            botaoExcluirVenda.setVisible(true);
        }
        if(evt.getClickCount() == 2) {
            
            Executors.newFixedThreadPool(10).execute(new Runnable() {
                public void run() {
                    try {
                        //Passa, como parâmetro, a venda pesquisada pelo seu código 
                        VerDadosVendaDialog dialog = new VerDadosVendaDialog(null, GerenciadorDeVenda.getInstance().pesquisarVendaPorId(
                                Long.parseLong((String) modeloTabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 0))));

                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    } catch (VendaInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        }
    }//GEN-LAST:event_tabelaVendasMouseClicked

    private void tabelaMovimentacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMovimentacoesMouseClicked
        if (evt.getClickCount() == 1) {
            botaoExcluirDespesa.setVisible(true);
            botaoEditarDespesa.setVisible(true);
        }
        if(evt.getClickCount() == 2) {
            
            Executors.newFixedThreadPool(10).execute(new Runnable() {
                public void run() {
                    //Passa, como parâmetro, a movimentacao pesquisada pelo id
                    try {

                        if (((String) modeloTabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), 1)).toUpperCase().equals("DESPESA")) {
                            VerDadosDespesaDialog dialog = new VerDadosDespesaDialog(null, GerenciadorDoSistema.getInstance().pesquisarDespesaPorId(
                                    Long.parseLong((String) modeloTabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), 0))));

                            dialog.setLocationRelativeTo(null);
                            dialog.setVisible(true);
                        } else {
                            VerDadosMovimentacaoDialog dialog = new VerDadosMovimentacaoDialog(null, GerenciadorDoSistema.getInstance().pesquisarMovimentacaoPorId(
                                    Long.parseLong((String) modeloTabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), 0))));

                            dialog.setLocationRelativeTo(null);
                            dialog.setVisible(true);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        }
    }//GEN-LAST:event_tabelaMovimentacoesMouseClicked

    private void tabelaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUsuariosMouseClicked
        if (evt.getClickCount() == 1) {
            botaoEditarUsuario.setVisible(true);
            botaoExcluirUsuario.setVisible(true);
        }
        
    }//GEN-LAST:event_tabelaUsuariosMouseClicked

    private void tabelaLocacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLocacoesMouseClicked
        if (evt.getClickCount() == 1) {
            botaoVerRecibosLocacao.setVisible(true);
            botaoGerarReciboLocacao.setVisible(true);
            botaoVerContrato.setVisible(true);
            botaoFinalizarLocacao.setVisible(true);
        }
        if(evt.getClickCount() == 2) {
            
            Executors.newFixedThreadPool(10).execute(new Runnable() {
                public void run() {
                    try {
                        //Passa, como parâmetro, a locação pesquisada pelo id
                        VerDadosLocacaoDialog dialog = new VerDadosLocacaoDialog(null, GerenciadorDeLocacao.getInstance().pesquisarLocacaoPorId(
                                Long.parseLong((String) modeloTabelaLocacoes.getValueAt(tabelaLocacoes.getSelectedRow(), 0))));

                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    } catch (LocacaoInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        }
    }//GEN-LAST:event_tabelaLocacoesMouseClicked

    private void botaoRegistrarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRegistrarDespesaActionPerformed
        RegistrarDespesaDialog dialog = new RegistrarDespesaDialog(null);
        dialog.setLocationRelativeTo(null);
        if (dialog.alterarDados()) {
            adicionarNovaMovimentacaoNaTabela(dialog.getNovaMovimentacao());
        }
        dialog.dispose();
        atualizarValorEmCaixa();
    }//GEN-LAST:event_botaoRegistrarDespesaActionPerformed

    private void botaoSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSairMouseClicked
        new LoginFrame().setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoSairMouseClicked

    private void botaoEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarProdutoActionPerformed
        if(tabelaProdutos.getSelectedRow() >= 0) {
            
            Executors.newFixedThreadPool(10).execute(new Runnable() {
                public void run() {
                    try {
                        //Pesquisa o cliente selecionado através do seu CPF (0 = primeira coluna da tabela)
                        EditarProdutoDialog dialog = new EditarProdutoDialog(null, GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(
                                (String) modeloTabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0)));

                        dialog.setLocationRelativeTo(null);
                        if (dialog.alterarDados()) {
                            atualizarDadosProdutoNaTabela(dialog.getProduto(), tabelaProdutos.getSelectedRow());
                        }
                        dialog.dispose();
                        
                    } catch (ProdutoInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        }
    }//GEN-LAST:event_botaoEditarProdutoActionPerformed

    private void botaoEditarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarFornecedorActionPerformed
        if(tabelaFornecedores.getSelectedRow() >= 0) {
            try {
                //Pesquisa o cliente selecionado através do seu CPF (0 = primeira coluna da tabela)
                EditarFornecedorDialog dialog = new EditarFornecedorDialog(null, GerenciadorDePessoas.getInstance().pesquisarFornecedorPeloCnpj(
                        (String) modeloTabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 0)));
                
                dialog.setLocationRelativeTo(null);
                if (dialog.alterarDados()) {
                    atualizarDadosFornecedorNaTabela(dialog.getFornecedor(), tabelaFornecedores.getSelectedRow());
                }
                dialog.dispose();
                
            } catch (FornecedorInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoEditarFornecedorActionPerformed

    private void botaoEditarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarDespesaActionPerformed
        if(tabelaMovimentacoes.getSelectedRow() >= 0) {
            if(((String )modeloTabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), 1)).toCharArray().equals("DESPESA")) {
                Executors.newFixedThreadPool(10).execute(new Runnable() {
                    public void run() {
                        try {
                            //Pesquisa a despesa selecionado através do seu id (0 = primeira coluna da tabela)
                            EditarDespesaDialog dialog = new EditarDespesaDialog(null, GerenciadorDoSistema.getInstance().pesquisarDespesaPorId(
                                    Long.parseLong((String) modeloTabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), 0))));

                            dialog.setLocationRelativeTo(null);
                            if (dialog.alterarDados()) {
                                atualizarDadosDespesaNaTabela(dialog.getMovimentacao(), tabelaMovimentacoes.getSelectedRow());
                            }
                            dialog.dispose();

                        } catch (DespesaInexistenteException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "Você não pode editar esse tipo de movimentação", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum item na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoEditarDespesaActionPerformed

    private void botaoEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarUsuarioActionPerformed
        if(tabelaUsuarios.getSelectedRow() >= 0) {
            
            Executors.newFixedThreadPool(10).execute(new Runnable() {
                public void run() {
                    try {
                        //Pesquisa o usuário selecionado através do seu login (segunda coluna da tabela)
                        EditarUsuarioDialog dialog = new EditarUsuarioDialog(null, GerenciadorDePessoas.getInstance().pesquisarUsuarioPeloLogin(
                                (String) modeloTabelaUsuarios.getValueAt(tabelaUsuarios.getSelectedRow(), 1)));

                        dialog.setLocationRelativeTo(null);

                        if (dialog.alterarDados()) {
                            atualizarDadosUsuarioNaTabela(dialog.getUsuario(), tabelaUsuarios.getSelectedRow());
                        }
                        dialog.dispose();

                    } catch (UsuarioInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }

                }
            });
        }
    }//GEN-LAST:event_botaoEditarUsuarioActionPerformed

    private void botaoVerLocacoesClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerLocacoesClienteActionPerformed
        try {
            //Abrir pasta do sistema com as locações feitas pelo usuários
            Runtime.getRuntime().exec(Configuracao.getInstance().getDiretorioDeDocumentos()+
                        "\\Locações"+"\\"+modeloTabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 1));
        } catch (java.io.IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro na busca pela pasta de locações do cliente", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoVerLocacoesClienteActionPerformed

    private void botaoEditarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarEmpresaActionPerformed
        EditarEmpresaDialog dialog = new EditarEmpresaDialog(null, Configuracao.getInstance().getEmpresa());
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_botaoEditarEmpresaActionPerformed

    private void botaoAlterarDiretorioBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarDiretorioBackupActionPerformed
        campoDiretorioBackup.setEditable(true);
    }//GEN-LAST:event_botaoAlterarDiretorioBackupActionPerformed

    private void botaoAlterarDiretorioDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarDiretorioDocumentosActionPerformed
        campoDiretorioDocumentos.setEditable(true);
    }//GEN-LAST:event_botaoAlterarDiretorioDocumentosActionPerformed

    private void botaoAlterarDiretorioRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarDiretorioRelatoriosActionPerformed
        campoDiretorioRelatorios.setEditable(true);
    }//GEN-LAST:event_botaoAlterarDiretorioRelatoriosActionPerformed

    private void botaoSalvarDiretorioRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarDiretorioRelatoriosActionPerformed
        if(campoDiretorioRelatorios.getText().length() <= 0) {
           JOptionPane.showMessageDialog(null, "Informe o caminho do diretório de relátorios corretamente", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            Configuracao.getInstance().setDiretorioDeRelatorios(campoDiretorioRelatorios.getText());
        }
    }//GEN-LAST:event_botaoSalvarDiretorioRelatoriosActionPerformed

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
    
    public void adicionarNovoClienteNaTabela(Cliente cliente) {
        //Adiciona os dados do novo cliente na tabela
        modeloTabelaClientes.addRow(new Object[]{cliente.getCpf(), cliente.getNome(), cliente.getCelular(), cliente.getDataCadastroInString()});
    }
    
    public void adicionarNovoProdutoNaTabela(Produto produto) {
        //Adiciona os dados do novo produto na tabela
        modeloTabelaProdutos.addRow(new Object[]{produto.getCodigo(), produto.getDescricao(), "R$ "+produto.getValorInString(),
            produto.getQuantidade(), produto.getFinalidade()});
    }
    
    public void adicionarNovoFornecedorNaTabela(Fornecedor fornecedor) {
        //Adiciona os dados do novo fornecedor na tabela
        modeloTabelaFornecedores.addRow(new Object[]{fornecedor.getCnpj(), fornecedor.getNome(), fornecedor.getEndereco(), fornecedor.getTelefone()});
    }
    
    public void adicionarNovaLocacaoNaTabela(Locacao locacao) {
        try {
            //Adiciona os dados da nova locação na tabela
            modeloTabelaLocacoes.addRow(new Object[]{Long.toString(locacao.getId()), locacao.getCliente().getCpf(), locacao.getCliente().getNome(),
                GerenciadorDeLocacao.getInstance().getProdutosDeLocacaoInString(locacao.getId()),
                "R$ "+locacao.getValorLocacaoInString(), locacao.getVencimento()});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void adicionarNovaVendaNaTabela(Venda venda) {
        //Adiciona os dadosa nova venda na tabela
        modeloTabelaVendas.addRow(new Object[]{venda.getDataVendaInString(), venda.getProdutosVendidos(), "R$ "+venda.getValorInString(), venda.getFormaDePagamento()});

    }
    
    public void adicionarNovaMovimentacaoNaTabela(Movimentacao movimentacao) {
        //Adiciona os dados da nova movimentação na tabela
        modeloTabelaMovimentacoes.addRow(new Object[]{movimentacao.getMovimento(), "R$ "+movimentacao.getValorInString(), 
            movimentacao.getDataInString(), movimentacao.getResponsavel(), movimentacao.getBeneficiario()});
    }
    
    public void adicionarNovoUsuarioNaTabela(Usuario usuario) {
        //Adiciona os dados do novo usuário na tabela
        modeloTabelaUsuarios.addRow(new Object[]{usuario.getNome(), usuario.getNickName(), usuario.getCategoria()});
    }
    
    public void removerClienteDaTabela(int indice) {
        modeloTabelaClientes.removeRow(indice);
    }
    
    public void removerProdutoDaTabela(int indice) {
        modeloTabelaProdutos.removeRow(indice);
    }
    
    public void removerFornecedorDaTabela(int indice) {
        modeloTabelaFornecedores.removeRow(indice);
    }
    
    public void removerLocaoDaTabela(int indice) {
        modeloTabelaLocacoes.removeRow(indice);
    }
    
    public void removerVendaDaTabela(int indice) {
        modeloTabelaVendas.removeRow(indice);
    }
    
    public void removerMovimentacaoDaTabela(int indice) {
        modeloTabelaMovimentacoes.removeRow(indice);
    }
    
    public void removerUsuarioDaTabela(int indice) {
        modeloTabelaUsuarios.removeRow(indice);
    }
    
    public void atualizarDadosClienteNaTabela(Cliente cliente, int linha) {
        //Coluna de índice  1 = nome do cliente
        modeloTabelaClientes.setValueAt(cliente.getNome(), linha, 1); 
        //Coluna de índice  2 = contado
        modeloTabelaClientes.setValueAt(cliente.getCelular(), linha, 2);
    }
    
    public void atualizarDadosProdutoNaTabela(Produto produto, int linha) {
        //Coluna de descrição
        modeloTabelaProdutos.setValueAt(produto.getDescricao(), linha, 1);
        //Coluna de descrição
        modeloTabelaProdutos.setValueAt(produto.getValorInString(), linha, 2);
        //Coluna de descrição
        modeloTabelaProdutos.setValueAt(produto.getQuantidade(), linha, 3);
        //Coluna de descrição
        modeloTabelaProdutos.setValueAt(produto.getFinalidade(), linha, 4);
        
    }
    
    public void atualizarDadosFornecedorNaTabela(Fornecedor fornecedor, int linha) {
        //Coluna de nome
        modeloTabelaFornecedores.setValueAt(fornecedor.getNome(), linha, 1);
        //Coluna de endereo
        modeloTabelaFornecedores.setValueAt(fornecedor.getEnderecoInString(), linha, 2);
        //Coluna de índice telefone
        modeloTabelaFornecedores.setValueAt(fornecedor.getTelefone(), linha, 3);
    }
    
    public void atualizarDadosDespesaNaTabela(Movimentacao movimentacao, int linha) {
        //Coluna de valor
        modeloTabelaMovimentacoes.setValueAt(movimentacao.getValorInString(), linha, 2);
        //Coluna de valor
        modeloTabelaMovimentacoes.setValueAt(movimentacao.getResponsavel(), linha, 4);
        //Coluna de valor
        modeloTabelaMovimentacoes.setValueAt(movimentacao.getBeneficiario(), linha, 5);
    }
    
    public void atualizarDadosUsuarioNaTabela(Usuario usuario, int linha) {
        //Coluna de nome
        modeloTabelaUsuarios.setValueAt(usuario.getNome(), linha, 0);
        //Coluna de nome
        modeloTabelaUsuarios.setValueAt(usuario.getCategoria(), linha, 2);
    }
    
    public void atualizarValorEmCaixa() {
        double valorEmCaixa = GerenciadorDoSistema.getInstance().getValorCaixaDiario();
        if(valorEmCaixa > 0) {
            labelValorEmCaixa.setForeground(new Color(0, 153, 0));
        } else{
            labelValorEmCaixa.setForeground(new Color(255, 0, 0));
        }
        labelValorEmCaixa.setText("R$ "+new DecimalFormat("#.##").format(valorEmCaixa));
    }
    
    public void desabilitarCamposDeDiretorios() {
        campoDiretorioBackup.setEditable(false);
        campoDiretorioDocumentos.setEditable(false);
        campoDiretorioRelatorios.setEditable(false);
    }
    
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
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFrame().setVisible(true);
            }
        });
    }
    
    
    private DefaultTableModel modeloTabelaClientes;
    private DefaultTableModel modeloTabelaProdutos;
    private DefaultTableModel modeloTabelaFornecedores;
    private DefaultTableModel modeloTabelaLocacoes;
    private DefaultTableModel modeloTabelaVendas;
    private DefaultTableModel modeloTabelaMovimentacoes;
    private DefaultTableModel modeloTabelaUsuarios;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton botaoAlterarDiretorioBackup;
    private javax.swing.JButton botaoAlterarDiretorioDocumentos;
    private javax.swing.JButton botaoAlterarDiretorioRelatorios;
    private javax.swing.JButton botaoAtivarTemporada;
    private javax.swing.JButton botaoEditarCliente;
    private javax.swing.JButton botaoEditarDespesa;
    private javax.swing.JButton botaoEditarEmpresa;
    private javax.swing.JButton botaoEditarFornecedor;
    private javax.swing.JButton botaoEditarProduto;
    private javax.swing.JButton botaoEditarUsuario;
    private javax.swing.JButton botaoExcluirCliente;
    private javax.swing.JButton botaoExcluirDespesa;
    private javax.swing.JButton botaoExcluirFornecedor;
    private javax.swing.JButton botaoExcluirProduto;
    private javax.swing.JButton botaoExcluirUsuario;
    private javax.swing.JButton botaoExcluirVenda;
    private javax.swing.JButton botaoFecharCaixa;
    private javax.swing.JButton botaoFinalizarLocacao;
    private javax.swing.JButton botaoGerarReciboLocacao;
    private javax.swing.JButton botaoGerarReciboVenda;
    private javax.swing.JButton botaoGerarRelatorio;
    private javax.swing.JButton botaoNovaLocacao;
    private javax.swing.JButton botaoNovaVenda;
    private javax.swing.JButton botaoNovoCliente;
    private javax.swing.JButton botaoNovoFornecedor;
    private javax.swing.JButton botaoNovoProduto;
    private javax.swing.JButton botaoNovoUsuario;
    private javax.swing.JButton botaoPesquisarCliente;
    private javax.swing.JButton botaoPesquisarFornecedor;
    private javax.swing.JButton botaoPesquisarFornecedor1;
    private javax.swing.JButton botaoPesquisarLocacao;
    private javax.swing.JButton botaoPesquisarProduto;
    private javax.swing.JButton botaoPesquisarUsuario;
    private javax.swing.JButton botaoRegistrarDespesa;
    private javax.swing.JLabel botaoSair;
    private javax.swing.JButton botaoSalvarDiretorioBackup;
    private javax.swing.JButton botaoSalvarDiretorioDocumentos;
    private javax.swing.JButton botaoSalvarDiretorioRelatorios;
    private javax.swing.JButton botaoVerContrato;
    private javax.swing.JButton botaoVerLocacoesCliente;
    private javax.swing.JButton botaoVerRecibosLocacao;
    private javax.swing.JButton botaoVerRecibosVenda;
    private javax.swing.JTextField campoDiretorioBackup;
    private javax.swing.JTextField campoDiretorioDocumentos;
    private javax.swing.JTextField campoDiretorioRelatorios;
    private javax.swing.JTextField campoPesquisarCliente;
    private javax.swing.JTextField campoPesquisarFornecedor;
    private javax.swing.JTextField campoPesquisarLocacao;
    private javax.swing.JTextField campoPesquisarProduto;
    private javax.swing.JTextField campoPesquisarUsuario;
    private javax.swing.JTextField campoPesquisarVenda;
    private javax.swing.JComboBox comboBoxOrdenarCaixaEMovimentacao;
    private javax.swing.JComboBox comboBoxOrdenarCliente1;
    private javax.swing.JComboBox comboBoxOrdenarFornecedores;
    private javax.swing.JComboBox comboBoxOrdenarFornecedores1;
    private javax.swing.JComboBox comboBoxOrdenarProdutos;
    private javax.swing.JComboBox comboBoxUsuario;
    private javax.swing.JComboBox comboFiltrarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelDiretorioBackups;
    private javax.swing.JLabel labelDiretorioDocumentos;
    private javax.swing.JLabel labelFiltrarClientes;
    private javax.swing.JLabel labelFiltrarFornecedores;
    private javax.swing.JLabel labelFiltrarLocacoes;
    private javax.swing.JLabel labelFiltrarMovimentacao;
    private javax.swing.JLabel labelFiltrarProdutos;
    private javax.swing.JLabel labelFiltrarUsuario;
    private javax.swing.JLabel labelFiltrarVenda;
    private javax.swing.JLabel labelLoginUsuario;
    private javax.swing.JLabel labelLogoEmpresa;
    private javax.swing.JLabel labelValorCaixa;
    private javax.swing.JLabel labelValorEmCaixa;
    private javax.swing.JPanel painelAdministrador;
    private javax.swing.JPanel painelCaixaERelatorios;
    private javax.swing.JPanel painelClientes;
    private javax.swing.JPanel painelConfiguracoes;
    private javax.swing.JPanel painelFornecedores;
    private javax.swing.JPanel painelGeral;
    private javax.swing.JPanel painelLocacoes;
    private javax.swing.JPanel painelProdutos;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JPanel painelVendas;
    private javax.swing.JScrollPane pnRlCaixaERelatorios;
    private javax.swing.JScrollPane pnRlCliente;
    private javax.swing.JScrollPane pnRlFornecedores;
    private javax.swing.JScrollPane pnRlLocacoes;
    private javax.swing.JScrollPane pnRlProduto;
    private javax.swing.JScrollPane pnRlUsuario;
    private javax.swing.JScrollPane pnRlVendas;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTable tabelaFornecedores;
    private javax.swing.JTable tabelaLocacoes;
    private javax.swing.JTable tabelaMovimentacoes;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTable tabelaUsuarios;
    private javax.swing.JTable tabelaVendas;
    // End of variables declaration//GEN-END:variables
}
