package JUnit5;

import entities.Recurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class RecursoTest {
    // El recurso “Oficina” no se puede crear -> Al intentarlo, el objeto será nulo
    @Test
    void testCrearOficina() {
        Recurso r = new Recurso("Oficina", "Ubicacio1");
        assertNull(r.getNombre());
    }
}
