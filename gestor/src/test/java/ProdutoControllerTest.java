import com.example.Controllers.ProdutoController;
import com.example.Models.Produto;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable; // Importando FindIterable
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ProdutoControllerTest {

    private ProdutoController produtoController;
    private MongoDatabase mockDatabase;
    private MongoCollection<Document> mockCollection;

    // O método de inicialização será executado antes de cada teste
    @Before
    public void setUp() {
        // Criando os mocks
        mockDatabase = mock(MongoDatabase.class);
        mockCollection = mock(MongoCollection.class);

        // Configurando o comportamento do mock do banco de dados
        when(mockDatabase.getCollection("produtos")).thenReturn(mockCollection);

        // Inicializando o controlador ProdutoController com o banco de dados mockado
        produtoController = new ProdutoController();
        produtoController.setDatabase(mockDatabase); // Usando o método para injetar o banco de dados mockado
    }

    // Testando a criação de um produto
    @Test
    public void testCriarProduto() {
        // Certifica-se de que o controlador foi inicializado
        assertNotNull(produtoController);

        // Chama o método para criar um produto
        produtoController.criarProduto(1, "Produto Teste", 1.5, 10);

        // Verifica se o método insertOne() foi chamado com qualquer documento
        verify(mockCollection, times(1)).insertOne(any(Document.class));
    }

    // Testando a listagem de produtos
    @Test
    public void testListarProdutos() {
        // Criar um documento simulado
        Document doc1 = new Document("idProduto", 1)
                .append("nome", "Produto 1")
                .append("tempoProduzirKg", 1.5)
                .append("quantidadeMaterias", 10);
        Document doc2 = new Document("idProduto", 2)
                .append("nome", "Produto 2")
                .append("tempoProduzirKg", 2.5)
                .append("quantidadeMaterias", 20);
        
        // Configurando o comportamento do mock da coleção para retornar um FindIterable
        FindIterable<Document> mockIterable = mock(FindIterable.class);
        when(mockCollection.find()).thenReturn(mockIterable);

        // Configurando o comportamento do cursor mockado
        MongoCursor<Document> mockCursor = mock(MongoCursor.class);
        when(mockCursor.hasNext()).thenReturn(true, true, false);
        when(mockCursor.next()).thenReturn(doc1, doc2);
        
        // Configurando o comportamento do mockIterable para retornar o cursor
        when(mockIterable.iterator()).thenReturn(mockCursor);

        // Chama o método para listar produtos
        List<Produto> produtos = produtoController.listarProdutos();

        // Verifica se a lista retornada contém os produtos esperados
        assertEquals(2, produtos.size());
        assertEquals("Produto 1", produtos.get(0).getNome());
        assertEquals("Produto 2", produtos.get(1).getNome());
    }
}
