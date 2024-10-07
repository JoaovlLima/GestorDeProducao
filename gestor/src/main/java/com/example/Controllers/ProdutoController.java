package com.example.Controllers;

import com.example.Models.Produto;
import com.example.Controllers.ConnectionFactory;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class ProdutoController {
    private MongoDatabase mb;

    public ProdutoController(){
        this.mb = ConnectionFactory.getDatabase();
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        MongoCollection<Document> colecao = mb.getCollection("produtos");

        try (MongoCursor<Document> cursor = colecao.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Produto produto = new Produto(
                        doc.getInteger("idProduto"),
                        doc.getString("nome"),
                        doc.getDouble("tempoProduzirKg"),
                        doc.getInteger("quantidadeMaterias")
                );
                produtos.add(produto);
            }
        }
        return produtos;
    }

    public void criarProduto(int id, String nome, double tempoProduzirKg, int quantidadeMaterias) {
        // Criar objeto Produto
        Produto produto = new Produto(id, nome, tempoProduzirKg, quantidadeMaterias);
        
        // Criar documento para armazenar no MongoDB
        Document produtoDoc = new Document("idProduto", produto.getIdProduto())
                .append("nome", produto.getNome())
                .append("tempoProduzirKg", produto.getTempoProduzirKg())
                .append("quantidadeMaterias", produto.getQuantidadeMaterias());

        // Obter conexão com o banco de dados
        MongoDatabase database = ConnectionFactory.getDatabase();

        // Obter a coleção "produtos"
        MongoCollection<Document> collection = database.getCollection("produtos");

        // Inserir o documento na coleção
        collection.insertOne(produtoDoc);
        
        System.out.println("Produto criado e inserido no MongoDB: " + produtoDoc.toJson());
    }
}