package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Operador {
    private int re;
    private String nome;
    private Turno turno;
    private String senha;
    private List<Maquina> maquinasOperadas;
    private double produtividadeMedia;

    public enum Turno {
        MANHA,
        TARDE,
        NOITE
    }
}
