package com.example.Controllers;

import com.example.Models.Maquina;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import com.mongodb.client.model.Filters;

public class MaquinaController {
    public MongoDatabase mb;
   
    public void setDatabase(MongoDatabase database) {
        this.mb = database;
    }

    public MaquinaController() {
        this.mb = ConnectionFactory.getDatabase();
    }

    // Método para buscar todas as máquinas (já implementado)
    public List<Maquina> listarMaquinas() {
        List<Maquina> maquinas = new ArrayList<>();
        MongoCollection<Document> colecao = mb.getCollection("maquinas");

        try (MongoCursor<Document> cursor = colecao.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                Maquina maquina = new Maquina(
                        doc.getInteger("idMaquina"),
                        doc.getInteger("linha"),
                        doc.getString("tipo"),
                        doc.getDouble("capacidadePorMin"),
                        doc.getString("estado"),
                        doc.getInteger("idProduto"),
                        doc.getString("historicoManutencao")
                );
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }

    // Método para criar uma nova máquina (já implementado)
    public void criarMaquina(int id, int linha, String tipo, double capacidadePorMin, String estado, int idProduto, String historicoManutencao) {
        Document maquinaDoc = new Document("idMaquina", id)
                .append("linha", linha)
                .append("tipo", tipo)
                .append("capacidadePorMin", capacidadePorMin)
                .append("estado", estado)
                .append("idProduto", idProduto)
                .append("historicoManutencao", historicoManutencao);

        MongoCollection<Document> collection = mb.getCollection("maquinas");
        collection.insertOne(maquinaDoc);
    }

    // Método para atualizar uma máquina
    public void atualizarMaquina(int idMaquina, int linha, String tipo, double capacidadePorMin, String estado, int idProduto, String historicoManutencao) {
        MongoCollection<Document> collection = mb.getCollection("maquinas");
        Document maquinaAtualizada = new Document()
                .append("linha", linha)
                .append("tipo", tipo)
                .append("capacidadePorMin", capacidadePorMin)
                .append("estado", estado)
                .append("idProduto", idProduto)
                .append("historicoManutencao", historicoManutencao);

        collection.updateOne(Filters.eq("idMaquina", idMaquina), new Document("$set", maquinaAtualizada));
    }

    // Método para remover uma máquina
    public void removerMaquina(int idMaquina) {
        MongoCollection<Document> collection = mb.getCollection("maquinas");
        collection.deleteOne(Filters.eq("idMaquina", idMaquina));
    }
}
