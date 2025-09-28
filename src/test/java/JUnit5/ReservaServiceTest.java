package JUnit5;

import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ReservaService;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaServiceTest {
    private ReservaService servicio;
    private Recurso recurso;
    private Socio socio1;
    private Socio socio2;

    @BeforeEach
    void setUp() throws EdadInvalidaException, NombreMuyLargoException, DniInvalidoException {
        servicio = new ReservaService();
        recurso = new Recurso("Sala1", "Ubicacion1");
        socio1 = new Socio("Ana", 30, "Direccion1", "1234567");
        socio2 = new Socio("Juan", 25, "Direccion2", "7654321");
    }

    // Se puede reservar un recurso sólo si no está ocupado en ese momento
    @Test
    void testReservarSinConflicto() {
        LocalDateTime inicio = LocalDateTime.of(2025, 9, 28, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2025, 9, 28, 11, 0);

        boolean exito = servicio.reservar(recurso, socio1, inicio, fin);

        assertTrue(exito); // Se puede reservar
        List<Reserva> reservas = servicio.listarReservas("Sala1");
        assertEquals(1, reservas.size());
    }

    @Test
    void testReservarConConflicto() {
        LocalDateTime inicio1 = LocalDateTime.of(2025, 9, 28, 10, 0);
        LocalDateTime fin1 = LocalDateTime.of(2025, 9, 28, 11, 0);

        LocalDateTime inicio2 = LocalDateTime.of(2025, 9, 28, 10, 30);
        LocalDateTime fin2 = LocalDateTime.of(2025, 9, 28, 11, 30);

        servicio.reservar(recurso, socio1, inicio1, fin1);
        boolean exito = servicio.reservar(recurso, socio2, inicio2, fin2);

        assertFalse(exito); // No se puede reservar por conflicto
        List<Reserva> reservas = servicio.listarReservas("Sala1");
        assertEquals(1, reservas.size()); // Solo la primera reserva
    }

    // Eliminar una reserva que realizó otro usuario no tiene efecto.
    @Test
    void testCancelarReservaDeOtroUsuario() {
        LocalDateTime inicio = LocalDateTime.of(2025, 9, 28, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2025, 9, 28, 11, 0);

        // socio1 hace la reserva
        servicio.reservar(recurso, socio1, inicio, fin);

        // socio2 intenta cancelar la reserva de socio1
        boolean cancelado = servicio.cancelarReserva(recurso, socio2, inicio, fin);

        assertFalse(cancelado); // No puede cancelar la reserva de otro usuario
        List<Reserva> reservas = servicio.listarReservas("Sala1");
        assertEquals(1, reservas.size()); // La reserva sigue existiendo
        assertEquals(socio1, reservas.get(0).getSocio()); // Sigue siendo de socio1
    }
}
