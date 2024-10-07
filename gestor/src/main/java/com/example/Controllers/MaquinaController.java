package com.example.Controllers;

import com.example.Models.Maquina;
import com.example.Controllers.ConnectionFactory;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MaquinaController {
    private MongoDatabase mb;

    public MaquinaController() {
        this.mb = ConnectionFactory.getDatabase();
    }

    // Método para buscar todas as máquinas
    public List<Maquina> listarMaquinas() {
        List<Maquina> maquinas = new ArrayList<>();
        MongoCollection<Document> colecao = mb.getCollection("maquinas");

        try (MongoCursor<Document> cursor = colecao.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                // Lê o estado diretamente como String
                String estado = doc.getString("estado");

                Maquina maquina = new Maquina(
                        doc.getInteger("idMaquina"),
                        doc.getInteger("linha"),
                        doc.getString("tipo"),
                        doc.getDouble("capacidadePorMin"),
                        estado,  // Passa o estado como String
                        doc.getInteger("idProduto"),
                        doc.getString("historicoManutencao")
                );
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }

    // Método para criar uma nova máquina
    public void criarMaquina(int id, int linha, String tipo, double capacidadePorMin, String estado, int idProduto, String historicoManutencao) {
        // Criar objeto Maquina
        Maquina maquina = new Maquina(id, linha, tipo, capacidadePorMin, estado, idProduto, historicoManutencao);

        // Criar documento para armazenar no MongoDB
        Document maquinaDoc = new Document("idMaquina", maquina.getIdMaquina())
                .append("linha", maquina.getLinha())
                .append("tipo", maquina.getTipo())
                .append("capacidadePorMin", maquina.getCapacidadePorMin())
                .append("estado", maquina.getEstado())  // Agora é uma String
                .append("idProduto", maquina.getIdProduto())
                .append("historicoManutencao", maquina.getHistoricoManutencao());

        // Obter a conexão com o banco de dados
        MongoDatabase database = ConnectionFactory.getDatabase();

        // Obter a coleção "maquinas"
        MongoCollection<Document> collection = database.getCollection("maquinas");

        // Inserir o documento na coleção
        collection.insertOne(maquinaDoc);

        System.out.println("Máquina criada e inserida no MongoDB: " + maquinaDoc.toJson());
    }
}
