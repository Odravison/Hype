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
import br.oltecnologias.hype.model.Empresa;
import br.oltecnologias.hype.model.Fornecedor;
import br.oltecnologias.hype.model.GeradorDeRecibo;
import br.oltecnologias.hype.model.Locacao;
import br.oltecnologias.hype.model.Movimentacao;
import br.oltecnologias.hype.model.Produto;
import br.oltecnologias.hype.model.Usuario;
import br.oltecnologias.hype.model.Venda;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luender Lima
 */
public class PrincipalFrame extends javax.swing.JFrame {

    public PrincipalFrame(String login) {
        loginUsuario = login;
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    public PrincipalFrame(String login, LoginFrame loginFrame) {
        loginUsuario = login;
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
        loginFrame.fecharThreadDeCarregamento();
        loginFrame.setVisible(false);
        loginFrame.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelGeral = new javax.swing.JPanel();
        painelTopo = new javax.swing.JPanel();
        labelLogoEmpresa = new javax.swing.JLabel();
        labelLoginUsuario = new javax.swing.JLabel();
        botaoSair = new javax.swing.JLabel();
        labelLogoCloset = new javax.swing.JLabel();
        abas = new javax.swing.JTabbedPane();
        painelClientes = new javax.swing.JPanel();
        botaoNovoCliente = new javax.swing.JButton();
        botaoPesquisarCliente = new javax.swing.JButton();
        campoPesquisarClientes = new javax.swing.JTextField();
        comboFiltrarClientes = new javax.swing.JComboBox();
        pnRlCliente = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        labelFiltrarClientes = new javax.swing.JLabel();
        botaoEditarCliente = new javax.swing.JButton();
        botaoExcluirCliente = new javax.swing.JButton();
        botaoVerLocacoesCliente = new javax.swing.JButton();
        painelProdutos = new javax.swing.JPanel();
        botaoNovoProduto = new javax.swing.JButton();
        botaoPesquisarProduto = new javax.swing.JButton();
        campoPesquisarProdutos = new javax.swing.JTextField();
        pnRlProduto = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        labelFiltrarProdutos = new javax.swing.JLabel();
        comboFiltrarProdutos = new javax.swing.JComboBox();
        botaoEditarProduto = new javax.swing.JButton();
        botaoExcluirProduto = new javax.swing.JButton();
        radioPesquisarProdutoCodigo = new javax.swing.JRadioButton();
        radioPesquisarProdutoNome = new javax.swing.JRadioButton();
        botaoConsultarDisponibilidade = new javax.swing.JButton();
        painelFornecedores = new javax.swing.JPanel();
        botaoNovoFornecedor = new javax.swing.JButton();
        botaoPesquisarFornecedor = new javax.swing.JButton();
        campoPesquisarFornecedores = new javax.swing.JTextField();
        pnRlFornecedores = new javax.swing.JScrollPane();
        tabelaFornecedores = new javax.swing.JTable();
        botaoEditarFornecedor = new javax.swing.JButton();
        botaoExcluirFornecedor = new javax.swing.JButton();
        comboFiltrarFornecedores = new javax.swing.JComboBox();
        labelFiltrarFornecedores = new javax.swing.JLabel();
        painelLocacoes = new javax.swing.JPanel();
        botaoNovaLocacao = new javax.swing.JButton();
        botaoPesquisarLocacao = new javax.swing.JButton();
        campoPesquisarLocacoes = new javax.swing.JTextField();
        pnRlLocacoes = new javax.swing.JScrollPane();
        tabelaLocacoes = new javax.swing.JTable();
        labelFiltrarLocacoes = new javax.swing.JLabel();
        comboFiltrarLocacoes = new javax.swing.JComboBox();
        botaoVerContrato = new javax.swing.JButton();
        botaoFinalizarLocacao = new javax.swing.JButton();
        botaoGerarReciboLocacao = new javax.swing.JButton();
        botaoVerRecibosLocacao = new javax.swing.JButton();
        painelVendas = new javax.swing.JPanel();
        botaoNovaVenda = new javax.swing.JButton();
        botaoPesquisarVendas = new javax.swing.JButton();
        campoPesquisarVendas = new javax.swing.JTextField();
        comboFiltrarVendas = new javax.swing.JComboBox();
        pnRlVendas = new javax.swing.JScrollPane();
        tabelaVendas = new javax.swing.JTable();
        labelFiltrarVenda = new javax.swing.JLabel();
        botaoVerRecibosVenda = new javax.swing.JButton();
        painelCaixaERelatorios = new javax.swing.JPanel();
        botaoGerarRelatorio = new javax.swing.JButton();
        pnRlCaixaERelatorios = new javax.swing.JScrollPane();
        tabelaMovimentacoes = new javax.swing.JTable();
        labelFiltrarMovimentacao = new javax.swing.JLabel();
        labelValorCaixa = new javax.swing.JLabel();
        comboFiltrarMovimentacoes = new javax.swing.JComboBox();
        botaoExcluirDespesa = new javax.swing.JButton();
        labelValorEmCaixa = new javax.swing.JLabel();
        botaoEditarDespesa = new javax.swing.JButton();
        botaoRegistrarDespesa = new javax.swing.JButton();
        painelConfiguracoes = new javax.swing.JPanel();
        botaoSalvarDiretorioBackup = new javax.swing.JButton();
        campoDiretorioBackup = new javax.swing.JTextField();
        labelDiretorioBackups = new javax.swing.JLabel();
        botaoSalvarDiretorioDocumentos = new javax.swing.JButton();
        campoDiretorioDocumentos = new javax.swing.JTextField();
        labelDiretorioDocumentos = new javax.swing.JLabel();
        botaoAlterarDiretorioBackup = new javax.swing.JButton();
        botaoAlterarDiretorioDocumentos = new javax.swing.JButton();
        labelDiretorioRelatorios = new javax.swing.JLabel();
        botaoAlterarDiretorioRelatorios = new javax.swing.JButton();
        botaoSalvarDiretorioRelatorios = new javax.swing.JButton();
        campoDiretorioRelatorios = new javax.swing.JTextField();
        campoNomeImpressora = new javax.swing.JTextField();
        labelNomeImpressora = new javax.swing.JLabel();
        botaoAlterarNomeImpressora = new javax.swing.JButton();
        botaoSalvarNomeImpressora = new javax.swing.JButton();
        painelAdministrador = new javax.swing.JPanel();
        botaoNovoUsuario = new javax.swing.JButton();
        botaoPesquisarUsuario = new javax.swing.JButton();
        campoPesquisarUsuarios = new javax.swing.JTextField();
        pnRlUsuario = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        botaoAtivarTemporada = new javax.swing.JButton();
        botaoExcluirUsuario = new javax.swing.JButton();
        botaoEditarUsuario = new javax.swing.JButton();
        botaoEditarEmpresa = new javax.swing.JButton();
        comboFiltrarUsuarios = new javax.swing.JComboBox();
        labelFiltrarUsuarios = new javax.swing.JLabel();
        botaoGerirValores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Closet");
        setResizable(false);

        painelGeral.setBackground(new java.awt.Color(255, 255, 255));
        painelGeral.setPreferredSize(new java.awt.Dimension(1366, 700));

        painelTopo.setBackground(new java.awt.Color(255, 255, 255));

        labelLogoEmpresa.setIcon(new ImageIcon("Imagens\\Mini Logo Empresa.png"));
        labelLogoEmpresa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelLogoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Mini logo Empresa.png"))); // NOI18N

        labelLoginUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelLoginUsuario.setText("Logado com "+loginUsuario);

        botaoSair.setIcon(new ImageIcon("Imagens\\Sair do sistema.png"));
        botaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Sair do sistema.png"))); // NOI18N
        botaoSair.setToolTipText("Sair do Sistema");
        botaoSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoSairMouseClicked(evt);
            }
        });

        labelLogoCloset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Mini logo Closet.png"))); // NOI18N
        labelLogoCloset.setToolTipText("Trocar de usuário");
        labelLogoCloset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLogoCloset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLogoClosetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTopoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelLogoEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 947, Short.MAX_VALUE)
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTopoLayout.createSequentialGroup()
                        .addComponent(labelLoginUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSair)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTopoLayout.createSequentialGroup()
                        .addComponent(labelLogoCloset)
                        .addGap(39, 39, 39))))
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addComponent(labelLogoEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(8, 8, 8))
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogoCloset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLoginUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoSair, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        abas.setBackground(new java.awt.Color(255, 255, 255));
        abas.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(153, 153, 153)));
        abas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        abas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        abas.setPreferredSize(new java.awt.Dimension(1346, 635));

        painelClientes.setBackground(new java.awt.Color(255, 255, 255));
        painelClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelClientes.setPreferredSize(new java.awt.Dimension(1311, 700));
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

        campoPesquisarClientes.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        campoPesquisarClientes.setForeground(new java.awt.Color(153, 153, 153));
        campoPesquisarClientes.setText("Pesquisar Cliente");
        campoPesquisarClientes.setToolTipText("Pesquise clientes pelo CPF ou pelo nome");
        campoPesquisarClientes.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        campoPesquisarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoPesquisarClientesMouseClicked(evt);
            }
        });
        campoPesquisarClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPesquisarClientesKeyTyped(evt);
            }
        });

        comboFiltrarClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFiltrarClientes.setMaximumRowCount(2);
        comboFiltrarClientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Últimos locatários" }));
        comboFiltrarClientes.setToolTipText("Selecionar tipo de filtro");
        comboFiltrarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboFiltrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltrarClientesActionPerformed(evt);
            }
        });

        pnRlCliente.setBackground(new java.awt.Color(255, 255, 255));
        pnRlCliente.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnRlCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnRlCliente.setPreferredSize(new java.awt.Dimension(826, 340));

        tabelaClientes.setAutoCreateRowSorter(true);
        tabelaClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelaClientes.getTableHeader().setResizingAllowed(false);
        tabelaClientes.getTableHeader().setReorderingAllowed(false);
        String[] nomesColunasTabelaClientes = {"CPF", "Nome do Cliente", "Contato", "Cadastrado em"};
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
        tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(390);
        // Redimensionando a largura da coluna de número do celular
        tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(150);
        // Redimensionando a largura da coluna de data de cadastro
        tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(140);
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
                        .addComponent(campoPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoPesquisarCliente))
                    .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelClientesLayout.createSequentialGroup()
                            .addComponent(labelFiltrarClientes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboFiltrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoVerLocacoesCliente)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botaoEditarCliente)
                            .addGap(4, 4, 4)
                            .addComponent(botaoExcluirCliente))
                        .addComponent(pnRlCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(479, Short.MAX_VALUE))
        );
        painelClientesLayout.setVerticalGroup(
            painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClientesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(botaoNovoCliente)
                .addGap(50, 50, 50)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisarCliente))
                .addGap(36, 36, 36)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoEditarCliente)
                        .addComponent(botaoExcluirCliente)
                        .addComponent(botaoVerLocacoesCliente))
                    .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelFiltrarClientes)
                        .addComponent(comboFiltrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnRlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
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
        botaoPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarProdutoActionPerformed(evt);
            }
        });

        campoPesquisarProdutos.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        campoPesquisarProdutos.setForeground(new java.awt.Color(153, 153, 153));
        campoPesquisarProdutos.setText("Pesquisar Produto");
        campoPesquisarProdutos.setToolTipText("Pesquise produtos pelo código ou pelo nome");
        campoPesquisarProdutos.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        campoPesquisarProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoPesquisarProdutosMouseClicked(evt);
            }
        });
        campoPesquisarProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPesquisarProdutosKeyTyped(evt);
            }
        });

        pnRlProduto.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnRlProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnRlProduto.setPreferredSize(new java.awt.Dimension(1176, 340));

        tabelaProdutos.setAutoCreateRowSorter(true);
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
        for (Produto produto : GerenciadorDeProduto.getInstance().getProdutosDisponiveisEntreDatas(Calendar.getInstance(), Calendar.getInstance())) {
            listaLinhasProdutos.add(new Object[]{produto.getCodigo(), produto.getDescricao(), "R$ "+produto.getValorInString(),
                produto.getQuantidade(), produto.getFinalidade()});
    }
    for (Produto produto : GerenciadorDeProduto.getInstance().getProdutosDeVenda()) {
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
    tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(730);
    // Redimensionando a largura da coluna de valor
    tabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(90);
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

    comboFiltrarProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comboFiltrarProdutos.setMaximumRowCount(6);
    comboFiltrarProdutos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Produtos de locação", "Produtos de venda", "Para Ajuste", "Últimos locados", "Últimos vendidos" }));
    comboFiltrarProdutos.setToolTipText("Selecionar tipo de filtro");
    comboFiltrarProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    comboFiltrarProdutos.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboFiltrarProdutosActionPerformed(evt);
        }
    });

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

    radioPesquisarProdutoCodigo.setBackground(new java.awt.Color(255, 255, 255));
    radioPesquisarProdutoCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    radioPesquisarProdutoCodigo.setText("Código");
    radioPesquisarProdutoCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    radioPesquisarProdutoCodigo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            radioPesquisarProdutoCodigoActionPerformed(evt);
        }
    });

    radioPesquisarProdutoNome.setBackground(new java.awt.Color(255, 255, 255));
    radioPesquisarProdutoNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    radioPesquisarProdutoNome.setSelected(true);
    radioPesquisarProdutoNome.setText("Nome");
    radioPesquisarProdutoNome.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            radioPesquisarProdutoNomeActionPerformed(evt);
        }
    });

    botaoConsultarDisponibilidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoConsultarDisponibilidade.setText("Consultar Disponibilidade");
    botaoConsultarDisponibilidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoConsultarDisponibilidade.setVisible(false);
    botaoConsultarDisponibilidade.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoConsultarDisponibilidadeActionPerformed(evt);
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
                .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelProdutosLayout.createSequentialGroup()
                        .addComponent(labelFiltrarProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFiltrarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoConsultarDisponibilidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoEditarProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluirProduto))
                    .addComponent(pnRlProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelProdutosLayout.createSequentialGroup()
                    .addComponent(campoPesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelProdutosLayout.createSequentialGroup()
                            .addComponent(radioPesquisarProdutoCodigo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(radioPesquisarProdutoNome))
                        .addComponent(botaoPesquisarProduto))))
            .addContainerGap(129, Short.MAX_VALUE))
    );
    painelProdutosLayout.setVerticalGroup(
        painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelProdutosLayout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(botaoNovoProduto)
            .addGap(50, 50, 50)
            .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoPesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoPesquisarProduto))
            .addGap(10, 10, 10)
            .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(radioPesquisarProdutoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(radioPesquisarProdutoNome))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(painelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelFiltrarProdutos)
                .addComponent(comboFiltrarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoEditarProduto)
                .addComponent(botaoExcluirProduto)
                .addComponent(botaoConsultarDisponibilidade))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
    botaoPesquisarFornecedor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoPesquisarFornecedorActionPerformed(evt);
        }
    });

    campoPesquisarFornecedores.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
    campoPesquisarFornecedores.setForeground(new java.awt.Color(153, 153, 153));
    campoPesquisarFornecedores.setText("Pesquisar Fornecedor");
    campoPesquisarFornecedores.setToolTipText("Pesquise fornecedores pelo CNPJ ou pelo nome");
    campoPesquisarFornecedores.setDisabledTextColor(new java.awt.Color(204, 204, 204));
    campoPesquisarFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            campoPesquisarFornecedoresMouseClicked(evt);
        }
    });
    campoPesquisarFornecedores.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            campoPesquisarFornecedoresKeyTyped(evt);
        }
    });

    pnRlFornecedores.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    pnRlFornecedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    pnRlFornecedores.setPreferredSize(new java.awt.Dimension(1136, 340));

    tabelaFornecedores.setAutoCreateRowSorter(true);
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
        listaLinhasFornecedores.toArray(new Object[listaLinhasFornecedores.size()][]), nomesColunasTabelaFornecedores){

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

    tabelaFornecedores.getRowSorter().toggleSortOrder(1);
    tabelaFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaFornecedoresMouseClicked(evt);
        }
    });
    pnRlFornecedores.setViewportView(tabelaFornecedores);

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

    comboFiltrarFornecedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comboFiltrarFornecedores.setMaximumRowCount(1);
    comboFiltrarFornecedores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));
    comboFiltrarFornecedores.setToolTipText("Selecionar tipo de filtro");
    comboFiltrarFornecedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    comboFiltrarFornecedores.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboFiltrarFornecedoresActionPerformed(evt);
        }
    });

    labelFiltrarFornecedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelFiltrarFornecedores.setText("Filtrar por:");

    javax.swing.GroupLayout painelFornecedoresLayout = new javax.swing.GroupLayout(painelFornecedores);
    painelFornecedores.setLayout(painelFornecedoresLayout);
    painelFornecedoresLayout.setHorizontalGroup(
        painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelFornecedoresLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoNovoFornecedor)
                .addGroup(painelFornecedoresLayout.createSequentialGroup()
                    .addComponent(campoPesquisarFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(botaoPesquisarFornecedor))
                .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelFornecedoresLayout.createSequentialGroup()
                        .addComponent(labelFiltrarFornecedores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFiltrarFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoEditarFornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluirFornecedor))
                    .addComponent(pnRlFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(169, Short.MAX_VALUE))
    );
    painelFornecedoresLayout.setVerticalGroup(
        painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelFornecedoresLayout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(botaoNovoFornecedor)
            .addGap(50, 50, 50)
            .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoPesquisarFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoPesquisarFornecedor))
            .addGap(36, 36, 36)
            .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFiltrarFornecedores)
                    .addComponent(comboFiltrarFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEditarFornecedor)
                    .addComponent(botaoExcluirFornecedor)))
            .addGap(18, 18, 18)
            .addComponent(pnRlFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18))
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
    botaoPesquisarLocacao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoPesquisarLocacaoActionPerformed(evt);
        }
    });

    campoPesquisarLocacoes.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
    campoPesquisarLocacoes.setForeground(new java.awt.Color(153, 153, 153));
    campoPesquisarLocacoes.setText("Pesquisar Locação");
    campoPesquisarLocacoes.setToolTipText("Pesquise locações pela data no formato: dd/mm/aaa");
    campoPesquisarLocacoes.setDisabledTextColor(new java.awt.Color(204, 204, 204));
    campoPesquisarLocacoes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            campoPesquisarLocacoesMouseClicked(evt);
        }
    });
    campoPesquisarLocacoes.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            campoPesquisarLocacoesKeyTyped(evt);
        }
    });

    pnRlLocacoes.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    pnRlLocacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    pnRlLocacoes.setPreferredSize(new java.awt.Dimension(1286, 340));

    tabelaLocacoes.setAutoCreateRowSorter(true);
    tabelaLocacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabelaLocacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tabelaLocacoes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    tabelaLocacoes.getTableHeader().setResizingAllowed(false);
    tabelaLocacoes.getTableHeader().setReorderingAllowed(false);
    //Define a fonte do cabeçalho da tabela fornecedores
    tabelaLocacoes.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 15));
    // Altura das linhas
    tabelaLocacoes.setRowHeight(25);

    String[] nomesColunasTabelaLocacoes = {"CPF Cliente", "Cliente", "Produtos Locados", "Valor Total", "Início","Devolução", "Status", ""};
    //Essa lista terá as linhas da tabela
    List<Object[]> listaLinhasLocacoes = new ArrayList<>();
    //Adicionando valores nas linhas
    for (Locacao locacao : GerenciadorDeLocacao.getInstance().getLocacoes()) {
        try {
            listaLinhasLocacoes.add(new Object[]{locacao.getCliente().getCpf(), locacao.getCliente().getNome(),
                GerenciadorDeLocacao.getInstance().getProdutosDeLocacaoInString(locacao.getId()),
                "R$ " + locacao.getValorLocacaoInString(), locacao.getDataLocacaoInString(), locacao.getDataDevolucaoInString(), locacao.getStatus(), Long.toString(locacao.getId())});
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro na hora de buscar os dados da locação", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    }
    //cria um defaultablemodel com as informações acima
    modeloTabelaLocacoes = new DefaultTableModel(
        listaLinhasLocacoes.toArray(new Object[listaLinhasLocacoes.size()][]), nomesColunasTabelaLocacoes){

        boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false, false};

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
        }

    };

    //define o model da tabela
    tabelaLocacoes.setModel(modeloTabelaLocacoes);
    // Redimensionando a largura da coluna de CPF do cliente
    tabelaLocacoes.getColumnModel().getColumn(0).setPreferredWidth(115);
    // Redimensionando a largura da coluna de nome do cliente
    tabelaLocacoes.getColumnModel().getColumn(1).setPreferredWidth(250);
    // Redimensionando a largura da coluna de produtos locados
    tabelaLocacoes.getColumnModel().getColumn(2).setPreferredWidth(585);
    // Redimensionando a largura da coluna de valor total
    tabelaLocacoes.getColumnModel().getColumn(3).setPreferredWidth(82);
    // Redimensionando a largura da coluna de data de início
    tabelaLocacoes.getColumnModel().getColumn(4).setPreferredWidth(85);
    // Redimensionando a largura da coluna de data de devolução
    tabelaLocacoes.getColumnModel().getColumn(5).setPreferredWidth(85);
    // Redimensionando a largura da coluna status
    tabelaLocacoes.getColumnModel().getColumn(6).setPreferredWidth(80);
    // Redimensionando a largura da coluna id da locação
    tabelaLocacoes.getColumnModel().getColumn(7).setPreferredWidth(0);
    tabelaLocacoes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaLocacoesMouseClicked(evt);
        }
    });
    pnRlLocacoes.setViewportView(tabelaLocacoes);

    labelFiltrarLocacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelFiltrarLocacoes.setText("Filtrar por:");

    comboFiltrarLocacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comboFiltrarLocacoes.setMaximumRowCount(6);
    comboFiltrarLocacoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Ativas", "Atrasadas", "Extraviadas", "Mais Recentes", "Mais Antigas" }));
    comboFiltrarLocacoes.setToolTipText("Selecionar tipo de filtro");
    comboFiltrarLocacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    comboFiltrarLocacoes.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboFiltrarLocacoesActionPerformed(evt);
        }
    });

    botaoVerContrato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoVerContrato.setText("Ver Contrato");
    botaoVerContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoVerContrato.setVisible(false);
    botaoVerContrato.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoVerContratoActionPerformed(evt);
        }
    });

    botaoFinalizarLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoFinalizarLocacao.setText("Finalizar Locação");
    botaoFinalizarLocacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoFinalizarLocacao.setVisible(false);
    botaoFinalizarLocacao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoFinalizarLocacaoActionPerformed(evt);
        }
    });

    botaoGerarReciboLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoGerarReciboLocacao.setText("Gerar Recibo");
    botaoGerarReciboLocacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoGerarReciboLocacao.setVisible(false);
    botaoGerarReciboLocacao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoGerarReciboLocacaoActionPerformed(evt);
        }
    });

    botaoVerRecibosLocacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoVerRecibosLocacao.setText("Ver Recibos");
    botaoVerRecibosLocacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoVerRecibosLocacao.setVisible(false);
    botaoVerRecibosLocacao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoVerRecibosLocacaoActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout painelLocacoesLayout = new javax.swing.GroupLayout(painelLocacoes);
    painelLocacoes.setLayout(painelLocacoesLayout);
    painelLocacoesLayout.setHorizontalGroup(
        painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelLocacoesLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoNovaLocacao)
                .addGroup(painelLocacoesLayout.createSequentialGroup()
                    .addComponent(campoPesquisarLocacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(botaoPesquisarLocacao))
                .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLocacoesLayout.createSequentialGroup()
                        .addComponent(labelFiltrarLocacoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFiltrarLocacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoFinalizarLocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoGerarReciboLocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVerRecibosLocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVerContrato))
                    .addComponent(pnRlLocacoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(19, Short.MAX_VALUE))
    );
    painelLocacoesLayout.setVerticalGroup(
        painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelLocacoesLayout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(botaoNovaLocacao)
            .addGap(49, 49, 49)
            .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoPesquisarLocacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoPesquisarLocacao))
            .addGap(36, 36, 36)
            .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLocacoesLayout.createSequentialGroup()
                    .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelFiltrarLocacoes)
                        .addComponent(comboFiltrarLocacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(pnRlLocacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelLocacoesLayout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelLocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoVerRecibosLocacao)
                            .addComponent(botaoGerarReciboLocacao)
                            .addComponent(botaoFinalizarLocacao))
                        .addComponent(botaoVerContrato))))
            .addGap(18, 18, 18))
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

    botaoPesquisarVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoPesquisarVendas.setText("Pesquisar");
    botaoPesquisarVendas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoPesquisarVendas.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoPesquisarVendasActionPerformed(evt);
        }
    });

    campoPesquisarVendas.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
    campoPesquisarVendas.setForeground(new java.awt.Color(153, 153, 153));
    campoPesquisarVendas.setText("Pesquisar Venda");
    campoPesquisarVendas.setToolTipText("Pesquise vendas pela data no formato: dd/mm/aaaa");
    campoPesquisarVendas.setDisabledTextColor(new java.awt.Color(204, 204, 204));
    campoPesquisarVendas.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            campoPesquisarVendasMouseClicked(evt);
        }
    });
    campoPesquisarVendas.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            campoPesquisarVendasKeyTyped(evt);
        }
    });

    comboFiltrarVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comboFiltrarVendas.setMaximumRowCount(2);
    comboFiltrarVendas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Mais Recentes" }));
    comboFiltrarVendas.setToolTipText("Selecionar tipo de filtro");
    comboFiltrarVendas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    comboFiltrarVendas.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboFiltrarVendasActionPerformed(evt);
        }
    });

    pnRlVendas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    pnRlVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    pnRlVendas.setPreferredSize(new java.awt.Dimension(1286, 340));

    tabelaVendas.setAutoCreateRowSorter(true);
    tabelaVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabelaVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tabelaVendas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    tabelaVendas.getTableHeader().setResizingAllowed(false);
    tabelaVendas.getTableHeader().setReorderingAllowed(false);
    String[] nomesColunasTabelaVendas = {"Data da Venda", "Produtos Vendidos", "Valor Total", "Forma de pagamento", ""};
    //Define a fonte do cabeçalho da tabela
    tabelaVendas.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 15));
    //Altura das linhas
    tabelaVendas.setRowHeight(25);

    //Lista que terá as linhas da tabela
    List<Object[]> listaLinhasVendas = new ArrayList<>();
    try {
        //Adicionando valores nas linhas
        for (Venda venda : GerenciadorDeVenda.getInstance().getVendas()) {
            listaLinhasVendas.add(new Object[]{venda.getDataVendaInString(), GerenciadorDeVenda.getInstance().getProdutosDeVendaInString(venda.getId()), "R$ "+venda.getValorInString(), venda.getFormaDePagamento(), Long.toString(venda.getId())});
        }
    } catch(Exception e) {
        e.getMessage();
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

    // Redimensionando a largura da coluna data da venda
    tabelaVendas.getColumnModel().getColumn(0).setPreferredWidth(120);
    // Redimensionando a largura da coluna de produtos vendidos
    tabelaVendas.getColumnModel().getColumn(1).setPreferredWidth(900);
    // Redimensionando a largura da coluna de valor total
    tabelaVendas.getColumnModel().getColumn(2).setPreferredWidth(95);
    // Redimensionando a largura da coluna de forma de pagamento
    tabelaVendas.getColumnModel().getColumn(3).setPreferredWidth(165);
    // Redimensionando a largura da coluna id da venda
    tabelaVendas.getColumnModel().getColumn(4).setPreferredWidth(0);
    tabelaVendas.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaVendasMouseClicked(evt);
        }
    });
    pnRlVendas.setViewportView(tabelaVendas);

    labelFiltrarVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelFiltrarVenda.setText("Filtrar por:");

    botaoVerRecibosVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoVerRecibosVenda.setText("Ver Recibo");
    botaoVerRecibosVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoVerRecibosVenda.setVisible(false);
    botaoVerRecibosVenda.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoVerRecibosVendaActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout painelVendasLayout = new javax.swing.GroupLayout(painelVendas);
    painelVendas.setLayout(painelVendasLayout);
    painelVendasLayout.setHorizontalGroup(
        painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelVendasLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoNovaVenda)
                .addGroup(painelVendasLayout.createSequentialGroup()
                    .addComponent(campoPesquisarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(botaoPesquisarVendas))
                .addGroup(painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelVendasLayout.createSequentialGroup()
                        .addComponent(labelFiltrarVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFiltrarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoVerRecibosVenda))
                    .addComponent(pnRlVendas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(19, Short.MAX_VALUE))
    );
    painelVendasLayout.setVerticalGroup(
        painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelVendasLayout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(botaoNovaVenda)
            .addGap(50, 50, 50)
            .addGroup(painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoPesquisarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botaoPesquisarVendas))
            .addGap(36, 36, 36)
            .addGroup(painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoVerRecibosVenda)
                .addGroup(painelVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFiltrarVenda)
                    .addComponent(comboFiltrarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(pnRlVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18))
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

    pnRlCaixaERelatorios.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    pnRlCaixaERelatorios.setPreferredSize(new java.awt.Dimension(947, 359));

    tabelaMovimentacoes.setAutoCreateRowSorter(true);
    tabelaMovimentacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabelaMovimentacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tabelaMovimentacoes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    tabelaMovimentacoes.getTableHeader().setResizingAllowed(false);
    tabelaMovimentacoes.getTableHeader().setReorderingAllowed(false);
    String[] nomesColunasTabelaMovimentacoes = { "Movimento", "Valor", "Data", "Responsável", "Beneficiário", ""};
    //Define a fonte do cabeçalho da tabela
    tabelaMovimentacoes.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 15));
    //Altura das linhas
    tabelaMovimentacoes.setRowHeight(25);

    //Lista que terá as linhas da tabela
    List<Object[]> listaLinhasMovimentacoes = new ArrayList<>();

    //Adicionando valores nas linhas
    for (Movimentacao movimentacao : GerenciadorDoSistema.getInstance().getMovimentacoes()) {
        listaLinhasMovimentacoes.add(new Object[]{movimentacao.getMovimento(), "R$ "+movimentacao.getValorInString(),
            movimentacao.getDataInString(), movimentacao.getResponsavel(), movimentacao.getBeneficiario(), Long.toString(movimentacao.getIdDaOperacao())});
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
    tabelaMovimentacoes.getColumnModel().getColumn(0).setPreferredWidth(130);
    // Redimensionando a largura da coluna de valor
    tabelaMovimentacoes.getColumnModel().getColumn(1).setPreferredWidth(110);
    // Redimensionando a largura da coluna de data
    tabelaMovimentacoes.getColumnModel().getColumn(2).setPreferredWidth(110);
    // Redimensionando a largura da coluna de responsável
    tabelaMovimentacoes.getColumnModel().getColumn(3).setPreferredWidth(340);
    // Redimensionando a largura da coluna de beneficiário
    tabelaMovimentacoes.getColumnModel().getColumn(4).setPreferredWidth(250);
    // Redimensionando a largura da coluna de id
    tabelaMovimentacoes.getColumnModel().getColumn(5).setPreferredWidth(0);
    tabelaMovimentacoes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaMovimentacoesMouseClicked(evt);
        }
    });
    pnRlCaixaERelatorios.setViewportView(tabelaMovimentacoes);

    labelFiltrarMovimentacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelFiltrarMovimentacao.setText("Filtrar por:");

    labelValorCaixa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    labelValorCaixa.setText("Apurado:");

    comboFiltrarMovimentacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comboFiltrarMovimentacoes.setMaximumRowCount(5);
    comboFiltrarMovimentacoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Vendas", "Locações", "Despesas", "Pendências" }));
    comboFiltrarMovimentacoes.setToolTipText("Selecionar tipo de filtro");
    comboFiltrarMovimentacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    comboFiltrarMovimentacoes.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboFiltrarMovimentacoesActionPerformed(evt);
        }
    });

    botaoExcluirDespesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoExcluirDespesa.setText("Excluir Despesa");
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

    botaoRegistrarDespesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoRegistrarDespesa.setText("Registrar Despesa");
    botaoRegistrarDespesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoRegistrarDespesa.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoRegistrarDespesaActionPerformed(evt);
        }
    });

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
                            .addComponent(comboFiltrarMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoEditarDespesa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botaoExcluirDespesa))
                        .addComponent(pnRlCaixaERelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(358, Short.MAX_VALUE))
                .addGroup(painelCaixaERelatoriosLayout.createSequentialGroup()
                    .addComponent(botaoGerarRelatorio)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(botaoRegistrarDespesa)
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
                        .addComponent(botaoRegistrarDespesa)))
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
                    .addComponent(comboFiltrarMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(pnRlCaixaERelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(37, Short.MAX_VALUE))
    );

    atualizarValorEmCaixa();

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
    botaoSalvarDiretorioBackup.setEnabled(false);
    botaoSalvarDiretorioBackup.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSalvarDiretorioBackupActionPerformed(evt);
        }
    });

    campoDiretorioBackup.setEditable(false);
    campoDiretorioBackup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

    labelDiretorioBackups.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelDiretorioBackups.setText("Diretório de backups");

    botaoSalvarDiretorioDocumentos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botaoSalvarDiretorioDocumentos.setText(" Salvar ");
    botaoSalvarDiretorioDocumentos.setToolTipText("Salvar diretório");
    botaoSalvarDiretorioDocumentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    botaoSalvarDiretorioDocumentos.setEnabled(false);
    botaoSalvarDiretorioDocumentos.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSalvarDiretorioDocumentosActionPerformed(evt);
        }
    });

    campoDiretorioDocumentos.setEditable(false);
    campoDiretorioDocumentos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

    labelDiretorioRelatorios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelDiretorioRelatorios.setText("Diretório de Relatórios");

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
    botaoSalvarDiretorioRelatorios.setEnabled(false);
    botaoSalvarDiretorioRelatorios.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSalvarDiretorioRelatoriosActionPerformed(evt);
        }
    });

    campoDiretorioRelatorios.setEditable(false);
    campoDiretorioRelatorios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

    campoNomeImpressora.setEditable(false);
    campoNomeImpressora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    campoNomeImpressora.setToolTipText("Informe o caminho do diretório");
    campoNomeImpressora.setDisabledTextColor(new java.awt.Color(204, 204, 204));
    campoNomeImpressora.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            campoNomeImpressoraMouseClicked(evt);
        }
    });
    campoNomeImpressora.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            campoNomeImpressoraKeyTyped(evt);
        }
    });
    Configuracao configuracao = GerenciadorDoSistema.getInstance().getConfiguracao();
    if(configuracao.getDiretorioDeRelatorios() != null) {
        campoDiretorioRelatorios.setText(configuracao.getDiretorioDeRelatorios().replace("\\\\", "\\"));
        }
        if(configuracao.getDiretorioDeDocumentos() != null) {
            campoDiretorioDocumentos.setText(configuracao.getDiretorioDeDocumentos().replace("\\\\", "\\"));
            }
            if(configuracao.getDiretorioDeBackup() != null) {
                campoDiretorioBackup.setText(configuracao.getDiretorioDeBackup().replace("\\\\", "\\"));
                }
                if(configuracao.getNomeDaImpressora() != null) {
                    campoNomeImpressora.setText(configuracao.getNomeDaImpressora().replace("\\\\", "\\"));
                    }

                    labelNomeImpressora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                    labelNomeImpressora.setText("Nome da impressora");

                    botaoAlterarNomeImpressora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                    botaoAlterarNomeImpressora.setText("Alterar");
                    botaoAlterarNomeImpressora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    botaoAlterarNomeImpressora.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            botaoAlterarNomeImpressoraActionPerformed(evt);
                        }
                    });

                    botaoSalvarNomeImpressora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                    botaoSalvarNomeImpressora.setText(" Salvar ");
                    botaoSalvarNomeImpressora.setToolTipText("Salvar diretório");
                    botaoSalvarNomeImpressora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    botaoSalvarNomeImpressora.setEnabled(false);
                    botaoSalvarNomeImpressora.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            botaoSalvarNomeImpressoraActionPerformed(evt);
                        }
                    });

                    javax.swing.GroupLayout painelConfiguracoesLayout = new javax.swing.GroupLayout(painelConfiguracoes);
                    painelConfiguracoes.setLayout(painelConfiguracoesLayout);
                    painelConfiguracoesLayout.setHorizontalGroup(
                        painelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelConfiguracoesLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(painelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelNomeImpressora)
                                .addGroup(painelConfiguracoesLayout.createSequentialGroup()
                                    .addComponent(campoNomeImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(botaoAlterarNomeImpressora)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botaoSalvarNomeImpressora))
                                .addComponent(labelDiretorioRelatorios)
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
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botaoSalvarDiretorioRelatorios)))
                            .addContainerGap(687, Short.MAX_VALUE))
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
                            .addComponent(labelDiretorioRelatorios)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(painelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoSalvarDiretorioRelatorios)
                                .addComponent(botaoAlterarDiretorioRelatorios)
                                .addComponent(campoDiretorioRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addComponent(labelNomeImpressora)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(painelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoSalvarNomeImpressora)
                                .addComponent(botaoAlterarNomeImpressora)
                                .addComponent(campoNomeImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(216, Short.MAX_VALUE))
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
                    botaoPesquisarUsuario.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            botaoPesquisarUsuarioActionPerformed(evt);
                        }
                    });

                    campoPesquisarUsuarios.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
                    campoPesquisarUsuarios.setForeground(new java.awt.Color(153, 153, 153));
                    campoPesquisarUsuarios.setText("Pesquisar Usuário");
                    campoPesquisarUsuarios.setToolTipText("Pesquise usuários pelo nome");
                    campoPesquisarUsuarios.setDisabledTextColor(new java.awt.Color(204, 204, 204));
                    campoPesquisarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            campoPesquisarUsuariosMouseClicked(evt);
                        }
                    });
                    campoPesquisarUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyTyped(java.awt.event.KeyEvent evt) {
                            campoPesquisarUsuariosKeyTyped(evt);
                        }
                    });

                    pnRlUsuario.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    pnRlUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                    pnRlUsuario.setPreferredSize(new java.awt.Dimension(596, 340));

                    tabelaUsuarios.setAutoCreateRowSorter(true);
                    tabelaUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                    tabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    tabelaUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    tabelaUsuarios.getTableHeader().setResizingAllowed(false);
                    tabelaUsuarios.getTableHeader().setReorderingAllowed(false);
                    String[] nomesColunasTabelaUsuarios = {"Nome do Usuário", "Login", "Categoria"};
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

                    tabelaUsuarios.getRowSorter().toggleSortOrder(0);
                    tabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            tabelaUsuariosMouseClicked(evt);
                        }
                    });
                    pnRlUsuario.setViewportView(tabelaUsuarios);

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

                    botaoEditarEmpresa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                    botaoEditarEmpresa.setText("Editar Empresa");
                    botaoEditarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    botaoEditarEmpresa.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            botaoEditarEmpresaActionPerformed(evt);
                        }
                    });

                    comboFiltrarUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                    comboFiltrarUsuarios.setMaximumRowCount(1);
                    comboFiltrarUsuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));
                    comboFiltrarUsuarios.setToolTipText("Selecionar tipo de filtro");
                    comboFiltrarUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    comboFiltrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            comboFiltrarUsuariosActionPerformed(evt);
                        }
                    });

                    labelFiltrarUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                    labelFiltrarUsuarios.setText("Filtrar por:");

                    botaoGerirValores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                    botaoGerirValores.setText("Gerir Dias");
                    botaoGerirValores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    botaoGerirValores.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            botaoGerirValoresActionPerformed(evt);
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
                                    .addComponent(botaoEditarEmpresa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botaoAtivarTemporada)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botaoGerirValores))
                                .addGroup(painelAdministradorLayout.createSequentialGroup()
                                    .addComponent(campoPesquisarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(botaoPesquisarUsuario))
                                .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(painelAdministradorLayout.createSequentialGroup()
                                        .addComponent(labelFiltrarUsuarios)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboFiltrarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botaoEditarUsuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botaoExcluirUsuario))
                                    .addComponent(pnRlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(709, Short.MAX_VALUE))
                    );
                    painelAdministradorLayout.setVerticalGroup(
                        painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelAdministradorLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoNovoUsuario)
                                .addComponent(botaoAtivarTemporada)
                                .addComponent(botaoEditarEmpresa)
                                .addComponent(botaoGerirValores))
                            .addGap(50, 50, 50)
                            .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoPesquisarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botaoPesquisarUsuario))
                            .addGap(36, 36, 36)
                            .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelFiltrarUsuarios)
                                    .addComponent(comboFiltrarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(botaoEditarUsuario)
                                    .addComponent(botaoExcluirUsuario)))
                            .addGap(18, 18, 18)
                            .addComponent(pnRlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18))
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
                            .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(painelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    painelGeralLayout.setVerticalGroup(
                        painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelGeralLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(painelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                    );

                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                    getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(painelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                    );
                    layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(painelGeral, 704, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void campoPesquisarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarClientesMouseClicked
        if (campoPesquisarClientes.getText().equals("Pesquisar Cliente")) {
            eliminarTextoDeCampo(campoPesquisarClientes);
        }
    }//GEN-LAST:event_campoPesquisarClientesMouseClicked

    private void campoPesquisarClientesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarClientesKeyTyped
        if (campoPesquisarClientes.getText().equals("Pesquisar Cliente")) {
            eliminarTextoDeCampo(campoPesquisarClientes);
        }
    }//GEN-LAST:event_campoPesquisarClientesKeyTyped

    private void painelClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelClientesMouseClicked
        if (campoPesquisarClientes.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarClientes, "Pesquisar Cliente");
        }
        //Se alguma linha da tabela estiver selecionada
        if (tabelaClientes.getSelectedRow() >= 0 || (botaoEditarCliente.isVisible() || botaoExcluirCliente.isVisible()
                || botaoVerLocacoesCliente.isVisible())) {
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

    private void campoPesquisarProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarProdutosMouseClicked
        if (campoPesquisarProdutos.getText().equals("Pesquisar Produto")) {
            eliminarTextoDeCampo(campoPesquisarProdutos);
        }
    }//GEN-LAST:event_campoPesquisarProdutosMouseClicked

    private void campoPesquisarProdutosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarProdutosKeyTyped
        if (campoPesquisarProdutos.getText().equals("Pesquisar Produto")) {
            eliminarTextoDeCampo(campoPesquisarProdutos);
        }
    }//GEN-LAST:event_campoPesquisarProdutosKeyTyped

    private void painelProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelProdutosMouseClicked
        if (campoPesquisarProdutos.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarProdutos, "Pesquisar Produto");
        }
        //Se alguma linha da tabela estiver selecionada
        if (tabelaProdutos.getSelectedRow() >= 0 || (botaoEditarProduto.isVisible() || botaoExcluirProduto.isVisible())
                || botaoConsultarDisponibilidade.isVisible()) {
            botaoEditarProduto.setVisible(false);
            botaoExcluirProduto.setVisible(false);
            botaoConsultarDisponibilidade.setVisible(false);
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

    private void campoPesquisarFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarFornecedoresMouseClicked
        if (campoPesquisarFornecedores.getText().equals("Pesquisar Fornecedor")) {
            eliminarTextoDeCampo(campoPesquisarFornecedores);
        }
    }//GEN-LAST:event_campoPesquisarFornecedoresMouseClicked

    private void campoPesquisarFornecedoresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarFornecedoresKeyTyped
        if (campoPesquisarFornecedores.getText().equals("Pesquisar Fornecedor")) {
            eliminarTextoDeCampo(campoPesquisarFornecedores);
        }
    }//GEN-LAST:event_campoPesquisarFornecedoresKeyTyped

    private void painelFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelFornecedoresMouseClicked
        if (campoPesquisarFornecedores.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarFornecedores, "Pesquisar Fornecedor");
        }
        //Se alguma linha da tabela estiver selecionada
        if (tabelaFornecedores.getSelectedRow() >= 0 || (botaoEditarFornecedor.isVisible() || botaoExcluirFornecedor.isVisible())) {
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
            //Atualizando a tabela de produtos para que os dados fiquem consistentes
            modeloTabelaProdutos.setRowCount(0);
            adicionarProdutosNaTabela(GerenciadorDeProduto.getInstance().getProdutos());
        }
        dialog.dispose();
    }//GEN-LAST:event_botaoNovaLocacaoActionPerformed

    private void campoPesquisarLocacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarLocacoesMouseClicked
        if (campoPesquisarLocacoes.getText().equals("Pesquisar Locação")) {
            eliminarTextoDeCampo(campoPesquisarLocacoes);
        }
    }//GEN-LAST:event_campoPesquisarLocacoesMouseClicked

    private void campoPesquisarLocacoesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarLocacoesKeyTyped
        if (campoPesquisarLocacoes.getText().equals("Pesquisar Locação")) {
            eliminarTextoDeCampo(campoPesquisarLocacoes);
        }
    }//GEN-LAST:event_campoPesquisarLocacoesKeyTyped

    private void painelLocacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelLocacoesMouseClicked
        if (campoPesquisarLocacoes.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarLocacoes, "Pesquisar Locação");
        }
        //Se alguma linha da tabela estiver selecionada
        if (tabelaLocacoes.getSelectedRow() >= 0 || (botaoVerRecibosLocacao.isVisible() || botaoGerarReciboLocacao.isVisible()
                || botaoVerContrato.isVisible() || botaoFinalizarLocacao.isVisible())) {
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

    private void campoPesquisarVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarVendasMouseClicked
        if (campoPesquisarVendas.getText().equals("Pesquisar Venda")) {
            eliminarTextoDeCampo(campoPesquisarVendas);
        }
    }//GEN-LAST:event_campoPesquisarVendasMouseClicked

    private void campoPesquisarVendasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarVendasKeyTyped
        if (campoPesquisarVendas.getText().equals("Pesquisar Venda")) {
            eliminarTextoDeCampo(campoPesquisarVendas);
        }
    }//GEN-LAST:event_campoPesquisarVendasKeyTyped

    private void painelVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelVendasMouseClicked
        if (campoPesquisarVendas.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarVendas, "Pesquisar Venda");
        }
        //Se alguma linha da tabela estiver selecionada
        if (tabelaVendas.getSelectedRow() >= 0 || botaoVerRecibosVenda.isVisible()) {
            botaoVerRecibosVenda.setVisible(false);
            tabelaVendas.clearSelection();
        }
    }//GEN-LAST:event_painelVendasMouseClicked

    private void botaoGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarRelatorioActionPerformed
        GerarRelatorioDialog dialog = new GerarRelatorioDialog(new java.awt.Frame());
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_botaoGerarRelatorioActionPerformed

    private void botaoSalvarDiretorioBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarDiretorioBackupActionPerformed
        if (campoDiretorioBackup.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe o caminho do diretório de documentos corretamente", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Configuracao configuracao = GerenciadorDoSistema.getInstance().getConfiguracao();
                configuracao.setDiretorioDeBackup(campoDiretorioBackup.getText());
                GerenciadorDoSistema.getInstance().salvarEstadoDeConfiguracao(configuracao);
                JOptionPane.showMessageDialog(null, "Diretório de backup salvo com sucesso!");
                campoDiretorioBackup.setEditable(false);
                botaoSalvarDiretorioBackup.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar a alteração feita\n" + e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoSalvarDiretorioBackupActionPerformed

    private void campoDiretorioBackupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoDiretorioBackupMouseClicked
        if (campoDiretorioBackup.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioBackup);
        }
    }//GEN-LAST:event_campoDiretorioBackupMouseClicked

    private void campoDiretorioBackupKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDiretorioBackupKeyTyped
        if (campoDiretorioBackup.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioBackup);
        }
    }//GEN-LAST:event_campoDiretorioBackupKeyTyped

    private void botaoSalvarDiretorioDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarDiretorioDocumentosActionPerformed
        if (campoDiretorioDocumentos.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe o caminho do diretório de documentos corretamente", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Configuracao configuracao = GerenciadorDoSistema.getInstance().getConfiguracao();
                configuracao.setDiretorioDeDocumentos(campoDiretorioDocumentos.getText().replace("\\", "\\\\"));
                GerenciadorDoSistema.getInstance().salvarEstadoDeConfiguracao(configuracao);
                JOptionPane.showMessageDialog(null, "Diretório de documentos salvo com sucesso!");
                campoDiretorioRelatorios.setEditable(false);
                botaoSalvarDiretorioDocumentos.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar a alteração feita\n" + e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoSalvarDiretorioDocumentosActionPerformed

    private void campoDiretorioDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoDiretorioDocumentosMouseClicked
        if (campoDiretorioDocumentos.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioDocumentos);
        }
    }//GEN-LAST:event_campoDiretorioDocumentosMouseClicked

    private void campoDiretorioDocumentosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDiretorioDocumentosKeyTyped
        if (campoDiretorioDocumentos.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioDocumentos);
        }
    }//GEN-LAST:event_campoDiretorioDocumentosKeyTyped

    private void painelConfiguracoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelConfiguracoesMouseClicked
        desabilitarCamposDeDiretorios();
    }//GEN-LAST:event_painelConfiguracoesMouseClicked

    private void botaoNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoUsuarioActionPerformed
        CadastrarUsuarioDialog dialog = new CadastrarUsuarioDialog(null);
        dialog.setLocationRelativeTo(null);
        if (dialog.alterarDados()) {
            adicionarNovoUsuarioNaTabela(dialog.getNovoUsuario());
        }
        dialog.dispose();
    }//GEN-LAST:event_botaoNovoUsuarioActionPerformed

    private void campoPesquisarUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPesquisarUsuariosMouseClicked
        if (campoPesquisarUsuarios.getText().equals("Pesquisar Usuário")) {
            eliminarTextoDeCampo(campoPesquisarUsuarios);
        }
    }//GEN-LAST:event_campoPesquisarUsuariosMouseClicked

    private void campoPesquisarUsuariosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarUsuariosKeyTyped
        if (campoPesquisarUsuarios.getText().equals("Pesquisar Usuário")) {
            eliminarTextoDeCampo(campoPesquisarUsuarios);
        }
    }//GEN-LAST:event_campoPesquisarUsuariosKeyTyped

    private void painelAdministradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelAdministradorMouseClicked
        if (campoPesquisarUsuarios.getText().length() <= 0) {
            criarTextoEmCampo(campoPesquisarUsuarios, "Pesquisar Usuário");
        }
        //Se alguma linha da tabela estiver selecionada
        if (tabelaUsuarios.getSelectedRow() >= 0 || (botaoEditarUsuario.isVisible() || botaoExcluirUsuario.isVisible())) {
            botaoEditarUsuario.setVisible(false);
            botaoExcluirUsuario.setVisible(false);
            tabelaUsuarios.clearSelection();
        }
    }//GEN-LAST:event_painelAdministradorMouseClicked

    private void botaoPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarClienteActionPerformed
        if (campoPesquisarClientes.getText().equals("Pesquisar Cliente") || campoPesquisarClientes.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe um nome para a pesquisa de cliente", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String textoPesquisado = campoPesquisarClientes.getText();

                //Verifica se o que foi digitado para a pesquisa é um CPF
                if (textoPesquisado.length() == 14 && (textoPesquisado.charAt(3) == '.' && textoPesquisado.charAt(7) == '.')
                        && textoPesquisado.charAt(11) == '-') {

                    // Atualiza o model da lista de clientes
                    modeloTabelaClientes.setRowCount(0);

                    Cliente cliente = GerenciadorDePessoas.getInstance().pesquisarCliente(textoPesquisado);
                    modeloTabelaClientes.addRow(new Object[]{cliente.getCpf(), cliente.getNome(), cliente.getCelular(), cliente.getDataCadastroInString()});
                    comboFiltrarClientes.setSelectedIndex(0);

                } else {
                    pesquisarClientesPorNomeEFiltro(textoPesquisado);
                }
            } catch (ClienteInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoPesquisarClienteActionPerformed

    private void comboFiltrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltrarClientesActionPerformed
        //Fazer a pesquisa sem levar o campo de pesquisa em consideração
        if (campoPesquisarClientes.getText().equals("Pesquisar Cliente") || campoPesquisarClientes.getText().length() <= 0) {
            pesquisarClientesPorFiltro();
        } else {
            try {
                String textoPesquisado = campoPesquisarClientes.getText();

                //Verifica se o que foi digitado para a pesquisa é um CPF
                if (textoPesquisado.length() == 14 && (textoPesquisado.charAt(3) == '.' && textoPesquisado.charAt(7) == '.') && textoPesquisado.charAt(11) == '-') {

                    // Atualiza o model da lista de clientes
                    modeloTabelaClientes.setRowCount(0);
                    Cliente cliente = GerenciadorDePessoas.getInstance().pesquisarCliente(textoPesquisado);
                    modeloTabelaClientes.addRow(new Object[]{cliente.getCpf(), cliente.getNome(), cliente.getCelular(), cliente.getDataCadastroInString()});
                    comboFiltrarClientes.setSelectedIndex(0);

                } else {
                    pesquisarClientesPorNomeEFiltro(textoPesquisado);
                }

            } catch (ClienteInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_comboFiltrarClientesActionPerformed

    public void pesquisarClientesPorNomeEFiltro(String nome) {
        modeloTabelaClientes.setRowCount(0);
        aguarde.setLocationRelativeTo(null);
        aguarde.setVisible(true);
        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                List<Cliente> clientes = null;

                switch (comboFiltrarClientes.getSelectedItem().toString()) {

                    case "Todos":

                        clientes = GerenciadorDePessoas.getInstance().pesquisarClientesPorNome(nome);

                        break;

                    case "Últimos locatários":
                        clientes = GerenciadorDePessoas.getInstance().pesquisarUltimosLocatariosPorNome(nome);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida\n\n Tente novamente", "Aviso", JOptionPane.WARNING_MESSAGE);
                        break;

                }
                if (clientes != null) {
                    adicionarClientesNaTabela(clientes);
                }
                return null;
            }

            @Override
            protected void done() {
                aguarde.dispose();

            }
        }.execute();

    }

    public void pesquisarClientesPorFiltro() {

        modeloTabelaClientes.setRowCount(0);
        aguarde.setLocationRelativeTo(null);
        aguarde.setVisible(true);
        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                List<Cliente> clientes = null;
                switch (comboFiltrarClientes.getSelectedItem().toString()) {
                    case "Todos":
                        clientes = GerenciadorDePessoas.getInstance().getClientes();
                        break;

                    case "Últimos locatários":
                        clientes = GerenciadorDePessoas.getInstance().getLocacoesMaisRecentsPorCliente();
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida\n\n Tente novamente", "Aviso", JOptionPane.WARNING_MESSAGE);
                        break;
                }
                if (clientes != null) {
                    adicionarClientesNaTabela(clientes);
                }
                return null;
            }

            @Override
            protected void done() {
                aguarde.dispose();

            }
        }.execute();
    }

    private void botaoAtivarTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtivarTemporadaActionPerformed
        AtivarTemporadaDialog dialog = new AtivarTemporadaDialog(new java.awt.Frame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_botaoAtivarTemporadaActionPerformed

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        if (evt.getClickCount() == 1) {
            botaoEditarProduto.setVisible(true);
            botaoExcluirProduto.setVisible(true);
            botaoConsultarDisponibilidade.setVisible(true);
        }
        if (evt.getClickCount() == 2) {
            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    try {
                        //Passa, como parâmetro, o produto pesquisado pelo código 
                        VerDadosProdutoDialog dialog = new VerDadosProdutoDialog(null, GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(
                                (String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0)));

                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    } catch (ProdutoInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                    return null;
                }
            }.execute();
        }
    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        if (evt.getClickCount() == 1) {
            botaoEditarCliente.setVisible(true);
            botaoExcluirCliente.setVisible(true);
            botaoVerLocacoesCliente.setVisible(true);
        }
        if (evt.getClickCount() == 2) {
            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {

                    try {
                        VerDadosClienteDialog dialog = new VerDadosClienteDialog(null, GerenciadorDePessoas.getInstance().pesquisarCliente(
                                (String) tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0)));
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    } catch (ClienteInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                    return null;
                }
            }.execute();

        }
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void painelCaixaERelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelCaixaERelatoriosMouseClicked
        botaoExcluirDespesa.setVisible(false);
        botaoEditarDespesa.setVisible(false);
        if (tabelaMovimentacoes.getSelectedRow() >= 0 || tabelaMovimentacoes.isVisible()) {
            tabelaMovimentacoes.clearSelection();
        }
    }//GEN-LAST:event_painelCaixaERelatoriosMouseClicked

    private void botaoEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarClienteActionPerformed
        if (tabelaClientes.getSelectedRow() >= 0) {

            try {
                //Pesquisa o produto selecionado através do seu CPF (0 = primeira coluna da tabela)
                EditarClienteDialog dialog = new EditarClienteDialog(null, GerenciadorDePessoas.getInstance().pesquisarCliente(
                        (String) tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0)));

                dialog.setLocationRelativeTo(null);
                if (dialog.alterarDados()) {
                    atualizarDadosClienteNaTabela(dialog.getCliente(), tabelaClientes.getSelectedRow());
                }
                dialog.dispose();
            } catch (ClienteInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar um cliente na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoEditarClienteActionPerformed

    private void botaoExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirClienteActionPerformed
        if (tabelaClientes.getSelectedRow() >= 0) {
            int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o cliente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            //Sim = 0
            if (escolha == 0) {
                try {
                    String idCliente = (String) tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0);
                    GerenciadorDePessoas.getInstance().removerCliente(idCliente);
                    removerClienteDaTabela(tabelaClientes.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                } catch (ClienteInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar um cliente na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoExcluirClienteActionPerformed

    private void botaoExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirProdutoActionPerformed
        if (tabelaProdutos.getSelectedRow() >= 0) {
            int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este produto?", "Atenção!", JOptionPane.YES_NO_OPTION);
            //Sim = 0
            if (escolha == 0) {
                try {
                    //Pesquisa o produto selecionado através do seu código (0 = primeira coluna da tabela)
                    GerenciadorDeProduto.getInstance().removerProduto((String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0));
                    removerProdutoDaTabela(tabelaProdutos.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                } catch (ProdutoInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar um produto na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoExcluirProdutoActionPerformed

    private void botaoExcluirFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirFornecedorActionPerformed
        if (tabelaFornecedores.getSelectedRow() >= 0) {
            int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este fornecedor?", "Atenção!", JOptionPane.YES_NO_OPTION);
            //Sim = 0
            if (escolha == 0) {
                try {
                    //Pesquisa o produto selecionado através do seu CNPJ (0 = primeira coluna da tabela)
                    GerenciadorDePessoas.getInstance().removerFornecedor((String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 0));
                    removerFornecedorDaTabela(tabelaFornecedores.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso!");
                } catch (FornecedorInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar um fornecedor na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoExcluirFornecedorActionPerformed

    private void botaoExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirUsuarioActionPerformed
        if (tabelaUsuarios.getSelectedRow() >= 0) {
            if (!((String) tabelaUsuarios.getValueAt(tabelaUsuarios.getSelectedRow(), 1)).equals(
                    GerenciadorDoSistema.getInstance().getUsuarioLogado().getNickName())) {

                String login = (String) tabelaUsuarios.getValueAt(tabelaUsuarios.getSelectedRow(), 1);
                int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este usuário?", "Atenção!", JOptionPane.YES_NO_OPTION);
                //Sim = 0
                if (escolha == 0) {
                    try {
                        //Remove o usuário selecionado através do seu login
                        GerenciadorDePessoas.getInstance().removerUsuario(login);
                        removerUsuarioDaTabela(tabelaUsuarios.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    } catch (UsuarioInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você não pode se excluir do sistema", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar um usuário na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoExcluirUsuarioActionPerformed

    private void botaoExcluirDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirDespesaActionPerformed
        if (tabelaMovimentacoes.getSelectedRow() >= 0) {
            if (((String) tabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), 0)).toUpperCase().equals("DESPESA")) {
                ConfirmarSenhaDialog dialog = new ConfirmarSenhaDialog(null);
                dialog.setLocationRelativeTo(null);
                if (dialog.alterarDados()) {
                    if (GerenciadorDoSistema.getInstance().getUsuarioLogado().getSenha().equals(dialog.getSenhaInformada())) {
                        int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta despesa?", "Atenção!", JOptionPane.YES_NO_OPTION);
                        //Sim = 0
                        if (escolha == 0) {
                            try {
                                //Pesquisa o produto selecionado através do seu código (0 = primeira coluna da tabela)
                                //GerenciadorDoSistema.getInstance().removerDespesas(Long.parseLong((String) tabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(),
                                  //      tabelaMovimentacoes.getColumnCount() - 1)));
                                
                                GerenciadorDoSistema.getInstance().removerMovimentacao(Long.parseLong((String) tabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(),
                                        tabelaMovimentacoes.getColumnCount() - 1)));
                                
                                removerMovimentacaoDaTabela(tabelaMovimentacoes.getSelectedRow());
                                atualizarValorEmCaixa();
                                JOptionPane.showMessageDialog(null, "Despesa removida com sucesso!");
                            } catch (MovimentacaoInexistenteException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Senhas incompatíveis", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Nao é possível excluir este tipo de movimentaçao", "Aviso", JOptionPane.WARNING_MESSAGE);
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
        if (evt.getClickCount() == 2) {

            //Passa, como parâmetro, o fornecedor pesquisado pelo CNPJ
            try {
                VerDadosFornecedorDialog dialog = new VerDadosFornecedorDialog(null, GerenciadorDePessoas.getInstance().pesquisarFornecedorPeloCnpj(
                        (String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 0)));

                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            } catch (FornecedorInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_tabelaFornecedoresMouseClicked

    private void tabelaVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendasMouseClicked
        if (evt.getClickCount() == 1) {
            botaoVerRecibosVenda.setVisible(true);
        }
        if (evt.getClickCount() == 2) {

            try {
                //Passa, como parâmetro, a venda pesquisada pelo seu código 
                VerDadosVendaDialog dialog = new VerDadosVendaDialog(null, GerenciadorDeVenda.getInstance().pesquisarVendaPorId(
                        Long.parseLong((String) tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), tabelaVendas.getColumnCount() - 1))));

                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            } catch (VendaInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_tabelaVendasMouseClicked

    private void tabelaMovimentacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMovimentacoesMouseClicked
        if (evt.getClickCount() == 1) {
            if (((String) tabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), 0)).toUpperCase().equals("DESPESA")) {
                botaoExcluirDespesa.setVisible(true);
                botaoEditarDespesa.setVisible(true);
            }
        }
        if (evt.getClickCount() == 2) {

            //Passa, como parâmetro, a movimentacao pesquisada pelo id
            try {
                if (((String) tabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), 0)).toUpperCase().equals("DESPESA")) {

                    VerDadosDespesaDialog dialog = new VerDadosDespesaDialog(null, GerenciadorDoSistema.getInstance().pesquisarDespesaPorId(
                            Long.parseLong((String) tabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), tabelaMovimentacoes.getColumnCount() - 1))));

                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                } else {
                    VerDadosMovimentacaoDialog dialog = new VerDadosMovimentacaoDialog(null, GerenciadorDoSistema.getInstance().pesquisarMovimentacaoPorId(
                            Long.parseLong((String) tabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), tabelaMovimentacoes.getColumnCount() - 1))));

                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_tabelaMovimentacoesMouseClicked

    private void tabelaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUsuariosMouseClicked
        botaoExcluirUsuario.setVisible(true);
        botaoEditarUsuario.setVisible(true);
    }//GEN-LAST:event_tabelaUsuariosMouseClicked

    private void tabelaLocacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLocacoesMouseClicked
        if (evt.getClickCount() == 1) {
            botaoVerRecibosLocacao.setVisible(true);
            botaoVerContrato.setVisible(true);
            botaoGerarReciboLocacao.setVisible(true);
            botaoFinalizarLocacao.setVisible(true);
        }
        if (evt.getClickCount() == 2) {

            try {
                //Passa, como parâmetro, a locação pesquisada pelo id
                VerDadosLocacaoDialog dialog = new VerDadosLocacaoDialog(null, GerenciadorDeLocacao.getInstance().pesquisarLocacaoPorId(
                        Long.parseLong((String) tabelaLocacoes.getValueAt(tabelaLocacoes.getSelectedRow(), tabelaLocacoes.getColumnCount() - 1))));

                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            } catch (LocacaoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_tabelaLocacoesMouseClicked

    private void botaoSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSairMouseClicked
        new LoginFrame().setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoSairMouseClicked

    private void botaoEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarProdutoActionPerformed
        if (tabelaProdutos.getSelectedRow() >= 0) {

            try {
                //Pesquisa o produto selecionado através do seucódigo
                EditarProdutoDialog dialog = new EditarProdutoDialog(null, GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(
                        (String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0)));

                dialog.setLocationRelativeTo(null);
                if (dialog.alterarDados()) {
                    atualizarDadosProdutoNaTabela(dialog.getProduto(), tabelaProdutos.getSelectedRow());
                }
                dialog.dispose();

            } catch (ProdutoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar um produto na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoEditarProdutoActionPerformed

    private void botaoEditarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarFornecedorActionPerformed
        if (tabelaFornecedores.getSelectedRow() >= 0) {
            try {
                //Pesquisa o produto selecionado através do seu CPF (0 = primeira coluna da tabela)
                EditarFornecedorDialog dialog = new EditarFornecedorDialog(null, GerenciadorDePessoas.getInstance().pesquisarFornecedorPeloCnpj(
                        (String) tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 0)));

                dialog.setLocationRelativeTo(null);
                if (dialog.alterarDados()) {
                    atualizarDadosFornecedorNaTabela(dialog.getFornecedor(), tabelaFornecedores.getSelectedRow());
                }
                dialog.dispose();

            } catch (FornecedorInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar um fornecedor na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoEditarFornecedorActionPerformed

    private void botaoEditarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarDespesaActionPerformed
        if (tabelaMovimentacoes.getSelectedRow() >= 0) {
            if (((String) tabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), 0)).toUpperCase().equals("DESPESA")) {

                try {
                    //Pesquisa a despesa selecionado através do seu id (0 = primeira coluna da tabela)
                    EditarDespesaDialog dialog = new EditarDespesaDialog(null, GerenciadorDoSistema.getInstance().pesquisarDespesaPorId(
                            Long.parseLong((String) tabelaMovimentacoes.getValueAt(tabelaMovimentacoes.getSelectedRow(), tabelaMovimentacoes.getColumnCount() - 1))));

                    dialog.setLocationRelativeTo(null);
                    if (dialog.alterarDados()) {
                        atualizarDadosDespesaNaTabela(dialog.getMovimentacao(), tabelaMovimentacoes.getSelectedRow());
                    }
                    dialog.dispose();

                } catch (DespesaInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Não é possível editar este tipo de movimentação", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar uma despesa na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_botaoEditarDespesaActionPerformed

    private void botaoEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarUsuarioActionPerformed
        if (tabelaUsuarios.getSelectedRow() >= 0) {

            try {
                //Pesquisa o usuário selecionado através do seu login (segunda coluna da tabela)
                EditarUsuarioDialog dialog = new EditarUsuarioDialog(null, GerenciadorDePessoas.getInstance().pesquisarUsuarioPeloLogin(
                        (String) tabelaUsuarios.getValueAt(tabelaUsuarios.getSelectedRow(), 1)));

                dialog.setLocationRelativeTo(null);

                if (dialog.alterarDados()) {
                    atualizarDadosUsuarioNaTabela(dialog.getUsuario(), tabelaUsuarios.getSelectedRow());
                }
                dialog.dispose();

            } catch (UsuarioInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar um usuário na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoEditarUsuarioActionPerformed

    private void botaoVerLocacoesClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerLocacoesClienteActionPerformed
        if (tabelaClientes.getSelectedRow() >= 0) {
            aguarde.setLocationRelativeTo(null);
            aguarde.setVisible(true);

            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    //Pesquisa o usuário selecionado através do seu login (segunda coluna da tabela)
                    try {
                        VerLocacoesDeClienteDialog dialog = new VerLocacoesDeClienteDialog(null, GerenciadorDePessoas.getInstance().pesquisarCliente(
                                (String) tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0)));
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    } catch (ClienteInexistenteException e) {
                        aguarde.dispose();
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                    return null;
                }

                @Override
                protected void done() {
                    aguarde.dispose();

                }
            }.execute();
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar um cliente na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoVerLocacoesClienteActionPerformed

    private void botaoEditarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarEmpresaActionPerformed
        Empresa empresa = GerenciadorDoSistema.getInstance().getConfiguracao().getEmpresa();
        EditarEmpresaDialog dialog = new EditarEmpresaDialog(null, empresa);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_botaoEditarEmpresaActionPerformed

    private void botaoAlterarDiretorioBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarDiretorioBackupActionPerformed
        if (campoDiretorioBackup.getText().length() > 0){
            campoDiretorioBackup.setEditable(true);
            JFileChooser fc = new JFileChooser(campoDiretorioBackup.getText());
            fc.setDialogTitle("Selecionar pasta");
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int res = fc.showSaveDialog(this);
            if (res == JFileChooser.APPROVE_OPTION){ 
                campoDiretorioBackup.setText(fc.getSelectedFile().getAbsolutePath()); 
            }
            botaoSalvarDiretorioBackup.setEnabled(true);
        }
    }//GEN-LAST:event_botaoAlterarDiretorioBackupActionPerformed

    private void botaoAlterarDiretorioDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarDiretorioDocumentosActionPerformed
        if (campoDiretorioDocumentos.getText().length() > 0){
            campoDiretorioDocumentos.setEditable(true);
            JFileChooser fc = new JFileChooser(campoDiretorioDocumentos.getText());
            fc.setDialogTitle("Selecionar pasta");
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int res = fc.showSaveDialog(this);
            if (res == JFileChooser.APPROVE_OPTION){ 
                campoDiretorioDocumentos.setText(fc.getSelectedFile().getAbsolutePath()); 
            }
            campoDiretorioDocumentos.setEnabled(true);
        }
    }//GEN-LAST:event_botaoAlterarDiretorioDocumentosActionPerformed

    private void botaoAlterarDiretorioRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarDiretorioRelatoriosActionPerformed
        if (campoDiretorioRelatorios.getText().length() > 0){
            campoDiretorioRelatorios.setEditable(true);
            JFileChooser fc = new JFileChooser(campoDiretorioRelatorios.getText());
            fc.setDialogTitle("Selecionar pasta");
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int res = fc.showSaveDialog(this);
            if (res == JFileChooser.APPROVE_OPTION){ 
                campoDiretorioRelatorios.setText(fc.getSelectedFile().getAbsolutePath()); 
            }
            campoDiretorioRelatorios.setEnabled(true);
        }
    }//GEN-LAST:event_botaoAlterarDiretorioRelatoriosActionPerformed

    private void botaoSalvarDiretorioRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarDiretorioRelatoriosActionPerformed
        if (campoDiretorioRelatorios.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe o caminho do diretório de relátorios corretamente", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Configuracao configuracao = GerenciadorDoSistema.getInstance().getConfiguracao();
                configuracao.setDiretorioDeRelatorios(campoDiretorioRelatorios.getText());
                GerenciadorDoSistema.getInstance().salvarEstadoDeConfiguracao(configuracao);
                JOptionPane.showMessageDialog(null, "Diretorio de relatórios salvo com sucesso!");
                campoDiretorioRelatorios.setEditable(false);
                botaoSalvarDiretorioRelatorios.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar a alteração feita\n" + e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoSalvarDiretorioRelatoriosActionPerformed

    private void campoDiretorioRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoDiretorioRelatoriosMouseClicked
        if (campoDiretorioRelatorios.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioRelatorios);
        }
    }//GEN-LAST:event_campoDiretorioRelatoriosMouseClicked

    private void campoDiretorioRelatoriosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDiretorioRelatoriosKeyTyped
        if (campoDiretorioRelatorios.getText().equals("Caminho do diretório")) {
            eliminarTextoDeCampo(campoDiretorioRelatorios);
        }
    }//GEN-LAST:event_campoDiretorioRelatoriosKeyTyped

    private void botaoVerContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerContratoActionPerformed
        if (tabelaLocacoes.getSelectedRow() >= 0) {
            try {
                GerenciadorDeLocacao.getInstance().verUltimoContratoGerado(
                        Long.parseLong((String) tabelaLocacoes.getValueAt(tabelaLocacoes.getSelectedRow(), tabelaLocacoes.getColumnCount() - 1)));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível abrir o contrato da locação", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar uma locação na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoVerContratoActionPerformed

    private void botaoVerRecibosLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerRecibosLocacaoActionPerformed
        if (tabelaLocacoes.getSelectedRow() >= 0) {
            try {

                String nomeCliente = GerenciadorDeLocacao.getInstance().pesquisarLocacaoPorId(
                        Long.parseLong((String) tabelaLocacoes.getValueAt(tabelaLocacoes.getSelectedRow(), tabelaLocacoes.getColumnCount() - 1)))
                        .getCliente().getNome();
                Desktop.getDesktop().open(new File(GerenciadorDoSistema.getInstance().getConfiguracao().getDiretorioDeDocumentos()
                        + "\\" + nomeCliente + "\\Recibos"));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível abrir a pasta com os recibos da locação", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar uma locação na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoVerRecibosLocacaoActionPerformed

    private void botaoGerarReciboLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarReciboLocacaoActionPerformed
        if (tabelaLocacoes.getSelectedRow() >= 0) {
            try {
                long idLocacao = Long.parseLong((String) tabelaLocacoes.getValueAt(
                        tabelaLocacoes.getSelectedRow(), tabelaLocacoes.getColumnCount() - 1));
                Locacao locacao = GerenciadorDeLocacao.getInstance().pesquisarLocacaoPorId(idLocacao);
                if (!locacao.isLocacaoPaga()) {
                    GerarReciboDeLocacaoDialog dialog = new GerarReciboDeLocacaoDialog(null, locacao);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Esta locação já foi quitada", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível gerar o recibo da locação", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar uma locação na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoGerarReciboLocacaoActionPerformed

    private void botaoVerRecibosVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerRecibosVendaActionPerformed
        if (tabelaVendas.getSelectedRow() >= 0) {
            try {
                Desktop.getDesktop().open(new File(GerenciadorDoSistema.getInstance().getConfiguracao().getDiretorioDeDocumentos()
                        + "\\Vendas\\" + tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), tabelaVendas.getColumnCount() - 1) + ".pdf"));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo de recibo da venda", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar uma venda na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoVerRecibosVendaActionPerformed

    private void botaoFinalizarLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizarLocacaoActionPerformed
        if (tabelaLocacoes.getSelectedRow() >= 0) {
            try {
                Locacao locacao = GerenciadorDeLocacao.getInstance().pesquisarLocacaoPorId(Long.parseLong(
                        (String) tabelaLocacoes.getValueAt(tabelaLocacoes.getSelectedRow(), tabelaLocacoes.getColumnCount() - 1)));

                if (locacao.isLocacaoPaga()) {
                    if (!locacao.isFinalizada()) {
                        int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja finalizar esta locação?", "Atenção!", JOptionPane.YES_NO_OPTION);
                        //Sim = 0
                        if (escolha == 0) {
                            aguarde.setLocationRelativeTo(null);
                            aguarde.setVisible(true);

                            new SwingWorker() {
                                @Override
                                protected Object doInBackground() throws Exception {

                                    try {
                                        //Pesquisa a locação através do seu id (tamanho da tabela - 1 = o id está na última coluna da tabela)
                                        GerenciadorDeLocacao.getInstance().finalizarLocacao(locacao.getId());

                                        JOptionPane.showMessageDialog(null, "Locação finalizada com sucesso!");

                                        atualizarStatusDeLocacao(Long.toString(locacao.getId()), tabelaLocacoes.getSelectedRow());
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                                    }
                                    return null;
                                }

                                @Override
                                protected void done() {
                                    aguarde.dispose();

                                }
                            }.execute();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Esta locação já está finalizada", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Esta locação ainda não foi quitada", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (LocacaoInexistenteException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível continuar. Tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar uma locação na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoFinalizarLocacaoActionPerformed

    private void botaoPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarProdutoActionPerformed
        if (campoPesquisarProdutos.getText().equals("Pesquisar Produto") || campoPesquisarProdutos.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe o código ou o nome para pesquisar um produto", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                if (radioPesquisarProdutoCodigo.isSelected()) {
                    Produto produto = GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(campoPesquisarProdutos.getText());
                    //Limpa a tabela para adicionar o dado da pesquisa
                    modeloTabelaProdutos.setRowCount(0);
                    modeloTabelaProdutos.addRow(new Object[]{produto.getCodigo(), produto.getDescricao(), "R$ " + produto.getValorInString(),
                        produto.getQuantidade(), produto.getFinalidade()});
                } else if (radioPesquisarProdutoNome.isSelected()) {
                    pesquisarProdutosPorNomeEFiltro(campoPesquisarProdutos.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível realizar a busca de produtos. \n\nPor favor, tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }

            } catch (ProdutoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_botaoPesquisarProdutoActionPerformed

    private void comboFiltrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltrarProdutosActionPerformed
        //Fazer a pesquisa sem levar o campo de pesquisa em consideração
        if (campoPesquisarProdutos.getText().equals("Pesquisar Produto") || campoPesquisarProdutos.getText().length() <= 0) {
            pesquisarProdutosPorFiltro();
        } else {
            try {
                if (radioPesquisarProdutoCodigo.isSelected()) {
                    Produto produto = GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(campoPesquisarProdutos.getText());
                    //Limpa a tabela para adicionar o dado da pesquisa
                    modeloTabelaProdutos.setRowCount(0);
                    modeloTabelaProdutos.addRow(new Object[]{produto.getCodigo(), produto.getDescricao(), "R$ " + produto.getValorInString(),
                        produto.getQuantidade(), produto.getFinalidade()});
                } else if (radioPesquisarProdutoNome.isSelected()) {
                    pesquisarProdutosPorNomeEFiltro(campoPesquisarProdutos.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível realizar a busca de produtos. \nPor favor, tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }

            } catch (ProdutoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_comboFiltrarProdutosActionPerformed

    public void pesquisarProdutosPorNomeEFiltro(String nome) {
        aguarde.setLocationRelativeTo(null);
        aguarde.setVisible(true);

        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                List<Produto> produtos = null;
                switch (comboFiltrarProdutos.getSelectedItem().toString()) {
                    case "Todos":
                        produtos = GerenciadorDeProduto.getInstance().pesquisarProdutosPeloNome(nome);
                        break;

                    case "Produtos de locação":
                        produtos = GerenciadorDeProduto.getInstance().pesquisarProdutosDeLocacaoPeloNome(nome);
                        break;

                    case "Produtos de venda":
                        produtos = GerenciadorDeProduto.getInstance().pesquisarProdutosDeVendaPeloNome(nome);
                        break;

                    case "Últimos locados":

                        try {
                            produtos = GerenciadorDeProduto.getInstance().pesquisarUltimosProdutosLocadosPorNome(nome);
                        } catch (ProdutoInexistenteException e) {
                            JOptionPane.showMessageDialog(null, "Ocorreu um erro na pesquisa de produtos. \nPor favor, tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                        }

                        break;

                    case "Últimos vendidos":

                        try {
                            produtos = GerenciadorDeProduto.getInstance().pesquisarUltimosProdutosVendidosPorNome(nome);
                        } catch (ProdutoInexistenteException e) {
                            JOptionPane.showMessageDialog(null, "Ocorreu um erro na pesquisa de produtos. \nPor favor, tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                        }

                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida\n\n Tente novamente", "Aviso", JOptionPane.WARNING_MESSAGE);
                        break;
                }
                if (produtos != null) {
                    adicionarProdutosNaTabela(produtos);
                }
                return null;
            }

            @Override
            protected void done() {
                aguarde.dispose();

            }
        }.execute();

    }

    public void pesquisarProdutosPorFiltro() {
        aguarde.setLocationRelativeTo(null);
        aguarde.setVisible(true);

        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                List<Produto> produtos = null;
                switch (comboFiltrarProdutos.getSelectedItem().toString()) {
                    case "Todos":
                        produtos = GerenciadorDeProduto.getInstance().getProdutosDisponiveisEntreDatas(Calendar.getInstance(), Calendar.getInstance());
                        for(Produto produto: GerenciadorDeProduto.getInstance().getProdutosDeVenda()) {
                            produtos.add(produto);
                        }
                        break;

                    case "Produtos de locação":
                        produtos = GerenciadorDeProduto.getInstance().getProdutosDisponiveisEntreDatas(Calendar.getInstance(), Calendar.getInstance());
                        break;

                    case "Produtos de venda":
                        produtos = GerenciadorDeProduto.getInstance().getProdutosDeVenda();
                        break;

                    case "Para Ajuste":
                        produtos = GerenciadorDeProduto.getInstance().getProdutosParaCostureira();
                        break;

                    case "Últimos locados":
                        try {
                            produtos = GerenciadorDeProduto.getInstance().pesquisarUltimosProdutosLocados();
                        } catch (ProdutoInexistenteException e) {
                            JOptionPane.showMessageDialog(null, "Ocorreu um erro na pesquisa de produtos. \nPor favor, tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                        }

                        break;

                    case "Últimos vendidos":
                        try {
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>FEZ A PESQUISA DOS ÚLTIMOS PRODUTOS VENDIDOS");
                            produtos = GerenciadorDeProduto.getInstance().pesquisarUltimosProdutosVendidos();
                            System.out.println("QAUNTIDADE DE PRODUTOS VENDIDOS: "+produtos.size());
                        } catch (ProdutoInexistenteException e) {
                            JOptionPane.showMessageDialog(null, "Ocorreu um erro na pesquisa de produtos. \nPor favor, tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                        }

                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida\n\n Tente novamente", "Aviso", JOptionPane.WARNING_MESSAGE);
                        break;
                }
                if (produtos != null) {
                    adicionarProdutosNaTabela(produtos);
                }
                return null;
            }

            @Override
            protected void done() {
                aguarde.dispose();

            }
        }.execute();
    }

    private void botaoPesquisarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarFornecedorActionPerformed
        if (campoPesquisarFornecedores.getText().equals("Pesquisar Fornecedor") || campoPesquisarFornecedores.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe um nome para a pesquisa de fornecedor", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            aguarde.setLocationRelativeTo(null);
            aguarde.setVisible(true);

            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    try {
                        String textoPesquisado = campoPesquisarFornecedores.getText();

                        //Verifica se o que foi digitado para a pesquisa é um CPF
                        if (textoPesquisado.length() == 14 && (textoPesquisado.charAt(3) == '.' && textoPesquisado.charAt(7) == '.')
                                && textoPesquisado.charAt(11) == '-') {

                            Fornecedor fornecedor = GerenciadorDePessoas.getInstance().pesquisarFornecedorPeloCnpj(textoPesquisado);
                            // Atualiza o model da lista de fornecedores
                            modeloTabelaFornecedores.setRowCount(0);
                            modeloTabelaFornecedores.addRow(new Object[]{fornecedor.getCnpj(), fornecedor.getNome(), fornecedor.getEndereco(), fornecedor.getTelefone()});
                        } else {
                            // Atualiza o model da lista de fornecedores
                            modeloTabelaFornecedores.setRowCount(0);
                            adicionarFornecedoresNaTabela(GerenciadorDePessoas.getInstance().pesquisarFornecedorPeloNome(textoPesquisado));

                        }

                    } catch (FornecedorInexistenteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                    return null;
                }

                @Override
                protected void done() {
                    aguarde.dispose();

                }
            }.execute();
        }
    }//GEN-LAST:event_botaoPesquisarFornecedorActionPerformed

    private void botaoPesquisarLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarLocacaoActionPerformed
        if (campoPesquisarLocacoes.getText().equals("Pesquisar Locação") || campoPesquisarLocacoes.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe o nome do cliente ou uma data para a pesquisa de locação", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            aguarde.setLocationRelativeTo(null);
            aguarde.setVisible(true);

            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    try {
                        // Limpa o model da lista de locações
                        modeloTabelaLocacoes.setRowCount(0);

                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        df.setLenient(false); // O date format não vai aceitar datas inválidas
                        Calendar dataPesquisada = Calendar.getInstance();
                        // Se o que foi digitado para a pesquisa não for uma data válida, será lançada uma exceção ao fazer o parse
                        dataPesquisada.setTime(df.parse(campoPesquisarLocacoes.getText()));

                        for (Locacao locacao : GerenciadorDeLocacao.getInstance().listarLocacoesPorDataDeLocacao(dataPesquisada)) {
                            try {
                                //Adiciona os dados da nova locação na tabela
                                modeloTabelaLocacoes.addRow(new Object[]{locacao.getCliente().getCpf(), locacao.getCliente().getNome(),
                                    GerenciadorDeLocacao.getInstance().getProdutosDeLocacaoInString(locacao.getId()),
                                    "R$ " + locacao.getValorLocacaoInString(), locacao.getDataLocacaoInString(), locacao.getDataDevolucaoInString(), locacao.getStatus(), Long.toString(locacao.getId())});
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                            }
                        }

                    } catch (ParseException e) { //Se o que está sendo pesquisado não for uma data
                        for (Locacao locacao : GerenciadorDeLocacao.getInstance().pesquisarLocacoesDeCliente(campoPesquisarLocacoes.getText())) {
                            try {
                                //Adiciona os dados da locação na tabela
                                modeloTabelaLocacoes.addRow(new Object[]{locacao.getCliente().getCpf(), locacao.getCliente().getNome(),
                                    GerenciadorDeLocacao.getInstance().getProdutosDeLocacaoInString(locacao.getId()),
                                    "R$ " + locacao.getValorLocacaoInString(), locacao.getDataDevolucaoInString(), locacao.getStatus(), Long.toString(locacao.getId())});
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                            }
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
    }//GEN-LAST:event_botaoPesquisarLocacaoActionPerformed

    private void comboFiltrarLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltrarLocacoesActionPerformed
        // Atualiza o model da lista de locações
        modeloTabelaLocacoes.setRowCount(0);
        aguarde.setLocationRelativeTo(null);
        aguarde.setVisible(true);

        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                List<Locacao> locacoes = null;
                switch (comboFiltrarLocacoes.getSelectedItem().toString().toUpperCase()) {

                    case "TODAS":
                        locacoes = GerenciadorDeLocacao.getInstance().getLocacoes();

                        break;

                        
                    case "ATIVAS":
                        locacoes = GerenciadorDeLocacao.getInstance().getLocacoesAtivas();

                        break;
                        
                    case "ATRASADAS":
                        locacoes = GerenciadorDeLocacao.getInstance().listarLocacoesEmAtraso();

                        break;

                    case "EXTRAVIADAS":
                        locacoes = GerenciadorDeLocacao.getInstance().listarLocacoesExtraviadas();

                        break;


                    case "MAIS RECENTES":
                        locacoes = GerenciadorDeLocacao.getInstance().getMostRecentLocation();

                        break;

                    case "MAIS ANTIGAS":
                        //locacoes = GerenciadorDeLocacao.getInstance().getLocacoesMaisAntigas();

                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida\n\n Tente novamente", "Aviso", JOptionPane.WARNING_MESSAGE);
                        break;
                }
                if (locacoes != null) {
                    adicionarLocacoesNaTabela(locacoes);
                }
                return null;
            }

            @Override
            protected void done() {
                aguarde.dispose();

            }
        }.execute();
    }//GEN-LAST:event_comboFiltrarLocacoesActionPerformed

    private void botaoPesquisarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarVendasActionPerformed
        if (campoPesquisarVendas.getText().equals("Pesquisar Venda") || campoPesquisarVendas.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe uma data para a pesquisa de venda", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            aguarde.setLocationRelativeTo(null);
            aguarde.setVisible(true);

            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    try {
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        df.setLenient(false); // O date format não vai aceitar datas inválidas
                        Calendar dataPesquisada = Calendar.getInstance();
                        // Se o que foi digitado para a pesquisa não for uma data válida, será lançada uma exceção ao fazer o parse
                        dataPesquisada.setTime(df.parse(campoPesquisarVendas.getText()));
                        // Limpa o model da lista de movimentacoes
                        modeloTabelaVendas.setRowCount(0);

                        for (Venda venda : GerenciadorDeVenda.getInstance().pesquisarVendasPorData(dataPesquisada)) {
                            modeloTabelaVendas.addRow(new Object[]{venda.getDataVendaInString(), GerenciadorDeVenda.getInstance().getProdutosDeVendaInString(venda.getId()), "R$ " + venda.getValorInString(), venda.getFormaDePagamento()});
                        }

                    } catch (ParseException e) { //Se o que está sendo pesquisado não for uma data
                        JOptionPane.showMessageDialog(null, "Informe uma data válida para a pesquisa", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                    return null;
                }

                @Override
                protected void done() {
                    aguarde.dispose();

                }
            }.execute();

        }
    }//GEN-LAST:event_botaoPesquisarVendasActionPerformed

    private void comboFiltrarMovimentacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltrarMovimentacoesActionPerformed
        // Atualiza o model da lista de movimentações
        modeloTabelaMovimentacoes.setRowCount(0);
        aguarde.setLocationRelativeTo(null);
        aguarde.setVisible(true);

        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                List<Movimentacao> movimentacoes = null;
                switch (comboFiltrarMovimentacoes.getSelectedItem().toString().toUpperCase()) {

                    case "TODAS":
                        movimentacoes = GerenciadorDoSistema.getInstance().getMovimentacoes();

                        break;

                    case "VENDAS":
                        movimentacoes = GerenciadorDoSistema.getInstance().pesquisarMovimentacoesEspecificas("VENDA");

                        break;

                    case "LOCAÇÕES":
                        movimentacoes = GerenciadorDoSistema.getInstance().pesquisarMovimentacoesEspecificas("LOCAÇÃO");

                        break;

                    case "DESPESAS":
                        movimentacoes = GerenciadorDoSistema.getInstance().pesquisarMovimentacoesEspecificas("DESPESA");

                        break;

                    case "PENDÊNCIAS":
                        movimentacoes = GerenciadorDoSistema.getInstance().pesquisarMovimentacoesPendentes();

                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida\n\n Tente novamente", "Aviso", JOptionPane.WARNING_MESSAGE);
                        break;
                }
                if (movimentacoes != null) {
                    adicionarMovimentacoesNaTabela(movimentacoes);
                }
                return null;
            }

            @Override
            protected void done() {
                aguarde.dispose();

            }
        }.execute();
    }//GEN-LAST:event_comboFiltrarMovimentacoesActionPerformed

    private void botaoPesquisarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarUsuarioActionPerformed
        if (campoPesquisarUsuarios.getText().equals("Pesquisar Usuário") || campoPesquisarUsuarios.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe um nome para a pesquisa de usuarios", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            adicionarUsuariosNaTabela(GerenciadorDePessoas.getInstance().pesquisarUsuarioPorNome(campoPesquisarUsuarios.getText()));
        }
    }//GEN-LAST:event_botaoPesquisarUsuarioActionPerformed

    private void radioPesquisarProdutoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPesquisarProdutoCodigoActionPerformed
        radioPesquisarProdutoCodigo.setSelected(true);
        radioPesquisarProdutoNome.setSelected(false);
    }//GEN-LAST:event_radioPesquisarProdutoCodigoActionPerformed

    private void radioPesquisarProdutoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPesquisarProdutoNomeActionPerformed
        radioPesquisarProdutoNome.setSelected(true);
        radioPesquisarProdutoCodigo.setSelected(false);
    }//GEN-LAST:event_radioPesquisarProdutoNomeActionPerformed

    private void comboFiltrarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltrarVendasActionPerformed
        // Atualiza o model da lista de locações
        modeloTabelaVendas.setRowCount(0);
        aguarde.setLocationRelativeTo(null);
        aguarde.setVisible(true);

        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                List<Venda> vendas = null;
                switch (comboFiltrarVendas.getSelectedItem().toString().toUpperCase()) {

                    case "TODAS":
                        vendas = GerenciadorDeVenda.getInstance().getVendas();

                        break;

                    case "MAIS RECENTES":
                        vendas = GerenciadorDeVenda.getInstance().getMostRecentsSales();

                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida\n\n Tente novamente", "Aviso", JOptionPane.WARNING_MESSAGE);
                        break;
                }
                if (vendas != null) {
                    adicionarVendasNaTabela(GerenciadorDeVenda.getInstance().getVendas());
                }
                return null;
            }

            @Override
            protected void done() {
                aguarde.dispose();

            }
        }.execute();
    }//GEN-LAST:event_comboFiltrarVendasActionPerformed

    private void comboFiltrarFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltrarFornecedoresActionPerformed
        if (comboFiltrarFornecedores.getSelectedItem().toString().toUpperCase().equals("TODOS")) {
            // Atualiza o model da lista de fornecedores
            modeloTabelaFornecedores.setRowCount(0);
            try {
                adicionarFornecedoresNaTabela(GerenciadorDePessoas.getInstance().getFornecedores());
            } catch (FornecedorInexistenteException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível fazer a pesquisa de fornecedores.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_comboFiltrarFornecedoresActionPerformed

    private void comboFiltrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltrarUsuariosActionPerformed
        if (comboFiltrarUsuarios.getSelectedItem().toString().toUpperCase().equals("TODOS")) {
            // Atualiza o model da lista de usuarios
            modeloTabelaUsuarios.setRowCount(0);
            adicionarUsuariosNaTabela(GerenciadorDePessoas.getInstance().getUsuarios());
        }
    }//GEN-LAST:event_comboFiltrarUsuariosActionPerformed

    private void campoNomeImpressoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNomeImpressoraMouseClicked
        if (campoNomeImpressora.getText().equals("Informe o nome")) {
            eliminarTextoDeCampo(campoNomeImpressora);
        }
    }//GEN-LAST:event_campoNomeImpressoraMouseClicked

    private void campoNomeImpressoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeImpressoraKeyTyped
        if (campoNomeImpressora.getText().equals("Informe o nome")) {
            eliminarTextoDeCampo(campoNomeImpressora);
        }
    }//GEN-LAST:event_campoNomeImpressoraKeyTyped

    private void botaoAlterarNomeImpressoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarNomeImpressoraActionPerformed
        campoNomeImpressora.setEditable(true);
        botaoSalvarNomeImpressora.setEnabled(true);
    }//GEN-LAST:event_botaoAlterarNomeImpressoraActionPerformed

    private void botaoSalvarNomeImpressoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarNomeImpressoraActionPerformed
        if (campoNomeImpressora.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe o nome da impressora corretamente", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Configuracao configuracao = GerenciadorDoSistema.getInstance().getConfiguracao();
                configuracao.setNomeDaImpressora(campoNomeImpressora.getText());
                GerenciadorDoSistema.getInstance().salvarEstadoDeConfiguracao(configuracao);
                JOptionPane.showMessageDialog(null, "Nome da impressora salvo com sucesso!");
                campoNomeImpressora.setEditable(false);
                botaoSalvarNomeImpressora.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar a alteração feita\n" + e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoSalvarNomeImpressoraActionPerformed

    private void botaoRegistrarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRegistrarDespesaActionPerformed
        RegistrarDespesaDialog dialog = new RegistrarDespesaDialog(null);
        dialog.setLocationRelativeTo(null);
        if (dialog.alterarDados()) {
            adicionarNovaMovimentacaoNaTabela(dialog.getNovaMovimentacao());
        }
        dialog.dispose();
        atualizarValorEmCaixa();
    }//GEN-LAST:event_botaoRegistrarDespesaActionPerformed

    private void labelLogoClosetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogoClosetMouseClicked
        TrocarUsuarioDialog dialog = new TrocarUsuarioDialog(null);
        dialog.setLocationRelativeTo(null);
        if (dialog.alterarDados()) {
            if (!dialog.getNovoUsuarioLogado().isAdministrador()) {
                abas.remove(painelConfiguracoes);
                abas.remove(painelAdministrador);
            } else {
                abas.addTab("Configurações", painelConfiguracoes);
                abas.addTab("Administrador", painelAdministrador);
            }
        }
        labelLoginUsuario.setText("Logado com " + dialog.getNovoUsuarioLogado().getNickName());
        dialog.dispose();
    }//GEN-LAST:event_labelLogoClosetMouseClicked

    private void botaoConsultarDisponibilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarDisponibilidadeActionPerformed
        if (tabelaProdutos.getSelectedRow() >= 0) {
            try {
                //Pesquisa o produto selecionado através do seu código
                VerificarDisponibilidadeDialog dialog = new VerificarDisponibilidadeDialog(null, GerenciadorDeProduto.getInstance().pesquisarProdutoPeloCodigo(
                        (String) tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0)));

                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            } catch (ProdutoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "É preciso selecionar um produto na tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoConsultarDisponibilidadeActionPerformed

    private void botaoGerirValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerirValoresActionPerformed
        GerirDiasDialog dialog = new GerirDiasDialog(null);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_botaoGerirValoresActionPerformed

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
        //Adiciona os dados do novo produto na tabela
        modeloTabelaClientes.addRow(new Object[]{cliente.getCpf(), cliente.getNome(), cliente.getCelular(), cliente.getDataCadastroInString()});
    }

    public void adicionarNovoProdutoNaTabela(Produto produto) {
        //Adiciona os dados do novo produto na tabela
        modeloTabelaProdutos.addRow(new Object[]{produto.getCodigo(), produto.getDescricao(), "R$ " + produto.getValorInString(),
            produto.getQuantidade(), produto.getFinalidade()});
    }

    public void adicionarNovoFornecedorNaTabela(Fornecedor fornecedor) {
        //Adiciona os dados do novo fornecedor na tabela
        modeloTabelaFornecedores.addRow(new Object[]{fornecedor.getCnpj(), fornecedor.getNome(), fornecedor.getEndereco(), fornecedor.getTelefone()});
    }

    public void adicionarNovaLocacaoNaTabela(Locacao locacao) {
        try {
            //Adiciona os dados da nova locação na tabela
            modeloTabelaLocacoes.addRow(new Object[]{locacao.getCliente().getCpf(), locacao.getCliente().getNome(),
                GerenciadorDeLocacao.getInstance().getProdutosDeLocacaoInString(locacao.getId()),
                "R$ " + locacao.getValorLocacaoInString(), locacao.getDataLocacaoInString(), locacao.getDataDevolucaoInString(), locacao.getStatus(), Long.toString(locacao.getId())});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar os dados da locação na tabela:\n" + e.getMessage(),
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void adicionarNovaVendaNaTabela(Venda venda) {
        try {
            //Adiciona os dadosa nova venda na tabela
            modeloTabelaVendas.addRow(new Object[]{venda.getDataVendaInString(), GerenciadorDeVenda.getInstance().getProdutosDeVendaInString(venda.getId()),
                "R$ " + venda.getValorInString(), venda.getFormaDePagamento(), Long.toString(venda.getId())});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar os dados da venda na tabela:\n" + e.getMessage(),
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void adicionarNovaMovimentacaoNaTabela(Movimentacao movimentacao) {
        //Adiciona os dados da nova movimentação na tabela
        modeloTabelaMovimentacoes.addRow(new Object[]{movimentacao.getMovimento(), "R$ " + movimentacao.getValorInString(),
            movimentacao.getDataInString(), movimentacao.getResponsavel(), movimentacao.getBeneficiario(), Long.toString(movimentacao.getIdDaOperacao())});
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
        String cpfSelecionado = cliente.getCpf();
        if (cpfSelecionado.equals((String) modeloTabelaClientes.getValueAt(linha, 0))) {
            //Coluna de índice  1 = nome do cliente
            modeloTabelaClientes.setValueAt(cliente.getNome(), linha, 1);
            //Coluna de índice  2 = contado
            modeloTabelaClientes.setValueAt(cliente.getCelular(), linha, 2);
        } else {
            for (int i = 0; i < modeloTabelaClientes.getRowCount(); i++) {
                if (cpfSelecionado.equals((String) modeloTabelaClientes.getValueAt(i, 0))) {
                    //Coluna de índice  1 = nome do cliente
                    modeloTabelaClientes.setValueAt(cliente.getNome(), i, 1);
                    //Coluna de índice  2 = contado
                    modeloTabelaClientes.setValueAt(cliente.getCelular(), i, 2);

                    break;
                }
            }
        }
    }

    public void atualizarDadosProdutoNaTabela(Produto produto, int linha) {
        String codigoProduto = produto.getCodigo();
        if (codigoProduto.equals((String) modeloTabelaProdutos.getValueAt(linha, 0))) {
            //Coluna de descrição
            modeloTabelaProdutos.setValueAt(produto.getDescricao(), linha, 1);
            //Coluna de descrição
            modeloTabelaProdutos.setValueAt("R$ " + produto.getValorInString(), linha, 2);
            //Coluna de descrição
            modeloTabelaProdutos.setValueAt(produto.getQuantidade(), linha, 3);
            //Coluna de descrição
            modeloTabelaProdutos.setValueAt(produto.getFinalidade(), linha, 4);
        } else {
            for (int i = 0; i < modeloTabelaProdutos.getRowCount(); i++) {
                if (codigoProduto.equals((String) modeloTabelaProdutos.getValueAt(i, 0))) {
                    //Coluna de descrição
                    modeloTabelaProdutos.setValueAt(produto.getDescricao(), i, 1);
                    //Coluna de descrição
                    modeloTabelaProdutos.setValueAt("R$ " + produto.getValorInString(), i, 2);
                    //Coluna de descrição
                    modeloTabelaProdutos.setValueAt(produto.getQuantidade(), i, 3);
                    //Coluna de descrição
                    modeloTabelaProdutos.setValueAt(produto.getFinalidade(), i, 4);

                    break;
                }
            }
        }

    }

    public void atualizarDadosFornecedorNaTabela(Fornecedor fornecedor, int linha) {
        String cnpjSelecionado = fornecedor.getCnpj();
        if (cnpjSelecionado.equals((String) modeloTabelaFornecedores.getValueAt(linha, 0))) {
            //Coluna de nome
            modeloTabelaFornecedores.setValueAt(fornecedor.getNome(), linha, 1);
            //Coluna de endereo
            modeloTabelaFornecedores.setValueAt(fornecedor.getEnderecoInString(), linha, 2);
            //Coluna de índice telefone
            modeloTabelaFornecedores.setValueAt(fornecedor.getTelefone(), linha, 3);
        } else {
            for (int i = 0; i < modeloTabelaFornecedores.getRowCount(); i++) {
                if (cnpjSelecionado.equals((String) modeloTabelaFornecedores.getValueAt(i, 0))) {
                    //Coluna de nome
                    modeloTabelaFornecedores.setValueAt(fornecedor.getNome(), i, 1);
                    //Coluna de endereo
                    modeloTabelaFornecedores.setValueAt(fornecedor.getEnderecoInString(), i, 2);
                    //Coluna de índice telefone
                    modeloTabelaFornecedores.setValueAt(fornecedor.getTelefone(), i, 3);

                    break;
                }
            }
        }

    }

    public void atualizarDadosDespesaNaTabela(Movimentacao movimentacao, int linha) {
        String idSelecionado = Long.toString(movimentacao.getIdDaOperacao());
        if (idSelecionado.equals((String) modeloTabelaMovimentacoes.getValueAt(linha, 0))) {
            //Coluna de valor
            modeloTabelaMovimentacoes.setValueAt(movimentacao.getValorInString(), linha, 1);
            //Coluna de responsável
            modeloTabelaMovimentacoes.setValueAt(movimentacao.getResponsavel(), linha, 3);
            //Coluna de beneficiário
            modeloTabelaMovimentacoes.setValueAt(movimentacao.getBeneficiario(), linha, 4);
        } else {
            for (int i = 0; i < modeloTabelaMovimentacoes.getRowCount(); i++) {
                if (idSelecionado.equals((String) modeloTabelaMovimentacoes.getValueAt(i, 0))) {
                    //Coluna de valor
                    modeloTabelaMovimentacoes.setValueAt(movimentacao.getValorInString(), i, 1);
                    //Coluna de responsável
                    modeloTabelaMovimentacoes.setValueAt(movimentacao.getResponsavel(), i, 3);
                    //Coluna de beneficiário
                    modeloTabelaMovimentacoes.setValueAt(movimentacao.getBeneficiario(), i, 4);

                    break;
                }
            }
        }

    }

    public void atualizarDadosUsuarioNaTabela(Usuario usuario, int linha) {
        String loginSelecionado = usuario.getNickName();
        if (loginSelecionado.equals((String) modeloTabelaUsuarios.getValueAt(linha, 0))) {
            //Coluna de nome
            modeloTabelaUsuarios.setValueAt(usuario.getNome(), linha, 0);
            //Coluna de nome
            modeloTabelaUsuarios.setValueAt(usuario.getCategoria(), linha, 2);
        } else {
            for (int i = 0; i < modeloTabelaUsuarios.getRowCount(); i++) {
                if (loginSelecionado.equals((String) modeloTabelaUsuarios.getValueAt(i, 0))) {
                    //Coluna de nome
                    modeloTabelaUsuarios.setValueAt(usuario.getNome(), i, 0);
                    //Coluna de nome
                    modeloTabelaUsuarios.setValueAt(usuario.getCategoria(), i, 2);

                    break;
                }
            }
        }

    }

    public void atualizarStatusDeLocacao(String idLocacao, int linha) {
        int quantColunas = modeloTabelaLocacoes.getColumnCount();
        if (idLocacao.equals((String) modeloTabelaLocacoes.getValueAt(linha, quantColunas - 1))) {
            //Atualiza a coluna de status
            modeloTabelaLocacoes.setValueAt("Fechada", linha, quantColunas - 2);

        } else {
            //Varre o model da tabela para atualizar o status na linha correta
            for (int i = 0; i < modeloTabelaLocacoes.getRowCount(); i++) {
                if (idLocacao.equals((String) modeloTabelaLocacoes.getValueAt(i, quantColunas - 1))) {
                    //Coluna de nome
                    modeloTabelaLocacoes.setValueAt("Fechada", i, quantColunas - 2);

                    break;
                }
            }
        }
    }

    public void atualizarValorEmCaixa() {
        double valorEmCaixa = GerenciadorDoSistema.getInstance().getValorCaixaDiario();
        if (valorEmCaixa > 0) {
            labelValorEmCaixa.setForeground(new Color(0, 153, 0));
        } else {
            labelValorEmCaixa.setForeground(new Color(255, 0, 0));
        }
        labelValorEmCaixa.setText("R$ " + new DecimalFormat("0.00").format(valorEmCaixa));
    }

    public void desabilitarCamposDeDiretorios() {
        campoDiretorioBackup.setEditable(false);
        campoDiretorioDocumentos.setEditable(false);
        campoDiretorioRelatorios.setEditable(false);
        campoNomeImpressora.setEditable(false);
        botaoSalvarDiretorioBackup.setEnabled(false);
        botaoSalvarDiretorioDocumentos.setEnabled(false);
        botaoSalvarDiretorioRelatorios.setEnabled(false);
        botaoSalvarNomeImpressora.setEnabled(false);
    }

    public void adicionarClientesNaTabela(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            modeloTabelaClientes.addRow(new Object[]{cliente.getCpf(), cliente.getNome(), cliente.getCelular(), cliente.getDataCadastroInString()});
        }
    }

    public void adicionarProdutosNaTabela(List<Produto> produtos) {
        //Limpa a tabela de produtos
        modeloTabelaProdutos.setRowCount(0);
        for (Produto produto : produtos) {
            modeloTabelaProdutos.addRow(new Object[]{produto.getCodigo(), produto.getDescricao(), "R$ " + produto.getValorInString(),
                produto.getQuantidade(), produto.getFinalidade()});
        }
    }

    public void adicionarFornecedoresNaTabela(List<Fornecedor> fornecedores) {
        for (Fornecedor fornecedor : fornecedores) {
            modeloTabelaFornecedores.addRow(new Object[]{fornecedor.getCnpj(), fornecedor.getNome(), fornecedor.getEndereco(), fornecedor.getTelefone()});
        }
    }

    public void adicionarLocacoesNaTabela(List<Locacao> locacoes) {
        try {
            //Adiciona os dados das locação na tabela
            for (Locacao locacao : locacoes) {
                modeloTabelaLocacoes.addRow(new Object[]{locacao.getCliente().getCpf(), locacao.getCliente().getNome(),
                    GerenciadorDeLocacao.getInstance().getProdutosDeLocacaoInString(locacao.getId()),
                    "R$ " + locacao.getValorLocacaoInString(), locacao.getDataLocacaoInString(), locacao.getDataDevolucaoInString(), locacao.getStatus(), Long.toString(locacao.getId())});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void adicionarVendasNaTabela(List<Venda> vendas) {
        for (Venda venda : vendas) {
            try {
                modeloTabelaVendas.addRow(new Object[]{venda.getDataVendaInString(), GerenciadorDeVenda.getInstance().getProdutosDeVendaInString(venda.getId()), "R$ " + venda.getValorInString(), venda.getFormaDePagamento()});
            } catch (ProdutoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            } catch (VendaInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void adicionarMovimentacoesNaTabela(List<Movimentacao> movimentacoes) {
        for (Movimentacao movimentacao : movimentacoes) {
            modeloTabelaMovimentacoes.addRow(new Object[]{movimentacao.getMovimento(), "R$ " + movimentacao.getValorInString(),
                movimentacao.getDataInString(), movimentacao.getResponsavel(), movimentacao.getBeneficiario(), Long.toString(movimentacao.getIdDaOperacao())});
        }
    }

    public void adicionarUsuariosNaTabela(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            modeloTabelaUsuarios.addRow(new Object[]{usuario.getNome(), usuario.getNickName(), usuario.getCategoria()});
        }
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
            java.util.logging.Logger.getLogger(PrincipalFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFrame(null).setVisible(true);
            }
        });
    }

    private final AguardeDialog aguarde = new AguardeDialog(null);
    private String loginUsuario;
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
    private javax.swing.JButton botaoAlterarNomeImpressora;
    private javax.swing.JButton botaoAtivarTemporada;
    private javax.swing.JButton botaoConsultarDisponibilidade;
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
    private javax.swing.JButton botaoFinalizarLocacao;
    private javax.swing.JButton botaoGerarReciboLocacao;
    private javax.swing.JButton botaoGerarRelatorio;
    private javax.swing.JButton botaoGerirValores;
    private javax.swing.JButton botaoNovaLocacao;
    private javax.swing.JButton botaoNovaVenda;
    private javax.swing.JButton botaoNovoCliente;
    private javax.swing.JButton botaoNovoFornecedor;
    private javax.swing.JButton botaoNovoProduto;
    private javax.swing.JButton botaoNovoUsuario;
    private javax.swing.JButton botaoPesquisarCliente;
    private javax.swing.JButton botaoPesquisarFornecedor;
    private javax.swing.JButton botaoPesquisarLocacao;
    private javax.swing.JButton botaoPesquisarProduto;
    private javax.swing.JButton botaoPesquisarUsuario;
    private javax.swing.JButton botaoPesquisarVendas;
    private javax.swing.JButton botaoRegistrarDespesa;
    private javax.swing.JLabel botaoSair;
    private javax.swing.JButton botaoSalvarDiretorioBackup;
    private javax.swing.JButton botaoSalvarDiretorioDocumentos;
    private javax.swing.JButton botaoSalvarDiretorioRelatorios;
    private javax.swing.JButton botaoSalvarNomeImpressora;
    private javax.swing.JButton botaoVerContrato;
    private javax.swing.JButton botaoVerLocacoesCliente;
    private javax.swing.JButton botaoVerRecibosLocacao;
    private javax.swing.JButton botaoVerRecibosVenda;
    private javax.swing.JTextField campoDiretorioBackup;
    private javax.swing.JTextField campoDiretorioDocumentos;
    private javax.swing.JTextField campoDiretorioRelatorios;
    private javax.swing.JTextField campoNomeImpressora;
    private javax.swing.JTextField campoPesquisarClientes;
    private javax.swing.JTextField campoPesquisarFornecedores;
    private javax.swing.JTextField campoPesquisarLocacoes;
    private javax.swing.JTextField campoPesquisarProdutos;
    private javax.swing.JTextField campoPesquisarUsuarios;
    private javax.swing.JTextField campoPesquisarVendas;
    private javax.swing.JComboBox comboFiltrarClientes;
    private javax.swing.JComboBox comboFiltrarFornecedores;
    private javax.swing.JComboBox comboFiltrarLocacoes;
    private javax.swing.JComboBox comboFiltrarMovimentacoes;
    private javax.swing.JComboBox comboFiltrarProdutos;
    private javax.swing.JComboBox comboFiltrarUsuarios;
    private javax.swing.JComboBox comboFiltrarVendas;
    private javax.swing.JLabel labelDiretorioBackups;
    private javax.swing.JLabel labelDiretorioDocumentos;
    private javax.swing.JLabel labelDiretorioRelatorios;
    private javax.swing.JLabel labelFiltrarClientes;
    private javax.swing.JLabel labelFiltrarFornecedores;
    private javax.swing.JLabel labelFiltrarLocacoes;
    private javax.swing.JLabel labelFiltrarMovimentacao;
    private javax.swing.JLabel labelFiltrarProdutos;
    private javax.swing.JLabel labelFiltrarUsuarios;
    private javax.swing.JLabel labelFiltrarVenda;
    private javax.swing.JLabel labelLoginUsuario;
    private javax.swing.JLabel labelLogoCloset;
    private javax.swing.JLabel labelLogoEmpresa;
    private javax.swing.JLabel labelNomeImpressora;
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
    private javax.swing.JRadioButton radioPesquisarProdutoCodigo;
    private javax.swing.JRadioButton radioPesquisarProdutoNome;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTable tabelaFornecedores;
    private javax.swing.JTable tabelaLocacoes;
    private javax.swing.JTable tabelaMovimentacoes;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTable tabelaUsuarios;
    private javax.swing.JTable tabelaVendas;
    // End of variables declaration//GEN-END:variables
}
