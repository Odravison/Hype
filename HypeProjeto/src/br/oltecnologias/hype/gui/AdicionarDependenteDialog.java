/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.oltecnologias.hype.gui;

import br.oltecnologias.hype.model.Medidas;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Cliente
 */
public class AdicionarDependenteDialog extends java.awt.Dialog {

    /**
     * Creates new form AdicionarDependenteDialog
     */
    public AdicionarDependenteDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        botaoSalvar.setIcon(new ImageIcon("Imagens\\Salvar.png"));
        botaoCancelar.setIcon(new ImageIcon("Imagens\\Cancelar.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelGeral = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        painelMedidas = new javax.swing.JPanel();
        labelTraje = new javax.swing.JLabel();
        labelCalca = new javax.swing.JLabel();
        labelColete = new javax.swing.JLabel();
        labelObservacao = new javax.swing.JLabel();
        labelGravata = new javax.swing.JLabel();
        labelSapato = new javax.swing.JLabel();
        labelBlazer = new javax.swing.JLabel();
        scPnObservacao = new javax.swing.JScrollPane();
        areaObservacao = new javax.swing.JTextArea();
        labelCamisa = new javax.swing.JLabel();
        campoCalca = new javax.swing.JFormattedTextField();
        campoBlazer = new javax.swing.JFormattedTextField();
        campoColete = new javax.swing.JFormattedTextField();
        campoCamisa = new javax.swing.JFormattedTextField();
        campoSapato = new javax.swing.JFormattedTextField();
        campoTraje = new javax.swing.JFormattedTextField();
        campoGravata = new javax.swing.JFormattedTextField();
        labelObrigatorio = new javax.swing.JLabel();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setTitle("Adicionar Dependente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        painelGeral.setBackground(new java.awt.Color(255, 255, 255));
        painelGeral.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNome.setText("Nome:*");

        campoNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        painelMedidas.setBackground(new java.awt.Color(255, 255, 255));
        painelMedidas.setBorder(javax.swing.BorderFactory.createTitledBorder("Medidas"));
        painelMedidas.setPreferredSize(new java.awt.Dimension(635, 238));

        labelTraje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTraje.setText("Traje:");

        labelCalca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCalca.setText("Calça:");

        labelColete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelColete.setText("Colete:");

        labelObservacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelObservacao.setText("Observação:");

        labelGravata.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelGravata.setText("Gravata:");

        labelSapato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSapato.setText("Sapato:");

        labelBlazer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelBlazer.setText("Blazer:");

        areaObservacao.setColumns(20);
        areaObservacao.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        areaObservacao.setRows(5);
        areaObservacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaObservacaoKeyTyped(evt);
            }
        });
        scPnObservacao.setViewportView(areaObservacao);

        labelCamisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCamisa.setText("Camisa:");

        try {
            campoCalca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCalca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            campoBlazer.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoBlazer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            campoColete.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoColete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            campoCamisa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCamisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            campoSapato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoSapato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            campoTraje.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoTraje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            campoGravata.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoGravata.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout painelMedidasLayout = new javax.swing.GroupLayout(painelMedidas);
        painelMedidas.setLayout(painelMedidasLayout);
        painelMedidasLayout.setHorizontalGroup(
            painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMedidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMedidasLayout.createSequentialGroup()
                        .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(painelMedidasLayout.createSequentialGroup()
                                .addComponent(labelGravata)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoGravata, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(labelTraje))
                            .addGroup(painelMedidasLayout.createSequentialGroup()
                                .addComponent(labelBlazer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoBlazer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCalca)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelMedidasLayout.createSequentialGroup()
                                .addComponent(campoTraje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(labelSapato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoSapato, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelMedidasLayout.createSequentialGroup()
                                .addComponent(campoCalca, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(labelColete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoColete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(labelCamisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelMedidasLayout.createSequentialGroup()
                        .addComponent(labelObservacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scPnObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        painelMedidasLayout.setVerticalGroup(
            painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMedidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCalca)
                    .addComponent(labelBlazer)
                    .addComponent(labelColete)
                    .addComponent(labelCamisa)
                    .addComponent(campoCalca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBlazer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoColete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGravata)
                    .addComponent(labelSapato)
                    .addComponent(campoSapato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoGravata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTraje))
                .addGap(22, 22, 22)
                .addGroup(painelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObservacao)
                    .addComponent(scPnObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelGeralLayout = new javax.swing.GroupLayout(painelGeral);
        painelGeral.setLayout(painelGeralLayout);
        painelGeralLayout.setHorizontalGroup(
            painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelGeralLayout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelGeralLayout.setVerticalGroup(
            painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(painelMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelObrigatorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelObrigatorio.setText("* Obrigatório");

        botaoSalvar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoSalvar.setText(" Salvar ");
        botaoSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelObrigatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObrigatorio)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoSalvar)
                        .addComponent(botaoCancelar)))
                .addContainerGap(33, Short.MAX_VALUE))
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

    private void areaObservacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaObservacaoKeyTyped
        if(areaObservacao.getText().length()>= maxCaracteresObs){
            evt.consume();
        }
    }//GEN-LAST:event_areaObservacaoKeyTyped

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        // Validar campos para cadastro
        if(campoNome.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Informe o nome do dependente", "Aviso", JOptionPane.WARNING_MESSAGE);
        } 

        Medidas medidas = new Medidas(Integer.parseInt(campoCalca.getText()), Integer.parseInt(campoTraje.getText()),
            Integer.parseInt(campoColete.getText()), Integer.parseInt(campoCamisa.getText()),
            Integer.parseInt(campoGravata.getText()), Integer.parseInt(campoSapato.getText()),
            Integer.parseInt(campoBlazer.getText()), areaObservacao.getText());
        try {
            //Dependente;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
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
                AdicionarDependenteDialog dialog = new AdicionarDependenteDialog(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private String numeros = "0987654321"; // Alguns campos não devem aceitar números
    private int maxCaracteresNome = 40;
    private int maxCaracteresObs = 250;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaObservacao;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JFormattedTextField campoBlazer;
    private javax.swing.JFormattedTextField campoCalca;
    private javax.swing.JFormattedTextField campoCamisa;
    private javax.swing.JFormattedTextField campoColete;
    private javax.swing.JFormattedTextField campoGravata;
    private javax.swing.JTextField campoNome;
    private javax.swing.JFormattedTextField campoSapato;
    private javax.swing.JFormattedTextField campoTraje;
    private javax.swing.JLabel labelBlazer;
    private javax.swing.JLabel labelCalca;
    private javax.swing.JLabel labelCamisa;
    private javax.swing.JLabel labelColete;
    private javax.swing.JLabel labelGravata;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelObrigatorio;
    private javax.swing.JLabel labelObservacao;
    private javax.swing.JLabel labelSapato;
    private javax.swing.JLabel labelTraje;
    private javax.swing.JPanel painelGeral;
    private javax.swing.JPanel painelMedidas;
    private javax.swing.JScrollPane scPnObservacao;
    // End of variables declaration//GEN-END:variables
}
