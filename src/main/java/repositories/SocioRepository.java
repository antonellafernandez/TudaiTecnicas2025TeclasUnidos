package repositories;

import java.util.*;

import entities.Socio;

public class SocioRepository {
    // Atributo
    private Map<String, Socio> socios = new HashMap<>();

    // Create
    public void agregar(Socio socio) {
        socios.put(socio.getDni(), socio);
    }

    // Read
    public List<Socio> listar() {
        return new ArrayList<>(socios.values());
    }

    // Update
    public void actualizar(Socio socio) {
        socios.put(socio.getDni(), socio);
    }

    // Delete
    public void eliminar(String dni) {
        socios.remove(dni);
    }

    // Buscar por DNI
    public Socio buscarPorDni(String dni) {
        return socios.get(dni);
    }
}
