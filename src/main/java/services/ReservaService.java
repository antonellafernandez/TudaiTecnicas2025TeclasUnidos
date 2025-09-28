package services;

import java.time.LocalDateTime;
import java.util.*;

import entities.Recurso;
import entities.Reserva;
import entities.Socio;

public class ReservaService {
    private final Map<String, List<Reserva>> reservasPorRecurso = new HashMap<>();

    public boolean reservar(Recurso recurso, Socio socio, LocalDateTime inicio, LocalDateTime fin) {
        List<Reserva> reservas = reservasPorRecurso.computeIfAbsent(
                (String) recurso.getNombre(),   // Clave del map, el nombre del recurso
                k -> new ArrayList<>()          // Si no hay lista aún, crea una nueva lista vacía
        );

        for (Reserva r : reservas) {
            if (r.seSuperpone(inicio, fin)) {
                return false; // Conflicto de horario
            }
        }

        reservas.add(new Reserva(recurso, socio, inicio, fin));
        return true;
    }

    public boolean cancelarReserva(Recurso recurso, Socio socio, LocalDateTime inicio, LocalDateTime fin) {
        List<Reserva> reservas = reservasPorRecurso.get(recurso.getNombre());
        if (reservas == null) return false;

        return reservas.removeIf(r -> r.getSocio().equals(socio) &&
                                      r.getInicio().equals(inicio) &&
                                      r.getFin().equals(fin));
    }

    public List<Reserva> listarReservas(String nombreRecurso) {
        return reservasPorRecurso.getOrDefault(nombreRecurso, new ArrayList<>());
    }
}
