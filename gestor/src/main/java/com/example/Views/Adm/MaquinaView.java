package com.example.Views.Adm;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.MaquinaController;
import com.example.Models.Maquina;
import com.example.Views.LoginView;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MaquinaView extends JPanel {
    private MaquinaController maquinaController;
    private JTable tabelaMaquinas;
    private DefaultTableModel modeloTabela;

    private JTextField txtIdMaquina, txtLinha, txtTipo, txtCapacidadePorMin, txtIdProduto, txtHistoricoManutencao;
    private JComboBox<String> cbEstado;
    private JButton btnCadastrar, btnEditar, btnRemover, btnVoltar;

    public MaquinaView() {
        setLayout(new BorderLayout());
        maquinaController = new MaquinaController();
        setBackground(new Color(240, 255, 240)); // Fundo verde claro

        // Painel de Cadastro de Máquinas
        JPanel painelCadastro = new JPanel(new GridLayout(8, 2, 10, 10));
        painelCadastro.setBackground(new Color(255, 255, 255)); // Fundo branco
        painelCadastro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 128, 0), 2), "Cadastro de Máquinas", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 14), new Color(0, 128, 0))); // Borda verde

        // Labels e Campos
        JLabel lblIdMaquina = new JLabel("ID da Máquina:");
        txtIdMaquina = new JTextField();
        JLabel lblLinha = new JLabel("Linha:");
        txtLinha = new JTextField();
        JLabel lblTipo = new JLabel("Tipo:");
        txtTipo = new JTextField();
        JLabel lblCapacidadePorMin = new JLabel("Capacidade por Min:");
        txtCapacidadePorMin = new JTextField();
        JLabel lblEstado = new JLabel("Estado:");

        // Criação do JComboBox para o estado
        String[] opcoesEstado = {"OPERANDO", "PARADA", "MANUTENCAO"};
        cbEstado = new JComboBox<>(opcoesEstado);

        JLabel lblIdProduto = new JLabel("ID do Produto:");
        txtIdProduto = new JTextField();
        JLabel lblHistoricoManutencao = new JLabel("Histórico de Manutenção:");
        txtHistoricoManutencao = new JTextField();

        // Botões com cor e estilo
        btnCadastrar = createButton("Cadastrar Máquina");
        btnEditar = createButton("Editar Máquina");
        btnRemover = createButton("Remover Máquina");
        btnVoltar = createButton("Voltar");

        // Adicionando componentes ao painel de cadastro
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
        painelCadastro.add(btnEditar);
        painelCadastro.add(btnRemover);
        painelCadastro.add(btnVoltar);

        // Tabela para listar as máquinas
        String[] colunas = {"ID da Máquina", "Linha", "Tipo", "Capacidade por Min", "Estado", "ID do Produto", "Histórico de Manutenção"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaMaquinas = new JTable(modeloTabela);
        tabelaMaquinas.setFillsViewportHeight(true);
        tabelaMaquinas.setBackground(new Color(255, 255, 255)); // Fundo da tabela
        tabelaMaquinas.setForeground(new Color(0, 128, 0)); // Cor do texto
        tabelaMaquinas.setGridColor(new Color(0, 128, 0)); // Cor da grade

        JScrollPane scrollPane = new JScrollPane(tabelaMaquinas);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0), 2)); // Borda verde para a tabela

        // Adicionando componentes ao painel principal
        add(painelCadastro, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Carregar máquinas na tabela ao iniciar a view
        carregarMaquinas();

        // Ação do botão "Cadastrar Máquina"
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idMaquina = Integer.parseInt(txtIdMaquina.getText());
                    int linha = Integer.parseInt(txtLinha.getText());
                    String tipo = txtTipo.getText();
                    double capacidadePorMin = Double.parseDouble(txtCapacidadePorMin.getText());
                    String estado = (String) cbEstado.getSelectedItem();
                    int idProduto = Integer.parseInt(txtIdProduto.getText());
                    String historicoManutencao = txtHistoricoManutencao.getText();

                    // Chama o método do controlador para criar a máquina
                    maquinaController.criarMaquina(idMaquina, linha, tipo, capacidadePorMin, estado, idProduto, historicoManutencao);
                    JOptionPane.showMessageDialog(null, "Máquina cadastrada com sucesso!");

                    // Adiciona a máquina à tabela
                    modeloTabela.addRow(new Object[]{idMaquina, linha, tipo, capacidadePorMin, estado, idProduto, historicoManutencao});

                    limparCampos();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar máquina: " + ex.getMessage());
                }
            }
        });

        // Ação do botão "Editar Máquina"
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = tabelaMaquinas.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Selecione uma máquina para editar.");
                        return;
                    }

                    int idMaquina = Integer.parseInt(txtIdMaquina.getText());
                    int linha = Integer.parseInt(txtLinha.getText());
                    String tipo = txtTipo.getText();
                    double capacidadePorMin = Double.parseDouble(txtCapacidadePorMin.getText());
                    String estado = (String) cbEstado.getSelectedItem();
                    int idProduto = Integer.parseInt(txtIdProduto.getText());
                    String historicoManutencao = txtHistoricoManutencao.getText();

                    // Atualiza a máquina no banco de dados
                    maquinaController.atualizarMaquina(idMaquina, linha, tipo, capacidadePorMin, estado, idProduto, historicoManutencao);

                    // Atualiza a linha selecionada na tabela
                    modeloTabela.setValueAt(linha, selectedRow, 1);
                    modeloTabela.setValueAt(tipo, selectedRow, 2);
                    modeloTabela.setValueAt(capacidadePorMin, selectedRow, 3);
                    modeloTabela.setValueAt(estado, selectedRow, 4);
                    modeloTabela.setValueAt(idProduto, selectedRow, 5);
                    modeloTabela.setValueAt(historicoManutencao, selectedRow, 6);

                    JOptionPane.showMessageDialog(null, "Máquina atualizada com sucesso!");
                    limparCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao editar máquina: " + ex.getMessage());
                }
            }
        });

        // Ação do botão "Remover Máquina"
        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = tabelaMaquinas.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Selecione uma máquina para remover.");
                        return;
                    }

                    int idMaquina = (int) modeloTabela.getValueAt(selectedRow, 0);

                    // Remove a máquina do banco de dados
                    maquinaController.removerMaquina(idMaquina);

                    // Remove a linha da tabela
                    modeloTabela.removeRow(selectedRow);

                    JOptionPane.showMessageDialog(null, "Máquina removida com sucesso!");
                    limparCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao remover máquina: " + ex.getMessage());
                }
            }
        });

    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(0, 128, 0)); // Cor de fundo verde
        button.setForeground(Color.WHITE); // Texto branco
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Espaçamento interno
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Fonte em negrito
        return button;
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

    private void limparCampos() {
        txtIdMaquina.setText("");
        txtLinha.setText("");
        txtTipo.setText("");
        txtCapacidadePorMin.setText("");
        cbEstado.setSelectedIndex(0);
        txtIdProduto.setText("");
        txtHistoricoManutencao.setText("");
    }
}
