package com.example.Views.Operador;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.example.Controllers.ProducaoController;

public class JanelaPrincipal extends JFrame {

    private JTabbedPane jTPane;

    public JanelaPrincipal(int reRecuperado) {
        super();
        
        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs

        OperadorHomeView tab1 = new OperadorHomeView(reRecuperado);
        jTPane.add("Maquinas", tab1);
       


        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // jTPane.addChangeListener(e -> {
        // tab2.atualizarVendasCli();
        // tab2.atualizarVendasCar();
        // });
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }

}
