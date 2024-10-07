package com.example.Views.Operador;

import java.awt.BorderLayout;

import javax.swing.*;


import com.example.Models.Maquina;
import com.example.Models.Operador;
import com.example.Models.Producao;
import com.example.Models.Producao.StatusProducao;

public class ProducaoView extends JPanel {
    private Maquina maquinaSelecionada;
    private Operador operador;

    public ProducaoView(Maquina maquina) {
        this.maquinaSelecionada = maquina;
        operador = new Operador();
        setLayout(new BorderLayout());

        JLabel lblMaquina = new JLabel("Máquina selecionada: " + maquina.getTipo());
        add(lblMaquina, BorderLayout.NORTH);

        JTextField quantidadeField = new JTextField();
        JTextField tempoField = new JTextField();
        
        JButton iniciarBtn = new JButton("Iniciar Produção");
        iniciarBtn.addActionListener(e -> {
            // Criar objeto Producao e salvar via método post
            Producao producao = new Producao();
            producao.setIdMaquina(maquina.getIdMaquina());
            producao.setQuantidadeProd(Double.parseDouble(quantidadeField.getText()));
            producao.setTempoProd(Double.parseDouble(tempoField.getText()));
            producao.setReOperador(operador.getRe()); // Associar o operador
            producao.setStatus(StatusProducao.EM_ANDAMENTO);
            producao.post();  // Salva a produção

            JOptionPane.showMessageDialog(null, "Produção Iniciada!");
        });
        
        add(quantidadeField, BorderLayout.CENTER);
        add(tempoField, BorderLayout.CENTER);
        add(iniciarBtn, BorderLayout.SOUTH);
    }
}
