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
    
    // ComboBox para selecionar máquinas operadas
    private JComboBox<Maquina> cbMaquinasOperadas;
    private DefaultListModel<Maquina> maquinasOperadasModel;
    private JList<Maquina> listMaquinasOperadas;

    public OperadorView() {
        setLayout(new BorderLayout());
        operadorController = new OperadorController();

        // Tabela para listar os operadores
        String[] colunas = {"RE", "Nome", "Turno", "Senha", "Produtividade Média", "Máquinas Operadas"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaOperadores = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaOperadores);

        // Botões para controle
        JButton btnAtualizar = new JButton("Atualizar Tabela");
        JButton btnCadastrar = new JButton("Cadastrar Operador");

        // Painel de controle dos botões
        JPanel painelControle = new JPanel();
        painelControle.add(btnAtualizar);
        painelControle.add(btnCadastrar);

        // Configurando o layout com GridBagLayout
        JPanel painelCadastro = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Inicialização dos campos de texto
        tfRe = new JTextField(10);
        tfNome = new JTextField(10);
        tfTurno = new JTextField(10);
        tfSenha = new JTextField(10);
        tfProdutividadeMedia = new JTextField(10);
        
        // Criação do JComboBox para selecionar máquinas
        cbMaquinasOperadas = new JComboBox<>();
        carregarMaquinasOperadas(); // Carrega a lista de máquinas no ComboBox
        
        // Configuração da lista para exibir as máquinas selecionadas
        maquinasOperadasModel = new DefaultListModel<>();
        listMaquinasOperadas = new JList<>(maquinasOperadasModel);
        JScrollPane scrollMaquinas = new JScrollPane(listMaquinasOperadas);

        JButton btnAddMaquina = new JButton("Adicionar Máquina");

        // Adicionando os componentes ao painel de cadastro
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCadastro.add(new JLabel("RE:"), gbc);
        gbc.gridx = 1;
        painelCadastro.add(tfRe, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelCadastro.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        painelCadastro.add(tfNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painelCadastro.add(new JLabel("Turno:"), gbc);
        gbc.gridx = 1;
        painelCadastro.add(tfTurno, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painelCadastro.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1;
        painelCadastro.add(tfSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        painelCadastro.add(new JLabel("Produtividade Média:"), gbc);
        gbc.gridx = 1;
        painelCadastro.add(tfProdutividadeMedia, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        painelCadastro.add(new JLabel("Selecionar Máquina:"), gbc);
        gbc.gridx = 1;
        painelCadastro.add(cbMaquinasOperadas, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        painelCadastro.add(new JLabel("Máquinas Operadas:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        painelCadastro.add(scrollMaquinas, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        painelCadastro.add(btnAddMaquina, gbc);

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

        // Ação do botão "Adicionar Máquina"
        btnAddMaquina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Maquina maquinaSelecionada = (Maquina) cbMaquinasOperadas.getSelectedItem();
                if (maquinaSelecionada != null && !maquinasOperadasModel.contains(maquinaSelecionada)) {
                    maquinasOperadasModel.addElement(maquinaSelecionada); // Adiciona a máquina selecionada à lista
                }
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
            
            // Criar lista de máquinas operadas a partir do JList
            List<Maquina> maquinasOperadas = new ArrayList<>();
            for (int i = 0; i < maquinasOperadasModel.size(); i++) {
                maquinasOperadas.add(maquinasOperadasModel.get(i));
            }

            operadorController.criarOperador(re, nome, turnoStr, senha, maquinasOperadas, produtividadeMedia);
            carregarOperadores(); // Atualiza a tabela após o cadastro
            JOptionPane.showMessageDialog(this, "Operador cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar operador: " + ex.getMessage());
        }
    }

    private void carregarMaquinasOperadas() {
        // Obter a lista de máquinas do controlador
        List<Maquina> maquinas = operadorController.listarMaquinas();
        cbMaquinasOperadas.removeAllItems();
        for (Maquina maquina : maquinas) {
            cbMaquinasOperadas.addItem(maquina); // Adiciona as máquinas ao ComboBox
        }
    }
}
