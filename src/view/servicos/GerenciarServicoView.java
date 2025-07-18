/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.servicos;

import controller.FuncionarioController;
import controller.HospedeController;
import controller.ServicoController;
import enums.CargoFuncionario;
import enums.CategoriaQuarto;
import enums.TipoServico;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Hospede;
import model.Servico;

/**
 *
 * @author leoms
 */
public class GerenciarServicoView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastrarFuncionarioView
     */
    
    private Integer linha = -1;
    
    public GerenciarServicoView() {
        initComponents();
        preencherComboServicos();
        preencherComboHospedes();
        Inicializar();
        preencherTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbExcluir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jtxValor = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jlCargo = new javax.swing.JLabel();
        jcbServicos = new javax.swing.JComboBox<TipoServico>();
        jlCargo1 = new javax.swing.JLabel();
        jcbHospedes = new javax.swing.JComboBox<Hospede>();
        jtxData = new javax.swing.JFormattedTextField();
        jlCpf = new javax.swing.JLabel();
        jlId = new javax.swing.JLabel();
        jtxIdServico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtServicos = new javax.swing.JTable();

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jtxValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxValorActionPerformed(evt);
            }
        });

        jlNome.setText("Valor:");

        jlCargo.setText("Serviço");

        jcbServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbServicosActionPerformed(evt);
            }
        });

        jlCargo1.setText("Hóspede");

        jcbHospedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbHospedesActionPerformed(evt);
            }
        });

        jtxData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/y HH:mm:ss"))));
        jtxData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxDataActionPerformed(evt);
            }
        });

        jlCpf.setText("Data:");

        jlId.setText("ID:");

        jtxIdServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxIdServicoActionPerformed(evt);
            }
        });

        jtServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Serviço", "Valor", "Hóspede", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtServicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtServicos);
        if (jtServicos.getColumnModel().getColumnCount() > 0) {
            jtServicos.getColumnModel().getColumn(0).setResizable(false);
            jtServicos.getColumnModel().getColumn(1).setResizable(false);
            jtServicos.getColumnModel().getColumn(2).setResizable(false);
            jtServicos.getColumnModel().getColumn(3).setResizable(false);
            jtServicos.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlNome)
                        .addGap(18, 18, 18)
                        .addComponent(jtxValor, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jlCpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxData))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jlId)
                        .addGap(18, 18, 18)
                        .addComponent(jtxIdServico, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jlCargo)
                        .addGap(18, 18, 18)
                        .addComponent(jcbServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jlCargo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbHospedes, 0, 292, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlId)
                    .addComponent(jtxIdServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCpf)
                    .addComponent(jtxData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCargo)
                    .addComponent(jcbServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCargo1)
                    .addComponent(jcbHospedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void Inicializar(){
        jtxIdServico.setEditable(false);
        jtxValor.setEditable(false);
        jtxData.setEditable(false);
        jcbServicos.setEnabled(false);
        jcbHospedes.setEnabled(false);
        
    }
    
    private void preencherTabela(){
        ServicoController controller = new ServicoController();
        List<Servico> lista = controller.findAll();
        if (lista.isEmpty()) {
            DefaultTableModel modeloTabela = (DefaultTableModel) jtServicos.getModel();
            modeloTabela.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Nenhum Serviço Cadastrado", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            DefaultTableModel modeloTabela = (DefaultTableModel) jtServicos.getModel();
            modeloTabela.setRowCount(0);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");            
            for (Servico s: lista) {
                modeloTabela.addRow(new Object[]{
                    s.getIdServico(),
                    s.getTipo(),
                    s.getValor(),
                    s.getHospede(),
                    format.format(s.getDtServico())});
            }
        }
    }
    
    private void limparCampos(){
        jtxIdServico.setText("");
        jtxValor.setText("");
        jtxData.setText("");
        jcbServicos.setSelectedIndex(0);
        jcbHospedes.setSelectedIndex(0);
    }
    
    private void preencherComboServicos(){
        List<TipoServico> lista = Arrays.asList(TipoServico.values());
        for (TipoServico t: lista)
            jcbServicos.addItem(t);
    }
    
    private void preencherComboHospedes(){
        HospedeController controller = new HospedeController();
        List<Hospede> lista = controller.findAll();
        for (Hospede h: lista)
            jcbHospedes.addItem(h);
    }
    
    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        Integer id = Integer.valueOf(jtxIdServico.getText());
        ServicoController controller = new ServicoController();
        controller.delete(id);
        JOptionPane.showMessageDialog(this, "Serviço excluído com Sucesso!");
        limparCampos();
        preencherTabela();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        String valor = jtxValor.getText();
        String strData = jtxData.getText();               
        TipoServico tpServico = (TipoServico) jcbServicos.getSelectedItem();
        Hospede hospede = (Hospede) jcbHospedes.getSelectedItem();
        Integer id = Integer.valueOf(jtxIdServico.getText());
        if ((valor.isEmpty()) || (strData.isEmpty()) || (tpServico.getDescricao().isEmpty()) || hospede == null) {
            JOptionPane.showMessageDialog(this, "Digite todos os campos", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            try {
                ServicoController controller = new ServicoController();
                Servico servico = new Servico();
                servico.setIdServico(id);
                servico.setTipo(tpServico);
                servico.setHospede(hospede);
                servico.setValor(Float.valueOf(valor.replace(",", ".")));
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");            
                Date data = format.parse(strData);
                servico.setDtServico(data);
                controller.edit(servico);
                limparCampos();
                preencherTabela();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Serviço editado com Sucesso!");
            limparCampos();
            preencherTabela();
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jtxValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxValorActionPerformed

    private void jcbServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbServicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbServicosActionPerformed

    private void jcbHospedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbHospedesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbHospedesActionPerformed

    private void jtxDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxDataActionPerformed

    private void jtxIdServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxIdServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxIdServicoActionPerformed

    private void jtServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtServicosMouseClicked
        linha  = jtServicos.getSelectedRow();
        if (linha != -1) {
            jtxIdServico.setText(jtServicos.getValueAt(linha, 0).toString());
            jcbServicos.setSelectedItem((TipoServico) jtServicos.getValueAt(linha, 1));
            jtxValor.setText(jtServicos.getValueAt(linha, 2).toString());
            jcbHospedes.setSelectedItem((Hospede) jtServicos.getValueAt(linha, 3));
            jtxData.setText(jtServicos.getValueAt(linha, 4).toString());
            jtxValor.setEditable(true);
            jtxData.setEditable(true);
            jcbServicos.setEnabled(true);
            jcbHospedes.setEnabled(true);
            linha = -1;
        }
    }//GEN-LAST:event_jtServicosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JComboBox<Hospede> jcbHospedes;
    private javax.swing.JComboBox<TipoServico> jcbServicos;
    private javax.swing.JLabel jlCargo;
    private javax.swing.JLabel jlCargo1;
    private javax.swing.JLabel jlCpf;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlNome;
    private javax.swing.JTable jtServicos;
    private javax.swing.JFormattedTextField jtxData;
    private javax.swing.JTextField jtxIdServico;
    private javax.swing.JTextField jtxValor;
    // End of variables declaration//GEN-END:variables

}
