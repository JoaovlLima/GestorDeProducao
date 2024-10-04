package com.example.Views;

import javax.swing.*;

import com.example.Controllers.OperadorController;
import com.example.Models.Operador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    

    public LoginView() {
        super("Login");

        // Painel de login
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel lblUsuario = new JLabel("RE:");
        txtUsuario = new JTextField();

        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField();

        btnLogin = new JButton("Login");

        // Adicionando componentes ao painel
        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblSenha);
        panel.add(txtSenha);
        panel.add(new JLabel());
        panel.add(btnLogin);

        add(panel);

        // Configurações da janela
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                } else if ( verificarOperador(Integer.parseInt(usuario),senha)) {
                    Operador operador = InfoOperador(Integer.parseInt(usuario),senha);
                    
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!\n"+
                    "Seja Bem vindo "+operador.getNome());
                    dispose();
                    //abrir view
                   
                }else{
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


private boolean verificarOperador(int usuario, String senha) {
    OperadorController operadorController = new OperadorController();
    Operador operador = operadorController.buscarOperador(usuario, senha);
    
    return operador != null; // Retorna true se o operador foi encontrado
}
private Operador InfoOperador(int usuario, String senha){
  OperadorController operadorController = new OperadorController();
  Operador operador = operadorController.buscarOperador(usuario,senha);

  return operador;
}

    public static void main(String[] args) {
        LoginView login = new LoginView();
        login.setVisible(true);
    }

}
