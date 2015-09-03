/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

/**
 *
 * @author Cliente
 */
public class EditarEmpresaDialog extends java.awt.Dialog {

    /**
     * Creates new form EditarEmpresaDialog
     */
    public EditarEmpresaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDadosPessoais2 = new javax.swing.JPanel();
        labelNome2 = new javax.swing.JLabel();
        campoNome2 = new javax.swing.JTextField();
        labelCNPJ2 = new javax.swing.JLabel();
        painelEndereco2 = new javax.swing.JPanel();
        labelRua2 = new javax.swing.JLabel();
        campoRua2 = new javax.swing.JTextField();
        labelNumero2 = new javax.swing.JLabel();
        labelBairro2 = new javax.swing.JLabel();
        campoBairro2 = new javax.swing.JTextField();
        labelCidade2 = new javax.swing.JLabel();
        campoCidade2 = new javax.swing.JTextField();
        labelUf2 = new javax.swing.JLabel();
        comboUf2 = new javax.swing.JComboBox();
        campoNumero2 = new javax.swing.JTextField();
        labelTelefone = new javax.swing.JLabel();
        campoCnpj = new javax.swing.JFormattedTextField();
        campoTelefone = new javax.swing.JFormattedTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setTitle("Editar Empresa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelDadosPessoais2.setBackground(new java.awt.Color(255, 255, 255));
        painelDadosPessoais2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"));

        labelNome2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNome2.setText("Nome:");

        campoNome2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNome2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNome2KeyTyped(evt);
            }
        });

        labelCNPJ2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCNPJ2.setText("CNPJ:");

        painelEndereco2.setBackground(new java.awt.Color(255, 255, 255));
        painelEndereco2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        labelRua2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelRua2.setText("Rua:");

        campoRua2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoRua2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoRua2KeyTyped(evt);
            }
        });

        labelNumero2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumero2.setText("Número:");

        labelBairro2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelBairro2.setText("Bairro:");

        campoBairro2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoBairro2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBairro2KeyTyped(evt);
            }
        });

        labelCidade2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCidade2.setText("Cidade:");

        campoCidade2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoCidade2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCidade2KeyTyped(evt);
            }
        });

        labelUf2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelUf2.setText("UF:");

        comboUf2.setMaximumRowCount(20);
        comboUf2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PB", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        comboUf2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        campoNumero2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNumero2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumero2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout painelEndereco2Layout = new javax.swing.GroupLayout(painelEndereco2);
        painelEndereco2.setLayout(painelEndereco2Layout);
        painelEndereco2Layout.setHorizontalGroup(
            painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEndereco2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEndereco2Layout.createSequentialGroup()
                        .addComponent(labelRua2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoRua2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(labelNumero2))
                    .addGroup(painelEndereco2Layout.createSequentialGroup()
                        .addComponent(labelBairro2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBairro2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(labelCidade2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEndereco2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(labelUf2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboUf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(painelEndereco2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelEndereco2Layout.setVerticalGroup(
            painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEndereco2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRua2)
                    .addComponent(campoRua2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumero2)
                    .addComponent(campoNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEndereco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBairro2)
                    .addComponent(campoBairro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCidade2)
                    .addComponent(campoCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUf2)
                    .addComponent(comboUf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        labelTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTelefone.setText("Telefone:");

        campoCnpj.setEditable(false);
        try {
            campoCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCnpj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            campoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout painelDadosPessoais2Layout = new javax.swing.GroupLayout(painelDadosPessoais2);
        painelDadosPessoais2.setLayout(painelDadosPessoais2Layout);
        painelDadosPessoais2Layout.setHorizontalGroup(
            painelDadosPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoais2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosPessoais2Layout.createSequentialGroup()
                        .addComponent(painelEndereco2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(painelDadosPessoais2Layout.createSequentialGroup()
                        .addComponent(labelNome2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCNPJ2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(painelDadosPessoais2Layout.createSequentialGroup()
                        .addComponent(labelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelDadosPessoais2Layout.setVerticalGroup(
            painelDadosPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoais2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome2)
                    .addComponent(campoNome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCNPJ2)
                    .addComponent(campoCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(painelEndereco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefone)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.setIcon(new ImageIcon("Imagens\\Cancelar.png"));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(painelDadosPessoais2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelDadosPessoais2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addContainerGap(45, Short.MAX_VALUE))
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

    private void campoNome2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNome2KeyTyped
        validarLetrasETamanho(evt, campoNome, maxCaracteresNome);
    }//GEN-LAST:event_campoNome2KeyTyped

    private void campoRua2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoRua2KeyTyped
        if(campoRua.getText().length()>= maxCaracteresNome){
            evt.consume();
        }
    }//GEN-LAST:event_campoRua2KeyTyped

    private void campoBairro2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBairro2KeyTyped
        if(campoBairro.getText().length()>= maxCaracteresBairro){
            evt.consume();
        }
    }//GEN-LAST:event_campoBairro2KeyTyped

    private void campoCidade2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCidade2KeyTyped
        validarLetrasETamanho(evt, campoCidade, maxCaracteresBairro); // Mesmo tamanho para nomes de bairros e cidades
    }//GEN-LAST:event_campoCidade2KeyTyped

    private void campoNumero2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumero2KeyTyped
        validarNumerosETamanho(evt, campoNumero, maxCaracteresNumero);
    }//GEN-LAST:event_campoNumero2KeyTyped

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        try {
            if(campoCnpj.getText().charAt(16) == ' ') {//O último caractere do número de CNPJ não pode ser vazio
                JOptionPane.showMessageDialog(null, "Informe o CNPJ da empresa", "Aviso", JOptionPane.WARNING_MESSAGE);
            }else if(campoNome.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o nome do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoRua.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a rua do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoCidade.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe a cidade do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoBairro.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o bairro do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoNumero.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Informe o número do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if(campoTelefone.getText().charAt(14) == ' ') { //O último caractere do número de telefone não pode ser vazio
                JOptionPane.showMessageDialog(null, "Informe o número de telefone do estabelecimento comercial", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    GerenciadorDoSistema.getInstance().cadastrarEmpresa(new Empresa(campoNome.getText(), campoCnpj.getText(),
                        campoTelefone.getText(), new Endereco(campoRua.getText(), campoBairro.getText(), comboUf.getSelectedItem().toString(),
                            Integer.parseInt(campoNumero.getText()), campoCidade.getText())));

                JOptionPane.showMessageDialog(null, "Empresa cadastrada com sucesso!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarEmpresaDialog dialog = new EditarEmpresaDialog(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JTextField campoBairro1;
    private javax.swing.JTextField campoBairro2;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoCidade1;
    private javax.swing.JTextField campoCidade2;
    private javax.swing.JFormattedTextField campoCnpj;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNome1;
    private javax.swing.JTextField campoNome2;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoNumero1;
    private javax.swing.JTextField campoNumero2;
    private javax.swing.JTextField campoRua;
    private javax.swing.JTextField campoRua1;
    private javax.swing.JTextField campoRua2;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.JComboBox comboUf;
    private javax.swing.JComboBox comboUf1;
    private javax.swing.JComboBox comboUf2;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelBairro1;
    private javax.swing.JLabel labelBairro2;
    private javax.swing.JLabel labelCNPJ;
    private javax.swing.JLabel labelCNPJ1;
    private javax.swing.JLabel labelCNPJ2;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelCidade1;
    private javax.swing.JLabel labelCidade2;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNome1;
    private javax.swing.JLabel labelNome2;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelNumero1;
    private javax.swing.JLabel labelNumero2;
    private javax.swing.JLabel labelRua;
    private javax.swing.JLabel labelRua1;
    private javax.swing.JLabel labelRua2;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelUf;
    private javax.swing.JLabel labelUf1;
    private javax.swing.JLabel labelUf2;
    private javax.swing.JPanel painelDadosPessoais;
    private javax.swing.JPanel painelDadosPessoais1;
    private javax.swing.JPanel painelDadosPessoais2;
    private javax.swing.JPanel painelEndereco;
    private javax.swing.JPanel painelEndereco1;
    private javax.swing.JPanel painelEndereco2;
    // End of variables declaration//GEN-END:variables
}
