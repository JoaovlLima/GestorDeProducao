package com.example.Views;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;      

public class AdmView extends JFrame{
  
        private JTextField operadorNomeField;
        private JPasswordField operadorSenhaField;
        private JTextField operadorReField;
        private JTextField operadorTurnoField;
        private JButton criarOperadorButton;
    
        // Construtor e layout da tela omitidos para simplificação
    
        public String getOperadorNome() {
            return operadorNomeField.getText();
        }
    
        public String getOperadorSenha() {
            return new String(operadorSenhaField.getPassword());
        }
    
        public int getOperadorRe() {
            return Integer.parseInt(operadorReField.getText());
        }
    
        public int getOperadorTurno() {
            return Integer.parseInt(operadorTurnoField.getText());
        }
    
        public void addCreateOperadorListener(ActionListener listener) {
            criarOperadorButton.addActionListener(listener);
        }
    
        public void mostrarMensagemErro(String mensagem) {
            JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    
        public void mostrarMensagemSucesso(String mensagem) {
            JOptionPane.showMessageDialog(this, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

