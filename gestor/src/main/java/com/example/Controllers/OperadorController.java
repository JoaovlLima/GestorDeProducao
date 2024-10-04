package com.example.Controllers;

import com.example.Models.Operador;
import com.example.Controllers.ConnectionFactory;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class OperadorController {
    
    public void criarOperador(int re, String nome, String turno, String senha) {
        
        Operador operador = new Operador(re, nome, turno, senha);
        
     
        Document operadorDoc = new Document("re", operador.getRe())
                .append("nome", operador.getNome())
                .append("turno", operador.getTurno())
                .append("senha", operador.getSenha());

        
        // Obter conexão com o banco de dados
        MongoDatabase database = ConnectionFactory.getDatabase();

        // Obter a coleção "operadores"
        MongoCollection<Document> collection = database.getCollection("operadores");

        // Inserir o documento na coleção
        collection.insertOne(operadorDoc);
        
        
        System.out.println("Operador criado e documento gerado: " + operadorDoc.toJson());
    }
}