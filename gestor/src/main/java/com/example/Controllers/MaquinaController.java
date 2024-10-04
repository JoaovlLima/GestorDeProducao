package com.example.Controllers;

import com.example.Models.Maquina;
import com.example.Controllers.ConnectionFactory;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MaquinaController {

    public void criarMaquina(int id, int linha, String tipo, double capacidadePorMin, String estado, int idProduto) {
        // Criar objeto Maquina
        Maquina maquina = new Maquina(id, linha, tipo, capacidadePorMin, estado, idProduto);
        
        // Criar documento para armazenar no MongoDB
        Document maquinaDoc = new Document("id", maquina.getIdMaquina())
                .append("linha", maquina.getLinha())
                .append("tipo", maquina.getTipo())
                .append("capacidadePorMin", maquina.getCapacidadePorMin())
                .append("estado", maquina.getEstado())
                .append("idProduto", maquina.getIdProduto());

        // Obter conexão com o banco de dados
        MongoDatabase database = ConnectionFactory.getDatabase();

        // Obter a coleção "maquinas"
        MongoCollection<Document> collection = database.getCollection("maquinas");

        // Inserir o documento na coleção
        collection.insertOne(maquinaDoc);
        
        System.out.println("Maquina criada e inserida no MongoDB: " + maquinaDoc.toJson());
    }
}
