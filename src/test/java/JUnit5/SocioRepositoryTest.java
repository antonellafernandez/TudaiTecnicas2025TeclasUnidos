package JUnit5;

import entities.DniInvalidoException;
import entities.EdadInvalidaException;
import entities.NombreMuyLargoException;
import entities.Socio;
import repositories.SocioRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SocioRepositoryTest {
    private SocioRepository repo;

    @BeforeEach
    void setUp() { // Planificación
        repo = new SocioRepository();
    }

    @AfterEach
    void tearDown() { // Verificación o cierre
        // Limpiar el repo para asegurar que cada test empiece limpio
        repo = null;
    }

    // Create
    @Test
    void testAgregar() throws EdadInvalidaException, NombreMuyLargoException, DniInvalidoException {
        Socio s = new Socio("Daniela", 29, "DirecciónDaniela", "123456");
        repo.agregar(s);

        Socio encontrado = repo.buscarPorDni("123456");
        assertNotNull(encontrado);
        assertEquals("Daniela", encontrado.getNombre());
    }

    // Read
    @Test
    void testListar() throws EdadInvalidaException, NombreMuyLargoException, DniInvalidoException {
        repo.agregar(new Socio("Nombre1", 10, "Dirección1", "234567"));
        repo.agregar(new Socio("Nombre2", 20, "Dirección2", "345678"));

        List<Socio> lista = repo.listar();
        assertEquals(2, lista.size());
    }

    // Update
    @Test
    void testActualizar() throws EdadInvalidaException, NombreMuyLargoException, DniInvalidoException {
        Socio s = new Socio("Juan", 30, "DirecciónJuan", "456789");
        repo.agregar(s);

        s.setNombre("Juan Pérez");
        repo.actualizar(s);

        assertEquals("Juan Pérez", repo.buscarPorDni("456789").getNombre());
    }

    // Delete
    @Test
    void testEliminar() throws EdadInvalidaException, NombreMuyLargoException, DniInvalidoException {
        Socio s = new Socio("Ana", 40, "DirecciónAna", "567890");
        repo.agregar(s);

        repo.eliminar("567890");
        assertNull(repo.buscarPorDni("567890"));
    }

    // El nombre de un socio no puede contener más de 50 caracteres. Si eso sucede, se obtiene la
    // excepción NombreMuyLargoException
    @Test
    void testAgregarConExcepcionNombre() throws EdadInvalidaException, NombreMuyLargoException {
        assertThrowsExactly(
                NombreMuyLargoException.class,
                () -> repo.agregar(new Socio(
                        "Danieladanieladanieladanieladanieladanieladanieladaniela",
                        29,
                        "DirecciónDaniela",
                        "123456"
                ))
        );
    }

    // El DNI contiene 6 o 7 números y sin puntos
    @Test
    void testDniValido() throws EdadInvalidaException, NombreMuyLargoException, DniInvalidoException {
        // DNI válido: 6 o 7 dígitos
        Socio s1 = new Socio("Ana", 25, "Calle 1", "123456");
        Socio s2 = new Socio("Juan", 30, "Calle 2", "1234567");
        assertEquals("123456", s1.getDni());
        assertEquals("1234567", s2.getDni());

        // DNI inválido: menos de 6 dígitos
        assertThrows(DniInvalidoException.class, () -> new Socio("Pedro", 20, "Calle 3", "12345"));

        // DNI inválido: más de 7 dígitos
        assertThrows(DniInvalidoException.class, () -> new Socio("Pedro", 20, "Calle 3", "12345678"));

        // DNI inválido: contiene puntos o letras
        assertThrows(DniInvalidoException.class, () -> new Socio("Pedro", 20, "Calle 3", "12.3456"));
        assertThrows(DniInvalidoException.class, () -> new Socio("Pedro", 20, "Calle 3", "12A456"));
    }
}
