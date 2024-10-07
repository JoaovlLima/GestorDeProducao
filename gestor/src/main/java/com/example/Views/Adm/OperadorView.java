package com.example.Views.Adm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.OperadorController;
import com.example.Models.Operador;
import com.example.Models.Maquina;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

public class OperadorView extends JPanel {
    private OperadorController operadorController;
    private JTable tabelaOperadores;
    private DefaultTableModel modeloTabela;
    
    // Campos de entrada para cadastrar um novo operador
    private JTextField tfRe, tfNome, tfTurno, tfSenha, tfProdutividadeMedia;
    private JTextArea taMaquinasOperadas;

    public OperadorView() {
        setLayout(new BorderLayout());
        operadorController = new OperadorController();

        // Tabela para listar os operadores
        String[] colunas = {"RE", "Nome", "Turno", "Senha", "Produtividade Média", "Máquinas Operadas"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaOperadores = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaOperadores);

        // Botão para atualizar a tabela
        JButton btnAtualizar = new JButton("Atualizar Tabela");
        JButton btnCadastrar = new JButton("Cadastrar Operador");

        // Painel de controle
        JPanel painelControle = new JPanel();
        painelControle.add(btnAtualizar);
        painelControle.add(btnCadastrar);

        // Painel para cadastro de operador
        JPanel painelCadastro = new JPanel(new GridLayout(6, 2));
        tfRe = new JTextField();
        tfNome = new JTextField();
        tfTurno = new JTextField();
        tfSenha = new JTextField();
        tfProdutividadeMedia = new JTextField();
        taMaquinasOperadas = new JTextArea();

        painelCadastro.add(new JLabel("RE:"));
        painelCadastro.add(tfRe);
        painelCadastro.add(new JLabel("Nome:"));
        painelCadastro.add(tfNome);
        painelCadastro.add(new JLabel("Turno:"));
        painelCadastro.add(tfTurno);
        painelCadastro.add(new JLabel("Senha:"));
        painelCadastro.add(tfSenha);
        painelCadastro.add(new JLabel("Produtividade Média:"));
        painelCadastro.add(tfProdutividadeMedia);
        painelCadastro.add(new JLabel("Máquinas Operadas (JSON):"));
        painelCadastro.add(new JScrollPane(taMaquinasOperadas));

        // Adicionando componentes ao painel principal
        add(scrollPane, BorderLayout.CENTER);
        add(painelControle, BorderLayout.SOUTH);
        add(painelCadastro, BorderLayout.EAST);

        // Ação do botão "Atualizar Tabela"
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carregarOperadores();
            }
        });

        // Ação do botão "Cadastrar Operador"
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarOperador();
            }
        });

        // Carregar operadores na tabela ao iniciar a view
        carregarOperadores();
    }

    private void carregarOperadores() {
        modeloTabela.setRowCount(0); // Limpa a tabela antes de carregar novos dados
        List<Operador> operadores = operadorController.listarOperadores();
        for (Operador operador : operadores) {
            modeloTabela.addRow(new Object[]{
                operador.getRe(),
                operador.getNome(),
                operador.getTurno().name(),
                operador.getSenha(),
                operador.getProdutividadeMedia(),
                operador.getMaquinasOperadas() // Aqui você pode formatar a saída como preferir
            });
        }
    }

    private void cadastrarOperador() {
        try {
            int re = Integer.parseInt(tfRe.getText());
            String nome = tfNome.getText();
            String turnoStr = tfTurno.getText().toUpperCase();
            String senha = tfSenha.getText();
            double produtividadeMedia = Double.parseDouble(tfProdutividadeMedia.getText());
            
            // Aqui você pode implementar um método para converter o texto das máquinas operadas em uma lista
            List<Maquina> maquinasOperadas = parseMaquinasOperadas(taMaquinasOperadas.getText());

            operadorController.criarOperador(re, nome, turnoStr, senha, maquinasOperadas, produtividadeMedia);
            carregarOperadores(); // Atualiza a tabela após o cadastro
            JOptionPane.showMessageDialog(this, "Operador cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar operador: " + ex.getMessage());
        }
    }

    private List<Maquina> parseMaquinasOperadas(String maquinasJson) {
        // Método para converter o texto JSON das máquinas operadas em uma lista de objetos Maquina
        // Implemente sua lógica de parsing aqui
        return new ArrayList<>(); // Retorne a lista de máquinas operadas
    }
}
