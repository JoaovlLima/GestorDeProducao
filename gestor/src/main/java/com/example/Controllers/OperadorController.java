package com.example.Controllers;

import org.bson.Document;

import com.example.Models.Operador;

public class OperadorController {
    
    public void criarOperador(int re, String nome, String turno, String senha){
        

Operador operador = new Operador(re, nome, turno,senha);

Document operadorDoc = new Document("re",operador).append("nome", operador)
.append("turno", operador).append("senha", operador);
 

        
        
    }
}
