package entities;

import java.util.ArrayList;
import java.util.List;

public class Actividad {
    private String nombre;
    private String encargado;
    private String horario;
    private int edadMinima;
    private String lugar;
    private int cupo;
    private List<Socio> inscriptos;

    public Actividad(String nombre, String encargado, String horario, int edadMinima, String lugar, int cupo) {
        this.nombre = nombre;
        this.encargado = encargado;
        this.horario = horario;
        this.edadMinima = edadMinima;
        this.lugar = lugar;
        this.cupo = cupo;
        this.inscriptos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public boolean agregarInscripcion(Socio socio) {
        if (socio == null
                || (socio.getEdad() <= edadMinima || inscriptos.size() >= cupo)
                || (nombre.equals("Boxeo") && socio.getEdad() < 16)) {
            return false;
        }

        inscriptos.add(socio);
        return true;
    }

    public boolean eliminarInscripcion(Socio socio) {
        if (socio == null || !inscriptos.contains(socio)) { // Redefinir equals en Socio
            return false;
        }

        inscriptos.remove(socio);
        return true;
    }

	public String toString() {
		return nombre+"-"+lugar;
	}
}
