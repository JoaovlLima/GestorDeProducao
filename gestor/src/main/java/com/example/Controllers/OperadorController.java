package com.example.Controllers;

import com.example.Models.Operador;
import com.example.Models.Maquina;
import com.example.Controllers.ConnectionFactory;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class OperadorController {
    private MongoDatabase mb;
    private Maquina maquina;

    public OperadorController() {
        this.mb = ConnectionFactory.getDatabase();
        maquina = new Maquina();
    }

    // Método para listar todos os operadores
    public List<Operador> listarOperadores() {
        List<Operador> operadores = new ArrayList<>();
        MongoCollection<Document> colecao = mb.getCollection("operadores");

        try (MongoCursor<Document> cursor = colecao.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                
                // Convertendo o campo 'turno' de string para enum
                Operador.Turno turno = Operador.Turno.valueOf(doc.getString("turno"));

                // Recuperar a lista de máquinas operadas
                List<Maquina> maquinasOperadas = new ArrayList<>();
                List<Document> maquinasDocs = (List<Document>) doc.get("maquinasOperadas");
                if (maquinasDocs != null) {
                    for (Document maquinaDoc : maquinasDocs) {
                        Maquina maquina = new Maquina(
                                maquinaDoc.getInteger("idMaquina"),
                                maquinaDoc.getInteger("linha"),
                                maquinaDoc.getString("tipo"),
                                maquinaDoc.getDouble("capacidadePorMin"),
                                maquinaDoc.getString("estado"),  // Convertendo estado
                                maquinaDoc.getInteger("idProduto"),
                                maquinaDoc.getString("historicoManutencao")  // Novo campo
                        );
                        maquinasOperadas.add(maquina);
                    }
                }

                Operador operador = new Operador(
                        doc.getInteger("re"),
                        doc.getString("nome"),
                        turno,  // Passa o turno como enum
                        doc.getString("senha"),
                        maquinasOperadas,  // Lista de máquinas operadas
                        doc.getDouble("produtividadeMedia")  // Produtividade média
                );
                operadores.add(operador);
            }
        }
        return operadores;
    }

    // Método para criar um novo operador
    public void criarOperador(int re, String nome, String turnoStr, String senha, List<Maquina> maquinasOperadas, double produtividadeMedia) {
        // Convertendo o turno de String para o enum apropriado
        Operador.Turno turno = Operador.Turno.valueOf(turnoStr);

        Operador operador = new Operador(re, nome, turno, senha, maquinasOperadas, produtividadeMedia);

        // Criar documento para armazenar no MongoDB
        List<Document> maquinasDocs = new ArrayList<>();
        for (Maquina maquina : maquinasOperadas) {
            Document maquinaDoc = new Document("idMaquina", maquina.getIdMaquina())
                    .append("linha", maquina.getLinha())
                    .append("tipo", maquina.getTipo())
                    .append("capacidadePorMin", maquina.getCapacidadePorMin())
                    .append("estado", maquina.getEstado())
                    .append("idProduto", maquina.getIdProduto())  // Novo campo
                    .append("historicoManutencao", maquina.getHistoricoManutencao());  // Novo campo
            maquinasDocs.add(maquinaDoc);
        }

        Document operadorDoc = new Document("re", operador.getRe())
                .append("nome", operador.getNome())
                .append("turno", operador.getTurno().name())  // Salva o enum como String
                .append("senha", operador.getSenha())
                .append("maquinasOperadas", maquinasDocs)  // Lista de máquinas operadas
                .append("produtividadeMedia", operador.getProdutividadeMedia());

        // Obter conexão com o banco de dados
        MongoDatabase database = ConnectionFactory.getDatabase();

        // Obter a coleção "operadores"
        MongoCollection<Document> collection = database.getCollection("operadores");

        // Inserir o documento na coleção
        collection.insertOne(operadorDoc);

        System.out.println("Operador criado e documento gerado: " + operadorDoc.toJson());
    }

    // Método para buscar um operador pelo RE e senha
    public Operador buscarOperador(int re, String senha) {
        MongoCollection<Document> colecao = mb.getCollection("operadores");

        // Busca no banco de dados pelo RE e senha
        Document operadorDoc = colecao.find(Filters.and(
                Filters.eq("re", re),
                Filters.eq("senha", senha)
        )).first();

        if (operadorDoc != null) {
            // Convertendo o campo 'turno' de string para enum
            Operador.Turno turno = Operador.Turno.valueOf(operadorDoc.getString("turno"));

            // Recuperar a lista de máquinas operadas
            List<Maquina> maquinasOperadas = new ArrayList<>();
            List<Document> maquinasDocs = (List<Document>) operadorDoc.get("maquinasOperadas");
            if (maquinasDocs != null) {
                for (Document maquinaDoc : maquinasDocs) {
                    Maquina maquina = new Maquina(
                            maquinaDoc.getInteger("idMaquina"),
                            maquinaDoc.getInteger("linha"),
                            maquinaDoc.getString("tipo"),
                            maquinaDoc.getDouble("capacidadePorMin"),
                            maquinaDoc.getString("estado"),  // Convertendo estado para enum
                            maquinaDoc.getInteger("idProduto"),  // Novo campo
                            maquinaDoc.getString("historicoManutencao")  // Novo campo
                    );
                    maquinasOperadas.add(maquina);
                }
            }

            return new Operador(
                    operadorDoc.getInteger("re"),
                    operadorDoc.getString("nome"),
                    turno,  // Converte string para enum Turno
                    operadorDoc.getString("senha"),
                    maquinasOperadas,  // Lista de máquinas operadas
                    operadorDoc.getDouble("produtividadeMedia")  // Produtividade média
            );
        } else {
            return null; // Retorna null se o operador não for encontrado
        }
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

}
