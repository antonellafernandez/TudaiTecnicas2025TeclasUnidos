package services;

import entities.Actividad;
import entities.Socio;

public class InscripcionService {
    public boolean inscribir(Socio socio, Actividad actividad) {
        return actividad.agregarInscripcion(socio);
    }

    public boolean eliminarInscripcion(Socio socio, Actividad actividad) {
        return actividad.eliminarInscripcion(socio);
    }
}
