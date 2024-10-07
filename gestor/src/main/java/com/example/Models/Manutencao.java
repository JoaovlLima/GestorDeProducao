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
public class Manutencao {
    private int id;
    private int idMaquina;
    private String descricaoProblema;
    private String acaoCorretiva;
    private Date dataManutencao;
    private int idOperadorResponsavel;
}
