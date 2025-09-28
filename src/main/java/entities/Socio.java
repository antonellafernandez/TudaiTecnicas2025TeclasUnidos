package entities;

public class Socio {
    private String nombre;
    private int edad;
    private String direccion;
    private String dni;

    public Socio(String nombre, int edad, String direccion, String dni) throws NombreMuyLargoException, EdadInvalidaException, DniInvalidoException {
    	if (nombre.length() > 51)  {
			throw new NombreMuyLargoException();
		} else {
			this.nombre = nombre;
		}

        if (edad < 0 || edad > 100) {
			throw new EdadInvalidaException();
		} else {
			this.edad = edad;
		}

		if (!dni.matches("\\d{6,7}")) {
			throw new DniInvalidoException();
		} else {
			this.dni = dni;
		}

        this.direccion = direccion;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public boolean equals(Object o) {
		try {
			Socio otro = (Socio) o;
			return this.getNombre().equals(otro.getNombre())
					&& this.getEdad() == otro.getEdad()
					&& this.getDireccion().equals(otro.getDireccion())
					&& this.getDni().equals(otro.getDni());
		} catch (Exception e) {
			return false;
		}
	}
}
