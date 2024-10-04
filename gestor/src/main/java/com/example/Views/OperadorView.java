package com.example.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.OperadorController;

public class OperadorView extends JPanel {
    private OperadorController operadorController;

    public OperadorView() {
        setLayout(new BorderLayout()); // Definindo o layout principal da view

        // Painel de Cadastro de Operadores
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
        panel.add(new JLabel()); // Espaço vazio
        panel.add(btnCadastrar);

        add(panel, BorderLayout.CENTER); // Adicionando o painel ao centro da view

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
    }
}
