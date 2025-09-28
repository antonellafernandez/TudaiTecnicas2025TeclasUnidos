package JUnit5;

import entities.Recurso;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.RecursoRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecursoRepositoryTest {
    private RecursoRepository repo;

    @BeforeEach
    void setup() {
        repo = new RecursoRepository();
    }

    @AfterEach
    void tearDown() {
        repo = null;
    }

    // Create
    @Test
    void testAgregar() {
        Recurso r = new Recurso("Recurso1", "Ubicación1");
        repo.agregar(r);

        Recurso encontrado = repo.buscarPorNombre("Recurso1");
        assertNotNull(encontrado);
        assertEquals("Recurso1", encontrado.getNombre());
    }

    // Read
    @Test
    void testListar() {
        repo.agregar(new Recurso("Recurso1", "Ubicacio1"));
        repo.agregar(new Recurso("Recurso2", "Ubicacio2"));

        List<Recurso> lista = repo.listar();
        assertEquals(2, lista.size());
    }

    // Update
    @Test
    void testActualizar() {
        Recurso r = new Recurso("Recurso1", "Ubicacio1");
        repo.agregar(r);

        r.setUbicacion("Ubicación2");
        repo.actualizar(r);

        assertEquals("Ubicación2", repo.buscarPorNombre("Recurso1").getUbicacion());
    }

    // Delete
    @Test
    void testEliminar() {
        Recurso r = new Recurso("Recurso1", "Ubicacio1");
        repo.agregar(r);

        repo.eliminar("Recurso1");
        assertNull(repo.buscarPorNombre("Recurso1"));
    }
}
