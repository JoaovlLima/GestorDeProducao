package com.example.Views.Adm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.MaquinaController;
import com.example.Models.Maquina;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MaquinaView extends JPanel {
    private MaquinaController maquinaController;
    private JTable tabelaMaquinas;
    private DefaultTableModel modeloTabela;

    public MaquinaView() {
        setLayout(new BorderLayout());
        maquinaController = new MaquinaController();

        // Painel de Cadastro de Máquinas
        JPanel painelCadastro = new JPanel(new GridLayout(7, 2, 10, 10));

        JLabel lblIdMaquina = new JLabel("ID da Máquina:");
        JTextField txtIdMaquina = new JTextField();
        JLabel lblLinha = new JLabel("Linha:");
        JTextField txtLinha = new JTextField();
        JLabel lblTipo = new JLabel("Tipo:");
        JTextField txtTipo = new JTextField();
        JLabel lblCapacidadePorMin = new JLabel("Capacidade por Min:");
        JTextField txtCapacidadePorMin = new JTextField();
        JLabel lblEstado = new JLabel("Estado:");
        
        // Criação do JComboBox para o estado
        String[] opcoesEstado = {"OPERANDO", "PARADA", "MANUTENCAO"};
        JComboBox<String> cbEstado = new JComboBox<>(opcoesEstado);
        
        JLabel lblIdProduto = new JLabel("ID do Produto:");
        JTextField txtIdProduto = new JTextField();
        JLabel lblHistoricoManutencao = new JLabel("Histórico de Manutenção:");
        JTextField txtHistoricoManutencao = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar Máquina");

        painelCadastro.add(lblIdMaquina);
        painelCadastro.add(txtIdMaquina);
        painelCadastro.add(lblLinha);
        painelCadastro.add(txtLinha);
        painelCadastro.add(lblTipo);
        painelCadastro.add(txtTipo);
        painelCadastro.add(lblCapacidadePorMin);
        painelCadastro.add(txtCapacidadePorMin);
        painelCadastro.add(lblEstado);
        painelCadastro.add(cbEstado); // Adiciona JComboBox para estado
        painelCadastro.add(lblIdProduto);
        painelCadastro.add(txtIdProduto);
        painelCadastro.add(lblHistoricoManutencao);
        painelCadastro.add(txtHistoricoManutencao);
        
        painelCadastro.add(new JLabel()); // Espaço vazio
        painelCadastro.add(btnCadastrar);

        // Tabela para listar as máquinas
        String[] colunas = {"ID da Máquina", "Linha", "Tipo", "Capacidade por Min", "Estado", "ID do Produto", "Histórico de Manutenção"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaMaquinas = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaMaquinas);

        // Adicionando componentes ao painel principal
        add(painelCadastro, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Ação do botão "Cadastrar Máquina"
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idMaquina = Integer.parseInt(txtIdMaquina.getText());
                    int linha = Integer.parseInt(txtLinha.getText());
                    String tipo = txtTipo.getText();
                    double capacidadePorMin = Double.parseDouble(txtCapacidadePorMin.getText());
                    String estado = (String) cbEstado.getSelectedItem(); // Obtém a opção selecionada do JComboBox
                    int idProduto = Integer.parseInt(txtIdProduto.getText());
                    String historicoManutencao = txtHistoricoManutencao.getText();

                    // Chama o método do controlador para criar a máquina
                    maquinaController.criarMaquina(idMaquina, linha, tipo, capacidadePorMin, estado, idProduto, historicoManutencao);
                    JOptionPane.showMessageDialog(null, "Máquina cadastrada com sucesso!");

                    // Adiciona a máquina à tabela
                    modeloTabela.addRow(new Object[]{idMaquina, linha, tipo, capacidadePorMin, estado, idProduto, historicoManutencao});
                    
                    // Limpar os campos após o cadastro
                    txtIdMaquina.setText("");
                    txtLinha.setText("");
                    txtTipo.setText("");
                    txtCapacidadePorMin.setText("");
                    cbEstado.setSelectedIndex(0); // Reseta o JComboBox para a primeira opção
                    txtIdProduto.setText("");
                    txtHistoricoManutencao.setText("");
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar máquina: " + ex.getMessage());
                    System.out.println(ex);
                }
            }
        });

        // Carregar máquinas na tabela ao iniciar a view
        carregarMaquinas();
    }

    private void carregarMaquinas() {
        List<Maquina> maquinas = maquinaController.listarMaquinas();
        for (Maquina maquina : maquinas) {
            modeloTabela.addRow(new Object[]{
                maquina.getIdMaquina(), 
                maquina.getLinha(), 
                maquina.getTipo(),
                maquina.getCapacidadePorMin(), 
                maquina.getEstado(), 
                maquina.getIdProduto(),
                maquina.getHistoricoManutencao()
            });
        }
    }
}
