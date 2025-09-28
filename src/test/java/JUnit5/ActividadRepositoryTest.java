package JUnit5;

import entities.Actividad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.ActividadRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ActividadRepositoryTest {
    private ActividadRepository repo;

    @BeforeEach
    void setup() {
        repo = new ActividadRepository();
    }

    @AfterEach
    void tearDown() {
        repo = null;
    }

    // Create
    @Test
    void testAgregar() {
        Actividad a = new Actividad("Nombre1", "Encargado1", "Horario1", 10, "Lugar1", 10);
        repo.agregar(a);

        Actividad encontrado = repo.buscarPorNombre("Nombre1");
        assertNotNull(encontrado);
        assertEquals("Nombre1", encontrado.getNombre());
    }

    // Read
    @Test
    void testListar() {
        repo.agregar(new Actividad("Nombre1", "Encargado1", "Horario1", 10, "Lugar1", 10));
        repo.agregar(new Actividad("Nombre2", "Encargado2", "Horario2", 20, "Lugar2", 20));

        List<Actividad> lista = repo.listar();
        assertEquals(2, lista.size());
    }

    // Update
    @Test
    void testActualizar() {
        Actividad a = new Actividad("Nombre1", "Encargado1", "Horario1", 10, "Lugar1", 10);
        repo.agregar(a);

        a.setEncargado("Encargado2");
        repo.actualizar(a);

        assertEquals("Encargado2", repo.buscarPorNombre("Nombre1").getEncargado());
    }

    // Delete
    @Test
    void testEliminar() {
        Actividad a = new Actividad("Nombre1", "Encargado1", "Horario1", 10, "Lugar1", 10);
        repo.agregar(a);

        repo.eliminar("Nombre1");
        assertNull(repo.buscarPorNombre("Nombre1"));
    }
}
