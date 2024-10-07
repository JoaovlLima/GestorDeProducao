package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Producao {
    private int id;
    private int idMaquina;
    private double quantidadeProd;
    private double tempoProd;
    private int reOperador;
    private Date data;
    private StatusProducao status;
    private double eficiencia;

    public enum StatusProducao {
        EM_ANDAMENTO,
        FINALIZADA
    }
}
