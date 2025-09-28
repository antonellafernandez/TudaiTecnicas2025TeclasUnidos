package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Recurso;

public class RecursoRepository {
	// Atributo
    private Map<String, Recurso> recursos = new HashMap<>();

	// Create
	public void agregar(Recurso recurso) {
		recursos.put(recurso.getNombre(), recurso);
	}

	// Read
	public List<Recurso> listar() {
		return new ArrayList<>(recursos.values());
	}

	// Update
	public void actualizar(Recurso recurso) {
		recursos.put(recurso.getNombre(), recurso);
	}

	// Delete
	public void eliminar(String nombre) {
		recursos.remove(nombre);
	}

	// Buscar por nombre
	public Recurso buscarPorNombre(String nombre) {
		return recursos.get(nombre);
	}
}
