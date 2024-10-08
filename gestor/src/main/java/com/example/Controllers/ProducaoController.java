package com.example.Controllers;

import com.example.Models.Producao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProducaoController {
    private MongoDatabase mb;

    public ProducaoController() {
        this.mb = ConnectionFactory.getDatabase(); // Conexão com o banco de dados
    }

    // Método para listar todas as produções
    public List<Producao> listarProducoes() {
        List<Producao> producoes = new ArrayList<>();
        MongoCollection<Document> colecao = mb.getCollection("producoes");

        try (MongoCursor<Document> cursor = colecao.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                Producao producao = new Producao(
                        doc.getInteger("id"),
                        doc.getInteger("idMaquina"),
                        doc.getDouble("quantidadeProd"),
                        doc.getDouble("tempoProd"),
                        doc.getInteger("reOperador"),
                        doc.getDate("data"),
                        Producao.StatusProducao.valueOf(doc.getString("status")),
                        doc.getDouble("eficiencia")
                );
                producoes.add(producao);
            }
        }
        return producoes;
    }

    // Método para criar uma nova produção
    public void criarProducao(int idMaquina, double quantidadeProd, double tempoProd, int reOperador, Date data, Producao.StatusProducao status, double eficiencia) {
        Document producaoDoc = new Document("id", gerarNovoId()) // Gerar um novo ID (você pode implementar sua lógica aqui)
                .append("idMaquina", idMaquina)
                .append("quantidadeProd", quantidadeProd)
                .append("tempoProd", tempoProd)
                .append("reOperador", reOperador)
                .append("data", data)
                .append("status", status.name())
                .append("eficiencia", eficiencia);

        MongoCollection<Document> collection = mb.getCollection("producoes");
        collection.insertOne(producaoDoc);
    }

    // Método para atualizar uma produção
    public void atualizarProducao(int id, int idMaquina, double quantidadeProd, double tempoProd, int reOperador, Date data, Producao.StatusProducao status, double eficiencia) {
        MongoCollection<Document> collection = mb.getCollection("producoes");
        Document producaoAtualizada = new Document()
                .append("idMaquina", idMaquina)
                .append("quantidadeProd", quantidadeProd)
                .append("tempoProd", tempoProd)
                .append("reOperador", reOperador)
                .append("data", data)
                .append("status", status.name())
                .append("eficiencia", eficiencia);

        collection.updateOne(Filters.eq("id", id), new Document("$set", producaoAtualizada));
    }

    // Método para remover uma produção
    public void removerProducao(int id) {
        MongoCollection<Document> collection = mb.getCollection("producoes");
        collection.deleteOne(Filters.eq("id", id));
    }

    // Método para gerar um novo ID (exemplo simples, pode ser ajustado conforme a necessidade)
    private int gerarNovoId() {
        // Implementar lógica para gerar um novo ID único
        // Exemplo: buscar o maior ID atual e adicionar 1
        return 1; // Substitua pela lógica real de geração de ID
    }
}
