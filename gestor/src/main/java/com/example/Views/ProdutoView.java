package com.example.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.ProdutoController;

public class ProdutoView extends JPanel {
    private ProdutoController produtoController;

    public ProdutoView() {
        setLayout(new BorderLayout());
        produtoController = new ProdutoController();
        // Painel de Cadastro de Produtos
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
        panel.add(new JLabel()); // Espaço vazio
        panel.add(btnCadastrar);

        add(panel, BorderLayout.CENTER); // Adicionando o painel ao centro da view

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
                    // JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + ex.getMessage());
                    System.out.println(ex);
                    
                }
            }
        });
    }
}
