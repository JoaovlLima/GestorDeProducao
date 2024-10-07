package com.example.Views.Operador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.MaquinaController;
import com.example.Models.Maquina;
import java.util.List;

public class OperadorHomeView extends JPanel {
    private MaquinaController maquinaController;

    public OperadorHomeView() {
        setLayout(new BorderLayout());
        maquinaController = new MaquinaController();

        // Painel de boas-vindas
        JPanel painelBoasVindas = new JPanel(new BorderLayout());
        JLabel lblBoasVindas = new JLabel("Bem-vindo, Operador! Escolha a máquina que deseja operar:", JLabel.CENTER);
        lblBoasVindas.setFont(new Font("Arial", Font.BOLD, 16));
        painelBoasVindas.add(lblBoasVindas, BorderLayout.NORTH);
        add(painelBoasVindas, BorderLayout.NORTH);

        // Painel para listar as máquinas em "blocos"
        JPanel painelMaquinas = new JPanel();
        painelMaquinas.setLayout(new BoxLayout(painelMaquinas, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(painelMaquinas); // Adicionando Scroll caso haja muitas máquinas
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem ao redor dos blocos

        // Carregar máquinas na interface
        carregarMaquinas(painelMaquinas);

        // Adicionando o painel de máquinas ao centro da view
        add(scrollPane, BorderLayout.CENTER);
    }

    // Método para carregar as máquinas em blocos visuais
    private void carregarMaquinas(JPanel painelMaquinas) {
        List<Maquina> maquinas = maquinaController.listarMaquinas();

        for (Maquina maquina : maquinas) {
            JPanel blocoMaquina = new JPanel(new BorderLayout());
            blocoMaquina.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true)); // Simula borda da máquina
            blocoMaquina.setBackground(new Color(230, 230, 250)); // Cor de fundo leve

            // Nome e Linha da Máquina
            JLabel lblNome = new JLabel("Máquina: " + maquina.getTipo(), JLabel.CENTER);
            lblNome.setFont(new Font("Arial", Font.BOLD, 14));
            JLabel lblLinha = new JLabel("Linha: " + maquina.getLinha(), JLabel.CENTER);
            lblLinha.setFont(new Font("Arial", Font.PLAIN, 12));

            // Painel para os botões de ação
            JButton btnSelecionar = new JButton("Selecionar Máquina");

            btnSelecionar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Máquina " + maquina.getTipo() + " selecionada com sucesso!");
                    // Lógica adicional após a seleção da máquina, como iniciar a operação
                }
            });

            // Adicionando os componentes ao bloco
            blocoMaquina.add(lblNome, BorderLayout.NORTH);
            blocoMaquina.add(lblLinha, BorderLayout.CENTER);
            blocoMaquina.add(btnSelecionar, BorderLayout.SOUTH);

            // Adicionando bloco ao painel de máquinas
            painelMaquinas.add(blocoMaquina);
            painelMaquinas.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre os blocos
        }
    }
}
