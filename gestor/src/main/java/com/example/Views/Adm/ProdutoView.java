package com.example.Views.Adm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.ProdutoController;
import com.example.Models.Produto;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ProdutoView extends JPanel {
    private ProdutoController produtoController;
    private JTable tabelaProdutos;
    private DefaultTableModel modeloTabela;

    public ProdutoView() {
        setLayout(new BorderLayout());
        produtoController = new ProdutoController();

        // Painel de Cadastro de Produtos
        JPanel painelCadastro = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel lblIdProduto = new JLabel("ID do Produto:");
        JTextField txtIdProduto = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblTempoProduzirKg = new JLabel("Tempo para Produzir (kg):");
        JTextField txtTempoProduzirKg = new JTextField();
        JLabel lblQuantidadeMaterias = new JLabel("Quantidade de Matérias:");
        JTextField txtQuantidadeMaterias = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar Produto");

        painelCadastro.add(lblIdProduto);
        painelCadastro.add(txtIdProduto);
        painelCadastro.add(lblNome);
        painelCadastro.add(txtNome);
        painelCadastro.add(lblTempoProduzirKg);
        painelCadastro.add(txtTempoProduzirKg);
        painelCadastro.add(lblQuantidadeMaterias);
        painelCadastro.add(txtQuantidadeMaterias);
        painelCadastro.add(new JLabel()); // Espaço vazio
        painelCadastro.add(btnCadastrar);

        // Tabela para listar os produtos
        String[] colunas = {"ID do Produto", "Nome", "Tempo para Produzir (kg)", "Quantidade de Matérias"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaProdutos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);

        // Adicionando componentes ao painel principal
        add(painelCadastro, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Ação do botão "Cadastrar Produto"
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idProduto = Integer.parseInt(txtIdProduto.getText());
                    String nome = txtNome.getText();
                    double tempoProduzirKg = Double.parseDouble(txtTempoProduzirKg.getText());
                    int quantidadeMaterias = Integer.parseInt(txtQuantidadeMaterias.getText());

                    produtoController.criarProduto(idProduto, nome, tempoProduzirKg, quantidadeMaterias);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

                    // Adiciona o produto à tabela
                    modeloTabela.addRow(new Object[]{idProduto, nome, tempoProduzirKg, quantidadeMaterias});
                    
                    // Limpar os campos após o cadastro
                    txtIdProduto.setText("");
                    txtNome.setText("");
                    txtTempoProduzirKg.setText("");
                    txtQuantidadeMaterias.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + ex.getMessage());
                    System.out.println(ex);
                }
            }
        });

        // Carregar produtos na tabela ao iniciar a view
        carregarProdutos();
    }

    private void carregarProdutos() {
        List<Produto> produtos = produtoController.listarProdutos();
        for (Produto produto : produtos) {
            modeloTabela.addRow(new Object[]{
                produto.getIdProduto(), 
                produto.getNome(), 
                produto.getTempoProduzirKg(), 
                produto.getQuantidadeMaterias()
            });
        }
    }
}
