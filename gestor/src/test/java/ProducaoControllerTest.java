import com.example.Controllers.ProducaoController;
import com.example.Models.Producao;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProducaoControllerTest {

    private ProducaoController producaoController;
    private MongoDatabase mockDatabase;
    private MongoCollection<Document> mockCollection;

    @Before
    public void setUp() {
        // Criação dos mocks
        mockDatabase = mock(MongoDatabase.class);
        mockCollection = mock(MongoCollection.class);

        // Configurando o comportamento do mock do banco de dados
        when(mockDatabase.getCollection("producoes")).thenReturn(mockCollection);

        // Inicializando o controlador com o banco de dados mockado
        producaoController = new ProducaoController();
        producaoController.setDatabase(mockDatabase); // Método para injetar o banco de dados mockado
    }

    @Test
public void testListarProducoes() {
    // Criação de documentos de exemplo
    Document doc1 = new Document("id", 1)
            .append("idMaquina", 1)
            .append("quantidadeProd", 100.0)
            .append("tempoProd", 5.0)
            .append("reOperador", 1)
            .append("data", new Date())
            .append("status", Producao.StatusProducao.FINALIZADA.name())
            .append("eficiencia", 0.9);

    Document doc2 = new Document("id", 2)
            .append("idMaquina", 2)
            .append("quantidadeProd", 150.0)
            .append("tempoProd", 4.0)
            .append("reOperador", 2)
            .append("data", new Date())
            .append("status", Producao.StatusProducao.EM_ANDAMENTO.name())
            .append("eficiencia", 0.85);

    // Mock para FindIterable
    FindIterable<Document> mockFindIterable = mock(FindIterable.class);

    // Mock para MongoCursor
    MongoCursor<Document> mockCursor = mock(MongoCursor.class);
    
    // Configurando o comportamento do mock
    when(mockCollection.find()).thenReturn(mockFindIterable);
    when(mockFindIterable.iterator()).thenReturn(mockCursor);
    when(mockCursor.hasNext()).thenReturn(true, true, false); // Duas chamadas para hasNext() - duas produções
    when(mockCursor.next()).thenReturn(doc1, doc2); // Retorna os documentos quando next() é chamado

    // Chamando o método
    List<Producao> producoes = producaoController.listarProducoes();

    // Verificando se as produções foram listadas corretamente
    assert producoes.size() == 2;
    assert producoes.get(0).getId() == 1;
    assert producoes.get(1).getId() == 2;

    // Verificando se o método find foi chamado uma vez
    verify(mockCollection, times(1)).find();
}

@Test
public void testCriarProducao() {
    // Criando um mock para o retorno de InsertOneResult
    InsertOneResult mockResult = mock(InsertOneResult.class);

    // Configurando o comportamento do mockCollection para o insertOne
    when(mockCollection.insertOne(any(Document.class))).thenReturn(mockResult);

    // Chamando o método para criar uma produção
    producaoController.criarProducao(1, 100.0, 5.0, 1, new Date(), Producao.StatusProducao.EM_ANDAMENTO, 0.9);

    // Verificando se o método insertOne foi chamado uma vez
    verify(mockCollection, times(1)).insertOne(any(Document.class));
}
    

    @Test
public void testRemoverProducao() {
    // Criando um mock para o retorno de DeleteResult
    DeleteResult mockDeleteResult = mock(DeleteResult.class);

    // Configurando o comportamento do mock para deleteOne
    when(mockCollection.deleteOne(any())).thenReturn(mockDeleteResult);

    // Chamando o método para remover uma produção
    producaoController.removerProducao(1);

    // Verificando se o método deleteOne foi chamado uma vez
    verify(mockCollection, times(1)).deleteOne(any());
}
}
