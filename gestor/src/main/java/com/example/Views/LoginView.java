package com.example.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.OperadorController;
import com.example.Models.Operador;
import com.example.Views.Adm.AdmView;
import com.example.Views.Operador.JanelaPrincipal;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin;

    public LoginView() {
        super("Login");
        
        // Configurações da janela
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Criar um painel com fundo verde claro
        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 240, 220)); // Verde claro
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // Estilizando os componentes
        JLabel lblUsuario = new JLabel("RE:");
        lblUsuario.setForeground(new Color(0, 100, 0)); // Verde escuro
        txtUsuario = new JTextField();
        
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(new Color(0, 100, 0)); // Verde escuro
        txtSenha = new JPasswordField();

        btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(0, 150, 0)); // Verde mais forte
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        
        // Adicionando componentes ao painel
        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblSenha);
        panel.add(txtSenha);
        panel.add(new JLabel()); // Espaço em branco
        panel.add(btnLogin);

        // Adicionando o painel à janela
        add(panel);

        // Ação do botão de login
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                // Verificar o login (simples verificação)
                if (usuario.equals("admin") && senha.equals("1234")) {
                    // Se o login for válido, abrir a tela de cadastro
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    dispose(); // Fechar a tela de login
                    abrirAdmView();
                } else if (verificarOperador(Integer.parseInt(usuario), senha)) {
                    Operador operador = InfoOperador(Integer.parseInt(usuario), senha);
                    
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!\n" +
                    "Seja Bem vindo " + operador.getNome());
                    dispose();
                    abrirOpview(operador.getRe());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
                }
            }
        });
    }

    // Método para abrir a tela de cadastro após login bem-sucedido
    private void abrirAdmView() {
        AdmView cadastroView = new AdmView();
        cadastroView.run(); // Tornar visível a tela de cadastro
    }

    private void abrirOpview(int reRecuperado) {
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal(reRecuperado);
        janelaPrincipal.run();
    }

    private boolean verificarOperador(int usuario, String senha) {
        OperadorController operadorController = new OperadorController();
        Operador operador = operadorController.buscarOperador(usuario, senha);
        
        return operador != null; // Retorna true se o operador foi encontrado
    }

    private Operador InfoOperador(int usuario, String senha) {
        OperadorController operadorController = new OperadorController();
        Operador operador = operadorController.buscarOperador(usuario, senha);
        return operador;
    }

    public void run() {
        setVisible(true);
    }
}
