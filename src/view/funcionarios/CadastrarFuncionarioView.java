/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.funcionarios;

import controller.FuncionarioController;
import enums.CargoFuncionario;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;

/**
 *
 * @author leoms
 */
public class CadastrarFuncionarioView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastrarFuncionarioView
     */
    public CadastrarFuncionarioView() {
        initComponents();
        preencherCombo();
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

        jlNome = new javax.swing.JLabel();
        jlCpf = new javax.swing.JLabel();
        jlCargo = new javax.swing.JLabel();
        jtxNome = new javax.swing.JTextField();
        jtxCpf = new javax.swing.JFormattedTextField();
        jcbCargo = new javax.swing.JComboBox<CargoFuncionario>();
        jbSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFuncionarios = new javax.swing.JTable();

        jlNome.setText("Nome:");

        jlCpf.setText("CPF:");

        jlCargo.setText("Cargo:");

        jtxNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxNomeActionPerformed(evt);
            }
        });

        try {
            jtxCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtxCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxCpfActionPerformed(evt);
            }
        });

        jcbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCargoActionPerformed(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jtFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Cpf", "Cargo"
            }
        ));
        jScrollPane1.setViewportView(jtFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlCpf)
                            .addComponent(jlNome)
                            .addComponent(jlCargo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxNome, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jcbCargo, javax.swing.GroupLayout.Alignment.LEADING, 0, 186, Short.MAX_VALUE)
                                .addComponent(jtxCpf, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNome)
                    .addComponent(jtxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCpf)
                    .addComponent(jtxCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCargo)
                    .addComponent(jcbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void preencherTabela(){
        FuncionarioController controller = new FuncionarioController();
        List<Funcionario> lista = controller.findAll();
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum Funcionário Cadastrado", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            DefaultTableModel modeloTabela = (DefaultTableModel) jtFuncionarios.getModel();
            modeloTabela.setRowCount(0);
            for (Funcionario f: lista) {
                modeloTabela.addRow(new Object[]{ 
                    f.getNome(),
                    f.getCpf(),
                    f.getCargo()});
            }
        }
    }
    
    private void limparCampos(){
        jtxNome.setText("");
        jtxCpf.setText("");
        jcbCargo.setSelectedIndex(0);
    }
    
    private void preencherCombo(){
        List<CargoFuncionario> lista = Arrays.asList(CargoFuncionario.values());
        for (CargoFuncionario c: lista)
            jcbCargo.addItem(c);
    }
    
    private void jtxNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxNomeActionPerformed

    private void jtxCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxCpfActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        String nome = jtxNome.getText();
        String cpf = jtxCpf.getText().replace("-", "").replace(".", "");
        CargoFuncionario cargo = (CargoFuncionario) jcbCargo.getSelectedItem();
        if ((nome.isEmpty()) || (cpf.isEmpty()) || (cargo.getDescricao().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Digite todos os campos", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            Funcionario funcionario = new Funcionario();
            funcionario.setCargo(cargo);
            funcionario.setCpf(cpf);
            funcionario.setNome(nome);
            FuncionarioController controller = new FuncionarioController();
            controller.insert(funcionario);
            JOptionPane.showMessageDialog(this, "Funcionário Inserido com Sucesso!");
            limparCampos();
            preencherTabela();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jcbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCargoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<CargoFuncionario> jcbCargo;
    private javax.swing.JLabel jlCargo;
    private javax.swing.JLabel jlCpf;
    private javax.swing.JLabel jlNome;
    private javax.swing.JTable jtFuncionarios;
    private javax.swing.JFormattedTextField jtxCpf;
    private javax.swing.JTextField jtxNome;
    // End of variables declaration//GEN-END:variables
}
