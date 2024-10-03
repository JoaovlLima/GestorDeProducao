package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Adm {
    private int idAdm;
    private String nomeAdm;
    private String senhaAdm;



    public boolean validarSenha(String senha) {
        return this.senhaAdm.equals(senha);
    }

    
}
