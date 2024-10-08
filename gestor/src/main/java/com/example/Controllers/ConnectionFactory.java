package com.example.Controllers;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionFactory {
    private static MongoClient mongoClient;
    private static final String CONNECTION_STRING = "mongodb://localhost:27017"; // URL do MongoDB
    private static final String DATABASE_NAME = "GestorProducao"; // Nome do banco de dados
    private static MongoDatabase database;

    // Método para configurar um banco de dados mock
    public static void setMockDatabase(MongoDatabase mockDatabase) {
        database = mockDatabase;
    }
    // Método para criar a conexão
    private static void createMongoClient() {
        if (mongoClient == null) {
            try {
                mongoClient = MongoClients.create(CONNECTION_STRING); // Conecta ao MongoDB
            } catch (Exception e) {
                System.err.println("Erro ao conectar ao MongoDB: " + e.getMessage());
            }
        }
    }

    // Método para obter o banco de dados
    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            createMongoClient();
        }
        return mongoClient.getDatabase(DATABASE_NAME); // Retorna o banco de dados
    }

    // Método para fechar a conexão
    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
