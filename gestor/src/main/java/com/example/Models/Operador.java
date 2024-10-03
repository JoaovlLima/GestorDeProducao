package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Operador {
private int re;
private String nome;
private String turno;
private String senha;


 
public Producao iniciarProducao(Maquina maquina, double quantidade, String data) {
    double tempoEstimado = calcularTempoProducao(maquina, quantidade);
    return new Producao(0, maquina.getIdMaquina(), quantidade, tempoEstimado, this.re, data);
}

private double calcularTempoProducao(Maquina maquina, double quantidade) {
    return quantidade / maquina.getCapacidadePorMin();  
}

// Validações
public boolean validarSenha(String senha) {
    return this.senha.equals(senha);
}
}


