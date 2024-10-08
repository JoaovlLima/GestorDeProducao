package com.example.Views.Operador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.ProducaoController;
import com.example.Models.Producao;
import java.util.Date;

public class ProducaoView extends JFrame {
    private ProducaoController producaoController;
    private int reOperador;
    private int idMaquina;

    private JTextField txtQuantidadeProd;
    private JTextField txtTempoProd;
    private JButton btnSalvar;
    private JButton btnListar; // Botão para listar produções

    public ProducaoView(int reOperador, int idMaquina) {
        this.reOperador = reOperador;
        this.idMaquina = idMaquina;
        producaoController = new ProducaoController();

        setTitle("Registro de Produção");
        setLayout(new GridLayout(5, 2, 10, 10));

        // Campos de entrada
        add(new JLabel("Quantidade de Produto:"));
        txtQuantidadeProd = new JTextField();
        add(txtQuantidadeProd);

        add(new JLabel("Tempo de Produção (em horas):"));
        txtTempoProd = new JTextField();
        add(txtTempoProd);

        btnSalvar = new JButton("Salvar Produção");
        add(btnSalvar);

        btnListar = new JButton("Listar Produções"); // Inicialização do botão de listar
        add(btnListar); // Adiciona o botão ao layout

        // Configurações da janela
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ação do botão de salvar
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarProducao();
            }
        });

        // Ação do botão de listar
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarProducoes();
            }
        });
    }

    private void salvarProducao() {
        try {
            double quantidadeProd = Double.parseDouble(txtQuantidadeProd.getText());
            double tempoProd = Double.parseDouble(txtTempoProd.getText());

            // Calcular a eficiência
            double eficiencia = calcularEficiencia(quantidadeProd, tempoProd);

            // Criar uma nova produção
            Producao.StatusProducao status = Producao.StatusProducao.EM_ANDAMENTO; // Ou o status desejado
            Date dataAtual = new Date();
            producaoController.criarProducao(idMaquina, quantidadeProd, tempoProd, reOperador, dataAtual, status, eficiencia);

            JOptionPane.showMessageDialog(this, "Produção salva com sucesso!\nEficiência: " + eficiencia);
            dispose(); // Fecha a janela
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para calcular a eficiência
    private double calcularEficiencia(double quantidadeProd, double tempoProd) {
        if (tempoProd <= 0) {
            return 0;
        }
        return quantidadeProd / tempoProd; 
    }

    // Método para listar produções
    private void listarProducoes() {
        ListaProducaoView listaView = new ListaProducaoView(producaoController);
        listaView.setVisible(true);
    }

    public void run() {
        setVisible(true);
    }
}
