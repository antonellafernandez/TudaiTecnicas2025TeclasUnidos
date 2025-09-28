package JUnit5;

import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.InscripcionService;

import static org.junit.jupiter.api.Assertions.*;

public class InscripcionServiceTest {

    private InscripcionService servicio;

    private Actividad boxeo;
    private Socio menor;
    private Socio mayor;

    private Actividad yoga;
    private Socio socio1;
    private Socio socio2;
    private Socio socio3;

    @BeforeEach
    void setUp() throws EdadInvalidaException, NombreMuyLargoException, DniInvalidoException {
        servicio = new InscripcionService();

        boxeo = new Actividad("Boxeo", "Juan", "18:00", 16, "Gimnasio", 2);

        menor = new Socio("Pedro", 15, "Calle Falsa 123", "1111111");
        mayor = new Socio("Ana", 18, "Calle Verdadera 456", "2222222");

        yoga = new Actividad("Yoga", "Maria", "19:00", 12, "Sala1", 2); // cupo máximo = 2

        socio1 = new Socio("Ana", 20, "Calle 1", "1234567");
        socio2 = new Socio("Juan", 25, "Calle 2", "2345678");
        socio3 = new Socio("Pedro", 30, "Calle 3", "3456789");
    }

    // Escenario específico: No se pueden inscribir menores de 16 años a Boxeo
    @Test
    void testNoSePuedeInscribirMenorBoxeo() {
        boolean exito = servicio.inscribir(menor, boxeo);
        assertFalse(exito, "No debería poder inscribirse un menor de 16 años en Boxeo");
    }

    @Test
    void testSePuedeInscribirMayorBoxeo() {
        boolean exito = servicio.inscribir(mayor, boxeo);
        assertTrue(exito, "Debería poder inscribirse un mayor de 16 años en Boxeo");
    }

    // No se pueden inscribir socios a una actividad si se ha superado el cupo
    @Test
    void testNoSePuedeSuperarCupo() {
        // Inscribimos dos socios (cupo = 2)
        assertTrue(servicio.inscribir(socio1, yoga));
        assertTrue(servicio.inscribir(socio2, yoga));

        // Intentamos inscribir un tercer socio → debería fallar
        boolean exito = servicio.inscribir(socio3, yoga);
        assertFalse(exito, "No se debería poder inscribir más socios si se ha superado el cupo");
    }
}
