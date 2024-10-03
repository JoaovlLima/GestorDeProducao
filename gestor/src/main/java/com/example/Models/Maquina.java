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

    public boolean estaDisponivel() {
        return this.estado.equalsIgnoreCase("disponivel");
    }

    public void alterarEstado(String novoEstado) {
        this.estado = novoEstado;
    }

    public boolean trocarProduto(int novoIdProduto) {
        if (this.estaDisponivel()) {
            this.idProduto = novoIdProduto;
            return true;
        } else {
            System.out.println("A máquina não está disponível para troca de produto.");
            return false;
        }
    }
    
}
