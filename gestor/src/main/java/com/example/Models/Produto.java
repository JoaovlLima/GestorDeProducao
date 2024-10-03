package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Produto {
    private int idProduto;
    private String nome;
    private double tempoProduzirKg;
    private int quantidadeMaterias;

    public boolean trocarProduto(Maquina maquina, int novoIdProduto) {
        if (maquina.trocarProduto(novoIdProduto)) {
            this.idProduto = novoIdProduto;
            System.out.println("Produto trocado com sucesso na produção.");
            return true;
        } else {
            System.out.println("Falha ao trocar o produto na produção.");
            return false;
        }
    }
}
