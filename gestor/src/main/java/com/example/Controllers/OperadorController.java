package com.example.Controllers;

import com.example.Models.Operador;
import com.example.Controllers.ConnectionFactory;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.internal.connection.DefaultClusterableServerFactory;

import org.bson.Document;

public class OperadorController {
    private MongoDatabase mb;

    public OperadorController(){
        this.mb = ConnectionFactory.getDatabase();
    }

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

    public  Operador buscarOperador(int re, String senha){
        MongoCollection<Document> colecao = mb.getCollection("operadores");

       // Busca no banco de dados pelo nome e senha
        Document operadorDoc = colecao.find(Filters.and(
            Filters.eq("re", re),
            Filters.eq("senha", senha)
        )).first();

        if (operadorDoc != null) {
            return new Operador(
                operadorDoc.getInteger("re"),
                operadorDoc.getString("nome"),
                operadorDoc.getString("turno"),
                operadorDoc.getString("senha")
            );
        } else {
            return null; // Retorna null se o operador não for encontrado
        }

    }

}