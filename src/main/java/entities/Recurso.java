package entities;

public class Recurso {
    private String nombre;
    private String ubicacion;

    public Recurso(String nombre, String ubicacion) {
    	if (!nombre.equals("Oficina")) {
			this.nombre = nombre;
			this.ubicacion = ubicacion;
    	} // Si no, lo crea vacío
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
}
