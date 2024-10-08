import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.example.Controllers.MaquinaController;
import com.example.Models.Maquina;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class MaquinaControllerTest {

    private MongoDatabase mockDatabase;
    private MongoCollection<Document> mockCollection;
    private FindIterable<Document> mockFindIterable;
    private MongoCursor<Document> mockCursor;

    @Before
    public void setUp() {
        mockDatabase = mock(MongoDatabase.class);
        mockCollection = mock(MongoCollection.class);
        mockFindIterable = mock(FindIterable.class);
        mockCursor = mock(MongoCursor.class);

        // Quando chamar getCollection("maquinas"), retorna a collection mockada
        when(mockDatabase.getCollection("maquinas")).thenReturn(mockCollection);

        // Quando chamar find(), retorna o FindIterable mockado
        when(mockCollection.find()).thenReturn(mockFindIterable);

        // Quando iterator() for chamado no FindIterable, retorna o cursor mockado
        when(mockFindIterable.iterator()).thenReturn(mockCursor);
    }

    @Test
    public void testListarMaquinas() {
        // Criar documento mockado
        Document mockDocument = new Document("idMaquina", 1)
                                    .append("linha", 2)
                                    .append("tipo", "tipoTeste")
                                    .append("capacidadePorMin", 100.0)
                                    .append("estado", "OPERANDO")
                                    .append("idProduto", 123)
                                    .append("historicoManutencao", "Manutenção teste");

        // Configurar o cursor para ter valores e finalizar corretamente
        when(mockCursor.hasNext()).thenReturn(true, false);  // Primeira chamada: true, segunda: false
        when(mockCursor.next()).thenReturn(mockDocument);

        // Criar o MaquinaController com a database mockada
        MaquinaController maquinaController = new MaquinaController();
        maquinaController.setDatabase(mockDatabase);  // Definir a database mockada no controlador

        // Executar o método que estamos testando
        List<Maquina> maquinas = maquinaController.listarMaquinas();

        // Verificar se a lista retornada contém os dados esperados
        assertEquals(1, maquinas.size());  // Deve retornar 1 máquina
        Maquina maquina = maquinas.get(0);
        assertEquals(1, maquina.getIdMaquina());
        assertEquals(2, maquina.getLinha());
        assertEquals("tipoTeste", maquina.getTipo());
        assertEquals(100.0, maquina.getCapacidadePorMin(), 0.001);
        assertEquals("OPERANDO", maquina.getEstado());
        assertEquals(123, maquina.getIdProduto());
        assertEquals("Manutenção teste", maquina.getHistoricoManutencao());
    }

    @Test
    public void testCriarMaquina() {
        // Criar o controlador
        MaquinaController maquinaController = new MaquinaController();
        maquinaController.setDatabase(mockDatabase);

        // Chamar o método a ser testado
        maquinaController.criarMaquina(1, 2, "tipoTeste", 100.0, "OPERANDO", 123, "Manutenção teste");

        // Verificar se o método insertOne foi chamado com o documento correto
        Document expectedDocument = new Document("idMaquina", 1)
                .append("linha", 2)
                .append("tipo", "tipoTeste")
                .append("capacidadePorMin", 100.0)
                .append("estado", "OPERANDO")
                .append("idProduto", 123)
                .append("historicoManutencao", "Manutenção teste");
        
        verify(mockCollection).insertOne(expectedDocument);
    }

    @Test
    public void testAtualizarMaquina() {
        // Criar o controlador
        MaquinaController maquinaController = new MaquinaController();
        maquinaController.setDatabase(mockDatabase);

        // Chamar o método a ser testado
        maquinaController.atualizarMaquina(1, 2, "tipoAtualizado", 150.0, "PARADO", 456, "Manutenção atualizada");

        // Verificar se o método updateOne foi chamado com os parâmetros corretos
        Document updatedDocument = new Document()
                .append("linha", 2)
                .append("tipo", "tipoAtualizado")
                .append("capacidadePorMin", 150.0)
                .append("estado", "PARADO")
                .append("idProduto", 456)
                .append("historicoManutencao", "Manutenção atualizada");
        
        verify(mockCollection).updateOne(Filters.eq("idMaquina", 1), new Document("$set", updatedDocument));
    }

    @Test
    public void testRemoverMaquina() {
        // Criar o controlador
        MaquinaController maquinaController = new MaquinaController();
        maquinaController.setDatabase(mockDatabase);

        // Chamar o método a ser testado
        maquinaController.removerMaquina(1);

        // Verificar se o método deleteOne foi chamado com o filtro correto
        verify(mockCollection).deleteOne(Filters.eq("idMaquina", 1));
    }
}
