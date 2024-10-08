import com.example.Controllers.OperadorController;
import com.example.Models.Operador;
import com.example.Models.Maquina;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class OperadorControllerTest {
    private OperadorController operadorController;
    private MongoDatabase mockDatabase;
    private MongoCollection<Document> mockCollection;
    private FindIterable<Document> mockFindIterable;
    private MongoCursor<Document> mockCursor;

    @Before
    public void setUp() {
        // Criação dos mocks
        mockDatabase = mock(MongoDatabase.class);
        mockCollection = mock(MongoCollection.class);
        mockFindIterable = mock(FindIterable.class); // Mock do FindIterable
        mockCursor = mock(MongoCursor.class);

        // Configurando o comportamento do mock
        when(mockDatabase.getCollection("operadores")).thenReturn(mockCollection);
        when(mockCollection.find()).thenReturn(mockFindIterable); // Retornando FindIterable
        when(mockFindIterable.iterator()).thenReturn(mockCursor); // Retornando o cursor do FindIterable

        // Inicializa o OperadorController com o banco de dados mock
        operadorController = new OperadorController();
        operadorController.setDatabase(mockDatabase);
    }

    @Test
    public void testListarOperadores() {
        // Configurando o cursor mock para retornar um documento
        Document doc = new Document("re", 123)
                .append("nome", "Operador Teste")
                .append("turno", "NOITE")
                .append("senha", "senha123")
                .append("produtividadeMedia", 75.0);

        // Simulando o comportamento do cursor
        when(mockCursor.hasNext()).thenReturn(true).thenReturn(false); // Retorna um documento uma vez
        when(mockCursor.next()).thenReturn(doc); // Retorna o documento quando next() é chamado

        // Chama o método e verifica o resultado
        List<Operador> operadores = operadorController.listarOperadores();
        assertEquals(1, operadores.size()); // Verifica se um operador foi adicionado
        assertEquals("Operador Teste", operadores.get(0).getNome()); // Verifica o nome do operador
    }

  
    }

   

