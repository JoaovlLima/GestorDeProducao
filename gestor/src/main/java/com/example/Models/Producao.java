package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Producao {
    private int idProducao;
    private int idMaquina;
    private double quantidadeProd;
    private double tempoProd;
    private int ReOperador;
    private String data;

    public double calcularEficiência(Maquina maquina) {
        double capacidadeEsperada = maquina.getCapacidadePorMin() * (tempoProd / 60);
        return (quantidadeProd / capacidadeEsperada) * 100; 
    }

    public boolean foiConcluida() {
        return quantidadeProd > 0 && tempoProd > 0;
    }
}
