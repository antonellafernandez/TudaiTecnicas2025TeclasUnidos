package JUnit5;

import entities.Actividad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActividadTest {
    // El el método toString de Actividad retorna un string <nombre>-<lugar>
    @Test
    void testToString() {
        Actividad a = new Actividad("Nombre1", "Encargado1", "Horario1", 10, "Lugar1", 10);
        assertEquals("Nombre1-Lugar1", a .toString());
    }
}
