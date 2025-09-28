package repositories;

import java.util.*;

import entities.Actividad;

public class ActividadRepository {
    // Atributo
    private Map<String, Actividad> actividades = new HashMap<>();

    // Create
    public void agregar(Actividad actividad) {
        actividades.put(actividad.getNombre(), actividad);
    }

    // Read
    public List<Actividad> listar() {
        return new ArrayList<>(actividades.values());
    }

    // Update
    public void actualizar(Actividad actividad) {
        actividades.put(actividad.getNombre(), actividad);
    }

    // Delete
    public void eliminar(String nombre) {
        actividades.remove(nombre);
    }

    // Buscar por nombre
    public Actividad buscarPorNombre(String nombre) {
        return actividades.get(nombre);
    }

    // Obtener cantidad de actividades
    public int cantidad() {
        return actividades.size();
    }
}
