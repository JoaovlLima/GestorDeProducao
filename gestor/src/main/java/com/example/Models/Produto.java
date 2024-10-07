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

    
}
