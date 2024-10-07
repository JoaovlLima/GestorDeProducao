package com.example.Views.Operador;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame {
    


    private JTabbedPane jTPane;
    
    public JanelaPrincipal() {
        super();

        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs
        // tab1 carros
        OperadorHomeView tab1 = new OperadorHomeView();
        jTPane.add("Maquinas", tab1);
       
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
