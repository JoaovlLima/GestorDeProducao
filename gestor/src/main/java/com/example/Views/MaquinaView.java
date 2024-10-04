package com.example.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.MaquinaController;

public class MaquinaView extends JPanel {
    private MaquinaController maquinaController;

    public MaquinaView() {
        setLayout(new BorderLayout());
        maquinaController = new MaquinaController();

        // Painel de Cadastro de Máquinas
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
        panel.add(new JLabel()); // Espaço vazio
        panel.add(btnCadastrar);

        add(panel, BorderLayout.CENTER); // Adicionando o painel ao centro da view

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
    }
}
