/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.funcionarios;

import controller.FuncionarioController;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import relatorios.Relatorio;

/**
 *
 * @author leoms
 */
public class RelatorioFuncionarioView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastrarFuncionarioView
     */
    public RelatorioFuncionarioView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFuncionario = new javax.swing.JTable();
        jbRelatorio = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();

        jtxNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxNomeActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jtFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtFuncionario);
        if (jtFuncionario.getColumnModel().getColumnCount() > 0) {
            jtFuncionario.getColumnModel().getColumn(0).setResizable(false);
            jtFuncionario.getColumnModel().getColumn(1).setResizable(false);
            jtFuncionario.getColumnModel().getColumn(2).setResizable(false);
        }

        jbRelatorio.setText("Gerar relatório");
        jbRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRelatorioActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbRelatorio))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxNome))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRelatorio)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxNomeActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String nome = jtxNome.getText();
        FuncionarioController c = new FuncionarioController();
        List<Funcionario> lista = c.findByNomeFuncionario(nome);
        if(lista.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nenhum funcionário encontrado para o filtro");
            DefaultTableModel modeloTabela = (DefaultTableModel) jtFuncionario.getModel();
            modeloTabela.setRowCount(0);
            return;
        }
        
        DefaultTableModel modeloTabela = (DefaultTableModel) jtFuncionario.getModel();
        modeloTabela.setRowCount(0);
        for (Funcionario f: lista) {
            modeloTabela.addRow(new Object[]{ 
                f.getNome(),
                f.getCpf(),
                f.getCargo()});
            }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRelatorioActionPerformed
        try {
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("nome", "%" + jtxNome.getText() + "%");
            Relatorio.gerarRelatorio("src/relatorios/RelFuncionarios", parametros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbRelatorioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbRelatorio;
    private javax.swing.JTable jtFuncionario;
    private javax.swing.JTextField jtxNome;
    // End of variables declaration//GEN-END:variables
}
