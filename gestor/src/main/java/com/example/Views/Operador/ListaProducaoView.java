package com.example.Views.Operador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.example.Controllers.ProducaoController;
import com.example.Models.Producao;
import java.awt.*;
import java.util.List;

public class ListaProducaoView extends JFrame {
    private ProducaoController producaoController;
    private JTable table;

    public ListaProducaoView(ProducaoController producaoController) {
        this.producaoController = producaoController;
        setTitle("Lista de Produções");
        setSize(700, 400); // Aumenta o tamanho para acomodar mais colunas
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Configuração da tabela
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        // Carrega as produções na tabela
        carregarProducoes();
    }

    private void carregarProducoes() {
        // Obtém a lista de produções do controlador
        List<Producao> producoes = producaoController.listarProducoes();

        // Cria o modelo de tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("ID Máquina");
        model.addColumn("Quantidade");
        model.addColumn("Tempo");
        model.addColumn("Re Operador");
        model.addColumn("Data");
        model.addColumn("Status");
        model.addColumn("Eficiência");

        // Preenche o modelo com dados
        for (Producao producao : producoes) {
            model.addRow(new Object[]{
                producao.getId(), 
                producao.getIdMaquina(), 
                producao.getQuantidadeProd(), 
                producao.getTempoProd(), 
                producao.getReOperador(), // Certifique-se de ter um getter para reOperador
                producao.getData(), // Método para obter a data
                producao.getStatus(), // Status da produção
                producao.getEficiencia() // Eficiência
            });
        }

        // Define o modelo na tabela
        table.setModel(model);
    }
}
