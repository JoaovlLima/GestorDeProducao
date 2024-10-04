package com.example.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.OperadorController;
import com.example.Controllers.ProdutoController;
import com.example.Controllers.MaquinaController;

public class CadastroView extends JFrame {

    // Controladores
    private OperadorController operadorController;
    private ProdutoController produtoController;
    private MaquinaController maquinaController;

    // Construtor
    public CadastroView() {
        operadorController = new OperadorController();
        produtoController = new ProdutoController();
        maquinaController = new MaquinaController();

        // Configurações da Janela
        setTitle("Gestão de Produção - Cadastro");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar abas para os cadastros
        JTabbedPane tabbedPane = new JTabbedPane();

        // Painel de Cadastro de Operadores
        JPanel panelOperador = criarPainelCadastroOperador();
        tabbedPane.addTab("Cadastro de Operador", panelOperador);

        // Painel de Cadastro de Produtos
        JPanel panelProduto = criarPainelCadastroProduto();
        tabbedPane.addTab("Cadastro de Produto", panelProduto);

        // Painel de Cadastro de Máquinas
        JPanel panelMaquina = criarPainelCadastroMaquina();
        tabbedPane.addTab("Cadastro de Maquina", panelMaquina);

        // Adicionar o tabbedPane à janela
        add(tabbedPane);
    }

    // Painel de Cadastro de Operadores
    private JPanel criarPainelCadastroOperador() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel lblRe = new JLabel("RE:");
        JTextField txtRe = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblTurno = new JLabel("Turno:");
        JTextField txtTurno = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();

        JButton btnCadastrar = new JButton("Cadastrar Operador");

        panel.add(lblRe);
        panel.add(txtRe);
        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblTurno);
        panel.add(txtTurno);
        panel.add(lblSenha);
        panel.add(txtSenha);
        panel.add(new JLabel());
        panel.add(btnCadastrar);

        // Ação do botão "Cadastrar Operador"
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int re = Integer.parseInt(txtRe.getText());
                    String nome = txtNome.getText();
                    String turno = txtTurno.getText();
                    String senha = new String(txtSenha.getPassword());

                    operadorController.criarOperador(re, nome, turno, senha);
                    JOptionPane.showMessageDialog(null, "Operador cadastrado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar operador: " + ex.getMessage());
                }
            }
        });

        return panel;
    }

    // Painel de Cadastro de Produtos
    private JPanel criarPainelCadastroProduto() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel lblId = new JLabel("ID:");
        JTextField txtId = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblTempo = new JLabel("Tempo Produzir por Kg:");
        JTextField txtTempo = new JTextField();
        JLabel lblQuantMaterias = new JLabel("Quantidade de Materiais:");
        JTextField txtQuantMaterias = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar Produto");

        panel.add(lblId);
        panel.add(txtId);
        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblTempo);
        panel.add(txtTempo);
        panel.add(lblQuantMaterias);
        panel.add(txtQuantMaterias);
        panel.add(new JLabel());
        panel.add(btnCadastrar);

        // Ação do botão "Cadastrar Produto"
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText());
                    String nome = txtNome.getText();
                    double tempoProduzirKg = Double.parseDouble(txtTempo.getText());
                    int quantidadeMaterias = Integer.parseInt(txtQuantMaterias.getText());

                    produtoController.criarProduto(id, nome, tempoProduzirKg, quantidadeMaterias);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + ex.getMessage());
                }
            }
        });

        return panel;
    }

    // Painel de Cadastro de Máquinas
    private JPanel criarPainelCadastroMaquina() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JLabel lblId = new JLabel("ID:");
        JTextField txtId = new JTextField();
        JLabel lblLinha = new JLabel("Linha:");
        JTextField txtLinha = new JTextField();
        JLabel lblTipo = new JLabel("Tipo:");
        JTextField txtTipo = new JTextField();
        JLabel lblCapacidade = new JLabel("Capacidade (por min):");
        JTextField txtCapacidade = new JTextField();
        JLabel lblEstado = new JLabel("Estado:");
        JTextField txtEstado = new JTextField();
        JLabel lblIdProduto = new JLabel("ID Produto:");
        JTextField txtIdProduto = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar Máquina");

        panel.add(lblId);
        panel.add(txtId);
        panel.add(lblLinha);
        panel.add(txtLinha);
        panel.add(lblTipo);
        panel.add(txtTipo);
        panel.add(lblCapacidade);
        panel.add(txtCapacidade);
        panel.add(lblEstado);
        panel.add(txtEstado);
        panel.add(lblIdProduto);
        panel.add(txtIdProduto);
        panel.add(new JLabel());
        panel.add(btnCadastrar);

        // Ação do botão "Cadastrar Máquina"
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText());
                    int linha = Integer.parseInt(txtLinha.getText());
                    String tipo = txtTipo.getText();
                    double capacidadePorMin = Double.parseDouble(txtCapacidade.getText());
                    String estado = txtEstado.getText();
                    int idProduto = Integer.parseInt(txtIdProduto.getText());

                    maquinaController.criarMaquina(id, linha, tipo, capacidadePorMin, estado, idProduto);
                    JOptionPane.showMessageDialog(null, "Máquina cadastrada com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar máquina: " + ex.getMessage());
                }
            }
        });

        return panel;
    }

    // Método principal para executar a GUI
    
}
