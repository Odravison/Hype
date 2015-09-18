/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.controller.GerenciadorDePessoas;
import br.oltecnologias.hype.model.Cliente;
import br.oltecnologias.hype.model.Endereco;
import br.oltecnologias.hype.model.Medidas;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Luender Lima
 */
public class EditarClienteDialog extends java.awt.Dialog {
    
    public EditarClienteDialog(java.awt.Frame parent, Cliente cliente) {
        super(parent);
        this.cliente = cliente;
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/oltecnologias/hype/imagens/Icon borda branca.png")).getImage());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelMedidas = new javax.swing.JPanel();
        labelCalca = new javax.swing.JLabel();
        labelColete = new javax.swing.JLabel();
        labelObservacao = new javax.swing.JLabel();
        labelSapato = new javax.swing.JLabel();
        labelCompriCalca = new javax.swing.JLabel();
        labelBlazer = new javax.swing.JLabel();
        scPnObservacao = new javax.swing.JScrollPane();
        areaObservacao = new javax.swing.JTextArea();
        labelCamisa = new javax.swing.JLabel();
        labelComprimentoManga = new javax.swing.JLabel();
        labelCmCompriCal = new javax.swing.JLabel();
        labelCompriCal = new javax.swing.JLabel();
        campoComprimentoCalca = new javax.swing.JTextField();
        campoBlazer = new javax.swing.JTextField();
        campoCalca = new javax.swing.JTextField();
        campoColete = new javax.swing.JTextField();
        campoCamisa = new javax.swing.JTextField();
        campoSapato = new javax.swing.JTextField();
        campoComprimentoManga = new javax.swing.JTextField();
        painelDadosPessoais = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelCpf = new javax.swing.JLabel();
        painelEndereco = new javax.swing.JPanel();
        labelRua = new javax.swing.JLabel();
        campoRua = new javax.swing.JTextField();
        labelNumero = new javax.swing.JLabel();
        labelBairro = new javax.swing.JLabel();
        campoBairro = new javax.swing.JTextField();
        labelCidade = new javax.swing.JLabel();
        campoCidade = new javax.swing.JTextField();
        labelUf = new javax.swing.JLabel();
        comboUf = new javax.swing.JComboBox();
        campoNumero = new javax.swing.JTextField();
        labelTelResidencial = new javax.swing.JLabel();
        labelCel = new javax.swing.JLabel();
        campoCpf = new javax.swing.JFormattedTextField();
        campoCel = new javax.swing.JFormattedTextField();
        campoTelefone = new javax.swing.JFormattedTextField();
        labelObrigatório = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Editar Cliente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        botaoSalvar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoSalvar.setText(" Salvar ");
        botaoSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSalvar.setIcon(new ImageIcon("Imagens\\Salvar.png"));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.setIcon(new ImageIcon("Imagens\\Cancelar.png"));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        painelMedidas.setBackground(new java.awt.Color(255, 255, 255));
        painelMedidas.setBorder(javax.swing.BorderFactory.createTitledBorder("Medidas"));
        painelMedidas.setPreferredSize(new java.awt.Dimension(635, 238));

        labelCalca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCalca.setText("Calça:");

        labelColete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelColete.setText("Colete:");

        labelObservacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelObservacao.setText("Observação:");

        labelSapato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSapato.setText("Sapato:");

        labelCompriCalca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCompriCalca.setText("Comprimento da calça:");

        labelBlazer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelBlazer.setText("Blazer:");

        scPnObservacao.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        areaObservacao.setColumns(20);
        areaObservacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        areaObservacao.setLineWrap(true);
        areaObservacao.setRows(5);
        areaObservacao.setWrapStyleWord(true);
        areaObservacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaObservacaoKeyTyped(evt);
            }
        });
        areaObservacao.setText(cliente.getMedidas().getObservacao());
        scPnObservacao.setViewportView(areaObservacao);

        labelCamisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCamisa.setText("Camisa:");

        labelComprimentoManga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelComprimentoManga.setText("Comprimento da manga:");

        labelCmCompriCal.setText("cm");

        labelCompriCal.setText("cm");

        campoComprimentoCalca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoComprimentoCalca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoComprimentoCalcaKeyTyped(evt);
            }
        });
        campoComprimentoCalca.setText(cliente.getMedidas().getComprimentoCalca()+"");

        campoBlazer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoBlazer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBlazerKeyTyped(evt);
            }
        });
        campoBlazer.setText(cliente.getMedidas().getBlazer()+"");

        campoCalca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoCalca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCalcaKeyTyped(evt);
            }
        });
        campoCalca.setText(cliente.getMedidas().getCalca()+"");

        campoColete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoColete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoColeteKeyTyped(evt);
            }
        });
        campoColete.setText(cliente.getMedidas().getColete()+"");

        campoCamisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoCamisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCamisaKeyTyped(evt);
            }
        });
        campoCamisa.setText(cliente.getMedidas().getCamisa()+"");

        campoSapato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoSapato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoSapatoKeyTyped(evt);
            }
        });
        campoSapato.setText(cliente.getMedidas().getSapato()+"");

        campoComprimentoManga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoComprimentoManga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoComprimentoMangaKeyTyped(evt);
            }
        });
        campoComprimentoManga.setText(cliente.getMedidas().getComprimentoManga()+"");

        javax.swing.GroupLayout painelMedidasLayout = new javax.swing.GroupLayout(painelMedidas);
        painelMedidas.setLayout(painelMedidasLayout);
        painelMedidasLayout.setHorizontalGroup(
            painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMedidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelMedidasLayout.createSequentialGroup()
                        .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMedidasLayout.createSequentialGroup()
                                .addComponent(labelBlazer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoBlazer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(painelMedidasLayout.createSequentialGroup()
                                .addComponent(labelSapato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoSapato, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelComprimentoManga)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMedidasLayout.createSequentialGroup()
                                .addComponent(labelCalca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCalca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelMedidasLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(campoComprimentoManga, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(labelCmCompriCal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(labelCompriCalca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(painelMedidasLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(labelColete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoColete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(labelCamisa)
                                .addGap(1, 1, 1)))
                        .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelMedidasLayout.createSequentialGroup()
                                .addComponent(campoComprimentoCalca, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCompriCal))))
                    .addGroup(painelMedidasLayout.createSequentialGroup()
                        .addComponent(labelObservacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scPnObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelMedidasLayout.setVerticalGroup(
            painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMedidasLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCalca)
                    .addComponent(labelBlazer)
                    .addComponent(labelColete)
                    .addComponent(labelCamisa)
                    .addComponent(campoBlazer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCalca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoColete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSapato)
                    .addComponent(labelCompriCalca)
                    .addComponent(labelComprimentoManga)
                    .addComponent(labelCmCompriCal)
                    .addComponent(labelCompriCal)
                    .addComponent(campoComprimentoCalca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSapato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoComprimentoManga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObservacao)
                    .addComponent(scPnObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        painelDadosPessoais.setBackground(new java.awt.Color(255, 255, 255));
        painelDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados pessoais"));

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNome.setText("Nome:*");

        campoNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNomeKeyTyped(evt);
            }
        });
        campoNome.setText(cliente.getNome());

        labelCpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCpf.setText("CPF:*");

        painelEndereco.setBackground(new java.awt.Color(255, 255, 255));
        painelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        labelRua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelRua.setText("Rua:*");

        campoRua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoRuaKeyTyped(evt);
            }
        });
        campoRua.setText(cliente.getEndereco().getRua());

        labelNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumero.setText("Número:*");

        labelBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelBairro.setText("Bairro:*");

        campoBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBairroKeyTyped(evt);
            }
        });
        campoBairro.setText(cliente.getEndereco().getBairro());

        labelCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCidade.setText("Cidade:*");

        campoCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCidadeKeyTyped(evt);
            }
        });
        campoCidade.setText(cliente.getEndereco().getCidade());

        labelUf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelUf.setText("UF:*");

        comboUf.setMaximumRowCount(20);
        comboUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PB", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        comboUf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboUf.setSelectedItem(cliente.getEndereco().getUf());

        campoNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumeroKeyTyped(evt);
            }
        });
        campoNumero.setText(cliente.getEndereco().getNumeroCasa()+"");

        javax.swing.GroupLayout painelEnderecoLayout = new javax.swing.GroupLayout(painelEndereco);
        painelEndereco.setLayout(painelEnderecoLayout);
        painelEnderecoLayout.setHorizontalGroup(
            painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                        .addComponent(labelRua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(labelNumero))
                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                        .addComponent(labelBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(labelCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(labelUf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelEnderecoLayout.setVerticalGroup(
            painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRua)
                    .addComponent(campoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumero)
                    .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBairro)
                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCidade)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUf)
                    .addComponent(comboUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        labelTelResidencial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTelResidencial.setText("Telefone residencial:");

        labelCel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCel.setText("Celular:*");

        campoCpf.setEditable(false);
        try {
            campoCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoCpf.setText(cliente.getCpf());

        try {
            campoCel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoCel.setText(cliente.getCelular());

        try {
            campoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoTelefone.setText(cliente.getTelefone());

        javax.swing.GroupLayout painelDadosPessoaisLayout = new javax.swing.GroupLayout(painelDadosPessoais);
        painelDadosPessoais.setLayout(painelDadosPessoaisLayout);
        painelDadosPessoaisLayout.setHorizontalGroup(
            painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(labelCpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(labelTelResidencial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(labelCel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelDadosPessoaisLayout.setVerticalGroup(
            painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCpf)
                    .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(painelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelResidencial)
                    .addComponent(labelCel)
                    .addComponent(campoCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelObrigatório.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelObrigatório.setText("* Obrigatório");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(painelMedidas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelDadosPessoais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelObrigatório)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(painelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(painelMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoSalvar)
                        .addComponent(botaoCancelar))
                    .addComponent(labelObrigatório))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        try {
            if(campoNome.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o nome do cliente", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoRua.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a rua do cliente", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoCidade.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a cidade do cliente", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoBairro.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o bairro do cliente", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoNumero.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o número da casa do cliente", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoCel.getText().charAt(14) == ' ') { //O último caractere do número de cel não pode ser vazio
                JOptionPane.showMessageDialog(null, "Informe o número de celular completo do cliente", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {

                Endereco endereco = cliente.getEndereco();
                endereco.setCidade(campoCidade.getText());
                endereco.setNumeroCasa(Integer.parseInt(campoNumero.getText()));
                endereco.setRua(campoRua.getText());
                endereco.setBairro(campoBairro.getText());
                endereco.setUf(comboUf.getSelectedItem().toString());

                Medidas medidas = cliente.getMedidas();

                // Talvez, nem todos os valores das medidas serão informados
                if(campoBlazer.getText().length() <= 0) {
                    medidas.setBlazer(0);
                } else {
                    medidas.setBlazer(Integer.parseInt(campoBlazer.getText()));
                }
                if(campoCalca.getText().length() <= 0) {
                    medidas.setCalca(0);
                } else {
                    medidas.setCalca(Integer.parseInt(campoCalca.getText()));
                }
                if(campoColete.getText().length() <=0) {
                    medidas.setColete(0);
                } else {
                    medidas.setColete(Integer.parseInt(campoColete.getText()));
                }
                if(campoCamisa.getText().length() <=0) {
                    medidas.setCamisa(0);
                } else {
                    medidas.setCamisa(Integer.parseInt(campoCamisa.getText()));
                }
                if(campoSapato.getText().length() <=0) {
                    medidas.setSapato(0);
                } else {
                    medidas.setSapato(Integer.parseInt(campoSapato.getText()));
                }
                if(campoComprimentoCalca.getText().length() <= 0) {
                    medidas.setComprimentoCalca(0);
                } else {
                    medidas.setComprimentoCalca(Integer.parseInt(campoComprimentoCalca.getText()));
                }
                if(campoComprimentoManga.getText().length() <=0) {
                    medidas.setComprimentoManga(0);
                } else  {
                    medidas.setComprimentoManga(Integer.parseInt(campoComprimentoManga.getText()));
                }
                
                //Tratamento caso o número de telefone residencial não seja informado
                if (campoTelefone.getText().length() <= 0) {
                    campoTelefone.setText("Não informado");
                }
                medidas.setObservacao(areaObservacao.getText());
                
                cliente.setNome(campoNome.getText());
                cliente.setTelefone(campoTelefone.getText());
                cliente.setCelular(campoCel.getText());
                //tirar o última medição
                try {
                    
                    GerenciadorDePessoas.getInstance().editarCliente(cliente);

                    JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
                    
                    //O botão Salvar foi selecionado
                    salvarSelecionado = true; 
                    setVisible(false);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void areaObservacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaObservacaoKeyTyped
        if(areaObservacao.getText().length()>= maxCaracteresObs){
            evt.consume();
        }
    }//GEN-LAST:event_areaObservacaoKeyTyped

    private void campoComprimentoCalcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoComprimentoCalcaKeyTyped
        validarNumerosETamanho(evt, campoComprimentoCalca, maxCaracteresComprimento); // o comprimento máximo da manga também serve para o da calça
    }//GEN-LAST:event_campoComprimentoCalcaKeyTyped

    private void campoBlazerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBlazerKeyTyped
        validarNumerosETamanho(evt, campoBlazer, maxCaracteresMedidas);
    }//GEN-LAST:event_campoBlazerKeyTyped

    private void campoCalcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCalcaKeyTyped
        validarNumerosETamanho(evt, campoCalca, maxCaracteresMedidas);
    }//GEN-LAST:event_campoCalcaKeyTyped

    private void campoColeteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoColeteKeyTyped
        validarNumerosETamanho(evt, campoColete, maxCaracteresMedidas);
    }//GEN-LAST:event_campoColeteKeyTyped

    private void campoCamisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCamisaKeyTyped
        validarNumerosETamanho(evt, campoCamisa, maxCaracteresMedidas);
    }//GEN-LAST:event_campoCamisaKeyTyped

    private void campoSapatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSapatoKeyTyped
        validarNumerosETamanho(evt, campoSapato, maxCaracteresMedidas);
    }//GEN-LAST:event_campoSapatoKeyTyped

    private void campoComprimentoMangaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoComprimentoMangaKeyTyped
        validarNumerosETamanho(evt, campoComprimentoCalca, maxCaracteresComprimento);
    }//GEN-LAST:event_campoComprimentoMangaKeyTyped

    private void campoNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeKeyTyped
        validarLetrasETamanho(evt, campoNome, maxCaracteresNome);
    }//GEN-LAST:event_campoNomeKeyTyped

    private void campoRuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoRuaKeyTyped
        if(campoRua.getText().length()>= maxCaracteresNome){ //O mesmo limite de tamanho para nome do cliente e nome da rua
            evt.consume();
        }
    }//GEN-LAST:event_campoRuaKeyTyped

    private void campoBairroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBairroKeyTyped
        if(campoBairro.getText().length()>= maxCaracteresBairro){
            evt.consume();
        }
    }//GEN-LAST:event_campoBairroKeyTyped

    private void campoCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCidadeKeyTyped
        validarLetrasETamanho(evt, campoCidade, maxCaracteresBairro); // Mesmo tamanho para nomes de bairros e cidades
    }//GEN-LAST:event_campoCidadeKeyTyped

    private void campoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumeroKeyTyped
        validarNumerosETamanho(evt, campoNumero, maxCaracteresNumero);
    }//GEN-LAST:event_campoNumeroKeyTyped

    private void validarLetrasETamanho(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int maxCaracteres) { 
        if(numeros.contains(evt.getKeyChar()+"")){// se o carácter que gerou o evento estiver na lista 
            evt.consume();
        } 
        if(campo.getText().length()>= maxCaracteres){
            evt.consume();
        }
    }
    
    public void validarNumerosETamanho(java.awt.event.KeyEvent evt, javax.swing.JTextField campo, int maxCaracteres) {
        if(!numeros.contains(evt.getKeyChar()+"")){// se o carácter que gerou o evento não estiver na lista 
            evt.consume();
        } 
        if(campo.getText().length()>= maxCaracteres){
            evt.consume();
        }
    }
    
    public boolean alterarDados() {        
        salvarSelecionado = false;  //Marcamos que o salavar não foi selecionado
        setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible ap�s ficar invisível.
        setVisible(true);       //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
        return salvarSelecionado;   //Retornamos true, se ele pressionou ok.
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    private Cliente cliente;
    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresNome = 40;
    private int maxCaracteresBairro = 30;
    private int maxCaracteresNumero = 4;
    private int maxCaracteresObs = 450;
    private int maxCaracteresComprimento = 4;
    private int maxCaracteresMedidas = 2;
    protected boolean salvarSelecionado;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaObservacao;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JTextField campoBlazer;
    private javax.swing.JTextField campoCalca;
    private javax.swing.JTextField campoCamisa;
    private javax.swing.JFormattedTextField campoCel;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoColete;
    private javax.swing.JTextField campoComprimentoCalca;
    private javax.swing.JTextField campoComprimentoManga;
    private javax.swing.JFormattedTextField campoCpf;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoRua;
    private javax.swing.JTextField campoSapato;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.JComboBox comboUf;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelBlazer;
    private javax.swing.JLabel labelCalca;
    private javax.swing.JLabel labelCamisa;
    private javax.swing.JLabel labelCel;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelCmCompriCal;
    private javax.swing.JLabel labelColete;
    private javax.swing.JLabel labelCompriCal;
    private javax.swing.JLabel labelCompriCalca;
    private javax.swing.JLabel labelComprimentoManga;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelObrigatório;
    private javax.swing.JLabel labelObservacao;
    private javax.swing.JLabel labelRua;
    private javax.swing.JLabel labelSapato;
    private javax.swing.JLabel labelTelResidencial;
    private javax.swing.JLabel labelUf;
    private javax.swing.JPanel painelDadosPessoais;
    private javax.swing.JPanel painelEndereco;
    private javax.swing.JPanel painelMedidas;
    private javax.swing.JScrollPane scPnObservacao;
    // End of variables declaration//GEN-END:variables
}
