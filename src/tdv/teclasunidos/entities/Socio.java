package tdv.teclasunidos.entities;

public class Socio {
    private String nombre;
    private int edad;
    private String direccion;
    private String dni;

    public Socio(String nombre, int edad, String direccion, String dni) throws NombreMuyLargoException, EdadInvalidaException {
    	if (nombre.length()>51) 
    		throw new NombreMuyLargoException();
        this.nombre = nombre;
        if (edad <0 ||edad >100) 
        	throw new EdadInvalidaException();
        this.edad = edad;
        this.direccion = direccion;
        
        this.dni = dni;
    }

	public int getEdad() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getDni() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

    // Getters y setters
}

