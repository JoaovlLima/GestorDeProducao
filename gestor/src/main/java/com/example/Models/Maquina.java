package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Maquina {
    private int idMaquina;
    private int linha;
    private String tipo;
    private double capacidadePorMin;
    private String estado;
    private int idProduto;
    private String historicoManutencao;

    @Override
    public String toString() {
        return tipo + " (Linha: " + linha + ")";
    }   
}
