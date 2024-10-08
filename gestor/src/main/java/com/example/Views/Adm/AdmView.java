package com.example.Views.Adm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.Controllers.OperadorController;
import com.example.Controllers.ProdutoController;
import com.example.Controllers.MaquinaController;

public class AdmView extends JFrame {

    private JTabbedPane jTPane;
   
    public AdmView() {
        super();

        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs
        // tab1 carros
        OperadorView tab1 = new OperadorView();
        jTPane.add("Operadores", tab1);
        ProdutoView tab2 = new ProdutoView();
        jTPane.add("Produto", tab2);
        MaquinaView tab3 = new MaquinaView();
        jTPane.add("Maquina", tab3);
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // jTPane.addChangeListener(e -> {
        //     tab2.atualizarVendasCli();
        //     tab2.atualizarVendasCar();
        // });
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }

        
    }

    

   

   

        

